package com.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_user")
public class RoleUserEntity {

    @Id
    @GenericGenerator(name = "ruuuid", strategy = "uuid")
    @GeneratedValue(generator = "ruuuid")
    @Column(name = "ru_id",length = 32)
    private String ruId;

    @ManyToOne
    @JoinColumn(name = "f_u_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "f_r_id")
    private RoleEntity role;

 public RoleUserEntity() {
 }

 public RoleUserEntity(UserEntity user, RoleEntity role) {
  this.user = user;
  this.role = role;
 }

 public String getRuId() {
  return ruId;
 }

 public void setRuId(String ruId) {
  this.ruId = ruId;
 }

 public UserEntity getUser() {
  return user;
 }

 public void setUser(UserEntity user) {
  this.user = user;
 }

 public RoleEntity getRole() {
  return role;
 }

 public void setRole(RoleEntity role) {
  this.role = role;
 }
}
