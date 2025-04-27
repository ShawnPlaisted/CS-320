import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        service.addContact(new Contact("001", "John", "Doe", "1234567890", "123 Main Street"));
    }

    @Test
    public void testAddContact() {
        Contact newContact = new Contact("002", "Jane", "Smith", "0987654321", "456 Elm Street");
        service.addContact(newContact);
        assertEquals("Jane", service.getContact("002").getFirstName());
    }

    @Test
    public void testDeleteContact() {
        service.deleteContact("001");
        assertNull(service.getContact("001"));
    }

    @Test
    public void testUpdateFirstName() {
        service.updateFirstName("001", "Mike");
        assertEquals("Mike", service.getContact("001").getFirstName());
    }

    @Test
    public void testUpdatePhoneInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("001", "123");
        });
    }
}
