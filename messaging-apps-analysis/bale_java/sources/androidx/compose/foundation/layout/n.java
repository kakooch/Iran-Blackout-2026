package androidx.compose.foundation.layout;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class n {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ float f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, float f2) {
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

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2) {
            super(1);
            this.e = ua2;
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

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, UA2 ua2) {
        return eVar.i(new OffsetPxModifier(ua2, true, new b(ua2)));
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, float f, float f2) {
        return eVar.i(new OffsetModifierElement(f, f2, true, new a(f, f2), null));
    }

    public static /* synthetic */ androidx.compose.ui.e c(androidx.compose.ui.e eVar, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        return b(eVar, f, f2);
    }
}
