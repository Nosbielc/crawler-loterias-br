package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.megasena.exception.SaveResultMegaSenaException;

public interface SaveResultMegaSenaUseCase {

    void execute(MegaSena megaSena) throws SaveResultMegaSenaException;

}
