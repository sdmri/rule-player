package product.catalogue.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiven on 01-08-2015.
 */
public class Product {

    int id;
    String name;
    Double price;
    Double specialPrice;
    Set<Category> categories = new HashSet<Category>();

    public Product(int id, String name, Double price, Double specialPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.specialPrice = specialPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPartOfCategorySet(int categoryId){
        for(Category category : categories){
            if(category !=null && category.getId() == categoryId){
                return true;
            }
        }
        return false;
    }

    public void addCategory(Category category){
        categories.add(category);
    }



}
