CREATE TABLE appointments (
    id BIGINT PRIMARY KEY auto_increment,
    doctor_id BIGINT,
    patient_id BIGINT,
    appointment_time DATETIME,
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);