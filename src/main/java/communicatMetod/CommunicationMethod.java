package communicatMetod;

public enum CommunicationMethod implements ICommunicationMethod {
    TELEGRAM("Тelegram"),
    WHATSAPP("whatsapp");
    private String name;

    CommunicationMethod(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
