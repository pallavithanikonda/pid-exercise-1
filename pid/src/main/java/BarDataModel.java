import java.util.List;

public class BarDataModel {

    private String serialNumber;
    private double fatt;
    private double energy;
    private double kolhydrat;
    private double protein;
    private double fiber;
    private List<ReviewDataModel> reviews;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getFatt() {
        return fatt;
    }

    public void setFatt(double fatt) {
        this.fatt = fatt;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getKolhydrat() {
        return kolhydrat;
    }

    public void setKolhydrat(double kolhydrat) {
        this.kolhydrat = kolhydrat;
    }

    public double getProtein() {
        return protein;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public List<ReviewDataModel> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDataModel> reviews) {
        this.reviews = reviews;
    }

}

