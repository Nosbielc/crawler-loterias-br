package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;
import com.nosbielc.crawler.loterias.core.common.annotations.ColumnMerge;
import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.generic.GenericExtractParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Log4j2
@RequiredArgsConstructor
public class ProcessColumnMergeImpl implements ProcessColumnMerge {

    private final FormatStringToBigDecimalUseCase toBigDecimal;
    @Override
    public CrawlerSealed execute(GenericExtractParams params) throws PortalAPIException {

        try {
            Class<?> clazzForValidation = Class.forName(params.crawler().getClass().getName());
            Object clazzNew = clazzForValidation.newInstance();

            Field[] fields = clazzForValidation.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ColumnMerge.class)) {
                    ColumnMerge columnMerge = field.getAnnotation(ColumnMerge.class);

                    var valueSource = params.mapColumns().get(columnMerge.index()).trim();

                    var value = switch (columnMerge.type()) {
                        case LONG -> (long) (Double.valueOf(valueSource)).doubleValue();
                        case INTEGER -> (int) (Double.valueOf(valueSource)).doubleValue();
                        case LOCALDATE -> LocalDate.parse(valueSource, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        case LOCADATETIME -> LocalDate.parse(valueSource, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS"));
                        case BIGDECIMAL -> toBigDecimal.execute(valueSource);
                        case BOOLEAN -> valueSource.trim().equalsIgnoreCase("Sim") ? Boolean.TRUE : Boolean.FALSE;
                        default -> valueSource;
                        };

                    if (value instanceof String str) {
                        if (str.length() > 255 && columnMerge.outputSize() > 0) {
                            value = str.substring(0, columnMerge.outputSize());
                        }
                        if (columnMerge.removeInvalidCharacters()) {
                            value = ((String) value).replaceAll("/n|/|;", "");
                        }
                    }


                    var nameMethodSetter = "set" + field.getName().substring(0, 1).toUpperCase() +
                            field.getName().substring(1);
                    Method methodSetter = clazzForValidation.getDeclaredMethod(nameMethodSetter, field.getType());

                    methodSetter.invoke(clazzNew, value);

                }
            }

            return (CrawlerSealed) clazzNew;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
