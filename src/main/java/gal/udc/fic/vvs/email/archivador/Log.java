package gal.udc.fic.vvs.email.archivador;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import gal.udc.fic.vvs.email.correo.Correo;

public class Log extends DecoradorArchivador {
	
	private static EtmMonitor monitor = EtmManager.getEtmMonitor();

    public Log(Archivador decorado) {
        super(decorado);
    }

    public boolean almacenarCorreo(Correo correo) {
    	EtmPoint point = monitor.createPoint("Log:almacenarCorreo");
        boolean resultado = super.almacenarCorreo(correo);
        System.out.println("Mensaxe de log");
        point.collect();
        return resultado;
    }

}
