package dev.sohaib;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        } else {
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) >= 0) {
            myContacts.set(findContact(oldContact), newContact);
            return true;
        } else if (findContact(newContact.getName()) >= 0) {
            return false;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contact) {
        int contactIndex = -1;
        for (int i = 0; i < myContacts.size(); i++) {
            Contact currentContact = myContacts.get(i);
            if (currentContact.getName().equals(contact)) {
                contactIndex = i;
                break;
            }
        }
        return contactIndex;
    }

    public Contact queryContact(String contact) {
        if (findContact(contact) >= 0) {
            return myContacts.get(findContact(contact));
        } else {
            return null;
        }
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 1; i <= myContacts.size(); i++) {
            Contact contact = myContacts.get(i - 1);
            System.out.printf("%d. %s -> %s%n", i, contact.getName(), contact.getPhoneNumber());
        }
    }
}
