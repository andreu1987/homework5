package dataGender;

public enum Gender implements IGender {
    MALE("m"),
    FEMALE("f");

    private String name;

    Gender(String name){
        this.name = name;
    }

    public String getName(){
        return  this.name;
    }
}
