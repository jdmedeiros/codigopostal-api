/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Concelhos")
public class Concelhos {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "codDistrito")
    private String codDistrito;
    @DatabaseField(columnName = "codConcelho")
    private String codConcelho;
    @DatabaseField(columnName = "designacaoConcelho")
    private String designacaoConcelho;

    public Concelhos() {
    }

    public int getId() {
        return id;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public String getCodConcelho() {
        return codConcelho;
    }

    public String getDesignacaoConcelho() {
        return designacaoConcelho;
    }
    
}
