package com.nosbielc.crawler.loterias.core.megasena.constants;

public final class MegaSenaConstants {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    static String SHEET = "MEGA SENA";

    private MegaSenaConstants() {
        throw new IllegalStateException("Utility Class => MegaSenaConstants");
    }
}
