package androidx.compose.animation;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC13854gv7;
import ir.nasim.AbstractC4139Dv7;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC5999Lt;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14638iE6;
import ir.nasim.C14865ic6;
import ir.nasim.C15866kJ0;
import ir.nasim.C18827pJ6;
import ir.nasim.C19938rB7;
import ir.nasim.C21669tv7;
import ir.nasim.C22045ua3;
import ir.nasim.C22094uf2;
import ir.nasim.C3432Av7;
import ir.nasim.C4414Fa3;
import ir.nasim.C7444Rt;
import ir.nasim.EnumC17550n92;
import ir.nasim.IY7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC21900uK2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4788Go2;
import ir.nasim.InterfaceC5342Ix7;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.PQ7;
import ir.nasim.SA2;
import ir.nasim.UA2;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
public abstract class f {
    private static final InterfaceC5342Ix7 a = PQ7.a(C1924a.e, C1925b.e);
    private static final C18827pJ6 b = AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null);
    private static final C18827pJ6 c = AbstractC5999Lt.j(0.0f, 400.0f, C22045ua3.c(IY7.c(C22045ua3.b)), 1, null);
    private static final C18827pJ6 d = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);

    static final class A extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        A(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C22045ua3.f((((Number) this.e.invoke(Integer.valueOf((int) (j >> 32)))).intValue() << 32) | (0 & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class B extends AbstractC8614Ws3 implements UA2 {
        public static final B e = new B();

        B() {
            super(1);
        }

        public final Integer a(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class C extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C22045ua3.f((((Number) this.e.invoke(Integer.valueOf((int) (j & 4294967295L)))).intValue() & 4294967295L) | (0 << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a(((C4414Fa3) obj).j()));
        }
    }

    /* renamed from: androidx.compose.animation.f$a, reason: case insensitive filesystem */
    static final class C1924a extends AbstractC8614Ws3 implements UA2 {
        public static final C1924a e = new C1924a();

        C1924a() {
            super(1);
        }

        public final C7444Rt a(long j) {
            return new C7444Rt(androidx.compose.ui.graphics.f.f(j), androidx.compose.ui.graphics.f.g(j));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((androidx.compose.ui.graphics.f) obj).j());
        }
    }

    /* renamed from: androidx.compose.animation.f$b, reason: case insensitive filesystem */
    static final class C1925b extends AbstractC8614Ws3 implements UA2 {
        public static final C1925b e = new C1925b();

        C1925b() {
            super(1);
        }

        public final long a(C7444Rt c7444Rt) {
            return AbstractC13854gv7.a(c7444Rt.f(), c7444Rt.g());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return androidx.compose.ui.graphics.f.b(a((C7444Rt) obj));
        }
    }

    /* renamed from: androidx.compose.animation.f$c, reason: case insensitive filesystem */
    static final class C1926c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.compose.animation.h e;
        final /* synthetic */ androidx.compose.animation.j f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1926c(androidx.compose.animation.h hVar, androidx.compose.animation.j jVar) {
            super(1);
            this.e = hVar;
            this.f = jVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
            InterfaceC4788Go2 interfaceC4788Go2B;
            InterfaceC4788Go2 interfaceC4788Go2B2;
            EnumC17550n92 enumC17550n92 = EnumC17550n92.a;
            EnumC17550n92 enumC17550n922 = EnumC17550n92.b;
            if (bVar.c(enumC17550n92, enumC17550n922)) {
                C22094uf2 c22094uf2C = this.e.b().c();
                return (c22094uf2C == null || (interfaceC4788Go2B2 = c22094uf2C.b()) == null) ? f.b : interfaceC4788Go2B2;
            }
            if (!bVar.c(enumC17550n922, EnumC17550n92.c)) {
                return f.b;
            }
            C22094uf2 c22094uf2C2 = this.f.b().c();
            return (c22094uf2C2 == null || (interfaceC4788Go2B = c22094uf2C2.b()) == null) ? f.b : interfaceC4788Go2B;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.compose.animation.h e;
        final /* synthetic */ androidx.compose.animation.j f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC17550n92.values().length];
                try {
                    iArr[EnumC17550n92.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC17550n92.a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC17550n92.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(androidx.compose.animation.h hVar, androidx.compose.animation.j jVar) {
            super(1);
            this.e = hVar;
            this.f = jVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke(EnumC17550n92 enumC17550n92) {
            int i = a.a[enumC17550n92.ordinal()];
            float fA = 1.0f;
            if (i != 1) {
                if (i == 2) {
                    C22094uf2 c22094uf2C = this.e.b().c();
                    if (c22094uf2C != null) {
                        fA = c22094uf2C.a();
                    }
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C22094uf2 c22094uf2C2 = this.f.b().c();
                    if (c22094uf2C2 != null) {
                        fA = c22094uf2C2.a();
                    }
                }
            }
            return Float.valueOf(fA);
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63) {
            super(1);
            this.e = interfaceC9664aL6;
            this.f = interfaceC9664aL62;
            this.g = interfaceC9664aL63;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            InterfaceC9664aL6 interfaceC9664aL6 = this.e;
            cVar.c(interfaceC9664aL6 != null ? ((Number) interfaceC9664aL6.getValue()).floatValue() : 1.0f);
            InterfaceC9664aL6 interfaceC9664aL62 = this.f;
            cVar.g(interfaceC9664aL62 != null ? ((Number) interfaceC9664aL62.getValue()).floatValue() : 1.0f);
            InterfaceC9664aL6 interfaceC9664aL63 = this.f;
            cVar.m(interfaceC9664aL63 != null ? ((Number) interfaceC9664aL63.getValue()).floatValue() : 1.0f);
            InterfaceC9664aL6 interfaceC9664aL64 = this.g;
            cVar.C0(interfaceC9664aL64 != null ? ((androidx.compose.ui.graphics.f) interfaceC9664aL64.getValue()).j() : androidx.compose.ui.graphics.f.b.a());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: androidx.compose.animation.f$f, reason: collision with other inner class name */
    static final class C0027f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.compose.animation.h e;
        final /* synthetic */ androidx.compose.animation.j f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0027f(androidx.compose.animation.h hVar, androidx.compose.animation.j jVar) {
            super(1);
            this.e = hVar;
            this.f = jVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
            InterfaceC4788Go2 interfaceC4788Go2A;
            InterfaceC4788Go2 interfaceC4788Go2A2;
            EnumC17550n92 enumC17550n92 = EnumC17550n92.a;
            EnumC17550n92 enumC17550n922 = EnumC17550n92.b;
            if (bVar.c(enumC17550n92, enumC17550n922)) {
                C14865ic6 c14865ic6E = this.e.b().e();
                return (c14865ic6E == null || (interfaceC4788Go2A2 = c14865ic6E.a()) == null) ? f.b : interfaceC4788Go2A2;
            }
            if (!bVar.c(enumC17550n922, EnumC17550n92.c)) {
                return f.b;
            }
            C14865ic6 c14865ic6E2 = this.f.b().e();
            return (c14865ic6E2 == null || (interfaceC4788Go2A = c14865ic6E2.a()) == null) ? f.b : interfaceC4788Go2A;
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.compose.animation.h e;
        final /* synthetic */ androidx.compose.animation.j f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC17550n92.values().length];
                try {
                    iArr[EnumC17550n92.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC17550n92.a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC17550n92.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(androidx.compose.animation.h hVar, androidx.compose.animation.j jVar) {
            super(1);
            this.e = hVar;
            this.f = jVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke(EnumC17550n92 enumC17550n92) {
            int i = a.a[enumC17550n92.ordinal()];
            float fB = 1.0f;
            if (i != 1) {
                if (i == 2) {
                    C14865ic6 c14865ic6E = this.e.b().e();
                    if (c14865ic6E != null) {
                        fB = c14865ic6E.b();
                    }
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C14865ic6 c14865ic6E2 = this.f.b().e();
                    if (c14865ic6E2 != null) {
                        fB = c14865ic6E2.b();
                    }
                }
            }
            return Float.valueOf(fB);
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
            return AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.compose.ui.graphics.f e;
        final /* synthetic */ androidx.compose.animation.h f;
        final /* synthetic */ androidx.compose.animation.j g;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC17550n92.values().length];
                try {
                    iArr[EnumC17550n92.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC17550n92.a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC17550n92.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(androidx.compose.ui.graphics.f fVar, androidx.compose.animation.h hVar, androidx.compose.animation.j jVar) {
            super(1);
            this.e = fVar;
            this.f = hVar;
            this.g = jVar;
        }

        public final long a(EnumC17550n92 enumC17550n92) {
            androidx.compose.ui.graphics.f fVarB;
            int i = a.a[enumC17550n92.ordinal()];
            if (i != 1) {
                fVarB = null;
                if (i == 2) {
                    C14865ic6 c14865ic6E = this.f.b().e();
                    if (c14865ic6E != null || (c14865ic6E = this.g.b().e()) != null) {
                        fVarB = androidx.compose.ui.graphics.f.b(c14865ic6E.c());
                    }
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C14865ic6 c14865ic6E2 = this.g.b().e();
                    if (c14865ic6E2 != null || (c14865ic6E2 = this.f.b().e()) != null) {
                        fVarB = androidx.compose.ui.graphics.f.b(c14865ic6E2.c());
                    }
                }
            } else {
                fVarB = this.e;
            }
            return fVarB != null ? fVarB.j() : androidx.compose.ui.graphics.f.b.a();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return androidx.compose.ui.graphics.f.b(a((EnumC17550n92) obj));
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        public static final j e = new j();

        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(boolean z, SA2 sa2) {
            super(1);
            this.e = z;
            this.f = sa2;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            cVar.x(!this.e && ((Boolean) this.f.invoke()).booleanValue());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class l extends AbstractC8614Ws3 implements UA2 {
        public static final l e = new l();

        l() {
            super(1);
        }

        public final Integer a(int i) {
            return 0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class m extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C4414Fa3.c((((int) (j & 4294967295L)) & 4294967295L) | (((Number) this.e.invoke(Integer.valueOf((int) (j >> 32)))).intValue() << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class n extends AbstractC8614Ws3 implements UA2 {
        public static final n e = new n();

        n() {
            super(1);
        }

        public final long a(long j) {
            long j2 = 0;
            return C4414Fa3.c((j2 & 4294967295L) | (j2 << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class o extends AbstractC8614Ws3 implements UA2 {
        public static final o e = new o();

        o() {
            super(1);
        }

        public final Integer a(int i) {
            return 0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class p extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C4414Fa3.c((((Number) this.e.invoke(Integer.valueOf((int) (j & 4294967295L)))).intValue() & 4294967295L) | (((int) (j >> 32)) << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class q extends AbstractC8614Ws3 implements UA2 {
        public static final q e = new q();

        q() {
            super(1);
        }

        public final Integer a(int i) {
            return 0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class r extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C4414Fa3.c((((int) (j & 4294967295L)) & 4294967295L) | (((Number) this.e.invoke(Integer.valueOf((int) (j >> 32)))).intValue() << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class s extends AbstractC8614Ws3 implements UA2 {
        public static final s e = new s();

        s() {
            super(1);
        }

        public final long a(long j) {
            long j2 = 0;
            return C4414Fa3.c((j2 & 4294967295L) | (j2 << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class t extends AbstractC8614Ws3 implements UA2 {
        public static final t e = new t();

        t() {
            super(1);
        }

        public final Integer a(int i) {
            return 0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class u extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C4414Fa3.c((((Number) this.e.invoke(Integer.valueOf((int) (j & 4294967295L)))).intValue() & 4294967295L) | (((int) (j >> 32)) << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C4414Fa3.b(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class v extends AbstractC8614Ws3 implements UA2 {
        public static final v e = new v();

        v() {
            super(1);
        }

        public final Integer a(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class w extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C22045ua3.f((((Number) this.e.invoke(Integer.valueOf((int) (j >> 32)))).intValue() << 32) | (0 & 4294967295L));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class x extends AbstractC8614Ws3 implements UA2 {
        public static final x e = new x();

        x() {
            super(1);
        }

        public final Integer a(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class y extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final long a(long j) {
            return C22045ua3.f((((Number) this.e.invoke(Integer.valueOf((int) (j & 4294967295L)))).intValue() & 4294967295L) | (0 << 32));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C22045ua3.c(a(((C4414Fa3) obj).j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class z extends AbstractC8614Ws3 implements UA2 {
        public static final z e = new z();

        z() {
            super(1);
        }

        public final Integer a(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final androidx.compose.animation.h A(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2) {
        return z(interfaceC4788Go2, new w(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.h B(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C22045ua3.c(IY7.c(C22045ua3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            ua2 = v.e;
        }
        return A(interfaceC4788Go2, ua2);
    }

    public static final androidx.compose.animation.h C(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2) {
        return z(interfaceC4788Go2, new y(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.h D(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C22045ua3.c(IY7.c(C22045ua3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            ua2 = x.e;
        }
        return C(interfaceC4788Go2, ua2);
    }

    public static final androidx.compose.animation.j E(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2) {
        return new androidx.compose.animation.k(new C3432Av7(null, new C14638iE6(ua2, interfaceC4788Go2), null, null, false, null, 61, null));
    }

    public static final androidx.compose.animation.j F(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2) {
        return E(interfaceC4788Go2, new A(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.j G(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C22045ua3.c(IY7.c(C22045ua3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            ua2 = z.e;
        }
        return F(interfaceC4788Go2, ua2);
    }

    public static final androidx.compose.animation.j H(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2) {
        return E(interfaceC4788Go2, new C(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.j I(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C22045ua3.c(IY7.c(C22045ua3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            ua2 = B.e;
        }
        return H(interfaceC4788Go2, ua2);
    }

    private static final InterfaceC12529em J(InterfaceC12529em.b bVar) {
        InterfaceC12529em.a aVar = InterfaceC12529em.a;
        return AbstractC13042fc3.d(bVar, aVar.k()) ? aVar.h() : AbstractC13042fc3.d(bVar, aVar.j()) ? aVar.f() : aVar.e();
    }

    private static final InterfaceC12529em K(InterfaceC12529em.c cVar) {
        InterfaceC12529em.a aVar = InterfaceC12529em.a;
        return AbstractC13042fc3.d(cVar, aVar.l()) ? aVar.m() : AbstractC13042fc3.d(cVar, aVar.a()) ? aVar.b() : aVar.e();
    }

    public static final androidx.compose.animation.h L(C21669tv7 c21669tv7, androidx.compose.animation.h hVar, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(21614502, i2, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:908)");
        }
        boolean z2 = (((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.V(c21669tv7)) || (i2 & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC13472gH6.d(hVar, null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        if (c21669tv7.h() == c21669tv7.o() && c21669tv7.h() == EnumC17550n92.b) {
            if (c21669tv7.u()) {
                N(interfaceC9102Ym4, hVar);
            } else {
                N(interfaceC9102Ym4, androidx.compose.animation.h.a.a());
            }
        } else if (c21669tv7.o() == EnumC17550n92.b) {
            N(interfaceC9102Ym4, M(interfaceC9102Ym4).c(hVar));
        }
        androidx.compose.animation.h hVarM = M(interfaceC9102Ym4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return hVarM;
    }

    private static final androidx.compose.animation.h M(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (androidx.compose.animation.h) interfaceC9102Ym4.getValue();
    }

    private static final void N(InterfaceC9102Ym4 interfaceC9102Ym4, androidx.compose.animation.h hVar) {
        interfaceC9102Ym4.setValue(hVar);
    }

    public static final androidx.compose.animation.j O(C21669tv7 c21669tv7, androidx.compose.animation.j jVar, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1363864804, i2, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:928)");
        }
        boolean z2 = (((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.V(c21669tv7)) || (i2 & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC13472gH6.d(jVar, null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        if (c21669tv7.h() == c21669tv7.o() && c21669tv7.h() == EnumC17550n92.b) {
            if (c21669tv7.u()) {
                Q(interfaceC9102Ym4, jVar);
            } else {
                Q(interfaceC9102Ym4, androidx.compose.animation.j.a.a());
            }
        } else if (c21669tv7.o() != EnumC17550n92.b) {
            Q(interfaceC9102Ym4, P(interfaceC9102Ym4).c(jVar));
        }
        androidx.compose.animation.j jVarP = P(interfaceC9102Ym4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jVarP;
    }

    private static final androidx.compose.animation.j P(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (androidx.compose.animation.j) interfaceC9102Ym4.getValue();
    }

    private static final void Q(InterfaceC9102Ym4 interfaceC9102Ym4, androidx.compose.animation.j jVar) {
        interfaceC9102Ym4.setValue(jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final ir.nasim.InterfaceC21900uK2 e(final ir.nasim.C21669tv7 r20, final androidx.compose.animation.h r21, final androidx.compose.animation.j r22, java.lang.String r23, ir.nasim.InterfaceC22053ub1 r24, int r25) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.f.e(ir.nasim.tv7, androidx.compose.animation.h, androidx.compose.animation.j, java.lang.String, ir.nasim.ub1, int):ir.nasim.uK2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.UA2 f(ir.nasim.C21669tv7.a r3, ir.nasim.C21669tv7.a r4, ir.nasim.C21669tv7 r5, androidx.compose.animation.h r6, androidx.compose.animation.j r7, ir.nasim.C21669tv7.a r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L12
            androidx.compose.animation.f$c r1 = new androidx.compose.animation.f$c
            r1.<init>(r6, r7)
            androidx.compose.animation.f$d r2 = new androidx.compose.animation.f$d
            r2.<init>(r6, r7)
            ir.nasim.aL6 r3 = r3.a(r1, r2)
            goto L13
        L12:
            r3 = r0
        L13:
            if (r4 == 0) goto L24
            androidx.compose.animation.f$f r1 = new androidx.compose.animation.f$f
            r1.<init>(r6, r7)
            androidx.compose.animation.f$g r2 = new androidx.compose.animation.f$g
            r2.<init>(r6, r7)
            ir.nasim.aL6 r4 = r4.a(r1, r2)
            goto L25
        L24:
            r4 = r0
        L25:
            java.lang.Object r5 = r5.h()
            ir.nasim.n92 r1 = ir.nasim.EnumC17550n92.a
            if (r5 != r1) goto L4d
            ir.nasim.Av7 r5 = r6.b()
            ir.nasim.ic6 r5 = r5.e()
            if (r5 == 0) goto L40
        L37:
            long r1 = r5.c()
            androidx.compose.ui.graphics.f r5 = androidx.compose.ui.graphics.f.b(r1)
            goto L6b
        L40:
            ir.nasim.Av7 r5 = r7.b()
            ir.nasim.ic6 r5 = r5.e()
            if (r5 == 0) goto L4b
            goto L37
        L4b:
            r5 = r0
            goto L6b
        L4d:
            ir.nasim.Av7 r5 = r7.b()
            ir.nasim.ic6 r5 = r5.e()
            if (r5 == 0) goto L60
        L57:
            long r1 = r5.c()
            androidx.compose.ui.graphics.f r5 = androidx.compose.ui.graphics.f.b(r1)
            goto L6b
        L60:
            ir.nasim.Av7 r5 = r6.b()
            ir.nasim.ic6 r5 = r5.e()
            if (r5 == 0) goto L4b
            goto L57
        L6b:
            if (r8 == 0) goto L78
            androidx.compose.animation.f$h r0 = androidx.compose.animation.f.h.e
            androidx.compose.animation.f$i r1 = new androidx.compose.animation.f$i
            r1.<init>(r5, r6, r7)
            ir.nasim.aL6 r0 = r8.a(r0, r1)
        L78:
            androidx.compose.animation.f$e r5 = new androidx.compose.animation.f$e
            r5.<init>(r3, r4, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.f.f(ir.nasim.tv7$a, ir.nasim.tv7$a, ir.nasim.tv7, androidx.compose.animation.h, androidx.compose.animation.j, ir.nasim.tv7$a):ir.nasim.UA2");
    }

    public static final androidx.compose.ui.e g(C21669tv7 c21669tv7, androidx.compose.animation.h hVar, androidx.compose.animation.j jVar, SA2 sa2, String str, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        C21669tv7.a aVar;
        C21669tv7.a aVar2;
        C15866kJ0 c15866kJ0A;
        SA2 sa22 = (i3 & 4) != 0 ? j.e : sa2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(28261782, i2, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:860)");
        }
        int i4 = i2 & 14;
        androidx.compose.animation.h hVarL = L(c21669tv7, hVar, interfaceC22053ub1, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | i4);
        int i5 = i2 >> 3;
        androidx.compose.animation.j jVarO = O(c21669tv7, jVar, interfaceC22053ub1, (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | i4);
        boolean z2 = true;
        boolean z3 = (hVarL.b().f() == null && jVarO.b().f() == null) ? false : true;
        boolean z4 = (hVarL.b().a() == null && jVarO.b().a() == null) ? false : true;
        C21669tv7.a aVar3 = null;
        if (z3) {
            interfaceC22053ub1.W(-821159459);
            InterfaceC5342Ix7 interfaceC5342Ix7F = PQ7.f(C22045ua3.b);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = str + " slide";
                interfaceC22053ub1.s(objB);
            }
            C21669tv7.a aVarD = AbstractC4139Dv7.d(c21669tv7, interfaceC5342Ix7F, (String) objB, interfaceC22053ub1, i4 | 384, 0);
            interfaceC22053ub1.Q();
            aVar = aVarD;
        } else {
            interfaceC22053ub1.W(-821053656);
            interfaceC22053ub1.Q();
            aVar = null;
        }
        if (z4) {
            interfaceC22053ub1.W(-820961865);
            InterfaceC5342Ix7 interfaceC5342Ix7G = PQ7.g(C4414Fa3.b);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = str + " shrink/expand";
                interfaceC22053ub1.s(objB2);
            }
            C21669tv7.a aVarD2 = AbstractC4139Dv7.d(c21669tv7, interfaceC5342Ix7G, (String) objB2, interfaceC22053ub1, i4 | 384, 0);
            interfaceC22053ub1.Q();
            aVar2 = aVarD2;
        } else {
            interfaceC22053ub1.W(-820851041);
            interfaceC22053ub1.Q();
            aVar2 = null;
        }
        if (z4) {
            interfaceC22053ub1.W(-820777446);
            InterfaceC5342Ix7 interfaceC5342Ix7F2 = PQ7.f(C22045ua3.b);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = str + " InterruptionHandlingOffset";
                interfaceC22053ub1.s(objB3);
            }
            C21669tv7.a aVarD3 = AbstractC4139Dv7.d(c21669tv7, interfaceC5342Ix7F2, (String) objB3, interfaceC22053ub1, i4 | 384, 0);
            interfaceC22053ub1.Q();
            aVar3 = aVarD3;
        } else {
            interfaceC22053ub1.W(-820608001);
            interfaceC22053ub1.Q();
        }
        C15866kJ0 c15866kJ0A2 = hVarL.b().a();
        boolean z5 = ((c15866kJ0A2 == null || c15866kJ0A2.c()) && ((c15866kJ0A = jVarO.b().a()) == null || c15866kJ0A.c()) && z4) ? false : true;
        InterfaceC21900uK2 interfaceC21900uK2E = e(c21669tv7, hVarL, jVarO, str, interfaceC22053ub1, i4 | (i5 & 7168));
        e.a aVar4 = androidx.compose.ui.e.a;
        boolean zA = interfaceC22053ub1.a(z5);
        if ((((i2 & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) <= 2048 || !interfaceC22053ub1.V(sa22)) && (i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) != 2048) {
            z2 = false;
        }
        boolean z6 = zA | z2;
        Object objB4 = interfaceC22053ub1.B();
        if (z6 || objB4 == InterfaceC22053ub1.a.a()) {
            objB4 = new k(z5, sa22);
            interfaceC22053ub1.s(objB4);
        }
        androidx.compose.ui.e eVarI = androidx.compose.ui.graphics.b.a(aVar4, (UA2) objB4).i(new EnterExitTransitionElement(c21669tv7, aVar2, aVar3, aVar, hVarL, jVarO, sa22, interfaceC21900uK2E));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return eVarI;
    }

    public static final androidx.compose.animation.h h(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.b bVar, boolean z2, UA2 ua2) {
        return j(interfaceC4788Go2, J(bVar), z2, new m(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.h i(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.b bVar, boolean z2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            bVar = InterfaceC12529em.a.j();
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            ua2 = l.e;
        }
        return h(interfaceC4788Go2, bVar, z2, ua2);
    }

    public static final androidx.compose.animation.h j(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em interfaceC12529em, boolean z2, UA2 ua2) {
        return new androidx.compose.animation.i(new C3432Av7(null, null, new C15866kJ0(interfaceC12529em, ua2, interfaceC4788Go2, z2), null, false, null, 59, null));
    }

    public static /* synthetic */ androidx.compose.animation.h k(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em interfaceC12529em, boolean z2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            interfaceC12529em = InterfaceC12529em.a.c();
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            ua2 = n.e;
        }
        return j(interfaceC4788Go2, interfaceC12529em, z2, ua2);
    }

    public static final androidx.compose.animation.h l(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.c cVar, boolean z2, UA2 ua2) {
        return j(interfaceC4788Go2, K(cVar), z2, new p(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.h m(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.c cVar, boolean z2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            cVar = InterfaceC12529em.a.a();
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            ua2 = o.e;
        }
        return l(interfaceC4788Go2, cVar, z2, ua2);
    }

    public static final androidx.compose.animation.h n(InterfaceC4788Go2 interfaceC4788Go2, float f) {
        return new androidx.compose.animation.i(new C3432Av7(new C22094uf2(f, interfaceC4788Go2), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ androidx.compose.animation.h o(InterfaceC4788Go2 interfaceC4788Go2, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null);
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return n(interfaceC4788Go2, f);
    }

    public static final androidx.compose.animation.j p(InterfaceC4788Go2 interfaceC4788Go2, float f) {
        return new androidx.compose.animation.k(new C3432Av7(new C22094uf2(f, interfaceC4788Go2), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ androidx.compose.animation.j q(InterfaceC4788Go2 interfaceC4788Go2, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null);
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return p(interfaceC4788Go2, f);
    }

    public static final androidx.compose.animation.h r(InterfaceC4788Go2 interfaceC4788Go2, float f, long j2) {
        return new androidx.compose.animation.i(new C3432Av7(null, null, null, new C14865ic6(f, j2, interfaceC4788Go2, null), false, null, 55, null));
    }

    public static /* synthetic */ androidx.compose.animation.h s(InterfaceC4788Go2 interfaceC4788Go2, float f, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null);
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            j2 = androidx.compose.ui.graphics.f.b.a();
        }
        return r(interfaceC4788Go2, f, j2);
    }

    public static final androidx.compose.animation.j t(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.b bVar, boolean z2, UA2 ua2) {
        return v(interfaceC4788Go2, J(bVar), z2, new r(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.j u(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.b bVar, boolean z2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            bVar = InterfaceC12529em.a.j();
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            ua2 = q.e;
        }
        return t(interfaceC4788Go2, bVar, z2, ua2);
    }

    public static final androidx.compose.animation.j v(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em interfaceC12529em, boolean z2, UA2 ua2) {
        return new androidx.compose.animation.k(new C3432Av7(null, null, new C15866kJ0(interfaceC12529em, ua2, interfaceC4788Go2, z2), null, false, null, 59, null));
    }

    public static /* synthetic */ androidx.compose.animation.j w(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em interfaceC12529em, boolean z2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            interfaceC12529em = InterfaceC12529em.a.c();
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            ua2 = s.e;
        }
        return v(interfaceC4788Go2, interfaceC12529em, z2, ua2);
    }

    public static final androidx.compose.animation.j x(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.c cVar, boolean z2, UA2 ua2) {
        return v(interfaceC4788Go2, K(cVar), z2, new u(ua2));
    }

    public static /* synthetic */ androidx.compose.animation.j y(InterfaceC4788Go2 interfaceC4788Go2, InterfaceC12529em.c cVar, boolean z2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC4788Go2 = AbstractC5999Lt.j(0.0f, 400.0f, C4414Fa3.b(IY7.d(C4414Fa3.b)), 1, null);
        }
        if ((i2 & 2) != 0) {
            cVar = InterfaceC12529em.a.a();
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            ua2 = t.e;
        }
        return x(interfaceC4788Go2, cVar, z2, ua2);
    }

    public static final androidx.compose.animation.h z(InterfaceC4788Go2 interfaceC4788Go2, UA2 ua2) {
        return new androidx.compose.animation.i(new C3432Av7(null, new C14638iE6(ua2, interfaceC4788Go2), null, null, false, null, 61, null));
    }
}
