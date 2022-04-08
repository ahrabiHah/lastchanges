package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.ServiceType;
import de.denkformat.austauch_last_update.repository.ServiceTypeRepository;
import de.denkformat.austauch_last_update.repository.ServicesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceTypeService {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ServiceTypeService(ServicesRepository servicesRepository,ServiceTypeRepository serviceTypeRepository){
        this.servicesRepository=servicesRepository;
        this.serviceTypeRepository=serviceTypeRepository;
    }

    //find All ServicesType from DB
    public List<ServiceType> findAll(){
        return serviceTypeRepository.findAll();
    }
    //Find ServicesType by his ID
    public ServiceType findById(Long theId){
        Optional<ServiceType> result= serviceTypeRepository.findById(theId);
        ServiceType serviceType =null;
        if (result.isPresent()){
            serviceType=result.get();
        }else {
            throw  new RuntimeException("dind nt found"+theId);
        }
        return serviceType;
    }
public ServiceType save(ServiceType serviceType){
    serviceTypeRepository.save(serviceType);
    return serviceType;
}
    //update Person in DB
    public ServiceType updateType(ServiceType serviceType){
        return  serviceTypeRepository.save(serviceType);
    }

    //delete ServiceType By his ID
    public void deleteServiceType(Long theId){
        serviceTypeRepository.deleteById(theId);
    }
}



