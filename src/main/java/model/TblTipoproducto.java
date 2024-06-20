package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipoproducto database table.
 * 
 */
@Entity
@Table(name="tbl_tipoproducto")
@NamedQuery(name="TblTipoproducto.findAll", query="SELECT t FROM TblTipoproducto t")
public class TblTipoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipoproducto;

	private String description;

	//bi-directional many-to-one association to TblProducto
	@OneToMany(mappedBy="tblTipoproducto")
	private List<TblProducto> tblProductos;

	public TblTipoproducto() {
	}

	public int getIdtipoproducto() {
		return this.idtipoproducto;
	}

	public void setIdtipoproducto(int idtipoproducto) {
		this.idtipoproducto = idtipoproducto;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TblProducto> getTblProductos() {
		return this.tblProductos;
	}

	public void setTblProductos(List<TblProducto> tblProductos) {
		this.tblProductos = tblProductos;
	}

	public TblProducto addTblProducto(TblProducto tblProducto) {
		getTblProductos().add(tblProducto);
		tblProducto.setTblTipoproducto(this);

		return tblProducto;
	}

	public TblProducto removeTblProducto(TblProducto tblProducto) {
		getTblProductos().remove(tblProducto);
		tblProducto.setTblTipoproducto(null);

		return tblProducto;
	}

}