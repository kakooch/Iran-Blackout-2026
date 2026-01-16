package androidx.compose.foundation.layout;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.Q93;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class c {

    public static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(float f, boolean z) {
            super(1);
            this.e = f;
            this.f = z;
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

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, float f, boolean z) {
        return eVar.i(new AspectRatioElement(f, z, Q93.b() ? new a(f, z) : Q93.a()));
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(eVar, f, z);
    }

    public static final boolean c(long j, int i, int i2) {
        int iN = C17833ne1.n(j);
        if (i <= C17833ne1.l(j) && iN <= i) {
            int iM = C17833ne1.m(j);
            if (i2 <= C17833ne1.k(j) && iM <= i2) {
                return true;
            }
        }
        return false;
    }
}
