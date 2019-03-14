package entity;

public class Recipe {
    private int id;
    private String name;
    private String description;
    private int cookingTime;
    private int preparationTime;
    //private int userId;

    public Recipe(String name, String description, int cookingTime, int preparationTime) {
        this.name = name;
        this.description = description;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        //this.userId = userId;
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

  //  public int getUserId() {
  //      return userId;
   // }

  //  public void setUserId(int userId) {
  //      this.userId = userId;
   // }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cookingTime=" + cookingTime +
                ", preparationTime=" + preparationTime +
                '}';
    }
}
