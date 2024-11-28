package com.minhkakart.ninjaschool.game.managers;

import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.interfaces.InputListener;
import com.minhkakart.ninjaschool.game.layers.GameLayer;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class LayerManager {
    private static final ArrayList<GameLayer> layers = new ArrayList<>();

    private static final Object lock = new Object();

    public static void addLayer(GameLayer... layers) {
        synchronized (lock) {
            LayerManager.layers.addAll(Arrays.asList(layers));
            LayerManager.layers.sort(GameLayer::compareTo);
        }
    }

    public static ArrayList<GameLayer> getLayers() {
        synchronized (lock) {
            return LayerManager.layers;
        }
    }

    public static GameLayer getLayer(LayerDepth layerDepth) {
        synchronized (lock) {
            for (GameLayer layer : LayerManager.layers) {
                if (layer.getName().equals(layerDepth.getName())) {
                    return layer;
                }
            }
            return null;
        }
    }

    public static void removeLayer(GameLayer layer) {
        synchronized (lock) {
            LayerManager.layers.remove(layer);
        }
    }

    public static InputListener getActiveListener() {
        synchronized (lock) {
            if (!layers.isEmpty()) {
                return layers.get(layers.size() - 1);
            } else {
                return GameLayer.getInstance();
            }
        }
    }

}
