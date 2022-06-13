package vip.almaty.servicevisits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vip.almaty.servicevisits.entities.*;
import vip.almaty.servicevisits.services.AnalyzerService;
import vip.almaty.servicevisits.services.CustomerService;
import vip.almaty.servicevisits.services.FieldTripService;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final FieldTripService fieldTripService;
    private final AnalyzerService analyzerService;
    private final CustomerService customerService;

    public ManagerController(FieldTripService fieldTripService, AnalyzerService analyzerService, CustomerService customerService) {
        this.fieldTripService = fieldTripService;
        this.analyzerService = analyzerService;
        this.customerService = customerService;
    }

    @GetMapping("/servicevisits")
    public String viewServiceVisits (Model model) {

        Iterable<ServiceVisit> serviceVisitsList = fieldTripService.getAllServiceVisits();

        model.addAttribute("serviceVisitsList", serviceVisitsList);

        return "manager/list-servicevisits";
    }

    @GetMapping("/servicevisit/choose-analyzer")
    public String chooseAnalyzerToService (Model model){
        Iterable<Analyzer> anlyzersList = analyzerService.getAllAnalyzers();
        model.addAttribute("analyzersList", anlyzersList);
        return "manager/list-analyzers";
    }

    @GetMapping("/servicevisit/new")
    public String displayUpdateAnalyzerTypeForm(@RequestParam("id") long theId, Model model) {
        ServiceVisit newServiceVisit = new ServiceVisit();
        Analyzer analyzerToBeServiced = analyzerService.findAnalyzerById(theId);
        newServiceVisit.setAnlz(analyzerToBeServiced);
        newServiceVisit.setServiceVisitDate(Date.from(Instant.now()));
       List<SparePart> sparePartsList = fieldTripService.getAllSpareParts();
        Iterable<ServiceVisitType> serviceVisitTypes = fieldTripService.getAllServiceVisitTypes();
        model.addAttribute("newServiceVisit", newServiceVisit);
        model.addAttribute("analyzerToBeServiced", analyzerToBeServiced);
        model.addAttribute("sparePartsList", sparePartsList);
        model.addAttribute("serviceType", serviceVisitTypes);
        return "manager/new-servicevisit";
    }

    @PostMapping("/servicevisit/save")
    public String createNewAnalyzerType(Model model, ServiceVisit newServiceVisit){
        fieldTripService.saveNewServiceVisit(newServiceVisit);

        return "redirect:/manager/servicevisits";
    }

    @GetMapping("/servicevisit/viewdetails")
    public String displayServiceVisitDetails(@RequestParam("id") long theId, Model model) {
        ServiceVisit theServiceVisit = fieldTripService.findServiceVisitById(theId);
        model.addAttribute("theServiceVisit", theServiceVisit);

        return "manager/service-details";
    }
    @GetMapping("/servicevisit/history")
    public String displayServiceHistory(@RequestParam("id") long theId, Model model) {
        Analyzer theAnalyzer = analyzerService.findAnalyzerById(theId);
        System.out.println(theAnalyzer);
        List<ServiceVisit> serviceVisitsList = theAnalyzer.getServiceVisits();
        List<SparePart> spareParts = serviceVisitsList.stream().map(visit -> visit.getSparePartsInstalled()).collect(Collectors.toList()).stream().flatMap(sparePart -> sparePart.stream()).collect(Collectors.toList());
        System.out.println(serviceVisitsList);
        System.out.println(spareParts);
        model.addAttribute("serviceVisitsList", serviceVisitsList);
        return "manager/service-history";
    }

}
