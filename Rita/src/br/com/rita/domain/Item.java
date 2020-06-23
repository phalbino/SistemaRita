package br.com.rita.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "tb_itens")
@NamedQueries({
@NamedQuery(name = "Item.listar", query = "SELECT item FROM Item item" ),
@NamedQuery(name = "Item.buscarPorCodigo", query = "SELECT item FROM Item item WHERE item.codigo = :codigo" )

})
public class Item {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="ite_codigo")
	private Long codigo;

	@Column(name="ite_quantidade",  nullable=false )
	private Integer quantidade;

	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_retiradas_ret_codigo", referencedColumnName="ret_codigo", 	nullable=false)
	private Retirada retirada;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tbl_produtos_pro_codigo", referencedColumnName="pro_codigo", 	nullable=false)
	private Produto produto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Retirada getRetirada() {
		return retirada;
	}

	public void setRetirada(Retirada retirada) {
		this.retirada = retirada;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", quantidade=" + quantidade + ", retirada=" + retirada + ", produto="
				+ produto + "]";
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
		Item other = (Item) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	 
	
	

}
