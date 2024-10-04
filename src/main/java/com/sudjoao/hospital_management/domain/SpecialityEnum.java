package com.sudjoao.hospital_management.domain;

import lombok.Getter;

@Getter
public enum SpecialityEnum {
    ORTHOPEDICS(0),
    CARDIOLOGY(1),
    GYNECOLOGY(2),
    DERMATOLOGY(3);

    final int id;

    SpecialityEnum(int id) {
        this.id = id;
    }

    public static SpecialityEnum getById(int id) {
        for (SpecialityEnum speciality : SpecialityEnum.values()) {
            if (speciality.id == id) {
                return speciality;
            }
        }
        throw new IllegalArgumentException("Invalid ID for SpecialityEnum: " + id);
    }

    public static SpecialityEnum getByName(String name) {
        for (SpecialityEnum specialityEnum : SpecialityEnum.values()) {
            if (specialityEnum.toString().equalsIgnoreCase(name)) {
                return specialityEnum;
            }
        }
        throw new EnumConstantNotPresentException(SpecialityEnum.class, name);
    }

}
