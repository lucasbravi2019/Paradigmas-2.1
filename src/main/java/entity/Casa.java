package entity;

public class Casa extends Edificio {

    private Boolean plantaAlta;

    private int superficie;

    public Casa(float avaluoxmt, Boolean plantaAlta, int superficie) {
        super(avaluoxmt);
        this.plantaAlta = plantaAlta;
        this.superficie = superficie;
    }

    public Boolean getPlantaAlta() {
        return plantaAlta;
    }

    public void setPlantaAlta(Boolean plantaAlta) {
        this.plantaAlta = plantaAlta;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    @Override
    public float valuar() {
        return getAvaluoxmt() * superficie;
    }

    @Override
    public String toString() {
        return super.toString() + ", Casa{" +
                "plantaAlta=" + plantaAlta +
                ", superficie=" + superficie +
                '}';
    }
}
