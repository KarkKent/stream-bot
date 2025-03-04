package io.github.karkkent;

import io.github.karkkent.model.StreamingBroadcast;
import io.github.karkkent.repository.StreamRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class App {

    @Autowired
    private StreamRepository streamRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner testDatabase() {
        return args -> {
            System.out.println("Тестируем базу данных...");

            // test stream
            StreamingBroadcast stream = new StreamingBroadcast("test", LocalDateTime.of(2024, 3, 20, 18, 0));
            streamRepository.save(stream);
            System.out.println("✅ Стрим сохранён!");

            // looking for nearest stream
            Optional<StreamingBroadcast> nextStream = streamRepository.findNextStream(LocalDateTime.now());
            nextStream.ifPresent(s -> System.out.println("🎥 Ближайший стрим: " + s.getTitle() + " 📅 " + s.getStreamDate()));
        };
    }
}