package com.app.ss_test_bknd.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.app.ss_test_bknd.model.Manager;
import com.app.ss_test_bknd.model.Pet;
import com.app.ss_test_bknd.model.PetCareCenter;
import com.app.ss_test_bknd.model.PetOwner;
import com.app.ss_test_bknd.model.Document;
import com.app.ss_test_bknd.model.PetService;
import com.app.ss_test_bknd.enums.PetServiceType;
import com.app.ss_test_bknd.converter.PetServiceTypeConverter;
import com.app.ss_test_bknd.converter.DurationConverter;
import com.app.ss_test_bknd.converter.UUIDToByteConverter;
import com.app.ss_test_bknd.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Pet")
@Table(name = "\"Pet\"", schema =  "\"ss_test_bknd_226\"")
@Data
                        
public class Pet {
	public Pet () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"PetId\"", nullable = true )
  private Integer petId;
	  
  @Column(name = "\"PetName\"", nullable = true )
  private String petName;
  
	  
  @Column(name = "\"Breed\"", nullable = true )
  private String breed;
  
	  
  @Column(name = "\"AnimalType\"", nullable = true )
  private String animalType;
  
	  
  @Column(name = "\"Gender\"", nullable = true )
  private String gender;
  
	  
  @Column(name = "\"Color\"", nullable = true )
  private String color;
  
	  
  @Column(name = "\"Weight\"", nullable = true )
  private Double weight;
  
	  
  @Column(name = "\"Height\"", nullable = true )
  private Double height;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Pet [" 
  + "PetId= " + petId  + ", " 
  + "PetName= " + petName  + ", " 
  + "Breed= " + breed  + ", " 
  + "AnimalType= " + animalType  + ", " 
  + "Gender= " + gender  + ", " 
  + "Color= " + color  + ", " 
  + "Weight= " + weight  + ", " 
  + "Height= " + height 
 + "]";
	}
	
}
