package androidx.compose.foundation.layout;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.EnumC12613eu3;
import ir.nasim.T93;
import ir.nasim.TS4;
import ir.nasim.UA2;
import ir.nasim.US4;

/* loaded from: classes.dex */
public abstract class q {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;
        final /* synthetic */ float h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, float f2, float f3, float f4) {
            super(1);
            this.e = f;
            this.f = f2;
            this.g = f3;
            this.h = f4;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ float f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f, float f2) {
            super(1);
            this.e = f;
            this.f = f2;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(float f) {
            super(1);
            this.e = f;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ TS4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(TS4 ts4) {
            super(1);
            this.e = ts4;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    public static final TS4 a(float f) {
        return new US4(f, f, f, f, null);
    }

    public static final TS4 b(float f, float f2) {
        return new US4(f, f2, f, f2, null);
    }

    public static /* synthetic */ TS4 c(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        return b(f, f2);
    }

    public static final TS4 d(float f, float f2, float f3, float f4) {
        return new US4(f, f2, f3, f4, null);
    }

    public static /* synthetic */ TS4 e(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        if ((i & 4) != 0) {
            f3 = C17784nZ1.q(0);
        }
        if ((i & 8) != 0) {
            f4 = C17784nZ1.q(0);
        }
        return d(f, f2, f3, f4);
    }

    public static final float f(TS4 ts4, EnumC12613eu3 enumC12613eu3) {
        return enumC12613eu3 == EnumC12613eu3.a ? ts4.b(enumC12613eu3) : ts4.d(enumC12613eu3);
    }

    public static final float g(TS4 ts4, EnumC12613eu3 enumC12613eu3) {
        return enumC12613eu3 == EnumC12613eu3.a ? ts4.d(enumC12613eu3) : ts4.b(enumC12613eu3);
    }

    public static final androidx.compose.ui.e h(androidx.compose.ui.e eVar, TS4 ts4) {
        return eVar.i(new PaddingValuesElement(ts4, new d(ts4)));
    }

    public static final androidx.compose.ui.e i(androidx.compose.ui.e eVar, float f) {
        return eVar.i(new PaddingElement(f, f, f, f, true, new c(f), null));
    }

    public static final androidx.compose.ui.e j(androidx.compose.ui.e eVar, float f, float f2) {
        return eVar.i(new PaddingElement(f, f2, f, f2, true, new b(f, f2), null));
    }

    public static /* synthetic */ androidx.compose.ui.e k(androidx.compose.ui.e eVar, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        return j(eVar, f, f2);
    }

    public static final androidx.compose.ui.e l(androidx.compose.ui.e eVar, float f, float f2, float f3, float f4) {
        return eVar.i(new PaddingElement(f, f2, f3, f4, true, new a(f, f2, f3, f4), null));
    }

    public static /* synthetic */ androidx.compose.ui.e m(androidx.compose.ui.e eVar, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        if ((i & 4) != 0) {
            f3 = C17784nZ1.q(0);
        }
        if ((i & 8) != 0) {
            f4 = C17784nZ1.q(0);
        }
        return l(eVar, f, f2, f3, f4);
    }
}
