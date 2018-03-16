package com.favorites.core.favorites.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * 12/03/18
 */
public class Favorites {

    private int id;
    private String name;
    private String description;
    @SerializedName("default")
    private String isDeault;
    private Owner owner;
    private String createdAt;
    private String visibility;

    @SerializedName("products")
    @Expose
    private Map<String, Products> products;

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

    public String getIsDeault() {
        return isDeault;
    }

    public void setIsDeault(String isDeault) {
        this.isDeault = isDeault;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Map<String, Products> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Products> products) {
        this.products = products;
    }

    public class Owner {
        private String name;
        private String email;
        private String linioId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLinioId() {
            return linioId;
        }

        public void setLinioId(String linioId) {
            this.linioId = linioId;
        }
    }

    public class Products {
        private int id;
        private String name;
        private int wishListPrice;
        private String slug;
        private String url;
        private String image;
        private int linioPlusLevel;
        private String conditionType;
        private boolean freeShipping;
        private boolean imported;
        private boolean active;

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

        public int getWishListPrice() {
            return wishListPrice;
        }

        public void setWishListPrice(int wishListPrice) {
            this.wishListPrice = wishListPrice;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getLinioPlusLevel() {
            return linioPlusLevel;
        }

        public void setLinioPlusLevel(int linioPlusLevel) {
            this.linioPlusLevel = linioPlusLevel;
        }

        public String getConditionType() {
            return conditionType;
        }

        public void setConditionType(String conditionType) {
            this.conditionType = conditionType;
        }

        public boolean isFreeShipping() {
            return freeShipping;
        }

        public void setFreeShipping(boolean freeShipping) {
            this.freeShipping = freeShipping;
        }

        public boolean isImported() {
            return imported;
        }

        public void setImported(boolean imported) {
            this.imported = imported;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }

}
