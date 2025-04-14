import java.util.*;

public class SurveySystem {
    static Scanner scanner = new Scanner(System.in);
    static String question;
    static List<String> options = new ArrayList<>();
    static Map<Integer, String> responses = new HashMap<>();
    static int responseId = 1;

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Online Survey System ===");

        while (true) {
            System.out.println("\n1. Create Survey (Admin)");
            System.out.println("2. Take Survey (User)");
            System.out.println("3. Show All Responses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createSurvey();
                case 2 -> takeSurvey();
                case 3 -> showResponses();
                case 4 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void createSurvey() {
        System.out.print("Enter the survey question: ");
        question = scanner.nextLine();

        options.clear();
        System.out.println("Enter 4 options:");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Option " + i + ": ");
            options.add(scanner.nextLine());
        }

        System.out.println("Survey created successfully!");
    }

    static void takeSurvey() {
        if (question == null || options.isEmpty()) {
            System.out.println("No survey available. Please ask the admin to create one.");
            return;
        }

        System.out.println("\n" + question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice < 1 || choice > 4) {
            System.out.println("Invalid option selected.");
        } else {
            responses.put(responseId++, options.get(choice - 1));
            System.out.println("Response recorded. Thank you!");
        }
    }

    static void showResponses() {
        if (responses.isEmpty()) {
            System.out.println("No responses yet.");
        } else {
            System.out.println("\n--- All Responses ---");
            for (Map.Entry<Integer, String> entry : responses.entrySet()) {
                System.out.println("Response " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
