package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.megasena.exception.SaveResultMegaSenaException;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SaveResultMegaSenaUseCaseImpl implements SaveResultMegaSenaUseCase {

    @Value("${lotericas.url.megasena}")
    private String urlMegaSena;

    @Override
    public void execute(MegaSena megaSena) throws SaveResultMegaSenaException {
        try {
            Document doc = Jsoup.connect(urlMegaSena).get();




        } catch (IOException e) {
            throw new SaveResultMegaSenaException("Error Fatal in process crawler", e);
        }
    }

}
