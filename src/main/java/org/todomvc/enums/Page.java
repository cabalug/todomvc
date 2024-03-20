package org.todomvc.enums;

public enum Page {
    HOME_PAGE("https://todomvc.com/examples/angular/dist/browser/#/all");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
