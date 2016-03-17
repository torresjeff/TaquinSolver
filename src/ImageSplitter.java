
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;


public class ImageSplitter
{
    /**
     * Dividir una imagen en r filas y c columnas.
     * @param fileName nombre del archivo. El archivo debe estar guardado en la carpeta "imagenes" del proyecto. La imagen es opcional. Deben tener extension ".jpg".
     * @param r numero de filas para dividir la imagen
     * @param c numero de columnas para dividir la imagen
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void Split(String fileName, int r, int c) throws FileNotFoundException, IOException
    {
        for (int i = 1; i < 10*10; ++i)
        {
            Path path = FileSystems.getDefault().getPath("images/", i + ".jpg");
            if (Files.exists(path))
            {
                Files.delete(path);
            }
        }
        
        if (!Files.exists(FileSystems.getDefault().getPath(fileName)))
        {
            return;
        }
        
        try {
            File file = new File(/*"images/" + */fileName); // La imagen está guardada en la carpeta "images"
            FileInputStream fis = new FileInputStream(file);
            BufferedImage image = ImageIO.read(fis); //leemos el archivo de la imagen
            
            int rows = r; //Numero de filas que deseamos
            int cols = c; ////Numero de columnas que deseamos
            int chunks = rows * cols - 1;
            
            int chunkWidth = image.getWidth() / cols; // determina el tamaño del ancho
            int chunkHeight = image.getHeight() / rows; // // determina el tamaño del alto
            int count = 0;
            BufferedImage imgs[] = new BufferedImage[chunks]; //Arreglo de imagenes que guarda las subimagenes
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    if (x == rows - 1 && y == cols - 1) {
                        break;
                    } else {
                        //Guardamos cada subimagen en un indice del arreglo
                        imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                        // Dibuja la subimagen
                        Graphics2D gr = imgs[count++].createGraphics();
                        gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                        gr.dispose();
                    }
                }
            }
            System.out.println("Splitting done");

            //Escribimos las subimagenes a archivos llamados de 1 hasta n*n - 1.
            for (int i = 0; i < imgs.length; i++) {
                ImageIO.write(imgs[i], "jpg", new File("images/" + (i + 1) + ".jpg"));
            }
            System.out.println("Mini images created");
        } catch (IOException iOException) {
        }
    }
}
