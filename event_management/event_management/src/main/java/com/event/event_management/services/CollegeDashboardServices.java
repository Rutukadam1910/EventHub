package com.event.event_management.services;

import java.util.List;
import com.event.event_management.module.CollegeDashboard;
import com.event.event_management.module.College;

public interface CollegeDashboardServices {
    public CollegeDashboard saveEvent(CollegeDashboard collegeDashboard);
    public List<CollegeDashboard> eventList();
    public void deleteById(int id);
    public CollegeDashboard findById(int id);
    public CollegeDashboard updateEvent(CollegeDashboard collegeDashboard);
    public List<CollegeDashboard> findByCollege(College college);
}
