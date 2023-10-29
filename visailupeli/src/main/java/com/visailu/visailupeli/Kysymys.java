package com.visailu.visailupeli;

public class Kysymys {

    private String kysymysteksti;
    private String oikeaVastaus;

    public Kysymys(String kysymysteksti, String oikeaVastaus) {
        this.kysymysteksti = kysymysteksti;
        this.oikeaVastaus = oikeaVastaus;
    }

    public String getKysymysteksti() {
        return kysymysteksti;
    }

    public String getOikeaVastaus() {
        return oikeaVastaus;
    }
}
