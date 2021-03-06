package br.com.fiap.banco.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entidade que representa a tabela Conta no BD
 *
 */
@Entity
@Table(name = "CONTA", catalog = "DBBotBank")
public class Conta implements Serializable {

	private static final long serialVersionUID = 430455852172035774L;

	/**
	 * N�mero da conta que � criada a partir do Id do Telegram do usu�rio
	 */
	@Id
	@Column(name = "numero", unique = true, nullable = false)
	private long numero;

	/**
	 * Data de abertura da conta
	 */
	@Column(name = "data_abertura", unique = false, nullable = false)
	private LocalDate dataAbertura;

	/**
	 * Saldo do cliente na conta
	 */
	@Column(name = "saldo")
	private double saldo;

	/**
	 * Relacionamento com os usu�rios da conta
	 */
	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Usuario> usuarios;

	/**
	 * Relacionamento com as transa��es da conta
	 */
	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Transacao> transacoes;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numero ^ (numero >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Conta)) {
			return false;
		}
		Conta other = (Conta) obj;
		if (numero != other.numero) {
			return false;
		}
		return true;
	}

}
