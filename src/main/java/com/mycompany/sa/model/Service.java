package com.mycompany.sa.model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private String serviceName;
    private List<Service> referencedServices;

    public Service(){}

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public Service(String serviceName, List<Service> referencedServices){
        this.serviceName = serviceName;
        this.referencedServices = referencedServices;
    }
    
    public List<Service> buildServiceList(List<String> names) {
        List<Service> serviceList = new ArrayList<>();

        for (String serviceName : names) {
            Service service = new Service();
            service.serviceName = serviceName;
            serviceList.add(service);
        }

        return serviceList;
    }

    //Get one Service search for dependencies, get services, add dependency
    public void buildReferencePerService(List<Service> services) {
        for (Service service : services) {

        }
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", referencedServices=" + referencedServices +
                '}';
    }
}
