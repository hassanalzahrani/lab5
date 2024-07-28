package com.example.lab5event.Controllerr;

import com.example.lab5event.Apirespons.ApiResponse;
import com.example.lab5event.modell.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping({"/api/v1/event"})
@RestController
public class Controller {
    ArrayList<Model> models = new ArrayList<>();

    @GetMapping
    public ArrayList<Model> getEvent() {
        return models;

    }

    @PostMapping("add")
    public ApiResponse addEvent(@RequestBody Model model) {
        models.add(model);
        return new ApiResponse("event added");


    }

    @PutMapping({"/update/{index}"})
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Model model) {
        models.set(index, model);
        return new ApiResponse("event updated");

    }

    @DeleteMapping({"/delete/{index}"})
    public ApiResponse deleteEvent(@PathVariable int index) {
        models.remove(index);
        return new ApiResponse("event deleted");
    }

    @PatchMapping("/update capacity/{index}/{newCapacity}")
    public ApiResponse updateCapacity(@PathVariable int index, @PathVariable int newCapacity) {
        Model event = models.get(index);
        event.setCapacity(newCapacity);
        models.set(index, event);
        return new ApiResponse("event capacity updated");
    }

    @GetMapping({"/search/{id}"})
    public Model searchById(@PathVariable String id) {
        for (int i = 0; i < models.size(); ++i) {
            if ((models.get(i)).getId().equalsIgnoreCase(id)) {

                return models.get(i);
            }

        }

return null;
    }
}
