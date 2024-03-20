package org.todomvc.features.newTodo;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.todomvc.tasks.CreateTodo;
import org.todomvc.tasks.Navigate;

import java.util.Arrays;
import java.util.List;

import static org.todomvc.enums.Page.HOME_PAGE;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewTodos {
    @CastMember(name = "Toby")
    Actor toby;

    @Test
    void addATodoItemToAnEmptyList() {
        List<String> newTodos = Arrays.asList("Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4");
        toby.attemptsTo(
                Navigate.toThe(HOME_PAGE.path()),
                CreateTodo.withInfo(newTodos)
        );

        var todos = toby.asksFor(Text.ofEach(".todo-list li"));
        toby.attemptsTo(
                Ensure.that(todos).isEqualTo(newTodos)
        );
    }
}