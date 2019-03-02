package com.example.springbootjpa.dao;

import org.springframework.stereotype.Repository;
import com.example.springbootjpa.pojo.UserPojo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface  UserDao extends JpaRepository<UserPojo, Long>,JpaSpecificationExecutor<UserPojo>{
	
	UserPojo findByName(String name);
	
	/**
	 * 查询
	 * @param name
	 * @param id
	 * @return
	 */
	@Query("SELECT O FROM UserPojo O WHERE O.name = :name  OR O.id = :id ")
	List<UserPojo> findTwoName(@Param("name") String name, @Param("id") long id);
	
	
	/**
	 * 原生查询
	 * @param name
	 * @param id
	 * @return
	 */
	@Query(nativeQuery = true,value="SELECT O FROM user_detail O WHERE O.name = :name  OR O.id = :id ")
	List<UserPojo> findSql(@Param("name") String name, @Param("id") long id);

}
