package br.com.fiap.to;

import java.time.LocalDateTime;
import java.util.List;

public class PeriodoFidelidadeTO {
    private int idPeriodoFidelidade;
    private List<RecompensaTO> recompensas;
    private LocalDateTime dataDeVigencia;

    public PeriodoFidelidadeTO() {
    }

    public PeriodoFidelidadeTO(int idPeriodoFidelidade, List<RecompensaTO> recompensas, LocalDateTime dataDeVigencia) {
        this.idPeriodoFidelidade = idPeriodoFidelidade;
        this.recompensas = recompensas;
        this.dataDeVigencia = dataDeVigencia;
    }

    public int getIdPeriodoFidelidade() {
        return idPeriodoFidelidade;
    }

    public void setIdPeriodoFidelidade(int idPeriodoFidelidade) {
        this.idPeriodoFidelidade = idPeriodoFidelidade;
    }

    public List<RecompensaTO> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(List<RecompensaTO> recompensas) {
        this.recompensas = recompensas;
    }

    public LocalDateTime getDataDeVigencia() {
        return dataDeVigencia;
    }

    public void setDataDeVigencia(LocalDateTime dataDeVigencia) {
        this.dataDeVigencia = dataDeVigencia;
    }
}
