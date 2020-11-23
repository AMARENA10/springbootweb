package org.example.springbootweb.repository;

import org.example.springbootweb.entity.TasaDeIntereses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasaDeInteresesRepository extends JpaRepository<TasaDeIntereses, Long> {
    //select * from tasa_de_interes where interes_code = ?
    TasaDeIntereses findByInteresCode(String interesCode);
    TasaDeIntereses findByInteresMonto(String interesMonto);
    TasaDeIntereses findByInteresMontoAndInteresCode(String interesMonto, String interesCode);
}