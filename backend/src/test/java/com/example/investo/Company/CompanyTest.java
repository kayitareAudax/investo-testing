package com.example.investo.Company;

import com.example.investo.model.Company;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

@Test
public class CompanyTest {
    Company company = new Company("UBUMWE", 4000, 12, 50000);

    public void calculate_total_success() {
        assertEquals(company.getMyAmount(), 4000 * 12, "Improper calculation of your total amount invested");
    }

    public void check_totalFundsset() {
        assertNotEquals(company.getCompanyTotalFunds(), 0, "we did not expect zero funds to be returned and" + company.getCompanyTotalFunds() + "USD is returned");
    }

    public void calculate_percentage() {
        long expected = 4000 * 12 * 100 / 50000;
        assertEquals(company.getMyPercentage(), expected, "expected to get percentage of" + expected + " % but got" + company.getMyPercentage() + " %");
    }
}
