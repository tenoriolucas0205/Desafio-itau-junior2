package com.TesteJuniorItau.demo.business.service;

import com.TesteJuniorItau.demo.controller.dtos.EstatisticasResponseDTO;
import com.TesteJuniorItau.demo.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService  {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO getEstatisticas(Integer intervaloBusca ) {
        List<TransacaoRequestDTO> transacoes =  transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),estatisticasTransacoes.getSum(),estatisticasTransacoes.getAverage(), estatisticasTransacoes.getMin(),estatisticasTransacoes.getMax());
    }



}
