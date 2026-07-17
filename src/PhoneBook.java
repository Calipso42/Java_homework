import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (!book.containsKey(lastName)) {
            book.put(lastName, new ArrayList<>());
        }
        book.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        if (book.containsKey(lastName)) {
            return book.get(lastName);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Иванов", "+7-999-111-22-33");
        myPhoneBook.add("Петров", "+7-999-444-55-66");
        myPhoneBook.add("Иванов", "+7-999-777-88-99");
        myPhoneBook.add("Сидоров", "+7-999-000-11-22");

        System.out.println("Номера для фамилии Иванов:");
        List<String> ivanovPhones = myPhoneBook.get("Иванов");
        for (String phone : ivanovPhones) {
            System.out.println(phone);
        }

        System.out.println("\nНомера для фамилии Сидоров:");
        List<String> sidorovPhones = myPhoneBook.get("Сидоров");
        for (String phone : sidorovPhones) {
            System.out.println(phone);
        }
    }
}
