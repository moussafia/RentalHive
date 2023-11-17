package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.dao.DemandeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DemandeServiceTest {

    DemandeService demandeService;
    DemandeDao demandeDao;

    @BeforeEach
    void setUp() {
        demandeDao = Mockito.mock(DemandeDao.class);
    }

    @Test
    void createDemande() {

    }

    @Test
    void updateDemande() {

    }
}