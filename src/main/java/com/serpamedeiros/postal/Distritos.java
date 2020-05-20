/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Distritos")
public class Distritos {

    @DatabaseField(columnName = "codDistrito")
    String codDistrito;
    @DatabaseField(columnName = "designacaoDistrito")
    private String designacaoDistrito;

    public Distritos() {
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public String getDesignacaoDistrito() {
        return designacaoDistrito;
    }
}
