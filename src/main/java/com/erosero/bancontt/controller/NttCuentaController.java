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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class NttCuentaController {

    @Autowired
    NttCuentaService nttCuentaService;

    @GetMapping(value = "/encontrarCuentaPorId/{id}")
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

    @PostMapping(value = "/crearCuenta")
    public ResponseEntity<GenericResponse> crearCuenta(@RequestBody NttCuenta nttCuenta) {
        GenericResponse<NttCuenta> nttCuentaGR = new GenericResponse<>();
        try {
            NttCuenta nttCuentaGuardado = nttCuentaService.guardarCuenta(nttCuenta);
            nttCuentaGR.setObject(nttCuentaGuardado);
            nttCuentaGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttCuentaGR.setObject(null);
            nttCuentaGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttCuentaGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttCuentaGR, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizarCuenta")
    public ResponseEntity<GenericResponse> actualizarCuenta(@PathVariable(value = "id") Integer cuentaId,
                                                            @RequestBody NttCuenta nttCuenta) {
        GenericResponse<NttCuenta> nttCuentaGR = new GenericResponse<>();
        try {
            NttCuenta nttCuentaActualizada = nttCuentaService.actualizarCuenta(cuentaId, nttCuenta);
            nttCuentaGR.setObject(nttCuentaActualizada);
            nttCuentaGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttCuentaGR.setObject(null);
            nttCuentaGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttCuentaGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttCuentaGR, HttpStatus.OK);
    }

    @PutMapping(value = "/eliminarCuentaPorId")
    public ResponseEntity<GenericResponse> eliminarCuenta(@PathVariable(value = "id") Integer cuentaId) {
        GenericResponse<NttCuenta> nttCuentaGR = new GenericResponse<>();
        try {
            NttCuenta nttCuentaEliminada = nttCuentaService.eliminarCuenta(cuentaId);
            nttCuentaGR.setObject(nttCuentaEliminada);
            nttCuentaGR.setStatus(ParametersApp.SUCCESSFUL.value());
        } catch (Exception e) {
            nttCuentaGR.setObject(null);
            nttCuentaGR.setStatus(ParametersApp.PROCESS_NOT_COMPLETED.value());
            nttCuentaGR.saveMessage(UtilsApi.getProcessExceptionMessage(e, 500));
        }
        return new ResponseEntity<>(nttCuentaGR, HttpStatus.OK);
    }

}
