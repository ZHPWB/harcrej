package com.zhpwb.harcrej.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {

    ADMIN(Set.of(
            Permission.ADMIN_READ,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_CREATE,
            Permission.ADMIN_DELETE,

            Permission.KOMENDANT_CHORAGWI_READ,
            Permission.KOMENDANT_CHORAGWI_UPDATE,
            Permission.KOMENDANT_CHORAGWI_CREATE,
            Permission.KOMENDANT_CHORAGWI_DELETE,

            Permission.HUFCOWY_READ,
            Permission.HUFCOWY_UPDATE,
            Permission.HUFCOWY_CREATE,
            Permission.HUFCOWY_DELETE,

            Permission.SZCZEPOWY_READ,
            Permission.SZCZEPOWY_UPDATE,
            Permission.SZCZEPOWY_CREATE,
            Permission.SZCZEPOWY_DELETE,

            Permission.DRUZYNOWY_READ,
            Permission.DRUZYNOWY_UPDATE,
            Permission.DRUZYNOWY_CREATE,
            Permission.DRUZYNOWY_DELETE
    )),
    KOMENDANT_CHORAGWI(Set.of(
            Permission.KOMENDANT_CHORAGWI_READ,
            Permission.KOMENDANT_CHORAGWI_UPDATE,

            Permission.HUFCOWY_READ,
            Permission.HUFCOWY_UPDATE,
            Permission.HUFCOWY_CREATE,
            Permission.HUFCOWY_DELETE,

            Permission.SZCZEPOWY_READ,
            Permission.SZCZEPOWY_UPDATE,
            Permission.SZCZEPOWY_CREATE,
            Permission.SZCZEPOWY_DELETE,

            Permission.DRUZYNOWY_READ,
            Permission.DRUZYNOWY_UPDATE,
            Permission.DRUZYNOWY_CREATE,
            Permission.DRUZYNOWY_DELETE
    )),
    HUFCOWY(Set.of(
            Permission.HUFCOWY_READ,
            Permission.HUFCOWY_UPDATE,

            Permission.SZCZEPOWY_READ,
            Permission.SZCZEPOWY_UPDATE,
            Permission.SZCZEPOWY_CREATE,
            Permission.SZCZEPOWY_DELETE,

            Permission.DRUZYNOWY_READ,
            Permission.DRUZYNOWY_UPDATE,
            Permission.DRUZYNOWY_CREATE,
            Permission.DRUZYNOWY_DELETE
    )),
    SZCZEPOWY(Set.of(
            Permission.SZCZEPOWY_READ,
            Permission.SZCZEPOWY_UPDATE,

            Permission.DRUZYNOWY_READ,
            Permission.DRUZYNOWY_UPDATE,
            Permission.DRUZYNOWY_CREATE,
            Permission.DRUZYNOWY_DELETE
    )),
    DRUZYNOWY(Set.of(
            Permission.DRUZYNOWY_READ,
            Permission.DRUZYNOWY_UPDATE
    )),
    UNASSIGNED(Collections.emptySet());

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
