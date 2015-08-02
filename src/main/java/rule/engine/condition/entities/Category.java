package rule.engine.condition.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiven on 02-08-2015.
 */
public class Category implements ConditionType {
    @JsonProperty("cIds")
    private Set<Integer> categoryIds = new HashSet<Integer>();
    @JsonProperty("exclude")
    private boolean exclusion;

    public Category() {
    }

    public Category(Set<Integer> categoryIds, boolean exclusion) {
        this.categoryIds = categoryIds;
        this.exclusion = exclusion;
    }

    public Set<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public boolean isExclusion() {
        return exclusion;
    }

    public void setExclusion(boolean exclusion) {
        this.exclusion = exclusion;
    }

    public void addCategoryId(int categoryId){
        this.categoryIds.add(categoryId);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryIds=" + categoryIds +
                ", exclusion=" + exclusion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (exclusion != category.exclusion) return false;
        if (categoryIds != null ? !categoryIds.equals(category.categoryIds) : category.categoryIds != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryIds != null ? categoryIds.hashCode() : 0;
        result = 31 * result + (exclusion ? 1 : 0);
        return result;
    }
}
