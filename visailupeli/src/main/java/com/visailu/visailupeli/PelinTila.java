package com.visailu.visailupeli;

public class PelinTila {
    
        private int pisteet = 0;
        private int nykyinenKysymysIndeksi = 0;
    
        public int getPisteet() {
            return pisteet;
        }
    
        public void lisaaPisteita(int pisteet) {
            this.pisteet += pisteet;
        }
    
        public int getNykyinenKysymysIndeksi() {
            return nykyinenKysymysIndeksi;
        }
    
        public void siirrySeuraavaanKysymykseen() {
            nykyinenKysymysIndeksi++;
        }
    }

