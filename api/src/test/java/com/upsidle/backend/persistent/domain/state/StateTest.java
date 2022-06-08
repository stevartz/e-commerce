package com.upsidle.backend.persistent.domain.state;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import com.upsidle.backend.persistent.domain.country.Country;
import com.upsidle.backend.persistent.domain.product.Product;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

/**
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
public class StateTest extends TestUtils {

    @Test
    void equalsContract() {
        Country one = new  Country();
        one.setName(TestUtils.FAKER.country().name());

        Country two = new  Country();
        one.setName(TestUtils.FAKER.country().name());

        EqualsVerifier.forClass(State.class)
                .withRedefinedSuperclass()
                .withPrefabValues(Country.class, one, two)
                .withOnlyTheseFields(TestUtils.getEntityEqualsFields("name"))
                .verify();
    }

    @Test
    void testToString() {
        ToStringVerifier.forClass(State.class).withClassName(NameStyle.SIMPLE_NAME).verify();
    }
}
