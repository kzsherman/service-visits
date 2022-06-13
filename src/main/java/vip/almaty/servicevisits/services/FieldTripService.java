package vip.almaty.servicevisits.services;

import org.springframework.stereotype.Service;
import vip.almaty.servicevisits.entities.Analyzer;
import vip.almaty.servicevisits.entities.ServiceVisit;
import vip.almaty.servicevisits.entities.ServiceVisitType;
import vip.almaty.servicevisits.entities.SparePart;
import vip.almaty.servicevisits.repositories.ServiceVisitTypeRepository;
import vip.almaty.servicevisits.repositories.ServiceVisitsRepository;
import vip.almaty.servicevisits.repositories.SparePartRepository;

import java.util.List;


@Service
public class FieldTripService {

    private final ServiceVisitsRepository serviceVisitsRepository;
    private final SparePartRepository sparePartRepository;
    private final ServiceVisitTypeRepository serviceVisitTypeRepository;

    public FieldTripService(ServiceVisitsRepository serviceVisitsRepository, SparePartRepository sparePartRepository, ServiceVisitTypeRepository serviceVisitTypeRepository) {
        this.serviceVisitsRepository = serviceVisitsRepository;
        this.sparePartRepository = sparePartRepository;
        this.serviceVisitTypeRepository = serviceVisitTypeRepository;
    }

    public Iterable<ServiceVisit> getAllServiceVisits (){

        return serviceVisitsRepository.findAll();
    }

    public List<SparePart> getAllSpareParts () {

        return sparePartRepository.findAll();
    }

    public Iterable<ServiceVisitType> getAllServiceVisitTypes () {
        return serviceVisitTypeRepository.findAll();
    }

    public ServiceVisit saveNewServiceVisit(ServiceVisit newServiceVisit) {
        return serviceVisitsRepository.save(newServiceVisit);
    }

    public ServiceVisit findServiceVisitById(long theId) {

        return serviceVisitsRepository.findById(theId).get();
    }

    public List<ServiceVisit> getServiceVisitsByAnalyzer (Analyzer analyzer) {
        return serviceVisitsRepository.findServiceVisitsByAnlz(analyzer);
    }
}
