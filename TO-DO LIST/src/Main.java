import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> Tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.println("\nTO-DO LIST");
            System.out.println("1. Dodaj zadanie");
            System.out.println("2. Usuń zadanie");
            System.out.println("3. Pokaż zadania");
            System.out.println("4. Wyjdź");

            System.out.println("Podaj opcje: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1 -> addTask();
                case 2 -> removeTask();
                case 3 -> showTask();
                case 4 -> System.exit(0);
                default -> System.out.println("Podaj poprawną opcje: ");
            }
        }
    }

    public static void addTask() {
        System.out.println("\nDODAJ ZADANIE:");
        System.out.print("Podaj treść zadania: ");
        String task = scanner.nextLine();

        if(task.isEmpty()) {
            System.out.println("\nNie dodano zadania. Dodaj treść");
            return;
        }

        Tasks.add(task);
        System.out.println("\nPomyślnie dodano zadanie!");
    }

    public static void removeTask() {
        System.out.println("\nUSUŃ ZADANIE:");

        if(Tasks.isEmpty()) {
            System.out.println("Brak zadań na liście do usunięcia.");
            return;
        }

        showTask();
        System.out.println("Podaj numer zadania do usunięcia: ");
        int index = scanner.nextInt();

        if(index < 1 || index > Tasks.size()) {
            System.out.println("Nie ma takiego zadania!");
            return;
        }
        Tasks.remove(index - 1);
    }

    public static void showTask() {
        System.out.println("\nTWOJE ZADANIA:");

        if(Tasks.isEmpty()) {
            System.out.println("Brak zadań na liście.");
            return;
        }

        for(int i = 0; i < Tasks.size(); i++) {
            System.out.println((i + 1) + "." + Tasks.get(i));
        }
    }
}