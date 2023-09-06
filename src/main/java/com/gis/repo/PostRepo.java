package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.PostEntity;

public interface PostRepo  extends JpaRepository<PostEntity, Integer>{

}
