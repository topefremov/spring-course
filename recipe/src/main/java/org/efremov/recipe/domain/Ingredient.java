package org.efremov.recipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	
	private final String description;
	private final BigDecimal amount;

	@ManyToOne
	private final Recipe recipe;
	
	@OneToOne(fetch = FetchType.EAGER)
	private final UnitOfMeasure uom;
	
	public Ingredient() {
		this(null, null, null, null, null);
	}
}
