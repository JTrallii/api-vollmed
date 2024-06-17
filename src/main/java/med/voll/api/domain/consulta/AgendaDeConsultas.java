package med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository repositorio;

    public void agendar(DadosAgendamentoConsulta dados) {
        var consulta = new Consulta(null, medico, paciente, dados.data());



    }

}
