package entity;

import java.io.Serializable;

public class Escritura implements Serializable {

    public static final Long serialVersionUID = 1L;
    private Integer numero;
    private int superficie;
    private String domicilio;

    public Escritura() {
    }

    public Escritura(Integer numero, int superficie, String domicilio) {
        this.numero = numero;
        this.superficie = superficie;
        this.domicilio = domicilio;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public static EscrituraBuilder builder() {
        return new EscrituraBuilder(new Escritura());
    }

    @Override
    public String toString() {
        return "Escritura{" +
                "numero=" + numero +
                ", superficie=" + superficie +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }

    public static class EscrituraBuilder {
        private Escritura escritura;

        public EscrituraBuilder(Escritura escritura) {
            this.escritura = escritura;
        }

        public EscrituraBuilder domicilio(String domicilio) {
            this.escritura.setDomicilio(domicilio);
            return this;
        }

        public EscrituraBuilder numero(Integer numero) {
            this.escritura.setNumero(numero);
            return this;
        }

        public EscrituraBuilder superficie(int superficie) {
            this.escritura.setSuperficie(superficie);
            return this;
        }

        public Escritura build() {
            return this.escritura;
        }
    }
}
