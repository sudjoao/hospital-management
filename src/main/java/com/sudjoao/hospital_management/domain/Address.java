package com.sudjoao.hospital_management.domain;

import jakarta.persistence.Embeddable;
import lombok.Builder;

@Embeddable
@Builder
public class Address {
    String street;
    String number;
    String complement;
    String neighborhood;
    String city;
    String state;
    String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
