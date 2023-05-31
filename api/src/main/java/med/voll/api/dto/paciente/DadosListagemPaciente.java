package med.voll.api.dto.paciente;

import med.voll.api.domain.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }
}
