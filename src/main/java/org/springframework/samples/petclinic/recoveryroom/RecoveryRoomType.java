package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecoveryRoomType extends BaseEntity {    
    @NotBlank
    @Size(min=5,max=50)
    String name;
}
