package com.intern.ssdemo.Controller;

import com.intern.ssdemo.DTO.CustomerDTO;
import com.intern.ssdemo.Models.Customer;
import com.intern.ssdemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity getALlCustomers() {
        List<Customer> allCusotmers= customerService.getAll();
        return new ResponseEntity(allCusotmers,HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity saveCustomer( @RequestParam("name") String name,
                                        @RequestParam("email") String email,
                                        @RequestParam("mobile") String mobile,
                                        @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        String fileName = null;

        if (image != null && !image.isEmpty()) {
            // Generate unique filename
            fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

            // Define folder path (make sure uploads folder exists in your project root)
            Path uploadPath = Paths.get("uploads");

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save file
            Files.copy(image.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(name);
        customerDTO.setEmail(email);
        customerDTO.setMobile(mobile);
        customerDTO.setImage(fileName);
          customerService.add(customerDTO);
          return new ResponseEntity("Successfully Stored in DB",HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable int id) {
        Customer customer = customerService.getById(id);
        return new ResponseEntity(customer,HttpStatus.OK);
    }
    @PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity updateCustomer(@PathVariable int id,@RequestParam("name") String name,
                                         @RequestParam("email") String email,
                                         @RequestParam("mobile") String mobile,
                                         @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        String fileName = null;

        if (image != null && !image.isEmpty()) {
            // Generate unique filename
            fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

            // Define folder path (make sure uploads folder exists in your project root)
            Path uploadPath = Paths.get("uploads");

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save file
            Files.copy(image.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(name);
        customerDTO.setEmail(email);
        customerDTO.setMobile(mobile);
        customerDTO.setImage(fileName);
        customerService.update(id,customerDTO);
        return new ResponseEntity("Successfully customer updated",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
        return new ResponseEntity("Successfully deleted",HttpStatus.OK);
    }

}
