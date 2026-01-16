package ir.nasim.features.media.components;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9160Yt;
import ir.nasim.C19406qI3;
import ir.nasim.C5161Id6;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.KB5;
import ir.nasim.NZ;
import ir.nasim.components.radiobutton.view.RadioButton;
import ir.nasim.features.media.Cells.PhotoEditToolCell;
import ir.nasim.features.media.components.PhotoEditorSeekBar;
import ir.nasim.features.media.components.PhotoFilterBlurControl;
import ir.nasim.features.media.components.PhotoFilterCurvesControl;
import ir.nasim.features.media.components.RecyclerListView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes6.dex */
public class PhotoFilterView extends FrameLayout {
    private float A;
    private float A0;
    private float B;
    private int B0;
    private float C0;
    private int D;
    private CurvesToolValue D0;
    private float E0;
    private Point F0;
    private int G;
    private float G0;
    private float H;
    private float H0;
    private ToolsAdapter I0;
    private float J;
    private PhotoEditorSeekBar J0;
    private FrameLayout K0;
    private FrameLayout L0;
    private TextView M0;
    private TextView N0;
    private TextView O0;
    private TextView P0;
    private TextView Q0;
    private TextureView R0;
    private EGLThread S0;
    private RecyclerListView T0;
    private FrameLayout U0;
    private PhotoFilterBlurControl V0;
    private PhotoFilterCurvesControl W0;
    private TextView X0;
    private TextView Y0;
    private TextView Z0;
    private final int[] a;
    private FrameLayout a1;
    private final int[] b;
    private TextView b1;
    private boolean c;
    private TextView c1;
    private float d;
    private LinearLayout d1;
    private int e;
    private FrameLayout e1;
    private int f;
    private TextView[] f1;
    private int g;
    private Bitmap g1;
    private int h;
    private int h1;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private float w;
    private float x;
    private float y;
    private float z;
    private float z0;

    public static class CurvesToolValue {
        public static final int CurvesTypeBlue = 3;
        public static final int CurvesTypeGreen = 2;
        public static final int CurvesTypeLuminance = 0;
        public static final int CurvesTypeRed = 1;
        public int activeType;
        public ByteBuffer curveBuffer;
        public CurvesValue luminanceCurve = new CurvesValue();
        public CurvesValue redCurve = new CurvesValue();
        public CurvesValue greenCurve = new CurvesValue();
        public CurvesValue blueCurve = new CurvesValue();

        public CurvesToolValue() {
            this.curveBuffer = null;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(800);
            this.curveBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }

        public void fillBuffer() {
            this.curveBuffer.position(0);
            float[] dataPoints = this.luminanceCurve.getDataPoints();
            float[] dataPoints2 = this.redCurve.getDataPoints();
            float[] dataPoints3 = this.greenCurve.getDataPoints();
            float[] dataPoints4 = this.blueCurve.getDataPoints();
            for (int i = 0; i < 200; i++) {
                this.curveBuffer.put((byte) (dataPoints2[i] * 255.0f));
                this.curveBuffer.put((byte) (dataPoints3[i] * 255.0f));
                this.curveBuffer.put((byte) (dataPoints4[i] * 255.0f));
                this.curveBuffer.put((byte) (dataPoints[i] * 255.0f));
            }
            this.curveBuffer.position(0);
        }

        public boolean shouldBeSkipped() {
            return this.luminanceCurve.isDefault() && this.redCurve.isDefault() && this.greenCurve.isDefault() && this.blueCurve.isDefault();
        }
    }

    public static class CurvesValue {
        public float[] cachedDataPoints;
        public float blacksLevel = 0.0f;
        public float shadowsLevel = 25.0f;
        public float midtonesLevel = 50.0f;
        public float highlightsLevel = 75.0f;
        public float whitesLevel = 100.0f;
        public float previousBlacksLevel = 0.0f;
        public float previousShadowsLevel = 25.0f;
        public float previousMidtonesLevel = 50.0f;
        public float previousHighlightsLevel = 75.0f;
        public float previousWhitesLevel = 100.0f;

        public float[] getDataPoints() {
            if (this.cachedDataPoints == null) {
                interpolateCurve();
            }
            return this.cachedDataPoints;
        }

        public float[] interpolateCurve() {
            float f = this.blacksLevel;
            float f2 = this.shadowsLevel / 100.0f;
            float f3 = this.midtonesLevel / 100.0f;
            float f4 = this.highlightsLevel / 100.0f;
            float f5 = this.whitesLevel;
            float f6 = 0.0f;
            int i = 5;
            float[] fArr = {-0.001f, f / 100.0f, 0.0f, f / 100.0f, 0.25f, f2, 0.5f, f3, 0.75f, f4, 1.0f, f5 / 100.0f, 1.001f, f5 / 100.0f};
            ArrayList arrayList = new ArrayList(100);
            ArrayList arrayList2 = new ArrayList(100);
            arrayList2.add(Float.valueOf(fArr[0]));
            arrayList2.add(Float.valueOf(fArr[1]));
            int i2 = 1;
            while (i2 < i) {
                int i3 = (i2 - 1) * 2;
                float f7 = fArr[i3];
                float f8 = fArr[i3 + 1];
                int i4 = i2 * 2;
                float f9 = fArr[i4];
                float f10 = fArr[i4 + 1];
                int i5 = i2 + 1;
                int i6 = i5 * 2;
                float f11 = fArr[i6];
                float f12 = fArr[i6 + 1];
                int i7 = (i2 + 2) * 2;
                float f13 = fArr[i7];
                float f14 = fArr[i7 + 1];
                int i8 = 1;
                while (i8 < 100) {
                    float f15 = i8 * 0.01f;
                    float f16 = f15 * f15;
                    float f17 = f16 * f15;
                    float f18 = ((f9 * 2.0f) + ((f11 - f7) * f15) + (((((f7 * 2.0f) - (f9 * 5.0f)) + (f11 * 4.0f)) - f13) * f16) + (((((f9 * 3.0f) - f7) - (f11 * 3.0f)) + f13) * f17)) * 0.5f;
                    float fMax = Math.max(f6, Math.min(1.0f, ((f10 * 2.0f) + ((f12 - f8) * f15) + (((((2.0f * f8) - (5.0f * f10)) + (4.0f * f12)) - f14) * f16) + (((((f10 * 3.0f) - f8) - (3.0f * f12)) + f14) * f17)) * 0.5f));
                    if (f18 > f7) {
                        arrayList2.add(Float.valueOf(f18));
                        arrayList2.add(Float.valueOf(fMax));
                    }
                    if ((i8 - 1) % 2 == 0) {
                        arrayList.add(Float.valueOf(fMax));
                    }
                    i8++;
                    f6 = 0.0f;
                }
                arrayList2.add(Float.valueOf(f11));
                arrayList2.add(Float.valueOf(f12));
                i2 = i5;
                i = 5;
                f6 = 0.0f;
            }
            arrayList2.add(Float.valueOf(fArr[12]));
            arrayList2.add(Float.valueOf(fArr[13]));
            this.cachedDataPoints = new float[arrayList.size()];
            int i9 = 0;
            while (true) {
                float[] fArr2 = this.cachedDataPoints;
                if (i9 >= fArr2.length) {
                    break;
                }
                fArr2[i9] = ((Float) arrayList.get(i9)).floatValue();
                i9++;
            }
            int size = arrayList2.size();
            float[] fArr3 = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                fArr3[i10] = ((Float) arrayList2.get(i10)).floatValue();
            }
            return fArr3;
        }

        public boolean isDefault() {
            return ((double) Math.abs(this.blacksLevel - 0.0f)) < 1.0E-5d && ((double) Math.abs(this.shadowsLevel - 25.0f)) < 1.0E-5d && ((double) Math.abs(this.midtonesLevel - 50.0f)) < 1.0E-5d && ((double) Math.abs(this.highlightsLevel - 75.0f)) < 1.0E-5d && ((double) Math.abs(this.whitesLevel - 100.0f)) < 1.0E-5d;
        }

        public void restoreValues() {
            this.blacksLevel = this.previousBlacksLevel;
            this.shadowsLevel = this.previousShadowsLevel;
            this.midtonesLevel = this.previousMidtonesLevel;
            this.highlightsLevel = this.previousHighlightsLevel;
            this.whitesLevel = this.previousWhitesLevel;
            interpolateCurve();
        }

        public void saveValues() {
            this.previousBlacksLevel = this.blacksLevel;
            this.previousShadowsLevel = this.shadowsLevel;
            this.previousMidtonesLevel = this.midtonesLevel;
            this.previousHighlightsLevel = this.highlightsLevel;
            this.previousWhitesLevel = this.whitesLevel;
        }
    }

    public class EGLThread extends NZ {
        private int A;
        private int A0;
        private boolean A1;
        private int B;
        private int B0;
        private int B1;
        private int C0;
        private int C1;
        private int D;
        private int D0;
        private volatile int D1;
        private int E0;
        private volatile int E1;
        private int F0;
        private FloatBuffer F1;
        private int G;
        private int G0;
        private FloatBuffer G1;
        private int H;
        private int H0;
        private FloatBuffer H1;
        private int I0;
        private boolean I1;
        private int J;
        private int J0;
        private long J1;
        private int K0;
        private Runnable K1;
        private int L0;
        private int M0;
        private int N0;
        private int O0;
        private int P0;
        private int Q0;
        private int R0;
        private int S0;
        private int T0;
        private int U0;
        private int V0;
        private int W0;
        private int X0;
        private int Y;
        private int Y0;
        private int Z;
        private int Z0;
        private int a1;
        private int b1;
        private int c1;
        private int d1;
        private int e1;
        private final int f;
        private int f1;
        private final int g;
        private int g1;
        private SurfaceTexture h;
        private int h1;
        private EGL10 i;
        private int i1;
        private EGLDisplay j;
        private int j1;
        private EGLConfig k;
        private int k1;
        private EGLContext l;
        private int l1;
        private EGLSurface m;
        private int m1;
        private boolean n;
        private int n1;
        private boolean o;
        private int o1;
        private Bitmap p;
        private int p1;
        private int q;
        private int q1;
        private int r;
        private int r1;
        private int s;
        private int s1;
        private int t;
        private int t1;
        private int u;
        private int u1;
        private int v;
        private int v1;
        private int w;
        private int[] w1;
        private int x;
        private int[] x1;
        private int y;
        private int[] y1;
        private int z;
        private int z0;
        private int[] z1;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (EGLThread.this.n) {
                    if ((!EGLThread.this.l.equals(EGLThread.this.i.eglGetCurrentContext()) || !EGLThread.this.m.equals(EGLThread.this.i.eglGetCurrentSurface(12377))) && !EGLThread.this.i.eglMakeCurrent(EGLThread.this.j, EGLThread.this.m, EGLThread.this.m, EGLThread.this.l)) {
                        C19406qI3.b("baleMessages", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(EGLThread.this.i.eglGetError()));
                        return;
                    }
                    GLES20.glViewport(0, 0, EGLThread.this.B1, EGLThread.this.C1);
                    EGLThread.this.J();
                    EGLThread.this.K();
                    EGLThread.this.I();
                    EGLThread eGLThread = EGLThread.this;
                    eGLThread.I1 = eGLThread.H();
                    GLES20.glViewport(0, 0, EGLThread.this.D1, EGLThread.this.E1);
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glClear(0);
                    GLES20.glUseProgram(EGLThread.this.s1);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(3553, EGLThread.this.x1[!EGLThread.this.I1 ? 1 : 0]);
                    GLES20.glUniform1i(EGLThread.this.v1, 0);
                    GLES20.glEnableVertexAttribArray(EGLThread.this.u1);
                    GLES20.glVertexAttribPointer(EGLThread.this.u1, 2, 5126, false, 8, (Buffer) EGLThread.this.G1);
                    GLES20.glEnableVertexAttribArray(EGLThread.this.t1);
                    GLES20.glVertexAttribPointer(EGLThread.this.t1, 2, 5126, false, 8, (Buffer) EGLThread.this.F1);
                    GLES20.glDrawArrays(5, 0, 4);
                    EGLThread.this.i.eglSwapBuffers(EGLThread.this.j, EGLThread.this.m);
                }
            }
        }

        class b implements Runnable {
            final /* synthetic */ Bitmap[] a;
            final /* synthetic */ Semaphore b;

            b(Bitmap[] bitmapArr, Semaphore semaphore) {
                this.a = bitmapArr;
                this.b = semaphore;
            }

            @Override // java.lang.Runnable
            public void run() {
                GLES20.glBindFramebuffer(36160, EGLThread.this.y1[1]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, EGLThread.this.x1[1 ^ (EGLThread.this.I1 ? 1 : 0)], 0);
                GLES20.glClear(0);
                this.a[0] = EGLThread.this.L();
                this.b.release();
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glClear(0);
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EGLThread.this.finish();
                EGLThread.this.p = null;
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    looperMyLooper.quit();
                }
            }
        }

        class d implements Runnable {
            final /* synthetic */ boolean a;
            final /* synthetic */ boolean b;

            d(boolean z, boolean z2) {
                this.a = z;
                this.b = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!EGLThread.this.o) {
                    EGLThread.this.o = this.a;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.b || Math.abs(EGLThread.this.J1 - jCurrentTimeMillis) > 30) {
                    EGLThread.this.J1 = jCurrentTimeMillis;
                    EGLThread.this.K1.run();
                }
            }
        }

        public EGLThread(SurfaceTexture surfaceTexture, Bitmap bitmap) {
            super("Q_PFV_EGL");
            this.f = 12440;
            this.g = 4;
            this.o = true;
            this.w1 = new int[2];
            this.x1 = new int[3];
            this.y1 = new int[3];
            this.z1 = new int[1];
            this.K1 = new a();
            this.h = surfaceTexture;
            this.p = bitmap;
        }

        private Bitmap G(Bitmap bitmap, float f) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            matrix.postRotate(PhotoFilterView.this.h1);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean H() {
            if (PhotoFilterView.this.c || PhotoFilterView.this.B0 == 0) {
                return false;
            }
            if (this.o) {
                GLES20.glUseProgram(this.M0);
                GLES20.glUniform1i(this.P0, 0);
                GLES20.glEnableVertexAttribArray(this.O0);
                GLES20.glVertexAttribPointer(this.O0, 2, 5126, false, 8, (Buffer) this.G1);
                GLES20.glEnableVertexAttribArray(this.N0);
                GLES20.glVertexAttribPointer(this.N0, 2, 5126, false, 8, (Buffer) this.H1);
                GLES20.glBindFramebuffer(36160, this.y1[0]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.x1[0], 0);
                GLES20.glClear(0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.x1[1]);
                GLES20.glUniform1f(this.Q0, 0.0f);
                GLES20.glUniform1f(this.R0, 1.0f / this.C1);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glBindFramebuffer(36160, this.y1[2]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.x1[2], 0);
                GLES20.glClear(0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.x1[0]);
                GLES20.glUniform1f(this.Q0, 1.0f / this.B1);
                GLES20.glUniform1f(this.R0, 0.0f);
                GLES20.glDrawArrays(5, 0, 4);
                this.o = false;
            }
            GLES20.glBindFramebuffer(36160, this.y1[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.x1[0], 0);
            GLES20.glClear(0);
            if (PhotoFilterView.this.B0 == 1) {
                GLES20.glUseProgram(this.c1);
                GLES20.glUniform1i(this.f1, 0);
                GLES20.glUniform1i(this.g1, 1);
                GLES20.glUniform1f(this.h1, PhotoFilterView.this.E0);
                GLES20.glUniform1f(this.j1, PhotoFilterView.this.G0);
                GLES20.glUniform2f(this.i1, PhotoFilterView.this.F0.x, PhotoFilterView.this.F0.y);
                GLES20.glUniform1f(this.k1, this.C1 / this.B1);
                GLES20.glEnableVertexAttribArray(this.e1);
                GLES20.glVertexAttribPointer(this.e1, 2, 5126, false, 8, (Buffer) this.G1);
                GLES20.glEnableVertexAttribArray(this.d1);
                GLES20.glVertexAttribPointer(this.d1, 2, 5126, false, 8, (Buffer) this.H1);
            } else if (PhotoFilterView.this.B0 == 2) {
                GLES20.glUseProgram(this.S0);
                GLES20.glUniform1i(this.V0, 0);
                GLES20.glUniform1i(this.W0, 1);
                GLES20.glUniform1f(this.X0, PhotoFilterView.this.E0);
                GLES20.glUniform1f(this.Z0, PhotoFilterView.this.G0);
                GLES20.glUniform1f(this.a1, PhotoFilterView.this.H0);
                GLES20.glUniform2f(this.Y0, PhotoFilterView.this.F0.x, PhotoFilterView.this.F0.y);
                GLES20.glUniform1f(this.b1, this.C1 / this.B1);
                GLES20.glEnableVertexAttribArray(this.U0);
                GLES20.glVertexAttribPointer(this.U0, 2, 5126, false, 8, (Buffer) this.G1);
                GLES20.glEnableVertexAttribArray(this.T0);
                GLES20.glVertexAttribPointer(this.T0, 2, 5126, false, 8, (Buffer) this.H1);
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.x1[1]);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.x1[2]);
            GLES20.glDrawArrays(5, 0, 4);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I() {
            GLES20.glBindFramebuffer(36160, this.y1[1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.x1[1], 0);
            GLES20.glClear(0);
            GLES20.glUseProgram(this.A);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.x1[0]);
            GLES20.glUniform1i(this.G, 0);
            if (PhotoFilterView.this.c) {
                GLES20.glUniform1f(this.H, 1.0f);
                GLES20.glUniform1f(this.J, 1.0f);
                GLES20.glUniform1f(this.Y, 0.0f);
                GLES20.glUniform1f(this.Z, 1.0f);
                GLES20.glUniform1f(this.z0, 1.0f);
                GLES20.glUniform1f(this.A0, 0.0f);
                GLES20.glUniform1f(this.B0, 0.0f);
                GLES20.glUniform1f(this.C0, 0.0f);
                GLES20.glUniform1f(this.H0, 0.0f);
                GLES20.glUniform3f(this.L0, 0.0f, 0.0f, 0.0f);
                GLES20.glUniform1f(this.J0, 0.0f);
                GLES20.glUniform3f(this.K0, 0.0f, 0.0f, 0.0f);
                GLES20.glUniform1f(this.I0, 0.0f);
                GLES20.glUniform1f(this.G0, 1.0f);
            } else {
                GLES20.glUniform1f(this.H, PhotoFilterView.this.getShadowsValue());
                GLES20.glUniform1f(this.J, PhotoFilterView.this.getHighlightsValue());
                GLES20.glUniform1f(this.Y, PhotoFilterView.this.getExposureValue());
                GLES20.glUniform1f(this.Z, PhotoFilterView.this.getContrastValue());
                GLES20.glUniform1f(this.z0, PhotoFilterView.this.getSaturationValue());
                GLES20.glUniform1f(this.A0, PhotoFilterView.this.getWarmthValue());
                GLES20.glUniform1f(this.B0, PhotoFilterView.this.getVignetteValue());
                GLES20.glUniform1f(this.C0, PhotoFilterView.this.getGrainValue());
                GLES20.glUniform1f(this.H0, PhotoFilterView.this.getFadeValue());
                GLES20.glUniform3f(this.L0, ((PhotoFilterView.this.G >> 16) & 255) / 255.0f, ((PhotoFilterView.this.G >> 8) & 255) / 255.0f, (PhotoFilterView.this.G & 255) / 255.0f);
                GLES20.glUniform1f(this.J0, PhotoFilterView.this.getTintHighlightsIntensityValue());
                GLES20.glUniform3f(this.K0, ((PhotoFilterView.this.D >> 16) & 255) / 255.0f, ((PhotoFilterView.this.D >> 8) & 255) / 255.0f, (PhotoFilterView.this.D & 255) / 255.0f);
                GLES20.glUniform1f(this.I0, PhotoFilterView.this.getTintShadowsIntensityValue());
                boolean zShouldBeSkipped = PhotoFilterView.this.D0.shouldBeSkipped();
                GLES20.glUniform1f(this.G0, zShouldBeSkipped ? 1.0f : 0.0f);
                if (!zShouldBeSkipped) {
                    PhotoFilterView.this.D0.fillBuffer();
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(3553, this.z1[0]);
                    GLES20.glTexParameteri(3553, 10241, 9729);
                    GLES20.glTexParameteri(3553, 10240, 9729);
                    GLES20.glTexParameteri(3553, 10242, 33071);
                    GLES20.glTexParameteri(3553, 10243, 33071);
                    GLES20.glTexImage2D(3553, 0, 6408, 200, 1, 0, 6408, 5121, PhotoFilterView.this.D0.curveBuffer);
                    GLES20.glUniform1i(this.F0, 1);
                }
            }
            GLES20.glUniform1f(this.D0, this.B1);
            GLES20.glUniform1f(this.E0, this.C1);
            GLES20.glEnableVertexAttribArray(this.D);
            GLES20.glVertexAttribPointer(this.D, 2, 5126, false, 8, (Buffer) this.G1);
            GLES20.glEnableVertexAttribArray(this.B);
            GLES20.glVertexAttribPointer(this.B, 2, 5126, false, 8, (Buffer) this.H1);
            GLES20.glDrawArrays(5, 0, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:17:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0156  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void J() {
            /*
                Method dump skipped, instructions count: 390
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoFilterView.EGLThread.J():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K() {
            GLES20.glBindFramebuffer(36160, this.y1[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.x1[0], 0);
            GLES20.glClear(0);
            GLES20.glUseProgram(this.l1);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.x1[1]);
            GLES20.glUniform1i(this.r1, 0);
            if (PhotoFilterView.this.c) {
                GLES20.glUniform1f(this.m1, 0.0f);
            } else {
                GLES20.glUniform1f(this.m1, PhotoFilterView.this.getSharpenValue());
            }
            GLES20.glUniform1f(this.n1, this.B1);
            GLES20.glUniform1f(this.o1, this.C1);
            GLES20.glEnableVertexAttribArray(this.q1);
            GLES20.glVertexAttribPointer(this.q1, 2, 5126, false, 8, (Buffer) this.G1);
            GLES20.glEnableVertexAttribArray(this.p1);
            GLES20.glVertexAttribPointer(this.p1, 2, 5126, false, 8, (Buffer) this.H1);
            GLES20.glDrawArrays(5, 0, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bitmap L() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.B1 * this.C1 * 4);
            GLES20.glReadPixels(0, 0, this.B1, this.C1, 6408, 5121, byteBufferAllocateDirect);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.B1, this.C1, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
            return bitmapCreateBitmap;
        }

        private boolean M() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.i = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.j = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                C19406qI3.b("baleMessages", "eglGetDisplay failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            if (!this.i.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                C19406qI3.b("baleMessages", "eglInitialize failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            int[] iArr = new int[1];
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!this.i.eglChooseConfig(this.j, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                C19406qI3.b("baleMessages", "eglChooseConfig failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            if (iArr[0] <= 0) {
                C19406qI3.b("baleMessages", "eglConfig not initialized");
                finish();
                return false;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            this.k = eGLConfig;
            EGLContext eGLContextEglCreateContext = this.i.eglCreateContext(this.j, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.l = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext == null) {
                C19406qI3.b("baleMessages", "eglCreateContext failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            SurfaceTexture surfaceTexture = this.h;
            if (!(surfaceTexture instanceof SurfaceTexture)) {
                finish();
                return false;
            }
            EGLSurface eGLSurfaceEglCreateWindowSurface = this.i.eglCreateWindowSurface(this.j, this.k, surfaceTexture, null);
            this.m = eGLSurfaceEglCreateWindowSurface;
            if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                C19406qI3.b("baleMessages", "createWindowSurface failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            if (!this.i.eglMakeCurrent(this.j, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.l)) {
                C19406qI3.b("baleMessages", "eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.i.eglGetError()));
                finish();
                return false;
            }
            this.l.getGL();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
            byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
            this.F1 = floatBufferAsFloatBuffer;
            floatBufferAsFloatBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f});
            this.F1.position(0);
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
            byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
            FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
            this.H1 = floatBufferAsFloatBuffer2;
            floatBufferAsFloatBuffer2.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
            this.H1.position(0);
            ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(32);
            byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
            FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
            this.G1 = floatBufferAsFloatBuffer3;
            floatBufferAsFloatBuffer3.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
            this.G1.position(0);
            GLES20.glGenTextures(1, this.z1, 0);
            GLES20.glGenTextures(2, this.w1, 0);
            int iN = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iN2 = N(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;uniform highp float width;uniform highp float height;uniform sampler2D curvesImage;uniform lowp float skipTone;uniform lowp float shadows;const mediump vec3 hsLuminanceWeighting = vec3(0.3, 0.3, 0.3);uniform lowp float highlights;uniform lowp float contrast;uniform lowp float fadeAmount;const mediump vec3 satLuminanceWeighting = vec3(0.2126, 0.7152, 0.0722);uniform lowp float saturation;uniform lowp float shadowsTintIntensity;uniform lowp float highlightsTintIntensity;uniform lowp vec3 shadowsTintColor;uniform lowp vec3 highlightsTintColor;uniform lowp float exposure;uniform lowp float warmth;uniform lowp float grain;const lowp float permTexUnit = 1.0 / 256.0;const lowp float permTexUnitHalf = 0.5 / 256.0;const lowp float grainsize = 2.3;uniform lowp float vignette;highp float getLuma(highp vec3 rgbP) {return (0.299 * rgbP.r) + (0.587 * rgbP.g) + (0.114 * rgbP.b);}lowp vec3 rgbToHsv(lowp vec3 c) {highp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);highp vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);highp vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);highp float d = q.x - min(q.w, q.y);highp float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}lowp vec3 hsvToRgb(lowp vec3 c) {highp vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);highp vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);}highp vec3 rgbToHsl(highp vec3 color) {highp vec3 hsl;highp float fmin = min(min(color.r, color.g), color.b);highp float fmax = max(max(color.r, color.g), color.b);highp float delta = fmax - fmin;hsl.z = (fmax + fmin) / 2.0;if (delta == 0.0) {hsl.x = 0.0;hsl.y = 0.0;} else {if (hsl.z < 0.5) {hsl.y = delta / (fmax + fmin);} else {hsl.y = delta / (2.0 - fmax - fmin);}highp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;highp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;highp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;if (color.r == fmax) {hsl.x = deltaB - deltaG;} else if (color.g == fmax) {hsl.x = (1.0 / 3.0) + deltaR - deltaB;} else if (color.b == fmax) {hsl.x = (2.0 / 3.0) + deltaG - deltaR;}if (hsl.x < 0.0) {hsl.x += 1.0;} else if (hsl.x > 1.0) {hsl.x -= 1.0;}}return hsl;}highp float hueToRgb(highp float f1, highp float f2, highp float hue) {if (hue < 0.0) {hue += 1.0;} else if (hue > 1.0) {hue -= 1.0;}highp float res;if ((6.0 * hue) < 1.0) {res = f1 + (f2 - f1) * 6.0 * hue;} else if ((2.0 * hue) < 1.0) {res = f2;} else if ((3.0 * hue) < 2.0) {res = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;} else {res = f1;} return res;}highp vec3 hslToRgb(highp vec3 hsl) {if (hsl.y == 0.0) {return vec3(hsl.z);} else {highp float f2;if (hsl.z < 0.5) {f2 = hsl.z * (1.0 + hsl.y);} else {f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z);}highp float f1 = 2.0 * hsl.z - f2;return vec3(hueToRgb(f1, f2, hsl.x + (1.0/3.0)), hueToRgb(f1, f2, hsl.x), hueToRgb(f1, f2, hsl.x - (1.0/3.0)));}}highp vec3 rgbToYuv(highp vec3 inP) {highp float luma = getLuma(inP);return vec3(luma, (1.0 / 1.772) * (inP.b - luma), (1.0 / 1.402) * (inP.r - luma));}lowp vec3 yuvToRgb(highp vec3 inP) {return vec3(1.402 * inP.b + inP.r, (inP.r - (0.299 * 1.402 / 0.587) * inP.b - (0.114 * 1.772 / 0.587) * inP.g), 1.772 * inP.g + inP.r);}lowp float easeInOutSigmoid(lowp float value, lowp float strength) {if (value > 0.5) {return 1.0 - pow(2.0 - 2.0 * value, 1.0 / (1.0 - strength)) * 0.5;} else {return pow(2.0 * value, 1.0 / (1.0 - strength)) * 0.5;}}lowp vec3 applyLuminanceCurve(lowp vec3 pixel) {highp float index = floor(clamp(pixel.z / (1.0 / 200.0), 0.0, 199.0));pixel.y = mix(0.0, pixel.y, smoothstep(0.0, 0.1, pixel.z) * (1.0 - smoothstep(0.8, 1.0, pixel.z)));pixel.z = texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).a;return pixel;}lowp vec3 applyRGBCurve(lowp vec3 pixel) {highp float index = floor(clamp(pixel.r / (1.0 / 200.0), 0.0, 199.0));pixel.r = texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).r;index = floor(clamp(pixel.g / (1.0 / 200.0), 0.0, 199.0));pixel.g = clamp(texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).g, 0.0, 1.0);index = floor(clamp(pixel.b / (1.0 / 200.0), 0.0, 199.0));pixel.b = clamp(texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).b, 0.0, 1.0);return pixel;}highp vec3 fadeAdjust(highp vec3 color, highp float fadeVal) {return (color * (1.0 - fadeVal)) + ((color + (vec3(-0.9772) * pow(vec3(color), vec3(3.0)) + vec3(1.708) * pow(vec3(color), vec3(2.0)) + vec3(-0.1603) * vec3(color) + vec3(0.2878) - color * vec3(0.9))) * fadeVal);}lowp vec3 tintRaiseShadowsCurve(lowp vec3 color) {return vec3(-0.003671) * pow(color, vec3(3.0)) + vec3(0.3842) * pow(color, vec3(2.0)) + vec3(0.3764) * color + vec3(0.2515);}lowp vec3 tintShadows(lowp vec3 texel, lowp vec3 tintColor, lowp float tintAmount) {return clamp(mix(texel, mix(texel, tintRaiseShadowsCurve(texel), tintColor), tintAmount), 0.0, 1.0);} lowp vec3 tintHighlights(lowp vec3 texel, lowp vec3 tintColor, lowp float tintAmount) {return clamp(mix(texel, mix(texel, vec3(1.0) - tintRaiseShadowsCurve(vec3(1.0) - texel), (vec3(1.0) - tintColor)), tintAmount), 0.0, 1.0);}highp vec4 rnm(in highp vec2 tc) {highp float noise = sin(dot(tc, vec2(12.9898, 78.233))) * 43758.5453;return vec4(fract(noise), fract(noise * 1.2154), fract(noise * 1.3453), fract(noise * 1.3647)) * 2.0 - 1.0;}highp float fade(in highp float t) {return t * t * t * (t * (t * 6.0 - 15.0) + 10.0);}highp float pnoise3D(in highp vec3 p) {highp vec3 pi = permTexUnit * floor(p) + permTexUnitHalf;highp vec3 pf = fract(p);highp float perm = rnm(pi.xy).a;highp float n000 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf);highp float n001 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(0.0, 0.0, 1.0));perm = rnm(pi.xy + vec2(0.0, permTexUnit)).a;highp float n010 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(0.0, 1.0, 0.0));highp float n011 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(0.0, 1.0, 1.0));perm = rnm(pi.xy + vec2(permTexUnit, 0.0)).a;highp float n100 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(1.0, 0.0, 0.0));highp float n101 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(1.0, 0.0, 1.0));perm = rnm(pi.xy + vec2(permTexUnit, permTexUnit)).a;highp float n110 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(1.0, 1.0, 0.0));highp float n111 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(1.0, 1.0, 1.0));highp vec4 n_x = mix(vec4(n000, n001, n010, n011), vec4(n100, n101, n110, n111), fade(pf.x));highp vec2 n_xy = mix(n_x.xy, n_x.zw, fade(pf.y));return mix(n_xy.x, n_xy.y, fade(pf.z));}lowp vec2 coordRot(in lowp vec2 tc, in lowp float angle) {return vec2(((tc.x * 2.0 - 1.0) * cos(angle) - (tc.y * 2.0 - 1.0) * sin(angle)) * 0.5 + 0.5, ((tc.y * 2.0 - 1.0) * cos(angle) + (tc.x * 2.0 - 1.0) * sin(angle)) * 0.5 + 0.5);}void main() {lowp vec4 source = texture2D(sourceImage, texCoord);lowp vec4 result = source;const lowp float toolEpsilon = 0.005;if (skipTone < toolEpsilon) {result = vec4(applyRGBCurve(hslToRgb(applyLuminanceCurve(rgbToHsl(result.rgb)))), result.a);}mediump float hsLuminance = dot(result.rgb, hsLuminanceWeighting);mediump float shadow = clamp((pow(hsLuminance, 1.0 / shadows) + (-0.76) * pow(hsLuminance, 2.0 / shadows)) - hsLuminance, 0.0, 1.0);mediump float highlight = clamp((1.0 - (pow(1.0 - hsLuminance, 1.0 / (2.0 - highlights)) + (-0.8) * pow(1.0 - hsLuminance, 2.0 / (2.0 - highlights)))) - hsLuminance, -1.0, 0.0);lowp vec3 hsresult = vec3(0.0, 0.0, 0.0) + ((hsLuminance + shadow + highlight) - 0.0) * ((result.rgb - vec3(0.0, 0.0, 0.0)) / (hsLuminance - 0.0));mediump float contrastedLuminance = ((hsLuminance - 0.5) * 1.5) + 0.5;mediump float whiteInterp = contrastedLuminance * contrastedLuminance * contrastedLuminance;mediump float whiteTarget = clamp(highlights, 1.0, 2.0) - 1.0;hsresult = mix(hsresult, vec3(1.0), whiteInterp * whiteTarget);mediump float invContrastedLuminance = 1.0 - contrastedLuminance;mediump float blackInterp = invContrastedLuminance * invContrastedLuminance * invContrastedLuminance;mediump float blackTarget = 1.0 - clamp(shadows, 0.0, 1.0);hsresult = mix(hsresult, vec3(0.0), blackInterp * blackTarget);result = vec4(hsresult.rgb, result.a);result = vec4(clamp(((result.rgb - vec3(0.5)) * contrast + vec3(0.5)), 0.0, 1.0), result.a);if (abs(fadeAmount) > toolEpsilon) {result.rgb = fadeAdjust(result.rgb, fadeAmount);}lowp float satLuminance = dot(result.rgb, satLuminanceWeighting);lowp vec3 greyScaleColor = vec3(satLuminance);result = vec4(clamp(mix(greyScaleColor, result.rgb, saturation), 0.0, 1.0), result.a);if (abs(shadowsTintIntensity) > toolEpsilon) {result.rgb = tintShadows(result.rgb, shadowsTintColor, shadowsTintIntensity * 2.0);}if (abs(highlightsTintIntensity) > toolEpsilon) {result.rgb = tintHighlights(result.rgb, highlightsTintColor, highlightsTintIntensity * 2.0);}if (abs(exposure) > toolEpsilon) {mediump float mag = exposure * 1.045;mediump float exppower = 1.0 + abs(mag);if (mag < 0.0) {exppower = 1.0 / exppower;}result.r = 1.0 - pow((1.0 - result.r), exppower);result.g = 1.0 - pow((1.0 - result.g), exppower);result.b = 1.0 - pow((1.0 - result.b), exppower);}if (abs(warmth) > toolEpsilon) {highp vec3 yuvVec;if (warmth > 0.0 ) {yuvVec = vec3(0.1765, -0.1255, 0.0902);} else {yuvVec = -vec3(0.0588, 0.1569, -0.1255);}highp vec3 yuvColor = rgbToYuv(result.rgb);highp float luma = yuvColor.r;highp float curveScale = sin(luma * 3.14159);yuvColor += 0.375 * warmth * curveScale * yuvVec;result.rgb = yuvToRgb(yuvColor);}if (abs(grain) > toolEpsilon) {highp vec3 rotOffset = vec3(1.425, 3.892, 5.835);highp vec2 rotCoordsR = coordRot(texCoord, rotOffset.x);highp vec3 noise = vec3(pnoise3D(vec3(rotCoordsR * vec2(width / grainsize, height / grainsize),0.0)));lowp vec3 lumcoeff = vec3(0.299,0.587,0.114);lowp float luminance = dot(result.rgb, lumcoeff);lowp float lum = smoothstep(0.2, 0.0, luminance);lum += luminance;noise = mix(noise,vec3(0.0),pow(lum,4.0));result.rgb = result.rgb + noise * grain;}if (abs(vignette) > toolEpsilon) {const lowp float midpoint = 0.7;const lowp float fuzziness = 0.62;lowp float radDist = length(texCoord - 0.5) / sqrt(0.5);lowp float mag = easeInOutSigmoid(radDist * midpoint, fuzziness) * vignette * 0.645;result.rgb = mix(pow(result.rgb, vec3(1.0 / (1.0 - mag))), vec3(0.0), mag * mag);}gl_FragColor = result;}");
            if (iN == 0 || iN2 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.A = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iN);
            GLES20.glAttachShader(this.A, iN2);
            GLES20.glBindAttribLocation(this.A, 0, "position");
            GLES20.glBindAttribLocation(this.A, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.A);
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(this.A, 35714, iArr2, 0);
            if (iArr2[0] == 0) {
                GLES20.glDeleteProgram(this.A);
                this.A = 0;
            } else {
                this.B = GLES20.glGetAttribLocation(this.A, "position");
                this.D = GLES20.glGetAttribLocation(this.A, "inputTexCoord");
                this.G = GLES20.glGetUniformLocation(this.A, "sourceImage");
                this.H = GLES20.glGetUniformLocation(this.A, "shadows");
                this.J = GLES20.glGetUniformLocation(this.A, "highlights");
                this.Y = GLES20.glGetUniformLocation(this.A, "exposure");
                this.Z = GLES20.glGetUniformLocation(this.A, "contrast");
                this.z0 = GLES20.glGetUniformLocation(this.A, "saturation");
                this.A0 = GLES20.glGetUniformLocation(this.A, "warmth");
                this.B0 = GLES20.glGetUniformLocation(this.A, "vignette");
                this.C0 = GLES20.glGetUniformLocation(this.A, "grain");
                this.D0 = GLES20.glGetUniformLocation(this.A, "width");
                this.E0 = GLES20.glGetUniformLocation(this.A, "height");
                this.F0 = GLES20.glGetUniformLocation(this.A, "curvesImage");
                this.G0 = GLES20.glGetUniformLocation(this.A, "skipTone");
                this.H0 = GLES20.glGetUniformLocation(this.A, "fadeAmount");
                this.I0 = GLES20.glGetUniformLocation(this.A, "shadowsTintIntensity");
                this.J0 = GLES20.glGetUniformLocation(this.A, "highlightsTintIntensity");
                this.K0 = GLES20.glGetUniformLocation(this.A, "shadowsTintColor");
                this.L0 = GLES20.glGetUniformLocation(this.A, "highlightsTintColor");
            }
            int iN3 = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;uniform highp float inputWidth;uniform highp float inputHeight;varying vec2 leftTexCoord;varying vec2 rightTexCoord;varying vec2 topTexCoord;varying vec2 bottomTexCoord;void main() {gl_Position = position;texCoord = inputTexCoord;highp vec2 widthStep = vec2(1.0 / inputWidth, 0.0);highp vec2 heightStep = vec2(0.0, 1.0 / inputHeight);leftTexCoord = inputTexCoord - widthStep;rightTexCoord = inputTexCoord + widthStep;topTexCoord = inputTexCoord + heightStep;bottomTexCoord = inputTexCoord - heightStep;}");
            int iN4 = N(35632, "precision highp float;varying vec2 texCoord;varying vec2 leftTexCoord;varying vec2 rightTexCoord;varying vec2 topTexCoord;varying vec2 bottomTexCoord;uniform sampler2D sourceImage;uniform float sharpen;void main() {vec4 result = texture2D(sourceImage, texCoord);vec3 leftTextureColor = texture2D(sourceImage, leftTexCoord).rgb;vec3 rightTextureColor = texture2D(sourceImage, rightTexCoord).rgb;vec3 topTextureColor = texture2D(sourceImage, topTexCoord).rgb;vec3 bottomTextureColor = texture2D(sourceImage, bottomTexCoord).rgb;result.rgb = result.rgb * (1.0 + 4.0 * sharpen) - (leftTextureColor + rightTextureColor + topTextureColor + bottomTextureColor) * sharpen;gl_FragColor = result;}");
            if (iN3 == 0 || iN4 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram2 = GLES20.glCreateProgram();
            this.l1 = iGlCreateProgram2;
            GLES20.glAttachShader(iGlCreateProgram2, iN3);
            GLES20.glAttachShader(this.l1, iN4);
            GLES20.glBindAttribLocation(this.l1, 0, "position");
            GLES20.glBindAttribLocation(this.l1, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.l1);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.l1, 35714, iArr3, 0);
            if (iArr3[0] == 0) {
                GLES20.glDeleteProgram(this.l1);
                this.l1 = 0;
            } else {
                this.p1 = GLES20.glGetAttribLocation(this.l1, "position");
                this.q1 = GLES20.glGetAttribLocation(this.l1, "inputTexCoord");
                this.r1 = GLES20.glGetUniformLocation(this.l1, "sourceImage");
                this.n1 = GLES20.glGetUniformLocation(this.l1, "inputWidth");
                this.o1 = GLES20.glGetUniformLocation(this.l1, "inputHeight");
                this.m1 = GLES20.glGetUniformLocation(this.l1, "sharpen");
            }
            int iN5 = N(35633, "attribute vec4 position;attribute vec4 inputTexCoord;uniform highp float texelWidthOffset;uniform highp float texelHeightOffset;varying vec2 blurCoordinates[9];void main() {gl_Position = position;vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);blurCoordinates[0] = inputTexCoord.xy;blurCoordinates[1] = inputTexCoord.xy + singleStepOffset * 1.458430;blurCoordinates[2] = inputTexCoord.xy - singleStepOffset * 1.458430;blurCoordinates[3] = inputTexCoord.xy + singleStepOffset * 3.403985;blurCoordinates[4] = inputTexCoord.xy - singleStepOffset * 3.403985;blurCoordinates[5] = inputTexCoord.xy + singleStepOffset * 5.351806;blurCoordinates[6] = inputTexCoord.xy - singleStepOffset * 5.351806;blurCoordinates[7] = inputTexCoord.xy + singleStepOffset * 7.302940;blurCoordinates[8] = inputTexCoord.xy - singleStepOffset * 7.302940;}");
            int iN6 = N(35632, "uniform sampler2D sourceImage;varying highp vec2 blurCoordinates[9];void main() {lowp vec4 sum = vec4(0.0);sum += texture2D(sourceImage, blurCoordinates[0]) * 0.133571;sum += texture2D(sourceImage, blurCoordinates[1]) * 0.233308;sum += texture2D(sourceImage, blurCoordinates[2]) * 0.233308;sum += texture2D(sourceImage, blurCoordinates[3]) * 0.135928;sum += texture2D(sourceImage, blurCoordinates[4]) * 0.135928;sum += texture2D(sourceImage, blurCoordinates[5]) * 0.051383;sum += texture2D(sourceImage, blurCoordinates[6]) * 0.051383;sum += texture2D(sourceImage, blurCoordinates[7]) * 0.012595;sum += texture2D(sourceImage, blurCoordinates[8]) * 0.012595;gl_FragColor = sum;}");
            if (iN5 == 0 || iN6 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram3 = GLES20.glCreateProgram();
            this.M0 = iGlCreateProgram3;
            GLES20.glAttachShader(iGlCreateProgram3, iN5);
            GLES20.glAttachShader(this.M0, iN6);
            GLES20.glBindAttribLocation(this.M0, 0, "position");
            GLES20.glBindAttribLocation(this.M0, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.M0);
            int[] iArr4 = new int[1];
            GLES20.glGetProgramiv(this.M0, 35714, iArr4, 0);
            if (iArr4[0] == 0) {
                GLES20.glDeleteProgram(this.M0);
                this.M0 = 0;
            } else {
                this.N0 = GLES20.glGetAttribLocation(this.M0, "position");
                this.O0 = GLES20.glGetAttribLocation(this.M0, "inputTexCoord");
                this.P0 = GLES20.glGetUniformLocation(this.M0, "sourceImage");
                this.Q0 = GLES20.glGetUniformLocation(this.M0, "texelWidthOffset");
                this.R0 = GLES20.glGetUniformLocation(this.M0, "texelHeightOffset");
            }
            int iN7 = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iN8 = N(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;uniform sampler2D inputImageTexture2;uniform lowp float excludeSize;uniform lowp vec2 excludePoint;uniform lowp float excludeBlurSize;uniform highp float angle;uniform highp float aspectRatio;void main() {lowp vec4 sharpImageColor = texture2D(sourceImage, texCoord);lowp vec4 blurredImageColor = texture2D(inputImageTexture2, texCoord);highp vec2 texCoordToUse = vec2(texCoord.x, (texCoord.y * aspectRatio + 0.5 - 0.5 * aspectRatio));highp float distanceFromCenter = abs((texCoordToUse.x - excludePoint.x) * aspectRatio * cos(angle) + (texCoordToUse.y - excludePoint.y) * sin(angle));gl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeSize - excludeBlurSize, excludeSize, distanceFromCenter));}");
            if (iN7 == 0 || iN8 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram4 = GLES20.glCreateProgram();
            this.S0 = iGlCreateProgram4;
            GLES20.glAttachShader(iGlCreateProgram4, iN7);
            GLES20.glAttachShader(this.S0, iN8);
            GLES20.glBindAttribLocation(this.S0, 0, "position");
            GLES20.glBindAttribLocation(this.S0, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.S0);
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(this.S0, 35714, iArr5, 0);
            if (iArr5[0] == 0) {
                GLES20.glDeleteProgram(this.S0);
                this.S0 = 0;
            } else {
                this.T0 = GLES20.glGetAttribLocation(this.S0, "position");
                this.U0 = GLES20.glGetAttribLocation(this.S0, "inputTexCoord");
                this.V0 = GLES20.glGetUniformLocation(this.S0, "sourceImage");
                this.W0 = GLES20.glGetUniformLocation(this.S0, "inputImageTexture2");
                this.X0 = GLES20.glGetUniformLocation(this.S0, "excludeSize");
                this.Y0 = GLES20.glGetUniformLocation(this.S0, "excludePoint");
                this.Z0 = GLES20.glGetUniformLocation(this.S0, "excludeBlurSize");
                this.a1 = GLES20.glGetUniformLocation(this.S0, "angle");
                this.b1 = GLES20.glGetUniformLocation(this.S0, "aspectRatio");
            }
            int iN9 = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iN10 = N(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;uniform sampler2D inputImageTexture2;uniform lowp float excludeSize;uniform lowp vec2 excludePoint;uniform lowp float excludeBlurSize;uniform highp float aspectRatio;void main() {lowp vec4 sharpImageColor = texture2D(sourceImage, texCoord);lowp vec4 blurredImageColor = texture2D(inputImageTexture2, texCoord);highp vec2 texCoordToUse = vec2(texCoord.x, (texCoord.y * aspectRatio + 0.5 - 0.5 * aspectRatio));highp float distanceFromCenter = distance(excludePoint, texCoordToUse);gl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeSize - excludeBlurSize, excludeSize, distanceFromCenter));}");
            if (iN9 == 0 || iN10 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram5 = GLES20.glCreateProgram();
            this.c1 = iGlCreateProgram5;
            GLES20.glAttachShader(iGlCreateProgram5, iN9);
            GLES20.glAttachShader(this.c1, iN10);
            GLES20.glBindAttribLocation(this.c1, 0, "position");
            GLES20.glBindAttribLocation(this.c1, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.c1);
            int[] iArr6 = new int[1];
            GLES20.glGetProgramiv(this.c1, 35714, iArr6, 0);
            if (iArr6[0] == 0) {
                GLES20.glDeleteProgram(this.c1);
                this.c1 = 0;
            } else {
                this.d1 = GLES20.glGetAttribLocation(this.c1, "position");
                this.e1 = GLES20.glGetAttribLocation(this.c1, "inputTexCoord");
                this.f1 = GLES20.glGetUniformLocation(this.c1, "sourceImage");
                this.g1 = GLES20.glGetUniformLocation(this.c1, "inputImageTexture2");
                this.h1 = GLES20.glGetUniformLocation(this.c1, "excludeSize");
                this.i1 = GLES20.glGetUniformLocation(this.c1, "excludePoint");
                this.j1 = GLES20.glGetUniformLocation(this.c1, "excludeBlurSize");
                this.k1 = GLES20.glGetUniformLocation(this.c1, "aspectRatio");
            }
            int iN11 = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iN12 = N(35632, "precision highp float;varying vec2 texCoord;uniform sampler2D sourceImage;vec3 rgb_to_hsv(vec3 c) {vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);float d = q.x - min(q.w, q.y);float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}void main() {vec4 texel = texture2D(sourceImage, texCoord);gl_FragColor = vec4(rgb_to_hsv(texel.rgb), texel.a);}");
            if (iN11 == 0 || iN12 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram6 = GLES20.glCreateProgram();
            this.q = iGlCreateProgram6;
            GLES20.glAttachShader(iGlCreateProgram6, iN11);
            GLES20.glAttachShader(this.q, iN12);
            GLES20.glBindAttribLocation(this.q, 0, "position");
            GLES20.glBindAttribLocation(this.q, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.q);
            int[] iArr7 = new int[1];
            GLES20.glGetProgramiv(this.q, 35714, iArr7, 0);
            if (iArr7[0] == 0) {
                GLES20.glDeleteProgram(this.q);
                this.q = 0;
            } else {
                this.r = GLES20.glGetAttribLocation(this.q, "position");
                this.s = GLES20.glGetAttribLocation(this.q, "inputTexCoord");
                this.t = GLES20.glGetUniformLocation(this.q, "sourceImage");
            }
            int iN13 = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iN14 = N(35632, "precision highp float;varying vec2 texCoord;uniform sampler2D sourceImage;uniform sampler2D inputImageTexture2;uniform float intensity;float enhance(float value) {const vec2 offset = vec2(0.001953125, 0.03125);value = value + offset.x;vec2 coord = (clamp(texCoord, 0.125, 1.0 - 0.125001) - 0.125) * 4.0;vec2 frac = fract(coord);coord = floor(coord);float p00 = float(coord.y * 4.0 + coord.x) * 0.0625 + offset.y;float p01 = float(coord.y * 4.0 + coord.x + 1.0) * 0.0625 + offset.y;float p10 = float((coord.y + 1.0) * 4.0 + coord.x) * 0.0625 + offset.y;float p11 = float((coord.y + 1.0) * 4.0 + coord.x + 1.0) * 0.0625 + offset.y;vec3 c00 = texture2D(inputImageTexture2, vec2(value, p00)).rgb;vec3 c01 = texture2D(inputImageTexture2, vec2(value, p01)).rgb;vec3 c10 = texture2D(inputImageTexture2, vec2(value, p10)).rgb;vec3 c11 = texture2D(inputImageTexture2, vec2(value, p11)).rgb;float c1 = ((c00.r - c00.g) / (c00.b - c00.g));float c2 = ((c01.r - c01.g) / (c01.b - c01.g));float c3 = ((c10.r - c10.g) / (c10.b - c10.g));float c4 = ((c11.r - c11.g) / (c11.b - c11.g));float c1_2 = mix(c1, c2, frac.x);float c3_4 = mix(c3, c4, frac.x);return mix(c1_2, c3_4, frac.y);}vec3 hsv_to_rgb(vec3 c) {vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);}void main() {vec4 texel = texture2D(sourceImage, texCoord);vec4 hsv = texel;hsv.y = min(1.0, hsv.y * 1.2);hsv.z = min(1.0, enhance(hsv.z) * 1.1);gl_FragColor = vec4(hsv_to_rgb(mix(texel.xyz, hsv.xyz, intensity)), texel.w);}");
            if (iN13 == 0 || iN14 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram7 = GLES20.glCreateProgram();
            this.u = iGlCreateProgram7;
            GLES20.glAttachShader(iGlCreateProgram7, iN13);
            GLES20.glAttachShader(this.u, iN14);
            GLES20.glBindAttribLocation(this.u, 0, "position");
            GLES20.glBindAttribLocation(this.u, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.u);
            int[] iArr8 = new int[1];
            GLES20.glGetProgramiv(this.u, 35714, iArr8, 0);
            if (iArr8[0] == 0) {
                GLES20.glDeleteProgram(this.u);
                this.u = 0;
            } else {
                this.v = GLES20.glGetAttribLocation(this.u, "position");
                this.w = GLES20.glGetAttribLocation(this.u, "inputTexCoord");
                this.x = GLES20.glGetUniformLocation(this.u, "sourceImage");
                this.y = GLES20.glGetUniformLocation(this.u, "intensity");
                this.z = GLES20.glGetUniformLocation(this.u, "inputImageTexture2");
            }
            int iN15 = N(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 texCoord;void main() {gl_Position = position;texCoord = inputTexCoord;}");
            int iN16 = N(35632, "varying highp vec2 texCoord;uniform sampler2D sourceImage;void main() {gl_FragColor = texture2D(sourceImage, texCoord);}");
            if (iN15 == 0 || iN16 == 0) {
                finish();
                return false;
            }
            int iGlCreateProgram8 = GLES20.glCreateProgram();
            this.s1 = iGlCreateProgram8;
            GLES20.glAttachShader(iGlCreateProgram8, iN15);
            GLES20.glAttachShader(this.s1, iN16);
            GLES20.glBindAttribLocation(this.s1, 0, "position");
            GLES20.glBindAttribLocation(this.s1, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.s1);
            int[] iArr9 = new int[1];
            GLES20.glGetProgramiv(this.s1, 35714, iArr9, 0);
            if (iArr9[0] == 0) {
                GLES20.glDeleteProgram(this.s1);
                this.s1 = 0;
            } else {
                this.t1 = GLES20.glGetAttribLocation(this.s1, "position");
                this.u1 = GLES20.glGetAttribLocation(this.s1, "inputTexCoord");
                this.v1 = GLES20.glGetUniformLocation(this.s1, "sourceImage");
            }
            Bitmap bitmap = this.p;
            if (bitmap != null) {
                O(bitmap);
            }
            return true;
        }

        private int N(int i, String str) {
            int iGlCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return iGlCreateShader;
            }
            C19406qI3.b("baleMessages", GLES20.glGetShaderInfoLog(iGlCreateShader));
            GLES20.glDeleteShader(iGlCreateShader);
            return 0;
        }

        private void O(Bitmap bitmap) {
            float f;
            this.B1 = bitmap.getWidth();
            this.C1 = bitmap.getHeight();
            float fG = AbstractC7426Rr.G();
            if (this.B1 > fG || this.C1 > fG || PhotoFilterView.this.h1 % 360 != 0) {
                if (this.B1 > fG || this.C1 > fG) {
                    float width = fG / bitmap.getWidth();
                    float height = fG / bitmap.getHeight();
                    if (width < height) {
                        this.B1 = (int) fG;
                        this.C1 = (int) (bitmap.getHeight() * width);
                        f = width;
                    } else {
                        this.C1 = (int) fG;
                        this.B1 = (int) (bitmap.getWidth() * height);
                        f = height;
                    }
                } else {
                    f = 1.0f;
                }
                if (PhotoFilterView.this.h1 % 360 == 90 || PhotoFilterView.this.h1 % 360 == 270) {
                    int i = this.B1;
                    this.B1 = this.C1;
                    this.C1 = i;
                }
                this.p = G(bitmap, f);
            }
            GLES20.glGenFramebuffers(3, this.y1, 0);
            GLES20.glGenTextures(3, this.x1, 0);
            GLES20.glBindTexture(3553, this.x1[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6408, this.B1, this.C1, 0, 6408, 5121, null);
            GLES20.glBindTexture(3553, this.x1[1]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, this.p, 0);
            GLES20.glBindTexture(3553, this.x1[2]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6408, this.B1, this.C1, 0, 6408, 5121, null);
        }

        public void finish() {
            if (this.m != null) {
                EGL10 egl10 = this.i;
                EGLDisplay eGLDisplay = this.j;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                this.i.eglDestroySurface(this.j, this.m);
                this.m = null;
            }
            EGLContext eGLContext = this.l;
            if (eGLContext != null) {
                this.i.eglDestroyContext(this.j, eGLContext);
                this.l = null;
            }
            EGLDisplay eGLDisplay2 = this.j;
            if (eGLDisplay2 != null) {
                this.i.eglTerminate(eGLDisplay2);
                this.j = null;
            }
        }

        public Bitmap getTexture() throws InterruptedException {
            if (!this.n) {
                return null;
            }
            Semaphore semaphore = new Semaphore(0);
            Bitmap[] bitmapArr = new Bitmap[1];
            try {
                postRunnable(new b(bitmapArr, semaphore));
                semaphore.acquire();
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
            return bitmapArr[0];
        }

        public void requestRender(boolean z) {
            requestRender(z, false);
        }

        @Override // ir.nasim.NZ, java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            this.n = M();
            super.run();
        }

        public void setSurfaceTextureSize(int i, int i2) {
            this.D1 = i;
            this.E1 = i2;
        }

        public void shutdown() {
            postRunnable(new c());
        }

        public void requestRender(boolean z, boolean z2) {
            postRunnable(new d(z, z2));
        }
    }

    public class ToolsAdapter extends RecyclerView.h {
        private Context d;

        private class a extends RecyclerView.C {
            public a(View view) {
                super(view);
            }
        }

        public ToolsAdapter(Context context) {
            this.d = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return 14;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(RecyclerView.C c, int i) {
            String str;
            a aVar = (a) c;
            if (i == PhotoFilterView.this.i) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_enhance, C5721Ko.b.getString(AbstractC12217eE5.Enhance), PhotoFilterView.this.w);
                return;
            }
            if (i == PhotoFilterView.this.p) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_highlights, C5721Ko.b.getString(AbstractC12217eE5.Highlights), PhotoFilterView.this.H);
                return;
            }
            if (i == PhotoFilterView.this.k) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_contrast, C5721Ko.b.getString(AbstractC12217eE5.Contrast), PhotoFilterView.this.y);
                return;
            }
            if (i == PhotoFilterView.this.j) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_brightness, C5721Ko.b.getString(AbstractC12217eE5.Exposure), PhotoFilterView.this.x);
                return;
            }
            if (i == PhotoFilterView.this.l) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_warmth, C5721Ko.b.getString(AbstractC12217eE5.Warmth), PhotoFilterView.this.z);
                return;
            }
            if (i == PhotoFilterView.this.m) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_saturation, C5721Ko.b.getString(AbstractC12217eE5.Saturation), PhotoFilterView.this.A);
                return;
            }
            if (i == PhotoFilterView.this.r) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_vignette, C5721Ko.b.getString(AbstractC12217eE5.Vignette), PhotoFilterView.this.z0);
                return;
            }
            if (i == PhotoFilterView.this.q) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_shadows, C5721Ko.b.getString(AbstractC12217eE5.Shadows), PhotoFilterView.this.J);
                return;
            }
            if (i == PhotoFilterView.this.s) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_grain, C5721Ko.b.getString(AbstractC12217eE5.Grain), PhotoFilterView.this.A0);
                return;
            }
            if (i == PhotoFilterView.this.u) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_details, C5721Ko.b.getString(AbstractC12217eE5.Sharpen), PhotoFilterView.this.C0);
                return;
            }
            str = "◆";
            String str2 = "";
            if (i == PhotoFilterView.this.n) {
                PhotoEditToolCell photoEditToolCell = (PhotoEditToolCell) aVar.a;
                int i2 = KB5.tool_tint;
                String string = C5721Ko.b.getString(AbstractC12217eE5.Tint);
                if (PhotoFilterView.this.G == 0 && PhotoFilterView.this.D == 0) {
                    str = "";
                }
                photoEditToolCell.setIconAndTextAndValue(i2, string, str);
                return;
            }
            if (i == PhotoFilterView.this.o) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_fade, C5721Ko.b.getString(AbstractC12217eE5.Fade), PhotoFilterView.this.B);
                return;
            }
            if (i == PhotoFilterView.this.v) {
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_curve, C5721Ko.b.getString(AbstractC12217eE5.Curves), PhotoFilterView.this.D0.shouldBeSkipped() ? "" : "◆");
                return;
            }
            if (i == PhotoFilterView.this.t) {
                if (PhotoFilterView.this.B0 == 1) {
                    str2 = TokenNames.R;
                } else if (PhotoFilterView.this.B0 == 2) {
                    str2 = TokenNames.L;
                }
                ((PhotoEditToolCell) aVar.a).setIconAndTextAndValue(KB5.tool_blur, C5721Ko.b.getString(AbstractC12217eE5.Blur), str2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new a(new PhotoEditToolCell(this.d));
        }
    }

    class a implements TextureView.SurfaceTextureListener {

        /* renamed from: ir.nasim.features.media.components.PhotoFilterView$a$a, reason: collision with other inner class name */
        class RunnableC1179a implements Runnable {
            RunnableC1179a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PhotoFilterView.this.S0 != null) {
                    PhotoFilterView.this.S0.requestRender(false, true);
                }
            }
        }

        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (PhotoFilterView.this.S0 != null || surfaceTexture == null) {
                return;
            }
            PhotoFilterView photoFilterView = PhotoFilterView.this;
            PhotoFilterView photoFilterView2 = PhotoFilterView.this;
            photoFilterView.S0 = photoFilterView2.new EGLThread(surfaceTexture, photoFilterView2.g1);
            PhotoFilterView.this.S0.setSurfaceTextureSize(i, i2);
            PhotoFilterView.this.S0.requestRender(true, true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (PhotoFilterView.this.S0 == null) {
                return true;
            }
            PhotoFilterView.this.S0.shutdown();
            PhotoFilterView.this.S0 = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.setSurfaceTextureSize(i, i2);
                PhotoFilterView.this.S0.requestRender(false, true);
                PhotoFilterView.this.S0.postRunnable(new RunnableC1179a());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoFilterView.this.B0 = 1;
            PhotoFilterView.this.S0();
            PhotoFilterView.this.V0.setVisibility(0);
            PhotoFilterView.this.V0.setType(1);
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(false);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoFilterView.this.B0 = 2;
            PhotoFilterView.this.S0();
            PhotoFilterView.this.V0.setVisibility(0);
            PhotoFilterView.this.V0.setType(0);
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(false);
            }
        }
    }

    class d extends AbstractC9160Yt {
        final /* synthetic */ View a;
        final /* synthetic */ View b;

        class a extends AbstractC9160Yt {
            a() {
            }

            @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (PhotoFilterView.this.h == PhotoFilterView.this.i) {
                    PhotoFilterView.this.N0();
                }
            }
        }

        d(View view, View view2) {
            this.a = view;
            this.b = view2;
        }

        @Override // ir.nasim.AbstractC9160Yt, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            this.b.setTranslationY(AbstractC7426Rr.z(126.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, "translationY", 0.0f));
            animatorSet.addListener(new a());
            animatorSet.setDuration(200L);
            animatorSet.start();
        }
    }

    class e implements PhotoFilterBlurControl.PhotoFilterLinearBlurControlDelegate {
        e() {
        }

        @Override // ir.nasim.features.media.components.PhotoFilterBlurControl.PhotoFilterLinearBlurControlDelegate
        public void valueChanged(Point point, float f, float f2, float f3) {
            PhotoFilterView.this.E0 = f2;
            PhotoFilterView.this.F0 = point;
            PhotoFilterView.this.G0 = f;
            PhotoFilterView.this.H0 = f3;
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(false);
            }
        }
    }

    class f implements PhotoFilterCurvesControl.PhotoFilterCurvesControlDelegate {
        f() {
        }

        @Override // ir.nasim.features.media.components.PhotoFilterCurvesControl.PhotoFilterCurvesControlDelegate
        public void valueChanged() {
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(false);
            }
        }
    }

    class g implements RecyclerListView.OnItemClickListener {
        g() {
        }

        @Override // ir.nasim.features.media.components.RecyclerListView.OnItemClickListener
        public void onItemClick(int i) {
            PhotoFilterView.this.h = i;
            if (i == PhotoFilterView.this.i) {
                PhotoFilterView photoFilterView = PhotoFilterView.this;
                photoFilterView.d = photoFilterView.w;
                PhotoFilterView.this.J0.setMinMax(0, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Enhance);
            } else if (i == PhotoFilterView.this.p) {
                PhotoFilterView photoFilterView2 = PhotoFilterView.this;
                photoFilterView2.d = photoFilterView2.H;
                PhotoFilterView.this.J0.setMinMax(-100, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Highlights);
            } else if (i == PhotoFilterView.this.k) {
                PhotoFilterView photoFilterView3 = PhotoFilterView.this;
                photoFilterView3.d = photoFilterView3.y;
                PhotoFilterView.this.J0.setMinMax(-100, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Contrast);
            } else if (i == PhotoFilterView.this.j) {
                PhotoFilterView photoFilterView4 = PhotoFilterView.this;
                photoFilterView4.d = photoFilterView4.x;
                PhotoFilterView.this.J0.setMinMax(-100, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Exposure);
            } else if (i == PhotoFilterView.this.l) {
                PhotoFilterView photoFilterView5 = PhotoFilterView.this;
                photoFilterView5.d = photoFilterView5.z;
                PhotoFilterView.this.J0.setMinMax(-100, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Warmth);
            } else if (i == PhotoFilterView.this.m) {
                PhotoFilterView photoFilterView6 = PhotoFilterView.this;
                photoFilterView6.d = photoFilterView6.A;
                PhotoFilterView.this.J0.setMinMax(-100, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Saturation);
            } else if (i == PhotoFilterView.this.r) {
                PhotoFilterView photoFilterView7 = PhotoFilterView.this;
                photoFilterView7.d = photoFilterView7.z0;
                PhotoFilterView.this.J0.setMinMax(0, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Vignette);
            } else if (i == PhotoFilterView.this.q) {
                PhotoFilterView photoFilterView8 = PhotoFilterView.this;
                photoFilterView8.d = photoFilterView8.J;
                PhotoFilterView.this.J0.setMinMax(-100, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Shadows);
            } else if (i == PhotoFilterView.this.s) {
                PhotoFilterView photoFilterView9 = PhotoFilterView.this;
                photoFilterView9.d = photoFilterView9.A0;
                PhotoFilterView.this.J0.setMinMax(0, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Grain);
            } else if (i == PhotoFilterView.this.o) {
                PhotoFilterView photoFilterView10 = PhotoFilterView.this;
                photoFilterView10.d = photoFilterView10.B;
                PhotoFilterView.this.J0.setMinMax(0, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Fade);
            } else if (i == PhotoFilterView.this.u) {
                PhotoFilterView photoFilterView11 = PhotoFilterView.this;
                photoFilterView11.d = photoFilterView11.C0;
                PhotoFilterView.this.J0.setMinMax(0, 100);
                PhotoFilterView.this.M0.setText(AbstractC12217eE5.Sharpen);
            } else if (i == PhotoFilterView.this.t) {
                PhotoFilterView photoFilterView12 = PhotoFilterView.this;
                photoFilterView12.e = photoFilterView12.B0;
            } else if (i == PhotoFilterView.this.n) {
                PhotoFilterView photoFilterView13 = PhotoFilterView.this;
                photoFilterView13.e = photoFilterView13.D;
                PhotoFilterView photoFilterView14 = PhotoFilterView.this;
                photoFilterView14.f = photoFilterView14.G;
            } else if (i == PhotoFilterView.this.v) {
                PhotoFilterView.this.D0.luminanceCurve.saveValues();
                PhotoFilterView.this.D0.redCurve.saveValues();
                PhotoFilterView.this.D0.greenCurve.saveValues();
                PhotoFilterView.this.D0.blueCurve.saveValues();
            }
            PhotoFilterView.this.J0.setProgress((int) PhotoFilterView.this.d, false);
            PhotoFilterView.this.U0();
            PhotoFilterView.this.switchToOrFromEditMode();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoFilterView.this.h == PhotoFilterView.this.i) {
                PhotoFilterView photoFilterView = PhotoFilterView.this;
                photoFilterView.w = photoFilterView.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.p) {
                PhotoFilterView photoFilterView2 = PhotoFilterView.this;
                photoFilterView2.H = photoFilterView2.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.k) {
                PhotoFilterView photoFilterView3 = PhotoFilterView.this;
                photoFilterView3.y = photoFilterView3.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.j) {
                PhotoFilterView photoFilterView4 = PhotoFilterView.this;
                photoFilterView4.x = photoFilterView4.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.l) {
                PhotoFilterView photoFilterView5 = PhotoFilterView.this;
                photoFilterView5.z = photoFilterView5.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.m) {
                PhotoFilterView photoFilterView6 = PhotoFilterView.this;
                photoFilterView6.A = photoFilterView6.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.r) {
                PhotoFilterView photoFilterView7 = PhotoFilterView.this;
                photoFilterView7.z0 = photoFilterView7.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.q) {
                PhotoFilterView photoFilterView8 = PhotoFilterView.this;
                photoFilterView8.J = photoFilterView8.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.s) {
                PhotoFilterView photoFilterView9 = PhotoFilterView.this;
                photoFilterView9.A0 = photoFilterView9.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.u) {
                PhotoFilterView photoFilterView10 = PhotoFilterView.this;
                photoFilterView10.C0 = photoFilterView10.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.o) {
                PhotoFilterView photoFilterView11 = PhotoFilterView.this;
                photoFilterView11.B = photoFilterView11.d;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.t) {
                PhotoFilterView photoFilterView12 = PhotoFilterView.this;
                photoFilterView12.B0 = photoFilterView12.e;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.n) {
                PhotoFilterView photoFilterView13 = PhotoFilterView.this;
                photoFilterView13.D = photoFilterView13.e;
                PhotoFilterView photoFilterView14 = PhotoFilterView.this;
                photoFilterView14.G = photoFilterView14.f;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.v) {
                PhotoFilterView.this.D0.luminanceCurve.restoreValues();
                PhotoFilterView.this.D0.redCurve.restoreValues();
                PhotoFilterView.this.D0.greenCurve.restoreValues();
                PhotoFilterView.this.D0.blueCurve.restoreValues();
            }
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(PhotoFilterView.this.h != PhotoFilterView.this.t);
            }
            PhotoFilterView.this.switchToOrFromEditMode();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoFilterView.this.I0.notifyDataSetChanged();
            PhotoFilterView.this.switchToOrFromEditMode();
        }
    }

    class j implements PhotoEditorSeekBar.PhotoEditorSeekBarDelegate {
        j() {
        }

        @Override // ir.nasim.features.media.components.PhotoEditorSeekBar.PhotoEditorSeekBarDelegate
        public void onProgressChanged() {
            int progress = PhotoFilterView.this.J0.getProgress();
            if (PhotoFilterView.this.h == PhotoFilterView.this.i) {
                PhotoFilterView.this.w = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.p) {
                PhotoFilterView.this.H = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.k) {
                PhotoFilterView.this.y = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.j) {
                PhotoFilterView.this.x = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.l) {
                PhotoFilterView.this.z = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.m) {
                PhotoFilterView.this.A = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.r) {
                PhotoFilterView.this.z0 = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.q) {
                PhotoFilterView.this.J = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.s) {
                PhotoFilterView.this.A0 = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.u) {
                PhotoFilterView.this.C0 = progress;
            } else if (PhotoFilterView.this.h == PhotoFilterView.this.o) {
                PhotoFilterView.this.B = progress;
            }
            PhotoFilterView.this.U0();
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(true);
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RadioButton radioButton = (RadioButton) view;
            if (PhotoFilterView.this.g == 0) {
                PhotoFilterView photoFilterView = PhotoFilterView.this;
                photoFilterView.D = photoFilterView.a[((Integer) radioButton.getTag()).intValue()];
            } else {
                PhotoFilterView photoFilterView2 = PhotoFilterView.this;
                photoFilterView2.G = photoFilterView2.b[((Integer) radioButton.getTag()).intValue()];
            }
            PhotoFilterView.this.T0(true);
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(false);
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PhotoFilterView.this.B0 = 0;
            PhotoFilterView.this.S0();
            PhotoFilterView.this.V0.setVisibility(4);
            if (PhotoFilterView.this.S0 != null) {
                PhotoFilterView.this.S0.requestRender(false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0439  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PhotoFilterView(android.content.Context r24, android.graphics.Bitmap r25, int r26) {
        /*
            Method dump skipped, instructions count: 1674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoFilterView.<init>(android.content.Context, android.graphics.Bitmap, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        if (this.w == 0.0f) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ObjectAnimator.ofInt(this.J0, "progress", 50));
            animatorSet.start();
        }
    }

    private void O0(int i2, int i3) {
        float height;
        int width;
        float fCeil;
        float fCeil2;
        if (this.g1 == null) {
            return;
        }
        int iZ = i2 - AbstractC7426Rr.z(28.0f);
        int iZ2 = i3 - (AbstractC7426Rr.z(154.0f) + AbstractC7426Rr.H());
        int i4 = this.h1;
        if (i4 % 360 == 90 || i4 % 360 == 270) {
            height = this.g1.getHeight();
            width = this.g1.getWidth();
        } else {
            height = this.g1.getWidth();
            width = this.g1.getHeight();
        }
        float f2 = iZ;
        float f3 = iZ2;
        if (f2 / height > f3 / width) {
            fCeil2 = (int) Math.ceil(height * r6);
            fCeil = f3;
        } else {
            fCeil = (int) Math.ceil(r2 * r4);
            fCeil2 = f2;
        }
        int iCeil = (int) Math.ceil(((f2 - fCeil2) / 2.0f) + AbstractC7426Rr.z(14.0f));
        int iCeil2 = (int) Math.ceil(((f3 - fCeil) / 2.0f) + AbstractC7426Rr.z(14.0f) + AbstractC7426Rr.H());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.R0.getLayoutParams();
        layoutParams.leftMargin = iCeil;
        layoutParams.topMargin = iCeil2;
        int i5 = (int) fCeil2;
        layoutParams.width = i5;
        int i6 = (int) fCeil;
        layoutParams.height = i6;
        this.W0.setActualArea(iCeil, iCeil2, i5, i6);
        this.V0.setActualAreaSize(layoutParams.width, layoutParams.height);
        ((FrameLayout.LayoutParams) this.V0.getLayoutParams()).height = AbstractC7426Rr.z(28.0f) + iZ2;
        ((FrameLayout.LayoutParams) this.W0.getLayoutParams()).height = iZ2 + AbstractC7426Rr.z(28.0f);
        if (C5161Id6.k()) {
            int iZ3 = AbstractC7426Rr.z(86.0f) * 10;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.T0.getLayoutParams();
            if (iZ3 < iZ) {
                layoutParams2.width = iZ3;
                layoutParams2.leftMargin = (iZ - iZ3) / 2;
            } else {
                layoutParams2.width = -1;
                layoutParams2.leftMargin = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        int i2 = 0;
        while (i2 < 4) {
            TextView textView = this.f1[i2];
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(i2 == iIntValue ? c5495Jo7.l2() : c5495Jo7.n2());
            i2++;
        }
        this.D0.activeType = iIntValue;
        this.W0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view) {
        this.g = 0;
        T0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(View view) {
        this.g = 1;
        T0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        int i2 = this.B0;
        if (i2 == 0) {
            this.X0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_off_active, 0, 0);
            TextView textView = this.X0;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.t2());
            this.Y0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_radial, 0, 0);
            this.Y0.setTextColor(c5495Jo7.l2());
            this.Z0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_linear, 0, 0);
            this.Z0.setTextColor(c5495Jo7.l2());
            return;
        }
        if (i2 == 1) {
            this.X0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_off, 0, 0);
            TextView textView2 = this.X0;
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            textView2.setTextColor(c5495Jo72.l2());
            this.Y0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_radial_active, 0, 0);
            this.Y0.setTextColor(c5495Jo72.t2());
            this.Z0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_linear, 0, 0);
            this.Z0.setTextColor(c5495Jo72.l2());
            return;
        }
        if (i2 == 2) {
            this.X0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_off, 0, 0);
            TextView textView3 = this.X0;
            C5495Jo7 c5495Jo73 = C5495Jo7.a;
            textView3.setTextColor(c5495Jo73.l2());
            this.Y0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_radial, 0, 0);
            this.Y0.setTextColor(c5495Jo73.l2());
            this.Z0.setCompoundDrawablesWithIntrinsicBounds(0, KB5.blur_linear_active, 0, 0);
            this.Z0.setTextColor(c5495Jo73.t2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(boolean z) {
        this.c1.setTextColor(this.g == 1 ? C5495Jo7.a.l2() : C5495Jo7.a.n2());
        this.b1.setTextColor(this.g == 1 ? C5495Jo7.a.n2() : C5495Jo7.a.l2());
        int childCount = this.d1.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.d1.getChildAt(i2);
            if (childAt instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) childAt;
                int iIntValue = ((Integer) radioButton.getTag()).intValue();
                int i3 = this.g;
                radioButton.setChecked((i3 == 0 ? this.D : this.G) == (i3 == 0 ? this.a[iIntValue] : this.b[iIntValue]), z);
                radioButton.setColor(iIntValue == 0 ? -1 : this.g == 0 ? this.a[iIntValue] : this.b[iIntValue], iIntValue != 0 ? this.g == 0 ? this.a[iIntValue] : this.b[iIntValue] : -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void U0() {
        /*
            r4 = this;
            int r0 = r4.h
            int r1 = r4.i
            if (r0 != r1) goto La
            float r0 = r4.w
        L8:
            int r0 = (int) r0
            goto L51
        La:
            int r1 = r4.p
            if (r0 != r1) goto L11
            float r0 = r4.H
            goto L8
        L11:
            int r1 = r4.k
            if (r0 != r1) goto L18
            float r0 = r4.y
            goto L8
        L18:
            int r1 = r4.j
            if (r0 != r1) goto L1f
            float r0 = r4.x
            goto L8
        L1f:
            int r1 = r4.l
            if (r0 != r1) goto L26
            float r0 = r4.z
            goto L8
        L26:
            int r1 = r4.m
            if (r0 != r1) goto L2d
            float r0 = r4.A
            goto L8
        L2d:
            int r1 = r4.r
            if (r0 != r1) goto L34
            float r0 = r4.z0
            goto L8
        L34:
            int r1 = r4.q
            if (r0 != r1) goto L3b
            float r0 = r4.J
            goto L8
        L3b:
            int r1 = r4.s
            if (r0 != r1) goto L42
            float r0 = r4.A0
            goto L8
        L42:
            int r1 = r4.u
            if (r0 != r1) goto L49
            float r0 = r4.C0
            goto L8
        L49:
            int r1 = r4.o
            if (r0 != r1) goto L50
            float r0 = r4.B
            goto L8
        L50:
            r0 = 0
        L51:
            if (r0 <= 0) goto L6a
            android.widget.TextView r1 = r4.O0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "+"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.setText(r0)
            goto L80
        L6a:
            android.widget.TextView r1 = r4.O0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.setText(r0)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.components.PhotoFilterView.U0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getContrastValue() {
        return ((this.y / 100.0f) * 0.3f) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getEnhanceValue() {
        return this.w / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getExposureValue() {
        return this.x / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFadeValue() {
        return this.B / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getGrainValue() {
        return (this.A0 / 100.0f) * 0.04f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getHighlightsValue() {
        return ((this.H * 0.75f) + 100.0f) / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getSaturationValue() {
        float f2 = this.A / 100.0f;
        if (f2 > 0.0f) {
            f2 *= 1.05f;
        }
        return f2 + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getShadowsValue() {
        return ((this.J * 0.55f) + 100.0f) / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getSharpenValue() {
        return ((this.C0 / 100.0f) * 0.6f) + 0.11f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getTintHighlightsIntensityValue() {
        return this.G == 0 ? 0.0f : 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getTintShadowsIntensityValue() {
        return this.D == 0 ? 0.0f : 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getVignetteValue() {
        return this.z0 / 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getWarmthValue() {
        return this.z / 100.0f;
    }

    private void setShowOriginal(boolean z) {
        if (this.c == z) {
            return;
        }
        this.c = z;
        EGLThread eGLThread = this.S0;
        if (eGLThread != null) {
            eGLThread.requestRender(false);
        }
    }

    public Bitmap getBitmap() {
        EGLThread eGLThread = this.S0;
        if (eGLThread != null) {
            return eGLThread.getTexture();
        }
        return null;
    }

    public TextView getCancelTextView() {
        return this.Q0;
    }

    public TextView getDoneTextView() {
        return this.P0;
    }

    public FrameLayout getToolsView() {
        return this.K0;
    }

    public boolean hasChanges() {
        return (this.w == 0.0f && this.y == 0.0f && this.H == 0.0f && this.x == 0.0f && this.z == 0.0f && this.A == 0.0f && this.z0 == 0.0f && this.J == 0.0f && this.A0 == 0.0f && this.C0 == 0.0f && this.B == 0.0f && this.G == 0 && this.D == 0 && this.D0.shouldBeSkipped()) ? false : true;
    }

    public void init() {
        this.R0.setVisibility(0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        O0(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        super.onMeasure(i2, i3);
    }

    public void onTouch(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0 && motionEvent.getActionMasked() != 5) {
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6) {
                setShowOriginal(false);
                return;
            }
            return;
        }
        if (((FrameLayout.LayoutParams) this.R0.getLayoutParams()) == null || motionEvent.getX() < r0.leftMargin || motionEvent.getY() < r0.topMargin || motionEvent.getX() > r0.leftMargin + r0.width || motionEvent.getY() > r0.topMargin + r0.height) {
            return;
        }
        setShowOriginal(true);
    }

    public void shutdown() {
        EGLThread eGLThread = this.S0;
        if (eGLThread != null) {
            eGLThread.shutdown();
            this.S0 = null;
        }
        this.R0.setVisibility(8);
    }

    public void switchToOrFromEditMode() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (this.L0.getVisibility() == 8) {
            frameLayout = this.K0;
            frameLayout2 = this.L0;
            int i2 = this.h;
            int i3 = this.t;
            if (i2 == i3 || i2 == this.n || i2 == this.v) {
                this.U0.setVisibility(i2 == i3 ? 0 : 4);
                this.a1.setVisibility(this.h == this.n ? 0 : 4);
                this.e1.setVisibility(this.h == this.v ? 0 : 4);
                int i4 = this.h;
                if (i4 == this.t) {
                    this.N0.setText(AbstractC12217eE5.Blur);
                    if (this.B0 != 0) {
                        this.V0.setVisibility(0);
                    }
                } else if (i4 == this.v) {
                    this.N0.setText(AbstractC12217eE5.Curves);
                    this.W0.setVisibility(0);
                    this.D0.activeType = 0;
                    int i5 = 0;
                    while (i5 < 4) {
                        TextView textView = this.f1[i5];
                        C5495Jo7 c5495Jo7 = C5495Jo7.a;
                        textView.setTextColor(i5 == 0 ? c5495Jo7.l2() : c5495Jo7.n2());
                        i5++;
                    }
                } else {
                    this.g = 0;
                    T0(false);
                    this.N0.setText(AbstractC12217eE5.Tint);
                }
                this.N0.setVisibility(0);
                this.J0.setVisibility(4);
                this.M0.setVisibility(4);
                this.O0.setVisibility(4);
                S0();
            } else {
                this.a1.setVisibility(4);
                this.e1.setVisibility(4);
                this.U0.setVisibility(4);
                this.J0.setVisibility(0);
                this.N0.setVisibility(4);
                this.M0.setVisibility(0);
                this.O0.setVisibility(0);
                this.V0.setVisibility(4);
                this.W0.setVisibility(4);
            }
        } else {
            this.h = -1;
            frameLayout = this.L0;
            frameLayout2 = this.K0;
            this.V0.setVisibility(4);
            this.W0.setVisibility(4);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(frameLayout, "translationY", 0.0f, AbstractC7426Rr.z(126.0f)));
        animatorSet.addListener(new d(frameLayout, frameLayout2));
        animatorSet.setDuration(200L);
        animatorSet.start();
    }
}
