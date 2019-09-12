package ua.mycompany.contractEH;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("Nokia", 1000, true);
        Phone phone2 = new Phone("Phone", 1000, true);
        
        System.out.println("This phones equals? " + phone1.equals(phone2));
        boolean hashCodeSimilar = phone1.hashCode() == phone2.hashCode();
        System.out.println("Their hash codes equals? " + hashCodeSimilar);
    }

}
