package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.provider.MediaStore;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC11436d03;
import ir.nasim.AbstractC12384eX1;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.C10743c74;
import ir.nasim.C18727p87;
import ir.nasim.C19526qV6;
import ir.nasim.C22477vI7;
import ir.nasim.C4278El2;
import ir.nasim.C6372Nh7;
import ir.nasim.C8492We7;
import ir.nasim.InterfaceC19490qR6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes7.dex */
public class l extends AbstractC11436d03 {
    public int D;
    public int E;
    public Bitmap H;
    public File I;
    public File J;
    public File K;
    public ArrayList M;
    public List N;
    public File O;
    public MediaController.n P;
    public Bitmap Q;
    private boolean R;
    public b S;
    public C19526qV6 g;
    public long i;
    public boolean j;
    public long k;
    public boolean l;
    public boolean n;
    public boolean o;
    public boolean p;
    public File q;
    public boolean r;
    public String s;
    public boolean t;
    public float u;
    public int w;
    public int x;
    public long y;
    public InterfaceC19490qR6 f = InterfaceC19490qR6.a.a;
    public final int h = C22477vI7.f;
    public double m = -1.0d;
    public float v = 1.0f;
    public int z = 720;
    public int A = SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
    public int B = 1;
    public final ArrayList C = new ArrayList();
    public final ArrayList F = new ArrayList();
    public int G = 86400;
    public long L = 5000;
    private int T = 0;

    public interface a {
        Bitmap a(BitmapFactory.Options options);
    }

    public static class b {
        public int a;
        public int b;
        public int c;
        public float d;
        public float e;

        public int a() {
            if ((this.d > 0.0f || this.e > 0.0f) && this.a == 6) {
                int i = this.c;
                if (i == 7) {
                    return 1;
                }
                if (i == 6) {
                    return 2;
                }
            }
            return 0;
        }
    }

    public static class c extends AbstractC11436d03 {
        public File f;
        public boolean g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bitmap A(BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(this.K.getPath(), options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Utilities.b bVar) {
        bVar.a(this.S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final Utilities.b bVar) {
        Runnable runnable;
        try {
            try {
                b bVar2 = this.S;
                if (bVar2 == null) {
                    bVar2 = new b();
                    this.S = bVar2;
                    bVar2.d = 1000.0f;
                    bVar2.e = 0.001f;
                }
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(this.q.getAbsolutePath());
                int iX = MediaController.X(mediaExtractor, false);
                mediaExtractor.selectTrack(iX);
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(iX);
                if (trackFormat.containsKey("color-transfer")) {
                    bVar2.c = trackFormat.getInteger("color-transfer");
                }
                if (trackFormat.containsKey("color-standard")) {
                    bVar2.a = trackFormat.getInteger("color-standard");
                }
                if (trackFormat.containsKey("color-range")) {
                    bVar2.b = trackFormat.getInteger("color-range");
                }
                this.S = this.S;
                runnable = new Runnable() { // from class: ir.nasim.tQ6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.B(bVar);
                    }
                };
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                this.S = this.S;
                runnable = new Runnable() { // from class: ir.nasim.tQ6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.B(bVar);
                    }
                };
            }
            AbstractC21455b.m1(runnable);
        } catch (Throwable th) {
            this.S = this.S;
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tQ6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.B(bVar);
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(String str, int[] iArr, Utilities.b bVar) throws IOException, IllegalArgumentException {
        ArrayList arrayList;
        H h = new H();
        h.C = true;
        h.O = this.R;
        h.h = this.b;
        h.i = this.c;
        h.k = this.z;
        h.l = this.A;
        File file = this.K;
        h.y = file == null ? null : file.getPath();
        int iW = MediaController.W(h.k, h.l, h.m, true);
        if (this.p) {
            h.o = str;
            h.B = false;
            h.n = Math.min(59, iArr[7]);
            int iA0 = MediaController.a0(str);
            if (iA0 == -1) {
                iA0 = iArr[3];
            }
            h.j = iA0;
            if (iA0 >= 1000000 || (arrayList = this.M) == null || arrayList.isEmpty()) {
                int i = h.j;
                if (i < 500000) {
                    h.m = 2500000;
                    h.j = -1;
                } else {
                    h.m = Utilities.d(i, 3000000, 500000);
                }
            } else {
                h.m = 2000000;
                h.j = -1;
            }
            AbstractC6403Nl2.a("story bitrate, original = " + h.j + " => " + h.m);
            int i2 = iArr[4];
            long j = (long) i2;
            this.y = j;
            h.t = j * 1000;
            long j2 = ((long) (this.u * ((float) j))) * 1000;
            h.a = j2;
            long j3 = ((long) (this.v * j)) * 1000;
            h.b = j3;
            h.q = j3 - j2;
            h.s = this.t;
            h.p = (long) (iArr[5] + (((i2 / 1000.0f) * iW) / 8.0f));
            h.p = Math.max(this.q.length(), h.p);
            h.x = this.P;
        } else {
            File file2 = this.O;
            if (file2 != null) {
                h.o = file2.getAbsolutePath();
            } else {
                h.o = str;
            }
            h.B = true;
            long j4 = this.L;
            this.y = j4;
            h.t = j4;
            h.q = j4;
            h.a = -1L;
            h.b = -1L;
            h.s = true;
            h.j = -1;
            h.m = -1;
            h.n = 30;
            h.p = (long) (((j4 / 1000.0f) * iW) / 8.0f);
            h.x = null;
        }
        h.c = -1L;
        MediaController.i iVar = new MediaController.i();
        h.A = iVar;
        iVar.r = new Matrix();
        h.A.r.set(this.d);
        h.z = this.M;
        h.F = Integer.valueOf(this.D);
        h.G = Integer.valueOf(this.E);
        h.H = true;
        h.D = this.S;
        h.E = this.C;
        bVar.a(h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(final String str, final Utilities.b bVar) {
        final int[] iArr = new int[11];
        AnimatedFileDrawable.G0(str, iArr);
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.qQ6
            @Override // java.lang.Runnable
            public final void run() throws IOException, IllegalArgumentException {
                this.a.D(str, iArr, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Bitmap bitmap, Runnable runnable, int[] iArr) {
        this.D = iArr[0];
        this.E = iArr[1];
        bitmap.recycle();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Bitmap bitmap, Runnable runnable) {
        try {
            bitmap.compress(Bitmap.CompressFormat.WEBP, 90, new FileOutputStream(this.O));
        } catch (Exception e) {
            AbstractC6403Nl2.e(e, false);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, new FileOutputStream(this.O));
            } catch (Exception e2) {
                AbstractC6403Nl2.e(e2, false);
            }
        }
        bitmap.recycle();
        AbstractC21455b.m1(runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [ir.nasim.Nh7, ir.nasim.vi7] */
    public static File H(int i, String str) {
        C8492We7 c8492We7;
        C18727p87 c18727p87 = new C18727p87();
        c18727p87.c = -2147483648L;
        c18727p87.b = RecyclerView.UNDEFINED_DURATION;
        c18727p87.d = AbstractC8662Wx6.i();
        c18727p87.f = new byte[0];
        if ("mp4".equals(str)) {
            ?? c6372Nh7 = new C6372Nh7();
            c6372Nh7.d = c18727p87;
            c8492We7 = c6372Nh7;
        } else {
            C8492We7 c8492We72 = new C8492We7();
            c8492We72.c = c18727p87;
            c8492We7 = c8492We72;
        }
        return C4278El2.H(i).O(c8492We7, str, true);
    }

    public static File I(int i, boolean z) {
        return H(i, z ? "mp4" : "jpg");
    }

    public static void M(BitmapFactory.Options options, int i, int i2) {
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 * i4 * 8 > jMaxMemory || Math.max(i3, i4) > 4200 || AbstractC8662Wx6.h() <= 0) {
            options.inScaled = true;
            options.inDensity = options.outWidth;
            options.inTargetDensity = i;
        }
    }

    public static int k(BitmapFactory.Options options, int i, int i2) {
        double dMin = (options.outHeight > i2 || options.outWidth > i) ? Math.min((int) Math.ceil(r0 / i2), (int) Math.ceil(r6 / i)) : 1;
        return Math.max(1, (int) Math.pow(dMin, Math.floor(Math.log(dMin) / Math.log(2.0d))));
    }

    public static l r(MediaController.m mVar, float f) {
        l lVar = new l();
        lVar.q = new File(mVar.A);
        lVar.w = mVar.B;
        lVar.x = mVar.C;
        lVar.p = mVar.D;
        lVar.s = mVar.b;
        long j = mVar.w * 1000;
        lVar.y = j;
        lVar.u = 0.0f;
        lVar.v = Math.min(1.0f, (f * 1000.0f) / j);
        if (lVar.p && lVar.s == null) {
            lVar.s = "vthumb://" + mVar.u;
        }
        lVar.D = mVar.F;
        lVar.E = mVar.G;
        lVar.o(lVar.q.getAbsolutePath());
        lVar.K();
        return lVar;
    }

    public static l s(File file, int i) {
        l lVar = new l();
        lVar.q = file;
        lVar.r = true;
        lVar.w = i;
        lVar.x = 0;
        lVar.p = false;
        if (file != null) {
            lVar.o(file.getAbsolutePath());
        }
        lVar.K();
        return lVar;
    }

    public static l t(File file, String str, long j, float f) {
        l lVar = new l();
        lVar.R = true;
        lVar.q = file;
        lVar.r = true;
        lVar.w = 0;
        lVar.x = 0;
        lVar.p = true;
        lVar.y = j;
        lVar.s = str;
        lVar.u = 0.0f;
        lVar.v = Math.min(1.0f, f / j);
        return lVar;
    }

    public static Bitmap v(a aVar, int i, int i2, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        aVar.a(options);
        options.inJustDecodeBounds = false;
        options.inScaled = false;
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        boolean z2 = ((double) ((((long) (i3 * i4)) * 4) + (((long) (i * i2)) * 4))) * 1.1d <= ((double) jMaxMemory);
        if (i3 <= i && i4 <= i2) {
            return aVar.a(options);
        }
        if (!z2 || AbstractC8662Wx6.h() < 1) {
            options.inScaled = true;
            options.inDensity = options.outWidth;
            options.inTargetDensity = i;
            return aVar.a(options);
        }
        Bitmap bitmapA = aVar.a(options);
        float fMax = Math.max(i / bitmapA.getWidth(), i2 / bitmapA.getHeight());
        int width = (int) (bitmapA.getWidth() * fMax);
        int height = (int) (bitmapA.getHeight() * fMax);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapA, tileMode, tileMode);
        Paint paint = new Paint(3);
        paint.setShader(bitmapShader);
        int iD = Utilities.d(Math.round(1.0f / fMax), 8, 0);
        matrix.reset();
        matrix.postScale(fMax, fMax);
        bitmapShader.setLocalMatrix(matrix);
        canvas.drawRect(0.0f, 0.0f, width, height, paint);
        if (z && iD > 0) {
            Utilities.stackBlurBitmap(bitmapCreateBitmap, iD);
        }
        return bitmapCreateBitmap;
    }

    private boolean x(AbstractC18106o57 abstractC18106o57, String str) {
        if (abstractC18106o57 != null) {
            if (C10743c74.l0(abstractC18106o57)) {
                return true;
            }
            if (C10743c74.m0(abstractC18106o57, true) && RLottieDrawable.getFramesCount(str, null) > 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bitmap y(File file, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(file.getPath(), options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bitmap z(c cVar, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(cVar.f.getPath(), options);
    }

    public void J(final Runnable runnable) {
        final Bitmap bitmapDecodeFile;
        if (this.p && this.D == 0 && this.E == 0 && this.s != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (this.s.startsWith("vthumb://")) {
                    long j = Integer.parseInt(this.s.substring(9));
                    options.inJustDecodeBounds = true;
                    MediaStore.Video.Thumbnails.getThumbnail(AbstractC14047hG.a.getContentResolver(), j, 1, options);
                    options.inSampleSize = k(options, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inDither = true;
                    bitmapDecodeFile = MediaStore.Video.Thumbnails.getThumbnail(AbstractC14047hG.a.getContentResolver(), j, 1, options);
                } else {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.s);
                    options.inSampleSize = k(options, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inDither = true;
                    bitmapDecodeFile = BitmapFactory.decodeFile(this.s);
                }
            } catch (Exception unused) {
                bitmapDecodeFile = null;
            }
            if (bitmapDecodeFile != null) {
                AbstractC12384eX1.b(true, bitmapDecodeFile, true, new Utilities.b() { // from class: ir.nasim.sQ6
                    @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                    public final void a(Object obj) {
                        this.a.F(bitmapDecodeFile, runnable, (int[]) obj);
                    }
                });
            }
        }
    }

    public void K() {
        L(this.d, 0);
    }

    public void L(Matrix matrix, int i) {
        matrix.reset();
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.w + i;
        int i5 = this.x;
        matrix.postScale(i5 == 1 ? -1.0f : 1.0f, i5 == 2 ? -1.0f : 1.0f, i2 / 2.0f, i3 / 2.0f);
        if (i4 != 0) {
            matrix.postTranslate((-i2) / 2.0f, (-i3) / 2.0f);
            matrix.postRotate(i4);
            if (i4 == 90 || i4 == 270) {
                i3 = i2;
                i2 = i3;
            }
            matrix.postTranslate(i2 / 2.0f, i3 / 2.0f);
        }
        float f = i2;
        float fMax = this.z / f;
        float f2 = i3;
        if (f2 / f > 1.29f) {
            fMax = Math.max(fMax, this.A / f2);
        }
        matrix.postScale(fMax, fMax);
        matrix.postTranslate((this.z - (f * fMax)) / 2.0f, (this.A - (f2 * fMax)) / 2.0f);
    }

    public void N(PhotoFilterView photoFilterView, final Runnable runnable) {
        m();
        MediaController.n savedFilterState = photoFilterView.getSavedFilterState();
        this.P = savedFilterState;
        if (this.p) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (savedFilterState.a()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        Bitmap bitmap = photoFilterView.getBitmap();
        if (bitmap == null) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = this.x;
        matrix.postScale(i == 1 ? -1.0f : 1.0f, i == 2 ? -1.0f : 1.0f, this.b / 2.0f, this.c / 2.0f);
        matrix.postRotate(-this.w);
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        this.d.preScale(this.b / bitmapCreateBitmap.getWidth(), this.c / bitmapCreateBitmap.getHeight());
        this.b = bitmapCreateBitmap.getWidth();
        this.c = bitmapCreateBitmap.getHeight();
        bitmap.recycle();
        File file = this.O;
        if (file != null && file.exists()) {
            this.O.delete();
        }
        this.O = H(this.h, "webp");
        if (runnable != null) {
            Utilities.g.i(new Runnable() { // from class: ir.nasim.uQ6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.G(bitmapCreateBitmap, runnable);
                }
            });
            return;
        }
        try {
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.WEBP, 90, new FileOutputStream(this.O));
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        bitmapCreateBitmap.recycle();
    }

    public boolean O() {
        ArrayList arrayList;
        if (this.p) {
            return true;
        }
        ArrayList arrayList2 = this.M;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (int i = 0; i < this.M.size(); i++) {
                H.b bVar = (H.b) this.M.get(i);
                byte b2 = bVar.a;
                if (b2 == 0) {
                    if (x(bVar.v, bVar.h)) {
                        return true;
                    }
                } else if (b2 == 1 && (arrayList = bVar.i) != null && !arrayList.isEmpty()) {
                    for (int i2 = 0; i2 < bVar.i.size(); i2++) {
                        H.a aVar = (H.a) bVar.i.get(i2);
                        if (x(aVar.g, aVar.i)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void j(File file) throws IOException {
        Matrix matrix = new Matrix();
        Paint paint = new Paint(7);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.z, this.A, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint2 = new Paint(1);
        paint2.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, canvas.getHeight(), new int[]{this.D, this.E}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), paint2);
        matrix.set(this.d);
        final File file2 = this.O;
        if (file2 == null) {
            file2 = this.q;
        }
        if (file2 != null) {
            try {
                Bitmap bitmapV = v(new a() { // from class: ir.nasim.mQ6
                    @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.l.a
                    public final Bitmap a(BitmapFactory.Options options) {
                        return ir.nasim.tgwidgets.editor.ui.stories.recorder.l.y(file2, options);
                    }
                }, this.z, this.A, true);
                float width = this.b / bitmapV.getWidth();
                matrix.preScale(width, width);
                canvas.drawBitmap(bitmapV, matrix, paint);
                bitmapV.recycle();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
        for (int i = 0; i < this.C.size(); i++) {
            try {
                final c cVar = (c) this.C.get(i);
                Bitmap bitmapV2 = v(new a() { // from class: ir.nasim.nQ6
                    @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.l.a
                    public final Bitmap a(BitmapFactory.Options options) {
                        return ir.nasim.tgwidgets.editor.ui.stories.recorder.l.z(cVar, options);
                    }
                }, this.z, this.A, false);
                float width2 = cVar.b / bitmapV2.getWidth();
                matrix.set(cVar.d);
                matrix.preScale(width2, width2);
                canvas.drawBitmap(bitmapV2, matrix, paint);
                bitmapV2.recycle();
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
        }
        if (this.K != null) {
            try {
                Bitmap bitmapV3 = v(new a() { // from class: ir.nasim.oQ6
                    @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.l.a
                    public final Bitmap a(BitmapFactory.Options options) {
                        return this.a.A(options);
                    }
                }, this.z, this.A, false);
                canvas.save();
                float width3 = this.z / bitmapV3.getWidth();
                canvas.scale(width3, width3);
                canvas.drawBitmap(bitmapV3, 0.0f, 0.0f, paint);
                canvas.restore();
                bitmapV3.recycle();
            } catch (Exception e3) {
                AbstractC6403Nl2.d(e3);
            }
        }
        this.Q = Bitmap.createScaledBitmap(bitmapCreateBitmap, 40, 22, true);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e4) {
            AbstractC6403Nl2.d(e4);
        }
        bitmapCreateBitmap.recycle();
    }

    public void l() {
        if (this.T != 0) {
            ConnectionsManager.k(this.h).i(this.T, true);
        }
    }

    public void m() {
        File file = this.O;
        if (file != null) {
            file.delete();
            this.O = null;
        }
    }

    public void n() {
        File file = this.K;
        if (file != null) {
            file.delete();
            this.K = null;
        }
    }

    public void o(String str) {
        if (str != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                this.b = options.outWidth;
                this.c = options.outHeight;
            } catch (Exception unused) {
            }
        }
        if (this.p) {
            return;
        }
        if (((int) Math.max(this.b, (this.c / 16.0f) * 9.0f)) <= 900) {
            this.z = 720;
            this.A = SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
        } else {
            this.z = 1080;
            this.A = 1920;
        }
    }

    public void p(boolean z) {
        Bitmap bitmap = this.H;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.H.recycle();
            this.H = null;
        }
        File file = this.I;
        if (file != null) {
            file.delete();
            this.I = null;
        }
        if (!z) {
            n();
            m();
            File file2 = this.q;
            if (file2 != null) {
                if (this.r && (!this.l || this.n)) {
                    file2.delete();
                }
                this.q = null;
            }
            if (this.s != null) {
                if (this.r) {
                    new File(this.s).delete();
                }
                this.s = null;
            }
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.g) {
                    cVar.f.delete();
                }
                cVar.f = null;
            }
        }
        l();
    }

    public void q(final Utilities.b bVar) {
        if (bVar == null) {
            return;
        }
        Object obj = this.S;
        if (obj != null) {
            bVar.a(obj);
        } else {
            if (this.p) {
                Utilities.e.i(new Runnable() { // from class: ir.nasim.rQ6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.C(bVar);
                    }
                });
                return;
            }
            b bVar2 = new b();
            this.S = bVar2;
            bVar.a(bVar2);
        }
    }

    public File u() {
        File file = this.O;
        return file != null ? file : this.q;
    }

    public void w(final Utilities.b bVar) {
        int i;
        if (!O()) {
            bVar.a(null);
            return;
        }
        if (!this.p && ((i = this.z) > 720 || this.A > 1280)) {
            float f = 720.0f / i;
            this.d.postScale(f, f, 0.0f, 0.0f);
            this.z = 720;
            this.A = SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE;
        }
        final String absolutePath = this.q.getAbsolutePath();
        Utilities.e.i(new Runnable() { // from class: ir.nasim.pQ6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E(absolutePath, bVar);
            }
        });
    }
}
