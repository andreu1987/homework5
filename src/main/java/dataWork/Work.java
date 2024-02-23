package dataWork;

public enum Work {
    COMPANY("company"),
    WORK("work");

    private String name;

    Work(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
