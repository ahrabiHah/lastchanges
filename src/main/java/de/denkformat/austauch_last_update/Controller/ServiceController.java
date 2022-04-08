package de.denkformat.austauch_last_update.Controller;


import de.denkformat.austauch_last_update.Services.ServiceTypeService;
import de.denkformat.austauch_last_update.Services.ServicesService;
import de.denkformat.austauch_last_update.modell.ServiceType;
import de.denkformat.austauch_last_update.modell.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {


    @Autowired
    private ServicesService servicesService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceController(ServiceTypeService serviceTypeService, ServicesService servicesService) {
        this.servicesService = servicesService;
        this.serviceTypeService = serviceTypeService;
    }

    @GetMapping("/api/services")
    public List<Services> findAll() {
        return servicesService.findAll();
    }

    @GetMapping("/api/service/{id}")
    public Services getService(@PathVariable long id) {
        return servicesService.findById(id);
    }


    @GetMapping("/api/services/{name}")
    public Services getServiceName(@PathVariable(value = "name") String name) {
        return servicesService.findByName(name);
    }

    @RequestMapping(value = "/api/service/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Services createService(@RequestBody Services services) {
        return servicesService.save(services);
    }

    @RequestMapping(value = "/api/service/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Services updateService(@RequestBody Services services, @PathVariable long id) {
        Services exsistPerson = servicesService.findById(id);
        if (exsistPerson == null) {
            throw new RuntimeException("test");
        }
        Services serviceResponse = (Services) servicesService.updateService(services);
        return serviceResponse;
    }

    @GetMapping("/api/serviceTypes")
    public List<ServiceType> findAllType() {
        return serviceTypeService.findAll();
    }

    @GetMapping("/api/serviceType/{id}")
    public ServiceType getServiceType(@PathVariable long id) {
        return serviceTypeService.findById(id);
    }

    @RequestMapping(value = "/api/serviceType/add", method = RequestMethod.POST)
    @ResponseBody
    public ServiceType createService(@RequestBody ServiceType serviceType) {
        return serviceTypeService.save(serviceType);
    }

    @RequestMapping(value = "/api/serviceType/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ServiceType updateServiceType(@RequestBody ServiceType serviceType, @PathVariable long id) {
        ServiceType exsisServieType = serviceTypeService.findById(id);
        if (exsisServieType == null) {
            throw new RuntimeException("test");
        }
        ServiceType serviceTypeResponse = (ServiceType) serviceTypeService.updateType(serviceType);
        return serviceTypeResponse;
    }


}


