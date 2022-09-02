package com.erosero.bancontt.controller;


import com.erosero.bancontt.dto.ReporteMovimientoDto;
import com.erosero.bancontt.entity.NttCuenta;
import com.erosero.bancontt.entity.NttMovimiento;
import com.erosero.bancontt.service.NttMovimientoService;
import com.erosero.bancontt.util.GenericResponse;
import com.erosero.bancontt.util.ParametersApp;
import com.erosero.bancontt.util.UtilsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class NttMovimientoController {

    @Autowired
    NttMovimientoService nttMovimientoService;

    @RequestMapping(value = "/encontrarCuentaPorId/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<GenericResponse> encontrarMovimientoPorFecha(@RequestParam("fechaInicial") Date fechaInicial,
                                                                       @RequestParam("fechaFinal") Date fechaFinal) {
        GenericResponse<List<ReporteMovimientoDto>> nttMovimientoGR = new GenericResponse<>();
        try {
            List<ReporteMovimientoDto> reporteMovimientoDtoList = nttMovimientoService.encontrarMovimientoPorFechas(fechaInicial, fechaFinal);
            nttMovimientoGR.setObject(reporteMovimientoDtoList);
            nttMovimientoGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttMovimientoGR.setObject(null);
            nttMovimientoGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttMovimientoGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttMovimientoGR, HttpStatus.OK);
    }



}
