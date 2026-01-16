package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.hm1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14351hm1 {

    /* renamed from: ir.nasim.hm1$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C12531em1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C12531em1 c12531em1) {
            super(0);
            this.e = c12531em1;
        }

        public final void a() {
            AbstractC13167fm1.a(this.e);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hm1$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC20315ro1 e;
        final /* synthetic */ InterfaceC9102Ym4 f;
        final /* synthetic */ C19101pm7 g;

        /* renamed from: ir.nasim.hm1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ InterfaceC9102Ym4 d;
            final /* synthetic */ C19101pm7 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, C19101pm7 c19101pm7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC9102Ym4;
                this.e = c19101pm7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC9102Ym4 interfaceC9102Ym4;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9102Ym4 interfaceC9102Ym42 = this.d;
                    C19101pm7 c19101pm7 = this.e;
                    this.b = interfaceC9102Ym42;
                    this.c = 1;
                    Object objB = AbstractC14351hm1.b(c19101pm7, this);
                    if (objB == objE) {
                        return objE;
                    }
                    interfaceC9102Ym4 = interfaceC9102Ym42;
                    obj = objB;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC9102Ym4 = (InterfaceC9102Ym4) this.b;
                    AbstractC10685c16.b(obj);
                }
                interfaceC9102Ym4.setValue(obj);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, C19101pm7 c19101pm7) {
            super(0);
            this.e = interfaceC20315ro1;
            this.f = interfaceC9102Ym4;
            this.g = c19101pm7;
        }

        public final void a() {
            AbstractC10533bm0.d(this.e, null, EnumC23959xo1.UNDISPATCHED, new a(this.f, this.g, null), 1, null);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hm1$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19101pm7 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C19101pm7 c19101pm7, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = c19101pm7;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14351hm1.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hm1$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        int b;
        int c;
        int d;
        /* synthetic */ Object e;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC14351hm1.b(null, this);
        }
    }

    public static final void a(C19101pm7 c19101pm7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1985516685);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c19101pm7) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i2 & 19) != 18, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1985516685, i2, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:43)");
            }
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C12531em1(null, 1, null);
                interfaceC22053ub1J.s(objB);
            }
            C12531em1 c12531em1 = (C12531em1) objB;
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1J);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB2;
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(C22342v44.b(C22342v44.b.a()), null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB3;
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new a(c12531em1);
                interfaceC22053ub1J.s(objB4);
            }
            SA2 sa2 = (SA2) objB4;
            UA2 ua2A = AbstractC20301rm7.a(c19101pm7, c12531em1, interfaceC9102Ym4);
            boolean zH = c19101pm7.H();
            boolean zD = interfaceC22053ub1J.D(interfaceC20315ro1) | interfaceC22053ub1J.D(c19101pm7);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD || objB5 == aVar.a()) {
                objB5 = new b(interfaceC20315ro1, interfaceC9102Ym4, c19101pm7);
                interfaceC22053ub1J.s(objB5);
            }
            AbstractC6402Nl1.b(c12531em1, sa2, ua2A, null, zH, (SA2) objB5, interfaceC14603iB2, interfaceC22053ub1J, ((i2 << 15) & 3670016) | 54, 8);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(c19101pm7, interfaceC14603iB2, i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093 A[PHI: r2 r5 r8 r9
      0x0093: PHI (r2v3 ??) = (r2v1 ??), (r2v9 ??) binds: [B:20:0x005d, B:35:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r5v5 int) = (r5v2 int), (r5v7 int) binds: [B:20:0x005d, B:35:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r8v3 ir.nasim.pm7) = (r8v0 ir.nasim.pm7), (r8v9 ir.nasim.pm7) binds: [B:20:0x005d, B:35:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0093: PHI (r9v8 int) = (r9v5 int), (r9v14 int) binds: [B:20:0x005d, B:35:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.C19101pm7 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14351hm1.b(ir.nasim.pm7, ir.nasim.rm1):java.lang.Object");
    }
}
