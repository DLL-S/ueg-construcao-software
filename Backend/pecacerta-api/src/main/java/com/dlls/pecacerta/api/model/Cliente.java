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

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "cli_nome", nullable = false)
	@Size(min = 3, max = 60)
	private String nome;

	@Column(name = "cli_tipo_cliente", nullable = false)
	@Enumerated(EnumType.STRING)
	private EnumTipoCliente tipoCliente;

	@Column(name = "cli_cpf", nullable = false, unique = true)
	@Size(min = 11, max = 11)
	private String cpf_cnpj;

	@Column(name = "cli_data_nasc", nullable = false)
	private LocalDate dataDeNascimento;

	@Embedded
	@Valid
	@AttributeOverrides({
        @AttributeOverride(name="logradouro", column=@Column(name="cli_logradouro")),
        @AttributeOverride(name="numero", column=@Column(name="cli_numero")),
        @AttributeOverride(name="complemento", column=@Column(name="cli_complemento")),
        @AttributeOverride(name="bairro", column=@Column(name="cli_bairro")),
        @AttributeOverride(name="cep", column=@Column(name="cli_cep")),
        @AttributeOverride(name="cidade", column=@Column(name="cli_cidade")),
        @AttributeOverride(name="estado", column=@Column(name="cli_estado"))
    })
	private Endereco endereco;

	@Column(name = "cli_email", nullable = false)
	@Size(max = 40)
	@Email
	private String email;

	@Column(name = "cli_telefone", nullable = false)
	@Size(min = 8, max = 12)
	private String telefone;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public EnumTipoCliente getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(EnumTipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
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
}
