package com.canvas.lms.canvaslms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CanvasAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String uuid;
	private Integer parentAccountId;
	private Integer rootAccountId;
	private Integer defaultStorageQuotaMb;
	private Integer defaultUserStorageQuotaMb;
	private Integer defaultGroupStorageQuotaMb;
	private String defaultTimeZone;
	private String sisAccountId;
	private String integrationId;
	private Integer sisImportId;
	private String ltiGuid;
	private String workflowState;

}
