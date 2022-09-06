package entity;

import exception.ErrorLote;

public class Lote {
    private Integer idPadron;
    private String domicilio;
    private float avaluoxmt;
    private int superficie;
    private Registro inscripto;
    private Edificio construccion;

    public Lote() {
    }

    public Lote(Integer idPadron, String domicilio, float avaluoxmt, int superficie, Registro inscripto) {
        this.idPadron = idPadron;
        this.domicilio = domicilio;
        this.avaluoxmt = avaluoxmt;
        this.superficie = superficie;
        this.inscripto = inscripto;
    }

    public Integer getIdPadron() {
        return idPadron;
    }

    public void setIdPadron(Integer idPadron) {
        this.idPadron = idPadron;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public float getAvaluoxmt() {
        return avaluoxmt;
    }

    public void setAvaluoxmt(float avaluoxmt) {
        this.avaluoxmt = avaluoxmt;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public Registro getInscripto() {
        return inscripto;
    }

    public void setInscripto(Registro inscripto) {
        this.inscripto = inscripto;
    }

    public Edificio getConstruccion() {
        return construccion;
    }

    public void setConstruccion(Edificio construccion) {
        this.construccion = construccion;
    }

    public static LoteBuilder builder() {
        return new LoteBuilder(new Lote());
    }

    public float valuar() {
        return avaluoxmt * superficie;
    }

    public Edificio construir(Edificio edificio) {
        if (this.construccion != null) {
            throw new ErrorLote("No se puede construir! Ya existe un edificio!");
        }

        this.construccion = edificio;
        return edificio;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "idPadron=" + idPadron +
                ", domicilio='" + domicilio + '\'' +
                ", avaluoxmt=" + avaluoxmt +
                ", superficie=" + superficie +
                ", construccion=" + construccion +
                '}';
    }

    public static class LoteBuilder {
        private Lote lote;

        public LoteBuilder(Lote lote) {
            this.lote = lote;
        }

        public LoteBuilder domicilio(String domicilio) {
            this.lote.setDomicilio(domicilio);
            return this;
        }

        public LoteBuilder avaluoxmt(float avaluo) {
            this.lote.setAvaluoxmt(avaluo);
            return this;
        }

        public LoteBuilder idPadron(Integer idPadron) {
            this.lote.setIdPadron(idPadron);
            return this;
        }

        public LoteBuilder superficie(int superficie) {
            this.lote.setSuperficie(superficie);
            return this;
        }

        public Lote build() {
            return this.lote;
        }


    }
}
