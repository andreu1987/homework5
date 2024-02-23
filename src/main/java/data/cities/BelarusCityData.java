package data.cities;

public enum BelarusCityData implements ICityData {

    MINSK("Минск",CountriesData.BELARUS);

    private String name;
    private CountriesData countriesData;

    BelarusCityData(String name, CountriesData countriesData){
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
