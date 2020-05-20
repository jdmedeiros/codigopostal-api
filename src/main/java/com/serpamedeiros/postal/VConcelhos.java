/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "VConcelhos")
public class VConcelhos {

    @DatabaseField(columnName = "designacaoDistrito")
    private String designacaoDistrito;

    @DatabaseField(columnName = "designacaoConcelho")
    private String designacaoConcelho;

    public VConcelhos() {
    }

    public String getDesignacaoDistrito() {
        return designacaoDistrito;
    }

    public String getDesignacaoConcelho() {
        return designacaoConcelho;
    }

}
