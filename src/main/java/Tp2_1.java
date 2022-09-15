import entity.*;
import exception.ErrorLote;

import java.util.ArrayList;

public class Tp2_1 {
    public static void main(String[] args) {
        Registro registro = Registro.builder()
                .coefAvaluoEdificio(156.23f)
                .municipio("Lujan de Cuyo")
                .tasa(24.23f)
                .build();

        Lote lote = Lote.builder()
                .domicilio("San Martin")
                .avaluoxmt(20.5f)
                .idPadron(1)
                .superficie(153)
                .build();

        Lote lote2 = Lote.builder()
                .domicilio("Lujan")
                .avaluoxmt(18.2f)
                .idPadron(2)
                .superficie(200)
                .build();

        registro.registrar(lote);
        registro.registrar(lote2);
        registro.emitirBoletos();
        registro.valuar(lote);
        registro.valuar(lote2);
        System.out.printf("Registro de lote 1: %s%n", lote.getInscripto());
        System.out.printf("Registro de lote 2: %s%n", lote2.getInscripto());
        System.out.printf("Lotes registrados: %s%n", registro.getInmuebles());
        System.out.printf("Escrituras: %s%n", registro.getEscrituras());
        Edificio edificio = lote.construir(new Casa(23.4f, Boolean.TRUE, 75));
        Edificio edificio2 = lote2.construir(new PH(26f, (byte) 1, new ArrayList<>()));
        System.out.printf("Lote 1 construido: %s%n", lote);
        System.out.printf("Lote 2 construido: %s%n", lote2);
        System.out.printf("Edificio 1: %s%n", edificio);
        System.out.printf("Edificio 2: %s%n", edificio2);
        System.out.printf("Avaluo edificio 1: $ %.2f%n", edificio.valuar());
        System.out.printf("Avaluo edificio 2: $ %.2f%n", edificio2.valuar());
        try {
            Edificio edificio3 = lote.construir(new PH(26f, (byte) 1, new ArrayList<>()));
        } catch (ErrorLote ex) {
            System.out.println(ex.getMessage());
        }
        edificio = edificio.demoler();
        edificio2 = edificio2.demoler();
        System.out.printf("Edificio 1 demolido: %s%n", edificio == null ? "OK" : "ERROR");
        System.out.printf("Edificio 2 demolido: %s%n", edificio2 == null ? "OK" : "ERROR");

        System.out.println("Se guarda el registro de las escrituras");
        registro.guardar();
        System.out.println("Se lee el registro de las escrituras");
        registro.recuperar();
    }
}
