package com.app.ss_test_bknd.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.app.ss_test_bknd.model.Manager;
import com.app.ss_test_bknd.model.Pet;
import com.app.ss_test_bknd.model.PetCareCenter;
import com.app.ss_test_bknd.model.PetOwner;
import com.app.ss_test_bknd.model.Document;
import com.app.ss_test_bknd.model.PetService;
import com.app.ss_test_bknd.enums.PetServiceType;
import com.app.ss_test_bknd.converter.PetServiceTypeConverter;

@Entity(name = "PetCareCenterImages")
@Table(schema = "\"ss_test_bknd_226\"", name = "\"PetCareCenterImages\"")
@Data
public class PetCareCenterImages{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"PcId\"")
	private Integer pcId;

    
    @Column(name = "\"DocId\"")
    private Integer docId;
 
}