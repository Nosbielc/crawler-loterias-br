package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.generic.usecase.FormatStringToBigDecimalUseCase;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class OpenResultsMegaSenaUseCaseImpl implements OpenResultsMegaSenaUseCase {

    private final FormatStringToBigDecimalUseCase toBigDecimal;
    @Override
    public List<MegaSena> execute(Document document) throws PortalAPIException {
        List<MegaSena> megaSenas = new ArrayList<>();
        Element table = document.select("table").first();

        Elements lines = table.select("tr");

        for (Element line : lines) {
            Elements cells = line.select("td");

            if (cells.size() == 21) {
                try {
                    var megaIndex = MegaSena.builder()
                            .contest(Long.parseLong(cells.get(0).text().trim()))
                            .drawDate(LocalDate.parse(cells.get(1).text().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                            .drawNumber1(Integer.parseInt(cells.get(2).text().trim()))
                            .drawNumber2(Integer.parseInt(cells.get(3).text().trim()))
                            .drawNumber3(Integer.parseInt(cells.get(4).text().trim()))
                            .drawNumber4(Integer.parseInt(cells.get(5).text().trim()))
                            .drawNumber5(Integer.parseInt(cells.get(6).text().trim()))
                            .drawNumber6(Integer.parseInt(cells.get(7).text().trim()))
                            .winnersTier1(Integer.parseInt(cells.get(8).text().trim()))
                            .winnersTier2(Integer.parseInt(cells.get(9).text().trim()))
                            .winnersTier3(Integer.parseInt(cells.get(10).text().trim()))
                            .payoutTier1(toBigDecimal.execute(cells.get(11).text().trim()))
                            .payoutTier2(toBigDecimal.execute(cells.get(12).text().trim()))
                            .payoutTier3(toBigDecimal.execute(cells.get(13).text().trim()))
                            .city(cells.get(14).text().trim())
                            .revenue(toBigDecimal.execute(cells.get(15).text().trim()))
                            .nextContestEstimate(toBigDecimal.execute(cells.get(16).text().trim()))
                            .accumulatedValueNextContest(toBigDecimal.execute(cells.get(17).text().trim()))
                            .accumulated(cells.get(18).text().trim().equalsIgnoreCase("Sim") ? Boolean.TRUE : Boolean.FALSE)
                            .specialDraw(cells.get(19).text().trim().equalsIgnoreCase("Sim") ? Boolean.TRUE : Boolean.FALSE)
                            .note(cells.get(20).text().trim())
                            .build();
                    log.info(megaIndex);
                    megaSenas.add(megaIndex);
                } catch (Exception e) {
                    log.error("Error get Line => " + cells);
                }
            }
        }

        return megaSenas;
    }
}