package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.wD6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23027wD6 implements InterfaceC23475wz1 {
    public static final a k = new a(null);
    private static final Set l = new LinkedHashSet();
    private static final Object m = new Object();
    private final SA2 a;
    private final InterfaceC25168zq6 b;
    private final InterfaceC7401Ro1 c;
    private final InterfaceC20315ro1 d;
    private final InterfaceC4557Fq2 e;
    private final String f;
    private final InterfaceC9173Yu3 g;
    private final InterfaceC9336Zm4 h;
    private List i;
    private final C24198yC6 j;

    /* renamed from: ir.nasim.wD6$a */
    public static final class a {
        private a() {
        }

        public final Set a() {
            return C23027wD6.l;
        }

        public final Object b() {
            return C23027wD6.m;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wD6$b */
    private static abstract class b {

        /* renamed from: ir.nasim.wD6$b$a */
        public static final class a extends b {
            private final VK6 a;

            public a(VK6 vk6) {
                super(null);
                this.a = vk6;
            }

            public VK6 a() {
                return this.a;
            }
        }

        /* renamed from: ir.nasim.wD6$b$b, reason: collision with other inner class name */
        public static final class C1754b extends b {
            private final InterfaceC14603iB2 a;
            private final InterfaceC22299v01 b;
            private final VK6 c;
            private final InterfaceC11938do1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1754b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22299v01 interfaceC22299v01, VK6 vk6, InterfaceC11938do1 interfaceC11938do1) {
                super(null);
                AbstractC13042fc3.i(interfaceC14603iB2, "transform");
                AbstractC13042fc3.i(interfaceC22299v01, "ack");
                AbstractC13042fc3.i(interfaceC11938do1, "callerContext");
                this.a = interfaceC14603iB2;
                this.b = interfaceC22299v01;
                this.c = vk6;
                this.d = interfaceC11938do1;
            }

            public final InterfaceC22299v01 a() {
                return this.b;
            }

            public final InterfaceC11938do1 b() {
                return this.d;
            }

            public VK6 c() {
                return this.c;
            }

            public final InterfaceC14603iB2 d() {
                return this.a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wD6$c */
    private static final class c extends OutputStream {
        private final FileOutputStream a;

        public c(FileOutputStream fileOutputStream) {
            AbstractC13042fc3.i(fileOutputStream, "fileOutputStream");
            this.a = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            AbstractC13042fc3.i(bArr, "b");
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            AbstractC13042fc3.i(bArr, "bytes");
            this.a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* renamed from: ir.nasim.wD6$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        d() {
            super(1);
        }

        public final void a(Throwable th) {
            if (th != null) {
                C23027wD6.this.h.setValue(new C21594to2(th));
            }
            a aVar = C23027wD6.k;
            Object objB = aVar.b();
            C23027wD6 c23027wD6 = C23027wD6.this;
            synchronized (objB) {
                aVar.a().remove(c23027wD6.q().getAbsolutePath());
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.wD6$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        public final void a(b bVar, Throwable th) {
            AbstractC13042fc3.i(bVar, "msg");
            if (bVar instanceof b.C1754b) {
                InterfaceC22299v01 interfaceC22299v01A = ((b.C1754b) bVar).a();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                interfaceC22299v01A.e(th);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((b) obj, (Throwable) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.wD6$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C23027wD6.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = (b) this.c;
                if (bVar instanceof b.a) {
                    this.b = 1;
                    if (C23027wD6.this.r((b.a) bVar, this) == objE) {
                        return objE;
                    }
                } else if (bVar instanceof b.C1754b) {
                    this.b = 2;
                    if (C23027wD6.this.s((b.C1754b) bVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD6$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.wD6$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ VK6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(VK6 vk6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = vk6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                VK6 vk6 = (VK6) this.c;
                VK6 vk62 = this.d;
                boolean z = false;
                if (!(vk62 instanceof C6046Ly1) && !(vk62 instanceof C21594to2) && vk6 == vk62) {
                    z = true;
                }
                return AbstractC6392Nk0.a(z);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(VK6 vk6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(vk6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.wD6$g$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.wD6$g$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.wD6$g$b$a$a, reason: collision with other inner class name */
                public static final class C1755a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1755a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C23027wD6.g.b.a.C1755a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.wD6$g$b$a$a r0 = (ir.nasim.C23027wD6.g.b.a.C1755a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.wD6$g$b$a$a r0 = new ir.nasim.wD6$g$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L53
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.VK6 r5 = (ir.nasim.VK6) r5
                        boolean r2 = r5 instanceof ir.nasim.C21885uI5
                        if (r2 != 0) goto L73
                        boolean r2 = r5 instanceof ir.nasim.C21594to2
                        if (r2 != 0) goto L6c
                        boolean r2 = r5 instanceof ir.nasim.C6046Ly1
                        if (r2 == 0) goto L56
                        ir.nasim.Ly1 r5 = (ir.nasim.C6046Ly1) r5
                        java.lang.Object r5 = r5.b()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L53
                        return r1
                    L53:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    L56:
                        boolean r5 = r5 instanceof ir.nasim.TA7
                        if (r5 == 0) goto L66
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                        java.lang.String r6 = r6.toString()
                        r5.<init>(r6)
                        throw r5
                    L66:
                        kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                        r5.<init>()
                        throw r5
                    L6c:
                        ir.nasim.to2 r5 = (ir.nasim.C21594to2) r5
                        java.lang.Throwable r5 = r5.a()
                        throw r5
                    L73:
                        ir.nasim.uI5 r5 = (ir.nasim.C21885uI5) r5
                        java.lang.Throwable r5 = r5.a()
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.g.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C23027wD6.this.new g(interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                VK6 vk6 = (VK6) C23027wD6.this.h.getValue();
                if (!(vk6 instanceof C6046Ly1)) {
                    C23027wD6.this.j.e(new b.a(vk6));
                }
                b bVar = new b(AbstractC6459Nq2.z(C23027wD6.this.h, new a(vk6, null)));
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD6$h */
    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) C23027wD6.this.a.invoke();
            String absolutePath = file.getAbsolutePath();
            a aVar = C23027wD6.k;
            synchronized (aVar.b()) {
                if (!(!aVar.a().contains(absolutePath))) {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
                Set setA = aVar.a();
                AbstractC13042fc3.h(absolutePath, "it");
                setA.add(absolutePath);
            }
            return file;
        }
    }

    /* renamed from: ir.nasim.wD6$i */
    static final class i extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.s(null, this);
        }
    }

    /* renamed from: ir.nasim.wD6$j */
    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        /* synthetic */ Object g;
        int i;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.t(this);
        }
    }

    /* renamed from: ir.nasim.wD6$k */
    public static final class k implements F73 {
        final /* synthetic */ InterfaceC19699qn4 a;
        final /* synthetic */ C9663aL5 b;
        final /* synthetic */ C12889fL5 c;
        final /* synthetic */ C23027wD6 d;

        /* renamed from: ir.nasim.wD6$k$a */
        static final class a extends AbstractC22163um1 {
            Object a;
            Object b;
            Object c;
            Object d;
            Object e;
            /* synthetic */ Object f;
            int h;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.f = obj;
                this.h |= RecyclerView.UNDEFINED_DURATION;
                return k.this.a(null, this);
            }
        }

        k(InterfaceC19699qn4 interfaceC19699qn4, C9663aL5 c9663aL5, C12889fL5 c12889fL5, C23027wD6 c23027wD6) {
            this.a = interfaceC19699qn4;
            this.b = c9663aL5;
            this.c = c12889fL5;
            this.d = c23027wD6;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b2, B:38:0x00ba), top: B:53:0x0052 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.F73
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object a(ir.nasim.InterfaceC14603iB2 r11, ir.nasim.InterfaceC20295rm1 r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 230
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.k.a(ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.wD6$l */
    static final class l extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.u(this);
        }
    }

    /* renamed from: ir.nasim.wD6$m */
    static final class m extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.v(this);
        }
    }

    /* renamed from: ir.nasim.wD6$n */
    static final class n extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.w(this);
        }
    }

    /* renamed from: ir.nasim.wD6$o */
    static final class o extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.x(this);
        }
    }

    /* renamed from: ir.nasim.wD6$p */
    static final class p extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.y(null, null, this);
        }
    }

    /* renamed from: ir.nasim.wD6$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 c;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC14603iB2;
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new q(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14603iB2 interfaceC14603iB2 = this.c;
                Object obj2 = this.d;
                this.b = 1;
                obj = interfaceC14603iB2.invoke(obj2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD6$r */
    static final class r extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C23027wD6.this.z(null, this);
        }
    }

    public C23027wD6(SA2 sa2, InterfaceC25168zq6 interfaceC25168zq6, List list, InterfaceC7401Ro1 interfaceC7401Ro1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(sa2, "produceFile");
        AbstractC13042fc3.i(interfaceC25168zq6, "serializer");
        AbstractC13042fc3.i(list, "initTasksList");
        AbstractC13042fc3.i(interfaceC7401Ro1, "corruptionHandler");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = sa2;
        this.b = interfaceC25168zq6;
        this.c = interfaceC7401Ro1;
        this.d = interfaceC20315ro1;
        this.e = AbstractC6459Nq2.R(new g(null));
        this.f = ".tmp";
        this.g = AbstractC13269fw3.a(new h());
        this.h = AbstractC12281eL6.a(TA7.a);
        this.i = AbstractC15401jX0.m1(list);
        this.j = new C24198yC6(interfaceC20315ro1, new d(), e.e, new f(null));
    }

    private final void p(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(AbstractC13042fc3.q("Unable to create parent directories of ", file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File q() {
        return (File) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(b.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        VK6 vk6 = (VK6) this.h.getValue();
        if (!(vk6 instanceof C6046Ly1)) {
            if (vk6 instanceof C21885uI5) {
                if (vk6 == aVar.a()) {
                    Object objV = v(interfaceC20295rm1);
                    return objV == AbstractC14862ic3.e() ? objV : C19938rB7.a;
                }
            } else {
                if (AbstractC13042fc3.d(vk6, TA7.a)) {
                    Object objV2 = v(interfaceC20295rm1);
                    return objV2 == AbstractC14862ic3.e() ? objV2 : C19938rB7.a;
                }
                if (vk6 instanceof C21594to2) {
                    throw new IllegalStateException("Can't read in final state.".toString());
                }
            }
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v20, types: [ir.nasim.v01] */
    /* JADX WARN: Type inference failed for: r9v27, types: [ir.nasim.v01] */
    /* JADX WARN: Type inference failed for: r9v3, types: [ir.nasim.v01] */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(ir.nasim.C23027wD6.b.C1754b r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.s(ir.nasim.wD6$b$b, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(ir.nasim.InterfaceC20295rm1 r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.t(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(ir.nasim.InterfaceC20295rm1 r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C23027wD6.l
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.wD6$l r0 = (ir.nasim.C23027wD6.l) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.wD6$l r0 = new ir.nasim.wD6$l
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.a
            ir.nasim.wD6 r0 = (ir.nasim.C23027wD6) r0
            ir.nasim.AbstractC10685c16.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L45
        L2d:
            r5 = move-exception
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            r0.a = r4     // Catch: java.lang.Throwable -> L48
            r0.d = r3     // Catch: java.lang.Throwable -> L48
            java.lang.Object r5 = r4.t(r0)     // Catch: java.lang.Throwable -> L48
            if (r5 != r1) goto L45
            return r1
        L45:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        L48:
            r5 = move-exception
            r0 = r4
        L4a:
            ir.nasim.Zm4 r0 = r0.h
            ir.nasim.uI5 r1 = new ir.nasim.uI5
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.u(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C23027wD6.m
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.wD6$m r0 = (ir.nasim.C23027wD6.m) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.wD6$m r0 = new ir.nasim.wD6$m
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.a
            ir.nasim.wD6 r0 = (ir.nasim.C23027wD6) r0
            ir.nasim.AbstractC10685c16.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L51
        L2d:
            r5 = move-exception
            goto L47
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            r0.a = r4     // Catch: java.lang.Throwable -> L45
            r0.d = r3     // Catch: java.lang.Throwable -> L45
            java.lang.Object r5 = r4.t(r0)     // Catch: java.lang.Throwable -> L45
            if (r5 != r1) goto L51
            return r1
        L45:
            r5 = move-exception
            r0 = r4
        L47:
            ir.nasim.Zm4 r0 = r0.h
            ir.nasim.uI5 r1 = new ir.nasim.uI5
            r1.<init>(r5)
            r0.setValue(r1)
        L51:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.v(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11, types: [ir.nasim.wD6] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [ir.nasim.rm1, ir.nasim.wD6$n] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [ir.nasim.wD6] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9, types: [ir.nasim.zq6] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(ir.nasim.InterfaceC20295rm1 r6) throws java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C23027wD6.n
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.wD6$n r0 = (ir.nasim.C23027wD6.n) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.wD6$n r0 = new ir.nasim.wD6$n
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.c
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.b
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r0 = r0.a
            ir.nasim.wD6 r0 = (ir.nasim.C23027wD6) r0
            ir.nasim.AbstractC10685c16.b(r6)     // Catch: java.lang.Throwable -> L35
            goto L5f
        L35:
            r6 = move-exception
            goto L67
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3f:
            ir.nasim.AbstractC10685c16.b(r6)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L6d
            java.io.File r6 = r5.q()     // Catch: java.io.FileNotFoundException -> L6d
            r2.<init>(r6)     // Catch: java.io.FileNotFoundException -> L6d
            ir.nasim.zq6 r6 = r5.b     // Catch: java.lang.Throwable -> L65
            r0.a = r5     // Catch: java.lang.Throwable -> L65
            r0.b = r2     // Catch: java.lang.Throwable -> L65
            r4 = 0
            r0.c = r4     // Catch: java.lang.Throwable -> L65
            r0.f = r3     // Catch: java.lang.Throwable -> L65
            java.lang.Object r6 = r6.a(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r6 != r1) goto L5d
            return r1
        L5d:
            r0 = r5
            r1 = r4
        L5f:
            ir.nasim.YV0.a(r2, r1)     // Catch: java.io.FileNotFoundException -> L63
            return r6
        L63:
            r6 = move-exception
            goto L6f
        L65:
            r6 = move-exception
            r0 = r5
        L67:
            throw r6     // Catch: java.lang.Throwable -> L68
        L68:
            r1 = move-exception
            ir.nasim.YV0.a(r2, r6)     // Catch: java.io.FileNotFoundException -> L63
            throw r1     // Catch: java.io.FileNotFoundException -> L63
        L6d:
            r6 = move-exception
            r0 = r5
        L6f:
            java.io.File r1 = r0.q()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L80
            ir.nasim.zq6 r6 = r0.b
            java.lang.Object r6 = r6.b()
            return r6
        L80:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.w(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(ir.nasim.InterfaceC20295rm1 r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.C23027wD6.o
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.wD6$o r0 = (ir.nasim.C23027wD6.o) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.wD6$o r0 = new ir.nasim.wD6$o
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L55
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.b
            java.lang.Object r0 = r0.a
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.io.IOException -> L35
            goto L87
        L35:
            r8 = move-exception
            goto L8a
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3f:
            java.lang.Object r2 = r0.b
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.a
            ir.nasim.wD6 r4 = (ir.nasim.C23027wD6) r4
            ir.nasim.AbstractC10685c16.b(r8)
            goto L79
        L4b:
            java.lang.Object r2 = r0.a
            ir.nasim.wD6 r2 = (ir.nasim.C23027wD6) r2
            ir.nasim.AbstractC10685c16.b(r8)     // Catch: androidx.datastore.core.CorruptionException -> L53
            goto L63
        L53:
            r8 = move-exception
            goto L66
        L55:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r7     // Catch: androidx.datastore.core.CorruptionException -> L64
            r0.e = r5     // Catch: androidx.datastore.core.CorruptionException -> L64
            java.lang.Object r8 = r7.w(r0)     // Catch: androidx.datastore.core.CorruptionException -> L64
            if (r8 != r1) goto L63
            return r1
        L63:
            return r8
        L64:
            r8 = move-exception
            r2 = r7
        L66:
            ir.nasim.Ro1 r5 = r2.c
            r0.a = r2
            r0.b = r8
            r0.e = r4
            java.lang.Object r4 = r5.a(r8, r0)
            if (r4 != r1) goto L75
            return r1
        L75:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L79:
            r0.a = r2     // Catch: java.io.IOException -> L88
            r0.b = r8     // Catch: java.io.IOException -> L88
            r0.e = r3     // Catch: java.io.IOException -> L88
            java.lang.Object r0 = r4.z(r8, r0)     // Catch: java.io.IOException -> L88
            if (r0 != r1) goto L86
            return r1
        L86:
            r1 = r8
        L87:
            return r1
        L88:
            r8 = move-exception
            r0 = r2
        L8a:
            ir.nasim.AbstractC16041kc2.a(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.x(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(ir.nasim.InterfaceC14603iB2 r8, ir.nasim.InterfaceC11938do1 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ir.nasim.C23027wD6.p
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.wD6$p r0 = (ir.nasim.C23027wD6.p) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.wD6$p r0 = new ir.nasim.wD6$p
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r8 = r0.b
            java.lang.Object r9 = r0.a
            ir.nasim.wD6 r9 = (ir.nasim.C23027wD6) r9
            ir.nasim.AbstractC10685c16.b(r10)
            goto L8e
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.c
            java.lang.Object r9 = r0.b
            ir.nasim.Ly1 r9 = (ir.nasim.C6046Ly1) r9
            java.lang.Object r2 = r0.a
            ir.nasim.wD6 r2 = (ir.nasim.C23027wD6) r2
            ir.nasim.AbstractC10685c16.b(r10)
            goto L73
        L49:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.Zm4 r10 = r7.h
            java.lang.Object r10 = r10.getValue()
            ir.nasim.Ly1 r10 = (ir.nasim.C6046Ly1) r10
            r10.a()
            java.lang.Object r2 = r10.b()
            ir.nasim.wD6$q r6 = new ir.nasim.wD6$q
            r6.<init>(r8, r2, r3)
            r0.a = r7
            r0.b = r10
            r0.c = r2
            r0.f = r5
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r9, r6, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            r9 = r10
            r10 = r8
            r8 = r2
            r2 = r7
        L73:
            r9.a()
            boolean r9 = ir.nasim.AbstractC13042fc3.d(r8, r10)
            if (r9 == 0) goto L7d
            goto La0
        L7d:
            r0.a = r2
            r0.b = r10
            r0.c = r3
            r0.f = r4
            java.lang.Object r8 = r2.z(r10, r0)
            if (r8 != r1) goto L8c
            return r1
        L8c:
            r8 = r10
            r9 = r2
        L8e:
            ir.nasim.Zm4 r9 = r9.h
            ir.nasim.Ly1 r10 = new ir.nasim.Ly1
            if (r8 == 0) goto L99
            int r0 = r8.hashCode()
            goto L9a
        L99:
            r0 = 0
        L9a:
            r10.<init>(r8, r0)
            r9.setValue(r10)
        La0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.y(ir.nasim.iB2, ir.nasim.do1, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC23475wz1
    public Object a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        InterfaceC22299v01 interfaceC22299v01C = AbstractC23485x01.c(null, 1, null);
        this.j.e(new b.C1754b(interfaceC14603iB2, interfaceC22299v01C, (VK6) this.h.getValue(), interfaceC20295rm1.getContext()));
        return interfaceC22299v01C.y(interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC23475wz1
    public InterfaceC4557Fq2 getData() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C23027wD6.r
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.wD6$r r0 = (ir.nasim.C23027wD6.r) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            ir.nasim.wD6$r r0 = new ir.nasim.wD6$r
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r8 = r0.e
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
            java.lang.Object r1 = r0.d
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.c
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r3 = r0.b
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r0 = r0.a
            ir.nasim.wD6 r0 = (ir.nasim.C23027wD6) r0
            ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L3d
            goto L89
        L3d:
            r8 = move-exception
            goto Lc3
        L40:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L48:
            ir.nasim.AbstractC10685c16.b(r9)
            java.io.File r9 = r7.q()
            r7.p(r9)
            java.io.File r9 = new java.io.File
            java.io.File r2 = r7.q()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r4 = r7.f
            java.lang.String r2 = ir.nasim.AbstractC13042fc3.q(r2, r4)
            r9.<init>(r2)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.io.IOException -> Lc9
            r2.<init>(r9)     // Catch: java.io.IOException -> Lc9
            ir.nasim.zq6 r4 = r7.b     // Catch: java.lang.Throwable -> Lc1
            ir.nasim.wD6$c r5 = new ir.nasim.wD6$c     // Catch: java.lang.Throwable -> Lc1
            r5.<init>(r2)     // Catch: java.lang.Throwable -> Lc1
            r0.a = r7     // Catch: java.lang.Throwable -> Lc1
            r0.b = r9     // Catch: java.lang.Throwable -> Lc1
            r0.c = r2     // Catch: java.lang.Throwable -> Lc1
            r6 = 0
            r0.d = r6     // Catch: java.lang.Throwable -> Lc1
            r0.e = r2     // Catch: java.lang.Throwable -> Lc1
            r0.h = r3     // Catch: java.lang.Throwable -> Lc1
            java.lang.Object r8 = r4.c(r8, r5, r0)     // Catch: java.lang.Throwable -> Lc1
            if (r8 != r1) goto L85
            return r1
        L85:
            r0 = r7
            r3 = r9
            r8 = r2
            r1 = r6
        L89:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch: java.lang.Throwable -> L3d
            r8.sync()     // Catch: java.lang.Throwable -> L3d
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L3d
            ir.nasim.YV0.a(r2, r1)     // Catch: java.io.IOException -> Lbe
            java.io.File r8 = r0.q()     // Catch: java.io.IOException -> Lbe
            boolean r8 = r3.renameTo(r8)     // Catch: java.io.IOException -> Lbe
            if (r8 == 0) goto La2
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        La2:
            java.io.IOException r8 = new java.io.IOException     // Catch: java.io.IOException -> Lbe
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lbe
            r9.<init>()     // Catch: java.io.IOException -> Lbe
            java.lang.String r0 = "Unable to rename "
            r9.append(r0)     // Catch: java.io.IOException -> Lbe
            r9.append(r3)     // Catch: java.io.IOException -> Lbe
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch: java.io.IOException -> Lbe
            java.lang.String r9 = r9.toString()     // Catch: java.io.IOException -> Lbe
            r8.<init>(r9)     // Catch: java.io.IOException -> Lbe
            throw r8     // Catch: java.io.IOException -> Lbe
        Lbe:
            r8 = move-exception
            r9 = r3
            goto Lca
        Lc1:
            r8 = move-exception
            r3 = r9
        Lc3:
            throw r8     // Catch: java.lang.Throwable -> Lc4
        Lc4:
            r9 = move-exception
            ir.nasim.YV0.a(r2, r8)     // Catch: java.io.IOException -> Lbe
            throw r9     // Catch: java.io.IOException -> Lbe
        Lc9:
            r8 = move-exception
        Lca:
            boolean r0 = r9.exists()
            if (r0 == 0) goto Ld3
            r9.delete()
        Ld3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23027wD6.z(java.lang.Object, ir.nasim.rm1):java.lang.Object");
    }
}
