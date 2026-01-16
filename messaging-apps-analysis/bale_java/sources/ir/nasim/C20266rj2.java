package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.YT4;

/* renamed from: ir.nasim.rj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20266rj2 extends YT4 {
    private final C6613Og2 b;
    private final SF3 c;
    private final InterfaceC20468s37 d;
    private final ir.nasim.jaryan.feed.model.db.a e;
    private final InterfaceC15500jh2 f;
    private final C21544tj2 g;
    private final AbstractC13778go1 h;
    private final Context i;
    private final int j;
    private final C14970in2 k;

    /* renamed from: ir.nasim.rj2$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C20266rj2.this.s(this);
        }
    }

    /* renamed from: ir.nasim.rj2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ YT4.a f;
        final /* synthetic */ C20266rj2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(YT4.a aVar, C20266rj2 c20266rj2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = aVar;
            this.g = c20266rj2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.f, this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01ee A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x021e  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x02e6  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0313 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0314  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0343  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0364  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x036a  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 1010
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20266rj2.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rj2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20266rj2.this.v(null, null, this);
        }
    }

    /* renamed from: ir.nasim.rj2$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20266rj2.this.w(0L, null, this);
        }
    }

    /* renamed from: ir.nasim.rj2$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20266rj2.this.x(this);
        }
    }

    public C20266rj2(C6613Og2 c6613Og2, SF3 sf3, InterfaceC20468s37 interfaceC20468s37, ir.nasim.jaryan.feed.model.db.a aVar, InterfaceC15500jh2 interfaceC15500jh2, C21544tj2 c21544tj2, AbstractC13778go1 abstractC13778go1, Context context, int i, C14970in2 c14970in2) {
        AbstractC13042fc3.i(c6613Og2, "feedApiService");
        AbstractC13042fc3.i(sf3, "loadFeedRequiredGroups");
        AbstractC13042fc3.i(interfaceC20468s37, "feedEntityToFeedUiMapper");
        AbstractC13042fc3.i(aVar, "feedEntityMapper");
        AbstractC13042fc3.i(interfaceC15500jh2, "feedDao");
        AbstractC13042fc3.i(c21544tj2, "feedPreference");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.b = c6613Og2;
        this.c = sf3;
        this.d = interfaceC20468s37;
        this.e = aVar;
        this.f = interfaceC15500jh2;
        this.g = c21544tj2;
        this.h = abstractC13778go1;
        this.i = context;
        this.j = i;
        this.k = c14970in2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C20266rj2.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.rj2$a r0 = (ir.nasim.C20266rj2.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.rj2$a r0 = new ir.nasim.rj2$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.rj2 r0 = (ir.nasim.C20266rj2) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.jh2 r5 = r4.f
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.util.List r5 = (java.util.List) r5
            ir.nasim.in2 r0 = r0.k
            r0.Q(r5)
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20266rj2.s(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XV4 t(int i) {
        return i == 0 ? AbstractC4616Fw7.a(null, 1) : AbstractC4616Fw7.a(Integer.valueOf(i - 1), Integer.valueOf(i + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012f A[Catch: Exception -> 0x015a, TryCatch #0 {Exception -> 0x015a, blocks: (B:55:0x011f, B:59:0x013b, B:58:0x012f), top: B:70:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(byte[] r17, ir.nasim.YT4.a r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20266rj2.v(byte[], ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(long r10, ir.nasim.YT4.a r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20266rj2.w(long, ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[Catch: Exception -> 0x0040, TRY_ENTER, TryCatch #0 {Exception -> 0x0040, blocks: (B:13:0x003b, B:70:0x01b6, B:66:0x01a0, B:63:0x018a, B:46:0x00dc, B:47:0x00f5, B:49:0x00fb, B:50:0x0115), top: B:75:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:18:0x0053, B:23:0x006e, B:26:0x0085, B:54:0x0131, B:56:0x013f, B:58:0x0164, B:60:0x016e, B:57:0x0157), top: B:75:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0157 A[Catch: Exception -> 0x005a, TryCatch #1 {Exception -> 0x005a, blocks: (B:18:0x0053, B:23:0x006e, B:26:0x0085, B:54:0x0131, B:56:0x013f, B:58:0x0164, B:60:0x016e, B:57:0x0157), top: B:75:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016e A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #1 {Exception -> 0x005a, blocks: (B:18:0x0053, B:23:0x006e, B:26:0x0085, B:54:0x0131, B:56:0x013f, B:58:0x0164, B:60:0x016e, B:57:0x0157), top: B:75:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(ir.nasim.InterfaceC20295rm1 r14) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20266rj2.x(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    public Object f(YT4.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.h, new b(aVar, this, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.YT4
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Integer d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
