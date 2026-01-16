package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C22697vg5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes7.dex */
public class l {
    private int A;
    private int A0;
    private int B;
    private int B0;
    private int C;
    private int C0;
    private int D;
    private int D0;
    private int E;
    private int E0;
    private int F;
    private int F0;
    private int G;
    private int G0;
    private int H0;
    private int I0;
    private int J0;
    private int K0;
    private int L;
    private int L0;
    private int M;
    private int M0;
    private int N;
    private int N0;
    private int O;
    private int O0;
    private int P;
    private int P0;
    private int Q;
    private int Q0;
    private int R;
    private float[] R0;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int[] W0;
    private int X;
    private int Y;
    private boolean Y0;
    private int Z;
    private int Z0;
    private int a0;
    private int a1;
    private int b0;
    public FloatBuffer b1;
    private boolean c;
    private int c0;
    public FloatBuffer c1;
    private boolean d;
    private int d0;
    public FloatBuffer d1;
    private b e;
    private int e0;
    private ByteBuffer e1;
    private float f;
    private int f0;
    private ByteBuffer f1;
    private b g;
    private int g0;
    private ByteBuffer g1;
    private boolean h;
    private int h0;
    private c h1;
    private int i;
    private int i0;
    private boolean i1;
    private int j;
    private int j0;
    private l.b j1;
    private int k;
    private int k0;
    private int l;
    private int l0;
    private int m;
    private int m0;
    private int n;
    private int n0;
    private d o;
    private int o0;
    private int p;
    private int p0;
    private int q;
    private int q0;
    private int r;
    private int r0;
    private int s;
    private int s0;
    private int t;
    private int t0;
    private int u;
    private int u0;
    private int v;
    private int v0;
    private int w;
    private int w0;
    private int x;
    private int x0;
    private int y;
    private int y0;
    private int z;
    private int z0;
    private boolean a = true;
    private boolean b = true;
    private int[] H = new int[2];
    private int[] I = new int[2];
    private int[] J = new int[2];
    private int[] K = new int[2];
    private int[] S0 = new int[2];
    private int[] T0 = new int[1];
    private int[] U0 = new int[4];
    private int[] V0 = new int[1];
    private int[] X0 = new int[1];
    private boolean k1 = true;

    class a implements c {
        final /* synthetic */ MediaController.n a;

        a(MediaController.n nVar) {
            this.a = nVar;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public boolean b() {
            return !this.a.p.b();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public ByteBuffer d() {
            this.a.p.a();
            return this.a.p.e;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getBlurAngle() {
            return this.a.t;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getBlurExcludeBlurSize() {
            return this.a.s;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public C22697vg5 getBlurExcludePoint() {
            return this.a.r;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getBlurExcludeSize() {
            return this.a.q;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public int getBlurType() {
            return this.a.n;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getContrastValue() {
            return ((this.a.d / 100.0f) * 0.3f) + 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getEnhanceValue() {
            return this.a.a / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getExposureValue() {
            return this.a.c / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getFadeValue() {
            return this.a.g / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getGrainValue() {
            return (this.a.m / 100.0f) * 0.04f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getHighlightsValue() {
            return ((this.a.j * 0.75f) + 100.0f) / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getSaturationValue() {
            float f = this.a.f / 100.0f;
            if (f > 0.0f) {
                f *= 1.05f;
            }
            return f + 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getShadowsValue() {
            return ((this.a.k * 0.55f) + 100.0f) / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getSharpenValue() {
            return ((this.a.o / 100.0f) * 0.6f) + 0.11f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getSoftenSkinValue() {
            return this.a.b / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public int getTintHighlightsColor() {
            return this.a.i;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getTintHighlightsIntensityValue() {
            return this.a.i == 0 ? 0.0f : 0.5f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public int getTintShadowsColor() {
            return this.a.h;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getTintShadowsIntensityValue() {
            return this.a.h == 0 ? 0.0f : 0.5f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getVignetteValue() {
            return this.a.l / 100.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
        public float getWarmthValue() {
            return this.a.e / 100.0f;
        }
    }

    private static class b {
        private String a;
        private String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public b(float f, float f2, boolean z) {
            int i;
            if (z) {
                f2 = Math.round(f);
                if (f2 >= 1.0f) {
                    double d = f2;
                    int iFloor = (int) Math.floor(Math.sqrt(Math.pow(d, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d))));
                    i = iFloor + (iFloor % 2);
                } else {
                    i = 0;
                }
            } else {
                i = (int) f;
            }
            this.b = l.j(i, f2);
            this.a = l.A(i, f2);
        }

        public boolean a() {
            int iR = l.r(35633, this.a);
            int iR2 = l.r(35632, this.b);
            if (iR == 0 || iR2 == 0) {
                return false;
            }
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.c = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iR);
            GLES20.glAttachShader(this.c, iR2);
            GLES20.glBindAttribLocation(this.c, 0, "position");
            GLES20.glBindAttribLocation(this.c, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.c);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.c, 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(this.c);
                this.c = 0;
            } else {
                this.d = GLES20.glGetAttribLocation(this.c, "position");
                this.e = GLES20.glGetAttribLocation(this.c, "inputTexCoord");
                this.f = GLES20.glGetUniformLocation(this.c, "sTexture");
                this.g = GLES20.glGetUniformLocation(this.c, "texelWidthOffset");
                this.h = GLES20.glGetUniformLocation(this.c, "texelHeightOffset");
            }
            return true;
        }

        public void b() {
            int i = this.c;
            if (i != 0) {
                GLES20.glDeleteProgram(i);
                this.c = 0;
            }
        }
    }

    public interface c {
        boolean a();

        boolean b();

        ByteBuffer d();

        float getBlurAngle();

        float getBlurExcludeBlurSize();

        C22697vg5 getBlurExcludePoint();

        float getBlurExcludeSize();

        int getBlurType();

        float getContrastValue();

        float getEnhanceValue();

        float getExposureValue();

        float getFadeValue();

        float getGrainValue();

        float getHighlightsValue();

        float getSaturationValue();

        float getShadowsValue();

        float getSharpenValue();

        float getSoftenSkinValue();

        int getTintHighlightsColor();

        float getTintHighlightsIntensityValue();

        int getTintShadowsColor();

        float getTintShadowsIntensityValue();

        float getVignetteValue();

        float getWarmthValue();
    }

    private static class d {
        private float[] a;
        private float[] b;
        private float[] c;
        private float[] d;
        private int[] e = new int[1];

        public d() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PointF(0.0f, 0.0f));
            arrayList.add(new PointF(0.5f, 0.5f));
            arrayList.add(new PointF(1.0f, 1.0f));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new PointF(0.0f, 0.0f));
            arrayList2.add(new PointF(0.47f, 0.57f));
            arrayList2.add(new PointF(1.0f, 1.0f));
            this.a = b(arrayList2);
            float[] fArrB = b(arrayList);
            this.d = fArrB;
            this.c = fArrB;
            this.b = fArrB;
            e();
        }

        private float[] b(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                PointF pointF = (PointF) arrayList.get(i);
                pointF.x *= 255.0f;
                pointF.y *= 255.0f;
            }
            ArrayList arrayListD = d(arrayList);
            float f = ((PointF) arrayListD.get(0)).x;
            if (f > 0.0f) {
                for (int i2 = (int) f; i2 >= 0; i2--) {
                    arrayListD.add(0, new PointF(i2, 0.0f));
                }
            }
            float f2 = ((PointF) arrayListD.get(arrayListD.size() - 1)).x;
            if (f2 < 255.0f) {
                int i3 = (int) f2;
                while (true) {
                    i3++;
                    if (i3 > 255) {
                        break;
                    }
                    arrayListD.add(new PointF(i3, 255.0f));
                }
            }
            float[] fArr = new float[arrayListD.size()];
            int size2 = arrayListD.size();
            for (int i4 = 0; i4 < size2; i4++) {
                PointF pointF2 = (PointF) arrayListD.get(i4);
                float fSqrt = (float) Math.sqrt(Math.pow(pointF2.x - pointF2.y, 2.0d));
                if (pointF2.x > pointF2.y) {
                    fSqrt = -fSqrt;
                }
                fArr[i4] = fSqrt;
            }
            return fArr;
        }

        private double[] c(ArrayList arrayList) {
            int i;
            int size = arrayList.size();
            if (size <= 0) {
                return null;
            }
            char c = 1;
            if (size == 1) {
                return null;
            }
            char c2 = 2;
            char c3 = 0;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
            double[] dArr2 = new double[size];
            double[] dArr3 = dArr[0];
            dArr3[1] = 1.0d;
            double d = 0.0d;
            dArr3[0] = 0.0d;
            dArr3[2] = 0.0d;
            int i2 = 1;
            while (true) {
                i = size - 1;
                if (i2 >= i) {
                    break;
                }
                PointF pointF = (PointF) arrayList.get(i2 - 1);
                PointF pointF2 = (PointF) arrayList.get(i2);
                int i3 = i2 + 1;
                PointF pointF3 = (PointF) arrayList.get(i3);
                double[] dArr4 = dArr[i2];
                float f = pointF2.x;
                float f2 = pointF.x;
                dArr4[c3] = (f - f2) / 6.0d;
                float f3 = pointF3.x;
                double[] dArr5 = dArr2;
                dArr4[c] = (f3 - f2) / 3.0d;
                dArr4[c2] = (f3 - f) / 6.0d;
                float f4 = pointF3.y;
                float f5 = pointF2.y;
                dArr5[i2] = ((f4 - f5) / (f3 - f)) - ((f5 - pointF.y) / (f - f2));
                i2 = i3;
                dArr2 = dArr5;
                c = 1;
                c2 = 2;
                c3 = 0;
                d = 0.0d;
            }
            char c4 = c3;
            double[] dArr6 = dArr2;
            double d2 = d;
            dArr6[c4] = d2;
            dArr6[i] = d2;
            double[] dArr7 = dArr[i];
            char c5 = 1;
            dArr7[1] = 1.0d;
            dArr7[c4] = d2;
            char c6 = 2;
            dArr7[2] = d2;
            int i4 = 1;
            while (i4 < size) {
                double[] dArr8 = dArr[i4];
                double d3 = dArr8[c4];
                int i5 = i4 - 1;
                double[] dArr9 = dArr[i5];
                double d4 = d3 / dArr9[c5];
                dArr8[c5] = dArr8[c5] - (dArr9[c6] * d4);
                dArr8[c4] = 0.0d;
                dArr6[i4] = dArr6[i4] - (d4 * dArr6[i5]);
                i4++;
                c4 = 0;
                c6 = 2;
                c5 = 1;
            }
            for (int i6 = size - 2; i6 >= 0; i6--) {
                double[] dArr10 = dArr[i6];
                double d5 = dArr10[2];
                int i7 = i6 + 1;
                double[] dArr11 = dArr[i7];
                double d6 = d5 / dArr11[1];
                dArr10[1] = dArr10[1] - (dArr11[0] * d6);
                dArr10[2] = 0.0d;
                dArr6[i6] = dArr6[i6] - (d6 * dArr6[i7]);
            }
            double[] dArr12 = new double[size];
            for (int i8 = 0; i8 < size; i8++) {
                dArr12[i8] = dArr6[i8] / dArr[i8][1];
            }
            return dArr12;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x006d A[PHI: r4
          0x006d: PHI (r4v7 float) = (r4v3 float), (r4v4 float) binds: [B:13:0x006b, B:16:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.util.ArrayList d(java.util.ArrayList r22) {
            /*
                r21 = this;
                r0 = r22
                double[] r1 = r21.c(r22)
                int r2 = r1.length
                r3 = 1
                if (r2 >= r3) goto Lc
                r0 = 0
                return r0
            Lc:
                java.util.ArrayList r4 = new java.util.ArrayList
                int r5 = r2 + 1
                r4.<init>(r5)
                r5 = 0
            L14:
                int r6 = r2 + (-1)
                if (r5 >= r6) goto L8f
                java.lang.Object r6 = r0.get(r5)
                android.graphics.PointF r6 = (android.graphics.PointF) r6
                int r7 = r5 + 1
                java.lang.Object r8 = r0.get(r7)
                android.graphics.PointF r8 = (android.graphics.PointF) r8
                float r9 = r6.x
                int r9 = (int) r9
            L29:
                float r10 = r8.x
                int r11 = (int) r10
                if (r9 >= r11) goto L8a
                float r11 = (float) r9
                float r12 = r6.x
                float r13 = r11 - r12
                double r13 = (double) r13
                float r15 = r10 - r12
                r16 = r4
                double r3 = (double) r15
                double r13 = r13 / r3
                r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                double r3 = r3 - r13
                float r10 = r10 - r12
                r12 = r9
                double r9 = (double) r10
                float r15 = r6.y
                r17 = r11
                r18 = r12
                double r11 = (double) r15
                double r11 = r11 * r3
                float r15 = r8.y
                r19 = r6
                r20 = r7
                double r6 = (double) r15
                double r6 = r6 * r13
                double r11 = r11 + r6
                double r9 = r9 * r9
                r6 = 4618441417868443648(0x4018000000000000, double:6.0)
                double r9 = r9 / r6
                double r6 = r3 * r3
                double r6 = r6 * r3
                double r6 = r6 - r3
                r3 = r1[r5]
                double r6 = r6 * r3
                double r3 = r13 * r13
                double r3 = r3 * r13
                double r3 = r3 - r13
                r13 = r1[r20]
                double r3 = r3 * r13
                double r6 = r6 + r3
                double r9 = r9 * r6
                double r11 = r11 + r9
                float r3 = (float) r11
                r4 = 1132396544(0x437f0000, float:255.0)
                int r6 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r6 <= 0) goto L6f
            L6d:
                r3 = r4
                goto L75
            L6f:
                r4 = 0
                int r6 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r6 >= 0) goto L75
                goto L6d
            L75:
                android.graphics.PointF r4 = new android.graphics.PointF
                r6 = r17
                r4.<init>(r6, r3)
                r3 = r16
                r3.add(r4)
                int r9 = r18 + 1
                r4 = r3
                r6 = r19
                r7 = r20
                r3 = 1
                goto L29
            L8a:
                r20 = r7
                r5 = r20
                goto L14
            L8f:
                r3 = r4
                int r1 = r22.size()
                r2 = 1
                int r1 = r1 - r2
                java.lang.Object r0 = r0.get(r1)
                android.graphics.PointF r0 = (android.graphics.PointF) r0
                r3.add(r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.l.d.d(java.util.ArrayList):java.util.ArrayList");
        }

        private void e() {
            GLES20.glGenTextures(1, this.e, 0);
            GLES20.glBindTexture(3553, this.e[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1024);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            if (this.b.length < 256 || this.c.length < 256 || this.d.length < 256 || this.a.length < 256) {
                return;
            }
            for (int i = 0; i < 256; i++) {
                float f = i;
                int iMin = (int) Math.min(Math.max(this.b[i] + f, 0.0f), 255.0f);
                int iMin2 = (int) Math.min(Math.max(this.c[i] + f, 0.0f), 255.0f);
                int iMin3 = (int) Math.min(Math.max(f + this.d[i], 0.0f), 255.0f);
                byteBufferAllocateDirect.put((byte) Math.min(Math.max(iMin3 + this.a[iMin3], 0.0f), 255.0f));
                byteBufferAllocateDirect.put((byte) Math.min(Math.max(iMin2 + this.a[iMin2], 0.0f), 255.0f));
                byteBufferAllocateDirect.put((byte) Math.min(Math.max(iMin + this.a[iMin], 0.0f), 255.0f));
                byteBufferAllocateDirect.put((byte) -1);
            }
            byteBufferAllocateDirect.position(0);
            GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, byteBufferAllocateDirect);
        }

        public int a() {
            return this.e[0];
        }
    }

    public l(boolean z, l.b bVar) {
        this.i1 = z;
        this.j1 = bVar;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.b1 = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f});
        this.b1.position(0);
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        this.d1 = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.d1.position(0);
        ByteBuffer byteBufferAllocateDirect3 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer3 = byteBufferAllocateDirect3.asFloatBuffer();
        this.c1 = floatBufferAsFloatBuffer3;
        floatBufferAsFloatBuffer3.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        this.c1.position(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String A(int i, float f) {
        int i2;
        float[] fArr = new float[(i * 2) + 1];
        float f2 = 0.0f;
        int i3 = 0;
        while (true) {
            i2 = i + 1;
            if (i3 >= i2) {
                break;
            }
            double d2 = f;
            float fSqrt = (float) ((1.0d / Math.sqrt(Math.pow(d2, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i3, 2.0d)) / (Math.pow(d2, 2.0d) * 2.0d)));
            fArr[i3] = fSqrt;
            f2 = i3 == 0 ? f2 + fSqrt : (float) (f2 + (fSqrt * 2.0d));
            i3++;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            fArr[i4] = fArr[i4] / f2;
        }
        int iMin = Math.min((i / 2) + (i % 2), 7);
        float[] fArr2 = new float[iMin];
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = i5 * 2;
            int i7 = i6 + 1;
            float f3 = fArr[i7];
            int i8 = i6 + 2;
            float f4 = fArr[i8];
            fArr2[i5] = ((f3 * i7) + (f4 * i8)) / (f3 + f4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("attribute vec4 position;\n");
        sb.append("attribute vec4 inputTexCoord;\n");
        sb.append("uniform float texelWidthOffset;\n");
        sb.append("uniform float texelHeightOffset;\n");
        sb.append(String.format(Locale.US, "varying vec2 blurCoordinates[%d];\n", Integer.valueOf((iMin * 2) + 1)));
        sb.append("void main()\n");
        sb.append("{\n");
        sb.append("gl_Position = position;\n");
        sb.append("vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n");
        sb.append("blurCoordinates[0] = inputTexCoord.xy;\n");
        for (int i9 = 0; i9 < iMin; i9++) {
            int i10 = i9 * 2;
            sb.append(String.format(Locale.US, "blurCoordinates[%d] = inputTexCoord.xy + singleStepOffset * %f;\nblurCoordinates[%d] = inputTexCoord.xy - singleStepOffset * %f;\n", Integer.valueOf(i10 + 1), Float.valueOf(fArr2[i9]), Integer.valueOf(i10 + 2), Float.valueOf(fArr2[i9])));
        }
        sb.append("}");
        return sb.toString();
    }

    private Bitmap d(Bitmap bitmap, int i, float f) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String j(int i, float f) {
        int i2;
        float[] fArr = new float[(i * 2) + 1];
        float f2 = 0.0f;
        int i3 = 0;
        while (true) {
            i2 = i + 1;
            if (i3 >= i2) {
                break;
            }
            double d2 = f;
            float fSqrt = (float) ((1.0d / Math.sqrt(Math.pow(d2, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i3, 2.0d)) / (Math.pow(d2, 2.0d) * 2.0d)));
            fArr[i3] = fSqrt;
            f2 = i3 == 0 ? f2 + fSqrt : (float) (f2 + (fSqrt * 2.0d));
            i3++;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            fArr[i4] = fArr[i4] / f2;
        }
        int i5 = (i / 2) + (i % 2);
        int iMin = Math.min(i5, 7);
        StringBuilder sb = new StringBuilder();
        sb.append("uniform sampler2D sTexture;\n");
        sb.append("uniform highp float texelWidthOffset;\n");
        sb.append("uniform highp float texelHeightOffset;\n");
        Locale locale = Locale.US;
        sb.append(String.format(locale, "varying highp vec2 blurCoordinates[%d];\n", Integer.valueOf((iMin * 2) + 1)));
        sb.append("void main()\n");
        sb.append("{\n");
        sb.append("lowp vec4 sum = vec4(0.0);\n");
        sb.append(String.format(locale, "sum += texture2D(sTexture, blurCoordinates[0]) * %f;\n", Float.valueOf(fArr[0])));
        for (int i6 = 0; i6 < iMin; i6++) {
            int i7 = i6 * 2;
            int i8 = i7 + 1;
            int i9 = i7 + 2;
            float f3 = fArr[i8] + fArr[i9];
            Locale locale2 = Locale.US;
            sb.append(String.format(locale2, "sum += texture2D(sTexture, blurCoordinates[%d]) * %f;\n", Integer.valueOf(i8), Float.valueOf(f3)));
            sb.append(String.format(locale2, "sum += texture2D(sTexture, blurCoordinates[%d]) * %f;\n", Integer.valueOf(i9), Float.valueOf(f3)));
        }
        if (i5 > iMin) {
            sb.append("highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n");
            while (iMin < i5) {
                int i10 = iMin * 2;
                int i11 = i10 + 1;
                float f4 = fArr[i11];
                int i12 = i10 + 2;
                float f5 = fArr[i12];
                float f6 = f4 + f5;
                float f7 = ((f4 * i11) + (f5 * i12)) / f6;
                Locale locale3 = Locale.US;
                sb.append(String.format(locale3, "sum += texture2D(sTexture, blurCoordinates[0] + singleStepOffset * %f) * %f;\n", Float.valueOf(f7), Float.valueOf(f6)));
                sb.append(String.format(locale3, "sum += texture2D(sTexture, blurCoordinates[0] - singleStepOffset * %f) * %f;\n", Float.valueOf(f7), Float.valueOf(f6)));
                iMin++;
            }
        }
        sb.append("gl_FragColor = sum;\n");
        sb.append("}\n");
        return sb.toString();
    }

    public static c k(MediaController.n nVar) {
        return new a(nVar);
    }

    public static int r(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.b(GLES20.glGetShaderInfoLog(iGlCreateShader));
            AbstractC6403Nl2.b("shader code:\n " + str);
        }
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    private void s(Bitmap bitmap, int i, int i2, int i3) {
        float width;
        Bitmap bitmapD = bitmap;
        this.Z0 = i2;
        this.a1 = i3;
        if (this.W0 == null) {
            int[] iArr = new int[4];
            this.W0 = iArr;
            GLES20.glGenFramebuffers(4, iArr, 0);
            GLES20.glGenTextures(4, this.U0, 0);
        }
        if (bitmapD != null && !bitmap.isRecycled()) {
            GLES20.glGenTextures(1, this.V0, 0);
            float fG0 = AbstractC21455b.g0();
            boolean z = this.k1;
            if ((z && (this.Z0 > fG0 || this.a1 > fG0)) || i % 360 != 0) {
                if (!z || (this.Z0 <= fG0 && this.a1 <= fG0)) {
                    width = 1.0f;
                } else {
                    width = fG0 / bitmap.getWidth();
                    float height = fG0 / bitmap.getHeight();
                    if (width < height) {
                        this.Z0 = (int) fG0;
                        this.a1 = (int) (bitmap.getHeight() * width);
                    } else {
                        this.a1 = (int) fG0;
                        this.Z0 = (int) (bitmap.getWidth() * height);
                        width = height;
                    }
                }
                int i4 = i % 360;
                if (i4 == 90 || i4 == 270) {
                    int i5 = this.Z0;
                    this.Z0 = this.a1;
                    this.a1 = i5;
                }
                bitmapD = d(bitmapD, i, width);
            }
            GLES20.glBindTexture(3553, this.V0[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmapD, 0);
        }
        for (int i6 = 0; i6 < 2; i6++) {
            GLES20.glBindTexture(3553, this.U0[i6]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexImage2D(3553, 0, 6408, this.Z0, this.a1, 0, 6408, 5121, null);
        }
    }

    private boolean y() {
        int iR;
        int iR2;
        int iR3;
        int iR4;
        int iR5;
        int iR6;
        l.b bVar = this.j1;
        int iA = bVar != null ? bVar.a() : 0;
        int i = 2;
        int i2 = 1;
        String strS = iA == 1 ? RLottieDrawable.S(null, AbstractC19363qD5.yuv_hlg2rgb) : iA == 2 ? RLottieDrawable.S(null, AbstractC19363qD5.yuv_pq2rgb) : "";
        boolean z = this.i1;
        String str = z ? "#extension GL_OES_EGL_image_external : require" : "";
        String str2 = z ? "samplerExternalOES" : "sampler2D";
        int[] iArr = new int[1];
        int i3 = 0;
        while (true) {
            boolean z2 = this.i1;
            int[] iArr2 = iArr;
            if (i3 >= (z2 ? i : i2)) {
                if (z2) {
                    if (iA != 0) {
                        iR = r(35633, "#version 320 es\nin vec4 position;uniform mat4 videoMatrix;in vec4 inputTexCoord;out vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = vec2(videoMatrix * inputTexCoord).xy;}");
                        iR2 = r(35632, String.format(Locale.US, "%1$s\nin highp vec2 vTextureCoord;out vec4 fragColor;void main() {vec4 inp = TEX(vTextureCoord);vec4 image = vec4(inp.rgb * pow(2.0, -1.0), inp.w);vec4 base = vec4(image.g, image.g, image.g, 1.0);vec4 overlay = vec4(image.b, image.b, image.b, 1.0);float ba = 2.0 * overlay.b * base.b + overlay.b * (1.0 - base.a) + base.b * (1.0 - overlay.a);fragColor = vec4(ba,ba,ba,image.a);}", strS));
                    } else {
                        iR2 = 0;
                        iR = 0;
                    }
                    if (iR == 0 || iR2 == 0) {
                        iR = r(35633, "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = vec2(videoMatrix * inputTexCoord).xy;}");
                        iR2 = r(35632, String.format(Locale.US, "%1$s\nprecision lowp float;varying highp vec2 vTextureCoord;uniform %2$s sTexture;void main() {vec4 inp = texture2D(sTexture, vTextureCoord);vec4 image = vec4(inp.rgb * pow(2.0, -1.0), inp.w);vec4 base = vec4(image.g, image.g, image.g, 1.0);vec4 overlay = vec4(image.b, image.b, image.b, 1.0);float ba = 2.0 * overlay.b * base.b + overlay.b * (1.0 - base.a) + base.b * (1.0 - overlay.a);gl_FragColor = vec4(ba,ba,ba,image.a);}", str, str2));
                    }
                } else {
                    iR = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
                    iR2 = r(35632, String.format(Locale.US, "%1$s\nprecision lowp float;varying highp vec2 vTextureCoord;uniform %2$s sTexture;void main() {vec4 inp = texture2D(sTexture, vTextureCoord);vec4 image = vec4(inp.rgb * pow(2.0, -1.0), inp.w);vec4 base = vec4(image.g, image.g, image.g, 1.0);vec4 overlay = vec4(image.b, image.b, image.b, 1.0);float ba = 2.0 * overlay.b * base.b + overlay.b * (1.0 - base.a) + base.b * (1.0 - overlay.a);gl_FragColor = vec4(ba,ba,ba,image.a);}", str, str2));
                }
                int i4 = iR;
                GLES20.glDeleteProgram(this.i);
                if (i4 == 0 || iR2 == 0) {
                    return false;
                }
                int iGlCreateProgram = GLES20.glCreateProgram();
                this.i = iGlCreateProgram;
                GLES20.glAttachShader(iGlCreateProgram, i4);
                GLES20.glAttachShader(this.i, iR2);
                GLES20.glBindAttribLocation(this.i, 0, "position");
                GLES20.glBindAttribLocation(this.i, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.i);
                GLES20.glGetProgramiv(this.i, 35714, iArr2, 0);
                if (iArr2[0] == 0) {
                    GLES20.glDeleteProgram(this.i);
                    this.i = 0;
                } else {
                    this.j = GLES20.glGetAttribLocation(this.i, "position");
                    this.k = GLES20.glGetAttribLocation(this.i, "inputTexCoord");
                    this.l = GLES20.glGetUniformLocation(this.i, "sTexture");
                    if (this.i1) {
                        this.m = GLES20.glGetUniformLocation(this.i, "videoMatrix");
                        this.n = GLES20.glGetUniformLocation(this.i, "texSize");
                    }
                }
                if (this.i1) {
                    if (iA != 0) {
                        iR3 = r(35633, "#version 320 es\nin vec4 position;uniform mat4 videoMatrix;in vec4 inputTexCoord;out vec2 vTextureCoord;out vec2 texCoord2;void main() {gl_Position = position;vTextureCoord = vec2(videoMatrix * inputTexCoord).xy;texCoord2 = inputTexCoord.xy;}");
                        iR4 = r(35632, String.format(Locale.US, "%1$s\nin highp vec2 vTextureCoord;in highp vec2 texCoord2;uniform sampler2D toneCurveTexture;uniform sampler2D inputImageTexture3;uniform lowp float mixturePercent;out vec4 fragColor;void main() {vec4 image = TEX(vTextureCoord);vec4 mask = texture(inputImageTexture3, texCoord2);float redCurveValue = texture(toneCurveTexture, vec2(image.r, 0.0)).r;float greenCurveValue = texture(toneCurveTexture, vec2(image.g, 0.0)).g;float blueCurveValue = texture(toneCurveTexture, vec2(image.b, 0.0)).b;vec4 result = vec4(redCurveValue, greenCurveValue, blueCurveValue, image.a);vec4 tone = mix(image, result, mixturePercent);fragColor = vec4(mix(image.rgb, tone.rgb, 1.0 - mask.b), 1.0);}", strS));
                    } else {
                        iR3 = 0;
                        iR4 = 0;
                    }
                    if (iR3 == 0 || iR4 == 0) {
                        iR3 = r(35633, "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 vTextureCoord;varying vec2 texCoord2;void main() {gl_Position = position;vTextureCoord = vec2(videoMatrix * inputTexCoord).xy;texCoord2 = inputTexCoord.xy;}");
                        iR4 = r(35632, String.format(Locale.US, "%1$s\nprecision lowp float;varying highp vec2 vTextureCoord;varying highp vec2 texCoord2;uniform %2$s sTexture;uniform sampler2D toneCurveTexture;uniform sampler2D inputImageTexture3;uniform lowp float mixturePercent;void main() {vec4 image = texture2D(sTexture, vTextureCoord);vec4 mask = texture2D(inputImageTexture3, texCoord2);float redCurveValue = texture2D(toneCurveTexture, vec2(image.r, 0.0)).r;float greenCurveValue = texture2D(toneCurveTexture, vec2(image.g, 0.0)).g;float blueCurveValue = texture2D(toneCurveTexture, vec2(image.b, 0.0)).b;vec4 result = vec4(redCurveValue, greenCurveValue, blueCurveValue, image.a);vec4 tone = mix(image, result, mixturePercent);gl_FragColor = vec4(mix(image.rgb, tone.rgb, 1.0 - mask.b), 1.0);}", str, str2));
                    }
                } else {
                    iR3 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;varying vec2 texCoord2;void main() {gl_Position = position;vTextureCoord = inputTexCoord;texCoord2 = inputTexCoord;}");
                    iR4 = r(35632, String.format(Locale.US, "%1$s\nprecision lowp float;varying highp vec2 vTextureCoord;varying highp vec2 texCoord2;uniform %2$s sTexture;uniform sampler2D toneCurveTexture;uniform sampler2D inputImageTexture3;uniform lowp float mixturePercent;void main() {vec4 image = texture2D(sTexture, vTextureCoord);vec4 mask = texture2D(inputImageTexture3, texCoord2);float redCurveValue = texture2D(toneCurveTexture, vec2(image.r, 0.0)).r;float greenCurveValue = texture2D(toneCurveTexture, vec2(image.g, 0.0)).g;float blueCurveValue = texture2D(toneCurveTexture, vec2(image.b, 0.0)).b;vec4 result = vec4(redCurveValue, greenCurveValue, blueCurveValue, image.a);vec4 tone = mix(image, result, mixturePercent);gl_FragColor = vec4(mix(image.rgb, tone.rgb, 1.0 - mask.b), 1.0);}", str, str2));
                }
                GLES20.glDeleteProgram(this.u);
                if (iR3 == 0 || iR4 == 0) {
                    return false;
                }
                int iGlCreateProgram2 = GLES20.glCreateProgram();
                this.u = iGlCreateProgram2;
                GLES20.glAttachShader(iGlCreateProgram2, iR3);
                GLES20.glAttachShader(this.u, iR4);
                GLES20.glBindAttribLocation(this.u, 0, "position");
                GLES20.glBindAttribLocation(this.u, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.u);
                GLES20.glGetProgramiv(this.u, 35714, iArr2, 0);
                if (iArr2[0] == 0) {
                    GLES20.glDeleteProgram(this.u);
                    this.u = 0;
                    return true;
                }
                this.v = GLES20.glGetAttribLocation(this.u, "position");
                this.w = GLES20.glGetAttribLocation(this.u, "inputTexCoord");
                this.x = GLES20.glGetUniformLocation(this.u, "sTexture");
                this.y = GLES20.glGetUniformLocation(this.u, "inputImageTexture3");
                this.z = GLES20.glGetUniformLocation(this.u, "toneCurveTexture");
                this.A = GLES20.glGetUniformLocation(this.u, "mixturePercent");
                if (!this.i1) {
                    return true;
                }
                this.B = GLES20.glGetUniformLocation(this.u, "videoMatrix");
                this.C = GLES20.glGetUniformLocation(this.u, "texSize");
                return true;
            }
            if (i3 == 1 && z2) {
                if (iA != 0) {
                    iR5 = r(35633, "#version 320 es\nin vec4 position;uniform mat4 videoMatrix;in vec4 inputTexCoord;out vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = vec2(videoMatrix * inputTexCoord).xy;}");
                    iR6 = r(35632, String.format(Locale.US, "%1$s\nin vec2 vTextureCoord;out vec4 fragColor;highp vec3 rgb_to_hsv(vec3 c) {highp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);highp vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);highp vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);highp float d = q.x - min(q.w, q.y);highp float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}void main() {vec4 texel = TEX(vTextureCoord);fragColor = vec4(rgb_to_hsv(texel.rgb), texel.a);}", strS));
                } else {
                    iR5 = 0;
                    iR6 = 0;
                }
                if (iR5 == 0 || iR6 == 0) {
                    iR5 = r(35633, "attribute vec4 position;uniform mat4 videoMatrix;attribute vec4 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = vec2(videoMatrix * inputTexCoord).xy;}");
                    iR6 = r(35632, String.format(Locale.US, "%1$s\nprecision highp float;varying vec2 vTextureCoord;uniform %2$s sTexture;vec3 rgb_to_hsv(vec3 c) {vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);float d = q.x - min(q.w, q.y);float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}void main() {vec4 texel = texture2D(sTexture, vTextureCoord);gl_FragColor = vec4(rgb_to_hsv(texel.rgb), texel.a);}", str, str2));
                }
            } else {
                iR5 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
                iR6 = r(35632, String.format(Locale.US, "%1$s\nprecision highp float;varying vec2 vTextureCoord;uniform %2$s sTexture;vec3 rgb_to_hsv(vec3 c) {vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);float d = q.x - min(q.w, q.y);float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}void main() {vec4 texel = texture2D(sTexture, vTextureCoord);gl_FragColor = vec4(rgb_to_hsv(texel.rgb), texel.a);}", "", "sampler2D"));
            }
            GLES20.glDeleteProgram(this.H[i3]);
            if (iR5 == 0 || iR6 == 0) {
                return false;
            }
            this.H[i3] = GLES20.glCreateProgram();
            GLES20.glAttachShader(this.H[i3], iR5);
            GLES20.glAttachShader(this.H[i3], iR6);
            GLES20.glBindAttribLocation(this.H[i3], 0, "position");
            GLES20.glBindAttribLocation(this.H[i3], 1, "inputTexCoord");
            GLES20.glLinkProgram(this.H[i3]);
            GLES20.glGetProgramiv(this.H[i3], 35714, iArr2, 0);
            if (iArr2[0] == 0) {
                GLES20.glDeleteProgram(this.H[i3]);
                this.H[i3] = 0;
            } else {
                this.I[i3] = GLES20.glGetAttribLocation(this.H[i3], "position");
                this.J[i3] = GLES20.glGetAttribLocation(this.H[i3], "inputTexCoord");
                this.K[i3] = GLES20.glGetUniformLocation(this.H[i3], "sTexture");
                if (i3 == 1) {
                    this.L = GLES20.glGetUniformLocation(this.H[i3], "videoMatrix");
                    this.M = GLES20.glGetUniformLocation(this.H[i3], "texSize");
                }
            }
            i3++;
            iArr = iArr2;
            i = 2;
            i2 = 1;
        }
    }

    public boolean c() {
        GLES20.glGenTextures(1, this.X0, 0);
        GLES20.glGenTextures(2, this.S0, 0);
        GLES20.glGenFramebuffers(1, this.T0, 0);
        GLES20.glBindTexture(3553, this.S0[1]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, this.X0[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int[] iArr = new int[1];
        int iR = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
        int iR2 = r(35632, "varying highp vec2 vTextureCoord;uniform sampler2D sTexture;uniform highp float width;uniform highp float height;uniform sampler2D curvesImage;uniform lowp float skipTone;uniform lowp float shadows;const mediump vec3 hsLuminanceWeighting = vec3(0.3, 0.3, 0.3);uniform lowp float highlights;uniform lowp float contrast;uniform lowp float fadeAmount;const mediump vec3 satLuminanceWeighting = vec3(0.2126, 0.7152, 0.0722);uniform lowp float saturation;uniform lowp float shadowsTintIntensity;uniform lowp float highlightsTintIntensity;uniform lowp vec3 shadowsTintColor;uniform lowp vec3 highlightsTintColor;uniform lowp float exposure;uniform lowp float warmth;uniform lowp float grain;const lowp float permTexUnit = 1.0 / 256.0;const lowp float permTexUnitHalf = 0.5 / 256.0;const lowp float grainsize = 2.3;uniform lowp float vignette;highp float getLuma(highp vec3 rgbP) {return (0.299 * rgbP.r) + (0.587 * rgbP.g) + (0.114 * rgbP.b);}lowp vec3 rgbToHsv(lowp vec3 c) {highp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);highp vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);highp vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);highp float d = q.x - min(q.w, q.y);highp float e = 1.0e-10;return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);}lowp vec3 hsvToRgb(lowp vec3 c) {highp vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);highp vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);}highp vec3 rgbToHsl(highp vec3 color) {highp vec3 hsl;highp float fmin = min(min(color.r, color.g), color.b);highp float fmax = max(max(color.r, color.g), color.b);highp float delta = fmax - fmin;hsl.z = (fmax + fmin) / 2.0;if (delta == 0.0) {hsl.x = 0.0;hsl.y = 0.0;} else {if (hsl.z < 0.5) {hsl.y = delta / (fmax + fmin);} else {hsl.y = delta / (2.0 - fmax - fmin);}highp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;highp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;highp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;if (color.r == fmax) {hsl.x = deltaB - deltaG;} else if (color.g == fmax) {hsl.x = (1.0 / 3.0) + deltaR - deltaB;} else if (color.b == fmax) {hsl.x = (2.0 / 3.0) + deltaG - deltaR;}if (hsl.x < 0.0) {hsl.x += 1.0;} else if (hsl.x > 1.0) {hsl.x -= 1.0;}}return hsl;}highp float hueToRgb(highp float f1, highp float f2, highp float hue) {if (hue < 0.0) {hue += 1.0;} else if (hue > 1.0) {hue -= 1.0;}highp float res;if ((6.0 * hue) < 1.0) {res = f1 + (f2 - f1) * 6.0 * hue;} else if ((2.0 * hue) < 1.0) {res = f2;} else if ((3.0 * hue) < 2.0) {res = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;} else {res = f1;}return res;}highp vec3 hslToRgb(highp vec3 hsl) {if (hsl.y == 0.0) {return vec3(hsl.z);} else {highp float f2;if (hsl.z < 0.5) {f2 = hsl.z * (1.0 + hsl.y);} else {f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z);}highp float f1 = 2.0 * hsl.z - f2;return vec3(hueToRgb(f1, f2, hsl.x + (1.0/3.0)), hueToRgb(f1, f2, hsl.x), hueToRgb(f1, f2, hsl.x - (1.0/3.0)));}}highp vec3 rgbToYuv(highp vec3 inP) {highp float luma = getLuma(inP);return vec3(luma, (1.0 / 1.772) * (inP.b - luma), (1.0 / 1.402) * (inP.r - luma));}lowp vec3 yuvToRgb(highp vec3 inP) {return vec3(1.402 * inP.b + inP.r, (inP.r - (0.299 * 1.402 / 0.587) * inP.b - (0.114 * 1.772 / 0.587) * inP.g), 1.772 * inP.g + inP.r);}lowp float easeInOutSigmoid(lowp float value, lowp float strength) {if (value > 0.5) {return 1.0 - pow(2.0 - 2.0 * value, 1.0 / (1.0 - strength)) * 0.5;} else {return pow(2.0 * value, 1.0 / (1.0 - strength)) * 0.5;}}lowp vec3 applyLuminanceCurve(lowp vec3 pixel) {highp float index = floor(clamp(pixel.z / (1.0 / 200.0), 0.0, 199.0));pixel.y = mix(0.0, pixel.y, smoothstep(0.0, 0.1, pixel.z) * (1.0 - smoothstep(0.8, 1.0, pixel.z)));pixel.z = texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).a;return pixel;}lowp vec3 applyRGBCurve(lowp vec3 pixel) {highp float index = floor(clamp(pixel.r / (1.0 / 200.0), 0.0, 199.0));pixel.r = texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).r;index = floor(clamp(pixel.g / (1.0 / 200.0), 0.0, 199.0));pixel.g = clamp(texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).g, 0.0, 1.0);index = floor(clamp(pixel.b / (1.0 / 200.0), 0.0, 199.0));pixel.b = clamp(texture2D(curvesImage, vec2(1.0 / 200.0 * index, 0)).b, 0.0, 1.0);return pixel;}highp vec3 fadeAdjust(highp vec3 color, highp float fadeVal) {return (color * (1.0 - fadeVal)) + ((color + (vec3(-0.9772) * pow(vec3(color), vec3(3.0)) + vec3(1.708) * pow(vec3(color), vec3(2.0)) + vec3(-0.1603) * vec3(color) + vec3(0.2878) - color * vec3(0.9))) * fadeVal);}lowp vec3 tintRaiseShadowsCurve(lowp vec3 color) {return vec3(-0.003671) * pow(color, vec3(3.0)) + vec3(0.3842) * pow(color, vec3(2.0)) + vec3(0.3764) * color + vec3(0.2515);}lowp vec3 tintShadows(lowp vec3 texel, lowp vec3 tintColor, lowp float tintAmount) {return clamp(mix(texel, mix(texel, tintRaiseShadowsCurve(texel), tintColor), tintAmount), 0.0, 1.0);} lowp vec3 tintHighlights(lowp vec3 texel, lowp vec3 tintColor, lowp float tintAmount) {return clamp(mix(texel, mix(texel, vec3(1.0) - tintRaiseShadowsCurve(vec3(1.0) - texel), (vec3(1.0) - tintColor)), tintAmount), 0.0, 1.0);}highp vec4 rnm(in highp vec2 tc) {highp float noise = sin(dot(tc, vec2(12.9898, 78.233))) * 43758.5453;return vec4(fract(noise), fract(noise * 1.2154), fract(noise * 1.3453), fract(noise * 1.3647)) * 2.0 - 1.0;}highp float fade(in highp float t) {return t * t * t * (t * (t * 6.0 - 15.0) + 10.0);}highp float pnoise3D(in highp vec3 p) {highp vec3 pi = permTexUnit * floor(p) + permTexUnitHalf;highp vec3 pf = fract(p);highp float perm = rnm(pi.xy).a;highp float n000 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf);highp float n001 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(0.0, 0.0, 1.0));perm = rnm(pi.xy + vec2(0.0, permTexUnit)).a;highp float n010 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(0.0, 1.0, 0.0));highp float n011 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(0.0, 1.0, 1.0));perm = rnm(pi.xy + vec2(permTexUnit, 0.0)).a;highp float n100 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(1.0, 0.0, 0.0));highp float n101 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(1.0, 0.0, 1.0));perm = rnm(pi.xy + vec2(permTexUnit, permTexUnit)).a;highp float n110 = dot(rnm(vec2(perm, pi.z)).rgb * 4.0 - 1.0, pf - vec3(1.0, 1.0, 0.0));highp float n111 = dot(rnm(vec2(perm, pi.z + permTexUnit)).rgb * 4.0 - 1.0, pf - vec3(1.0, 1.0, 1.0));highp vec4 n_x = mix(vec4(n000, n001, n010, n011), vec4(n100, n101, n110, n111), fade(pf.x));highp vec2 n_xy = mix(n_x.xy, n_x.zw, fade(pf.y));return mix(n_xy.x, n_xy.y, fade(pf.z));}lowp vec2 coordRot(in lowp vec2 tc, in lowp float angle) {return vec2(((tc.x * 2.0 - 1.0) * cos(angle) - (tc.y * 2.0 - 1.0) * sin(angle)) * 0.5 + 0.5, ((tc.y * 2.0 - 1.0) * cos(angle) + (tc.x * 2.0 - 1.0) * sin(angle)) * 0.5 + 0.5);}void main() {lowp vec4 source = texture2D(sTexture, vTextureCoord);lowp vec4 result = source;const lowp float toolEpsilon = 0.005;if (skipTone < toolEpsilon) {result = vec4(applyRGBCurve(hslToRgb(applyLuminanceCurve(rgbToHsl(result.rgb)))), result.a);}mediump float hsLuminance = dot(result.rgb, hsLuminanceWeighting);mediump float shadow = clamp((pow(hsLuminance, 1.0 / shadows) + (-0.76) * pow(hsLuminance, 2.0 / shadows)) - hsLuminance, 0.0, 1.0);mediump float highlight = clamp((1.0 - (pow(1.0 - hsLuminance, 1.0 / (2.0 - highlights)) + (-0.8) * pow(1.0 - hsLuminance, 2.0 / (2.0 - highlights)))) - hsLuminance, -1.0, 0.0);lowp vec3 hsresult = vec3(0.0, 0.0, 0.0) + ((hsLuminance + shadow + highlight) - 0.0) * ((result.rgb - vec3(0.0, 0.0, 0.0)) / (hsLuminance - 0.0));mediump float contrastedLuminance = ((hsLuminance - 0.5) * 1.5) + 0.5;mediump float whiteInterp = contrastedLuminance * contrastedLuminance * contrastedLuminance;mediump float whiteTarget = clamp(highlights, 1.0, 2.0) - 1.0;hsresult = mix(hsresult, vec3(1.0), whiteInterp * whiteTarget);mediump float invContrastedLuminance = 1.0 - contrastedLuminance;mediump float blackInterp = invContrastedLuminance * invContrastedLuminance * invContrastedLuminance;mediump float blackTarget = 1.0 - clamp(shadows, 0.0, 1.0);hsresult = mix(hsresult, vec3(0.0), blackInterp * blackTarget);result = vec4(hsresult.rgb, result.a);result = vec4(clamp(((result.rgb - vec3(0.5)) * contrast + vec3(0.5)), 0.0, 1.0), result.a);if (abs(fadeAmount) > toolEpsilon) {result.rgb = fadeAdjust(result.rgb, fadeAmount);}lowp float satLuminance = dot(result.rgb, satLuminanceWeighting);lowp vec3 greyScaleColor = vec3(satLuminance);result = vec4(clamp(mix(greyScaleColor, result.rgb, saturation), 0.0, 1.0), result.a);if (abs(shadowsTintIntensity) > toolEpsilon) {result.rgb = tintShadows(result.rgb, shadowsTintColor, shadowsTintIntensity * 2.0);}if (abs(highlightsTintIntensity) > toolEpsilon) {result.rgb = tintHighlights(result.rgb, highlightsTintColor, highlightsTintIntensity * 2.0);}if (abs(exposure) > toolEpsilon) {mediump float mag = exposure * 1.045;mediump float exppower = 1.0 + abs(mag);if (mag < 0.0) {exppower = 1.0 / exppower;}result.r = 1.0 - pow((1.0 - result.r), exppower);result.g = 1.0 - pow((1.0 - result.g), exppower);result.b = 1.0 - pow((1.0 - result.b), exppower);}if (abs(warmth) > toolEpsilon) {highp vec3 yuvVec;if (warmth > 0.0 ) {yuvVec = vec3(0.1765, -0.1255, 0.0902);} else {yuvVec = -vec3(0.0588, 0.1569, -0.1255);}highp vec3 yuvColor = rgbToYuv(result.rgb);highp float luma = yuvColor.r;highp float curveScale = sin(luma * 3.14159);yuvColor += 0.375 * warmth * curveScale * yuvVec;result.rgb = yuvToRgb(yuvColor);}if (abs(grain) > toolEpsilon) {highp vec3 rotOffset = vec3(1.425, 3.892, 5.835);highp vec2 rotCoordsR = coordRot(vTextureCoord, rotOffset.x);highp vec3 noise = vec3(pnoise3D(vec3(rotCoordsR * vec2(width / grainsize, height / grainsize),0.0)));lowp vec3 lumcoeff = vec3(0.299,0.587,0.114);lowp float luminance = dot(result.rgb, lumcoeff);lowp float lum = smoothstep(0.2, 0.0, luminance);lum += luminance;noise = mix(noise,vec3(0.0),pow(lum,4.0));result.rgb = result.rgb + noise * grain;}if (abs(vignette) > toolEpsilon) {const lowp float midpoint = 0.7;const lowp float fuzziness = 0.62;lowp float radDist = length(vTextureCoord - 0.5) / sqrt(0.5);lowp float mag = easeInOutSigmoid(radDist * midpoint, fuzziness) * vignette * 0.645;result.rgb = mix(pow(result.rgb, vec3(1.0 / (1.0 - mag))), vec3(0.0), mag * mag);}gl_FragColor = result;}");
        if (iR != 0 && iR2 != 0) {
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.T = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, iR);
            GLES20.glAttachShader(this.T, iR2);
            GLES20.glBindAttribLocation(this.T, 0, "position");
            GLES20.glBindAttribLocation(this.T, 1, "inputTexCoord");
            GLES20.glLinkProgram(this.T);
            GLES20.glGetProgramiv(this.T, 35714, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteProgram(this.T);
                this.T = 0;
            } else {
                this.U = GLES20.glGetAttribLocation(this.T, "position");
                this.V = GLES20.glGetAttribLocation(this.T, "inputTexCoord");
                this.W = GLES20.glGetUniformLocation(this.T, "sTexture");
                this.X = GLES20.glGetUniformLocation(this.T, "shadows");
                this.Y = GLES20.glGetUniformLocation(this.T, "highlights");
                this.Z = GLES20.glGetUniformLocation(this.T, "exposure");
                this.a0 = GLES20.glGetUniformLocation(this.T, "contrast");
                this.b0 = GLES20.glGetUniformLocation(this.T, "saturation");
                this.c0 = GLES20.glGetUniformLocation(this.T, "warmth");
                this.d0 = GLES20.glGetUniformLocation(this.T, "vignette");
                this.e0 = GLES20.glGetUniformLocation(this.T, "grain");
                this.f0 = GLES20.glGetUniformLocation(this.T, "width");
                this.g0 = GLES20.glGetUniformLocation(this.T, "height");
                this.h0 = GLES20.glGetUniformLocation(this.T, "curvesImage");
                this.i0 = GLES20.glGetUniformLocation(this.T, "skipTone");
                this.j0 = GLES20.glGetUniformLocation(this.T, "fadeAmount");
                this.k0 = GLES20.glGetUniformLocation(this.T, "shadowsTintIntensity");
                this.l0 = GLES20.glGetUniformLocation(this.T, "highlightsTintIntensity");
                this.m0 = GLES20.glGetUniformLocation(this.T, "shadowsTintColor");
                this.n0 = GLES20.glGetUniformLocation(this.T, "highlightsTintColor");
            }
            int iR3 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;uniform highp float inputWidth;uniform highp float inputHeight;varying vec2 leftTexCoord;varying vec2 rightTexCoord;varying vec2 topTexCoord;varying vec2 bottomTexCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;highp vec2 widthStep = vec2(1.0 / inputWidth, 0.0);highp vec2 heightStep = vec2(0.0, 1.0 / inputHeight);leftTexCoord = inputTexCoord - widthStep;rightTexCoord = inputTexCoord + widthStep;topTexCoord = inputTexCoord + heightStep;bottomTexCoord = inputTexCoord - heightStep;}");
            int iR4 = r(35632, "precision highp float;varying vec2 vTextureCoord;varying vec2 leftTexCoord;varying vec2 rightTexCoord;varying vec2 topTexCoord;varying vec2 bottomTexCoord;uniform sampler2D sTexture;uniform float sharpen;void main() {vec4 result = texture2D(sTexture, vTextureCoord);vec3 leftTextureColor = texture2D(sTexture, leftTexCoord).rgb;vec3 rightTextureColor = texture2D(sTexture, rightTexCoord).rgb;vec3 topTextureColor = texture2D(sTexture, topTexCoord).rgb;vec3 bottomTextureColor = texture2D(sTexture, bottomTexCoord).rgb;result.rgb = result.rgb * (1.0 + 4.0 * sharpen) - (leftTextureColor + rightTextureColor + topTextureColor + bottomTextureColor) * sharpen;gl_FragColor = result;}");
            if (iR3 != 0 && iR4 != 0) {
                int iGlCreateProgram2 = GLES20.glCreateProgram();
                this.H0 = iGlCreateProgram2;
                GLES20.glAttachShader(iGlCreateProgram2, iR3);
                GLES20.glAttachShader(this.H0, iR4);
                GLES20.glBindAttribLocation(this.H0, 0, "position");
                GLES20.glBindAttribLocation(this.H0, 1, "inputTexCoord");
                GLES20.glLinkProgram(this.H0);
                GLES20.glGetProgramiv(this.H0, 35714, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glDeleteProgram(this.H0);
                    this.H0 = 0;
                } else {
                    this.L0 = GLES20.glGetAttribLocation(this.H0, "position");
                    this.M0 = GLES20.glGetAttribLocation(this.H0, "inputTexCoord");
                    this.N0 = GLES20.glGetUniformLocation(this.H0, "sTexture");
                    this.J0 = GLES20.glGetUniformLocation(this.H0, "inputWidth");
                    this.K0 = GLES20.glGetUniformLocation(this.H0, "inputHeight");
                    this.I0 = GLES20.glGetUniformLocation(this.H0, "sharpen");
                }
                b bVar = new b(8.0f, 3.0f, false);
                this.g = bVar;
                if (!bVar.a() || !y()) {
                    return false;
                }
                int iR5 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
                int iR6 = r(35632, "varying highp vec2 vTextureCoord;uniform sampler2D sTexture;uniform sampler2D inputImageTexture2;uniform lowp float excludeSize;uniform lowp vec2 excludePoint;uniform lowp float excludeBlurSize;uniform highp float angle;uniform highp float aspectRatio;void main() {lowp vec4 sharpImageColor = texture2D(sTexture, vTextureCoord);lowp vec4 blurredImageColor = texture2D(inputImageTexture2, vTextureCoord);highp vec2 texCoordToUse = vec2(vTextureCoord.x, (vTextureCoord.y * aspectRatio + 0.5 - 0.5 * aspectRatio));highp float distanceFromCenter = abs((texCoordToUse.x - excludePoint.x) * aspectRatio * cos(angle) + (texCoordToUse.y - excludePoint.y) * sin(angle));gl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeSize - excludeBlurSize, excludeSize, distanceFromCenter));}");
                if (iR5 != 0 && iR6 != 0) {
                    int iGlCreateProgram3 = GLES20.glCreateProgram();
                    this.o0 = iGlCreateProgram3;
                    GLES20.glAttachShader(iGlCreateProgram3, iR5);
                    GLES20.glAttachShader(this.o0, iR6);
                    GLES20.glBindAttribLocation(this.o0, 0, "position");
                    GLES20.glBindAttribLocation(this.o0, 1, "inputTexCoord");
                    GLES20.glLinkProgram(this.o0);
                    GLES20.glGetProgramiv(this.o0, 35714, iArr, 0);
                    if (iArr[0] == 0) {
                        GLES20.glDeleteProgram(this.o0);
                        this.o0 = 0;
                    } else {
                        this.p0 = GLES20.glGetAttribLocation(this.o0, "position");
                        this.q0 = GLES20.glGetAttribLocation(this.o0, "inputTexCoord");
                        this.r0 = GLES20.glGetUniformLocation(this.o0, "sTexture");
                        this.s0 = GLES20.glGetUniformLocation(this.o0, "inputImageTexture2");
                        this.t0 = GLES20.glGetUniformLocation(this.o0, "excludeSize");
                        this.u0 = GLES20.glGetUniformLocation(this.o0, "excludePoint");
                        this.v0 = GLES20.glGetUniformLocation(this.o0, "excludeBlurSize");
                        this.w0 = GLES20.glGetUniformLocation(this.o0, "angle");
                        this.x0 = GLES20.glGetUniformLocation(this.o0, "aspectRatio");
                    }
                    int iR7 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
                    int iR8 = r(35632, "varying highp vec2 vTextureCoord;uniform sampler2D sTexture;uniform sampler2D inputImageTexture2;uniform lowp float excludeSize;uniform lowp vec2 excludePoint;uniform lowp float excludeBlurSize;uniform highp float aspectRatio;void main() {lowp vec4 sharpImageColor = texture2D(sTexture, vTextureCoord);lowp vec4 blurredImageColor = texture2D(inputImageTexture2, vTextureCoord);highp vec2 texCoordToUse = vec2(vTextureCoord.x, (vTextureCoord.y * aspectRatio + 0.5 - 0.5 * aspectRatio));highp float distanceFromCenter = distance(excludePoint, texCoordToUse);gl_FragColor = mix(sharpImageColor, blurredImageColor, smoothstep(excludeSize - excludeBlurSize, excludeSize, distanceFromCenter));}");
                    if (iR7 != 0 && iR8 != 0) {
                        int iGlCreateProgram4 = GLES20.glCreateProgram();
                        this.y0 = iGlCreateProgram4;
                        GLES20.glAttachShader(iGlCreateProgram4, iR7);
                        GLES20.glAttachShader(this.y0, iR8);
                        GLES20.glBindAttribLocation(this.y0, 0, "position");
                        GLES20.glBindAttribLocation(this.y0, 1, "inputTexCoord");
                        GLES20.glLinkProgram(this.y0);
                        GLES20.glGetProgramiv(this.y0, 35714, iArr, 0);
                        if (iArr[0] == 0) {
                            GLES20.glDeleteProgram(this.y0);
                            this.y0 = 0;
                        } else {
                            this.z0 = GLES20.glGetAttribLocation(this.y0, "position");
                            this.A0 = GLES20.glGetAttribLocation(this.y0, "inputTexCoord");
                            this.B0 = GLES20.glGetUniformLocation(this.y0, "sTexture");
                            this.C0 = GLES20.glGetUniformLocation(this.y0, "inputImageTexture2");
                            this.D0 = GLES20.glGetUniformLocation(this.y0, "excludeSize");
                            this.E0 = GLES20.glGetUniformLocation(this.y0, "excludePoint");
                            this.F0 = GLES20.glGetUniformLocation(this.y0, "excludeBlurSize");
                            this.G0 = GLES20.glGetUniformLocation(this.y0, "aspectRatio");
                        }
                        int iR9 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
                        int iR10 = r(35632, "precision highp float;varying vec2 vTextureCoord;uniform sampler2D sTexture;uniform sampler2D inputImageTexture2;uniform float intensity;float enhance(float value) {const vec2 offset = vec2(0.001953125, 0.03125);value = value + offset.x;vec2 coord = (clamp(vTextureCoord, 0.125, 1.0 - 0.125001) - 0.125) * 4.0;vec2 frac = fract(coord);coord = floor(coord);float p00 = float(coord.y * 4.0 + coord.x) * 0.0625 + offset.y;float p01 = float(coord.y * 4.0 + coord.x + 1.0) * 0.0625 + offset.y;float p10 = float((coord.y + 1.0) * 4.0 + coord.x) * 0.0625 + offset.y;float p11 = float((coord.y + 1.0) * 4.0 + coord.x + 1.0) * 0.0625 + offset.y;vec3 c00 = texture2D(inputImageTexture2, vec2(value, p00)).rgb;vec3 c01 = texture2D(inputImageTexture2, vec2(value, p01)).rgb;vec3 c10 = texture2D(inputImageTexture2, vec2(value, p10)).rgb;vec3 c11 = texture2D(inputImageTexture2, vec2(value, p11)).rgb;float c1 = ((c00.r - c00.g) / (c00.b - c00.g));float c2 = ((c01.r - c01.g) / (c01.b - c01.g));float c3 = ((c10.r - c10.g) / (c10.b - c10.g));float c4 = ((c11.r - c11.g) / (c11.b - c11.g));float c1_2 = mix(c1, c2, frac.x);float c3_4 = mix(c3, c4, frac.x);return mix(c1_2, c3_4, frac.y);}vec3 hsv_to_rgb(vec3 c) {vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);}void main() {vec4 texel = texture2D(sTexture, vTextureCoord);vec4 hsv = texel;hsv.y = min(1.0, hsv.y * 1.2);hsv.z = min(1.0, enhance(hsv.z) * 1.1);gl_FragColor = vec4(hsv_to_rgb(mix(texel.xyz, hsv.xyz, intensity)), texel.w);}");
                        if (iR9 != 0 && iR10 != 0) {
                            int iGlCreateProgram5 = GLES20.glCreateProgram();
                            this.N = iGlCreateProgram5;
                            GLES20.glAttachShader(iGlCreateProgram5, iR9);
                            GLES20.glAttachShader(this.N, iR10);
                            GLES20.glBindAttribLocation(this.N, 0, "position");
                            GLES20.glBindAttribLocation(this.N, 1, "inputTexCoord");
                            GLES20.glLinkProgram(this.N);
                            GLES20.glGetProgramiv(this.N, 35714, iArr, 0);
                            if (iArr[0] == 0) {
                                GLES20.glDeleteProgram(this.N);
                                this.N = 0;
                            } else {
                                this.O = GLES20.glGetAttribLocation(this.N, "position");
                                this.P = GLES20.glGetAttribLocation(this.N, "inputTexCoord");
                                this.Q = GLES20.glGetUniformLocation(this.N, "sTexture");
                                this.R = GLES20.glGetUniformLocation(this.N, "intensity");
                                this.S = GLES20.glGetUniformLocation(this.N, "inputImageTexture2");
                            }
                            int iR11 = r(35632, "precision lowp float;varying highp vec2 vTextureCoord;varying highp vec2 texCoord2;uniform sampler2D sTexture;uniform sampler2D inputImageTexture2;void main() {vec4 image = texture2D(sTexture, vTextureCoord);vec4 blurredImage = texture2D(inputImageTexture2, texCoord2);gl_FragColor = vec4((image.rgb - blurredImage.rgb + vec3(0.5,0.5,0.5)), image.a);}");
                            int iR12 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;varying vec2 texCoord2;void main() {gl_Position = position;vTextureCoord = inputTexCoord;texCoord2 = inputTexCoord;}");
                            if (iR12 != 0 && iR11 != 0) {
                                int iGlCreateProgram6 = GLES20.glCreateProgram();
                                this.p = iGlCreateProgram6;
                                GLES20.glAttachShader(iGlCreateProgram6, iR12);
                                GLES20.glAttachShader(this.p, iR11);
                                GLES20.glBindAttribLocation(this.p, 0, "position");
                                GLES20.glBindAttribLocation(this.p, 1, "inputTexCoord");
                                GLES20.glLinkProgram(this.p);
                                GLES20.glGetProgramiv(this.p, 35714, iArr, 0);
                                if (iArr[0] == 0) {
                                    GLES20.glDeleteProgram(this.p);
                                    this.p = 0;
                                } else {
                                    this.q = GLES20.glGetAttribLocation(this.p, "position");
                                    this.r = GLES20.glGetAttribLocation(this.p, "inputTexCoord");
                                    this.s = GLES20.glGetUniformLocation(this.p, "sTexture");
                                    this.t = GLES20.glGetUniformLocation(this.p, "inputImageTexture2");
                                }
                                int iR13 = r(35632, "precision lowp float;varying highp vec2 vTextureCoord;uniform sampler2D sTexture;void main() {vec4 color = texture2D(sTexture, vTextureCoord);float hardLightColor = color.b;for (int i = 0; i < 3; ++i){if (hardLightColor < 0.5) {hardLightColor = hardLightColor * hardLightColor * 2.0;} else {hardLightColor = 1.0 - (1.0 - hardLightColor) * (1.0 - hardLightColor) * 2.0;}}float k = 255.0 / (164.0 - 75.0);hardLightColor = (hardLightColor - 75.0 / 255.0) * k;gl_FragColor = vec4(vec3(hardLightColor), color.a);}");
                                int iR14 = r(35633, "attribute vec4 position;attribute vec2 inputTexCoord;varying vec2 vTextureCoord;void main() {gl_Position = position;vTextureCoord = inputTexCoord;}");
                                if (iR14 != 0 && iR13 != 0) {
                                    int iGlCreateProgram7 = GLES20.glCreateProgram();
                                    this.D = iGlCreateProgram7;
                                    GLES20.glAttachShader(iGlCreateProgram7, iR14);
                                    GLES20.glAttachShader(this.D, iR13);
                                    GLES20.glBindAttribLocation(this.D, 0, "position");
                                    GLES20.glBindAttribLocation(this.D, 1, "inputTexCoord");
                                    GLES20.glLinkProgram(this.D);
                                    GLES20.glGetProgramiv(this.D, 35714, iArr, 0);
                                    if (iArr[0] == 0) {
                                        GLES20.glDeleteProgram(this.D);
                                        this.D = 0;
                                    } else {
                                        this.E = GLES20.glGetAttribLocation(this.D, "position");
                                        this.F = GLES20.glGetAttribLocation(this.D, "inputTexCoord");
                                        this.G = GLES20.glGetUniformLocation(this.D, "sTexture");
                                    }
                                    this.o = new d();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean e() {
        c cVar;
        c cVar2 = this.h1;
        int blurType = cVar2 != null ? cVar2.getBlurType() : 0;
        if (this.i1 || (cVar = this.h1) == null || cVar.a() || blurType == 0) {
            return false;
        }
        if (this.a) {
            if (!this.c) {
                GLES20.glBindTexture(3553, this.U0[2]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, this.Z0, this.a1, 0, 6408, 5121, null);
                this.c = true;
            }
            GLES20.glUseProgram(this.g.c);
            GLES20.glUniform1i(this.g.f, 0);
            GLES20.glEnableVertexAttribArray(this.g.e);
            GLES20.glVertexAttribPointer(this.g.e, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.g.d);
            GLES20.glVertexAttribPointer(this.g.d, 2, 5126, false, 8, (Buffer) this.d1);
            GLES20.glBindFramebuffer(36160, this.W0[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[0], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.U0[1]);
            GLES20.glUniform1f(this.g.g, 0.0f);
            GLES20.glUniform1f(this.g.h, 1.0f / this.a1);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindFramebuffer(36160, this.W0[2]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[2], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.U0[0]);
            GLES20.glUniform1f(this.g.g, 1.0f / this.Z0);
            GLES20.glUniform1f(this.g.h, 0.0f);
            GLES20.glDrawArrays(5, 0, 4);
            this.a = false;
        }
        GLES20.glBindFramebuffer(36160, this.W0[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[0], 0);
        if (blurType == 1) {
            GLES20.glUseProgram(this.y0);
            GLES20.glUniform1i(this.B0, 0);
            GLES20.glUniform1i(this.C0, 1);
            GLES20.glUniform1f(this.D0, this.h1.getBlurExcludeSize());
            GLES20.glUniform1f(this.F0, this.h1.getBlurExcludeBlurSize());
            C22697vg5 blurExcludePoint = this.h1.getBlurExcludePoint();
            GLES20.glUniform2f(this.E0, blurExcludePoint.a, blurExcludePoint.b);
            GLES20.glUniform1f(this.G0, this.a1 / this.Z0);
            GLES20.glEnableVertexAttribArray(this.A0);
            GLES20.glVertexAttribPointer(this.A0, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.z0);
            GLES20.glVertexAttribPointer(this.z0, 2, 5126, false, 8, (Buffer) this.d1);
        } else if (blurType == 2) {
            GLES20.glUseProgram(this.o0);
            GLES20.glUniform1i(this.r0, 0);
            GLES20.glUniform1i(this.s0, 1);
            GLES20.glUniform1f(this.t0, this.h1.getBlurExcludeSize());
            GLES20.glUniform1f(this.v0, this.h1.getBlurExcludeBlurSize());
            GLES20.glUniform1f(this.w0, this.h1.getBlurAngle());
            C22697vg5 blurExcludePoint2 = this.h1.getBlurExcludePoint();
            GLES20.glUniform2f(this.u0, blurExcludePoint2.a, blurExcludePoint2.b);
            GLES20.glUniform1f(this.x0, this.a1 / this.Z0);
            GLES20.glEnableVertexAttribArray(this.q0);
            GLES20.glVertexAttribPointer(this.q0, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.p0);
            GLES20.glVertexAttribPointer(this.p0, 2, 5126, false, 8, (Buffer) this.d1);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.U0[1]);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.U0[2]);
        GLES20.glDrawArrays(5, 0, 4);
        return true;
    }

    public void f() {
        GLES20.glBindFramebuffer(36160, this.W0[!this.i1 ? 1 : 0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[!this.i1 ? 1 : 0], 0);
        GLES20.glUseProgram(this.T);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.U0[this.i1 ? 1 : 0]);
        GLES20.glUniform1i(this.W, 0);
        c cVar = this.h1;
        if (cVar == null || cVar.a()) {
            GLES20.glUniform1f(this.X, 1.0f);
            GLES20.glUniform1f(this.Y, 1.0f);
            GLES20.glUniform1f(this.Z, 0.0f);
            GLES20.glUniform1f(this.a0, 1.0f);
            GLES20.glUniform1f(this.b0, 1.0f);
            GLES20.glUniform1f(this.c0, 0.0f);
            GLES20.glUniform1f(this.d0, 0.0f);
            GLES20.glUniform1f(this.e0, 0.0f);
            GLES20.glUniform1f(this.j0, 0.0f);
            GLES20.glUniform3f(this.n0, 0.0f, 0.0f, 0.0f);
            GLES20.glUniform1f(this.l0, 0.0f);
            GLES20.glUniform3f(this.m0, 0.0f, 0.0f, 0.0f);
            GLES20.glUniform1f(this.k0, 0.0f);
            GLES20.glUniform1f(this.i0, 1.0f);
        } else {
            GLES20.glUniform1f(this.X, this.h1.getShadowsValue());
            GLES20.glUniform1f(this.Y, this.h1.getHighlightsValue());
            GLES20.glUniform1f(this.Z, this.h1.getExposureValue());
            GLES20.glUniform1f(this.a0, this.h1.getContrastValue());
            GLES20.glUniform1f(this.b0, this.h1.getSaturationValue());
            GLES20.glUniform1f(this.c0, this.h1.getWarmthValue());
            GLES20.glUniform1f(this.d0, this.h1.getVignetteValue());
            GLES20.glUniform1f(this.e0, this.h1.getGrainValue());
            GLES20.glUniform1f(this.j0, this.h1.getFadeValue());
            int tintHighlightsColor = this.h1.getTintHighlightsColor();
            int tintShadowsColor = this.h1.getTintShadowsColor();
            GLES20.glUniform3f(this.n0, ((tintHighlightsColor >> 16) & 255) / 255.0f, ((tintHighlightsColor >> 8) & 255) / 255.0f, (tintHighlightsColor & 255) / 255.0f);
            GLES20.glUniform1f(this.l0, this.h1.getTintHighlightsIntensityValue());
            GLES20.glUniform3f(this.m0, ((tintShadowsColor >> 16) & 255) / 255.0f, ((tintShadowsColor >> 8) & 255) / 255.0f, (tintShadowsColor & 255) / 255.0f);
            GLES20.glUniform1f(this.k0, this.h1.getTintShadowsIntensityValue());
            boolean zB = this.h1.b();
            GLES20.glUniform1f(this.i0, zB ? 0.0f : 1.0f);
            if (zB) {
                ByteBuffer byteBufferD = this.h1.d();
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, this.X0[0]);
                GLES20.glTexImage2D(3553, 0, 6408, 200, 1, 0, 6408, 5121, byteBufferD);
                GLES20.glUniform1i(this.h0, 1);
            }
        }
        GLES20.glUniform1f(this.f0, this.Z0);
        GLES20.glUniform1f(this.g0, this.a1);
        GLES20.glEnableVertexAttribArray(this.V);
        GLES20.glVertexAttribPointer(this.V, 2, 5126, false, 8, (Buffer) this.c1);
        GLES20.glEnableVertexAttribArray(this.U);
        GLES20.glVertexAttribPointer(this.U, 2, 5126, false, 8, (Buffer) this.d1);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void g() {
        char c2;
        boolean z = this.i1;
        if (z ? true : !this.Y0) {
            if (!z || this.h) {
                GLES20.glUseProgram(this.H[0]);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.h ? this.U0[1] : this.V0[0]);
                c2 = 0;
            } else {
                GLES20.glUseProgram(this.H[1]);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(36197, this.O0);
                GLES20.glUniformMatrix4fv(this.L, 1, false, this.R0, 0);
                int i = this.M;
                if (i != -1) {
                    GLES20.glUniform2f(i, this.Z0, this.a1);
                }
                c2 = 1;
            }
            GLES20.glUniform1i(this.K[c2], 0);
            GLES20.glEnableVertexAttribArray(this.J[c2]);
            GLES20.glVertexAttribPointer(this.J[c2], 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.I[c2]);
            GLES20.glVertexAttribPointer(this.I[c2], 2, 5126, false, 8, (Buffer) (this.i1 ? this.d1 : this.b1));
            GLES20.glBindFramebuffer(36160, this.T0[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.S0[0], 0);
            GLES20.glDrawArrays(5, 0, 4);
        }
        if (!this.Y0) {
            int i2 = this.Z0 * this.a1 * 4;
            ByteBuffer byteBuffer = this.e1;
            if (byteBuffer == null || i2 > byteBuffer.capacity()) {
                this.e1 = ByteBuffer.allocateDirect(i2);
            }
            if (this.f1 == null) {
                this.f1 = ByteBuffer.allocateDirect(16384);
            }
            if (this.g1 == null) {
                this.g1 = ByteBuffer.allocateDirect(32896);
            }
            GLES20.glReadPixels(0, 0, this.Z0, this.a1, 6408, 5121, this.e1);
            Utilities.calcCDT(this.e1, this.Z0, this.a1, this.f1, this.g1);
            GLES20.glBindTexture(3553, this.S0[1]);
            GLES20.glTexImage2D(3553, 0, 6408, 256, 16, 0, 6408, 5121, this.f1);
            if (!this.i1) {
                this.e1 = null;
                this.f1 = null;
                this.g1 = null;
            }
            this.Y0 = true;
        }
        GLES20.glBindFramebuffer(36160, this.W0[1]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[1], 0);
        GLES20.glUseProgram(this.N);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.S0[0]);
        GLES20.glUniform1i(this.Q, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.S0[1]);
        GLES20.glUniform1i(this.S, 1);
        c cVar = this.h1;
        if (cVar == null || cVar.a()) {
            GLES20.glUniform1f(this.R, 0.0f);
        } else {
            GLES20.glUniform1f(this.R, this.h1.getEnhanceValue());
        }
        GLES20.glEnableVertexAttribArray(this.P);
        GLES20.glVertexAttribPointer(this.P, 2, 5126, false, 8, (Buffer) this.c1);
        GLES20.glEnableVertexAttribArray(this.O);
        GLES20.glVertexAttribPointer(this.O, 2, 5126, false, 8, (Buffer) this.b1);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public void h() {
        if (this.i1) {
            return;
        }
        GLES20.glBindFramebuffer(36160, this.W0[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[0], 0);
        GLES20.glUseProgram(this.H0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.U0[1]);
        GLES20.glUniform1i(this.N0, 0);
        c cVar = this.h1;
        if (cVar == null || cVar.a()) {
            GLES20.glUniform1f(this.I0, 0.0f);
        } else {
            GLES20.glUniform1f(this.I0, this.h1.getSharpenValue());
        }
        GLES20.glUniform1f(this.J0, this.Z0);
        GLES20.glUniform1f(this.K0, this.a1);
        GLES20.glEnableVertexAttribArray(this.M0);
        GLES20.glVertexAttribPointer(this.M0, 2, 5126, false, 8, (Buffer) this.c1);
        GLES20.glEnableVertexAttribArray(this.L0);
        GLES20.glVertexAttribPointer(this.L0, 2, 5126, false, 8, (Buffer) this.d1);
        GLES20.glDrawArrays(5, 0, 4);
    }

    public boolean i() {
        int i;
        c cVar = this.h1;
        if (cVar == null || cVar.a() || this.h1.getSoftenSkinValue() <= 0.0f || (i = this.Z0) <= 0 || this.a1 <= 0) {
            if (this.h) {
                this.Y0 = false;
                this.h = false;
            }
            return false;
        }
        if (this.b || this.i1) {
            float f = i * 0.006f;
            if (this.e == null || Math.abs(this.f - f) > 1.0E-4d) {
                b bVar = this.e;
                if (bVar != null) {
                    bVar.b();
                }
                this.f = f;
                b bVar2 = new b(f, 2.0f, true);
                this.e = bVar2;
                bVar2.a();
            }
            if (!this.d) {
                GLES20.glBindTexture(3553, this.U0[3]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexImage2D(3553, 0, 6408, this.Z0, this.a1, 0, 6408, 5121, null);
                this.d = true;
            }
            GLES20.glUseProgram(this.i);
            GLES20.glUniform1i(this.l, 0);
            GLES20.glEnableVertexAttribArray(this.k);
            GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.j);
            if (this.i1) {
                GLES20.glUniformMatrix4fv(this.m, 1, false, this.R0, 0);
                int i2 = this.n;
                if (i2 != -1) {
                    GLES20.glUniform2f(i2, this.Z0, this.a1);
                }
            }
            GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 8, (Buffer) this.d1);
            GLES20.glBindFramebuffer(36160, this.W0[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[0], 0);
            GLES20.glActiveTexture(33984);
            if (this.i1) {
                GLES20.glBindTexture(36197, this.O0);
            } else {
                GLES20.glBindTexture(3553, this.V0[0]);
            }
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glUseProgram(this.e.c);
            GLES20.glUniform1i(this.e.f, 0);
            GLES20.glEnableVertexAttribArray(this.e.e);
            GLES20.glVertexAttribPointer(this.e.e, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.e.d);
            GLES20.glVertexAttribPointer(this.e.d, 2, 5126, false, 8, (Buffer) this.d1);
            GLES20.glBindFramebuffer(36160, this.W0[1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[1], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.U0[0]);
            GLES20.glUniform1f(this.e.g, 0.0f);
            GLES20.glUniform1f(this.e.h, 1.0f / this.a1);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindFramebuffer(36160, this.W0[3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[3], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.U0[1]);
            GLES20.glUniform1f(this.e.g, 1.0f / this.Z0);
            GLES20.glUniform1f(this.e.h, 0.0f);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glUseProgram(this.p);
            GLES20.glUniform1i(this.s, 0);
            GLES20.glUniform1i(this.t, 1);
            GLES20.glEnableVertexAttribArray(this.r);
            GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.q);
            GLES20.glVertexAttribPointer(this.q, 2, 5126, false, 8, (Buffer) this.d1);
            GLES20.glBindFramebuffer(36160, this.W0[1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[1], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.U0[0]);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.U0[3]);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glUseProgram(this.D);
            GLES20.glUniform1i(this.G, 0);
            GLES20.glEnableVertexAttribArray(this.F);
            GLES20.glVertexAttribPointer(this.F, 2, 5126, false, 8, (Buffer) this.c1);
            GLES20.glEnableVertexAttribArray(this.E);
            GLES20.glVertexAttribPointer(this.E, 2, 5126, false, 8, (Buffer) this.d1);
            GLES20.glBindFramebuffer(36160, this.W0[3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[3], 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.U0[1]);
            GLES20.glDrawArrays(5, 0, 4);
            this.b = false;
        }
        this.h = true;
        this.Y0 = false;
        GLES20.glUseProgram(this.u);
        GLES20.glUniform1i(this.x, 0);
        GLES20.glUniform1i(this.y, 1);
        GLES20.glUniform1i(this.z, 2);
        GLES20.glUniform1f(this.A, this.h1.getSoftenSkinValue());
        GLES20.glEnableVertexAttribArray(this.w);
        GLES20.glVertexAttribPointer(this.w, 2, 5126, false, 8, (Buffer) this.c1);
        GLES20.glEnableVertexAttribArray(this.v);
        GLES20.glVertexAttribPointer(this.v, 2, 5126, false, 8, (Buffer) this.d1);
        if (this.i1) {
            GLES20.glUniformMatrix4fv(this.B, 1, false, this.R0, 0);
            int i3 = this.C;
            if (i3 != -1) {
                GLES20.glUniform2f(i3, this.Z0, this.a1);
            }
        }
        GLES20.glBindFramebuffer(36160, this.W0[1]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.U0[1], 0);
        GLES20.glActiveTexture(33984);
        if (this.i1) {
            GLES20.glBindTexture(36197, this.O0);
        } else {
            GLES20.glBindTexture(3553, this.V0[0]);
        }
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.U0[3]);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.o.a());
        GLES20.glDrawArrays(5, 0, 4);
        return true;
    }

    public int l() {
        return this.a1;
    }

    public int m() {
        return this.Z0;
    }

    public int n() {
        int[] iArr = this.W0;
        if (iArr != null) {
            return iArr[!this.i1 ? 1 : 0];
        }
        return 0;
    }

    public int o(int i) {
        if (this.i1) {
            return this.U0[i == 0 ? (char) 1 : (char) 0];
        }
        return this.U0[i];
    }

    public FloatBuffer p() {
        return this.c1;
    }

    public FloatBuffer q() {
        return this.b1;
    }

    public void t(float[] fArr) {
        this.R0 = fArr;
        this.Y0 = false;
    }

    public void u() {
        this.a = true;
        this.b = true;
    }

    public void v(c cVar) {
        this.h1 = cVar;
    }

    public void w(Bitmap bitmap, int i, int i2, int i3, int i4) {
        s(bitmap, i, i3, i4);
        this.O0 = i2;
        this.P0 = i3;
        this.Q0 = i4;
        GLES20.glBindTexture(3553, this.S0[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, this.Z0, this.a1, 0, 6408, 5121, null);
    }

    public void x(boolean z) {
        this.k1 = z;
    }

    public void z(l.b bVar) {
        this.j1 = bVar;
        y();
    }
}
