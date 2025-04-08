package com.TesteJuniorItau.demo.controller;

import com.TesteJuniorItau.demo.business.service.EstatisticasService;
import com.TesteJuniorItau.demo.controller.dtos.EstatisticasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticController {

   private final EstatisticasService estatisticasService;

   public ResponseEntity<EstatisticasResponseDTO>buscarEstatisticas(
           @RequestParam(value = "intervalobusca",required = false,defaultValue = "60" )Integer intervalobusca) {

       return ResponseEntity.ok(estatisticasService.getEstatisticas(intervalobusca));
   }


}
