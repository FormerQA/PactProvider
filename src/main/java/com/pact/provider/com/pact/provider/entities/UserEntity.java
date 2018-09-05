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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user_details")
@Component
@Data
@NoArgsConstructor
@Transactional
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

	@JsonProperty("user_id")
	@Id
    @NotNull(
            message = "user id cannot be null"
    )
	@Column(name = "user_id")
    @Valid
	private Long userId;

	@JsonProperty("user_name")
    @NotNull(
            message = "user name can not be null"
    )
	@Column(name = "user_name")
	private String userName;

	@Valid
	@JsonProperty("courses")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="userEntity")
	private List<CourseEntity> courseEntities;

}
