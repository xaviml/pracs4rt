/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.compressor;

import controller.MainController;
import model.Imatge;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 * Classe controladora de totes les accions relacionades amb la compressió
 *
 * @author Albert Folch i Xavi Moreno
 */
public class CompressorController implements ICompressor {

    private int GoP;
    private int size_t;
    private int pc;
    private int fq;

    /**
     * Mètode que segons un ZipFile el descomprimeix i et retorna un ArrayList
     * de Imatge
     *
     * @param zFl
     * @return
     */
    @Override
    public ArrayList<Imatge> decompressZip(ZipFile zFl) {
        ArrayList<Imatge> images = new ArrayList<>();
        try {
            Enumeration<? extends ZipEntry> entries = zFl.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                Imatge image = new Imatge();
                String imgName = entry.getName();
                image.setName(imgName);
                InputStream is = zFl.getInputStream(entry);
                ImageInputStream iis = ImageIO.createImageInputStream(is);
                BufferedImage bufImg = ImageIO.read(iis);
                image.setImage(bufImg);
                images.add(image);

            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }

    /**
     * Aquest mètode fa: Descomprimir Zip,Guardar imatges com a files a disc i
     * retorna l'arraylist de files corresponent a les imatges
     *
     * @param path
     * @param zipFile
     * @return
     */
    @Override
    public ArrayList<File> getFilesFromZip(String path, ZipFile zipFile) {
        ArrayList<File> files = new ArrayList<>();
        File outputfile;
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {

            try {
                ZipEntry entry = entries.nextElement();
                Imatge image = new Imatge();
                String imgName = entry.getName();
                image.setName(imgName);
                InputStream is = zipFile.getInputStream(entry);
                ImageInputStream iis = ImageIO.createImageInputStream(is);
                BufferedImage bufImg = ImageIO.read(iis);
                image.setImage(bufImg);
                outputfile = new File((image.getName().substring(0, image.getName().length() - 4)) + ".jpg");
                ImageIO.write(image.getImage(), "jpg", outputfile);
                files.add(outputfile);

            } catch (IOException ex) {
                Logger.getLogger(CompressorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return files;
    }

    @Override
    public FXContent compressFX(ArrayList<Imatge> imatges, int GoP, int size_t, int pc, int fq) {

        int refs = imatges.size() / GoP;
        Imatge ref = imatges.get(0);

        FXFile fxf = new FXFile(GoP, size_t);

        for (int i = 1; i < imatges.size(); i++) {
            Imatge img = imatges.get(i);
            fxf.frames.add(new HashMap<Integer, Integer[]>());
            if (i % refs == 0) {
                ref = img;
                continue;
            }
            for (int j = 0; j < img.getNumTeseles(size_t); j++) {
                Integer[] pos = searchTesela(ref, img, j, size_t,pc, fq);
                deleteTesela(img, pos, size_t);
                fxf.frames.get(i).put(j, pos);
            }
        }

        FXContent content = new FXContent(imatges, fxf);

        return content;
    }

    @Override
    public ArrayList<Imatge> decompressFX(FXContent content) {

        return null;
    }

    private Integer[] searchTesela(Imatge src, Imatge dest, int tesela, int size_t,int pc, int fq) {
        int width = src.getImage().getWidth();
        int height = src.getImage().getHeight();
        
        for (int i = 0; i < src.getNumTeseles(size_t); i++) {
            Integer[] pos = src.getPosTesela(i, size_t);//pos[0]=x,columnes   pos[1]=y,files
            BufferedImage subimatge = src.getImage().getSubimage(pos[0].intValue(), pos[1].intValue(), size_t, size_t);
            int initColumna = pos[0]-pc < 0? 0:pos[0]-pc;
            int initFila = pos[1]-pc < 0? 0:pos[1]-pc;
            int fiColumna = pos[0]+pc >= width? width-1:pos[0]+pc;
            int fiFila = pos[1]+pc >= height? height-1:pos[1]+pc;
            
            
            

        }

        return null;
    }

    private void deleteTesela(Imatge img, Integer[] pos, int size_t) {

    }

    public int getGoP() {
        return GoP;
    }

    public void setGoP(int GoP) {
        this.GoP = GoP;
    }

    public int getSize_t() {
        return size_t;
    }

    public void setSize_t(int size_t) {
        this.size_t = size_t;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getFq() {
        return fq;
    }

    public void setFq(int fq) {
        this.fq = fq;
    }

}
