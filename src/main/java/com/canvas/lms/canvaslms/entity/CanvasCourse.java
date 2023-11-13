package com.canvas.lms.canvaslms.entity;

import java.sql.Timestamp;
import java.util.Calendar;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class CanvasCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sisCourseId;
	private String uuid;
	private Integer integrationId;
	private Integer sisImportId;
	private String name;
	private String courseCode;
	private String originalName;
	private String workflowState;
	private Long accountId;
	private Long rootAccountId;
	private Integer enrollmentTermId;
	private String gradingPeriods;
	private Integer gradingStandardId;
	private String gradePassbackSetting;
	private Timestamp createdAt;
	private Timestamp startAt;
	private Timestamp endat;
	private String locale;
	private String enrollments;
	private Integer totalStudents;
	private String calendar;
	private String defaultView;
	private String syllabusBody;
	private Integer needsGradingCount;
	private String term;
	private String courseProgress;
	private boolean applyAssignmentGroupWeights;
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "permissions_id")
	private Permissions permissions;
	private boolean isPublic;
	private boolean isPublicToAuthUsers;
	private boolean publicSyllabus;
	private boolean publicSyllabusToAuth;
	private String publicDescription;
	private Integer storageQuotaMb;
	private String storageQuotaUsedMb;
	private boolean hideFinalGrades;
	private String license;
	private boolean allowStudentAssignmentEdits;
	private boolean allowWikiComments;
	private boolean allowStudentForumAttachments;
	private boolean openEnrollment;
	private boolean selfEnrollment;
	private boolean restrictEnrollmentsToCourseDates;
	private String courseFormat;
	private boolean accessRestrictedByDate;
	private String time_zone;
	private boolean blueprint;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blueprintRestrictions_id")
	private BlueprintRestrictions blueprintRestrictions;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blueprintRestrictionsByObjectType_id")
	private BlueprintRestrictionsByObjectType blueprintRestrictionsByObjectType;
	private boolean template;
	
}
