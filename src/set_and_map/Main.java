package set_and_map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.repalceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        // union
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B) Union of emails (A) with phones (B)", unionAB);

        // intersect
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A ∩ B) Intersect emails (A) and phones (B)", intersectAB);

        // asymmetric difference
        Set<Contact> AminusB = new HashSet<>(emailContacts);
        AminusB.removeAll(phoneContacts);
        printData("(A - B) Asymmetric difference emails (A) and phones (B)", AminusB);

        Set<Contact> BminusA = new HashSet<>(phoneContacts);
        BminusA.removeAll(emailContacts);
        printData("(B - A) Asymmetric difference phones (B) and emails (A)", BminusA);

        // symmetric difference
        Set<Contact> AunionB = new HashSet<>(emailContacts);
        AunionB.addAll(phoneContacts); // A u B
        Set<Contact> AintersectB = new HashSet<>(emailContacts);
        AintersectB.retainAll(phoneContacts); // A n B
        AunionB.removeAll(AintersectB); // (A u B) - (A n B)
        printData("(A ∪ B) - (A ∩ B)", AunionB);

        Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        symmetricDiff.addAll(BminusA);
        printData("(A ∪ B) - (A ∩ B)", AunionB);
    }
    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
        contacts.forEach(System.out::println);
    }
}
