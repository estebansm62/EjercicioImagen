

package ejerciciostema2;

import java.io.File;

import java.io.IOException;

public class Ejercicio2_1 {

    public static void main(String[] args) throws IOException {

        

        File f = new File("resources/penyagolosa.bmp");

        

        TransformaImagen ti = new TransformaImagen(f);

        ti.transformaNegativo();

        ti.transformaOscuro();

        ti.transformaBlancoNegro();

        ti.transformaGrises();

    }

}

