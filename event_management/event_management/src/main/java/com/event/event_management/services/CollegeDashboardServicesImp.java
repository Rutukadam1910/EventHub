
package com.event.event_management.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.event.event_management.dao.CollegeDashboardRepo;
import com.event.event_management.module.CollegeDashboard;
import com.event.event_management.module.College;

@Service
public class CollegeDashboardServicesImp implements CollegeDashboardServices {

    @Autowired
    private CollegeDashboardRepo cd;

    @Override
    public CollegeDashboard saveEvent(CollegeDashboard collegeDashboard) {
        return cd.save(collegeDashboard);
    }

    @Override
    public List<CollegeDashboard> eventList() {
        return cd.findAll();
    }

    @Override
    public void deleteById(int id) {
        cd.deleteById(id);
    }

    @Override
    public CollegeDashboard findById(int id) {
        Optional<CollegeDashboard> findById = cd.findById(id);
        return findById.orElse(null);
    }

    @Override
    public CollegeDashboard updateEvent(CollegeDashboard collegeDashboard) {
        return cd.save(collegeDashboard);
    }

    @Override
    public List<CollegeDashboard> findByCollege(College college) {
        return cd.findByCollege(college);
    }
}
