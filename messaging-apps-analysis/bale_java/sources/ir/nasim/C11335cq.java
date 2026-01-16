package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.webkit.MimeTypeMap;
import com.bumptech.glide.load.engine.GlideException;
import ir.nasim.C19024pf0;
import ir.nasim.ME;
import ir.nasim.UO1;
import ir.nasim.XF2;
import ir.nasim.core.modules.file.FileSizeExceededException;
import ir.nasim.core.modules.file.GifSizeExceededException;
import ir.nasim.features.pfm.entity.AnalysisData;
import ir.nasim.features.pfm.entity.AnalysisDialogData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.cq, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C11335cq extends AbstractC18427oe4 {
    private static final Executor e = SZ.k("S_AM_Downloader");
    private final Context b;
    private final C9528a7 c;
    private final ME d;

    /* renamed from: ir.nasim.cq$a */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C11335cq.this.d2(intent);
        }
    }

    /* renamed from: ir.nasim.cq$b */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C11335cq.this.c2();
        }
    }

    /* renamed from: ir.nasim.cq$c */
    class c implements IT5 {
        final /* synthetic */ C11458d25 a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Long e;
        final /* synthetic */ Long f;
        final /* synthetic */ String g;
        final /* synthetic */ C7880To7 h;

        c(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, String str4, C7880To7 c7880To7) {
            this.a = c11458d25;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = l;
            this.f = l2;
            this.g = str4;
            this.h = c7880To7;
        }

        @Override // ir.nasim.IT5
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(Bitmap bitmap, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Bitmap bitmapO = V13.o(bitmap, 30, 30);
                C11335cq.this.A1(this.a, this.b, width, height, 0, new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO)), this.c, this.d, this.e, this.f, this.g, this.h);
                return true;
            } catch (Throwable th) {
                C19406qI3.c("AndroidMessenger", "sendGif", th);
                return true;
            }
        }

        @Override // ir.nasim.IT5
        public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
            return false;
        }
    }

    /* renamed from: ir.nasim.cq$f */
    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OP1.values().length];
            a = iArr;
            try {
                iArr[OP1.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OP1.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OP1.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OP1.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OP1.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C11335cq(Context context, C8468Wc1 c8468Wc1) {
        super(c8468Wc1);
        this.b = context;
        this.d = new C9381Zr4(this, this.a);
        this.c = C12736f7.n().d("actor/android/state", new V6() { // from class: ir.nasim.Tp
            @Override // ir.nasim.V6
            public final K6 create() {
                return this.a.z2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A2(int i) {
        AbstractC5593Jz6.a(C5721Ko.b, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C2(Integer num, AbstractC13554gQ7 abstractC13554gQ7) {
        if (num != null) {
            AbstractC5593Jz6.a(C5721Ko.b, num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.b.registerReceiver(new a(), intentFilter);
        if (w2()) {
            this.c.d(new ME.g());
        } else {
            this.c.d(new ME.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E2(String str, String str2, boolean z, boolean z2, C11458d25 c11458d25, String str3, Long l, Long l2, C7880To7 c7880To7, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C19406qI3.a("FiSeCoFl", "sendFile() called with: filePath = [" + str + "], sendMimeType = [" + str2 + "], sendPhotoOrVideoAsFile = [" + z + "], shouldBeCompressed = [" + z2 + "]", new Object[0]);
        try {
            X2(c11458d25, str3, l, l2, str2, z, false, z2, c7880To7, interfaceC15419jZ0, str);
        } catch (Exception e2) {
            interfaceC15419jZ0.onError(e2);
            C19406qI3.c("FiSeCoFl", "sendUri: ", e2);
            C19406qI3.d("AndroidMessenger", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(final String str, final String str2, final boolean z, final boolean z2, final C11458d25 c11458d25, final String str3, final Long l, final Long l2, final C7880To7 c7880To7, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        e.execute(new Runnable() { // from class: ir.nasim.Yp
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E2(str, str2, z, z2, c11458d25, str3, l, l2, c7880To7, interfaceC15419jZ0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object H2(C19247q16 c19247q16, String str, final String str2, InterfaceC20295rm1 interfaceC20295rm1) {
        return c19247q16.c(str, new UA2() { // from class: ir.nasim.Pp
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C11335cq.G2(str2, (InterfaceC20295rm1) obj);
            }
        }, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(final Uri uri, String str, boolean z, boolean z2, boolean z3, C11458d25 c11458d25, String str2, Long l, Long l2, C7880To7 c7880To7, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C19406qI3.a("FiSeCoFl", "sendUri() called with: uri = [" + uri + "], sendMimeType = [" + str + "], sendPhotoOrVideoAsFile = [" + z + "], sendVideoAsGif = [" + z2 + "], shouldBeCompressed = [" + z3 + "]", new Object[0]);
        try {
            final TF2 tf2A1 = ((InterfaceC19086pl2) C92.a(this.b, InterfaceC19086pl2.class)).a1();
            X2(c11458d25, str2, l, l2, str, z, z2, z3, c7880To7, interfaceC15419jZ0, (String) AbstractC24549yo1.b(new UA2() { // from class: ir.nasim.Qp
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return tf2A1.r(uri, (InterfaceC20295rm1) obj);
                }
            }));
        } catch (Exception e2) {
            interfaceC15419jZ0.onError(e2);
            C19406qI3.c("FiSeCoFl", "sendUri: ", e2);
            C19406qI3.d("AndroidMessenger", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(final Uri uri, final String str, final boolean z, final boolean z2, final boolean z3, final C11458d25 c11458d25, final String str2, final Long l, final Long l2, final C7880To7 c7880To7, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        e.execute(new Runnable() { // from class: ir.nasim.bq
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J2(uri, str, z, z2, z3, c11458d25, str2, l, l2, c7880To7, interfaceC15419jZ0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(String str, Uri uri, boolean z, InterfaceC15419jZ0 interfaceC15419jZ0, C11458d25 c11458d25, long j, String str2, Long l, C7880To7 c7880To7) throws FileNotFoundException {
        String str3;
        String str4;
        String str5;
        String mimeTypeFromExtension = str;
        String[] strArr = {"mime_type", "_display_name", "_size"};
        try {
            String path = uri.getPath();
            File file = new File(path);
            float fM2 = m2(file.length());
            if (!z && fM2 > this.a.S().h3()) {
                interfaceC15419jZ0.onError(new FileSizeExceededException());
                return;
            }
            String name = file.getName();
            Cursor cursorQuery = this.b.getContentResolver().query(uri, strArr, null, null, null);
            int i = 0;
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    int columnIndex = cursorQuery.getColumnIndex(strArr[0]);
                    int columnIndex2 = cursorQuery.getColumnIndex(strArr[1]);
                    int columnIndex3 = cursorQuery.getColumnIndex(strArr[2]);
                    if ((mimeTypeFromExtension == null || str.isEmpty() || mimeTypeFromExtension.contains(Separators.QUESTION)) && columnIndex != -1) {
                        mimeTypeFromExtension = cursorQuery.getString(columnIndex);
                    }
                    if (columnIndex2 != -1) {
                        name = cursorQuery.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        float fM22 = m2(cursorQuery.getLong(columnIndex3));
                        if (!z && fM22 > this.a.S().h3()) {
                            interfaceC15419jZ0.onError(new FileSizeExceededException());
                            cursorQuery.close();
                            return;
                        }
                    }
                }
                cursorQuery.close();
            }
            String extensionFromMimeType = mimeTypeFromExtension != null ? MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeTypeFromExtension) : "";
            if (extensionFromMimeType == null || extensionFromMimeType.isEmpty()) {
                extensionFromMimeType = C6906Pm2.l(name);
            }
            if (mimeTypeFromExtension == null || mimeTypeFromExtension.contains(Separators.QUESTION)) {
                if (!extensionFromMimeType.isEmpty()) {
                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extensionFromMimeType);
                }
                if (mimeTypeFromExtension == null) {
                    mimeTypeFromExtension = "?/?";
                }
            }
            if (path.isEmpty() || !(uri.getScheme() == null || uri.getScheme().equals("file"))) {
                File externalFilesDir = this.b.getExternalFilesDir(null);
                if (externalFilesDir == null) {
                    interfaceC15419jZ0.onError(new NullPointerException());
                    return;
                }
                String absolutePath = externalFilesDir.getAbsolutePath();
                String str6 = x2(mimeTypeFromExtension) ? "videos" : v2(mimeTypeFromExtension) ? "images" : t2(mimeTypeFromExtension) ? "audios" : "documents";
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                String str7 = File.separator;
                sb.append(str7);
                sb.append(str6);
                sb.append(str7);
                File file2 = new File(sb.toString());
                if (!file2.exists() && !file2.mkdirs()) {
                    file2 = new File(absolutePath + str7);
                }
                if (C6906Pm2.l(name).isEmpty() && !extensionFromMimeType.isEmpty()) {
                    name = name + Separators.DOT + extensionFromMimeType;
                }
                File file3 = new File(file2, name);
                String str8 = name;
                while (file3.exists()) {
                    i++;
                    if (extensionFromMimeType.isEmpty()) {
                        str5 = C6906Pm2.m(name) + " (" + i + Separators.RPAREN;
                    } else {
                        str5 = C6906Pm2.m(name) + " (" + i + ")." + extensionFromMimeType;
                    }
                    str8 = str5;
                    file3 = new File(file2, str8);
                }
                String absolutePath2 = file3.getAbsolutePath();
                InputStream inputStreamOpenInputStream = this.b.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    C19406qI3.b("AndroidMessenger", "Input stream of sharing uri is null!");
                    return;
                } else {
                    VZ2.b(inputStreamOpenInputStream, new File(absolutePath2));
                    str3 = absolutePath2;
                    str4 = str8;
                }
            } else {
                str3 = path;
                str4 = name;
            }
            z1(c11458d25, j, str4, str3, str2, l, c7880To7);
            interfaceC15419jZ0.a(Boolean.TRUE);
        } catch (Exception e2) {
            if (e2 instanceof IOException) {
                interfaceC15419jZ0.onError(e2);
            }
            C19406qI3.d("AndroidMessenger", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(final String str, final Uri uri, final boolean z, final C11458d25 c11458d25, final long j, final String str2, final Long l, final C7880To7 c7880To7, final InterfaceC15419jZ0 interfaceC15419jZ0) {
        e.execute(new Runnable() { // from class: ir.nasim.Sp
            @Override // java.lang.Runnable
            public final void run() throws FileNotFoundException {
                this.a.L2(str, uri, z, interfaceC15419jZ0, c11458d25, j, str2, l, c7880To7);
            }
        });
    }

    private void R2(Context context) {
        context.registerReceiver(new b(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void U2(C11458d25 c11458d25, String str, Long l, Long l2, String str2, String str3, String str4, boolean z, boolean z2, C7880To7 c7880To7) throws IOException {
        if (x2(str3)) {
            if (z) {
                c3(c11458d25, str2, str4, str, l, l2, str3, c7880To7);
                return;
            } else {
                b3(c11458d25, str2, str4, str, l, l2, z2, c7880To7);
                return;
            }
        }
        if (v2(str3)) {
            if (u2(str3)) {
                Y2(c11458d25, str2, str4, str, l, l2, str3, c7880To7);
                return;
            } else {
                Z2(c11458d25, str2, str4, str, l, l2, c7880To7);
                return;
            }
        }
        if (y2(str3)) {
            e3(c11458d25, 0, str2, l, l2, str, c7880To7);
        } else if (t2(str3)) {
            y1(c11458d25, str2, str4, str, l, l2, c7880To7);
        } else {
            V2(c11458d25, str2, str4, str, l, l2, str3, c7880To7);
        }
    }

    private void X2(C11458d25 c11458d25, String str, Long l, Long l2, final String str2, boolean z, boolean z2, boolean z3, C7880To7 c7880To7, InterfaceC15419jZ0 interfaceC15419jZ0, final String str3) throws IOException {
        if (str3 != null) {
            File file = new File(str3);
            if (file.exists()) {
                String name = file.getName();
                float fM2 = m2(file.length());
                if (!z3 && fM2 > this.a.S().h3()) {
                    interfaceC15419jZ0.onError(new FileSizeExceededException());
                    return;
                }
                if (z2 && fM2 > 65.0f) {
                    interfaceC15419jZ0.onError(new GifSizeExceededException());
                    return;
                }
                final C19247q16 c19247q16V = ((InterfaceC19086pl2) C92.a(this.b, InterfaceC19086pl2.class)).v();
                String str4 = (String) AbstractC24549yo1.b(new UA2() { // from class: ir.nasim.aq
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C11335cq.H2(c19247q16V, str3, str2, (InterfaceC20295rm1) obj);
                    }
                });
                if (str4 == null) {
                    str4 = "?/?";
                }
                String str5 = str4;
                if (!z || (!v2(str5) && (!x2(str5) || z2))) {
                    U2(c11458d25, str, l, l2, str3, str5, name, z2, z3, c7880To7);
                } else {
                    V2(c11458d25, str3, name, str, l, l2, str5, c7880To7);
                }
                interfaceC15419jZ0.a(Boolean.TRUE);
                return;
            }
        }
        interfaceC15419jZ0.onError(new IOException("Failed to read content of filePath: " + str3));
    }

    private void b3(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, boolean z, C7880To7 c7880To7) {
        try {
            C19406qI3.a("FiSeCoFl", "sendVideo()", new Object[0]);
            C22576vT7 c22576vT7F2 = f2(str);
            this.a.G().J2(c11458d25, str2, c22576vT7F2.a, c22576vT7F2.b, c22576vT7F2.c, new C22694vg2(c22576vT7F2.d.getWidth(), c22576vT7F2.d.getHeight(), V13.i(c22576vT7F2.d)), str, str3, l, l2, z, c7880To7);
        } catch (Throwable th) {
            C19406qI3.c("FiSeCoFl", "sendVideo: ", th);
            C19406qI3.c("AndroidMessenger", "sendVideo", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON") || w2()) {
            this.c.d(new ME.g());
            C19406qI3.b("baleMessages", "screen on");
            AbstractC7426Rr.R(true);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF") || !w2()) {
            this.c.d(new ME.f());
            C19406qI3.b("baleMessages", "screen off");
            AbstractC7426Rr.R(false);
        }
    }

    private int e2(String str, int i) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(this.b, Uri.parse(str));
                return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            } finally {
                mediaMetadataRetriever.release();
            }
        } catch (Exception e2) {
            C19406qI3.c("AndroidMessenger", "extractDuration failed", e2);
            return i;
        }
    }

    private C22576vT7 f2(String str) throws IllegalArgumentException {
        int width;
        int height;
        Bitmap bitmapO;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int i = (int) (Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000);
        if (Build.VERSION.SDK_INT >= 27) {
            int i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(24);
            int i4 = strExtractMetadata == null ? 0 : Integer.parseInt(strExtractMetadata);
            if (i4 == 90 || i4 == 270) {
                height = i2;
                width = i3;
            } else {
                width = i2;
                height = i3;
            }
            bitmapO = mediaMetadataRetriever.getScaledFrameAtTime(0L, 2, 30, 30);
        } else {
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            width = frameAtTime.getWidth();
            height = frameAtTime.getHeight();
            bitmapO = V13.o(frameAtTime, 30, 30);
        }
        return new C22576vT7(width, height, i, bitmapO);
    }

    private void f3(C19024pf0 c19024pf0, OP1 op1) {
        c19024pf0.B0(new e(op1));
    }

    private float m2(long j) {
        return Math.round((j / 1048576.0f) * 10.0f) / 10.0f;
    }

    private boolean t2(String str) {
        return str.startsWith("audio/");
    }

    private boolean u2(String str) {
        return str.startsWith("image/") && str.contains("gif");
    }

    private boolean v2(String str) {
        return str.startsWith("image/");
    }

    private boolean w2() {
        boolean z = false;
        for (Display display : ((DisplayManager) this.b.getSystemService("display")).getDisplays()) {
            if (display.getState() != 1) {
                z = true;
            }
        }
        return z;
    }

    private boolean x2(String str) {
        return str.startsWith("video/");
    }

    private boolean y2(String str) {
        return str.equals("audio/ogg") || str.equals("audio/opus");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ K6 z2() {
        return this.d;
    }

    public void N2() {
        this.c.d(new ME.d());
    }

    public void O2() {
        this.c.d(new ME.e());
    }

    public void P2(boolean z) {
        this.c.d(new ME.b(z));
    }

    public C6517Nv5 Q2(C11458d25 c11458d25, J44 j44, ArrayList arrayList, boolean z) {
        if (j44.L() == EnumC23558x74.PENDING) {
            return C6517Nv5.l0(new C4382Ew7(VF3.d, C6517Nv5.l0(C14505i18.a)));
        }
        this.a.G().N1(c11458d25, arrayList, Boolean.valueOf(z));
        return this.a.G().K1(c11458d25, j44, z);
    }

    public void S2() {
        this.a.m0();
    }

    public void T2() {
        if (C8386Vt0.X3()) {
            ((HS1) I22.a(C5721Ko.b, HS1.class)).n0().a(new XF2.b() { // from class: ir.nasim.Up
                @Override // ir.nasim.XF2.b
                public final void a(int i) {
                    C11335cq.A2(i);
                }
            }, new XF2.a() { // from class: ir.nasim.Vp
                @Override // ir.nasim.XF2.a
                public final void a(Throwable th) {
                    UO1.a.d("set ShortcutBadger failed!", th);
                }
            });
        } else {
            this.a.v().E().d().f(new InterfaceC14756iQ7() { // from class: ir.nasim.Wp
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    C11335cq.C2((Integer) obj, abstractC13554gQ7);
                }
            });
        }
        c2();
        R2(this.b);
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.Xp
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D2();
            }
        });
    }

    public C19024pf0 V1(C11458d25 c11458d25) {
        return this.a.C().C(c11458d25);
    }

    public void V2(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, String str4, C7880To7 c7880To7) {
        String str5;
        C19406qI3.a("FiSeCoFl", "sendDocument()", new Object[0]);
        if (str4 == null || str4.isEmpty()) {
            int iIndexOf = str2.indexOf(46);
            String mimeTypeFromExtension = iIndexOf >= 0 ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.substring(iIndexOf + 1)) : null;
            if (mimeTypeFromExtension == null) {
                mimeTypeFromExtension = "application/octet-stream";
            }
            str5 = mimeTypeFromExtension;
        } else {
            str5 = str4;
        }
        Bitmap bitmapE = V13.e(str);
        if (bitmapE == null) {
            this.a.G().u2(c11458d25, str2, str5, null, str, str3 != null ? str3 : "", l, l2, c7880To7);
        } else {
            Bitmap bitmapO = V13.o(bitmapE, 30, 30);
            this.a.G().u2(c11458d25, str2, str5, new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO)), str, str3 != null ? str3 : "", l, l2, c7880To7);
        }
    }

    public C19024pf0 W1() {
        return this.a.C().D();
    }

    public InterfaceC14830iZ0 W2(final C11458d25 c11458d25, final String str, final String str2, final Long l, final Long l2, final String str3, final boolean z, final boolean z2, final C7880To7 c7880To7) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Op
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.F2(str, str3, z, z2, c11458d25, str2, l, l2, c7880To7, interfaceC15419jZ0);
            }
        };
    }

    public C19024pf0 X1() {
        return (C19024pf0) this.a.C().E(false);
    }

    public C19024pf0 Y1() {
        return (C19024pf0) this.a.C().H(false);
    }

    public void Y2(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, String str4, C7880To7 c7880To7) {
        com.bumptech.glide.b.t(this.b).d().Z0(str).S0(new c(c11458d25, str2, str, str3, l, l2, str4, c7880To7)).f1();
    }

    public C19024pf0 Z1(C11458d25 c11458d25) {
        return (C19024pf0) this.a.C().J(c11458d25, false);
    }

    public void Z2(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, C7880To7 c7880To7) {
        try {
            C19406qI3.a("FiSeCoFl", "sendPhoto()", new Object[0]);
            Bitmap bitmapE = V13.e(str);
            if (bitmapE == null) {
                return;
            }
            Bitmap bitmapO = V13.o(bitmapE, 30, 30);
            String strM = C4053Dm2.m("jpg");
            if (strM == null) {
                return;
            }
            V13.f(bitmapE, strM);
            try {
                this.a.G().C2(c11458d25, str2, bitmapE.getWidth(), bitmapE.getHeight(), new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO)), strM, str3, l, l2, c7880To7);
            } catch (Throwable th) {
                th = th;
                C19406qI3.c("AndroidMessenger", "sendPhoto", th);
                C19406qI3.c("FiSeCoFl", "sendPhoto():", th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a2(String str) {
        o2().S().L(str);
    }

    public InterfaceC14830iZ0 a3(final C11458d25 c11458d25, final Uri uri, final String str, final Long l, final Long l2, final String str2, final boolean z, final boolean z2, final boolean z3, final C7880To7 c7880To7) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Zp
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.K2(uri, str2, z, z2, z3, c11458d25, str, l, l2, c7880To7, interfaceC15419jZ0);
            }
        };
    }

    public void b2(String str) {
        if (C5495Jo7.a.J2()) {
            this.a.S().N(str);
        } else {
            this.a.S().O(str);
        }
    }

    public EnumC19739qr4 c2() {
        EnumC19739qr4 enumC19739qr4;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
            if (C8386Vt0.o8()) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    enumC19739qr4 = networkCapabilities != null ? (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) ? EnumC19739qr4.WI_FI : networkCapabilities.hasTransport(0) ? EnumC19739qr4.MOBILE : EnumC19739qr4.UNKNOWN : EnumC19739qr4.UNKNOWN;
                } else {
                    enumC19739qr4 = EnumC19739qr4.NO_CONNECTION;
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (C4100Dr4.a(this.b)) {
                    int type = activeNetworkInfo.getType();
                    enumC19739qr4 = type != 0 ? (type == 1 || type == 6 || type == 9) ? EnumC19739qr4.WI_FI : EnumC19739qr4.UNKNOWN : EnumC19739qr4.MOBILE;
                } else {
                    enumC19739qr4 = EnumC19739qr4.NO_CONNECTION;
                }
            }
            C19406qI3.a("AndroidMessenger", "network state: " + enumC19739qr4, new Object[0]);
            this.a.b().f(enumC19739qr4);
            return enumC19739qr4;
        } catch (Exception e2) {
            EnumC19739qr4 enumC19739qr42 = EnumC19739qr4.UNKNOWN;
            this.a.b().f(enumC19739qr42);
            C19406qI3.b("AndroidMessenger", "Error in checkNetworkState: " + e2.getMessage());
            return enumC19739qr42;
        }
    }

    public void c3(C11458d25 c11458d25, String str, String str2, String str3, Long l, Long l2, String str4, C7880To7 c7880To7) {
        try {
            C19406qI3.a("FiSeCoFl", "sendVideoAsGif()", new Object[0]);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int i = (int) (Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            int width = frameAtTime.getWidth();
            int height = frameAtTime.getHeight();
            Bitmap bitmapO = V13.o(frameAtTime, 30, 30);
            A1(c11458d25, str2, width, height, i, new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO)), str, str3, l, l2, str4, c7880To7);
        } catch (Throwable th) {
            C19406qI3.c("FiSeCoFl", "sendVideoAsGif: ", th);
            C19406qI3.c("AndroidMessenger", "sendVideoAsGif", th);
        }
    }

    public InterfaceC14830iZ0 d3(final C11458d25 c11458d25, final long j, final Uri uri, final String str, final Long l, final String str2, final boolean z, final C7880To7 c7880To7) {
        return new InterfaceC14830iZ0() { // from class: ir.nasim.Rp
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.M2(str2, uri, z, c11458d25, j, str, l, c7880To7, interfaceC15419jZ0);
            }
        };
    }

    public void e3(C11458d25 c11458d25, int i, String str, Long l, Long l2, String str2, C7880To7 c7880To7) throws IOException {
        C19406qI3.a("FiSeCoFl", "sendVoice(duration: " + i + Separators.RPAREN, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("[sendVoice] file path is Empty!"));
            return;
        }
        this.a.G().K2(c11458d25, new File(str).getName(), e2(str, i), str, l, l2, str2, c7880To7);
    }

    public AnalysisData g2() {
        return o2().S().m0();
    }

    public AnalysisDialogData h2() {
        return o2().S().n0();
    }

    public ME i2() {
        return this.d;
    }

    public Context j2() {
        return this.b;
    }

    public C19024pf0 k2(OP1 op1) {
        BV1 bv1C;
        C9057Yh4 c9057Yh4 = this.a;
        if (c9057Yh4 == null || (bv1C = c9057Yh4.C()) == null) {
            return null;
        }
        int i = f.a[op1.ordinal()];
        C19024pf0 c19024pf0 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? (C19024pf0) bv1C.N() : (C19024pf0) bv1C.L() : (C19024pf0) bv1C.O() : (C19024pf0) bv1C.P() : (C19024pf0) bv1C.M();
        if (c19024pf0 == null) {
            return null;
        }
        f3(c19024pf0, op1);
        return c19024pf0;
    }

    public C6559Oa2 l2() {
        return this.a.a();
    }

    public String n2() {
        return this.a.S().C2();
    }

    public C9057Yh4 o2() {
        return this.a;
    }

    public int p2() {
        return this.a.S().r3();
    }

    public C19024pf0 q2(C11458d25 c11458d25, Long l, Long l2) {
        C19024pf0 c19024pf0 = (C19024pf0) this.a.C().I();
        c19024pf0.B0(new d(c11458d25, l, l2));
        return c19024pf0;
    }

    public String r2() {
        return C5495Jo7.a.J2() ? this.a.S().F1() : this.a.S().Q2();
    }

    public boolean s2() {
        return this.a.S().S7();
    }

    /* renamed from: ir.nasim.cq$d */
    class d implements C19024pf0.b {
        final /* synthetic */ C11458d25 a;
        final /* synthetic */ Long b;
        final /* synthetic */ Long c;

        d(C11458d25 c11458d25, Long l, Long l2) {
            this.a = c11458d25;
            this.b = l;
            this.c = l2;
        }

        @Override // ir.nasim.C19024pf0.b
        public void b() {
            C11335cq.this.a.y().p2(this.a, this.b.longValue(), this.c.longValue());
        }

        @Override // ir.nasim.C19024pf0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(P15 p15, int i) {
        }
    }

    /* renamed from: ir.nasim.cq$e */
    class e implements C19024pf0.b {
        final /* synthetic */ OP1 a;

        e(OP1 op1) {
            this.a = op1;
        }

        @Override // ir.nasim.C19024pf0.b
        public void b() {
            C11335cq.this.a.G().L1(this.a);
        }

        @Override // ir.nasim.C19024pf0.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C17067mL1 c17067mL1, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object G2(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return str;
    }
}
