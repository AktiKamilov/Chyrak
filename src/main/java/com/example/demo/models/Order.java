package com.example.demo.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leads")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "desired_data")
    private String desiredData;
    @Column(name = "email")
    private String email;
    @Column(name = "wishes", columnDefinition = "text")
    private String wishes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    public Order(String title, String desiredData, String email, String wishes) {
        this.title = title;
        this.desiredData = desiredData;
        this.email = email;
        this.wishes = wishes;
    }
}
