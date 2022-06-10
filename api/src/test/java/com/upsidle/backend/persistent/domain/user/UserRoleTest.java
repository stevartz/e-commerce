package com.upsidle.backend.persistent.domain.user;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import com.upsidle.TestUtils;
import com.upsidle.enums.RoleType;
import com.upsidle.shared.util.UserUtils;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class UserRoleTest {

  @Test
  void equalsContract() {
    User client = UserUtils.createUser();
    User admin = UserUtils.createUser();

    Role roleClient = new Role(RoleType.ROLE_USER);
    Role roleAdmin = new Role(RoleType.ROLE_ADMIN);

    EqualsVerifier.forClass(UserRole.class)
        .withRedefinedSuperclass()
        .withPrefabValues(User.class, client, admin)
        .withPrefabValues(Role.class, roleClient, roleAdmin)
        .withIgnoredFields(TestUtils.getIgnoredFields().toArray(new String[0]))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(UserRole.class)
        .withClassName(NameStyle.SIMPLE_NAME)
        .withIgnoredFields("user", "role")
        .verify();
  }
}
