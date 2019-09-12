package ua.mycompany.contractEH;

public class Phone {
    private String brand;
    private double price;
    private boolean doubleSim;

    public Phone() {
        brand = "brand";
        price = 0;
        doubleSim = false;
    }

    public Phone(String brand, double price, boolean doubleSim) {
        this.brand = brand;
        this.price = price;
        this.doubleSim = doubleSim;
    }

    public boolean equals(Phone phone) {
        if (this == phone) return true;
        if (phone == null || getClass() != phone.getClass()) return false;
        return Double.compare(phone.price, price) == 0 &&
                doubleSim == phone.doubleSim &&
                brand.equals(phone.brand);
    }

    @Override
    public int hashCode() {
        return doubleSim ? brand.length() * (int) price + 213 : 20 * brand.length() * (int) price - 14;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDoubleSim() {
        return doubleSim;
    }

    public void setDoubleSim(boolean doubleSim) {
        this.doubleSim = doubleSim;
    }
}
