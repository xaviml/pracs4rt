/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
 
import controller.player.OnImageListener;
import controller.compressor.CompressorController;
import controller.player.IPlayer;
import controller.filter.FilterController;
import controller.filter.IFilter;
import controller.disk.IDisk;
import controller.disk.DiskController;
import model.config.Config;
import model.config.DirectionType;
import model.FilterDim3;
import model.Imatge;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipFile;

/**
 *
 * @author albert
 */
public class MainController implements IPlayer, IFilter, IDisk {

    private ArrayList<Imatge> images,imagesCopia;
    private OnImageListener listener;
    private ScheduledExecutorService executor;
    private int index, time;
    private DirectionType dir;
    private CompressorController compressor;
    private DiskController disk;
    private FilterController filter;


    public MainController(OnImageListener listener) {
        this.listener = listener;
        this.dir = Config.DEFAULT_DIRECTION;
        this.time = Config.DEFAULT_FRAME_RATE;
        this.compressor = new CompressorController();
        this.disk = new DiskController();
        this.filter = new FilterController();
        this.images = new ArrayList<>();
    }

    @Override
    public void setFrameRate(int time) {
        this.time = time;
    }

    @Override
    public void pause() {
        if (executor != null)
            executor.shutdown();
    }

    @Override
    public void play() {
        Runnable nextRunnable = new Runnable() {
            @Override
            public void run() {
                if (dir == DirectionType.FORWARD) {
                    next();
                } else {
                    previous();
                }
            }
        };

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(nextRunnable, 0, this.time, TimeUnit.MILLISECONDS);
    }

    @Override
    public void setDirection(DirectionType type) {
        this.dir = type;
    }

    @Override
    public void openZip(String path) {
        if (executor != null)
            executor.shutdown();
        ZipFile zip = disk.openZip(path);
        this.images = compressor.decompressZip(zip);
        this.imagesCopia = (ArrayList<Imatge>)this.images.clone();
    }

    @Override
    public void openImage(String path) {
        Imatge img = disk.openImage(path);
        this.images.clear();
        this.imagesCopia.clear();
        this.images.add(img);
        this.imagesCopia.add(img);
    }

    @Override
    public void saveImage(String path) {
        disk.saveImage(path, this.images.get(0));
    }

    @Override
    public void saveZip(String path) {
        disk.saveZip(path, images);
    }

    @Override
    public void saveGZip(String path) {
        disk.saveGZip(path, images);
    }

    @Override
    public void first() {
        index = 0;
        if (listener != null) {
            listener.onImage(images.get(index));
        }
    }

    @Override
    public void next() {
        index++;
        if (index == images.size() || index < 0) {
            index = 0;
        }

        if (listener != null) {
            listener.onImage(images.get(index));
        }

    }

    @Override
    public void previous() {
        index--;
        if (index == images.size() || index < 0) {
            index = images.size() - 1;
        }
        if (listener != null) {
            listener.onImage(images.get(index));
        }
        
        
    }
    
    @Override
    public void removeFilter(){
        this.images = this.imagesCopia;
    }
    
    @Override
    public void applyFilter(FilterDim3 filter) {
        this.filter.convolveImages(images, filter);
    }

    @Override
    public void negativeFilter() {
        this.filter.negativeFilter(images);
    }

    @Override
    public void binaryFilter(int threshold) {
        this.filter.binaryFilter(images, threshold);
    }

    @Override
    public void changeHSB(float hue, float saturation, float brightness) {
        this.filter.changeHSB(images, hue, saturation, brightness);
    }

    @Override
    public float getHue() {
        return this.filter.getHue(images.get(index));
    }

    @Override
    public float getSaturation() {
        return this.filter.getSaturation(images.get(index));
    }

    @Override
    public float getBrightness() {
        return this.filter.getBrightness(images.get(index));
    }

    @Override
    public int getThreshold() {
        return this.filter.getThreshold() == -1 ? Config.DEFAULT_THRESHOLD : this.filter.getThreshold();
    }

    @Override
    public FilterDim3 getFilterDim3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void isPlaying() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFrameRate() {
        return this.time;
    }

    @Override
    public DirectionType getDirection() {
        return this.dir;
    }
}