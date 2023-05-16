package ar.com.redlink.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ar.com.redlink.configurations.OracleTestProfileJPAConfig;
import ar.com.redlink.services.impl.entities.GenderEntity;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Testcontainers
@TestInstance(Lifecycle.PER_METHOD)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        IGenderRepository.class,
        OracleTestProfileJPAConfig.class})
class IGenderRepositoryTest {

    @Autowired
    IGenderRepository genderRepository;
    GenderEntity genderEntity;

    private static final String GENERE_NAME = "MASCULINO";
    private static final String GENERE_DESC = "Hombres";


    @BeforeEach
    public void setup(){
        this.genderEntity = new GenderEntity();
        this.genderEntity.setId(1L);
        this.genderEntity.setName(GENERE_NAME);
        this.genderEntity.setDescription(GENERE_DESC);
        this.genderEntity.setStatus(1);
        this.genderEntity.setRegistration_user(1);
        this.genderEntity.setRegistration_date(LocalDateTime.now());
    }

    @Test
    public void test_find_all_ok(){
        List<?> genders = genderRepository.findAll();
        Assertions.assertNotEquals(0, genders.size());
    }

    @Test
    public void test_find_by_id_ok(){
        GenderEntity answer = genderRepository.save(this.genderEntity);
        Optional<GenderEntity> gender = genderRepository.findById(1L);
        Assertions.assertTrue(gender.isPresent());
    }

    @Test
    public void test_find_by_id_not_found(){
        Optional<GenderEntity> gender = genderRepository.findById(3L);
        Assertions.assertFalse(gender.isPresent());
    }

    @Test
    public void test_save_ok(){
        GenderEntity answer = genderRepository.save(this.genderEntity);
        Assertions.assertNotNull(answer);
    }

    @Test
    public void test_save_integrity_violation_exception(){
        genderRepository.save(this.genderEntity);
        List<?> genders = genderRepository.findAll();
        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class, () -> {
            GenderEntity genderEntity1 = new GenderEntity();
            genderEntity1.setId(11L);
            genderEntity1.setName(GENERE_NAME);
            genderEntity1.setDescription(GENERE_DESC);
            genderEntity1.setStatus(1);
            genderEntity1.setRegistration_user(1);
            genderEntity1.setRegistration_date(LocalDateTime.now());
            genderRepository.save(genderEntity1);
        });
        String expectedMessage = "could not execute statement";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }

}