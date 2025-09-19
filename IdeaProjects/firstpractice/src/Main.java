import java.util.ArrayList;
import java.util.Scanner;

// Класс предмета
class Item {
    private String name;
    private String type;   // оружие, зелье, броня, инструмент, ресурс
    private int value;

    public Item(String name, String type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " (тип: " + type + ", ценность: " + value + ")";
    }
}

// Класс инвентаря
class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Предмет добавлен!");
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Инвентарь пуст.");
        } else {
            System.out.println("Ваш инвентарь:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            System.out.println("Предмет удален!");
        } else {
            System.out.println("Неверный номер предмета.");
        }
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Добавить предмет");
            System.out.println("2 - Показать инвентарь");
            System.out.println("3 - Удалить предмет");
            System.out.println("0 - Выйти");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите название предмета: ");
                    String name = scanner.nextLine();

                    System.out.print("Введите тип предмета (оружие/зелье/броня/инструмент/ресурс): ");
                    String type = scanner.nextLine();

                    System.out.print("Введите ценность предмета: ");
                    int value;
                    try {
                        value = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Ценность должна быть числом!");
                        break;
                    }

                    Item newItem = new Item(name, type, value);
                    inventory.addItem(newItem);
                }
                case 2 -> inventory.showItems();
                case 3 -> {
                    inventory.showItems();
                    if (!inventory.isEmpty()) {
                        System.out.print("Введите номер предмета для удаления: ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine()) - 1;
                            inventory.removeItem(index);
                        } catch (NumberFormatException e) {
                            System.out.println("Введите корректный номер!");
                        }
                    }

                }
                case 0 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
