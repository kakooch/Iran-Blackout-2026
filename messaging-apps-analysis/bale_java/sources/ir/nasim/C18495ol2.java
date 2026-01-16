package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.core.modules.file.entity.FileReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: ir.nasim.ol2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18495ol2 implements ZY1 {
    public static final a E = new a(null);
    public static final int F = 8;
    private static String G = "Downloading_Parts_";
    private final InterfaceC14371ho1 A;
    private final InterfaceC20315ro1 B;
    private final InterfaceC3570Bk5 C;
    private final Object D;
    private final FileReference a;
    private final C9528a7 b;
    private final C9057Yh4 c;
    private final OkHttpClient d;
    private final InterfaceC12532em2 e;
    private final String f;
    private final boolean g;
    private InterfaceC3346Am2 h;
    private DN4 i;
    private long j;
    private float k;
    private InterfaceC13730gj3 l;
    private int m;
    private int n;
    private int o;
    private int p;
    private String q;
    private volatile int r;
    private volatile boolean s;
    private volatile boolean t;
    private final ArrayList u;
    private final String v;
    private String w;
    private TreeSet x;
    private TreeSet y;
    private final HashMap z;

    /* renamed from: ir.nasim.ol2$a */
    public static final class a {
        private a() {
        }

        public final String a() {
            return C18495ol2.G;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ol2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ Runnable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, Runnable runnable, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = runnable;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = this.c;
                if (j > 0) {
                    this.b = 1;
                    if (HG1.b(j, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.d.run();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ol2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18495ol2.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC12532em2 interfaceC12532em2 = C18495ol2.this.e;
                long fileId = C18495ol2.this.y().getFileId();
                long accessHash = C18495ol2.this.y().getAccessHash();
                this.b = 1;
                obj = interfaceC12532em2.c(fileId, accessHash, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            String str = (String) obj;
            if (str != null) {
                C19406qI3.a(C18495ol2.this.f, "requestUrl: received", new Object[0]);
                C18495ol2.this.q = str;
                C18495ol2.this.L();
            } else {
                C18495ol2.this.F(new Exception("Unable to get Url"));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ol2$d */
    public static final class d extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ C18495ol2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC14371ho1.a aVar, C18495ol2 c18495ol2) {
            super(aVar);
            this.b = c18495ol2;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            if (th instanceof IOException) {
                C19406qI3.b(this.b.f, "Caught IOException: " + th + ".\n" + AbstractC20507s76.q(((IOException) th).getStackTrace()));
                this.b.F((Exception) th);
                return;
            }
            if (th instanceof Exception) {
                C19406qI3.b(this.b.f, "Caught Exception: " + th + ".\n" + AbstractC20507s76.q(((Exception) th).getStackTrace()));
            }
        }
    }

    public C18495ol2(FileReference fileReference, C9528a7 c9528a7, C9057Yh4 c9057Yh4, OkHttpClient okHttpClient, InterfaceC12532em2 interfaceC12532em2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(c9528a7, "manager");
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(okHttpClient, "httpClient");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        this.a = fileReference;
        this.b = c9528a7;
        this.c = c9057Yh4;
        this.d = okHttpClient;
        this.e = interfaceC12532em2;
        this.f = "DownloadTask{" + fileReference.getFileId() + "}";
        this.g = true;
        this.m = 131072;
        this.n = 32768;
        this.u = new ArrayList();
        this.x = new TreeSet();
        this.y = new TreeSet();
        this.z = new HashMap();
        d dVar = new d(InterfaceC14371ho1.h0, this);
        this.A = dVar;
        this.B = AbstractC20906so1.a(C12366eV1.b().X(P17.b(null, 1, null)).X(dVar));
        this.C = C7183Qq.q(EnumC18608ow5.i);
        this.D = new Object();
        this.n = c9057Yh4.S().getInt("app.android.download.small_chunk_size", 32768);
        this.m = c9057Yh4.S().getInt("app.android.download.big_chunk_size", 131072);
        this.v = G + fileReference.getFileId() + "_" + fileReference.getAccessHash();
    }

    private final boolean A(Response response) {
        int iCode = response.code();
        return (500 <= iCode && iCode < 600) || response.code() == 0;
    }

    private final void B() {
        if (this.t) {
            return;
        }
        this.b.d(new C12870fJ4(this.a.getFileId(), this.k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        q();
        String str = this.w;
        if (str != null) {
            this.h = KN6.r(str);
        }
        InterfaceC3346Am2 interfaceC3346Am2 = null;
        if (this.w == null || this.h == null) {
            InterfaceC3346Am2 interfaceC3346Am2P = KN6.p();
            this.h = interfaceC3346Am2P;
            if (interfaceC3346Am2P == null) {
                AbstractC13042fc3.y("destReference");
                interfaceC3346Am2P = null;
            }
            this.w = interfaceC3346Am2P.getDescriptor();
            D();
        }
        if (this.h == null) {
            F(new Exception("Unable to create reference"));
            return;
        }
        this.o = this.a.getFileSize() > 10485760 ? this.m : this.n;
        this.p = this.a.getFileSize() / this.o;
        if (this.a.getFileSize() % this.o != 0) {
            this.p++;
        }
        InterfaceC3346Am2 interfaceC3346Am22 = this.h;
        if (interfaceC3346Am22 == null) {
            AbstractC13042fc3.y("destReference");
        } else {
            interfaceC3346Am2 = interfaceC3346Am22;
        }
        this.i = interfaceC3346Am2.b(this.a.getFileSize());
        G(((this.r - this.x.size()) - this.y.size()) / this.p);
        I();
    }

    private final void D() {
        this.C.remove(this.v + "_Is_it");
        this.C.remove(this.v + "_data");
        this.C.remove(this.v + "_tempDesc");
        this.C.remove(this.v + "_max_loaded_in_queue");
    }

    private final void E(InterfaceC3346Am2 interfaceC3346Am2) {
        if (this.g) {
            C19406qI3.a(this.f, "Report file #" + this.a.getFileId() + " download completed. FileSize=" + interfaceC3346Am2.f(), new Object[0]);
        }
        if (this.t) {
            return;
        }
        this.t = true;
        K();
        this.b.d(new C13488gJ4(this.a.getFileId(), interfaceC3346Am2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(Exception exc) {
        if (this.t) {
            return;
        }
        this.t = true;
        this.b.d(new C14079hJ4(this.a.getFileId(), exc));
    }

    private final void G(float f) {
        if (this.t) {
            return;
        }
        if (f > this.k) {
            this.k = f;
        }
        long jM = AbstractC20507s76.m() - this.j;
        InterfaceC13730gj3 interfaceC13730gj3 = this.l;
        if (interfaceC13730gj3 != null) {
            AbstractC13042fc3.f(interfaceC13730gj3);
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            this.l = null;
        }
        if (jM <= 200) {
            this.l = s(new Runnable() { // from class: ir.nasim.il2
                @Override // java.lang.Runnable
                public final void run() {
                    C18495ol2.H(this.a);
                }
            }, jM);
        } else {
            this.j = AbstractC20507s76.m();
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(C18495ol2 c18495ol2) {
        AbstractC13042fc3.i(c18495ol2, "this$0");
        c18495ol2.B();
    }

    private final void I() {
        if (this.g) {
            C19406qI3.a(this.f, "requestUrl", new Object[0]);
        }
        AbstractC10533bm0.d(this.B, null, null, new c(null), 3, null);
    }

    private final void J(int i, int i2) {
        if (this.s || this.t) {
            return;
        }
        if (i2 > 5) {
            F(new Exception("Reached max attempts for chunk #" + i));
            return;
        }
        synchronized (this.D) {
            try {
                this.z.put(Integer.valueOf(i), Integer.valueOf(i2));
                if (this.g) {
                    C19406qI3.a(this.f, "Trying again chunk #" + i + " download", new Object[0]);
                }
                this.x.add(Integer.valueOf(i));
                this.y.remove(Integer.valueOf(i));
            } catch (Throwable th) {
                throw th;
            }
        }
        t(this, new RunnableC15540jl2(this), 0L, 2, null);
    }

    private final void K() {
        if (this.s) {
            return;
        }
        if (this.t) {
            D();
            return;
        }
        synchronized (this.D) {
            TreeSet treeSet = new TreeSet((SortedSet) this.x);
            treeSet.addAll(this.y);
            byte[] bArrB = NW0.a.b(treeSet);
            this.C.f(this.v + "_data", bArrB);
            this.C.putInt(this.v + "_max_loaded_in_queue", this.r);
            this.C.g(this.v + "_Is_it", true);
            this.C.putString(this.v + "_tempDesc", this.w);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        if (this.g) {
            C19406qI3.a(this.f, "Starting downloading " + this.p + " chunks", new Object[0]);
        }
        t(this, new RunnableC15540jl2(this), 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        synchronized (this.D) {
            try {
                if (!this.s && !this.t) {
                    if (this.g) {
                        C19406qI3.a(this.f, "CheckQueue maxLoadedInQueue=" + this.r + ", chunksCount=" + this.p + ", queue.size=" + this.x.size() + ", currentDownloads=" + this.y.size(), new Object[0]);
                    }
                    if (z()) {
                        r();
                        return;
                    }
                    if (this.r < this.p) {
                        int i = this.r;
                        int size = this.x.size();
                        while (i < (this.r + 100) - size && i < this.p) {
                            this.x.add(Integer.valueOf(i));
                            i++;
                            this.r = i;
                        }
                    }
                    if ((!this.x.isEmpty()) && this.y.size() < 16) {
                        Integer num = (Integer) this.x.pollFirst();
                        if (num != null) {
                            this.y.add(Integer.valueOf(num.intValue()));
                        }
                        if (num != null) {
                            final int iIntValue = num.intValue();
                            t(this, new Runnable() { // from class: ir.nasim.kl2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C18495ol2.p(this.a, iIntValue);
                                }
                            }, 0L, 2, null);
                        }
                        t(this, new RunnableC15540jl2(this), 0L, 2, null);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(C18495ol2 c18495ol2, int i) {
        AbstractC13042fc3.i(c18495ol2, "this$0");
        c18495ol2.u(i);
    }

    private final void q() {
        if (this.C.h(this.v + "_Is_it", false)) {
            this.w = this.C.e(this.v + "_tempDesc");
            this.r = this.C.getInt(this.v + "_max_loaded_in_queue", 0);
            NW0 nw0 = NW0.a;
            byte[] bArrB = this.C.b(this.v + "_data");
            AbstractC13042fc3.h(bArrB, "getBytes(...)");
            nw0.a(bArrB, this.x);
        }
    }

    private final void r() {
        if (this.t) {
            return;
        }
        synchronized (this.D) {
            try {
                if (this.t) {
                    return;
                }
                DN4 dn4 = this.i;
                InterfaceC3346Am2 interfaceC3346Am2 = null;
                if (dn4 == null) {
                    AbstractC13042fc3.y("outputFile");
                    dn4 = null;
                }
                if (!dn4.close()) {
                    F(new Exception("Unable to close output file"));
                    return;
                }
                InterfaceC3346Am2 interfaceC3346Am22 = this.h;
                if (interfaceC3346Am22 == null) {
                    AbstractC13042fc3.y("destReference");
                    interfaceC3346Am22 = null;
                }
                if (interfaceC3346Am22.f() == this.a.getFileSize()) {
                    InterfaceC3346Am2 interfaceC3346Am23 = this.h;
                    if (interfaceC3346Am23 == null) {
                        AbstractC13042fc3.y("destReference");
                    } else {
                        interfaceC3346Am2 = interfaceC3346Am23;
                    }
                    InterfaceC3346Am2 interfaceC3346Am2C = KN6.c(interfaceC3346Am2, this.a.getFileId(), this.a.getFileName());
                    if (interfaceC3346Am2C == null) {
                        F(new Exception("Unable to commit temp file"));
                        return;
                    } else {
                        E(interfaceC3346Am2C);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                        return;
                    }
                }
                InterfaceC3346Am2 interfaceC3346Am24 = this.h;
                if (interfaceC3346Am24 == null) {
                    AbstractC13042fc3.y("destReference");
                    interfaceC3346Am24 = null;
                }
                Exception exc = new Exception("Length of download content doesn't match the file reference size. (downloaded: " + interfaceC3346Am24.f() + " != expected: " + this.a.getFileSize() + Separators.RPAREN);
                InterfaceC3346Am2 interfaceC3346Am25 = this.h;
                if (interfaceC3346Am25 == null) {
                    AbstractC13042fc3.y("destReference");
                } else {
                    interfaceC3346Am2 = interfaceC3346Am25;
                }
                File file = new File(interfaceC3346Am2.getDescriptor());
                if (file.exists()) {
                    file.delete();
                }
                D();
                F(exc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final InterfaceC13730gj3 s(Runnable runnable, long j) {
        return AbstractC10533bm0.d(this.B, null, null, new b(j, runnable, null), 3, null);
    }

    static /* synthetic */ InterfaceC13730gj3 t(C18495ol2 c18495ol2, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return c18495ol2.s(runnable, j);
    }

    private final void u(final int i) {
        if (this.g) {
            C19406qI3.a(this.f, "Starting chunk #" + i + " download", new Object[0]);
        }
        int i2 = this.o;
        int i3 = i * i2;
        int fileSize = i2 * (i + 1) > this.a.getFileSize() ? this.a.getFileSize() - 1 : (r3 * this.o) - 1;
        Object obj = this.z.get(Integer.valueOf(i));
        if (obj == null) {
            obj = 0;
        }
        final int iIntValue = ((Number) obj).intValue();
        Request.Builder builder = new Request.Builder();
        String str = this.q;
        AbstractC13042fc3.f(str);
        Call callNewCall = this.d.newCall(builder.url(str).addHeader("Range", "bytes=" + i3 + "-" + fileSize).build());
        synchronized (this.D) {
            this.u.add(callNewCall);
        }
        try {
            Response responseExecute = callNewCall.execute();
            if (this.s) {
                ResponseBody responseBodyBody = responseExecute.body();
                if (responseBodyBody != null) {
                    responseBodyBody.close();
                    return;
                }
                return;
            }
            if (responseExecute.isSuccessful()) {
                ResponseBody responseBodyBody2 = responseExecute.body();
                AbstractC13042fc3.f(responseBodyBody2);
                byte[] bArrBytes = responseBodyBody2.bytes();
                if (this.s) {
                    ResponseBody responseBodyBody3 = responseExecute.body();
                    if (responseBodyBody3 != null) {
                        responseBodyBody3.close();
                        return;
                    }
                    return;
                }
                if (bArrBytes.length != (fileSize - i3) + 1) {
                    if (this.g) {
                        C19406qI3.j(this.f, "Download chunk #" + i + " failed cause the content-length(" + bArrBytes.length + ") is not match the requested ranges(" + i3 + "-" + fileSize + ") trying again in 2 sec, attempt #" + (iIntValue + 1), new Object[0]);
                    }
                    s(new Runnable() { // from class: ir.nasim.ll2
                        @Override // java.lang.Runnable
                        public final void run() {
                            C18495ol2.v(this.a, i, iIntValue);
                        }
                    }, ((i % 16) + 2) * 200);
                    ResponseBody responseBodyBody4 = responseExecute.body();
                    if (responseBodyBody4 != null) {
                        responseBodyBody4.close();
                        return;
                    }
                    return;
                }
                if (this.g) {
                    C19406qI3.a(this.f, "Download chunk #" + i + " finished. Content length: " + bArrBytes.length, new Object[0]);
                }
                synchronized (this.D) {
                    try {
                        DN4 dn4 = this.i;
                        if (dn4 == null) {
                            AbstractC13042fc3.y("outputFile");
                            dn4 = null;
                        }
                        if (!dn4.a(i3, bArrBytes, 0, bArrBytes.length)) {
                            F(new Exception("Unable to persist chunk #" + i));
                            return;
                        }
                        this.z.remove(Integer.valueOf(i));
                        this.y.remove(Integer.valueOf(i));
                        G(((this.r - this.x.size()) - this.y.size()) / this.p);
                        K();
                        C19938rB7 c19938rB7 = C19938rB7.a;
                        if (this.g) {
                            C19406qI3.a(this.f, "Chunk #" + i + " persisted", new Object[0]);
                        }
                        t(this, new RunnableC15540jl2(this), 0L, 2, null);
                    } finally {
                    }
                }
            } else if (A(responseExecute)) {
                if (this.g) {
                    C19406qI3.j(this.f, "Download chunk #" + i + " failed with internal error (" + responseExecute.code() + ") trying again in 2 sec, attempt #" + (iIntValue + 1), new Object[0]);
                }
                s(new Runnable() { // from class: ir.nasim.ml2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C18495ol2.w(this.a, i, iIntValue);
                    }
                }, ((i % 16) + 2) * 200);
            } else {
                F(new Exception("Download chunk #" + i + " failed with error (" + responseExecute.code() + Separators.RPAREN));
                C19938rB7 c19938rB72 = C19938rB7.a;
            }
            ResponseBody responseBodyBody5 = responseExecute.body();
            if (responseBodyBody5 != null) {
                responseBodyBody5.close();
            }
        } catch (IOException e) {
            if (this.g) {
                C19406qI3.a(this.f, "Download chunk #" + i + " crashed with io exception (" + e.getMessage() + Separators.RPAREN, new Object[0]);
            }
            s(new Runnable() { // from class: ir.nasim.nl2
                @Override // java.lang.Runnable
                public final void run() {
                    C18495ol2.x(this.a, i, iIntValue);
                }
            }, ((i % 16) + 2) * 200);
        } catch (Exception e2) {
            F(new Exception("Download chunk #" + i + " crashed with exception (" + e2.getMessage() + Separators.RPAREN));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(C18495ol2 c18495ol2, int i, int i2) {
        AbstractC13042fc3.i(c18495ol2, "this$0");
        c18495ol2.J(i, i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(C18495ol2 c18495ol2, int i, int i2) {
        AbstractC13042fc3.i(c18495ol2, "this$0");
        c18495ol2.J(i, i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(C18495ol2 c18495ol2, int i, int i2) {
        AbstractC13042fc3.i(c18495ol2, "this$0");
        c18495ol2.J(i, i2 + 1);
    }

    private final boolean z() {
        return this.r == this.p && this.x.isEmpty() && this.y.isEmpty();
    }

    @Override // ir.nasim.ZY1
    public void cancel() {
        this.s = true;
        synchronized (this.D) {
            try {
                K();
                Iterator it = this.u.iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    Call call = (Call) it.next();
                    if (call != null) {
                        call.cancel();
                    }
                }
                this.u.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Float n() {
        if (!this.C.h(this.v + "_Is_it", false)) {
            return null;
        }
        String strE = this.C.e(this.v + "_tempDesc");
        this.w = strE;
        if (strE == null) {
            return null;
        }
        InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(strE);
        this.h = interfaceC3346Am2R;
        if (interfaceC3346Am2R == null) {
            return null;
        }
        this.r = this.C.getInt(this.v + "_max_loaded_in_queue", 0);
        this.o = this.a.getFileSize() > 10485760 ? this.m : this.n;
        this.p = this.a.getFileSize() / this.o;
        if (this.a.getFileSize() % this.o != 0) {
            this.p++;
        }
        NW0 nw0 = NW0.a;
        byte[] bArrB = this.C.b(this.v + "_data");
        AbstractC13042fc3.h(bArrB, "getBytes(...)");
        nw0.a(bArrB, this.x);
        if (this.p <= 0) {
            return null;
        }
        return Float.valueOf(((this.r - this.x.size()) - this.y.size()) / this.p);
    }

    @Override // ir.nasim.ZY1
    public void start() {
        t(this, new Runnable() { // from class: ir.nasim.hl2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C();
            }
        }, 0L, 2, null);
    }

    public final FileReference y() {
        return this.a;
    }
}
