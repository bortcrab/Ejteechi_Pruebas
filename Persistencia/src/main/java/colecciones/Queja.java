package colecciones;

import org.bson.types.ObjectId;
import java.util.Date;

public class Queja {
    private ObjectId _id;
    private String tipo;
    private Date fecha;
    private String comentario;
    private boolean anonimo;
    private boolean leido;
    private ObjectId idCliente;

    public Queja() {
    }

    public Queja(ObjectId _id) {
        this._id = _id;
    }
    
    public Queja(ObjectId id, String tipo, Date fecha, String comentario, boolean anonimo, boolean leido, ObjectId idCliente) {
        this._id = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.comentario = comentario;
        this.anonimo = anonimo;
        this.leido = leido;
        this.idCliente = idCliente;
    }

    public Queja(String tipo) {
        this.tipo = tipo;
    }
    
    

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public ObjectId getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ObjectId idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Queja{" + "_id=" + _id + ", tipo=" + tipo + ", fecha=" + fecha + ", comentario=" + comentario + ", anonimo=" + anonimo + ", leido=" + leido + ", idCliente=" + idCliente + '}';
    }

    
   
}
