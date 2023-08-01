package com.example.assi.controller;



import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.assi.model.Ass1;
import com.example.assi.repository.GetRepository;


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.assi.model.ass1;
// import com.example.assi.repository.GetRepository;

@RestController
@RequestMapping("/abc")

public class GetController {
    
    @Autowired
    GetRepository getRepository;


    @GetMapping("/show_all")
    public List<Ass1> getAllGet(){
        return(List<Ass1>) getRepository.findAll();
    }



 
    @PostMapping("/create")
    public ResponseEntity<Ass1> createTutorial(@RequestBody Ass1 tutorial){
        Ass1 _tutorial = getRepository
        .save(new Ass1(null, tutorial.getFirstname(),tutorial.getLastname(),tutorial.getCity()));
    
        
        return new ResponseEntity<Ass1>(_tutorial, HttpStatus.OK) ;
}

    @DeleteMapping("/delete_all")
    public ResponseEntity<HttpStatus> deleteResponseEntity(){
    getRepository.deleteAll();
    return new ResponseEntity<> (HttpStatus.NOT_FOUND);

    }            


    @PutMapping("/insert/{id}")
    public ResponseEntity<Ass1> updateTutorial(@PathVariable("id") Long id, @RequestBody Ass1 tutorial){
        Optional<Ass1> __tutorial = getRepository.findById(id);
        if(__tutorial.isPresent())
        {
            Ass1 _tutorial =__tutorial.get();
            _tutorial.setFirstname(tutorial.getFirstname());
            _tutorial.setLastname(tutorial.getLastname());
            _tutorial.setCity(tutorial.getCity());

            return new ResponseEntity<> (getRepository.save(_tutorial),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }

        
    }

    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        getRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
