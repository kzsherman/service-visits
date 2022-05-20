package vip.almaty.servicevisits.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vip.almaty.servicevisits.dto.AnalyzerModelDto;
import vip.almaty.servicevisits.entities.Analyzer;
import vip.almaty.servicevisits.entities.AnalyzerModel;
import vip.almaty.servicevisits.entities.AnalyzerType;
import vip.almaty.servicevisits.entities.Manufacturer;
import vip.almaty.servicevisits.repositories.AnalyzerTypeRepository;
import vip.almaty.servicevisits.services.AnalyzerService;

@Controller
@RequestMapping ("/admin")
public class AdminController {

    private final AnalyzerService analyzerService;

    public AdminController(AnalyzerService analyzerService) {
        this.analyzerService = analyzerService;
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


}
