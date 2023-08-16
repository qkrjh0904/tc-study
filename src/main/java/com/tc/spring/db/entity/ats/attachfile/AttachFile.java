package com.tc.spring.db.entity.ats.attachfile;

import com.tc.spring.db.entity.ats.BaseDateTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttachFile extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    private Long id;

    @Column(nullable = false)
    private String fileUid;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private String fileName;

}
