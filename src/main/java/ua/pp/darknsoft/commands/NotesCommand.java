package ua.pp.darknsoft.commands;

import ua.pp.darknsoft.models.Recipe;

public class NotesCommand {
    private Long id;
    private String recipeNotes;
    private Recipe recipe;

    public NotesCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
