package ir.nasim;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import okio.BufferedSink;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

/* renamed from: ir.nasim.zU1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24949zU1 implements Closeable, Flushable {
    public static final a s = new a(null);
    private static final C20644sM5 t = new C20644sM5("[a-z0-9_-]{1,120}");
    private final Path a;
    private final long b;
    private final int c;
    private final int d;
    private final Path e;
    private final Path f;
    private final Path g;
    private final LinkedHashMap h;
    private final InterfaceC20315ro1 i;
    private long j;
    private int k;
    private BufferedSink l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private final e r;

    /* renamed from: ir.nasim.zU1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zU1$b */
    public final class b {
        private final c a;
        private boolean b;
        private final boolean[] c;

        public b(c cVar) {
            this.a = cVar;
            this.c = new boolean[C24949zU1.this.d];
        }

        private final void d(boolean z) {
            C24949zU1 c24949zU1 = C24949zU1.this;
            synchronized (c24949zU1) {
                try {
                    if (!(!this.b)) {
                        throw new IllegalStateException("editor is closed".toString());
                    }
                    if (AbstractC13042fc3.d(this.a.b(), this)) {
                        c24949zU1.y(this, z);
                    }
                    this.b = true;
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void a() {
            d(false);
        }

        public final void b() {
            d(true);
        }

        public final d c() {
            d dVarH;
            C24949zU1 c24949zU1 = C24949zU1.this;
            synchronized (c24949zU1) {
                b();
                dVarH = c24949zU1.H(this.a.d());
            }
            return dVarH;
        }

        public final void e() {
            if (AbstractC13042fc3.d(this.a.b(), this)) {
                this.a.m(true);
            }
        }

        public final Path f(int i) {
            Path path;
            C24949zU1 c24949zU1 = C24949zU1.this;
            synchronized (c24949zU1) {
                if (!(!this.b)) {
                    throw new IllegalStateException("editor is closed".toString());
                }
                this.c[i] = true;
                Object obj = this.a.c().get(i);
                AbstractC13892h.a(c24949zU1.r, (Path) obj);
                path = (Path) obj;
            }
            return path;
        }

        public final c g() {
            return this.a;
        }

        public final boolean[] h() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.zU1$c */
    public final class c {
        private final String a;
        private final long[] b;
        private final ArrayList c;
        private final ArrayList d;
        private boolean e;
        private boolean f;
        private b g;
        private int h;

        public c(String str) {
            this.a = str;
            this.b = new long[C24949zU1.this.d];
            this.c = new ArrayList(C24949zU1.this.d);
            this.d = new ArrayList(C24949zU1.this.d);
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int i = C24949zU1.this.d;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(i2);
                this.c.add(C24949zU1.this.a.resolve(sb.toString()));
                sb.append(".tmp");
                this.d.add(C24949zU1.this.a.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final ArrayList a() {
            return this.c;
        }

        public final b b() {
            return this.g;
        }

        public final ArrayList c() {
            return this.d;
        }

        public final String d() {
            return this.a;
        }

        public final long[] e() {
            return this.b;
        }

        public final int f() {
            return this.h;
        }

        public final boolean g() {
            return this.e;
        }

        public final boolean h() {
            return this.f;
        }

        public final void i(b bVar) {
            this.g = bVar;
        }

        public final void j(List list) throws IOException {
            if (list.size() != C24949zU1.this.d) {
                throw new IOException("unexpected journal line: " + list);
            }
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.b[i] = Long.parseLong((String) list.get(i));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void k(int i) {
            this.h = i;
        }

        public final void l(boolean z) {
            this.e = z;
        }

        public final void m(boolean z) {
            this.f = z;
        }

        public final d n() {
            if (!this.e || this.g != null || this.f) {
                return null;
            }
            ArrayList arrayList = this.c;
            C24949zU1 c24949zU1 = C24949zU1.this;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!c24949zU1.r.exists((Path) arrayList.get(i))) {
                    try {
                        c24949zU1.X(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.h++;
            return C24949zU1.this.new d(this);
        }

        public final void o(BufferedSink bufferedSink) {
            for (long j : this.b) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    /* renamed from: ir.nasim.zU1$d */
    public final class d implements Closeable {
        private final c a;
        private boolean b;

        public d(c cVar) {
            this.a = cVar;
        }

        public final b a() {
            b bVarG;
            C24949zU1 c24949zU1 = C24949zU1.this;
            synchronized (c24949zU1) {
                close();
                bVarG = c24949zU1.G(this.a.d());
            }
            return bVarG;
        }

        public final Path b(int i) {
            if (!this.b) {
                return (Path) this.a.a().get(i);
            }
            throw new IllegalStateException("snapshot is closed".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            C24949zU1 c24949zU1 = C24949zU1.this;
            synchronized (c24949zU1) {
                try {
                    this.a.k(r1.f() - 1);
                    if (this.a.f() == 0 && this.a.h()) {
                        c24949zU1.X(this.a);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: ir.nasim.zU1$e */
    public static final class e extends ForwardingFileSystem {
        e(FileSystem fileSystem) {
            super(fileSystem);
        }

        @Override // okio.ForwardingFileSystem, okio.FileSystem
        public Sink sink(Path path, boolean z) {
            Path pathParent = path.parent();
            if (pathParent != null) {
                createDirectories(pathParent);
            }
            return super.sink(path, z);
        }
    }

    /* renamed from: ir.nasim.zU1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24949zU1.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C24949zU1 c24949zU1 = C24949zU1.this;
            synchronized (c24949zU1) {
                if (!c24949zU1.n || c24949zU1.o) {
                    return C19938rB7.a;
                }
                try {
                    c24949zU1.d0();
                } catch (IOException unused) {
                    c24949zU1.p = true;
                }
                try {
                    if (c24949zU1.K()) {
                        c24949zU1.f0();
                    }
                } catch (IOException unused2) {
                    c24949zU1.q = true;
                    c24949zU1.l = Okio.buffer(Okio.blackhole());
                }
                return C19938rB7.a;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zU1$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IOException) obj);
            return C19938rB7.a;
        }

        public final void invoke(IOException iOException) {
            C24949zU1.this.m = true;
        }
    }

    public C24949zU1(FileSystem fileSystem, Path path, AbstractC13778go1 abstractC13778go1, long j, int i, int i2) {
        this.a = path;
        this.b = j;
        this.c = i;
        this.d = i2;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.e = path.resolve("journal");
        this.f = path.resolve("journal.tmp");
        this.g = path.resolve("journal.bkp");
        this.h = new LinkedHashMap(0, 0.75f, true);
        this.i = AbstractC20906so1.a(P17.b(null, 1, null).X(abstractC13778go1.B0(1)));
        this.r = new e(fileSystem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K() {
        return this.k >= 2000;
    }

    private final void M() {
        AbstractC10533bm0.d(this.i, null, null, new f(null), 3, null);
    }

    private final BufferedSink P() {
        return Okio.buffer(new C3765Cg2(this.r.appendingSink(this.e), new g()));
    }

    private final void S() {
        Iterator it = this.h.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int i = 0;
            if (cVar.b() == null) {
                int i2 = this.d;
                while (i < i2) {
                    j += cVar.e()[i];
                    i++;
                }
            } else {
                cVar.i(null);
                int i3 = this.d;
                while (i < i3) {
                    this.r.delete((Path) cVar.a().get(i));
                    this.r.delete((Path) cVar.c().get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.j = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void T() throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.String r0 = ", "
            ir.nasim.zU1$e r1 = r12.r
            okio.Path r2 = r12.e
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer(r1)
            r2 = 0
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = "libcore.io.DiskLruCache"
            boolean r8 = ir.nasim.AbstractC13042fc3.d(r8, r3)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L81
            java.lang.String r8 = "1"
            boolean r8 = ir.nasim.AbstractC13042fc3.d(r8, r4)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L81
            int r8 = r12.c     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L5c
            boolean r8 = ir.nasim.AbstractC13042fc3.d(r8, r5)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L81
            int r8 = r12.d     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L5c
            boolean r8 = ir.nasim.AbstractC13042fc3.d(r8, r6)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L81
            int r8 = r7.length()     // Catch: java.lang.Throwable -> L5c
            if (r8 > 0) goto L81
            r0 = 0
        L52:
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch: java.lang.Throwable -> L5c java.io.EOFException -> L5e
            r12.U(r3)     // Catch: java.lang.Throwable -> L5c java.io.EOFException -> L5e
            int r0 = r0 + 1
            goto L52
        L5c:
            r0 = move-exception
            goto Lb5
        L5e:
            java.util.LinkedHashMap r3 = r12.h     // Catch: java.lang.Throwable -> L5c
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L5c
            int r0 = r0 - r3
            r12.k = r0     // Catch: java.lang.Throwable -> L5c
            boolean r0 = r1.exhausted()     // Catch: java.lang.Throwable -> L5c
            if (r0 != 0) goto L71
            r12.f0()     // Catch: java.lang.Throwable -> L5c
            goto L77
        L71:
            okio.BufferedSink r0 = r12.P()     // Catch: java.lang.Throwable -> L5c
            r12.l = r0     // Catch: java.lang.Throwable -> L5c
        L77:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto Lc2
            r1.close()     // Catch: java.lang.Throwable -> L7f
            goto Lc2
        L7f:
            r2 = move-exception
            goto Lc2
        L81:
            java.io.IOException r8 = new java.io.IOException     // Catch: java.lang.Throwable -> L5c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r9.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r10 = "unexpected journal header: ["
            r9.append(r10)     // Catch: java.lang.Throwable -> L5c
            r9.append(r3)     // Catch: java.lang.Throwable -> L5c
            r9.append(r0)     // Catch: java.lang.Throwable -> L5c
            r9.append(r4)     // Catch: java.lang.Throwable -> L5c
            r9.append(r0)     // Catch: java.lang.Throwable -> L5c
            r9.append(r5)     // Catch: java.lang.Throwable -> L5c
            r9.append(r0)     // Catch: java.lang.Throwable -> L5c
            r9.append(r6)     // Catch: java.lang.Throwable -> L5c
            r9.append(r0)     // Catch: java.lang.Throwable -> L5c
            r9.append(r7)     // Catch: java.lang.Throwable -> L5c
            r0 = 93
            r9.append(r0)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r9.toString()     // Catch: java.lang.Throwable -> L5c
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            throw r8     // Catch: java.lang.Throwable -> L5c
        Lb5:
            if (r1 == 0) goto Lbf
            r1.close()     // Catch: java.lang.Throwable -> Lbb
            goto Lbf
        Lbb:
            r1 = move-exception
            ir.nasim.AbstractC16041kc2.a(r0, r1)
        Lbf:
            r11 = r2
            r2 = r0
            r0 = r11
        Lc2:
            if (r2 != 0) goto Lc8
            ir.nasim.AbstractC13042fc3.f(r0)
            return
        Lc8:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24949zU1.T():void");
    }

    private final void U(String str) throws IOException {
        String strSubstring;
        int iK0 = AbstractC20762sZ6.k0(str, ' ', 0, false, 6, null);
        if (iK0 == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iK0 + 1;
        int iK02 = AbstractC20762sZ6.k0(str, ' ', i, false, 4, null);
        if (iK02 == -1) {
            strSubstring = str.substring(i);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            if (iK0 == 6 && AbstractC20153rZ6.S(str, "REMOVE", false, 2, null)) {
                this.h.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iK02);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
        }
        LinkedHashMap linkedHashMap = this.h;
        Object cVar = linkedHashMap.get(strSubstring);
        if (cVar == null) {
            cVar = new c(strSubstring);
            linkedHashMap.put(strSubstring, cVar);
        }
        c cVar2 = (c) cVar;
        if (iK02 != -1 && iK0 == 5 && AbstractC20153rZ6.S(str, "CLEAN", false, 2, null)) {
            String strSubstring2 = str.substring(iK02 + 1);
            AbstractC13042fc3.h(strSubstring2, "substring(...)");
            List listM0 = AbstractC20762sZ6.M0(strSubstring2, new char[]{' '}, false, 0, 6, null);
            cVar2.l(true);
            cVar2.i(null);
            cVar2.j(listM0);
            return;
        }
        if (iK02 == -1 && iK0 == 5 && AbstractC20153rZ6.S(str, "DIRTY", false, 2, null)) {
            cVar2.i(new b(cVar2));
            return;
        }
        if (iK02 == -1 && iK0 == 4 && AbstractC20153rZ6.S(str, "READ", false, 2, null)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean X(c cVar) {
        BufferedSink bufferedSink;
        if (cVar.f() > 0 && (bufferedSink = this.l) != null) {
            bufferedSink.writeUtf8("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(cVar.d());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (cVar.f() > 0 || cVar.b() != null) {
            cVar.m(true);
            return true;
        }
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            this.r.delete((Path) cVar.a().get(i2));
            this.j -= cVar.e()[i2];
            cVar.e()[i2] = 0;
        }
        this.k++;
        BufferedSink bufferedSink2 = this.l;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8("REMOVE");
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(cVar.d());
            bufferedSink2.writeByte(10);
        }
        this.h.remove(cVar.d());
        if (K()) {
            M();
        }
        return true;
    }

    private final boolean Z() {
        for (c cVar : this.h.values()) {
            if (!cVar.h()) {
                X(cVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        while (this.j > this.b) {
            if (!Z()) {
                return;
            }
        }
        this.p = false;
    }

    private final void e0(String str) {
        if (t.g(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void f0() {
        C19938rB7 c19938rB7;
        try {
            BufferedSink bufferedSink = this.l;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkBuffer = Okio.buffer(this.r.sink(this.f, false));
            Throwable th = null;
            try {
                bufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                bufferedSinkBuffer.writeUtf8("1").writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.c).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.d).writeByte(10);
                bufferedSinkBuffer.writeByte(10);
                for (c cVar : this.h.values()) {
                    if (cVar.b() != null) {
                        bufferedSinkBuffer.writeUtf8("DIRTY");
                        bufferedSinkBuffer.writeByte(32);
                        bufferedSinkBuffer.writeUtf8(cVar.d());
                        bufferedSinkBuffer.writeByte(10);
                    } else {
                        bufferedSinkBuffer.writeUtf8("CLEAN");
                        bufferedSinkBuffer.writeByte(32);
                        bufferedSinkBuffer.writeUtf8(cVar.d());
                        cVar.o(bufferedSinkBuffer);
                        bufferedSinkBuffer.writeByte(10);
                    }
                }
                c19938rB7 = C19938rB7.a;
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        AbstractC16632lc2.a(th3, th4);
                    }
                }
                c19938rB7 = null;
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            AbstractC13042fc3.f(c19938rB7);
            if (this.r.exists(this.e)) {
                this.r.atomicMove(this.e, this.g);
                this.r.atomicMove(this.f, this.e);
                this.r.delete(this.g);
            } else {
                this.r.atomicMove(this.f, this.e);
            }
            this.l = P();
            this.k = 0;
            this.m = false;
            this.q = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    private final void u() {
        if (!(!this.o)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void y(b bVar, boolean z) {
        c cVarG = bVar.g();
        if (!AbstractC13042fc3.d(cVarG.b(), bVar)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int i = 0;
        if (!z || cVarG.h()) {
            int i2 = this.d;
            while (i < i2) {
                this.r.delete((Path) cVarG.c().get(i));
                i++;
            }
        } else {
            int i3 = this.d;
            for (int i4 = 0; i4 < i3; i4++) {
                if (bVar.h()[i4] && !this.r.exists((Path) cVarG.c().get(i4))) {
                    bVar.a();
                    return;
                }
            }
            int i5 = this.d;
            while (i < i5) {
                Path path = (Path) cVarG.c().get(i);
                Path path2 = (Path) cVarG.a().get(i);
                if (this.r.exists(path)) {
                    this.r.atomicMove(path, path2);
                } else {
                    AbstractC13892h.a(this.r, (Path) cVarG.a().get(i));
                }
                long j = cVarG.e()[i];
                Long size = this.r.metadata(path2).getSize();
                long jLongValue = size != null ? size.longValue() : 0L;
                cVarG.e()[i] = jLongValue;
                this.j = (this.j - j) + jLongValue;
                i++;
            }
        }
        cVarG.i(null);
        if (cVarG.h()) {
            X(cVarG);
            return;
        }
        this.k++;
        BufferedSink bufferedSink = this.l;
        AbstractC13042fc3.f(bufferedSink);
        if (z || cVarG.g()) {
            cVarG.l(true);
            bufferedSink.writeUtf8("CLEAN");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(cVarG.d());
            cVarG.o(bufferedSink);
            bufferedSink.writeByte(10);
        } else {
            this.h.remove(cVarG.d());
            bufferedSink.writeUtf8("REMOVE");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(cVarG.d());
            bufferedSink.writeByte(10);
        }
        bufferedSink.flush();
        if (this.j > this.b || K()) {
            M();
        }
    }

    private final void z() throws IOException {
        close();
        AbstractC13892h.b(this.r, this.a);
    }

    public final synchronized b G(String str) {
        u();
        e0(str);
        J();
        c cVar = (c) this.h.get(str);
        if ((cVar != null ? cVar.b() : null) != null) {
            return null;
        }
        if (cVar != null && cVar.f() != 0) {
            return null;
        }
        if (!this.p && !this.q) {
            BufferedSink bufferedSink = this.l;
            AbstractC13042fc3.f(bufferedSink);
            bufferedSink.writeUtf8("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.m) {
                return null;
            }
            if (cVar == null) {
                cVar = new c(str);
                this.h.put(str, cVar);
            }
            b bVar = new b(cVar);
            cVar.i(bVar);
            return bVar;
        }
        M();
        return null;
    }

    public final synchronized d H(String str) {
        d dVarN;
        u();
        e0(str);
        J();
        c cVar = (c) this.h.get(str);
        if (cVar != null && (dVarN = cVar.n()) != null) {
            this.k++;
            BufferedSink bufferedSink = this.l;
            AbstractC13042fc3.f(bufferedSink);
            bufferedSink.writeUtf8("READ");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            if (K()) {
                M();
            }
            return dVarN;
        }
        return null;
    }

    public final synchronized void J() {
        try {
            if (this.n) {
                return;
            }
            this.r.delete(this.f);
            if (this.r.exists(this.g)) {
                if (this.r.exists(this.e)) {
                    this.r.delete(this.g);
                } else {
                    this.r.atomicMove(this.g, this.e);
                }
            }
            if (this.r.exists(this.e)) {
                try {
                    T();
                    S();
                    this.n = true;
                    return;
                } catch (IOException unused) {
                    try {
                        z();
                        this.o = false;
                    } catch (Throwable th) {
                        this.o = false;
                        throw th;
                    }
                }
            }
            f0();
            this.n = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.n && !this.o) {
                for (c cVar : (c[]) this.h.values().toArray(new c[0])) {
                    b bVarB = cVar.b();
                    if (bVarB != null) {
                        bVarB.e();
                    }
                }
                d0();
                AbstractC20906so1.d(this.i, null, 1, null);
                BufferedSink bufferedSink = this.l;
                AbstractC13042fc3.f(bufferedSink);
                bufferedSink.close();
                this.l = null;
                this.o = true;
                return;
            }
            this.o = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.n) {
            u();
            d0();
            BufferedSink bufferedSink = this.l;
            AbstractC13042fc3.f(bufferedSink);
            bufferedSink.flush();
        }
    }
}
