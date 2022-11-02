package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecoveryRoom extends BaseEntity{
    @NotBlank
    @Size(min=3,max=50)
    String name;
    @Min(0)
    double size;    
    boolean secure;
    
    @NotNull
    @ManyToOne(optional = false)
    RecoveryRoomType roomType;
    
}
