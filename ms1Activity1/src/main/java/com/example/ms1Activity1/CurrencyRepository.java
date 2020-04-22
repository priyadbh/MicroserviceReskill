package com.example.ms1Activity1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<ConversionFactor, String> {

}
