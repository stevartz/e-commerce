package com.upsidle.backend.persistent.domain.state;

import com.upsidle.backend.persistent.domain.base.BaseEntity;
import com.upsidle.backend.persistent.domain.country.Country;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

/**
 * The State model for the application.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@Setter
@Audited
@Table(name = "states")
@ToString(callSuper = true)
public class State extends BaseEntity<Long> implements Serializable {
  private static final long serialVersionUID = 4741179736997334897L;

  @Column(unique = true, nullable = false)
  @NotBlank(message = "State name is needed for all state entities")
  private String name;

  @ManyToOne
  @JoinColumn(name = "country_id", nullable = false)
  private Country country;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof State state) || !super.equals(o)) {
      return false;
    }
    return Objects.equals(getName(), state.getName());
  }

  @Override
  protected boolean canEqual(Object other) {
    return other instanceof State;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getName());
  }
}
