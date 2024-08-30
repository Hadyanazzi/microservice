package com.test.controllers;

import com.test.dto.request.CreateBukuRequestDto;
import com.test.entities.Buku;
import com.test.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;


    @GetMapping
    public ResponseEntity<List<Buku>> getAllBuku() {
        List<Buku> bukuList = bukuService.getAllBuku();
        return ResponseEntity.ok(bukuList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buku> getBukuById(@PathVariable Long id) {
        Buku buku = bukuService.getBukuById(id);
        return ResponseEntity.ok(buku);
    }

    @PostMapping
    public ResponseEntity<String> addBuku(@RequestBody CreateBukuRequestDto createBukuRequestDto) {
        if (createBukuRequestDto.getJudul() == null || createBukuRequestDto.getJudul().trim().isEmpty() ||
           createBukuRequestDto.getPenulis() == null || createBukuRequestDto.getPenulis().trim().isEmpty()) {
           return ResponseEntity.badRequest().body("Invalid input: Judul and Penulis cannot be null or blank");
            }
        if (createBukuRequestDto.getTahunTerbit() <= 0) {
           return ResponseEntity.badRequest().body("Invalid input: Tahun Terbit must be a positive number");
        }

        Buku buku = bukuService.createBukuFromDto(createBukuRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Buku added successfully with id: " + buku.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBuku(@PathVariable Long id, @RequestBody Buku buku) {
        bukuService.updateBuku(id, buku);
        return ResponseEntity.ok("Buku updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBuku(@PathVariable Long id) {
        bukuService.deleteBuku(id);
        return ResponseEntity.ok("Buku deleted successfully");
    }
}