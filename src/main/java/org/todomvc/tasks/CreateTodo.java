package org.todomvc.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateTodo implements Task {

    private final List<String> todos;

    public CreateTodo(List<String> todos) {
        this.todos = todos;
    }

    public static CreateTodo withInfo(List<String> todos) {
        return instrumented(CreateTodo.class, todos);
    }

    @Override
    @Step("{0} create new todos")
    public <T extends Actor> void performAs(T actor) {
        for (String todo : todos) {
            actor.attemptsTo(
                    Enter.theValue(todo).into(".new-todo").thenHit(Keys.RETURN)
            );
        }
    }
}
