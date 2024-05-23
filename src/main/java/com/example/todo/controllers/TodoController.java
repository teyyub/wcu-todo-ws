package com.example.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//http://localhost:8080/api/todos

@RestController
@RequestMapping("/api")
public class TodoController {

    List<Todo> todos = new ArrayList<>();

    private int getRandom(){
        return new Random().nextInt(100_000);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
//        System.out.println(id);
        for(Todo t : todos){
//            System.out.println(t.getId().equals(id));
            if(t.getId().equals(id))
              todos.remove(t);
            break;
        }
        System.out.println(todos);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }



    @GetMapping("/todos")
    public ResponseEntity<?> getAll(@RequestParam("desc") String desc){

        System.out.println(desc);
       if(desc.isEmpty()){
            return new ResponseEntity<>(todos,HttpStatus.OK);
        } else {
           List<Todo> todos = findByDesc(desc);
            return new ResponseEntity<>(todos,HttpStatus.OK);
        }
    }

    private List<Todo> findByDesc(String desc){
        List<Todo> founds = new ArrayList<>();
        for(Todo t: todos){
            System.out.println(t.getDescription());
            System.out.println(desc);
            System.out.println(t.getDescription().equals(desc));
            if(t.getDescription().equals(desc)){
                founds.add(t);
                break;
            }
        }
       return founds;
    }

    @PostMapping("/todos")
    public ResponseEntity<?> create(@RequestBody Todo todo){
        todo.setId(getRandom());
        todo.setCreatedAt(LocalDateTime.now());
        todos.add(todo);
        return new ResponseEntity<>(todo,HttpStatus.CREATED);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Todo todo){
        System.out.println(id);
        for(Todo t: todos){
            System.out.println(t.getId().equals(id));
             if(t.getId().equals(id)){
                 t.setDescription(todo.getDescription());
                 t.setNote(todo.getNote());
             }
             break;
         }
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }

}

