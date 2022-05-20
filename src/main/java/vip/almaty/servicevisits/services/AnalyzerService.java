package vip.almaty.servicevisits.services;

import org.springframework.stereotype.Service;
import vip.almaty.servicevisits.entities.Analyzer;
import vip.almaty.servicevisits.entities.AnalyzerModel;
import vip.almaty.servicevisits.entities.AnalyzerType;
import vip.almaty.servicevisits.entities.Manufacturer;
import vip.almaty.servicevisits.repositories.AnalyzerModelRepository;
import vip.almaty.servicevisits.repositories.AnalyzerTypeRepository;
import vip.almaty.servicevisits.repositories.ManufacturersRepository;

@Service
public class AnalyzerService {

    private final AnalyzerTypeRepository analyzerTypeRepository;
    private final ManufacturersRepository manufacturersRepository;
    private final AnalyzerModelRepository analyzerModelRepository;

    public AnalyzerService(AnalyzerTypeRepository analyzerTypeRepository
            , ManufacturersRepository manufacturersRepository, AnalyzerModelRepository analyzerModelRepository) {
        this.analyzerTypeRepository = analyzerTypeRepository;
        this.manufacturersRepository = manufacturersRepository;
        this.analyzerModelRepository = analyzerModelRepository;
    }

    public Iterable<AnalyzerType> getAllAnalyzerTypes () {
       return analyzerTypeRepository.findAll();
    }

    public AnalyzerType saveNewAnalyzerType(AnalyzerType anlzType) {
        return analyzerTypeRepository.save(anlzType);
    }

    public AnalyzerType findAnalyzerTypeById(Long theId) {
        return analyzerTypeRepository.findById(theId).get();
    }

    public void deleteAnalyzerType(AnalyzerType anlzType) {
        analyzerTypeRepository.delete(anlzType);
    }

    public Iterable<Manufacturer> getAllManufacturers() {
        return  manufacturersRepository.findAll();
    }

    public Manufacturer saveNewManufacturer(Manufacturer manufact) {
        return manufacturersRepository.save(manufact);
    }

    public Manufacturer findManufacturerById(long theId) {
        return manufacturersRepository.findById(theId).get();
    }

    public void deleteManufacturer(Manufacturer manufact) {
        manufacturersRepository.delete(manufact);
    }

    public Iterable<AnalyzerModel> getAllAnalyzerModels() {
        return analyzerModelRepository.findAll();
    }

    public AnalyzerModel saveNewAnalyzerModel(AnalyzerModel anlzModel) {
        return analyzerModelRepository.save(anlzModel);
    }

    public Manufacturer getManufacturerById(Long manufacturerId) {
        return  manufacturersRepository.getById(manufacturerId);
    }

    public AnalyzerType getAnalyzerTypeById(Long analyzerTypeId) {
        return analyzerTypeRepository.getById(analyzerTypeId);
    }
}
