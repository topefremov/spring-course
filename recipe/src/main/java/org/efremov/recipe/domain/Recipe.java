package org.efremov.recipe.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Represents recipe
 * @author efrem
 *
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	
	private final String description;
	private final Integer prepTime;
	private final Integer cookTime;
	private final Integer servings;
	private final String source;
	private final String url;
	private final String directions;
	
	@Lob
	private final Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private final Notes notes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private final Set<Ingredient> ingredients;
	
	public Recipe() {
		this(null, null, null, null, null, null, null, null, null, null, null);
	}
}
