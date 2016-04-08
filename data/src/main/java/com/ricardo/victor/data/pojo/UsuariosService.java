package com.ricardo.victor.data.pojo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UsuariosService implements Serializable {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("usuario")
    @Expose
    private Usuarios usuario;

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The usuario
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     * The usuario
     */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

}