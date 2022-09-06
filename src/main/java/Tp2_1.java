import entity.*;

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

        registro.registrar(lote);
        registro.emitirBoletos();
        registro.valuar(lote);
        System.out.printf("Registro de lote: %s%n", lote.getInscripto());
        System.out.printf("Lotes registrados: %s%n", registro.getInmuebles());
        System.out.printf("Escrituras: %s%n", registro.getEscrituras());
        Edificio edificio = lote.construir(new Casa(23.4f, Boolean.TRUE, 75));
        System.out.printf("Lote construido: %s%n", lote);
        System.out.printf("Edificio: %s%n", edificio);
        System.out.printf("Avaluo edificio: $ %.2f%n", edificio.valuar());
        try {
            Edificio edificio2 = lote.construir(new PH(26f, (byte) 1, new ArrayList<>()));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        edificio = edificio.demoler();
        System.out.printf("Edificio demolido: %s%n", edificio == null ? "OK" : "ERROR");

        System.out.println("Se guarda el registro de las escrituras");
        registro.guardar();
        System.out.println("Se lee el registro de las escrituras");
        registro.recuperar();
    }
}
