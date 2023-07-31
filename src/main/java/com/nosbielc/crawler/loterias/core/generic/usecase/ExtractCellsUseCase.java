package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;
import java.util.Iterator;

public interface ExtractCellsUseCase extends UseCaseBase<HashMap<Integer, String>, Iterator<Cell>> {
}
