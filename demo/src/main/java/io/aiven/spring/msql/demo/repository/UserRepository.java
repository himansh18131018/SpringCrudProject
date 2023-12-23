package io.aiven.spring.msql.demo.repository;

import org.springframework.data.repository.CrudRepository;

import io.aiven.spring.msql.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
