package com.developersboard.backend.persistent.domain.product;

import com.developersboard.TestUtils;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
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
