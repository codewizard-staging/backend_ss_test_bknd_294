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

@Entity(name = "PetService")
@Table(name = "\"PetService\"", schema =  "\"ss_test_bknd_226\"")
@Data
                        
public class PetService {
	public PetService () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ServiceId\"", nullable = true )
  private Integer serviceId;
	  
  @Column(name = "\"ServiceType\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = PetServiceTypeConverter.class)
  private PetServiceType serviceType;
  
	  
  @Column(name = "\"Price\"", nullable = true )
  private Double price;
  
	  
  @Column(name = "\"DogSize\"", nullable = true )
  private String dogSize;
  
	  
  @Column(name = "\"ServiceAt\"", nullable = true )
  private String serviceAt;
  
	  
  @Column(name = "\"DurationInDays\"", nullable = true )
  private Integer durationInDays;
  
	  
  @Column(name = "\"DurationInHours\"", nullable = true )
  private Integer durationInHours;
  
	  
  @Column(name = "\"OnlineBookingAllowed\"", nullable = true )
  private Boolean onlineBookingAllowed;
  
	  
  @Column(name = "\"AdvPaymentReqd\"", nullable = true )
  private Boolean advPaymentReqd;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "PetService [" 
  + "ServiceId= " + serviceId  + ", " 
  + "ServiceType= " + serviceType  + ", " 
  + "Price= " + price  + ", " 
  + "DogSize= " + dogSize  + ", " 
  + "ServiceAt= " + serviceAt  + ", " 
  + "DurationInDays= " + durationInDays  + ", " 
  + "DurationInHours= " + durationInHours  + ", " 
  + "OnlineBookingAllowed= " + onlineBookingAllowed  + ", " 
  + "AdvPaymentReqd= " + advPaymentReqd 
 + "]";
	}
	
}
