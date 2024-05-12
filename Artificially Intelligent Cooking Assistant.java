import java.util.*;

// Class to represent a recipe
class Recipe {
    private String name;
    private List<String> ingredients;
    private List<String> instructions;

    public Recipe(String name, List<String> ingredients, List<String> instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }
}

// Class to represent the Artificially Intelligent Cooking Assistant
public class CookingAssistant {
    private List<Recipe> recipes;

    public CookingAssistant() {
        this.recipes = new ArrayList<>();
        // Add some sample recipes for demonstration purposes
        Recipe pastaRecipe = new Recipe("Pasta Carbonara",
                Arrays.asList("Spaghetti", "Eggs", "Bacon", "Parmesan Cheese", "Black Pepper"),
                Arrays.asList("Cook spaghetti according to package instructions.",
                        "Cook bacon until crispy, then chop into pieces.",
                        "Mix eggs and parmesan cheese in a bowl.",
                        "Drain spaghetti and immediately mix with egg mixture, stirring quickly to coat.",
                        "Add bacon and black pepper, then serve immediately."));
        Recipe saladRecipe = new Recipe("Greek Salad",
                Arrays.asList("Lettuce", "Tomatoes", "Cucumber", "Red Onion", "Feta Cheese", "Olives", "Olive Oil", "Red Wine Vinegar", "Oregano"),
                Arrays.asList("Chop lettuce, tomatoes, cucumber, and red onion.",
                        "Combine chopped vegetables in a bowl.",
                        "Add crumbled feta cheese and olives to the bowl.",
                        "Drizzle olive oil and red wine vinegar over the salad, then sprinkle with oregano.",
                        "Toss salad gently to combine, then serve immediately."));
        recipes.add(pastaRecipe);
        recipes.add(saladRecipe);
    }

    // Method to suggest recipes based on available ingredients
    public List<Recipe> suggestRecipes(List<String> availableIngredients) {
        List<Recipe> suggestedRecipes = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (availableIngredients.containsAll(recipe.getIngredients())) {
                suggestedRecipes.add(recipe);
            }
        }
        return suggestedRecipes;
    }

    // Method to get cooking instructions for a specific recipe
    public List<String> getCookingInstructions(String recipeName) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                return recipe.getInstructions();
            }
        }
        return Collections.singletonList("Recipe not found.");
    }

    public static void main(String[] args) {
        CookingAssistant assistant = new CookingAssistant();
        Scanner scanner = new Scanner(System.in);

        // Sample usage: suggest recipes based on available ingredients
        System.out.println("Enter available ingredients (comma-separated):");
        String input = scanner.nextLine();
        List<String> availableIngredients = Arrays.asList(input.split(","));
        List<Recipe> suggestedRecipes = assistant.suggestRecipes(availableIngredients);
        if (suggestedRecipes.isEmpty()) {
            System.out.println("No recipes found with the available ingredients.");
        } else {
            System.out.println("Suggested recipes:");
            for (Recipe recipe : suggestedRecipes) {
                System.out.println("- " + recipe.getName());
            }
        }

        // Sample usage: get cooking instructions for a specific recipe
        System.out.println("Enter a recipe name to get cooking instructions:");
        input = scanner.nextLine();
        List<String> instructions = assistant.getCookingInstructions(input);
        System.out.println("Cooking Instructions:");
        for (String instruction : instructions) {
            System.out.println(instruction);
        }

        scanner.close();
    }
}
