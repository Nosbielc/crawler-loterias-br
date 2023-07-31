package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;

@Component
@Log4j2
@RequiredArgsConstructor
public class ExtractCellsUseCaseImpl implements ExtractCellsUseCase {
    @Override
    public HashMap<Integer, String> execute(Iterator<Cell> cellIterator) throws PortalAPIException {

        HashMap<Integer, String> maps = new HashMap<>();
        int cellIdx = 0;
        while (cellIterator.hasNext()) {
            Cell currentCell = cellIterator.next();

            var value = switch (currentCell.getCellType()){
                case _NONE, STRING -> currentCell.getStringCellValue().trim();
                case NUMERIC -> currentCell.getNumericCellValue();
                case FORMULA, BLANK, ERROR -> "";
                case BOOLEAN -> currentCell.getBooleanCellValue();
            };
            maps.put(cellIdx, String.valueOf(value));
            cellIdx++;
        }

        return maps;
    }
}
