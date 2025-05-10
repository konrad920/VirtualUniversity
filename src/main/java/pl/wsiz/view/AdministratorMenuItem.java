package pl.wsiz.view;

public enum AdministratorMenuItem {

    USER_LIST(1,"lista użytkowników"),
    EXIT(2,"Wyjście");

    String descriptionPL;
    int number;

    AdministratorMenuItem(int number, String descriptionPL) {
        this.descriptionPL = descriptionPL;
        this.number = number;
    }

    public String getDescriptionPL() {
        return descriptionPL;
    }

    public int getNumber() {
        return number;
    }
}
