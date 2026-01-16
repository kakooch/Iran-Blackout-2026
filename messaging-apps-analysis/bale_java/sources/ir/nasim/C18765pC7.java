package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.pC7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18765pC7 {
    private static final a f = new a(null);
    public static final int g = 8;
    private static final C7210Qt h = new C7210Qt(0.0f);
    private final ZQ7 a;
    private long b = Long.MIN_VALUE;
    private C7210Qt c = h;
    private boolean d;
    private float e;

    /* renamed from: ir.nasim.pC7$a */
    private static final class a {
        private a() {
        }

        public final C7210Qt a() {
            return C18765pC7.h;
        }

        public final boolean b(float f) {
            return Math.abs(f) < 0.01f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pC7$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        float d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C18765pC7.this.h(null, null, this);
        }
    }

    /* renamed from: ir.nasim.pC7$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(float f, UA2 ua2) {
            super(1);
            this.f = f;
            this.g = ua2;
        }

        public final void a(long j) {
            if (C18765pC7.this.b == Long.MIN_VALUE) {
                C18765pC7.this.b = j;
            }
            C7210Qt c7210Qt = new C7210Qt(C18765pC7.this.i());
            long jB = this.f == 0.0f ? C18765pC7.this.a.b(new C7210Qt(C18765pC7.this.i()), C18765pC7.f.a(), C18765pC7.this.c) : AbstractC20723sV3.f((j - C18765pC7.this.b) / this.f);
            float f = ((C7210Qt) C18765pC7.this.a.c(jB, c7210Qt, C18765pC7.f.a(), C18765pC7.this.c)).f();
            C18765pC7 c18765pC7 = C18765pC7.this;
            c18765pC7.c = (C7210Qt) c18765pC7.a.f(jB, c7210Qt, C18765pC7.f.a(), C18765pC7.this.c);
            C18765pC7.this.b = j;
            float fI = C18765pC7.this.i() - f;
            C18765pC7.this.j(f);
            this.g.invoke(Float.valueOf(fI));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).longValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pC7$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(UA2 ua2) {
            super(1);
            this.f = ua2;
        }

        public final void a(long j) {
            float fI = C18765pC7.this.i();
            C18765pC7.this.j(0.0f);
            this.f.invoke(Float.valueOf(fI));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).longValue());
            return C19938rB7.a;
        }
    }

    public C18765pC7(InterfaceC5766Kt interfaceC5766Kt) {
        this.a = interfaceC5766Kt.a(PQ7.d(C9361Zp2.a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088 A[Catch: all -> 0x00b4, PHI: r0 r2 r13 r14 r15
      0x0088: PHI (r0v9 ir.nasim.SA2) = (r0v3 ir.nasim.SA2), (r0v10 ir.nasim.SA2) binds: [B:31:0x0081, B:39:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r2v4 ir.nasim.pC7$b) = (r2v2 ir.nasim.pC7$b), (r2v5 ir.nasim.pC7$b) binds: [B:31:0x0081, B:39:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r13v5 float) = (r13v3 float), (r13v6 float) binds: [B:31:0x0081, B:39:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r14v6 ir.nasim.UA2) = (r14v3 ir.nasim.UA2), (r14v7 ir.nasim.UA2) binds: [B:31:0x0081, B:39:0x00ad] A[DONT_GENERATE, DONT_INLINE]
      0x0088: PHI (r15v17 ir.nasim.pC7) = (r15v10 ir.nasim.pC7), (r15v18 ir.nasim.pC7) binds: [B:31:0x0081, B:39:0x00ad] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x00b4, blocks: (B:37:0x00a8, B:32:0x0088, B:34:0x0092), top: B:54:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:37:0x00a8, B:32:0x0088, B:34:0x0092), top: B:54:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:13:0x0034, B:49:0x00d7, B:43:0x00b7, B:46:0x00c2), top: B:56:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a5 -> B:54:0x00a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.UA2 r13, ir.nasim.SA2 r14, ir.nasim.InterfaceC20295rm1 r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18765pC7.h(ir.nasim.UA2, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    public final float i() {
        return this.e;
    }

    public final void j(float f2) {
        this.e = f2;
    }
}
