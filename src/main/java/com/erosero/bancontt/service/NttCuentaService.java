package com.erosero.bancontt.service;

import com.erosero.bancontt.dto.NttCuentaDto;
import com.erosero.bancontt.entity.NttCuenta;
import com.erosero.bancontt.entity.NttTipoCuenta;
import com.erosero.bancontt.repository.NttCuentaRepository;
import com.erosero.bancontt.repository.NttTipoCuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NttCuentaService {

    @Autowired
    NttCuentaRepository nttCuentaRepository;

    @Autowired
    NttTipoCuentaRepository nttTipoCuentaRepository;

    @Autowired
    NttClienteService nttClienteService;

    public NttTipoCuenta encontrarTipoCuentaPorId(Integer tipoCuentaId) throws Exception {
        Optional<NttTipoCuenta> nttTipoCuenta = nttTipoCuentaRepository.findById(tipoCuentaId);
        if (!nttTipoCuenta.isPresent()) {
            throw new Exception("Ingrese un Tipo de Cuenta Válido");
        }
        return nttTipoCuenta.get();
    }

    public NttCuenta encontrarCuentaPorId(Integer cuentaId) throws Exception {
        Optional<NttCuenta> nttCuenta = nttCuentaRepository.findById(cuentaId);
        if (!nttCuenta.isPresent()) {
            throw new Exception("Ingrese una Cuenta Válida");
        }
        return nttCuenta.get();
    }

    public NttCuenta guardarCuenta(NttCuentaDto nttCuenta) throws Exception {
        NttCuenta nttCuentaGuardada = new NttCuenta();

        nttCuentaGuardada.setCuenNumero(nttCuenta.getCuenNumero() != null ? nttCuenta.getCuenNumero() : null);
        nttCuentaGuardada.setCuenEstado(nttCuenta.isCuenEstado());
        nttCuentaGuardada.setCuenSaldoInicial(nttCuenta.getCuenSaldoInicial() != null ? nttCuenta.getCuenSaldoInicial() : null);
        nttCuentaGuardada.setCuenTipoCuenta(nttCuenta.getCuenTipoCuenta() != null ? encontrarTipoCuentaPorId(nttCuenta.getCuenTipoCuenta()) : null);
        nttCuentaGuardada.setCuenCliId(nttCuenta.getCuenCliId() != null ? nttClienteService.encontrarClientePorId(nttCuenta.getCuenCliId()) : null);

        return nttCuentaRepository.save(nttCuentaGuardada);
    }

    public NttCuenta actualizarCuenta(Integer id, NttCuentaDto nttCuentaActualizar) throws Exception {
        Optional<NttCuenta> cuenta = nttCuentaRepository.findById(id);

        if (!cuenta.isPresent())
            throw new Exception("La Cuenta que intenta actualizar no existe");

        cuenta.get().setCuenNumero(nttCuentaActualizar.getCuenNumero() != null ? nttCuentaActualizar.getCuenNumero() : cuenta.get().getCuenNumero());
        cuenta.get().setCuenEstado(nttCuentaActualizar.isCuenEstado());
        cuenta.get().setCuenSaldoInicial(nttCuentaActualizar.getCuenSaldoInicial() != null ? nttCuentaActualizar.getCuenSaldoInicial() : cuenta.get().getCuenSaldoInicial());
        cuenta.get().setCuenTipoCuenta(nttCuentaActualizar.getCuenTipoCuenta() != null ? encontrarTipoCuentaPorId(nttCuentaActualizar.getCuenTipoCuenta()) : cuenta.get().getCuenTipoCuenta());
        cuenta.get().setCuenCliId(nttCuentaActualizar.getCuenCliId() != null ? nttClienteService.encontrarClientePorId(nttCuentaActualizar.getCuenCliId()) : cuenta.get().getCuenCliId());

        return nttCuentaRepository.save(cuenta.get());
    }

    public NttCuenta eliminarCuenta(Integer id) throws Exception {
        Optional<NttCuenta> nttCuenta = nttCuentaRepository.findById(id);

        if (!nttCuenta.isPresent())
            throw new Exception("La Cuenta que intenta eliminar no existe");
        nttCuenta.get().setCuenEstado(false);
        nttCuentaRepository.save(nttCuenta.get());
        return nttCuenta.get();
    }


}
