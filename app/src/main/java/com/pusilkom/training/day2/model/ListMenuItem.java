package com.pusilkom.training.day2.model;

/**
 * Created by purwa on 6/13/17.
 */

public class ListMenuItem {
    private long id;
    private String iconUrl;
    private String menuLabel;
    private String menuDesc;

    public ListMenuItem(int id, String icon, String label, String desc) {
        this.id = id;
        this.iconUrl = icon;
        this.menuLabel = label;
        this.menuDesc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }
}
