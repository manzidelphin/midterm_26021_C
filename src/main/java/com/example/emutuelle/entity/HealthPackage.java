package com.example.emutuelle.entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "health_packages")
public class HealthPackage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double monthlyFee;
    @ManyToMany(mappedBy = "healthPackages")
    @JsonIgnore
    private List<Member> members = new ArrayList<>();
    public HealthPackage() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(Double monthlyFee) { this.monthlyFee = monthlyFee; }
    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }
}