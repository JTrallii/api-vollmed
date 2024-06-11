package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repositorio;

//    @PostMapping
//    public void cadastro(@RequestBody String json) {
//        System.out.println(json);
//    } Para fazer o teste da requisição enviada, aqui verifica se está chegando a requisição

    //Agora podemos testar se conseguimos salvar um objeto Medico no banco de dados.
    //Vamos abrir o arquivo MedicoController.java. Acima do método, abaixo da
    //anotação @PostMapping, vamos inserir a anotação @Transactional.
    //Como esse é um método de escrita, que consiste em um insert no banco de dados,
    //precisamos ter uma transação ativa com ele.
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repositorio.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repositorio.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repositorio.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        var medico = repositorio.getReferenceById(id);
        medico.excluir();
    }
}



































