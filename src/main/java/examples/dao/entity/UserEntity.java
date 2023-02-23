package examples.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    private Long id;

    @Column(name="name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="profile")
    private ProfileEntity profile;


    public UserEntity() {
    }

    public UserEntity(Long id) {
        this.id = id;
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

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }
}
