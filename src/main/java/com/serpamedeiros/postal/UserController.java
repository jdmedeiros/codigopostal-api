/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serpamedeiros.postal;

import static com.serpamedeiros.postal.JsonUtil.json;
import static com.serpamedeiros.postal.JsonUtil.toJson;
import java.util.Map;
import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.Spark.get;
import java.util.*;

/**
 *
 * @author enta
 */
public class UserController {

    public UserController(final UserService userService) {
        get("/", (req, res) -> {
            res.status(404);
            return new ResponseError("Erro. Endpoints válidos: [ distritos | concelhos | moradas | codigos ]");
        }, json());

        get("/distritos", (req, res) -> {
            Map<String, String[]> params = req.queryMap().toMap();
            if (params.isEmpty()) {
                return userService.getAllDistritos();
            }
            Set<Map.Entry<String, String[]>> conjunto = params.entrySet();
            if (invalidParameters(conjunto, Arrays.asList("designacaoDistrito"))) {
                res.status(404);
                return new ResponseError("Erro. Parâmetros válidos: [ designacaoDistrito ]");
            }

            for (Map.Entry<String, String[]> chave : conjunto) {
                int numParams = 0;
                List<Distritos> resultado = null;
                for (String v : chave.getValue()) {
                    if (++numParams == 1) {
                        resultado = userService.getDistrito(v);
                    } else {
                        resultado.addAll(userService.getDistrito(v));
                    }
                }
                return resultado;
            }

            res.status(400);
            return new ResponseError("Should not happen");
        }, json());

        get("/concelhos", (req, res) -> {
            Map<String, String[]> params = req.queryMap().toMap();

            if (params.isEmpty()) {
                return userService.getAllConcelhos();
            }

            if (params.size() > 2) {
                res.status(501);
                return new ResponseError("Erro. Parâmetros válidos: [ designacaoDistrito | designacaoConcelho ]");
            }

            Set<Map.Entry<String, String[]>> conjunto = params.entrySet();
            if (params.size() >= 1) {
                if (invalidParameters(conjunto, Arrays.asList("designacaoDistrito", "designacaoConcelho"))) {
                    res.status(404);
                    return new ResponseError("Erro. Parâmetros válidos: [ designacaoDistrito | designacaoConcelho ]");
                }
            }

            String[] oDistrito = params.getOrDefault("designacaoDistrito", new String[]{"%"});
            String[] oConcelho = params.getOrDefault("designacaoConcelho", new String[]{"%"});

            return userService.getConcelho(oDistrito[0], oConcelho[0]);

        }, json());

        get("/moradas", (req, res) -> {
            Map<String, String[]> params = req.queryMap().toMap();

            if (params.isEmpty()) {
                return userService.getAllCodigos();
            }

            if (params.size() > 2) {
                res.status(501);
                return new ResponseError("Erro. Parâmetros válidos: [ codPostal4 [ codPostal3 ] ]");
            }

            Set<Map.Entry<String, String[]>> conjunto = params.entrySet();
            if (params.size() >= 1) {
                if (invalidParameters(conjunto, Arrays.asList("codPostal4", "codPostal3"))) {
                    res.status(404);
                    return new ResponseError("Erro. Parâmetros válidos: [ codPostal4 [ codPostal3 ] ]");
                }
            }

            String[] oDistrito = params.getOrDefault("codPostal4", new String[]{"%"});
            String[] oConcelho = params.getOrDefault("codPostal3", new String[]{"%"});

            return userService.getCodigo(oDistrito[0], oConcelho[0]);

        }, json());

        get("/codigos", (req, res) -> {
            Map<String, String[]> params = req.queryMap().toMap();

            if (params.isEmpty()) {
                return userService.getAllCodigos();
            }

            if (params.size() > 6) {
                res.status(501);
                return new ResponseError("Erro. Parâmetros inválidos são: "
                            + "[ designacaoDistrito | designacaoConcelho | designacaoConcelho | "
                            + "codPostal4 | codPostal3 | localidade | arruamento ]");
            }

            Set<Map.Entry<String, String[]>> conjunto = params.entrySet();
            if (params.size() >= 1) {
                if (invalidParameters(conjunto, Arrays.asList("designacaoDistrito", "designacaoConcelho",
                        "codPostal4", "codPostal3", "localidade", "arruamento"))) {
                    res.status(404);
                    return new ResponseError("Erro. Parâmetros inválidos são: "
                            + "[ designacaoDistrito | designacaoConcelho | designacaoConcelho | "
                            + "codPostal4 | codPostal3 | localidade | arruamento ]");
                }
            }

            String[] oDistrito = params.getOrDefault("designacaoDistrito", new String[]{"%"});
            String[] oConcelho = params.getOrDefault("designacaoConcelho", new String[]{"%"});
            String[] oCodPostal4 = params.getOrDefault("codPostal4", new String[]{"%"});
            String[] oCodPostal3 = params.getOrDefault("codPostal3", new String[]{"%"});
            String[] aLocalidade = params.getOrDefault("localidade", new String[]{"%"});
            String[] oArruamento = params.getOrDefault("arruamento", new String[]{"%"});

            return userService.getCodigo(oDistrito[0], oConcelho[0], oCodPostal4[0], oCodPostal3[0], aLocalidade[0], oArruamento[0]);

        }, json());

        after((req, res) -> {
            res.type("application/json");
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(toJson(new ResponseError(e)));
        });

    }

    private boolean invalidParameters(Set<Map.Entry<String, String[]>> conjunto, List<String> parameters) {
        for (Map.Entry<String, String[]> chave : conjunto) {
            if (!parameters.contains(chave.getKey())) {
                return true;
            }
        }
        return false;
    }
}
