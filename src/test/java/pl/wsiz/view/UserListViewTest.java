package pl.wsiz.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserListViewTest {

    @Test
    void withSpaces() {
        UserListView userListView = new UserListView(null);

        String textWithSpaces = userListView.withSpaces("Andrzej", 20);

        assertEquals("Andrzej             ", textWithSpaces);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Andrzej", "Konrad", "Stanisława"})
    void withSpacesParameterized(String name) {

        UserListView userListView = new UserListView((null));

        String textWithSpaces = userListView.withSpaces(name, 20);

        assertEquals(20, textWithSpaces.length());//sprawdza czy dlugosc tekstu to dokładnie 20 znakow
        assertTrue(textWithSpaces.startsWith(name));//sprawdza czy tekst zaczyna sie od imienia

        String spacesAfterName = textWithSpaces.substring(name.length());
        assertTrue(spacesAfterName.chars().allMatch(c -> c == ' '));//sprawdza czy wszystkie znaki po imieniu to spacje
    }

}