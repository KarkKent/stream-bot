package io.github.karkkent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity  
@Table(name = "streams")  // Table in DB 
public class StreamingBroadcast {
	
	@Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоинкремент
    private Long id;

    private String title;  // Stream title
    private LocalDateTime streamDate;  // Stream time 

    public StreamingBroadcast() {}  // constructor for Hibernate

    public StreamingBroadcast(String title, LocalDateTime streamDate) {
        this.title = title;
        this.streamDate = streamDate;
    }

    //getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getStreamDate() { return streamDate; }

    //setters
    public void setTitle(String title) { this.title = title; }
    public void setStreamDate(LocalDateTime streamDate) { this.streamDate = streamDate; }

}
