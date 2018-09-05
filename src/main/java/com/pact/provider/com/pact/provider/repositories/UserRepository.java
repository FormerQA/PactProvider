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

package com.pact.provider.com.pact.provider.repositories;

import com.pact.provider.com.pact.provider.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
