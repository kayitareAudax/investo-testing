package com.example.investo.repository;

import com.example.investo.model.Company;
import org.json.JSONException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepoTest {

    @Autowired
    private CompanyRepo companyRepo;

    @Test
    public void findAll_success () {
        List<Company> items = companyRepo.findAll();
        Assertions.assertEquals(items.size(), 4);
    }

    @Test
    public void findOne_success() throws JSONException {
        Optional<Company> itemOption = companyRepo.findById(101L);
        Assertions.assertTrue(itemOption.isPresent());

		/*JSONObject expected = null;
		expected.put("id",101);
		expected.put("name","Item1");
		expected.put("price",10);
		expected.put("quantity",100);
		*/
        //JSONAssert.assertEquals(expected, new JSONObject(itemOption.get()), true);
    }

}