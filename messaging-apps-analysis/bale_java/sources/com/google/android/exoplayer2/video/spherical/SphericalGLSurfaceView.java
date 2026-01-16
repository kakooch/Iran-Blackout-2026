package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.b;
import com.google.android.exoplayer2.video.spherical.h;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC19509qT7;
import ir.nasim.InterfaceC21161tD0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {
    public static final /* synthetic */ int m = 0;
    private final CopyOnWriteArrayList a;
    private final SensorManager b;
    private final Sensor c;
    private final com.google.android.exoplayer2.video.spherical.b d;
    private final Handler e;
    private final h f;
    private final g g;
    private SurfaceTexture h;
    private Surface i;
    private boolean j;
    private boolean k;
    private boolean l;

    final class a implements GLSurfaceView.Renderer, h.a, b.a {
        private final g a;
        private final float[] d;
        private final float[] e;
        private final float[] f;
        private float g;
        private float h;
        private final float[] b = new float[16];
        private final float[] c = new float[16];
        private final float[] i = new float[16];
        private final float[] j = new float[16];

        public a(g gVar) {
            float[] fArr = new float[16];
            this.d = fArr;
            float[] fArr2 = new float[16];
            this.e = fArr2;
            float[] fArr3 = new float[16];
            this.f = fArr3;
            this.a = gVar;
            GlUtil.j(fArr);
            GlUtil.j(fArr2);
            GlUtil.j(fArr3);
            this.h = 3.1415927f;
        }

        private float c(float f) {
            if (f > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f)) * 2.0d);
            }
            return 90.0f;
        }

        private void d() {
            Matrix.setRotateM(this.e, 0, -this.g, (float) Math.cos(this.h), (float) Math.sin(this.h), 0.0f);
        }

        @Override // com.google.android.exoplayer2.video.spherical.b.a
        public synchronized void a(float[] fArr, float f) {
            float[] fArr2 = this.d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.h = -f;
            d();
        }

        @Override // com.google.android.exoplayer2.video.spherical.h.a
        public synchronized void b(PointF pointF) {
            this.g = pointF.y;
            d();
            Matrix.setRotateM(this.f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.j, 0, this.d, 0, this.f, 0);
                Matrix.multiplyMM(this.i, 0, this.e, 0, this.j, 0);
            }
            Matrix.multiplyMM(this.c, 0, this.b, 0, this.i, 0);
            this.a.e(this.c, false);
        }

        @Override // com.google.android.exoplayer2.video.spherical.h.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.b, 0, c(f), f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.g(this.a.f());
        }
    }

    public interface b {
        void h(Surface surface);

        void k(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        Surface surface = this.i;
        if (surface != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).h(surface);
            }
        }
        h(this.h, surface);
        this.h = null;
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.h;
        Surface surface = this.i;
        Surface surface2 = new Surface(surfaceTexture);
        this.h = surfaceTexture;
        this.i = surface2;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).k(surface2);
        }
        h(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final SurfaceTexture surfaceTexture) {
        this.e.post(new Runnable() { // from class: ir.nasim.AI6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(surfaceTexture);
            }
        });
    }

    private static void h(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void j() {
        boolean z = this.j && this.k;
        Sensor sensor = this.c;
        if (sensor == null || z == this.l) {
            return;
        }
        if (z) {
            this.b.registerListener(this.d, sensor, 0);
        } else {
            this.b.unregisterListener(this.d);
        }
        this.l = z;
    }

    public void d(b bVar) {
        this.a.add(bVar);
    }

    public InterfaceC21161tD0 getCameraMotionListener() {
        return this.g;
    }

    public InterfaceC19509qT7 getVideoFrameMetadataListener() {
        return this.g;
    }

    public Surface getVideoSurface() {
        return this.i;
    }

    public void i(b bVar) {
        this.a.remove(bVar);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.post(new Runnable() { // from class: ir.nasim.BI6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.k = false;
        j();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.k = true;
        j();
    }

    public void setDefaultStereoMode(int i) {
        this.g.h(i);
    }

    public void setUseSensorRotation(boolean z) {
        this.j = z;
        j();
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new CopyOnWriteArrayList();
        this.e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) AbstractC20011rK.e(context.getSystemService("sensor"));
        this.b = sensorManager;
        Sensor defaultSensor = AbstractC9683aN7.a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g();
        this.g = gVar;
        a aVar = new a(gVar);
        h hVar = new h(context, aVar, 25.0f);
        this.f = hVar;
        this.d = new com.google.android.exoplayer2.video.spherical.b(((WindowManager) AbstractC20011rK.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), hVar, aVar);
        this.j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(hVar);
    }
}
