package com.erosero.bancontt.controller;


import com.erosero.bancontt.entity.NttCliente;
import com.erosero.bancontt.entity.NttCuenta;
import com.erosero.bancontt.service.NttCuentaService;
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
@RequestMapping("/cuentas")
public class NttCuentaController {

    @Autowired
    NttCuentaService nttCuentaService;

    @RequestMapping(value = "/encontrarCuentaPorId/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<GenericResponse> encontrarCuenta(@PathVariable(value = "id") Integer cuentaId) {
        GenericResponse<NttCuenta> nttCuentaGR = new GenericResponse<>();
        try {
            NttCuenta nttCliente = nttCuentaService.encontrarCuentaPorId(cuentaId);
            nttCuentaGR.setObject(nttCliente);
            nttCuentaGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttCuentaGR.setObject(null);
            nttCuentaGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttCuentaGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttCuentaGR, HttpStatus.OK);
    }

}
