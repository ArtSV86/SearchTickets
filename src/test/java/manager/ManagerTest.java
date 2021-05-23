package manager;

import domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager = new Manager();
    private Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    private Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 3100, "DME", "KZN", 90);




    @BeforeEach
    public void before() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
    }

    @Test
    void searchByFrom_() {
        Ticket[] expected = new Ticket[]{ticket2};
        Ticket[] actual = manager.searchBy("VKO", "");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByFromOf() {
        Ticket[] expected = new Ticket[]{ticket3};
        Ticket[] actual = manager.searchBy("DME", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy_Of() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3};
        Ticket[] actual = manager.searchBy("", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOfFrom() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("KZN", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy__() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchBy("", "");
        assertArrayEquals(expected, actual);
    }

}
