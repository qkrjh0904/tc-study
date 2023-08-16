package com.tc.spring.db.entity.ats.applicant;

import com.tc.spring.db.entity.ats.BaseDateTimeEntity;
import com.tc.spring.db.entity.ats.attachfile.AttachFile;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplicantPortfolio extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_file_sn")
    private AttachFile attachFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_sn")
    private Applicant applicant;
}
