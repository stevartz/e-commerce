package com.upsidle.backend.persistent.domain.address;

import com.upsidle.backend.persistent.domain.base.BaseEntity;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "states")
@ToString(callSuper = true)
public class State extends BaseEntity<Long> implements Serializable {
  @Serial private static final long serialVersionUID = 4741179736997334897L;

  @Column(unique = true, nullable = false)
  @NotBlank(message = "State name is needed for all state entities")
  private String name;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
  @JoinColumn(nullable = false)
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
