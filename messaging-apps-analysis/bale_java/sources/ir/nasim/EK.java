package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes2.dex */
public final class EK implements InterfaceC9664aL6 {
    private final List a;
    private final C18046nz7 b;
    private final FL c;
    private final UA2 d;
    private final InterfaceC9848af5 e;
    private final InterfaceC9102Ym4 f;
    private boolean g = true;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        int e;
        /* synthetic */ Object f;
        int h;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return EK.this.j(this);
        }
    }

    static final class b extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ InterfaceC8154Ut2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC8154Ut2 interfaceC8154Ut2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = interfaceC8154Ut2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return EK.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                EK ek = EK.this;
                InterfaceC8154Ut2 interfaceC8154Ut2 = this.d;
                this.b = 1;
                obj = ek.z(interfaceC8154Ut2, this);
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

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return EK.this.z(null, this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC8154Ut2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC8154Ut2 interfaceC8154Ut2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC8154Ut2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return EK.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9848af5 interfaceC9848af5 = EK.this.e;
                InterfaceC8154Ut2 interfaceC8154Ut2 = this.d;
                this.b = 1;
                obj = interfaceC9848af5.a(interfaceC8154Ut2, this);
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public EK(List list, Object obj, C18046nz7 c18046nz7, FL fl, UA2 ua2, InterfaceC9848af5 interfaceC9848af5) {
        this.a = list;
        this.b = c18046nz7;
        this.c = fl;
        this.d = ua2;
        this.e = interfaceC9848af5;
        this.f = AbstractC13472gH6.d(obj, null, 2, null);
    }

    private void setValue(Object obj) {
        this.f.setValue(obj);
    }

    @Override // ir.nasim.InterfaceC9664aL6
    public Object getValue() {
        return this.f.getValue();
    }

    public final boolean i() {
        return this.g;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x00f5, TRY_LEAVE, TryCatch #2 {all -> 0x00f5, blocks: (B:28:0x0078, B:30:0x008f, B:35:0x00c1, B:40:0x00f8), top: B:57:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f8 A[Catch: all -> 0x00f5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00f5, blocks: (B:28:0x0078, B:30:0x008f, B:35:0x00c1, B:40:0x00f8), top: B:57:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x010b -> B:44:0x010c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0110 -> B:46:0x0112). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(ir.nasim.InterfaceC20295rm1 r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EK.j(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(ir.nasim.InterfaceC8154Ut2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.EK.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.EK$c r0 = (ir.nasim.EK.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.EK$c r0 = new ir.nasim.EK$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r7 = r0.a
            ir.nasim.Ut2 r7 = (ir.nasim.InterfaceC8154Ut2) r7
            ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.lang.Exception -> L2e java.util.concurrent.CancellationException -> L30
            goto L4f
        L2e:
            r8 = move-exception
            goto L51
        L30:
            r7 = move-exception
            goto L7d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.EK$d r8 = new ir.nasim.EK$d     // Catch: java.lang.Exception -> L2e java.util.concurrent.CancellationException -> L30
            r8.<init>(r7, r4)     // Catch: java.lang.Exception -> L2e java.util.concurrent.CancellationException -> L30
            r0.a = r7     // Catch: java.lang.Exception -> L2e java.util.concurrent.CancellationException -> L30
            r0.d = r3     // Catch: java.lang.Exception -> L2e java.util.concurrent.CancellationException -> L30
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r8 = ir.nasim.AbstractC3860Cq7.e(r2, r8, r0)     // Catch: java.lang.Exception -> L2e java.util.concurrent.CancellationException -> L30
            if (r8 != r1) goto L4f
            return r1
        L4f:
            r4 = r8
            goto L87
        L51:
            ir.nasim.do1 r1 = r0.getContext()
            ir.nasim.ho1$a r2 = ir.nasim.InterfaceC14371ho1.h0
            ir.nasim.do1$b r1 = r1.a(r2)
            ir.nasim.ho1 r1 = (ir.nasim.InterfaceC14371ho1) r1
            if (r1 == 0) goto L87
            ir.nasim.do1 r0 = r0.getContext()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unable to load font "
            r3.append(r5)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r2.<init>(r7, r8)
            r1.m(r0, r2)
            goto L87
        L7d:
            ir.nasim.do1 r8 = r0.getContext()
            boolean r8 = ir.nasim.AbstractC19067pj3.q(r8)
            if (r8 == 0) goto L88
        L87:
            return r4
        L88:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EK.z(ir.nasim.Ut2, ir.nasim.rm1):java.lang.Object");
    }
}
