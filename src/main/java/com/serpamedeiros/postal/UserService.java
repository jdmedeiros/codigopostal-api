/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

/**
 *
 * @author enta
 */
import static com.serpamedeiros.postal.OpenDB.daoVConcelhos;
import static com.serpamedeiros.postal.OpenDB.userCodigosPostais;
import static com.serpamedeiros.postal.OpenDB.userDistritos;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    private Long MAXRECS = 100L;

    public List<Distritos> getAllDistritos() {
        try {
            List<Distritos> distritos = userDistritos.queryBuilder()
                    .limit(MAXRECS)
                    .selectColumns("designacaoDistrito")
                    .query();
            return distritos;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Distritos> getDistrito(String oDistrito) {
        try {
            List<Distritos> distritos = userDistritos.queryBuilder()
                    .limit(MAXRECS)
                    .selectColumns("designacaoDistrito")
                    .where().like("designacaoDistrito", oDistrito)
                    .query();
            return distritos;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<VConcelhos> getConcelho(String oDistrito, String oConcelho) {
        try {
            List<VConcelhos> vconcelhos = daoVConcelhos.queryBuilder()
                    .limit(MAXRECS)
                    .where().like("designacaoDistrito", oDistrito)
                    .and().like("designacaoConcelho", oConcelho)
                    .query();
            return vconcelhos;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<VConcelhos> getAllConcelhos() {
        try {
            List<VConcelhos> vconcelhos = daoVConcelhos.queryBuilder()
                    .limit(MAXRECS)
                    .query();
            return vconcelhos;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<CodigosPostais> getAllCodigos() {
        try {
            List<CodigosPostais> codigosPostais = userCodigosPostais.queryBuilder()
                    .limit(MAXRECS)
                    .query();
            return codigosPostais;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<CodigosPostais> getCodigo(String oCodigo4, String oCodigo3) {
        try {
            List<CodigosPostais> codigosPostais = userCodigosPostais.queryBuilder()
                    .limit(MAXRECS)
                    .where().like("codPostal4", oCodigo4)
                    .and().like("codPostal3", oCodigo3)
                    .query();
            return codigosPostais;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<CodigosPostais> getCodigo(String oDistrito, String oConcelho, String oCodPostal4, String oCodPostal3, String aLocalidade, String oArruamento) {
        try {
            List<CodigosPostais> codigosPostais = userCodigosPostais.queryBuilder()
                    .limit(MAXRECS)
                    .where().like("designacaoDistrito", oDistrito)
                    .and().like("designacaoConcelho", oConcelho)
                    .and().like("codPostal4", oCodPostal4)
                    .and().like("codPostal3", oCodPostal3)
                    .and().like("localidade", aLocalidade)
                    .and().like("artDesig", oArruamento)
                    .query();
            return codigosPostais;
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
