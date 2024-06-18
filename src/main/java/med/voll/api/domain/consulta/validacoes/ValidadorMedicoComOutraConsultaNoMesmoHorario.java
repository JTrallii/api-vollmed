package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta {

    @Autowired
    private ConsultaRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiConsultaHorario = medicoRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());


        if (medicoPossuiConsultaHorario) {
            throw new ValidacaoException("Médico já possui outra consulta marcada nesse mesmo horário !");
        }
    }

}
