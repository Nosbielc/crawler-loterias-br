package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;
import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.generic.GenericExtractParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class ExtractLinesExcelUseCaseImpl implements ExtractLinesExcelUseCase {

    private final ExtractCellsUseCase extractCellsUseCase;
    private final ProcessColumnMerge processColumnMerge;

    @Override
    public List<CrawlerSealed> execute(GenericExtractParams params) throws PortalAPIException {

        List<CrawlerSealed> crawlerSealed = new ArrayList<>();

        try(Workbook workbook = new XSSFWorkbook(params.is())){

            Sheet sheet = workbook.getSheet(params.sheet());
            Iterator<Row> rows = sheet.iterator();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                var hasCellsAndValues = extractCellsUseCase.execute(currentRow.iterator());

                var paramnsNew = new GenericExtractParams(params.is(), params.sheet(), params.crawler(), hasCellsAndValues);

                crawlerSealed.add(processColumnMerge.execute(paramnsNew));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }

        return crawlerSealed;
    }
}
