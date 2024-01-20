package com.yubi.project.usermanagementsystem.repository;

import com.yubi.project.usermanagementsystem.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
