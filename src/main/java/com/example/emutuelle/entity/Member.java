package com.example.emutuelle.entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private MemberCard memberCard;

    @ManyToMany
    @JoinTable(name = "member_health_package",
        joinColumns = @JoinColumn(name = "member_id"),
        inverseJoinColumns = @JoinColumn(name = "package_id"))
    @JsonIgnore
    private List<HealthPackage> healthPackages = new ArrayList<>();

    public Member() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public Village getVillage() { return village; }
    public void setVillage(Village village) { this.village = village; }
    public MemberCard getMemberCard() { return memberCard; }
    public void setMemberCard(MemberCard memberCard) { this.memberCard = memberCard; }
    public List<HealthPackage> getHealthPackages() { return healthPackages; }
    public void setHealthPackages(List<HealthPackage> healthPackages) { this.healthPackages = healthPackages; }
}