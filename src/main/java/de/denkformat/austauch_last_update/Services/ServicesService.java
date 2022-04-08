package de.denkformat.austauch_last_update.Services;

import de.denkformat.austauch_last_update.modell.Services;
import de.denkformat.austauch_last_update.repository.ServiceTypeRepository;
import de.denkformat.austauch_last_update.repository.ServicesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicesService {


    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository,ServiceTypeRepository serviceTypeRepository){
        this.servicesRepository=servicesRepository;
        this.serviceTypeRepository=serviceTypeRepository;
    }

    //find all services
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }

    //find all Service by ID
    public Services findById(Long theId) {
        Optional<Services> result = servicesRepository.findById(theId);
        Services services = null;
        if (result.isPresent()) {
            services = result.get();
        } else {
            throw new RuntimeException("didnt found" + theId);
        }
        return services;

    }

    //save user in DB
    public Services save(Services services){
        servicesRepository.save(services);
        return services;
    }
    //update Person in DB
    public Services updateService(Services services){
        return  servicesRepository.save(services);
    }

    //this function make search by name of the service and return all serviceTable info
    public  Services findByName(String name){
        Services result = servicesRepository.findByName(name);

        return result;

    }



}



