package data.cities;

public enum CountriesData {
    RUSSIA("Россия"),
    BELARUS("Беларусь");

    private String name;
    CountriesData(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


}
