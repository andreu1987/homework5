package dataData.english;

public enum EnglishLevelData implements IEnglishLevel {
    BEGINNER("Начальный уровень (Beginner)");

    private String name;

    EnglishLevelData(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
