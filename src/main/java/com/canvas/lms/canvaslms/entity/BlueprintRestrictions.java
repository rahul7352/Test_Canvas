package com.canvas.lms.canvaslms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class BlueprintRestrictions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private boolean content;
	private boolean points;
	private boolean dueDates;
	private boolean availabilityDates;

}
