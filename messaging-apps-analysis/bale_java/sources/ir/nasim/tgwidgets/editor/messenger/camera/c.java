package ir.nasim.tgwidgets.editor.messenger.camera;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.RD6;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c {
    private int A;
    public b a;
    private String b;
    private OrientationEventListener c;
    private boolean f;
    private final RD6 g;
    private final RD6 h;
    private final int i;
    private boolean j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private float r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int d = -1;
    private int e = -1;
    private boolean q = true;
    protected ArrayList w = new ArrayList();
    private int x = -1;
    Camera.CameraInfo y = new Camera.CameraInfo();
    private Camera.AutoFocusCallback z = new Camera.AutoFocusCallback() { // from class: ir.nasim.FD0
        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z, Camera camera) {
            ir.nasim.tgwidgets.editor.messenger.camera.c.z(z, camera);
        }
    };

    class a extends OrientationEventListener {
        a(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (c.this.c == null || !c.this.j || i == -1) {
                return;
            }
            c cVar = c.this;
            cVar.o = cVar.B(i, cVar.o);
            int rotation = ((WindowManager) AbstractC14047hG.a.getSystemService("window")).getDefaultDisplay().getRotation();
            if (c.this.d == c.this.o && rotation == c.this.e) {
                return;
            }
            if (!c.this.f) {
                c.this.m();
            }
            c.this.e = rotation;
            c cVar2 = c.this;
            cVar2.d = cVar2.o;
        }
    }

    public c(b bVar, RD6 rd6, RD6 rd62, int i, boolean z) {
        this.h = rd6;
        this.g = rd62;
        this.i = i;
        this.a = bVar;
        this.u = z;
        this.b = AbstractC14047hG.a.getSharedPreferences("camera", 0).getString(this.a.e != 0 ? "flashMode_front" : "flashMode", "off");
        a aVar = new a(AbstractC14047hG.a);
        this.c = aVar;
        if (aVar.canDetectOrientation()) {
            this.c.enable();
        } else {
            this.c.disable();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B(int i, int i2) {
        if (i2 != -1) {
            int iAbs = Math.abs(i - i2);
            if (Math.min(iAbs, 360 - iAbs) < 50) {
                return i2;
            }
        }
        return (((i + 45) / 90) * 90) % 360;
    }

    private void H() {
        if (this.x != this.a.a()) {
            int iA = this.a.a();
            this.x = iA;
            Camera.getCameraInfo(iA, this.y);
        }
    }

    private int t(Camera.CameraInfo cameraInfo, boolean z) {
        int rotation = ((WindowManager) AbstractC14047hG.a.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing != 1) {
            return ((cameraInfo.orientation - i) + 360) % 360;
        }
        int i2 = (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        if (!z && i2 == 90) {
            i2 = 270;
        }
        if (!z && "Huawei".equals(Build.MANUFACTURER) && "angler".equals(Build.PRODUCT) && i2 == 270) {
            return 90;
        }
        return i2;
    }

    private int u() {
        return ("LGE".equals(Build.MANUFACTURER) && "g3_tmo_us".equals(Build.PRODUCT)) ? 4 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(boolean z, Camera camera) {
    }

    public void A() {
        this.f = true;
    }

    public void C(String str) {
        this.b = str;
        m();
        AbstractC14047hG.a.getSharedPreferences("camera", 0).edit().putString(this.a.e != 0 ? "flashMode_front" : "flashMode", str).commit();
    }

    public void D() {
        this.j = true;
    }

    public void E(boolean z) {
        this.s = z;
        m();
    }

    public void F(float f) {
        this.r = f;
        if (this.f && "on".equals(this.b)) {
            this.t = true;
        }
        if (this.u) {
            o(false);
        } else {
            m();
        }
    }

    public void G() {
        this.f = false;
        this.t = false;
        m();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I() {
        /*
            r7 = this;
            ir.nasim.tgwidgets.editor.messenger.camera.b r0 = r7.a
            if (r0 != 0) goto L5
            return
        L5:
            r7.H()     // Catch: java.lang.Throwable -> L7d
            boolean r0 = r7.v
            if (r0 == 0) goto Le
            r0 = 0
            goto L12
        Le:
            ir.nasim.tgwidgets.editor.messenger.camera.b r0 = r7.a
            android.hardware.Camera r0 = r0.b
        L12:
            android.hardware.Camera$CameraInfo r1 = r7.y
            r2 = 1
            int r1 = r7.t(r1, r2)
            r7.A = r1
            java.lang.String r1 = "samsung"
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r1 = r1.equals(r3)
            r3 = 0
            if (r1 == 0) goto L31
            java.lang.String r1 = "sf2wifixx"
            java.lang.String r4 = android.os.Build.PRODUCT
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L31
            goto L68
        L31:
            int r1 = r7.A
            r4 = 90
            if (r1 == 0) goto L3f
            if (r1 == r2) goto L47
            r5 = 2
            if (r1 == r5) goto L44
            r5 = 3
            if (r1 == r5) goto L41
        L3f:
            r1 = r3
            goto L48
        L41:
            r1 = 270(0x10e, float:3.78E-43)
            goto L48
        L44:
            r1 = 180(0xb4, float:2.52E-43)
            goto L48
        L47:
            r1 = r4
        L48:
            android.hardware.Camera$CameraInfo r5 = r7.y
            int r6 = r5.orientation
            int r6 = r6 % r4
            if (r6 == 0) goto L51
            r5.orientation = r3
        L51:
            int r3 = r5.facing
            if (r3 != r2) goto L60
            int r2 = r5.orientation
            int r2 = r2 + r1
            int r2 = r2 % 360
            int r1 = 360 - r2
            int r1 = r1 % 360
            r3 = r1
            goto L68
        L60:
            int r2 = r5.orientation
            int r2 = r2 - r1
            int r2 = r2 + 360
            int r2 = r2 % 360
            r3 = r2
        L68:
            r7.m = r3
            if (r0 == 0) goto L6f
            r0.setDisplayOrientation(r3)     // Catch: java.lang.Throwable -> L6f
        L6f:
            int r0 = r7.m
            int r1 = r7.A
            int r0 = r0 - r1
            r7.n = r0
            if (r0 >= 0) goto L7c
            int r0 = r0 + 360
            r7.n = r0
        L7c:
            return
        L7d:
            r0 = move-exception
            ir.nasim.AbstractC6403Nl2.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.c.I():void");
    }

    public void l(String str) {
        if (this.w.contains(this.b)) {
            return;
        }
        this.b = str;
        m();
        AbstractC14047hG.a.getSharedPreferences("camera", 0).edit().putString(this.a.e != 0 ? "flashMode_front" : "flashMode", str).commit();
    }

    protected void m() {
        Camera.Parameters parameters;
        int i;
        try {
            Camera camera = this.a.b;
            if (camera != null) {
                try {
                    parameters = camera.getParameters();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                    parameters = null;
                }
                H();
                I();
                int i2 = this.m - this.A;
                this.n = i2;
                if (i2 < 0) {
                    this.n = i2 + 360;
                }
                if (parameters != null) {
                    parameters.setPreviewSize(this.h.b(), this.h.a());
                    parameters.setPictureSize(this.g.b(), this.g.a());
                    parameters.setPictureFormat(this.i);
                    parameters.setJpegQuality(100);
                    parameters.setJpegThumbnailQuality(100);
                    int maxZoom = parameters.getMaxZoom();
                    this.k = maxZoom;
                    parameters.setZoom((int) (this.r * maxZoom));
                    if (this.s) {
                        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
                        if (supportedSceneModes != null && supportedSceneModes.contains("barcode")) {
                            parameters.setSceneMode("barcode");
                        }
                        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                            parameters.setFocusMode("continuous-video");
                        }
                    } else if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                    }
                    int i3 = this.o;
                    if (i3 != -1) {
                        Camera.CameraInfo cameraInfo = this.y;
                        i = cameraInfo.facing == 1 ? ((cameraInfo.orientation - i3) + 360) % 360 : (cameraInfo.orientation + i3) % 360;
                    } else {
                        i = 0;
                    }
                    try {
                        parameters.setRotation(i);
                        if (this.y.facing == 1) {
                            this.p = (360 - this.A) % 360 == i;
                        } else {
                            this.p = this.A == i;
                        }
                    } catch (Exception unused) {
                    }
                    parameters.setFlashMode(this.t ? "torch" : this.b);
                    try {
                        camera.setParameters(parameters);
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
    }

    protected void n(int i, MediaRecorder mediaRecorder) {
        int i2;
        H();
        int i3 = this.o;
        if (i3 != -1) {
            Camera.CameraInfo cameraInfo = this.y;
            i2 = cameraInfo.facing == 1 ? ((cameraInfo.orientation - i3) + 360) % 360 : (cameraInfo.orientation + i3) % 360;
        } else {
            i2 = 0;
        }
        mediaRecorder.setOrientationHint(i2);
        int iU = u();
        boolean zHasProfile = CamcorderProfile.hasProfile(this.a.a, iU);
        boolean zHasProfile2 = CamcorderProfile.hasProfile(this.a.a, 0);
        if (zHasProfile && (i == 1 || !zHasProfile2)) {
            mediaRecorder.setProfile(CamcorderProfile.get(this.a.a, iU));
        } else {
            if (!zHasProfile2) {
                throw new IllegalStateException("cannot find valid CamcorderProfile");
            }
            mediaRecorder.setProfile(CamcorderProfile.get(this.a.a, 0));
        }
        this.f = true;
    }

    protected boolean o(boolean z) {
        Camera.Parameters parameters;
        int i;
        try {
            this.f = true;
            Camera camera = this.a.b;
            if (camera != null) {
                try {
                    parameters = camera.getParameters();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                    parameters = null;
                }
                H();
                I();
                if (parameters != null) {
                    if (z && AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.a("set preview size = " + this.h.b() + Separators.SP + this.h.a());
                    }
                    parameters.setPreviewSize(this.h.b(), this.h.a());
                    if (z && AbstractC8814Xl0.b) {
                        AbstractC6403Nl2.a("set picture size = " + this.g.b() + Separators.SP + this.g.a());
                    }
                    parameters.setPictureSize(this.g.b(), this.g.a());
                    parameters.setPictureFormat(this.i);
                    parameters.setRecordingHint(true);
                    this.k = parameters.getMaxZoom();
                    if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    } else if (parameters.getSupportedFocusModes().contains("auto")) {
                        parameters.setFocusMode("auto");
                    }
                    int i2 = this.o;
                    if (i2 != -1) {
                        Camera.CameraInfo cameraInfo = this.y;
                        i = cameraInfo.facing == 1 ? ((cameraInfo.orientation - i2) + 360) % 360 : (cameraInfo.orientation + i2) % 360;
                    } else {
                        i = 0;
                    }
                    try {
                        parameters.setRotation(i);
                        if (this.y.facing == 1) {
                            this.p = (360 - this.A) % 360 == i;
                        } else {
                            this.p = this.A == i;
                        }
                    } catch (Exception unused) {
                    }
                    parameters.setFlashMode("off");
                    parameters.setZoom((int) (this.r * this.k));
                    try {
                        camera.setParameters(parameters);
                        if (parameters.getMaxNumMeteringAreas() > 0) {
                            this.l = true;
                        }
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
            return false;
        }
    }

    public void p() {
        this.j = false;
        this.v = true;
        OrientationEventListener orientationEventListener = this.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.c = null;
        }
    }

    public void q(Rect rect, Rect rect2) {
        Camera.Parameters parameters;
        try {
            Camera camera = this.a.b;
            if (camera != null) {
                camera.cancelAutoFocus();
                try {
                    parameters = camera.getParameters();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                    parameters = null;
                }
                if (parameters != null) {
                    parameters.setFocusMode("auto");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(rect, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
                    parameters.setFocusAreas(arrayList);
                    if (this.l) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new Camera.Area(rect2, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
                        parameters.setMeteringAreas(arrayList2);
                    }
                    try {
                        camera.setParameters(parameters);
                        camera.autoFocus(this.z);
                    } catch (Exception e2) {
                        AbstractC6403Nl2.d(e2);
                    }
                }
            }
        } catch (Exception e3) {
            AbstractC6403Nl2.d(e3);
        }
    }

    public String r() {
        return this.b;
    }

    public int s() {
        try {
            H();
            return t(this.y, true);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return 0;
        }
    }

    public String v() {
        ArrayList arrayList = this.w;
        int i = 0;
        while (i < arrayList.size()) {
            if (((String) arrayList.get(i)).equals(this.b)) {
                return i < arrayList.size() + (-1) ? (String) arrayList.get(i + 1) : (String) arrayList.get(0);
            }
            i++;
        }
        return this.b;
    }

    public int w() {
        return this.n;
    }

    public boolean x() {
        return this.q;
    }

    public boolean y() {
        return this.j;
    }
}
