package javaTester.javaOOP.abstraction;

public interface IAnimal {
    String name = "Husky";
    String getName();
    void setName(String name);
    abstract String getAddress();
    abstract void setAddress(String address);
}
