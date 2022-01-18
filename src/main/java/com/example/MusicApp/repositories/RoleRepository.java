package com.example.MusicApp.repositories;

import com.example.MusicApp.models.Role;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("roles")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String roleName);
    Role findByRoleId(Integer roleId);
}
