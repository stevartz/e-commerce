package com.upsidle.backend.persistent.domain.product;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  void equalsContract() {

    EqualsVerifier.forClass(Product.class)
        .withRedefinedSuperclass()
        .withOnlyTheseFields(TestUtils.getEntityEqualsFields("name"))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(Product.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}
