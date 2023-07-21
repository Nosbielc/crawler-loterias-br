package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Log4j2
@Component
@RequiredArgsConstructor
public class FormatStringToBigDecimalUseCaseImpl implements FormatStringToBigDecimalUseCase {
    @Override
    public BigDecimal execute(String valor) throws PortalAPIException {
        valor = valor.replace("R$", "").replace(".", "").replace(",", ".");

        try {
            NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
            return new BigDecimal(format.parse(valor).toString());
        } catch (Exception e) {
            log.error("Error Format String to BigDecimal");
        }

        return BigDecimal.ZERO;
    }
}
