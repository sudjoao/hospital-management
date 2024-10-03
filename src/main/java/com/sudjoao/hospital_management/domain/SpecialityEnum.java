package com.sudjoao.hospital_management.domain;

public enum SpecialityEnum {
    ORTHOPEDICS,
    CARDIOLOGY,
    GYNECOLOGY,
    DERMATOLOGY;

    public static SpecialityEnum getByName(String name) {
        for (SpecialityEnum specialityEnum : SpecialityEnum.values()) {
            if (specialityEnum.toString().equalsIgnoreCase(name)) {
                return specialityEnum;
            }
        }
        throw new EnumConstantNotPresentException(SpecialityEnum.class, name);
    }
}
