package data.cities;

public enum RussiaCityData implements ICityData{

    MOSSCOW("Москва",CountriesData.RUSSIA);

    private String name;
    private CountriesData countriesData;

    RussiaCityData(String name, CountriesData countriesData){
        this.name = name;
        this.countriesData = countriesData;
    }

    public String getName(){
        return this.name;
    }

    public  CountriesData countriesData(){
        return this.countriesData;
    }
}
