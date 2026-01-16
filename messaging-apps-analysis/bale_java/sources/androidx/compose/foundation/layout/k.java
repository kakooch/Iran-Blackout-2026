package androidx.compose.foundation.layout;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.EnumC11821dc3;
import ir.nasim.Q93;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class k {

    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ EnumC11821dc3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EnumC11821dc3 enumC11821dc3) {
            super(1);
            this.e = enumC11821dc3;
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

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ EnumC11821dc3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EnumC11821dc3 enumC11821dc3) {
            super(1);
            this.e = enumC11821dc3;
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

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, EnumC11821dc3 enumC11821dc3) {
        return eVar.i(new IntrinsicHeightElement(enumC11821dc3, true, Q93.b() ? new a(enumC11821dc3) : Q93.a()));
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, EnumC11821dc3 enumC11821dc3) {
        return eVar.i(new IntrinsicWidthElement(enumC11821dc3, true, Q93.b() ? new b(enumC11821dc3) : Q93.a()));
    }
}
