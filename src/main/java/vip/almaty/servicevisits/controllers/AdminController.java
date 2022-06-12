package vip.almaty.servicevisits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vip.almaty.servicevisits.entities.*;
import vip.almaty.servicevisits.services.AnalyzerService;
import vip.almaty.servicevisits.services.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping ("/admin")
public class AdminController {

    private final AnalyzerService analyzerService;
    private final CustomerService customerService;

    public AdminController(AnalyzerService analyzerService, CustomerService customerService) {
        this.analyzerService = analyzerService;
        this.customerService = customerService;
    }

    @GetMapping("/panel")
    public String showAdminPanel(){
        return "admin/panel";
    }

    @GetMapping("/analyzertypes")
    public String viewAnalyzerTypes(Model model) {
        Iterable<AnalyzerType> analyzerTypesList = analyzerService.getAllAnalyzerTypes();
        model.addAttribute("analyzerTypesList", analyzerTypesList);
        return "/admin/list-analyzertypes";
    }

    @GetMapping("/analyzertype/new")
    public String displayNewAnalyzerTypeForm(Model model) {
        AnalyzerType anlzType = new AnalyzerType();
        model.addAttribute("anlzType", anlzType);
        return "/admin/new-analyzertype";
    }

    @PostMapping("/analyzertype/save")
    public String createNewAnalyzerType(Model model, AnalyzerType anlzType){
        analyzerService.saveNewAnalyzerType(anlzType);
        return "redirect:/admin/analyzertypes";
    }

    @GetMapping("/analyzertype/update")
    public String displayUpdateAnalyzerTypeForm(@RequestParam("id") long theId, Model model) {
        AnalyzerType anlzType = analyzerService.findAnalyzerTypeById(theId);
        model.addAttribute("anlzType", anlzType);
        return "admin/new-analyzertype";
    }

    @GetMapping("/analyzertype/delete")
    public String deleteAnalyzerType(@RequestParam("id") long theId, Model model) {
        AnalyzerType anlzType = analyzerService.findAnalyzerTypeById(theId);
        analyzerService.deleteAnalyzerType(anlzType);
        return "redirect:/admin/analyzertypes";
    }


    /*Manufactures controllers*/

    @GetMapping("/manufacturers")
    public String viewManufacturers(Model model) {
        Iterable<Manufacturer> manufacturersList = analyzerService.getAllManufacturers();
        model.addAttribute("manufacturersList", manufacturersList);
        return "/admin/list-manufacturers";
    }

    @GetMapping("/manufacturer/new")
    public String displayNewManufacturerForm(Model model) {
        Manufacturer manufact = new Manufacturer();
        model.addAttribute("manufact", manufact);
        return "/admin/new-manufacturer";
    }

    @PostMapping("/manufacturer/save")
    public String createNewManufacturer(Model model, Manufacturer manufact){
        analyzerService.saveNewManufacturer(manufact);
        return "redirect:/admin/manufacturers";
    }

    @GetMapping("/manufacturer/update")
    public String displayUpdateManufacturerForm(@RequestParam("id") long theId, Model model) {
        Manufacturer manufact = analyzerService.findManufacturerById(theId);
        model.addAttribute("manufact", manufact);
        return "admin/new-manufacturer";
    }

    @GetMapping("/manufacturer/delete")
    public String deleteManufacturer(@RequestParam("id") long theId, Model model) {
        Manufacturer manufact = analyzerService.findManufacturerById(theId);
        analyzerService.deleteManufacturer(manufact);
        return "redirect:/admin/manufacturers";
    }

    @GetMapping("/analyzermodels")
    public String viewAnalyzerModels(Model model) {
        Iterable<AnalyzerModel> analyzerModels = analyzerService.getAllAnalyzerModels();
        model.addAttribute("analyzerModels", analyzerModels);
        return "/admin/list-analyzermodels";
    }

    @GetMapping("/analyzermodel/new")
    public String displayNewAnalyzerModelForm(Model model) {

            AnalyzerModel anlzModel = new AnalyzerModel();
//            AnalyzerModelDto analyzerModelDto = new AnalyzerModelDto();

            Iterable <AnalyzerType> analyzerTypeList = analyzerService.getAllAnalyzerTypes();
            Iterable <Manufacturer> manufacturersList = analyzerService.getAllManufacturers();

            //   model.addAttribute("analyzerModel", analyzerModel);
            model.addAttribute("anlzModel", anlzModel);
            model.addAttribute("analyzerTypeList", analyzerTypeList);
            model.addAttribute("manufacturerList", manufacturersList);

            return "/admin/new-analyzermodel";
    }


    @PostMapping("/analyzermodel/save")
    public String createNewAnalyzerModel(Model model, AnalyzerModel anlzModel){

        System.out.println(anlzModel);

        analyzerService.saveNewAnalyzerModel(anlzModel);
        return "redirect:/admin/analyzermodels";
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        Iterable<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "/admin/list-customers";
    }

    @GetMapping("/customers/new")
    public String displayNewCustomerForm(Model model) {

        Customer newCustomer = new Customer();
        model.addAttribute("newCustomer", newCustomer);
        return "/admin/new-customer";
    }

    @PostMapping("/customers/save")
    public String saveNewCustomer (Model model, Customer newCustomer){

        System.out.println(newCustomer);

        customerService.saveNewCustomer(newCustomer);
        return "redirect:/admin/customers";
    }

    @GetMapping("/customers/view")
    public String showCustomerDetails (@RequestParam("id") long theId, Model model) {
        Customer theCustomer = customerService.findCustomerById(theId);
        Iterable<Analyzer> analyzersListByTheCustomer = customerService.findAnalyzersByTheCustomer(theCustomer);
        model.addAttribute("theCustomer", theCustomer);
        model.addAttribute("analyzersListByTheCustomer", analyzersListByTheCustomer);
        return "admin/customer-details";
    }

    @GetMapping("/customers/update")
    public String displayUpdateCustomerDetailsForm (@RequestParam("id") long theId, Model model) {
        Customer theCustomer = customerService.findCustomerById(theId);
        model.addAttribute("newCustomer", theCustomer);
        return "admin/new-customer";
    }

    @GetMapping("/customers/delete")
    public String deleteCustomer(@RequestParam("id") long theId, Model model) {
        Customer theCustomer = customerService.findCustomerById(theId);
        customerService.deleteCustomer(theCustomer);
        return "redirect:/admin/customers";
    }

    @GetMapping("/analyzers")
    public String viewAnalyzers(Model model) {
        Iterable<Analyzer> analyzersList = analyzerService.getAllAnalyzers();
        model.addAttribute("analyzersList", analyzersList);
        return "/admin/list-analyzers";
    }

    @GetMapping("/analyzer/new")
    public String newAnalyzerInstallation(@RequestParam("id") long theId, Model model) {
        Iterable<AnalyzerModel> analyzerModels = analyzerService.getAllAnalyzerModels();
        Customer theCustomer = customerService.findCustomerById(theId);
        Analyzer theAnalyzer = new Analyzer();
        theAnalyzer.setCustomr(theCustomer);
        model.addAttribute("theCustomer", theCustomer);
        model.addAttribute("theAnalyzer", theAnalyzer);
        model.addAttribute("analyzerModels", analyzerModels);
        return "/admin/new-analyzer";
    }

    @PostMapping("analyzer/save")
    public String saveNewAnalyzer (Analyzer newAnalyzer, Model model, RedirectAttributes redirectAttributes) {
        System.out.println(newAnalyzer);
        //have to implement installation date parsing
        newAnalyzer.setInstallationDate(Date.from(Instant.now()));
        analyzerService.saveNewAnalyzer(newAnalyzer);
        String newAnalyzerId = newAnalyzer.getCustomr().getCustomerId().toString();
        redirectAttributes.addAttribute("id", newAnalyzerId);
        return "redirect:/admin/customers/view";
    }

    @GetMapping("/analyzer/update")
    public String displayUpdateAnalyzerDetailsForm (@RequestParam("id") long theId, Model model) {
        Analyzer theAnalyzer = analyzerService.findAnalyzerById(theId);
        Iterable<AnalyzerModel> analyzerModels = analyzerService.getAllAnalyzerModels();
        model.addAttribute("analyzerModels", analyzerModels);
        model.addAttribute("theAnalyzer", theAnalyzer);
        return "admin/new-analyzer";
    }

    @GetMapping("/analyzer/delete")
    public String deleteAnalyzer(@RequestParam("id") long theId, Model model) {
        Analyzer theAnalyzer = analyzerService.findAnalyzerById(theId);
        analyzerService.deleteAnalyzer(theAnalyzer);
        return "redirect:/admin/analyzers";
    }


}
