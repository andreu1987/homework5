package fieldData;

public enum InputFieldData {

    FNAME("fname"), // имя
    FNAMELATIN("fname_latin"),  // имя латинице
    LNAME("lname"), //фамилия
    LNAMELATIN("lname_latin"), // фамилия латиницей
    BLOGNAME ("blog_name"), // имя в блоке
    DATEOFBRITH("date_of_birth");


    private String fname;
    private String fname_latin;
    private String lname;
    private String lname_latin;
    private String blog_name;
    private String date_of_birth;


    InputFieldData (String fname){
        this.fname = fname;
    }


    public String getFname(){
        return fname;
    }

}
