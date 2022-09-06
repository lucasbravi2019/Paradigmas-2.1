package entity;

public abstract class Edificio {
    private float avaluoxmt;

    public Edificio() {
    }

    public Edificio(float avaluoxmt) {
        this.avaluoxmt = avaluoxmt;
    }

    public float getAvaluoxmt() {
        return avaluoxmt;
    }

    public void setAvaluoxmt(float avaluoxmt) {
        this.avaluoxmt = avaluoxmt;
    }

    //No se especifica que debe hacer este metodo
    public abstract float valuar();

    //No se especifica que debe hacer este metodo
    public Edificio demoler() {
        return null;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "avaluoxmt=" + avaluoxmt +
                '}';
    }

}
