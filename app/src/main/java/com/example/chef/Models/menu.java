package com.example.chef.Models;

public class menu {

    public String menuId;
    public String soup;
    public String pastaOrRice;
    public String meatOrChicken;
    public String vegetable;
    public String dessert;

    public menu() {
    }

    public menu(String menuId, String soup, String pastaOrRice, String meatOrChicken, String vegetable, String dessert) {
        this.menuId = menuId;
        this.soup = soup;
        this.pastaOrRice = pastaOrRice;
        this.meatOrChicken = meatOrChicken;
        this.vegetable = vegetable;
        this.dessert = dessert;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getPastaOrRice() {
        return pastaOrRice;
    }

    public void setPastaOrRice(String pastaOrRice) {
        this.pastaOrRice = pastaOrRice;
    }

    public String getMeatOrChicken() {
        return meatOrChicken;
    }

    public void setMeatOrChicken(String meatOrChicken) {
        this.meatOrChicken = meatOrChicken;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
}

