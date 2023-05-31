package med.voll.api.dto.paciente;

import med.voll.api.domain.Endereco;
import med.voll.api.domain.Paciente;

public record DadosDetalhamentoPaciente(Long id, String name, String email, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getEndereco());
    }
}
