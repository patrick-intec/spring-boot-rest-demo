package be.infernalwhale.restdemoinit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@Scope("session")
public class DemoController {
    @Autowired
    private DemoService service;

    @GetMapping("/byName/{name}")
    public ResponseEntity getUsersByName(@PathVariable("name") String name,
                                         @RequestParam(required = false, name = "sorting") Integer sorting,
                                         @RequestBody Message message) {

    }



    // http://blah/url?parameters=here
    @GetMapping("/paramdemo")
    public ResponseEntity doSomethingWithParameters(
            @RequestParam(name = "test", required = false, defaultValue = "blah") String testParam) {
        return ResponseEntity.ok(testParam);
    }

    @GetMapping("/something/{id}")
    public ResponseEntity doSomething(@PathVariable("id") Integer id) {
        System.out.println(id);

        /*
        try {
            Object returnValue = service.getShitByID(id);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        */

        if (id == 1) return ResponseEntity.ok(new Message("Hello Worldddd"));
        else return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Your resource was not found");
    }

    @PostMapping("/something")
    public ResponseEntity postSomething(@RequestBody Message message) {
        System.out.println(message.toString());

        return ResponseEntity.ok().build();
    }
}
