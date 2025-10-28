package lesson_6.phonebook;

import java.util.*;

public class PhoneBook {

    private static class Record {
        private final String lastName;
        private final String initials;
        private final String phoneNumber;

        private Record(String lastName, String initials, String phoneNumber) {
            this.lastName = lastName;
            this.initials = initials;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return lastName + " " + initials + " — " + phoneNumber;
        }

        public String lastName() {
            return lastName;
        }

        public String initials() {
            return initials;
        }

        public String phoneNumber() {
            return phoneNumber;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Record) obj;
            return Objects.equals(this.lastName, that.lastName) &&
                    Objects.equals(this.initials, that.initials) &&
                    Objects.equals(this.phoneNumber, that.phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastName, initials, phoneNumber);
        }

    }

    private final Map<String, List<Record>> phoneBook = new HashMap<>();

    public void add(String lastName, String initials, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>())
                .add(new Record(lastName, initials, phoneNumber));
    }

    public void get(String lastName) {
        List<Record> records = phoneBook.get(lastName);
        if (records == null || records.isEmpty()) {
            System.out.println(lastName + "ых" + " не найдено.");
            return;
        }

        System.out.println("Найдено " + lastName + "ых");
        for (Record record : records) {
            System.out.println("   " + record.initials() + " — " + record.phoneNumber());
        }
    }

    public void printAll() {
        if (phoneBook.isEmpty()) {
            System.out.println("Телефонный справочник пуст.");
            return;
        }

        phoneBook.forEach((lastName, records) -> {
            System.out.println(lastName + ":");
            for (Record record : records) {
                System.out.println("   " + record.initials() + " — " + record.phoneNumber());
            }
        });
    }
}