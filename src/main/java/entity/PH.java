package entity;

import java.util.ArrayList;
import java.util.List;

public class PH extends Edificio {

    private byte cantidadPisos;

    private List<Departamento> unidad;

    public PH(float avaluoxmt, byte cantidadPisos, List<Departamento> unidad) {
        super(avaluoxmt);
        this.cantidadPisos = cantidadPisos;
        this.unidad = unidad;
    }

    public byte getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(byte cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public List<Departamento> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<Departamento> unidad) {
        this.unidad = unidad;
    }

    @Override
    public float valuar() {
        return getAvaluoxmt() * cantidadPisos;
    }

    @Override
    public String toString() {
        return super.toString() + ", PH{" +
                "cantidadPisos=" + cantidadPisos +
                ", unidad=" + unidad +
                '}';
    }
}
