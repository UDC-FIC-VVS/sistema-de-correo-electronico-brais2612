package gal.udc.fic.vvs.email.archivador;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.correo.Correo;

public abstract class DecoradorArchivador implements Archivador {
	
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

    public DecoradorArchivador(Archivador decorado) {
        _decorado = decorado;
    }

    public String obtenerNombre() {
    	EtmPoint point = monitor.createPoint("DecoradorArchivador:obtenerNombre");
    	point.collect();
        return _decorado.obtenerNombre();
    }

    public boolean almacenarCorreo(Correo correo) {
    	EtmPoint point = monitor.createPoint("DecoradorArchivador:almacenarCorreo");
    	point.collect();
        return _decorado.almacenarCorreo(correo);
    }

    public int obtenerEspacioTotal() {
    	EtmPoint point = monitor.createPoint("DecoradorArchivador:obtenerEspacioTotal");
    	point.collect();
        return _decorado.obtenerEspacioTotal();
    }

    public int obtenerEspacioDisponible() {
    	EtmPoint point = monitor.createPoint("DecoradorArchivador:obtenerEspacioDisponible");
    	point.collect();
        return _decorado.obtenerEspacioDisponible();
    }

    public Archivador obtenerDelegado() {
    	EtmPoint point = monitor.createPoint("DecoradorArchivador:obtenerDelegado");
    	point.collect();
        return _decorado.obtenerDelegado();
    }

    public void establecerDelegado(Archivador archivador) {
    	EtmPoint point = monitor.createPoint("DecoradorArchivador:establecerDelegado");
    	point.collect();
        _decorado.establecerDelegado(archivador);
    }

    private Archivador _decorado;

}
