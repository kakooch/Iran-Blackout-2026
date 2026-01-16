package io.antmedia.android.broadcaster;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes.dex */
public class CameraProxy {
    private Camera _camera;
    private final CameraHandler _handler;
    private volatile Camera.Parameters _parameters;
    private final ConditionVariable _signal;
    private final HandlerThread ht;
    private boolean released;

    public CameraProxy(int cameraId) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this._signal = conditionVariable;
        this.released = false;
        HandlerThread handlerThread = new HandlerThread("Camera Proxy Thread");
        this.ht = handlerThread;
        handlerThread.start();
        CameraHandler cameraHandler = new CameraHandler(handlerThread.getLooper());
        this._handler = cameraHandler;
        conditionVariable.close();
        cameraHandler.obtainMessage(12, cameraId, 0).sendToTarget();
        conditionVariable.block();
        if (this._camera != null) {
            cameraHandler.obtainMessage(8, new ErrorCallback()).sendToTarget();
        }
    }

    public boolean isCameraAvailable() {
        return (this._camera == null || isReleased()) ? false : true;
    }

    public void release() {
        this.released = true;
        this._signal.close();
        this._handler.sendEmptyMessage(1);
        this._signal.block();
        this.ht.quitSafely();
    }

    public Camera.Parameters getParameters() {
        return this._parameters;
    }

    public void setParameters(Camera.Parameters parameters) {
        this._parameters = parameters;
        this._handler.obtainMessage(5, parameters).sendToTarget();
    }

    public void startPreview() {
        this._handler.sendEmptyMessage(10);
    }

    public void stopPreview() {
        this._signal.close();
        this._handler.sendEmptyMessage(11);
        this._signal.block();
    }

    public void setDisplayOrientation(int displayOrientation) {
        this._handler.obtainMessage(13, displayOrientation, 0).sendToTarget();
    }

    public void setPreviewTexture(SurfaceTexture previewTexture) {
        this._handler.obtainMessage(14, previewTexture).sendToTarget();
    }

    public boolean isReleased() {
        return this.released;
    }

    private class CameraHandler extends Handler {
        public CameraHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(final Message msg) throws IOException {
            try {
                switch (msg.what) {
                    case 1:
                        CameraProxy.this._camera.release();
                        break;
                    case 2:
                        CameraProxy.this._camera.autoFocus((Camera.AutoFocusCallback) msg.obj);
                        break;
                    case 3:
                        CameraProxy.this._camera.cancelAutoFocus();
                        break;
                    case 4:
                    default:
                        Log.e("CameraProxy", "Invalid message: " + msg.what);
                        break;
                    case 5:
                        CameraProxy.this._camera.setParameters((Camera.Parameters) msg.obj);
                        break;
                    case 6:
                        CameraProxy.this._camera.startSmoothZoom(msg.arg1);
                        break;
                    case 7:
                        CameraProxy.this._camera.addCallbackBuffer((byte[]) msg.obj);
                        break;
                    case 8:
                        CameraProxy.this._camera.setErrorCallback((Camera.ErrorCallback) msg.obj);
                        break;
                    case 9:
                        CameraProxy.this._camera.setPreviewDisplay((SurfaceHolder) msg.obj);
                        break;
                    case 10:
                        CameraProxy.this._camera.startPreview();
                        break;
                    case 11:
                        CameraProxy.this._camera.stopPreview();
                        break;
                    case 12:
                        CameraProxy.this._camera = Camera.open(msg.arg1);
                        CameraProxy cameraProxy = CameraProxy.this;
                        cameraProxy._parameters = cameraProxy._camera.getParameters();
                        break;
                    case 13:
                        CameraProxy.this._camera.setDisplayOrientation(msg.arg1);
                        break;
                    case 14:
                        CameraProxy.this._camera.setPreviewTexture((SurfaceTexture) msg.obj);
                        break;
                }
            } catch (IOException e) {
                handleException(msg, new RuntimeException(e.getMessage(), e));
            } catch (RuntimeException e2) {
                handleException(msg, e2);
            }
            CameraProxy.this._signal.open();
        }

        private void handleException(Message msg, RuntimeException e) {
            Log.e("CameraProxy", "Camera operation failed", e);
            if (msg.what == 1 || CameraProxy.this._camera == null) {
                return;
            }
            try {
                CameraProxy.this.released = true;
                CameraProxy.this._camera.release();
            } catch (Exception unused) {
                Log.e("CameraProxy", "Failed to release camera on error", e);
            }
        }
    }

    private static class ErrorCallback implements Camera.ErrorCallback {
        private ErrorCallback() {
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int error, Camera camera) {
            Log.e("CameraProxy", "Got camera error callback. error=" + error);
        }
    }
}
