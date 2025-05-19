package pl.wsiz.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    //@ValueSource(strings = {"Andrzej", "Konrad", "Stanisława"})
    @CsvSource({"Andrzej,20", "Konrad,10", "Stanisława,40"})
    void withSpacesParameterized(String name, int value) {

        UserListView userListView = new UserListView((null));

        String textWithSpaces = userListView.withSpaces(name, value);

        assertEquals(value, textWithSpaces.length());//sprawdza czy dlugosc tekstu jest równa value
        assertTrue(textWithSpaces.startsWith(name));//sprawdza czy tekst zaczyna sie od imienia

        String spacesAfterName = textWithSpaces.substring(name.length());
        assertTrue(spacesAfterName.chars().allMatch(c -> c == ' '));//sprawdza czy wszystkie znaki po imieniu to spacje
    }

}