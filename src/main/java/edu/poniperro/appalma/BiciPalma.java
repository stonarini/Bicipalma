package edu.poniperro.appalma;

import edu.poniperro.domain.bicicleta.Bicicleta;
import edu.poniperro.domain.estacion.Estacion;
import edu.poniperro.domain.tarjetausuario.TarjetaUsuario;

public class BiciPalma {

    public static void main(String[] args) {

        Estacion estacion = new Estacion(1, "Manacor", 6);

        /**
         * Historia de Usuario: visualizar estado de la estacion:
         * muestra id, direccion, anclaje
         */

        System.out.println("\n **** Historia de Usuario:  visualizar estado de la estacion **** \n");

        estacion.consultarEstacion();

        /**
         * Historia de Usuario: visualizar anclajes libres
         */

        System.out.println("\n **** Historia de Usuario:  visualizar anclajes libres **** \n");

        System.out.println("anclajesLibres: " + estacion.anclajesLibres());

        estacion.consultarAnclajes();

        /**
         * Historia de Usuario: anclar bicicleta(s)
         */

        System.out.println("\n **** Historia de Usuario:  anclar bicicleta(s) **** \n");

        int[] bicicletas = { 291, 292, 293, 294, 295, 296, 297 };

        Bicicleta bicicleta = null;
        for (int id : bicicletas) {
            bicicleta = new Bicicleta(id);
            estacion.anclarBicicleta(bicicleta);
        }

        System.out.println("anclajes libres tras generar " + bicicletas.length
                + " bicis: " + estacion.anclajesLibres());

        /**
         * Historia de Usuario: consultar bicicletas ancladas
         */

        System.out.println("\n **** Historia de Usuario:  consultar bicicletas ancladas **** \n");

        estacion.consultarAnclajes();

        /**
         * Historia de Usuario: retirar bicicleta
         */

        System.out.println("\n **** Historia de Usuario:  retirar bicicleta **** \n");

        TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("000456789", true);

        System.out.println("¿tarjeta de usuario activada? (true/false): "
                + estacion.leerTarjetaUsuario(tarjetaUsuario));

        estacion.retirarBicicleta(tarjetaUsuario);

        estacion.consultarAnclajes();

        System.out.println("anclajes libres: " + estacion.anclajesLibres());

        /**
         * Historia de Usuario: tarjeta inactiva
         */

        System.out.println("\n **** Historia de Usuario:  tarjeta inactiva **** \n");

        tarjetaUsuario.setActivada(false);

        System.out.println("¿tarjeta de usuario activada? (true/false): "
                + estacion.leerTarjetaUsuario(tarjetaUsuario));

        estacion.retirarBicicleta(tarjetaUsuario);

        estacion.consultarAnclajes();
    }
}
