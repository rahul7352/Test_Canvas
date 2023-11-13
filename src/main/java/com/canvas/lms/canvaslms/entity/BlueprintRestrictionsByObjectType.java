package com.canvas.lms.canvaslms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class BlueprintRestrictionsByObjectType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignment_id")
	private Assignment assignment;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wikiPage_id")
	private WikiPage wikiPage;

}
