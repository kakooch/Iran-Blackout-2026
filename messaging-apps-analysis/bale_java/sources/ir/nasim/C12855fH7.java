package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC23654xH7;
import ir.nasim.Q12;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.fH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12855fH7 {
    public static final a f = new a(null);
    public static final int g = 8;
    private static final long h;
    private final b a;
    private final InterfaceC20315ro1 b;
    private final int c;
    private final HashMap d;
    private InterfaceC13730gj3 e;

    /* renamed from: ir.nasim.fH7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fH7$b */
    public interface b {
        void a(Class cls, ZG7 zg7);

        void b();
    }

    /* renamed from: ir.nasim.fH7$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C12855fH7.this.f(null, this);
        }
    }

    /* renamed from: ir.nasim.fH7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ VH7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(VH7 vh7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = vh7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C12855fH7.this.new d(this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC23654xH7 interfaceC23654xH7 = (InterfaceC23654xH7) this.c;
                if (!AbstractC13042fc3.d(interfaceC23654xH7, InterfaceC23654xH7.b.a)) {
                    if (interfaceC23654xH7 instanceof InterfaceC23654xH7.c) {
                        C12855fH7.this.d();
                    } else if (interfaceC23654xH7 instanceof InterfaceC23654xH7.a) {
                        C12855fH7.this.e((InterfaceC23654xH7.a) interfaceC23654xH7);
                    } else {
                        if (!(interfaceC23654xH7 instanceof InterfaceC23654xH7.d)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C12855fH7 c12855fH7 = C12855fH7.this;
                        VH7 vh7 = this.e;
                        this.b = 1;
                        if (c12855fH7.f(vh7, this) == objE) {
                            return objE;
                        }
                    }
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
        public final Object invoke(InterfaceC23654xH7 interfaceC23654xH7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC23654xH7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.fH7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ VH7 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(VH7 vh7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = vh7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12855fH7.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12855fH7 c12855fH7 = C12855fH7.this;
                VH7 vh7 = this.d;
                this.b = 1;
                if (c12855fH7.g(vh7, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        Q12.a aVar = Q12.b;
        h = Q12.A(T12.s(1, W12.f));
    }

    public C12855fH7(b bVar, InterfaceC20315ro1 interfaceC20315ro1, int i) {
        AbstractC13042fc3.i(bVar, "listener");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = bVar;
        this.b = interfaceC20315ro1;
        this.c = i;
        this.d = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(InterfaceC23654xH7.a aVar) {
        int iIntValue = ((Number) this.d.getOrDefault(aVar.a().getClass(), 0)).intValue() + 1;
        if (iIntValue >= this.c) {
            this.a.a(aVar.a().getClass(), aVar.a());
        } else {
            this.d.put(aVar.a().getClass(), Integer.valueOf(iIntValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.VH7 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C12855fH7.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.fH7$c r0 = (ir.nasim.C12855fH7.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.fH7$c r0 = new ir.nasim.fH7$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.b
            ir.nasim.VH7 r7 = (ir.nasim.VH7) r7
            java.lang.Object r2 = r0.a
            ir.nasim.fH7 r2 = (ir.nasim.C12855fH7) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L3d
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            ir.nasim.AbstractC10685c16.b(r8)
            r2 = r6
        L3d:
            ir.nasim.do1 r8 = r0.getContext()
            boolean r8 = ir.nasim.AbstractC19067pj3.q(r8)
            if (r8 == 0) goto L64
            boolean r8 = r7.b()
            if (r8 != 0) goto L55
            ir.nasim.fH7$b r7 = r2.a
            r7.b()
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L55:
            long r4 = ir.nasim.C12855fH7.h
            r0.a = r2
            r0.b = r7
            r0.e = r3
            java.lang.Object r8 = ir.nasim.HG1.b(r4, r0)
            if (r8 != r1) goto L3d
            return r1
        L64:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12855fH7.f(ir.nasim.VH7, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(VH7 vh7, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(vh7.a(), new d(vh7, null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    public final void d() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.e;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.e = null;
    }

    public final InterfaceC13730gj3 h(VH7 vh7) {
        AbstractC13042fc3.i(vh7, "uploader");
        InterfaceC13730gj3 interfaceC13730gj3 = this.e;
        if (interfaceC13730gj3 != null) {
            if (!interfaceC13730gj3.b()) {
                interfaceC13730gj3 = null;
            }
            if (interfaceC13730gj3 != null) {
                return interfaceC13730gj3;
            }
        }
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.b, null, null, new e(vh7, null), 3, null);
        this.e = interfaceC13730gj3D;
        return interfaceC13730gj3D;
    }

    public /* synthetic */ C12855fH7(b bVar, InterfaceC20315ro1 interfaceC20315ro1, int i, int i2, ED1 ed1) {
        this(bVar, interfaceC20315ro1, (i2 & 4) != 0 ? 10 : i);
    }
}
