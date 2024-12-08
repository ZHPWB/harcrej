package com.zhpwb.harcrej.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    KOMENDANT_CHORAGWI_READ("komendantChoragwi:read"),
    KOMENDANT_CHORAGWI_UPDATE("komendantChoragwi:update"),
    KOMENDANT_CHORAGWI_CREATE("komendantChoragwi:create"),
    KOMENDANT_CHORAGWI_DELETE("komendantChoragwi:delete"),

    HUFCOWY_READ("hufcowy:read"),
    HUFCOWY_UPDATE("hufcowy:update"),
    HUFCOWY_CREATE("hufcowy:create"),
    HUFCOWY_DELETE("hufcowy:delete"),

    SZCZEPOWY_READ("szczepowy:read"),
    SZCZEPOWY_UPDATE("szczepowy:update"),
    SZCZEPOWY_CREATE("szczepowy:create"),
    SZCZEPOWY_DELETE("szczepowy:delete"),

    DRUZYNOWY_READ("druzynowy:read"),
    DRUZYNOWY_UPDATE("druzynowy:update"),
    DRUZYNOWY_CREATE("druzynowy:create"),
    DRUZYNOWY_DELETE("druzynowy:delete");

    @Getter
    private final String permission;



}
