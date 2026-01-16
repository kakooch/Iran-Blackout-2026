package io.antmedia.android.broadcaster;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class CameraHandler extends Handler {
    private static final String TAG = CameraHandler.class.getSimpleName();
    private WeakReference<ICameraViewer> cameraViewerWeakReference;

    public interface ICameraViewer {
        void handleSetSurfaceTexture(SurfaceTexture st);
    }

    public CameraHandler(ICameraViewer cameraViewer) {
        this.cameraViewerWeakReference = new WeakReference<>(cameraViewer);
    }

    public void invalidateHandler() {
        this.cameraViewerWeakReference.clear();
    }

    @Override // android.os.Handler
    public void handleMessage(Message inputMessage) {
        int i = inputMessage.what;
        String str = TAG;
        Log.d(str, "CameraHandler [" + this + "]: what=" + i);
        ICameraViewer iCameraViewer = this.cameraViewerWeakReference.get();
        if (iCameraViewer == null) {
            Log.w(str, "CameraHandler.handleMessage: cameraViewer is null");
        } else {
            if (i == 0) {
                iCameraViewer.handleSetSurfaceTexture((SurfaceTexture) inputMessage.obj);
                return;
            }
            throw new RuntimeException("unknown msg " + i);
        }
    }
}
