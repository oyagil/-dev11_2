package org.example;

// Araba sınıfı
class Araba {
    private String marka;
    private String model;
    private String renk;
    private boolean otomatikVites;
    private boolean sunroof;

    public Araba(String marka, String model, String renk, boolean otomatikVites, boolean sunroof) {
        this.marka = marka;
        this.model = model;
        this.renk = renk;
        this.otomatikVites = otomatikVites;
        this.sunroof = sunroof;
    }

    @Override
    public String toString() {
        return "Araba{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", renk='" + renk + '\'' +
                ", otomatikVites=" + otomatikVites +
                ", sunroof=" + sunroof +
                '}';
    }
}

// Builder arayüzü
interface ArabaBuilder {
    ArabaBuilder setMarka(String marka);
    ArabaBuilder setModel(String model);
    ArabaBuilder setRenk(String renk);
    ArabaBuilder setOtomatikVites(boolean otomatikVites);
    ArabaBuilder setSunroof(boolean sunroof);
    Araba build();
}

// Builder uygulaması
class ArabaBuilderImpl implements ArabaBuilder {
    private String marka;
    private String model;
    private String renk;
    private boolean otomatikVites;
    private boolean sunroof;

    @Override
    public ArabaBuilder setMarka(String marka) {
        this.marka = marka;
        return this;
    }

    @Override
    public ArabaBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public ArabaBuilder setRenk(String renk) {
        this.renk = renk;
        return this;
    }

    @Override
    public ArabaBuilder setOtomatikVites(boolean otomatikVites) {
        this.otomatikVites = otomatikVites;
        return this;
    }

    @Override
    public ArabaBuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    @Override
    public Araba build() {
        return new Araba(marka, model, renk, otomatikVites, sunroof);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        ArabaBuilder arabaBuilder = new ArabaBuilderImpl();
        Araba araba = arabaBuilder
                .setMarka("Toyota")
                .setModel("Corolla")
                .setRenk("Mavi")
                .setOtomatikVites(true)
                .setSunroof(false)
                .build();

        System.out.println(araba);
    }
}
