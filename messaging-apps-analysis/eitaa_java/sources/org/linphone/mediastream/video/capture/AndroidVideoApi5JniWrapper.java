package org.linphone.mediastream.video.capture;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import ir.eitaa.tgnet.ConnectionsManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.mediastream.video.AndroidVideoWindowImpl;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;

/* loaded from: classes3.dex */
public class AndroidVideoApi5JniWrapper {
    public static boolean isRecording = false;

    public static native void putImage(long j, byte[] bArr);

    public static int detectCamerasCount() {
        return AndroidCameraConfiguration.retrieveCameras().length;
    }

    public static int detectCameras(int[] iArr, int[] iArr2, int[] iArr3) {
        Log.d("detectCameras\n");
        int i = 0;
        for (AndroidCameraConfiguration.AndroidCamera androidCamera : AndroidCameraConfiguration.retrieveCameras()) {
            if (i >= iArr.length || i >= iArr2.length || i >= iArr3.length) {
                Log.w("Returning only the " + i + " first cameras (increase buffer size to retrieve all)");
                break;
            }
            iArr[i] = androidCamera.id;
            iArr2[i] = androidCamera.frontFacing ? 1 : 0;
            iArr3[i] = androidCamera.orientation;
            i++;
        }
        return i;
    }

    public static int[] selectNearestResolutionAvailable(int i, int i2, int i3) {
        Log.d("mediastreamer", "selectNearestResolutionAvailable: " + i + ", " + i2 + "x" + i3);
        return selectNearestResolutionAvailableForCamera(i, i2, i3);
    }

    public static void activateAutoFocus(Object obj) {
        Log.d("mediastreamer", "Turning on autofocus on camera " + obj);
        Camera camera = (Camera) obj;
        if (camera != null) {
            if (camera.getParameters().getFocusMode() == "auto" || camera.getParameters().getFocusMode() == "macro") {
                camera.autoFocus(null);
            }
        }
    }

    public static Object startRecording(int i, int i2, int i3, int i4, int i5, final long j) {
        Log.d("mediastreamer", "startRecording(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + j + ")");
        Camera cameraOpen = Camera.open();
        applyCameraParameters(cameraOpen, i2, i3, i4);
        cameraOpen.setPreviewCallback(new Camera.PreviewCallback() { // from class: org.linphone.mediastream.video.capture.AndroidVideoApi5JniWrapper.1
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                if (AndroidVideoApi5JniWrapper.isRecording) {
                    AndroidVideoApi5JniWrapper.putImage(j, bArr);
                }
            }
        });
        cameraOpen.startPreview();
        isRecording = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Returning camera object: ");
        sb.append(cameraOpen);
        Log.d("mediastreamer", sb.toString());
        return cameraOpen;
    }

    public static void stopRecording(Object obj) {
        isRecording = false;
        Log.d("mediastreamer", "stopRecording(" + obj + ")");
        Camera camera = (Camera) obj;
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            return;
        }
        Log.i("mediastreamer", "Cannot stop recording ('camera' is null)");
    }

    public static void setPreviewDisplaySurface(Object obj, Object obj2) throws IOException {
        Log.d("mediastreamer", "setPreviewDisplaySurface(" + obj + ", " + obj2 + ")");
        Camera camera = (Camera) obj;
        try {
            if (obj2 instanceof SurfaceView) {
                camera.setPreviewDisplay(((SurfaceView) obj2).getHolder());
            } else if ((obj2 instanceof TextureView) && ((TextureView) obj2).isAvailable()) {
                camera.setPreviewTexture(((TextureView) obj2).getSurfaceTexture());
            } else if (obj2 instanceof SurfaceTexture) {
                camera.setPreviewTexture((SurfaceTexture) obj2);
            } else if (obj2 instanceof Surface) {
                camera.setPreviewDisplay(new SimpleSurfaceHolder((Surface) obj2));
            } else {
                camera.setPreviewDisplay(((AndroidVideoWindowImpl) obj2).getPreviewSurfaceView().getHolder());
            }
        } catch (Exception e) {
            Log.e(e);
            e.printStackTrace();
        }
    }

    protected static int[] selectNearestResolutionAvailableForCamera(int i, int i2, int i3) {
        int i4;
        AndroidCameraConfiguration.AndroidCamera.Size size;
        int i5;
        int i6 = i2;
        int i7 = i3;
        if (i7 > i6) {
            i7 = i6;
            i6 = i7;
        }
        List<AndroidCameraConfiguration.AndroidCamera.Size> list = null;
        for (AndroidCameraConfiguration.AndroidCamera androidCamera : AndroidCameraConfiguration.retrieveCameras()) {
            if (androidCamera.id == i) {
                list = androidCamera.resolutions;
            }
        }
        if (list == null) {
            Log.e("mediastreamer", "Failed to retrieve supported resolutions.");
            return null;
        }
        Log.i("mediastreamer", list.size() + " supported resolutions :");
        for (AndroidCameraConfiguration.AndroidCamera.Size size2 : list) {
            Log.i("mediastreamer", "\t" + size2.width + "x" + size2.height);
        }
        int iMax = Math.max(i6, i7);
        int iMin = Math.min(i6, i7);
        int i8 = iMax * iMin;
        try {
            Iterator<AndroidCameraConfiguration.AndroidCamera.Size> it = list.iterator();
            size = null;
            int i9 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AndroidCameraConfiguration.AndroidCamera.Size next = it.next();
                int i10 = next.width;
                int i11 = next.height;
                int i12 = (i8 - (i10 * i11)) * (-1);
                if (((i10 >= iMax && i11 >= iMin) || (i10 >= iMin && i11 >= iMax)) && i12 < i9) {
                    i9 = i12;
                    size = next;
                    i5 = 0;
                }
                int i13 = (i8 - ((i10 * i11) / 4)) * (-1);
                if (((i10 / 2 >= iMax && i11 / 2 >= iMin) || (i10 / 2 >= iMin && i11 / 2 >= iMax)) && i13 < i9) {
                    if (Version.hasFastCpuWithAsmOptim()) {
                        i9 = i13;
                        size = next;
                        i5 = 1;
                    } else {
                        size = next;
                        i5 = 0;
                    }
                }
                if (next.width == iMax && next.height == iMin) {
                    size = next;
                    i5 = 0;
                    break;
                }
            }
            if (size == null) {
                int i14 = ConnectionsManager.DEFAULT_DATACENTER_ID;
                for (AndroidCameraConfiguration.AndroidCamera.Size size3 : list) {
                    int i15 = size3.width;
                    int i16 = size3.height;
                    int i17 = (i8 - (i15 * i16)) * (-1);
                    if (i15 * i16 > i8 && i17 < i14) {
                        size = size3;
                        i14 = i17;
                    }
                }
            }
            if (size == null) {
                size = list.get(0);
            }
            i4 = 3;
        } catch (Exception e) {
            e = e;
            i4 = 3;
        }
        try {
            int[] iArr = new int[3];
            iArr[0] = size.width;
            iArr[1] = size.height;
            iArr[2] = i5;
            Log.i("mediastreamer", "resolution selection done (" + iArr[0] + ", " + iArr[1] + ", " + iArr[2] + ")");
            return iArr;
        } catch (Exception e2) {
            e = e2;
            Object[] objArr = new Object[i4];
            objArr[0] = e;
            objArr[1] = "mediastreamer";
            objArr[2] = " resolution selection failed";
            Log.e(objArr);
            return null;
        }
    }

    protected static void applyCameraParameters(Camera camera, int i, int i2, int i3) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(i, i2);
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null) {
            int i4 = ConnectionsManager.DEFAULT_DATACENTER_ID;
            for (Integer num : supportedPreviewFrameRates) {
                int iAbs = Math.abs(num.intValue() - i3);
                if (iAbs < i4) {
                    parameters.setPreviewFrameRate(num.intValue());
                    i4 = iAbs;
                }
            }
            Log.d("mediastreamer", "Preview framerate set:" + parameters.getPreviewFrameRate());
        }
        camera.setParameters(parameters);
    }

    private static class SimpleSurfaceHolder implements SurfaceHolder {
        private Surface mSurface;

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return false;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect rect) {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i, int i2) {
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int i) {
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z) {
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
        }

        @Override // android.view.SurfaceHolder
        public void setType(int i) {
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
        }

        public SimpleSurfaceHolder(Surface surface) {
            this.mSurface = surface;
        }

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            return this.mSurface;
        }
    }
}
