package com.tc.spring.db.entity.ats.applicant;

import com.tc.spring.db.entity.ats.BaseDateTimeEntity;
import com.tc.spring.db.entity.ats.enums.GraduationType;
import com.tc.spring.db.entity.ats.enums.SchoolType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplicantEducation extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    private Long id;

    @Column(nullable = false)
    private String schoolName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SchoolType schoolType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GraduationType graduationType;

    @Column(nullable = false)
    private LocalDate admissionDate;

    private LocalDate graduatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_sn")
    private Applicant applicant;

}
