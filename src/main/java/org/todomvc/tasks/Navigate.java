package org.todomvc.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {
    private final String pageUrl;

    public Navigate(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public static Navigate toThe(String page) {
        return instrumented(Navigate.class, page);
    }

    @Override
    @Step("{0} navigate to #pageUrl")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(pageUrl)
        );
    }
}