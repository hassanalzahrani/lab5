package com.example.lap5tracker.Controllerr;

import com.example.lap5tracker.Apirespons.ApiResponse;
import com.example.lap5tracker.Model.Modell;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping({"/api/v1/tracker"})
@RestController
public class Controller {

    ArrayList<Modell> modells = new ArrayList<>();

   @GetMapping({"/get"})
    public ArrayList<Modell> getModells() {
        return modells;
    }

    @PostMapping("add")
    public ApiResponse addModell(@RequestBody Modell modell) {
        modells.add(modell);
        return new ApiResponse(" project added successfully");
    }

    @PutMapping({"/update/{index}"})
    public ApiResponse updateModell(@PathVariable int index, @RequestBody Modell modell) {
        modells.set(index, modell);
        return new ApiResponse(" project updated successfully");
    }

    @DeleteMapping({"/delete/{index}"})
    public ApiResponse deleteModell(@PathVariable int index) {
        modells.remove(index);
        return new ApiResponse(" project deleted successfully");
    }

    @PutMapping({"/change/{index}"})
    public ApiResponse change(@PathVariable int index) {
        if ((modells.get(index)).getStatus().equalsIgnoreCase("done")) {
            (modells.get(index)).setStatus("not done");
        } else if ((modells.get(index)).getStatus().equalsIgnoreCase(" not done")) {
            (modells.get(index)).setStatus("done");
        }
        return new ApiResponse(" project updated successfully");

    }
    @GetMapping({"/search/{title}"})
    public Modell searchByTitle(@PathVariable String title) {
        for (int i = 0; i < modells.size(); ++i) {
            if ((modells.get(i)).getTitle().equalsIgnoreCase(title)) {

                return modells.get(i);
            }
        }

        return null;
    }
    @GetMapping("/company/{companyName}")
    public ArrayList<Modell> getProjectsByCompany(@PathVariable String companyName) {
        ArrayList<Modell> projectsByCompany = new ArrayList<>();
        for (Modell model : modells) {
            if (model.getCompanyName().equalsIgnoreCase(companyName)) {
                projectsByCompany.add(model);
            }
        }
        return projectsByCompany;
    }
}
