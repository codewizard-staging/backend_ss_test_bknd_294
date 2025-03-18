package com.app.ss_test_bknd.function;

import com.app.ss_test_bknd.model.Manager;
import com.app.ss_test_bknd.model.Pet;
import com.app.ss_test_bknd.model.PetCareCenter;
import com.app.ss_test_bknd.model.PetOwner;
import com.app.ss_test_bknd.model.Document;
import com.app.ss_test_bknd.model.PetService;
import com.app.ss_test_bknd.enums.PetServiceType;
import com.app.ss_test_bknd.converter.PetServiceTypeConverter;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmParameter;
import com.sap.olingo.jpa.metadata.core.edm.mapper.extension.ODataFunction;
import com.app.ss_test_bknd.repository.PetServiceRepository;
import com.app.ss_test_bknd.repository.PetOwnerRepository;
import com.app.ss_test_bknd.repository.PetCareCenterRepository;
import com.app.ss_test_bknd.repository.ManagerRepository;
import com.app.ss_test_bknd.repository.DocumentRepository;
import com.app.ss_test_bknd.repository.PetRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class JavaFunctions implements ODataFunction {


    
    
}
   
