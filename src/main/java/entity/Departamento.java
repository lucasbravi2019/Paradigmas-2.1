package entity;

public class Departamento {

    private byte piso;
    private char departamento;
    private int superficie;

    public Departamento(byte piso, char departamento, int superficie) {
        this.piso = piso;
        this.departamento = departamento;
        this.superficie = superficie;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public char getDepartamento() {
        return departamento;
    }

    public void setDepartamento(char departamento) {
        this.departamento = departamento;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "piso=" + piso +
                ", departamento=" + departamento +
                ", superficie=" + superficie +
                '}';
    }
}
