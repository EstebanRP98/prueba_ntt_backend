package com.erosero.bancontt.controller;


import com.erosero.bancontt.entity.NttCliente;
import com.erosero.bancontt.service.NttClienteService;
import com.erosero.bancontt.util.GenericResponse;
import com.erosero.bancontt.util.ParametersApp;
import com.erosero.bancontt.util.UtilsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class NttClienteController {

    @Autowired
    NttClienteService nttClienteService;

    @RequestMapping(value = "/encontrarClientePorId/{id}", method = RequestMethod.GET, produces = "application/json")
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





}
