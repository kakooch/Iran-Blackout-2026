package com.pedro.encoder.input.video;

import android.content.Context;
import android.view.WindowManager;

/* loaded from: classes3.dex */
public class CameraHelper {
    private static final float[] verticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    public enum Facing {
        BACK,
        FRONT
    }

    public static float[] getVerticesData() {
        return verticesData;
    }

    public static int getCameraOrientation(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 180;
        }
        return 270;
    }

    public static boolean isPortrait(Context context) {
        int cameraOrientation = getCameraOrientation(context);
        return cameraOrientation == 90 || cameraOrientation == 270;
    }
}
