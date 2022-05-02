package ejerciciostema2;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Locale;

public class TransformaImagen {

    File f = null;

    public TransformaImagen(File fEnt) {
        if (fEnt.exists() && fEnt.getName().toLowerCase(Locale.ROOT).endsWith(".bmp")) {
            f = fEnt;
        } else {
            System.out.println("El archivo o lo escribiste mal o no existe");
        }

        // Control de existencia del fichero y control de la extensión .bmp (sacar

        // mensajes de error)

    }

    public void transformaNegativo() throws IOException {
        FileOutputStream fOut = new FileOutputStream("resources/" + getNombreSinExtension() + "_n.bmp");
        FileInputStream fIn = new FileInputStream(f);
        byte[] bytes = new byte[54];
        fIn.read(bytes);
        fOut.write(bytes);
        int owo = 0;
        while (owo != -1) {
            owo = fIn.read();
            fOut.write(255 - owo);
        }

        // Transformar a negativo y guardar como *_n.bmp

    }

    public void transformaOscuro() throws IOException {

        // Transformar a una imagen más oscura y guardar como *_o.bmp
        FileOutputStream fOut = new FileOutputStream("resources/" + getNombreSinExtension() + "_o.bmp");
        FileInputStream fIn = new FileInputStream(f);
        byte[] bytes = new byte[54];
        fIn.read(bytes);
        fOut.write(bytes);
        int owo = 0;
        while (owo != -1) {
            owo = fIn.read();
            fOut.write(owo / 2);
        }

    }


    public void transformaGrises() throws IOException {
        FileOutputStream fOut = new FileOutputStream("resources/" + getNombreSinExtension() + "_g.bmp");
        FileInputStream fIn = new FileInputStream(f);
        byte[] bytes = new byte[54];
        fIn.read(bytes);
        fOut.write(bytes);
        int rojo = fIn.read();
        int verde = fIn.read();
        int azul = fIn.read();
        while (rojo != -1) {
            fOut.write((rojo + azul + verde) / 3);
            fOut.write((rojo + azul + verde) / 3);
            fOut.write((rojo + azul + verde) / 3);
            rojo= fIn.read();
            verde=fIn.read();
            azul= fIn.read();

        }
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp

    }
    public void transformaBlancoNegro() throws IOException {
        FileOutputStream fOut = new FileOutputStream("resources/" + getNombreSinExtension() + "_bn.bmp");
        FileInputStream fIn = new FileInputStream(f);
        byte[] bytes = new byte[54];
        fIn.read(bytes);
        fOut.write(bytes);
        int rojo = fIn.read();
        int verde = fIn.read();
        int azul = fIn.read();
        while (rojo != -1) {
            if((rojo + azul + verde/3)>110){
                fOut.write(255);
                fOut.write(255);
                fOut.write(255);
            }else {
                fOut.write(0);
                fOut.write(0);
                fOut.write(0);
            }
            rojo= fIn.read();
            verde=fIn.read();
            azul= fIn.read();

        }
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp

    }

    private String getNombreSinExtension() {

        String[] parts = f.getName().split("\\.bmp");

        return parts[0];
    }

}