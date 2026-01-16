package ir.nasim;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC21332tU1;
import ir.nasim.InterfaceC22734vk2;
import java.io.IOException;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* renamed from: ir.nasim.qZ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19558qZ2 implements InterfaceC22734vk2 {
    public static final a f = new a(null);
    private static final CacheControl g = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl h = new CacheControl.Builder().noCache().onlyIfCached().build();
    private final String a;
    private final IL4 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final boolean e;

    /* renamed from: ir.nasim.qZ2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qZ2$b */
    public static final class b implements InterfaceC22734vk2.a {
        private final InterfaceC9173Yu3 a;
        private final InterfaceC9173Yu3 b;
        private final boolean c;

        public b(InterfaceC9173Yu3 interfaceC9173Yu3, InterfaceC9173Yu3 interfaceC9173Yu32, boolean z) {
            this.a = interfaceC9173Yu3;
            this.b = interfaceC9173Yu32;
            this.c = z;
        }

        private final boolean c(Uri uri) {
            return AbstractC13042fc3.d(uri.getScheme(), "http") || AbstractC13042fc3.d(uri.getScheme(), "https");
        }

        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(Uri uri, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (c(uri)) {
                return new C19558qZ2(uri.toString(), il4, this.a, this.b, this.c);
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.qZ2$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C19558qZ2.this.c(null, this);
        }
    }

    /* renamed from: ir.nasim.qZ2$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C19558qZ2.this.a(this);
        }
    }

    public C19558qZ2(String str, IL4 il4, InterfaceC9173Yu3 interfaceC9173Yu3, InterfaceC9173Yu3 interfaceC9173Yu32, boolean z) {
        this.a = str;
        this.b = il4;
        this.c = interfaceC9173Yu3;
        this.d = interfaceC9173Yu32;
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(okhttp3.Request r5, ir.nasim.InterfaceC20295rm1 r6) throws java.io.IOException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C19558qZ2.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.qZ2$c r0 = (ir.nasim.C19558qZ2.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.qZ2$c r0 = new ir.nasim.qZ2$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L72
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            boolean r6 = ir.nasim.AbstractC18638p.r()
            if (r6 == 0) goto L5d
            ir.nasim.IL4 r6 = r4.b
            ir.nasim.lp0 r6 = r6.k()
            boolean r6 = r6.j()
            if (r6 != 0) goto L57
            ir.nasim.Yu3 r6 = r4.c
            java.lang.Object r6 = r6.getValue()
            okhttp3.Call$Factory r6 = (okhttp3.Call.Factory) r6
            okhttp3.Call r5 = r6.newCall(r5)
            okhttp3.Response r5 = r5.execute()
            goto L75
        L57:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L5d:
            ir.nasim.Yu3 r6 = r4.c
            java.lang.Object r6 = r6.getValue()
            okhttp3.Call$Factory r6 = (okhttp3.Call.Factory) r6
            okhttp3.Call r5 = r6.newCall(r5)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC11431d.a(r5, r0)
            if (r6 != r1) goto L72
            return r1
        L72:
            r5 = r6
            okhttp3.Response r5 = (okhttp3.Response) r5
        L75:
            boolean r6 = r5.isSuccessful()
            if (r6 != 0) goto L92
            int r6 = r5.code()
            r0 = 304(0x130, float:4.26E-43)
            if (r6 == r0) goto L92
            okhttp3.ResponseBody r6 = r5.body()
            if (r6 == 0) goto L8c
            ir.nasim.AbstractC18638p.d(r6)
        L8c:
            coil.network.HttpException r6 = new coil.network.HttpException
            r6.<init>(r5)
            throw r6
        L92:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19558qZ2.c(okhttp3.Request, ir.nasim.rm1):java.lang.Object");
    }

    private final String d() {
        String strH = this.b.h();
        return strH == null ? this.a : strH;
    }

    private final FileSystem e() {
        Object value = this.d.getValue();
        AbstractC13042fc3.f(value);
        return ((InterfaceC21332tU1) value).c();
    }

    private final boolean g(Request request, Response response) {
        return this.b.i().p() && (!this.e || C19124pp0.c.c(request, response));
    }

    private final Request h() {
        Request.Builder builderHeaders = new Request.Builder().url(this.a).headers(this.b.j());
        for (Map.Entry entry : this.b.p().a().entrySet()) {
            Object key = entry.getKey();
            AbstractC13042fc3.g(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderHeaders.tag((Class) key, entry.getValue());
        }
        boolean zJ = this.b.i().j();
        boolean zJ2 = this.b.k().j();
        if (!zJ2 && zJ) {
            builderHeaders.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!zJ2 || zJ) {
            if (!zJ2 && !zJ) {
                builderHeaders.cacheControl(h);
            }
        } else if (this.b.i().p()) {
            builderHeaders.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            builderHeaders.cacheControl(g);
        }
        return builderHeaders.build();
    }

    private final InterfaceC21332tU1.c i() {
        InterfaceC21332tU1 interfaceC21332tU1;
        if (!this.b.i().j() || (interfaceC21332tU1 = (InterfaceC21332tU1) this.d.getValue()) == null) {
            return null;
        }
        return interfaceC21332tU1.b(d());
    }

    private final C17351mp0 j(InterfaceC21332tU1.c cVar) throws Throwable {
        Throwable th;
        C17351mp0 c17351mp0;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(e().source(cVar.o()));
            try {
                c17351mp0 = new C17351mp0(bufferedSourceBuffer);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        AbstractC16632lc2.a(th3, th4);
                    }
                }
                th = th3;
                c17351mp0 = null;
            }
            if (th != null) {
                throw th;
            }
            AbstractC13042fc3.f(c17351mp0);
            return c17351mp0;
        } catch (IOException unused) {
            return null;
        }
    }

    private final EnumC21699tz1 k(Response response) {
        return response.networkResponse() != null ? EnumC21699tz1.d : EnumC21699tz1.c;
    }

    private final AbstractC10086b33 l(InterfaceC21332tU1.c cVar) {
        return AbstractC11466d33.c(cVar.getData(), e(), d(), cVar);
    }

    private final AbstractC10086b33 m(ResponseBody responseBody) {
        return AbstractC11466d33.a(responseBody.getBodySource(), this.b.g());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2 A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_LEAVE, TryCatch #10 {Exception -> 0x0081, blocks: (B:15:0x002b, B:18:0x0036, B:37:0x0089, B:71:0x0103, B:38:0x008e, B:30:0x007a, B:39:0x008f, B:55:0x00c2, B:70:0x0100, B:74:0x010b, B:67:0x00f8, B:75:0x010c, B:52:0x00bb), top: B:99:0x002b, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010c A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_LEAVE, TryCatch #10 {Exception -> 0x0081, blocks: (B:15:0x002b, B:18:0x0036, B:37:0x0089, B:71:0x0103, B:38:0x008e, B:30:0x007a, B:39:0x008f, B:55:0x00c2, B:70:0x0100, B:74:0x010b, B:67:0x00f8, B:75:0x010c, B:52:0x00bb), top: B:99:0x002b, outer: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.InterfaceC21332tU1.c n(ir.nasim.InterfaceC21332tU1.c r6, okhttp3.Request r7, okhttp3.Response r8, ir.nasim.C17351mp0 r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19558qZ2.n(ir.nasim.tU1$c, okhttp3.Request, okhttp3.Response, ir.nasim.mp0):ir.nasim.tU1$c");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x012c A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:72:0x0188, B:54:0x011e, B:56:0x012c, B:58:0x013a, B:61:0x0143, B:63:0x014d, B:65:0x0155, B:67:0x016d), top: B:81:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:72:0x0188, B:54:0x011e, B:56:0x012c, B:58:0x013a, B:61:0x0143, B:63:0x014d, B:65:0x0155, B:67:0x016d), top: B:81:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22734vk2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19558qZ2.a(ir.nasim.rm1):java.lang.Object");
    }

    public final String f(String str, MediaType mediaType) {
        String strK;
        String mediaType2 = mediaType != null ? mediaType.getMediaType() : null;
        if ((mediaType2 == null || AbstractC20153rZ6.S(mediaType2, "text/plain", false, 2, null)) && (strK = AbstractC18638p.k(MimeTypeMap.getSingleton(), str)) != null) {
            return strK;
        }
        if (mediaType2 != null) {
            return AbstractC20762sZ6.g1(mediaType2, ';', null, 2, null);
        }
        return null;
    }
}
