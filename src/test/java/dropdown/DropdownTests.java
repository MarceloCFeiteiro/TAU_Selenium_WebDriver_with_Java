package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelecticOption() {
        String option = "Option 1";
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.selectFromDropdown(option);
        var selectOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectOptions.contains(option), "Option not selected");
    }
}
