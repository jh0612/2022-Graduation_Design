package com.pweb.test;

import com.pweb.pojo.Pets;
import com.pweb.service.Impl.PetsServiceImpl;
import com.pweb.service.PetsService;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-11  13:59
 * petweb
 */
class PetsServiceTest {
    private final PetsService petsService = new PetsServiceImpl();
    @Test
    void addPet() {
        petsService.addPet(new Pets(null,"マカバカ",
                "cat",3,
                "dshfkjhljdksafjhdslkajhfjkdhsafふでjkしゃfjbdすいlbふdsb",null));
    }

    @Test
    void deletePetById() {
        petsService.deletePetById(4);
    }

    @Test
    void updatePets() {
        petsService.updatePets(new Pets(5,"マカバカ12",
                "cat",38,
                "dshfkdhsafふでjkしゃfjbdすいlbふdsb",null));
    }

    @Test
    void getPetById() {
        Pets pet = petsService.getPetById(2);
        System.out.println(pet);
    }

    @Test
    void getPets() {
        List<Pets> cats = petsService.getPets("cat");
        cats.forEach(System.out::println);
    }
}