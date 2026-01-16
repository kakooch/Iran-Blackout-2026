package me.dm7.barcodescanner.core;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import ir.nasim.C17003mE0;
import ir.nasim.EV1;
import java.io.IOException;
import java.util.List;

/* loaded from: classes8.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private C17003mE0 a;
    private Handler b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private Camera.PreviewCallback g;
    private float h;
    private Runnable i;
    Camera.AutoFocusCallback j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraPreview.this.a != null && CameraPreview.this.c && CameraPreview.this.d && CameraPreview.this.e) {
                CameraPreview.this.i();
            }
        }
    }

    class b implements Camera.AutoFocusCallback {
        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            CameraPreview.this.j();
        }
    }

    public CameraPreview(Context context, C17003mE0 c17003mE0, Camera.PreviewCallback previewCallback) {
        super(context);
        this.c = true;
        this.d = true;
        this.e = false;
        this.f = true;
        this.h = 0.1f;
        this.i = new a();
        this.j = new b();
        h(c17003mE0, previewCallback);
    }

    private void f(Camera.Size size) {
        Point pointG = g(new Point(getWidth(), getHeight()));
        float f = size.width / size.height;
        int i = pointG.x;
        int i2 = pointG.y;
        if (i / i2 > f) {
            k((int) (i2 * f), i2);
        } else {
            k(i, (int) (i / f));
        }
    }

    private Point g(Point point) {
        return getDisplayOrientation() % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER == 0 ? point : new Point(point.y, point.x);
    }

    private Camera.Size getOptimalPreviewSize() {
        C17003mE0 c17003mE0 = this.a;
        Camera.Size size = null;
        if (c17003mE0 == null) {
            return null;
        }
        List<Camera.Size> supportedPreviewSizes = c17003mE0.a.getParameters().getSupportedPreviewSizes();
        int width = getWidth();
        int height = getHeight();
        if (EV1.a(getContext()) == 1) {
            height = width;
            width = height;
        }
        double d = width / height;
        if (supportedPreviewSizes == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : supportedPreviewSizes) {
            if (Math.abs((size2.width / size2.height) - d) <= this.h && Math.abs(size2.height - height) < dAbs2) {
                dAbs2 = Math.abs(size2.height - height);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : supportedPreviewSizes) {
                if (Math.abs(size3.height - height) < dAbs) {
                    size = size3;
                    dAbs = Math.abs(size3.height - height);
                }
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.b.postDelayed(this.i, 1000L);
    }

    private void k(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (getDisplayOrientation() % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER != 0) {
            i2 = i;
            i = i2;
        }
        if (this.f) {
            float f = i;
            float width = ((View) getParent()).getWidth() / f;
            float f2 = i2;
            float height = ((View) getParent()).getHeight() / f2;
            if (width <= height) {
                width = height;
            }
            i = Math.round(f * width);
            i2 = Math.round(f2 * width);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getDisplayOrientation() {
        int i = 0;
        if (this.a == null) {
            return 0;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = this.a.b;
        if (i2 == -1) {
            Camera.getCameraInfo(0, cameraInfo);
        } else {
            Camera.getCameraInfo(i2, cameraInfo);
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
    }

    public void h(C17003mE0 c17003mE0, Camera.PreviewCallback previewCallback) {
        setCamera(c17003mE0, previewCallback);
        this.b = new Handler();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void i() {
        try {
            this.a.a.autoFocus(this.j);
        } catch (RuntimeException unused) {
            j();
        }
    }

    public void l() throws IOException {
        if (this.a != null) {
            try {
                getHolder().addCallback(this);
                this.c = true;
                setupCameraParameters();
                this.a.a.setPreviewDisplay(getHolder());
                this.a.a.setDisplayOrientation(getDisplayOrientation());
                this.a.a.setOneShotPreviewCallback(this.g);
                this.a.a.startPreview();
                if (this.d) {
                    if (this.e) {
                        i();
                    } else {
                        j();
                    }
                }
            } catch (Exception e) {
                Log.e("CameraPreview", e.toString(), e);
            }
        }
    }

    public void m() {
        if (this.a != null) {
            try {
                this.c = false;
                getHolder().removeCallback(this);
                this.a.a.cancelAutoFocus();
                this.a.a.setOneShotPreviewCallback(null);
                this.a.a.stopPreview();
            } catch (Exception e) {
                Log.e("CameraPreview", e.toString(), e);
            }
        }
    }

    public void setAspectTolerance(float f) {
        this.h = f;
    }

    public void setAutoFocus(boolean z) {
        if (this.a == null || !this.c || z == this.d) {
            return;
        }
        this.d = z;
        if (!z) {
            Log.v("CameraPreview", "Cancelling autofocus");
            this.a.a.cancelAutoFocus();
        } else if (!this.e) {
            j();
        } else {
            Log.v("CameraPreview", "Starting autofocus");
            i();
        }
    }

    public void setCamera(C17003mE0 c17003mE0, Camera.PreviewCallback previewCallback) {
        this.a = c17003mE0;
        this.g = previewCallback;
    }

    public void setShouldScaleToFill(boolean z) {
        this.f = z;
    }

    public void setupCameraParameters() {
        Camera.Size optimalPreviewSize = getOptimalPreviewSize();
        Camera.Parameters parameters = this.a.a.getParameters();
        parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        this.a.a.setParameters(parameters);
        f(optimalPreviewSize);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) throws IOException {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        m();
        l();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.e = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e = false;
        m();
    }
}
