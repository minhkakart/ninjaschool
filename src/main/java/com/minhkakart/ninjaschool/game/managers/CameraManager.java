package com.minhkakart.ninjaschool.game.managers;

import com.minhkakart.ninjaschool.game.models.Camera;

public class CameraManager {
    private static final Camera DEFAULT_CAMERA = new Camera();
    
    public static Camera getDefaultCamera() {
        return DEFAULT_CAMERA;
    }
}
