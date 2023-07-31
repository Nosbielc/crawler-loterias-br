package com.nosbielc.crawler.loterias.core.generic;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;

import java.io.InputStream;
import java.util.HashMap;

public record GenericExtractParams(InputStream is, String sheet, CrawlerSealed crawler, HashMap<Integer, String> mapColumns) {

}
