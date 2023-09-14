package com.damagecal.calculator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class CharacterEntity {
	@Entity
	public class User {
	    @Id
	    private Long id;
	    public String name;
	    public int hp;
	    public int ad;
	    public int ar;
	    public int mr;
	    public int tier;

	    // getters and setters
	}
}
