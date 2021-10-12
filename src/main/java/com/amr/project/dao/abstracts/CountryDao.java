package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country,Long> {
}
