package com.erosero.bancontt.controller;


import com.erosero.bancontt.dto.NttClienteDto;
import com.erosero.bancontt.entity.NttCliente;
import com.erosero.bancontt.service.NttClienteService;
import com.erosero.bancontt.util.GenericResponse;
import com.erosero.bancontt.util.ParametersApp;
import com.erosero.bancontt.util.UtilsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class NttClienteController {

    @Autowired
    NttClienteService nttClienteService;

    @GetMapping(value = "/encontrarClientePorId/{id}")
    public ResponseEntity<GenericResponse> encontrarCliente(@PathVariable(value = "id") Integer clienteId) {
        GenericResponse<NttCliente> nttClienteGR = new GenericResponse<>();
        try {
            NttCliente nttCliente = nttClienteService.encontrarClientePorId(clienteId);
            nttClienteGR.setObject(nttCliente);
            nttClienteGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttClienteGR.setObject(null);
            nttClienteGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttClienteGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttClienteGR, HttpStatus.OK);
    }

    @PostMapping(value = "/crearCliente")
    public ResponseEntity<GenericResponse> crearCliente(@RequestBody NttClienteDto nttCliente) {
        GenericResponse<NttCliente> nttClienteGR = new GenericResponse<>();
        try {
            NttCliente nttClienteGuardado = nttClienteService.guardarCliente(nttCliente);
            nttClienteGR.setObject(nttClienteGuardado);
            nttClienteGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttClienteGR.setObject(null);
            nttClienteGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttClienteGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttClienteGR, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizarCliente/{id}")
    public ResponseEntity<GenericResponse> actualizarCliente(@PathVariable(value = "id") Integer clienteId,
                                                             @RequestBody NttClienteDto nttCliente) {
        GenericResponse<NttCliente> nttClienteGR = new GenericResponse<>();
        try {
            NttCliente nttClienteActualizado = nttClienteService.actualizarCliente(clienteId, nttCliente);
            nttClienteGR.setObject(nttClienteActualizado);
            nttClienteGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttClienteGR.setObject(null);
            nttClienteGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttClienteGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttClienteGR, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminarClientePorId/{id}")
    public ResponseEntity<GenericResponse> eliminarClientePorId(@PathVariable(value = "id") Integer clienteId) {
        GenericResponse<NttCliente> nttClienteGR = new GenericResponse<>();
        try {
            NttCliente nttClienteEliminado = nttClienteService.eliminarCliente(clienteId);
            nttClienteGR.setObject(nttClienteEliminado);
            nttClienteGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttClienteGR.setObject(null);
            nttClienteGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttClienteGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttClienteGR, HttpStatus.OK);
    }





}
