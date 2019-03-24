package entity;

public class Recipe {
    private int id;
    private String name;
    private String description;
    private int cookingTime;
    private int preparationTime;
    private String image;

    public  Recipe(){}
    public Recipe(String name,  int cookingTime, int preparationTime, String description) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.description = description;
    }

    public Recipe(String name,  int cookingTime, int preparationTime, String description, String image) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.description = description;
        this.image = image;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cookingTime=" + cookingTime +
                ", preparationTime=" + preparationTime +
                ", image='" + image + '\'' +
                '}';
    }
}
