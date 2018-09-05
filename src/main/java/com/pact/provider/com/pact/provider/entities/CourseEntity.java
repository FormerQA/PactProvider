/*
 * Copyright (c) 2017 Target Inc
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Target Inc and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Target Inc
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Target Inc
 */

package com.pact.provider.com.pact.provider.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "course_details")
@Component
@Data
@NoArgsConstructor
@Transactional
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseEntity {

	@JsonProperty("course_details")
	@EmbeddedId
    @Valid
	private CourseId courseId;

	@JsonProperty("course_name")
    @NotNull(
            message = "course name can not be null"
    )
	@Column(name = "course_name")
	private String courseName;

    @JsonProperty("register_date")
    @NotNull(
            message = "register date can not be null"
    )
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "register_date")
    private Date registerDate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("userEntity")
    @JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)})
    private UserEntity userEntity;
	
}
