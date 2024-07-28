package com.example.lap5.Controller;

import com.example.lap5.Apirespons.Apiresponse;
import com.example.lap5.Model.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping({"/api/v1/student"})
@RestController
public class Controllerstudent {

    ArrayList<Model> models = new ArrayList<>();

@PostMapping("add")
    public Apiresponse addModel(@RequestBody Model model) {
    models.add(model);
    return new Apiresponse(" student added successfully");
}
    @PutMapping({"/update/{index}"})
    public Apiresponse updateModel( @PathVariable int index, @RequestBody Model model) {
    models.add(index, model);
    return new Apiresponse(" student updated successfully");
}
    @DeleteMapping({"/delete/{index}"})
    public Apiresponse deleteModel(@PathVariable int index) {
    models.remove(index);
    return new Apiresponse(" student deleted successfully");

}
    @GetMapping("/status/{index}")
    public Apiresponse printgraduated(@PathVariable String index) {
        for (int i = 0; i < models.size(); i++) {
            if (String.valueOf(i).equals(index)) {
                if (models.get(i).getStatus().equalsIgnoreCase("graduated")) {
                    return new Apiresponse(" true");
                } else {
                    return new Apiresponse("false");
                }
            }
        }
        return new Apiresponse("Student not found");
    }


@GetMapping("get")
    public ArrayList<Model> getModels() {
  return models;
}
}







