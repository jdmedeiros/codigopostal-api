/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "VCodigosPostais")
public class CodigosPostais {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "designacaoDistrito")
    private String designacaoDistrito;
    @DatabaseField(columnName = "designacaoConcelho")
    private String designacaoConcelho;
    @DatabaseField(columnName = "codLocalidade")
    private String codLocalidade;
    @DatabaseField(columnName = "localidade")
    private String localidade;
    @DatabaseField(columnName = "artCod")
    private String artCod;
    @DatabaseField(columnName = "artTipo")
    private String artTipo;
    @DatabaseField(columnName = "priPrep")
    private String priPrep;
    @DatabaseField(columnName = "artTitulo")
    private String artTitulo;
    @DatabaseField(columnName = "segPrep")
    private String segPrep;
    @DatabaseField(columnName = "artDesig")
    private String artDesig;
    @DatabaseField(columnName = "artLocal")
    private String artLocal;
    @DatabaseField(columnName = "troco")
    private String troco;
    @DatabaseField(columnName = "porta")
    private String porta;
    @DatabaseField(columnName = "cliente")
    private String cliente;
    @DatabaseField(columnName = "codPostal4")
    private String codPostal4;
    @DatabaseField(columnName = "codPostal3")
    private String codPostal3;
    @DatabaseField(columnName = "cpAlf")
    private String cpAlf;
    @DatabaseField(columnName = "latitude")
    private String latitude;
    @DatabaseField(columnName = "longitude")
    private String longitude;

    public CodigosPostais() {
    }

    public int getId() {
        return id;
    }

    public String getDesignacaoDistrito() {
        return designacaoDistrito;
    }

    public String getDesignacaoConcelho() {
        return designacaoConcelho;
    }

    public String getCodLocalidade() {
        return codLocalidade;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getArtCod() {
        return artCod;
    }

    public String getArtTipo() {
        return artTipo;
    }

    public String getPriPrep() {
        return priPrep;
    }

    public String getArtTitulo() {
        return artTitulo;
    }

    public String getSegPrep() {
        return segPrep;
    }

    public String getArtDesig() {
        return artDesig;
    }

    public String getArtLocal() {
        return artLocal;
    }

    public String getTroco() {
        return troco;
    }

    public String getPorta() {
        return porta;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCodPostal4() {
        return codPostal4;
    }

    public String getCodPostal3() {
        return codPostal3;
    }

    public String getCpAlf() {
        return cpAlf;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
