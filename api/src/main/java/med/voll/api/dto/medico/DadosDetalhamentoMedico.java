package med.voll.api.dto.medico;

import med.voll.api.domain.Endereco;
import med.voll.api.domain.enums.Especialidade;
import med.voll.api.domain.Medico;

public record DadosDetalhamentoMedico(Long id, String name, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
