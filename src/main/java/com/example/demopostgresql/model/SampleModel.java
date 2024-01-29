package com.example.demopostgresql.model;

import com.example.demopostgresql.entity.SampleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class SampleModel extends SampleEntity {
}
