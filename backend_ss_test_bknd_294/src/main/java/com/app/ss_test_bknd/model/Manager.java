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

@Entity(name = "Manager")
@Table(name = "\"Manager\"", schema =  "\"ss_test_bknd_226\"")
@Data
                        
public class Manager {
	public Manager () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"MId\"", nullable = true )
  private Integer mId;
	  
  @Column(name = "\"FullName\"", nullable = true )
  private String fullName;
  
	  
  @Column(name = "\"ContactNumber\"", nullable = true )
  private String contactNumber;
  
	  
  @Column(name = "\"Address\"", nullable = true )
  private String address;
  
	  
  @Column(name = "\"SecondaryContactNumber\"", nullable = true )
  private String secondaryContactNumber;
  
	  
  @Column(name = "\"Pincode\"", nullable = true )
  private Integer pincode;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Manager [" 
  + "MId= " + mId  + ", " 
  + "FullName= " + fullName  + ", " 
  + "ContactNumber= " + contactNumber  + ", " 
  + "Address= " + address  + ", " 
  + "SecondaryContactNumber= " + secondaryContactNumber  + ", " 
  + "Pincode= " + pincode 
 + "]";
	}
	
}
