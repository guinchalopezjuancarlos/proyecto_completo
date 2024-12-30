package com.guincha.Service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.guincha.Model.Cliente;
import com.guincha.Repository.ClienteRepository;


@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repository) {
        this.clienteRepository = repository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente saveCliente(Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findByCedula(cliente.getCedula());
        if (existingCliente.isPresent()) {
        	Cliente existing = existingCliente.get();
            existing.setNombre(cliente.getNombre());
            existing.setEmail(cliente.getEmail());
            existing.setCelular(cliente.getCelular());
            return clienteRepository.save(existing);  
        } else {
            return clienteRepository.save(cliente);
        }
    }

    public void deleteCliente(Long id) {
    	clienteRepository.deleteById(id);
    }
}