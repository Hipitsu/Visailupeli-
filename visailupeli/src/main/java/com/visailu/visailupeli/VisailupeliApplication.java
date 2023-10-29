package com.visailu.visailupeli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VisailupeliApplication {

	private List<Kysymys> kysymykset = new ArrayList<>();
    private PelinTila pelinTila = new PelinTila();

	public static void main(String[] args) {
		SpringApplication.run(VisailupeliApplication.class, args);
	}

    @GetMapping("/")
    public String getInfo() {
        return "Tervetuloa visailupalveluun. Käytä /api/pelin_tila saadaksesi pelin tilan.";
    }

	@GetMapping("/api/pelin_tila")
    public PelinTila getPelinTila() {
        return pelinTila;
    }

	   @GetMapping("/api/kysymys/{kysymysId}")
    public Kysymys getKysymys(@PathVariable int kysymysId) {
        if (kysymysId >= 0 && kysymysId < kysymykset.size()) {
            return kysymykset.get(kysymysId);
        } else {
            return null;
        }
    }

	    @PostMapping("/api/vastaa")
    public Vastaus tarkistaVastaus(@RequestBody PelaajanVastaus pelaajanVastaus) {
        Kysymys nykyinenKysymys = kysymykset.get(pelinTila.getNykyinenKysymysIndeksi());
        if (nykyinenKysymys.getOikeaVastaus().equalsIgnoreCase(pelaajanVastaus.getVastaus())) {
            pelinTila.lisaaPisteita(1);
            return new Vastaus("Oikein!");
        } else {
            return new Vastaus("Väärin. Oikea vastaus oli: " + nykyinenKysymys.getOikeaVastaus());
        }
    }



}
