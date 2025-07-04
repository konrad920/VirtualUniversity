package pl.wsiz.view;

public enum AdministratorMenuItem {

    USER_LIST(1,"lista użytkowników"),
    ADD_STUDENT(2,"dodaj studenta"),
    ADD_TEACHER(3,"dodaj nauczyciela"),
    ADD_ADMINISTRATOR(4,"dodaj administratora"),
    TEACHER_STATISTICS(5,"statystyki nauczycieli"),
    SUBJECT_LIST(6,"lista przedmiotów"),
    EXIT(7,"Wyjście");

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
