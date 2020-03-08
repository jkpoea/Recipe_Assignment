package ec.utb.jv.Recipe_Assignment.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch =
    FetchType.LAZY)
    @JoinTable(name = "recipe_bundle", joinColumns = @JoinColumn(name = "recipe_category_id"), inverseJoinColumns =
    @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipeList;

    public RecipeCategory(int categoryId, String categoryName, List<Recipe> recipeList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.recipeList = recipeList;
    }

    public RecipeCategory(String categoryName, List<Recipe> recipeList) {
        this(0, categoryName, recipeList);
    }

    public RecipeCategory(){}

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(recipeList, that.recipeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, recipeList);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", recipeList=" + recipeList +
                '}';
    }
}
