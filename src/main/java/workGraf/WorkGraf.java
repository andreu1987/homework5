package workGraf;

public enum WorkGraf {
    REMOTELY("Удаленно"),
    FULLDAY("Полный день"),
    FLEXIBLESCHEDULE("Гибкий график");

    private String name;

    WorkGraf(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
