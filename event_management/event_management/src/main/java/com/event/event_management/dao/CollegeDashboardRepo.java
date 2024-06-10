package com.event.event_management.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.event.event_management.module.CollegeDashboard;
import com.event.event_management.module.College;

public interface CollegeDashboardRepo extends JpaRepository<CollegeDashboard, Integer> {
    List<CollegeDashboard> findByCollege(College college);
}