package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.aZ1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9785aZ1 {
    public static final b h = new b(null);
    private final C4995Hl2 a;
    private final SA2 b;
    private final OY1 c;
    private final InterfaceC17089mN5 d;
    private final InterfaceC19699qn4 e;
    private c f;
    private final C23270we2 g;

    /* renamed from: ir.nasim.aZ1$a */
    /* synthetic */ class a extends EB2 implements SA2 {
        public static final a a = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* renamed from: ir.nasim.aZ1$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.aZ1$c */
    private static final class c {
        private final String a;
        private final long b;

        public c(String str, long j) {
            AbstractC13042fc3.i(str, "url");
            this.a = str;
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Long.hashCode(this.b);
        }

        public String toString() {
            return "DownloadUrl(url=" + this.a + ", timeToLive=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.aZ1$d */
    public interface d {
        C9785aZ1 a(C4995Hl2 c4995Hl2, OY1 oy1);
    }

    /* renamed from: ir.nasim.aZ1$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C9785aZ1.this.c(this);
        }
    }

    /* renamed from: ir.nasim.aZ1$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C9785aZ1.this.d(this);
        }
    }

    public C9785aZ1(C4995Hl2 c4995Hl2, SA2 sa2, OY1 oy1, InterfaceC17089mN5 interfaceC17089mN5) {
        AbstractC13042fc3.i(c4995Hl2, "fileLocation");
        AbstractC13042fc3.i(sa2, "currentTimeProvider");
        AbstractC13042fc3.i(oy1, "retryPolicy");
        AbstractC13042fc3.i(interfaceC17089mN5, "remoteDownloadDataSource");
        this.a = c4995Hl2;
        this.b = sa2;
        this.c = oy1;
        this.d = interfaceC17089mN5;
        this.e = AbstractC20899sn4.a(false);
        this.g = new C23270we2(0L, 0L, 0.0d, 1.5f, 7, null);
    }

    private final c b(String str) {
        return new c(str, ((Number) this.b.invoke()).longValue() + 3600000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0093 -> B:13:0x002f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof ir.nasim.C9785aZ1.f
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.aZ1$f r0 = (ir.nasim.C9785aZ1.f) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.aZ1$f r0 = new ir.nasim.aZ1$f
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r2 = r0.a
            ir.nasim.aZ1 r2 = (ir.nasim.C9785aZ1) r2
            ir.nasim.AbstractC10685c16.b(r9)
        L2f:
            r9 = r2
            goto L45
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L39:
            java.lang.Object r2 = r0.a
            ir.nasim.aZ1 r2 = (ir.nasim.C9785aZ1) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L57
        L41:
            ir.nasim.AbstractC10685c16.b(r9)
            r9 = r8
        L45:
            ir.nasim.mN5 r2 = r9.d
            ir.nasim.Hl2 r5 = r9.a
            r0.a = r9
            r0.d = r4
            java.lang.Object r2 = r2.a(r5, r0)
            if (r2 != r1) goto L54
            return r1
        L54:
            r7 = r2
            r2 = r9
            r9 = r7
        L57:
            ir.nasim.MY1 r9 = (ir.nasim.MY1) r9
            boolean r5 = r9 instanceof ir.nasim.MY1.b
            if (r5 == 0) goto L63
            ir.nasim.we2 r0 = r2.g
            r0.b()
            goto L96
        L63:
            boolean r5 = r9 instanceof ir.nasim.MY1.a
            if (r5 == 0) goto L97
            ir.nasim.MY1$a r9 = (ir.nasim.MY1.a) r9
            ir.nasim.EX1 r5 = r9.a()
            boolean r6 = r5.a()
            if (r6 == 0) goto L96
            ir.nasim.OY1 r6 = r2.c
            ir.nasim.UA2 r6 = r6.a()
            java.lang.Object r5 = r6.invoke(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L96
            ir.nasim.we2 r9 = r2.g
            long r5 = r9.a()
            r0.a = r2
            r0.d = r3
            java.lang.Object r9 = ir.nasim.HG1.b(r5, r0)
            if (r9 != r1) goto L2f
            return r1
        L96:
            return r9
        L97:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9785aZ1.d(ir.nasim.rm1):java.lang.Object");
    }

    private final c e(c cVar) {
        if (cVar.a() > ((Number) this.b.invoke()).longValue()) {
            return cVar;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:13:0x0031, B:35:0x008a, B:37:0x0091, B:40:0x0097, B:42:0x009f, B:44:0x00a5), top: B:51:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.C9785aZ1.e
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.aZ1$e r0 = (ir.nasim.C9785aZ1.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.aZ1$e r0 = new ir.nasim.aZ1$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r1 = r0.b
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r0 = r0.a
            ir.nasim.aZ1 r0 = (ir.nasim.C9785aZ1) r0
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L35
            goto L8a
        L35:
            r7 = move-exception
            goto Laf
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L40:
            java.lang.Object r2 = r0.b
            ir.nasim.qn4 r2 = (ir.nasim.InterfaceC19699qn4) r2
            java.lang.Object r4 = r0.a
            ir.nasim.aZ1 r4 = (ir.nasim.C9785aZ1) r4
            ir.nasim.AbstractC10685c16.b(r7)
            r7 = r2
            goto L60
        L4d:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.qn4 r7 = r6.e
            r0.a = r6
            r0.b = r7
            r0.e = r4
            java.lang.Object r2 = r7.a(r5, r0)
            if (r2 != r1) goto L5f
            return r1
        L5f:
            r4 = r6
        L60:
            ir.nasim.aZ1$c r2 = r4.f     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L78
            ir.nasim.aZ1$c r2 = r4.e(r2)     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L78
            ir.nasim.MY1$b r0 = new ir.nasim.MY1$b     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = r2.b()     // Catch: java.lang.Throwable -> L74
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L74
            goto Lab
        L74:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto Laf
        L78:
            r4.f = r5     // Catch: java.lang.Throwable -> L74
            r0.a = r4     // Catch: java.lang.Throwable -> L74
            r0.b = r7     // Catch: java.lang.Throwable -> L74
            r0.e = r3     // Catch: java.lang.Throwable -> L74
            java.lang.Object r0 = r4.d(r0)     // Catch: java.lang.Throwable -> L74
            if (r0 != r1) goto L87
            return r1
        L87:
            r1 = r7
            r7 = r0
            r0 = r4
        L8a:
            r2 = r7
            ir.nasim.MY1 r2 = (ir.nasim.MY1) r2     // Catch: java.lang.Throwable -> L35
            boolean r3 = r2 instanceof ir.nasim.MY1.b     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L94
            ir.nasim.MY1$b r2 = (ir.nasim.MY1.b) r2     // Catch: java.lang.Throwable -> L35
            goto L95
        L94:
            r2 = r5
        L95:
            if (r2 == 0) goto La4
            java.lang.Object r2 = r2.a()     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto La4
            ir.nasim.aZ1$c r2 = r0.b(r2)     // Catch: java.lang.Throwable -> L35
            goto La5
        La4:
            r2 = r5
        La5:
            r0.f = r2     // Catch: java.lang.Throwable -> L35
            r0 = r7
            ir.nasim.MY1 r0 = (ir.nasim.MY1) r0     // Catch: java.lang.Throwable -> L35
            r7 = r1
        Lab:
            r7.e(r5)
            return r0
        Laf:
            r1.e(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9785aZ1.c(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C9785aZ1(C4995Hl2 c4995Hl2, OY1 oy1, InterfaceC17089mN5 interfaceC17089mN5) {
        this(c4995Hl2, a.a, oy1, interfaceC17089mN5);
        AbstractC13042fc3.i(c4995Hl2, "fileLocation");
        AbstractC13042fc3.i(oy1, "retryPolicy");
        AbstractC13042fc3.i(interfaceC17089mN5, "remoteDownloadDataSource");
    }
}
