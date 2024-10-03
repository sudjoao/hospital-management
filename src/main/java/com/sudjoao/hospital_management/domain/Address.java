package com.sudjoao.hospital_management.domain;

import lombok.Builder;

@Builder
public class Address {
    String street;
    String number;
    String complement;
    String neighborhood;
    String city;
    String state;
    String zipCode;
}
