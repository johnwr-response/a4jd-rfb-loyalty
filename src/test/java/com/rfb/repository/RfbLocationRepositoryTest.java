package com.rfb.repository;

import com.rfb.RfbloyaltyApp;
import com.rfb.bootstrap.RfbBootstrap;
import com.rfb.config.TestSecurityConfiguration;
import com.rfb.domain.RfbLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.util.List;

@SpringBootTest(classes = {RfbloyaltyApp.class, TestSecurityConfiguration.class})
public class RfbLocationRepositoryTest extends AbstractRepositoryTest{

    @BeforeEach
    public void setUp() {
        RfbBootstrap rfbBootstrap = new RfbBootstrap(rfbLocationRepository, rfbEventRepository, rfbEventAttendanceRepository, rfbUserRepository);
    }

    @Test
    void findAllByRunDayOfWeek() throws Exception {
        List<RfbLocation> mondayLocations = rfbLocationRepository.findAllByRunDayOfWeek(DayOfWeek.MONDAY.getValue());
        List<RfbLocation> tuesdayLocations = rfbLocationRepository.findAllByRunDayOfWeek(DayOfWeek.TUESDAY.getValue());
        List<RfbLocation> wednesdayLocations = rfbLocationRepository.findAllByRunDayOfWeek(DayOfWeek.WEDNESDAY.getValue());

        Assertions.assertEquals(1, mondayLocations.size());
        Assertions.assertEquals(1, tuesdayLocations.size());
        Assertions.assertEquals(1, wednesdayLocations.size());
    }
}
