package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.content.SharedPreferences;
import android.gov.nist.core.Separators;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC23776xV3;
import ir.nasim.AbstractC3855Cq2;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.B87;
import ir.nasim.C19545qX7;
import ir.nasim.C22477vI7;
import ir.nasim.FH3;
import ir.nasim.I87;
import ir.nasim.TD5;
import ir.nasim.U97;
import ir.nasim.V97;
import ir.nasim.W97;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.camera.CameraView;
import ir.nasim.tgwidgets.editor.messenger.camera.a;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;

/* loaded from: classes7.dex */
public class DualCameraView extends CameraView implements a.b {
    private static final int[] h2 = {1893745684, -215458996, -862041025, -1258375037, -1320049076, -215749424, 1901578030, -215451421, 1908491424, -1321491332, -1155551678, 1908524435, 976847578, -713271737, -2010722764, 1407170066, -1394190055, 1407170066, 1407159934, 1407172057, 1231389747, -2076538925, 41497626, 846150482, -1198092731, -251277614, -2078385967};
    private static final int[] i2 = new int[0];
    private double A1;
    private boolean B1;
    private boolean C1;
    private final Matrix D1;
    private final Matrix E1;
    private boolean F1;
    private float G1;
    private boolean H1;
    private boolean I1;
    private float[] J1;
    private Matrix K1;
    private Matrix L1;
    private boolean M1;
    private boolean N1;
    private boolean O1;
    private boolean P1;
    private float Q1;
    private float R1;
    private long S1;
    private Matrix U1;
    private Runnable V1;
    private Runnable W1;
    private final float[] X1;
    private float Y1;
    private float Z1;
    private float a2;
    private float b2;
    private float c2;
    private Matrix d2;
    private float[] e2;
    private float[] f2;
    private float[] g2;
    private boolean w1;
    private final PointF x1;
    private final PointF y1;
    private float z1;

    public DualCameraView(Context context, boolean z, boolean z2) {
        super(context, z, z2);
        this.x1 = new PointF();
        this.y1 = new PointF();
        this.D1 = new Matrix();
        this.E1 = new Matrix();
        this.J1 = new float[4];
        this.K1 = new Matrix();
        this.L1 = new Matrix();
        this.M1 = true;
        this.U1 = new Matrix();
        this.X1 = new float[2];
        this.d2 = new Matrix();
        this.e2 = new float[2];
        ir.nasim.tgwidgets.editor.messenger.camera.a.x().q(this);
        this.w1 = Z0(context);
    }

    private boolean V0(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.S1 = System.currentTimeMillis();
            this.Q1 = motionEvent.getX();
            this.R1 = motionEvent.getY();
            this.W1 = null;
            Runnable runnable = this.V1;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
                this.V1 = null;
            }
            if (b1(this.Q1, this.R1)) {
                Runnable runnable2 = new Runnable() { // from class: ir.nasim.w12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f1();
                    }
                };
                this.V1 = runnable2;
                AbstractC21455b.n1(runnable2, ViewConfiguration.getLongPressTimeout());
            }
            return true;
        }
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() != 3) {
                return false;
            }
            this.S1 = -1L;
            this.W1 = null;
            Runnable runnable3 = this.V1;
            if (runnable3 == null) {
                return false;
            }
            AbstractC21455b.t(runnable3);
            this.V1 = null;
            return false;
        }
        if (System.currentTimeMillis() - this.S1 <= ViewConfiguration.getTapTimeout() && AbstractC23776xV3.a(this.Q1, this.R1, motionEvent.getX(), motionEvent.getY()) < AbstractC21455b.F(10.0f)) {
            if (b1(this.Q1, this.R1)) {
                N0();
                this.W1 = null;
            } else {
                this.W1 = new Runnable() { // from class: ir.nasim.x12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g1();
                    }
                };
            }
        }
        this.S1 = -1L;
        Runnable runnable4 = this.V1;
        if (runnable4 == null) {
            return false;
        }
        AbstractC21455b.t(runnable4);
        this.V1 = null;
        return false;
    }

    public static boolean Y0(Context context, boolean z) {
        int i = 0;
        boolean z2 = AbstractC8662Wx6.h() >= 1 && Camera.getNumberOfCameras() > 1 && AbstractC8662Wx6.b();
        if (!z2) {
            return z2;
        }
        boolean z3 = context != null && context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
        if (!z3 && z) {
            int iHashCode = (Build.MANUFACTURER + Separators.SP + Build.DEVICE).toUpperCase().hashCode();
            int i3 = 0;
            while (true) {
                int[] iArr = h2;
                if (i3 >= iArr.length) {
                    break;
                }
                if (iArr[i3] == iHashCode) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (!z3) {
                int iHashCode2 = (Build.MANUFACTURER + Build.MODEL).toUpperCase().hashCode();
                while (true) {
                    int[] iArr2 = i2;
                    if (i >= iArr2.length) {
                        break;
                    }
                    if (iArr2[i] == iHashCode2) {
                        return true;
                    }
                    i++;
                }
            }
        }
        return z3;
    }

    public static boolean Z0(Context context) {
        return C.m().getBoolean("dual_available", Y0(context, true));
    }

    private void a1(Matrix matrix) {
        float[] fArr = this.X1;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.X1;
        this.Y1 = fArr2[0];
        this.Z1 = fArr2[1];
        fArr2[0] = 1.0f;
        fArr2[1] = 0.0f;
        matrix.mapPoints(fArr2);
        float[] fArr3 = this.X1;
        this.a2 = (float) Math.toDegrees(Math.atan2(fArr3[1] - this.Z1, fArr3[0] - this.Y1));
        float f = this.Y1;
        float f2 = this.Z1;
        float[] fArr4 = this.X1;
        this.b2 = AbstractC23776xV3.a(f, f2, fArr4[0], fArr4[1]) * 2.0f;
        float[] fArr5 = this.X1;
        fArr5[0] = 0.0f;
        fArr5[1] = 1.0f;
        matrix.mapPoints(fArr5);
        float f3 = this.Y1;
        float f4 = this.Z1;
        float[] fArr6 = this.X1;
        this.c2 = AbstractC23776xV3.a(f3, f4, fArr6[0], fArr6[1]) * 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1() {
        if (this.S1 > 0) {
            i0();
            performHapticFeedback(0, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1() {
        k0((int) this.Q1, (int) this.R1);
    }

    private Matrix getSavedDualMatrix() {
        String string = C.m().getString("dualmatrix", null);
        if (string == null) {
            return null;
        }
        String[] strArrSplit = string.split(Separators.SEMICOLON);
        if (strArrSplit.length != 9) {
            return null;
        }
        float[] fArr = new float[9];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                fArr[i] = Float.parseFloat(strArrSplit[i]);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return null;
            }
        }
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    private void h1(boolean z) {
        boolean zY0 = Y0(AbstractC14047hG.a, false);
        if (C.n(C22477vI7.f).l) {
            try {
                B87 b87 = new B87();
                I87 i87 = new I87();
                i87.b = ConnectionsManager.k(C22477vI7.f).j();
                i87.c = "android_dual_camera";
                U97 u97 = new U97();
                V97 v97 = new V97();
                v97.b = "device";
                W97 w97 = new W97();
                w97.b = "" + Build.MANUFACTURER + Build.MODEL;
                v97.c = w97;
                u97.b.add(v97);
                i87.e = u97;
                i87.d = (z ? 1 : 0) | (zY0 ? 2 : 0);
                b87.b.add(i87);
                ConnectionsManager.k(C22477vI7.f).m(b87, new C19545qX7());
            } catch (Exception unused) {
            }
        }
    }

    private void n1() {
        C.m().edit().putBoolean("dualcam", false).remove("dualmatrix").apply();
    }

    private void o1() {
        SharedPreferences.Editor editorEdit = C.m().edit();
        editorEdit.putBoolean("dualcam", p0());
        if (p0()) {
            float[] fArr = new float[9];
            getDualPosition().getValues(fArr);
            editorEdit.putString("dualmatrix", AbstractC3855Cq2.b(Separators.SEMICOLON, fArr));
        } else {
            editorEdit.remove("dualmatrix");
        }
        editorEdit.apply();
    }

    private void p1() {
        Matrix dualPosition = getDualPosition();
        dualPosition.reset();
        Matrix savedDualMatrix = getSavedDualMatrix();
        if (savedDualMatrix != null) {
            dualPosition.set(savedDualMatrix);
        } else {
            dualPosition.postConcat(this.K1);
            float measuredWidth = getMeasuredWidth() * 0.43f;
            float fMin = Math.min(getMeasuredWidth(), getMeasuredWidth()) * 0.025f;
            dualPosition.postScale(measuredWidth / getMeasuredWidth(), (getMeasuredHeight() * 0.43f) / getMeasuredHeight());
            dualPosition.postTranslate((getMeasuredWidth() - fMin) - measuredWidth, fMin);
            dualPosition.postConcat(this.L1);
        }
        R0();
    }

    private boolean q1(MotionEvent motionEvent) {
        double dAtan2;
        float fA;
        boolean z;
        float width;
        float f;
        Runnable runnable;
        boolean zV0 = V0(motionEvent);
        if (!p0()) {
            return zV0;
        }
        Matrix dualPosition = getDualPosition();
        boolean z2 = motionEvent.getPointerCount() > 1;
        if (z2) {
            this.y1.x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.y1.y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
            fA = AbstractC23776xV3.a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
            dAtan2 = Math.atan2(motionEvent.getY(1) - motionEvent.getY(0), motionEvent.getX(1) - motionEvent.getX(0));
        } else {
            this.y1.x = motionEvent.getX(0);
            this.y1.y = motionEvent.getY(0);
            dAtan2 = 0.0d;
            fA = 0.0f;
        }
        if (this.B1 != z2) {
            PointF pointF = this.x1;
            PointF pointF2 = this.y1;
            pointF.x = pointF2.x;
            pointF.y = pointF2.y;
            this.z1 = fA;
            this.A1 = dAtan2;
            this.B1 = z2;
        }
        PointF pointF3 = this.y1;
        float f2 = pointF3.x;
        float f3 = pointF3.y;
        PointF pointF4 = this.x1;
        float f4 = pointF4.x;
        float f5 = pointF4.y;
        if (motionEvent.getAction() == 0) {
            this.D1.set(dualPosition);
            this.D1.postConcat(this.K1);
            this.G1 = 0.0f;
            this.H1 = false;
            this.I1 = false;
            Matrix matrix = this.D1;
            PointF pointF5 = this.y1;
            this.F1 = d1(matrix, pointF5.x, pointF5.y);
        }
        if (motionEvent.getAction() == 2 && this.F1) {
            if (AbstractC23776xV3.a(f2, f3, f4, f5) > AbstractC21455b.F(2.0f) && (runnable = this.V1) != null) {
                AbstractC21455b.t(runnable);
                this.V1 = null;
            }
            if (motionEvent.getPointerCount() > 1) {
                if (this.z1 != 0.0f) {
                    a1(this.D1);
                    float f6 = fA / this.z1;
                    if (this.b2 * f6 > getWidth() * 0.7f) {
                        width = getWidth() * 0.7f;
                        f = this.b2;
                    } else {
                        if (this.b2 * f6 < getWidth() * 0.2f) {
                            width = getWidth() * 0.2f;
                            f = this.b2;
                        }
                        this.D1.postScale(f6, f6, f2, f3);
                    }
                    f6 = width / f;
                    this.D1.postScale(f6, f6, f2, f3);
                }
                float degrees = (float) Math.toDegrees(dAtan2 - this.A1);
                float f7 = this.G1 + degrees;
                this.G1 = f7;
                if (!this.C1) {
                    boolean z3 = Math.abs(f7) > 20.0f;
                    this.C1 = z3;
                    if (!z3) {
                        a1(this.D1);
                        this.C1 = (((float) Math.round(this.a2 / 90.0f)) * 90.0f) - this.a2 > 20.0f;
                    }
                    if (!this.H1) {
                        try {
                            performHapticFeedback(9, 1);
                        } catch (Exception unused) {
                        }
                        this.H1 = true;
                    }
                }
                if (this.C1) {
                    this.D1.postRotate(degrees, f2, f3);
                }
            }
            this.D1.postTranslate(f2 - f4, f3 - f5);
            this.E1.set(this.D1);
            a1(this.E1);
            float fRound = (Math.round(this.a2 / 90.0f) * 90.0f) - this.a2;
            if (this.C1 && !this.I1) {
                if (Math.abs(fRound) < 5.0f) {
                    this.E1.postRotate(fRound, this.Y1, this.Z1);
                    if (!this.H1) {
                        try {
                            performHapticFeedback(9, 1);
                        } catch (Exception unused2) {
                        }
                        this.H1 = true;
                    }
                } else {
                    this.H1 = false;
                }
            }
            float f8 = this.Y1;
            if (f8 < 0.0f) {
                this.E1.postTranslate(-f8, 0.0f);
            } else if (f8 > getWidth()) {
                this.E1.postTranslate(getWidth() - this.Y1, 0.0f);
            }
            float f9 = this.Z1;
            if (f9 < 0.0f) {
                this.E1.postTranslate(0.0f, -f9);
            } else if (f9 > getHeight() - AbstractC21455b.F(150.0f)) {
                this.E1.postTranslate(0.0f, (getHeight() - AbstractC21455b.F(150.0f)) - this.Z1);
            }
            this.E1.postConcat(this.L1);
            dualPosition.set(this.E1);
            R0();
            float f10 = this.Z1;
            boolean z4 = Math.min(f10, f10 - (this.c2 / 2.0f)) < ((float) AbstractC21455b.F(66.0f));
            float f11 = this.Z1;
            boolean z5 = Math.max(f11, (this.c2 / 2.0f) + f11) > ((float) (getHeight() - AbstractC21455b.F(66.0f)));
            if (this.N1 != z4) {
                this.N1 = z4;
                k1(z4);
            }
            if (this.O1 != z5) {
                this.O1 = z5;
                j1(z5);
            }
        }
        if (motionEvent.getAction() == 1) {
            z = false;
            this.C1 = false;
            this.G1 = 0.0f;
            this.H1 = false;
            invalidate();
            this.F1 = false;
            if (this.N1) {
                this.N1 = false;
                k1(false);
            }
            if (this.O1) {
                this.O1 = false;
                j1(false);
            }
        } else {
            z = false;
            if (motionEvent.getAction() == 3) {
                this.F1 = false;
                if (this.N1) {
                    this.N1 = false;
                    k1(false);
                }
                if (this.O1) {
                    this.O1 = false;
                    j1(false);
                }
            }
        }
        PointF pointF6 = this.x1;
        PointF pointF7 = this.y1;
        pointF6.x = pointF7.x;
        pointF6.y = pointF7.y;
        this.z1 = fA;
        this.A1 = dAtan2;
        if (this.F1 || zV0) {
            return true;
        }
        return z;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.CameraView
    protected void F0() {
        o1();
        if (this.P1) {
            l1();
        }
        h1(true);
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.CameraView
    public void O0() {
        if (p0() || X0()) {
            if (p0()) {
                m1();
            } else {
                p1();
            }
            super.O0();
        }
    }

    public void U0() {
        Runnable runnable = this.W1;
        if (runnable != null) {
            runnable.run();
            this.W1 = null;
        }
    }

    public void W0() {
        this.W1 = null;
        this.S1 = -1L;
    }

    public boolean X0() {
        return this.w1;
    }

    public boolean b1(float f, float f2) {
        if (!p0()) {
            return false;
        }
        float[] fArr = this.e2;
        fArr[0] = f;
        fArr[1] = f2;
        this.L1.mapPoints(fArr);
        getDualPosition().invert(this.U1);
        this.U1.mapPoints(this.e2);
        int dualShape = getDualShape() % 3;
        float f3 = (dualShape == 0 || dualShape == 1 || dualShape == 3) ? 0.5625f : 1.0f;
        float[] fArr2 = this.e2;
        float f4 = fArr2[0];
        if (f4 < -1.0f || f4 > 1.0f) {
            return false;
        }
        float f5 = fArr2[1];
        return f5 >= (-f3) && f5 <= f3;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.a.b
    public void c(int i, Camera camera, ir.nasim.tgwidgets.editor.messenger.camera.c cVar) {
        if (p0()) {
            if (!Y0(getContext(), false)) {
                SharedPreferences.Editor editorEdit = C.m().edit();
                this.w1 = false;
                editorEdit.putBoolean("dual_available", false).apply();
                new AlertDialog.i(getContext()).j(FH3.C(TD5.tgwidget_DualErrorTitle)).e(FH3.C(TD5.tgwidget_DualErrorMessage)).i(FH3.C(TD5.tgwidget_OK), null).q();
            }
            h1(false);
            O0();
        }
        if (n0(0) == cVar) {
            I0();
        }
        i1();
    }

    public boolean c1() {
        return this.F1;
    }

    public boolean d1(Matrix matrix, float f, float f2) {
        if (this.f2 == null) {
            this.f2 = new float[8];
        }
        if (this.g2 == null) {
            this.g2 = new float[8];
        }
        int dualShape = getDualShape() % 3;
        float f3 = (dualShape == 0 || dualShape == 1 || dualShape == 3) ? 0.5625f : 1.0f;
        float[] fArr = this.f2;
        fArr[0] = -1.0f;
        float f4 = -f3;
        fArr[1] = f4;
        fArr[2] = 1.0f;
        fArr[3] = f4;
        fArr[4] = 1.0f;
        fArr[5] = f3;
        fArr[6] = -1.0f;
        fArr[7] = f3;
        matrix.mapPoints(this.g2, fArr);
        float[] fArr2 = this.g2;
        float f5 = fArr2[0];
        float f6 = fArr2[2];
        float f7 = (f5 - f6) * (f5 - f6);
        float f8 = fArr2[1];
        float f9 = fArr2[3];
        double dSqrt = Math.sqrt(f7 + ((f8 - f9) * (f8 - f9)));
        float[] fArr3 = this.g2;
        float f10 = fArr3[2];
        float f11 = fArr3[4];
        float f12 = (f10 - f11) * (f10 - f11);
        float f13 = fArr3[3];
        float f14 = fArr3[5];
        double dSqrt2 = Math.sqrt(f12 + ((f13 - f14) * (f13 - f14)));
        float[] fArr4 = this.g2;
        float f15 = fArr4[4];
        float f16 = fArr4[6];
        float f17 = (f15 - f16) * (f15 - f16);
        float f18 = fArr4[5];
        float f19 = fArr4[7];
        double dSqrt3 = Math.sqrt(f17 + ((f18 - f19) * (f18 - f19)));
        float[] fArr5 = this.g2;
        float f20 = fArr5[6];
        float f21 = fArr5[0];
        float f22 = (f20 - f21) * (f20 - f21);
        float f23 = fArr5[7];
        float f24 = fArr5[1];
        double dSqrt4 = Math.sqrt(f22 + ((f23 - f24) * (f23 - f24)));
        float[] fArr6 = this.g2;
        float f25 = fArr6[0];
        float f26 = fArr6[1];
        double dSqrt5 = Math.sqrt(((f25 - f) * (f25 - f)) + ((f26 - f2) * (f26 - f2)));
        float[] fArr7 = this.g2;
        float f27 = fArr7[2];
        float f28 = fArr7[3];
        double dSqrt6 = Math.sqrt(((f27 - f) * (f27 - f)) + ((f28 - f2) * (f28 - f2)));
        float[] fArr8 = this.g2;
        float f29 = fArr8[4];
        float f30 = fArr8[5];
        double dSqrt7 = Math.sqrt(((f29 - f) * (f29 - f)) + ((f30 - f2) * (f30 - f2)));
        float[] fArr9 = this.g2;
        float f31 = fArr9[6];
        float f32 = fArr9[7];
        double dSqrt8 = Math.sqrt(((f31 - f) * (f31 - f)) + ((f32 - f2) * (f32 - f2)));
        double d = ((dSqrt + dSqrt5) + dSqrt6) / 2.0d;
        double d2 = ((dSqrt2 + dSqrt6) + dSqrt7) / 2.0d;
        double d3 = ((dSqrt3 + dSqrt7) + dSqrt8) / 2.0d;
        double d4 = ((dSqrt4 + dSqrt8) + dSqrt5) / 2.0d;
        return (((Math.sqrt((((d - dSqrt) * d) * (d - dSqrt5)) * (d - dSqrt6)) + Math.sqrt((((d2 - dSqrt2) * d2) * (d2 - dSqrt6)) * (d2 - dSqrt7))) + Math.sqrt((((d3 - dSqrt3) * d3) * (d3 - dSqrt7)) * (d3 - dSqrt8))) + Math.sqrt((((d4 - dSqrt4) * d4) * (d4 - dSqrt8)) * (d4 - dSqrt5))) - (dSqrt * dSqrt2) < 1.0d;
    }

    public boolean e1() {
        return Z0(getContext()) && C.m().getBoolean("dualcam", Y0(AbstractC14047hG.a, false));
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.CameraView
    public void h0(boolean z, Runnable runnable) {
        o1();
        super.h0(z, runnable);
        ir.nasim.tgwidgets.editor.messenger.camera.a.x().V(this);
    }

    protected void i1() {
        m1();
    }

    protected void j1(boolean z) {
    }

    protected void k1(boolean z) {
    }

    protected void l1() {
    }

    public void m1() {
        n1();
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.CameraView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        this.K1.reset();
        this.K1.postTranslate(1.0f, -1.0f);
        this.K1.postScale(getMeasuredWidth() / 2.0f, (-getMeasuredHeight()) / 2.0f);
        this.K1.invert(this.L1);
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.camera.CameraView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i3) {
        if (this.M1) {
            if (e1()) {
                this.P1 = true;
                p1();
                this.S0 = true;
            }
            this.M1 = false;
        }
        super.onSurfaceTextureAvailable(surfaceTexture, i, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent) || q1(motionEvent);
    }
}
