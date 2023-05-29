package rikkei.academy.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",columnDefinition = "text")
    private String name;
    @Column(nullable = false)
    private int age;
    @ManyToOne()
    @JoinColumn(name = "country_id" )
    private Country country;

    public Customer() {
    }

    public Customer(Long id, String name, int age, Country country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
