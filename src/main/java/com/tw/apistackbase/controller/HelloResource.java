package com.tw.apistackbase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class HelloResource {

    List<Employee> employees = new ArrayList();

    private final Logger log = Logger.getLogger(this.getClass().getName());

//    @GetMapping(path = "/{userName}", produces = {"application/json"})
//    public ResponseEntity<String> getAll(@PathVariable String userName) {
//
//        return ResponseEntity.ok("Hello:" + userName);
//    }

//    @GetMapping(path = "/{userName}", produces = {"application/json"})
    @GetMapping()
    public ResponseEntity getAll() {
        employees.add(new Employee(0,"zhangsan",20,"male"));
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping()
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
//        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity changeEmployee(@RequestBody Employee employee,@RequestParam int id) {
        employees.forEach(item -> {
            if(item.getId() == employee.getId()){
                item.setAge(employee.getAge());
                item.setGender(employee.getGender());
                item.setName(employee.getName());
            }
                }
                );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity deleteEmployee(@RequestParam int id) {
        employees.forEach(item -> {
                    if(item.getId() == id){
                        employees.remove(item);
                    }
                }
        );
        return ResponseEntity.ok().build();
    }


}
