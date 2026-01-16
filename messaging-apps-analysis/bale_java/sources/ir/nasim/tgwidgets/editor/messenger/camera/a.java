package ir.nasim.tgwidgets.editor.messenger.camera;

import android.content.SharedPreferences;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Base64;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C23394wq6;
import ir.nasim.RD6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes7.dex */
public class a implements MediaRecorder.OnInfoListener {
    private static volatile a l;
    private MediaRecorder b;
    private String c;
    private boolean d;
    protected volatile ArrayList e;
    private d f;
    private boolean g;
    private boolean h;
    c j;
    private ArrayList k;
    private ArrayList i = new ArrayList();
    protected ThreadPoolExecutor a = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.camera.a$a, reason: collision with other inner class name */
    static class C1579a implements Comparator {
        C1579a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RD6 rd6, RD6 rd62) {
            return Long.signum((rd6.b() * rd6.a()) - (rd62.b() * rd62.a()));
        }
    }

    public interface b {
        void c(int i, Camera camera, ir.nasim.tgwidgets.editor.messenger.camera.c cVar);
    }

    public interface c {
        void a();

        boolean b(File file, Runnable runnable);
    }

    public interface d {
        void a(String str, long j);
    }

    private void A(final Runnable runnable, final boolean z) {
        if (this.g) {
            return;
        }
        if (runnable != null && !this.i.contains(runnable)) {
            this.i.add(runnable);
        }
        if (this.h || this.g) {
            return;
        }
        this.h = true;
        this.a.execute(new Runnable() { // from class: ir.nasim.IC0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J(z, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Runnable runnable, ir.nasim.tgwidgets.editor.messenger.camera.c cVar, CountDownLatch countDownLatch, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        }
        Camera camera = cVar.a.b;
        if (camera != null) {
            try {
                camera.stopPreview();
                cVar.a.b.setPreviewCallbackWithBuffer(null);
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            try {
                cVar.a.b.release();
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
            cVar.a.b = null;
        }
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        if (runnable2 != null) {
            AbstractC21455b.m1(runnable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(File file, Bitmap bitmap, long j) {
        String absolutePath;
        if (this.f != null) {
            if (file != null) {
                absolutePath = file.getAbsolutePath();
                if (bitmap != null) {
                    C21457d.g0().D0(new BitmapDrawable(bitmap), Utilities.a(absolutePath), false);
                }
            } else {
                absolutePath = null;
            }
            this.f.a(absolutePath, j);
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ir.nasim.tgwidgets.editor.messenger.camera.c cVar, int i, Camera camera) {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                b bVar = (b) this.k.get(i2);
                if (bVar != null) {
                    bVar.c(i, camera, cVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int F(RD6 rd6, RD6 rd62) {
        int i = rd6.a;
        int i2 = rd62.a;
        if (i < i2) {
            return 1;
        }
        if (i > i2) {
            return -1;
        }
        int i3 = rd6.b;
        int i4 = rd62.b;
        if (i3 < i4) {
            return 1;
        }
        return i3 > i4 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.h = false;
        this.g = true;
        if (!this.i.isEmpty()) {
            for (int i = 0; i < this.i.size(); i++) {
                ((Runnable) this.i.get(i)).run();
            }
            this.i.clear();
        }
        E.j().s(E.N2, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(Runnable runnable) {
        A(runnable, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(boolean z, Exception exc, final Runnable runnable) {
        this.i.clear();
        this.h = false;
        this.g = false;
        if (z || !"APP_PAUSED".equals(exc.getMessage()) || runnable == null) {
            return;
        }
        AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.BC0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.H(runnable);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(final boolean z, final Runnable runnable) {
        String str;
        Camera.CameraInfo cameraInfo;
        int i;
        int i2;
        String str2;
        final a aVar = this;
        String str3 = "APP_PAUSED";
        String str4 = "cameraCache";
        try {
            if (aVar.e == null) {
                SharedPreferences sharedPreferencesM = C.m();
                String string = sharedPreferencesM.getString("cameraCache", null);
                Comparator comparator = new Comparator() { // from class: ir.nasim.JC0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ir.nasim.tgwidgets.editor.messenger.camera.a.F((RD6) obj, (RD6) obj2);
                    }
                };
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                if (string != null) {
                    C23394wq6 c23394wq6 = new C23394wq6(Base64.decode(string, 0));
                    int iE = c23394wq6.e(false);
                    for (int i4 = 0; i4 < iE; i4++) {
                        ir.nasim.tgwidgets.editor.messenger.camera.b bVar = new ir.nasim.tgwidgets.editor.messenger.camera.b(c23394wq6.e(false), c23394wq6.e(false));
                        int iE2 = c23394wq6.e(false);
                        for (int i5 = 0; i5 < iE2; i5++) {
                            bVar.d.add(new RD6(c23394wq6.e(false), c23394wq6.e(false)));
                        }
                        int iE3 = c23394wq6.e(false);
                        for (int i6 = 0; i6 < iE3; i6++) {
                            bVar.c.add(new RD6(c23394wq6.e(false), c23394wq6.e(false)));
                        }
                        arrayList.add(bVar);
                        Collections.sort(bVar.d, comparator);
                        Collections.sort(bVar.c, comparator);
                    }
                    c23394wq6.p();
                    str = "APP_PAUSED";
                } else {
                    int numberOfCameras = Camera.getNumberOfCameras();
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    int size = 4;
                    int i7 = 0;
                    while (i7 < numberOfCameras) {
                        try {
                            Camera.getCameraInfo(i7, cameraInfo2);
                            ir.nasim.tgwidgets.editor.messenger.camera.b bVar2 = new ir.nasim.tgwidgets.editor.messenger.camera.b(i7, cameraInfo2.facing);
                            if (AbstractC14047hG.c && AbstractC14047hG.d) {
                                throw new RuntimeException(str3);
                            }
                            Camera cameraOpen = Camera.open(bVar2.a());
                            Camera.Parameters parameters = cameraOpen.getParameters();
                            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                            int i8 = i3;
                            while (true) {
                                int size2 = supportedPreviewSizes.size();
                                cameraInfo = cameraInfo2;
                                str = str3;
                                i = SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
                                if (i8 >= size2) {
                                    break;
                                }
                                try {
                                    Camera.Size size3 = supportedPreviewSizes.get(i8);
                                    List<Camera.Size> list = supportedPreviewSizes;
                                    int i9 = size3.width;
                                    if ((i9 != 1280 || size3.height == 720) && (i2 = size3.height) < 2160 && i9 < 2160) {
                                        str2 = str4;
                                        bVar2.d.add(new RD6(i9, i2));
                                        if (AbstractC8814Xl0.b) {
                                            AbstractC6403Nl2.a("preview size = " + size3.width + Separators.SP + size3.height);
                                        }
                                    } else {
                                        str2 = str4;
                                    }
                                    i8++;
                                    cameraInfo2 = cameraInfo;
                                    str3 = str;
                                    supportedPreviewSizes = list;
                                    str4 = str2;
                                } catch (Exception e) {
                                    e = e;
                                    aVar = this;
                                    AbstractC6403Nl2.e(e, !str.equals(e.getMessage()));
                                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.wC0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.a.I(z, e, runnable);
                                        }
                                    });
                                    return;
                                }
                            }
                            String str5 = str4;
                            List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
                            int i10 = 0;
                            while (i10 < supportedPictureSizes.size()) {
                                Camera.Size size4 = supportedPictureSizes.get(i10);
                                if (size4.width != i || size4.height == 720) {
                                    if (!"samsung".equals(Build.MANUFACTURER) || !"jflteuc".equals(Build.PRODUCT) || size4.width < 2048) {
                                        bVar2.c.add(new RD6(size4.width, size4.height));
                                        if (AbstractC8814Xl0.b) {
                                            AbstractC6403Nl2.a("picture size = " + size4.width + Separators.SP + size4.height);
                                        }
                                    }
                                }
                                i10++;
                                i = SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
                            }
                            cameraOpen.release();
                            arrayList.add(bVar2);
                            Collections.sort(bVar2.d, comparator);
                            Collections.sort(bVar2.c, comparator);
                            size += ((bVar2.d.size() + bVar2.c.size()) * 8) + 8;
                            i7++;
                            cameraInfo2 = cameraInfo;
                            str3 = str;
                            str4 = str5;
                            i3 = 0;
                        } catch (Exception e2) {
                            e = e2;
                            str = str3;
                            aVar = this;
                            AbstractC6403Nl2.e(e, !str.equals(e.getMessage()));
                            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.wC0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.a.I(z, e, runnable);
                                }
                            });
                            return;
                        }
                    }
                    String str6 = str4;
                    str = str3;
                    C23394wq6 c23394wq62 = new C23394wq6(size);
                    c23394wq62.m(arrayList.size());
                    for (int i11 = 0; i11 < numberOfCameras; i11++) {
                        ir.nasim.tgwidgets.editor.messenger.camera.b bVar3 = (ir.nasim.tgwidgets.editor.messenger.camera.b) arrayList.get(i11);
                        c23394wq62.m(bVar3.a);
                        c23394wq62.m(bVar3.e);
                        int size5 = bVar3.d.size();
                        c23394wq62.m(size5);
                        for (int i12 = 0; i12 < size5; i12++) {
                            RD6 rd6 = (RD6) bVar3.d.get(i12);
                            c23394wq62.m(rd6.a);
                            c23394wq62.m(rd6.b);
                        }
                        int size6 = bVar3.c.size();
                        c23394wq62.m(size6);
                        for (int i13 = 0; i13 < size6; i13++) {
                            RD6 rd62 = (RD6) bVar3.c.get(i13);
                            c23394wq62.m(rd62.a);
                            c23394wq62.m(rd62.b);
                        }
                    }
                    sharedPreferencesM.edit().putString(str6, Base64.encodeToString(c23394wq62.q(), 0)).commit();
                    c23394wq62.p();
                    aVar = this;
                }
                try {
                    aVar.e = arrayList;
                } catch (Exception e3) {
                    e = e3;
                    AbstractC6403Nl2.e(e, !str.equals(e.getMessage()));
                    AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.wC0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.I(z, e, runnable);
                        }
                    });
                    return;
                }
            } else {
                str = "APP_PAUSED";
            }
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.KC0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.G();
                }
            });
        } catch (Exception e4) {
            e = e4;
            str = "APP_PAUSED";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ir.nasim.tgwidgets.editor.messenger.camera.c cVar, Runnable runnable, SurfaceTexture surfaceTexture, Runnable runnable2) throws IOException {
        ir.nasim.tgwidgets.editor.messenger.camera.b bVar = cVar.a;
        Camera camera = bVar.b;
        if (camera == null) {
            try {
                Camera cameraOpen = Camera.open(bVar.a);
                bVar.b = cameraOpen;
                camera = cameraOpen;
            } catch (Exception e) {
                cVar.a.b = null;
                if (camera != null) {
                    camera.release();
                }
                AbstractC6403Nl2.d(e);
                return;
            }
        }
        camera.setErrorCallback(w(cVar));
        List<String> supportedFlashModes = camera.getParameters().getSupportedFlashModes();
        cVar.w.clear();
        if (supportedFlashModes != null) {
            for (int i = 0; i < supportedFlashModes.size(); i++) {
                String str = supportedFlashModes.get(i);
                if (str.equals("off") || str.equals("on") || str.equals("auto")) {
                    cVar.w.add(str);
                }
            }
            cVar.l((String) cVar.w.get(0));
        }
        if (runnable != null) {
            runnable.run();
        }
        cVar.m();
        camera.setPreviewTexture(surfaceTexture);
        camera.startPreview();
        if (runnable2 != null) {
            AbstractC21455b.m1(runnable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(c cVar, File file, final boolean z, Runnable runnable) {
        cVar.b(file, new Runnable() { // from class: ir.nasim.EC0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.L(z);
            }
        });
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(Camera camera, ir.nasim.tgwidgets.editor.messenger.camera.c cVar, final c cVar2, final File file, final boolean z, final Runnable runnable) {
        try {
            if (camera != null) {
                try {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(cVar.r().equals("on") ? "torch" : "off");
                    camera.setParameters(parameters);
                    cVar.A();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.DC0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.M(cVar2, file, z, runnable);
                    }
                });
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Camera camera, ir.nasim.tgwidgets.editor.messenger.camera.c cVar, boolean z, File file, ir.nasim.tgwidgets.editor.messenger.camera.b bVar, d dVar, Runnable runnable) throws IllegalStateException, IOException, IllegalArgumentException {
        if (camera != null) {
            try {
                try {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(cVar.r().equals("on") ? "torch" : "off");
                    camera.setParameters(parameters);
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
                camera.unlock();
                try {
                    this.d = z;
                    MediaRecorder mediaRecorder = new MediaRecorder();
                    this.b = mediaRecorder;
                    mediaRecorder.setCamera(camera);
                    this.b.setVideoSource(1);
                    this.b.setAudioSource(5);
                    cVar.n(1, this.b);
                    this.b.setOutputFile(file.getAbsolutePath());
                    this.b.setMaxFileSize(1073741824L);
                    this.b.setVideoFrameRate(30);
                    this.b.setMaxDuration(0);
                    RD6 rd6R = r(bVar.b(), 720, 480, new RD6(16, 9), false);
                    this.b.setVideoEncodingBitRate(Math.min(rd6R.b, rd6R.a) >= 720 ? 3500000 : 1800000);
                    this.b.setVideoSize(rd6R.b(), rd6R.a());
                    this.b.setOnInfoListener(this);
                    this.b.prepare();
                    this.b.start();
                    this.f = dVar;
                    this.c = file.getAbsolutePath();
                    if (runnable != null) {
                        AbstractC21455b.m1(runnable);
                    }
                } catch (Exception e2) {
                    this.b.release();
                    this.b = null;
                    AbstractC6403Nl2.d(e2);
                }
            } catch (Exception e3) {
                AbstractC6403Nl2.d(e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(Camera camera, ir.nasim.tgwidgets.editor.messenger.camera.c cVar) {
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(cVar.r());
            camera.setParameters(parameters);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(final ir.nasim.tgwidgets.editor.messenger.camera.c cVar, boolean z, boolean z2) throws Throwable {
        MediaRecorder mediaRecorder;
        try {
            final Camera camera = cVar.a.b;
            if (camera != null && (mediaRecorder = this.b) != null) {
                this.b = null;
                try {
                    mediaRecorder.stop();
                } catch (Exception e) {
                    AbstractC6403Nl2.d(e);
                }
                try {
                    mediaRecorder.release();
                } catch (Exception e2) {
                    AbstractC6403Nl2.d(e2);
                }
                try {
                    camera.reconnect();
                    camera.startPreview();
                } catch (Exception e3) {
                    AbstractC6403Nl2.d(e3);
                }
                try {
                    cVar.G();
                } catch (Exception e4) {
                    AbstractC6403Nl2.d(e4);
                }
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode("off");
                camera.setParameters(parameters);
            } catch (Exception e5) {
                AbstractC6403Nl2.d(e5);
            }
            this.a.execute(new Runnable() { // from class: ir.nasim.CC0
                @Override // java.lang.Runnable
                public final void run() {
                    ir.nasim.tgwidgets.editor.messenger.camera.a.P(camera, cVar);
                }
            });
            if (z || this.f == null) {
                this.f = null;
            } else {
                L(z2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9 A[Catch: Exception -> 0x00af, TRY_LEAVE, TryCatch #0 {Exception -> 0x00af, blocks: (B:8:0x0045, B:29:0x00ab, B:32:0x00b2, B:34:0x00c9), top: B:41:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void R(java.io.File r9, ir.nasim.tgwidgets.editor.messenger.camera.b r10, boolean r11, boolean r12, ir.nasim.tgwidgets.editor.messenger.Utilities.b r13, byte[] r14, android.hardware.Camera r15) throws java.io.IOException {
        /*
            int r15 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.g0()
            float r15 = (float) r15
            float r0 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.g
            float r15 = r15 / r0
            int r15 = (int) r15
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = r9.getAbsolutePath()
            java.lang.String r1 = ir.nasim.tgwidgets.editor.messenger.Utilities.a(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            java.lang.Object[] r15 = new java.lang.Object[]{r1, r2, r15}
            java.lang.String r1 = "%s@%d_%d"
            java.lang.String r15 = java.lang.String.format(r0, r1, r15)
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L3c
            r1.<init>()     // Catch: java.lang.Throwable -> L3c
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch: java.lang.Throwable -> L3c
            int r3 = r14.length     // Catch: java.lang.Throwable -> L3c
            android.graphics.BitmapFactory.decodeByteArray(r14, r0, r3, r1)     // Catch: java.lang.Throwable -> L3c
            r1.inJustDecodeBounds = r0     // Catch: java.lang.Throwable -> L3c
            r1.inPurgeable = r2     // Catch: java.lang.Throwable -> L3c
            int r2 = r14.length     // Catch: java.lang.Throwable -> L3c
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r14, r0, r2, r1)     // Catch: java.lang.Throwable -> L3c
            goto L41
        L3c:
            r1 = move-exception
            ir.nasim.AbstractC6403Nl2.d(r1)
            r1 = 0
        L41:
            int r2 = y(r14)     // Catch: java.lang.Exception -> Ld6
            int r10 = r10.e     // Catch: java.lang.Exception -> Laf
            if (r10 == 0) goto Lb2
            if (r11 == 0) goto Lb2
            android.graphics.Matrix r7 = new android.graphics.Matrix     // Catch: java.lang.Throwable -> L5a
            r7.<init>()     // Catch: java.lang.Throwable -> L5a
            if (r12 != 0) goto L5c
            r10 = -1
            if (r2 == r10) goto L5c
            float r10 = (float) r2     // Catch: java.lang.Throwable -> L5a
            r7.setRotate(r10)     // Catch: java.lang.Throwable -> L5a
            goto L5c
        L5a:
            r10 = move-exception
            goto Lab
        L5c:
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 1065353216(0x3f800000, float:1.0)
            r7.postScale(r10, r11)     // Catch: java.lang.Throwable -> L79
            int r5 = r1.getWidth()     // Catch: java.lang.Throwable -> L79
            int r6 = r1.getHeight()     // Catch: java.lang.Throwable -> L79
            r8 = 1
            r3 = 0
            r4 = 0
            r2 = r1
            android.graphics.Bitmap r10 = ir.nasim.tgwidgets.editor.messenger.AbstractC21456c.b(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L79
            if (r10 == r1) goto L7c
            r1.recycle()     // Catch: java.lang.Throwable -> L79
            goto L7c
        L79:
            r10 = move-exception
            r2 = r0
            goto Lab
        L7c:
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L79
            r11.<init>(r9)     // Catch: java.lang.Throwable -> L79
            android.graphics.Bitmap$CompressFormat r12 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L79
            r2 = 80
            r10.compress(r12, r2, r11)     // Catch: java.lang.Throwable -> L79
            r11.flush()     // Catch: java.lang.Throwable -> L79
            java.io.FileDescriptor r12 = r11.getFD()     // Catch: java.lang.Throwable -> L79
            r12.sync()     // Catch: java.lang.Throwable -> L79
            r11.close()     // Catch: java.lang.Throwable -> L79
            ir.nasim.tgwidgets.editor.messenger.d r11 = ir.nasim.tgwidgets.editor.messenger.C21457d.g0()     // Catch: java.lang.Throwable -> L79
            android.graphics.drawable.BitmapDrawable r12 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Throwable -> L79
            r12.<init>(r10)     // Catch: java.lang.Throwable -> L79
            r11.D0(r12, r15, r0)     // Catch: java.lang.Throwable -> L79
            if (r13 == 0) goto Laa
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L79
            r13.a(r10)     // Catch: java.lang.Throwable -> L79
        Laa:
            return
        Lab:
            ir.nasim.AbstractC6403Nl2.d(r10)     // Catch: java.lang.Exception -> Laf
            goto Lb2
        Laf:
            r9 = move-exception
            r0 = r2
            goto Ld7
        Lb2:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> Laf
            r10.<init>(r9)     // Catch: java.lang.Exception -> Laf
            r10.write(r14)     // Catch: java.lang.Exception -> Laf
            r10.flush()     // Catch: java.lang.Exception -> Laf
            java.io.FileDescriptor r9 = r10.getFD()     // Catch: java.lang.Exception -> Laf
            r9.sync()     // Catch: java.lang.Exception -> Laf
            r10.close()     // Catch: java.lang.Exception -> Laf
            if (r1 == 0) goto Ldb
            ir.nasim.tgwidgets.editor.messenger.d r9 = ir.nasim.tgwidgets.editor.messenger.C21457d.g0()     // Catch: java.lang.Exception -> Laf
            android.graphics.drawable.BitmapDrawable r10 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Exception -> Laf
            r10.<init>(r1)     // Catch: java.lang.Exception -> Laf
            r9.D0(r10, r15, r0)     // Catch: java.lang.Exception -> Laf
            goto Ldb
        Ld6:
            r9 = move-exception
        Ld7:
            ir.nasim.AbstractC6403Nl2.d(r9)
            r2 = r0
        Ldb:
            if (r13 == 0) goto Le4
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r13.a(r9)
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.a.R(java.io.File, ir.nasim.tgwidgets.editor.messenger.camera.b, boolean, boolean, ir.nasim.tgwidgets.editor.messenger.Utilities$b, byte[], android.hardware.Camera):void");
    }

    private static int T(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    public static RD6 r(List list, int i, int i2, RD6 rd6, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        int iB = rd6.b();
        int iA = rd6.a();
        for (int i3 = 0; i3 < list.size(); i3++) {
            RD6 rd62 = (RD6) list.get(i3);
            if (!z || (rd62.a() <= i2 && rd62.b() <= i)) {
                if (rd62.a() == (rd62.b() * iA) / iB && rd62.b() >= i && rd62.a() >= i2) {
                    arrayList.add(rd62);
                } else if (rd62.a() * rd62.b() <= i * i2 * 4) {
                    arrayList2.add(rd62);
                }
            }
        }
        return arrayList.size() > 0 ? (RD6) Collections.min(arrayList, new C1579a()) : arrayList2.size() > 0 ? (RD6) Collections.min(arrayList2, new C1579a()) : (RD6) Collections.max(list, new C1579a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.a.L(boolean):void");
    }

    public static a x() {
        a aVar = l;
        if (aVar == null) {
            synchronized (a.class) {
                try {
                    aVar = l;
                    if (aVar == null) {
                        aVar = new a();
                        l = aVar;
                    }
                } finally {
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        r9 = 0;
        r2 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int y(byte[] r11) {
        /*
            Method dump skipped, instructions count: 189
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.camera.a.y(byte[]):int");
    }

    public boolean B() {
        return (!this.g || this.e == null || this.e.isEmpty()) ? false : true;
    }

    public void S(final ir.nasim.tgwidgets.editor.messenger.camera.c cVar, final SurfaceTexture surfaceTexture, final Runnable runnable, final Runnable runnable2) {
        if (cVar == null || surfaceTexture == null) {
            return;
        }
        this.a.execute(new Runnable() { // from class: ir.nasim.GC0
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.K(cVar, runnable2, surfaceTexture, runnable);
            }
        });
    }

    public void U(final ir.nasim.tgwidgets.editor.messenger.camera.c cVar, final File file, final boolean z, final d dVar, final Runnable runnable, final c cVar2, final boolean z2) {
        if (cVar == null) {
            return;
        }
        final ir.nasim.tgwidgets.editor.messenger.camera.b bVar = cVar.a;
        final Camera camera = bVar.b;
        if (cVar2 == null) {
            this.a.execute(new Runnable() { // from class: ir.nasim.zC0
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException, IOException, IllegalArgumentException {
                    this.a.O(camera, cVar, z, file, bVar, dVar, runnable);
                }
            });
            return;
        }
        this.j = cVar2;
        this.f = dVar;
        this.c = file.getAbsolutePath();
        this.a.execute(new Runnable() { // from class: ir.nasim.yC0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N(camera, cVar, cVar2, file, z2, runnable);
            }
        });
    }

    public void V(b bVar) {
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            arrayList.remove(bVar);
        }
    }

    public void W(ir.nasim.tgwidgets.editor.messenger.camera.c cVar, boolean z) {
        X(cVar, z, true);
    }

    public void X(final ir.nasim.tgwidgets.editor.messenger.camera.c cVar, final boolean z, final boolean z2) {
        c cVar2 = this.j;
        if (cVar2 == null) {
            this.a.execute(new Runnable() { // from class: ir.nasim.AC0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.a.Q(cVar, z, z2);
                }
            });
        } else {
            cVar2.a();
            this.j = null;
        }
    }

    public boolean Y(final File file, final boolean z, ir.nasim.tgwidgets.editor.messenger.camera.c cVar, final Utilities.b bVar) {
        if (cVar == null) {
            return false;
        }
        final ir.nasim.tgwidgets.editor.messenger.camera.b bVar2 = cVar.a;
        final boolean zX = cVar.x();
        try {
            bVar2.b.takePicture(null, null, new Camera.PictureCallback() { // from class: ir.nasim.xC0
                @Override // android.hardware.Camera.PictureCallback
                public final void onPictureTaken(byte[] bArr, Camera camera) throws IOException {
                    ir.nasim.tgwidgets.editor.messenger.camera.a.R(file, bVar2, zX, z, bVar, bArr, camera);
                }
            });
            return true;
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return false;
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws Throwable {
        if (i == 800 || i == 801 || i == 1) {
            MediaRecorder mediaRecorder2 = this.b;
            this.b = null;
            if (mediaRecorder2 != null) {
                mediaRecorder2.stop();
                mediaRecorder2.release();
            }
            if (this.f != null) {
                L(true);
            }
        }
    }

    public void q(b bVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.remove(bVar);
        this.k.add(bVar);
    }

    public void s(ir.nasim.tgwidgets.editor.messenger.camera.c cVar, CountDownLatch countDownLatch, Runnable runnable) {
        t(cVar, countDownLatch, runnable, null);
    }

    public void t(final ir.nasim.tgwidgets.editor.messenger.camera.c cVar, final CountDownLatch countDownLatch, final Runnable runnable, final Runnable runnable2) {
        cVar.p();
        this.a.execute(new Runnable() { // from class: ir.nasim.FC0
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.tgwidgets.editor.messenger.camera.a.C(runnable, cVar, countDownLatch, runnable2);
            }
        });
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
    }

    public ArrayList v() {
        return this.e;
    }

    public Camera.ErrorCallback w(final ir.nasim.tgwidgets.editor.messenger.camera.c cVar) {
        return new Camera.ErrorCallback() { // from class: ir.nasim.HC0
            @Override // android.hardware.Camera.ErrorCallback
            public final void onError(int i, Camera camera) {
                this.a.E(cVar, i, camera);
            }
        };
    }

    public void z(Runnable runnable) {
        A(runnable, false);
    }
}
