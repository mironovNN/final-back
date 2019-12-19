package ru.rosbank.javaschool.finalprojectback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.rosbank.javaschool.finalprojectback.dto.UserSaveRequestDto;
import ru.rosbank.javaschool.finalprojectback.entity.PostEntity;
import ru.rosbank.javaschool.finalprojectback.entity.UserEntity;
import ru.rosbank.javaschool.finalprojectback.repository.PostRepository;
import ru.rosbank.javaschool.finalprojectback.service.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class FinalBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(PostRepository repository, UserService service) throws IOException {
        return args -> {
            UserSaveRequestDto vasyaSave = new UserSaveRequestDto(0, "Вася", "vasya", "123456", "vasya@mail.ru", null);
            UserEntity vasya = service.save(vasyaSave);
            UserSaveRequestDto mashaSave = new UserSaveRequestDto(0, "Маша", "masha", "qwerty", "masha@mail.ru", null);
            UserEntity masha = service.save(mashaSave);
            repository.saveAll(List.of(
                    new PostEntity(0, vasya, LocalDate.now(), "First", null, false, 0),
                    new PostEntity(0, masha, LocalDate.now(), "Second", null, false, 0),
                    new PostEntity(0, vasya, LocalDate.now(), "Third", null, false, 0),
                    new PostEntity(0, masha, LocalDate.now(), "Fourth", null, false, 0)
            ));
        };

    }
}
