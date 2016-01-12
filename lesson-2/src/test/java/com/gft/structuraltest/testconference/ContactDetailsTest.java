package com.gft.structuraltest.testconference;

import com.gft.structuraltest.testconference.ContactDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.*;
import static org.junit.Assert.*;

/**
 * Created by jokrojek on 14/10/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class ContactDetailsTest {

    @Test
    @Parameters({
        "jacek@wp.pl,false",
        "jacek,true"
    })
    public void shouldReturnTrueIfFirstNameIsValid(String firstName, boolean result)  {
        assertEquals(ContactDetails.validateFirstName(firstName), result);
    }
    
    @Test
    @Parameters({
		"jacek@wp.pl,false",
	    "jacek,true" 
    })
    public void shouldReturnTrueIfSurNameIsValid(String surname, boolean result)  {
        assertEquals(ContactDetails.validateSurName(surname), result);
    }
    
    @Test
    @Parameters({
    	"£Ûdü,true",
    	"$%#$GFSD,false"
    })
    public void shouldReturnTrueIfCityIsValid(String city, boolean result)  {
        assertEquals(ContactDetails.validateCity(city), result);
    }
    

    
    @Test
    @Parameters({
    	"+48 123 132 533,false",
    	"fsfd3234,false",
    	"asdas@oas.cs,true"
    })
    public void shuldReturnTrueIfEmailIsValid(String email, boolean result){
    	assertEquals(ContactDetails.validateEmail(email), result);
    }
}

