package pe.edu.upc.connection2connection.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.connection2connection.entities.Empresa;
import pe.edu.upc.connection2connection.repositories.IEmpresaRepository;
import pe.edu.upc.connection2connection.services.IEmpresaService;

import java.util.List;
@Service
public class EmpresaServiceImplement implements IEmpresaService {

    @Autowired
    private IEmpresaRepository eR;

    @Override
    public void insert(Empresa empresa) {
        eR.save(empresa);
    }
    @Override
    public List<Empresa> list(){
        return eR.findAll();
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public Empresa ListId(int idAuthor) {
        return eR.findById(idAuthor).orElse(new Empresa());
    }
}
