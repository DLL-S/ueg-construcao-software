package com.dlls.pecacerta.api.model;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.dlls.pecacerta.api.utils.TipoFuncionario;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long codigo;

		@Column(name = "func_nome", nullable = false)
		@Size(min = 3, max = 60)
		private String nome;

		@Column(name = "func_tipo_funcionario", nullable = false)
		@Enumerated(EnumType.STRING)
		private TipoFuncionario tipoDeFuncionario;

		@Column(name = "func_cpf", nullable = false, unique = true)
		@Size(min = 11, max = 11)
		@CPF
		private String cpf;

		@Column(name = "func_data_nasc", nullable = false)
		private LocalDate dataNasc;

		@Embedded
		@Valid
		@AttributeOverrides({
	        @AttributeOverride(name="logradouro", column=@Column(name="func_logradouro")),
	        @AttributeOverride(name="numero", column=@Column(name="func_numero")),
	        @AttributeOverride(name="complemento", column=@Column(name="func_complemento")),
	        @AttributeOverride(name="bairro", column=@Column(name="func_bairro")),
	        @AttributeOverride(name="cep", column=@Column(name="func_cep")),
	        @AttributeOverride(name="cidade", column=@Column(name="func_cidade")),
	        @AttributeOverride(name="estado", column=@Column(name="func_estado"))
	    })
		private Endereco endereco;

		@Column(name = "func_email", nullable = false)
		@Size(max = 40)
		@Email
		private String email;

		@Column(name = "func_telefone", nullable = false)
		@Size(min = 8, max = 12)
		private String telefone;

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public TipoFuncionario getTipoDeFuncionario() {
			return tipoDeFuncionario;
		}

		public void setTipoDeFuncionario(TipoFuncionario tipoDeFuncionario) {
			this.tipoDeFuncionario = tipoDeFuncionario;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public LocalDate getDataNasc() {
			return dataNasc;
		}

		public void setDataNasc(LocalDate dataNasc) {
			this.dataNasc = dataNasc;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Funcionario other = (Funcionario) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			return true;
		}
}
