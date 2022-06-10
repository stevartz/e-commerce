package com.upsidle.backend.persistent.domain.category;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class CategoryTest extends TestUtils {


    @Test
    void equalsContract() {

        EqualsVerifier.forClass(Category.class)
                .withRedefinedSuperclass()
                .withOnlyTheseFields(TestUtils.getEntityEqualsFields("name"))
                .verify();
    }

    @Test
    void testToString() {
        ToStringVerifier.forClass(Category.class).withClassName(NameStyle.SIMPLE_NAME).verify();
    }
}


