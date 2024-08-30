package com.test.services;

import com.test.dto.request.CreateBukuRequestDto;
import com.test.entities.Buku;
import com.test.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    public Buku createBukuFromDto(CreateBukuRequestDto createBukuRequestDto) {
        Buku buku = new Buku();
        buku.setPenulis(createBukuRequestDto.getJudul());
        buku.setJudul(createBukuRequestDto.getPenulis());
        buku.setTahunTerbit(createBukuRequestDto.getTahunTerbit());
        addBuku(buku);
        return buku;
    }

    public void addBuku(Buku buku) {
        bukuRepository.save(buku);
    }

    public Buku getBukuById(Long id) {
        return bukuRepository.findById(id).get();
    }

    public ResponseEntity<String> updateBuku(Long id, Buku buku) {
        Buku existingBuku = bukuRepository.findById(id).orElse(null);
        if (existingBuku == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Buku not found");
        }

        if (existingBuku.getJudul() == null || existingBuku.getJudul().trim().isEmpty() ||
                existingBuku.getPenulis() == null || existingBuku.getPenulis().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid input: Judul and Penulis cannot be null or blank");
        }

        if (existingBuku.getTahunTerbit() <= 0) {
            return ResponseEntity.badRequest().body("Tahun Terbit must be a positive number");
        }

        existingBuku.setJudul(buku.getJudul());
        existingBuku.setPenulis(buku.getPenulis());
        existingBuku.setTahunTerbit(buku.getTahunTerbit());
        bukuRepository.save(existingBuku);

        return ResponseEntity.ok("Buku updated successfully");
    }

    public void deleteBuku(Long id) {
        bukuRepository.deleteById(id);
    }
}