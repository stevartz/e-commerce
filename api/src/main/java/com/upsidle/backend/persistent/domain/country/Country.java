package com.upsidle.backend.persistent.domain.country;

import com.upsidle.backend.persistent.domain.base.BaseEntity;
import com.upsidle.backend.persistent.domain.product.Product;
import com.upsidle.backend.persistent.domain.state.State;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The country model for the application.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */

@Entity
@Getter
@Setter
@Audited
@Table(name = "countries")
@ToString(callSuper = true)
public class Country extends BaseEntity<Long> implements Serializable {
    private static final long serialVersionUID = 9096210160059983754L;

    private String code;

    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<State> states = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country country) || !super.equals(o)) {
            return false;
        }
        return Objects.equals(getName(), country.getName());
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof Country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}
