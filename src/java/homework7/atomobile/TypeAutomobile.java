package homework7.atomobile;

public enum TypeAutomobile {

    CAR("легковой"), TRUCK("грузовой");

    private final String typeName;

    TypeAutomobile(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
