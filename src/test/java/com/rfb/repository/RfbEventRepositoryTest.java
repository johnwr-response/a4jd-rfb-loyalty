package com.rfb.repository;

import com.rfb.RfbloyaltyApp;
import com.rfb.bootstrap.RfbBootstrap;
import com.rfb.domain.RfbEvent;
import com.rfb.domain.RfbLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(classes = {RfbloyaltyApp.class})
public class RfbEventRepositoryTest extends AbstractRepositoryTest {

    @BeforeEach
    public void setUp() {
        RfbBootstrap rfbBootstrap = new RfbBootstrap(rfbLocationRepository, rfbEventRepository, rfbEventAttendanceRepository, rfbUserRepository);
    }

    @Test
    void findAllByRfbLocationAndEventDate() throws Exception {
        RfbLocation aleAndTheWitch = rfbLocationRepository.findByLocationName("St Pete - Ale and the Witch");
        Assertions.assertNotNull(aleAndTheWitch);
        RfbEvent event = rfbEventRepository.findByRfbLocationAndEventDate(aleAndTheWitch, LocalDate.now());
        Assertions.assertNotNull(event);
    }
}
