package pl.wsiz.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListViewTest {

    @Test
    void withSpaces() {
        UserListView userListView = new UserListView(null);

        String textWithSpaces = userListView.withSpaces("Andrzej", 20);

        assertEquals("Andrzej             ", textWithSpaces);
    }
}