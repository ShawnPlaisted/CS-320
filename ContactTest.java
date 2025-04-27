import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("001", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "John", "Doe", "12345", "123 Main Street");
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "John", "Doe", "1234567890", "This address is way too long to be valid and should fail.");
        });
    }
}
