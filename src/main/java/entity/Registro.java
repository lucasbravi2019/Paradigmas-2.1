package entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    private float coefAvaluoEdificio;
    private String municipio;
    private float tasa;
    private List<Lote> inmuebles = new ArrayList<>();
    private List<Escritura> escrituras = new ArrayList<>();

    public Registro() {
    }

    public Registro(float coefAvaluoEdificio, String municipio, float tasa, List<Lote> inmuebles, List<Escritura> escrituras) {
        this.coefAvaluoEdificio = coefAvaluoEdificio;
        this.municipio = municipio;
        this.tasa = tasa;
        this.inmuebles = inmuebles;
        this.escrituras = escrituras;
    }

    public float getCoefAvaluoEdificio() {
        return coefAvaluoEdificio;
    }

    public void setCoefAvaluoEdificio(float coefAvaluoEdificio) {
        this.coefAvaluoEdificio = coefAvaluoEdificio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public List<Lote> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Lote> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public List<Escritura> getEscrituras() {
        return escrituras;
    }

    public void setEscrituras(List<Escritura> escrituras) {
        this.escrituras = escrituras;
    }

    public static RegistroBuilder builder() {
        return new RegistroBuilder(new Registro());
    }

    public void valuar(Lote lote) {
        System.out.printf("El lote a valuar es: %s%n", lote.getIdPadron());
        System.out.printf("El valor del lote es de: $ %.2f%n", lote.valuar());
    }

    public void guardar() {
        try {
            OutputStream outputStream = new FileOutputStream("registro_escrituras.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(escrituras);
            outputStream.close();
            objectOutputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void recuperar() {
        List<Escritura> escrituras;
        try {
            InputStream inputStream = new FileInputStream("registro_escrituras.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            escrituras = (List<Escritura>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        System.out.println(escrituras);
    }

    public void registrar(Lote lote) {
        this.addLote(lote);
        this.escrituras.add(Escritura.builder()
                .domicilio(lote.getDomicilio())
                .numero(this.getNumeroDeEscritura())
                .superficie(lote.getSuperficie())
                .build());
    }

    private Integer getNumeroDeEscritura() {
        if (this.escrituras.isEmpty()) {
            return 1;
        }
        return this.escrituras.get(this.escrituras.size() - 1).getNumero() + 1;
    }

    public void emitirBoletos() {
        inmuebles.forEach(System.out::println);
    }

    private void addLote(Lote lote) {
        this.inmuebles.add(lote);
        lote.setInscripto(this);
    }

    @Override
    public String toString() {
        return "Registro{" +
                "coefAvaluoEdificio=" + coefAvaluoEdificio +
                ", municipio='" + municipio + '\'' +
                ", tasa=" + tasa +
                ", inmuebles=" + inmuebles +
                ", escrituras=" + escrituras +
                '}';
    }

    public static class RegistroBuilder {
        private Registro registro;

        public RegistroBuilder(Registro registro) {
            this.registro = registro;
        }

        public RegistroBuilder coefAvaluoEdificio(float coefAvaluo) {
            this.registro.setCoefAvaluoEdificio(coefAvaluo);
            return this;
        }

        public RegistroBuilder municipio(String municipio) {
            this.registro.setMunicipio(municipio);
            return this;
        }

        public RegistroBuilder tasa(float tasa) {
            this.registro.setTasa(tasa);
            return this;
        }

        public Registro build() {
            return this.registro;
        }

    }
}
