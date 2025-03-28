//package com.spring_securitywith_h2.Entity;
//
//import jakarta.persistence.*;
//
//
//@Entity
//@Table(name = "authorities", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"username", "authority"})
//})
//public class Authority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "username", nullable = false)
//    private User user;
//
//    @Column(name = "authority", length = 50, nullable = false)
//    private String authority;
//
//    // Constructors
//    public Authority() {}
//
//    public Authority(User user, String authority) {
//        this.user = user;
//        this.authority = authority;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//}
//
