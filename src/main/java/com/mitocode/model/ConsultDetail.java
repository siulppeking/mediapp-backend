package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConsultDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetail;

    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false, foreignKey = @ForeignKey(name = "fk_detail_consult"))
    private Consult consult;

    @Column(nullable = false, length = 70)
    private String diagnosis;

    @Column(nullable = false, length = 300)
    private String treatment;

    //Consult
    //id_consult | id_patient | id_medic | id_user | num_consult | consult_date
    //1             15          7           3          C01          2025-10-23 10:30:00

    //Consul_Detail
    //id_detail | id_consult (FK) | diagnosis | treatment
    //1           | 1               | "Flu"     | "Rest and hydration"
    //2           | 1               | "Fever"     | "Paracetamol"
}
