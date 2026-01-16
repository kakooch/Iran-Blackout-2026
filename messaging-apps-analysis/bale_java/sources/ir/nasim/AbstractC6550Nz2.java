package ir.nasim;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;

/* renamed from: ir.nasim.Nz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6550Nz2 {

    /* renamed from: ir.nasim.Nz2$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final InterfaceC9173Yu3 b(Fragment fragment, InterfaceC11299cm3 interfaceC11299cm3, SA2 sa2, SA2 sa22, SA2 sa23) {
        if (sa23 == null) {
            sa23 = new a(fragment);
        }
        return new androidx.lifecycle.F(interfaceC11299cm3, sa2, sa23, sa22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 c(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return (InterfaceC15408jX7) interfaceC9173Yu3.getValue();
    }
}
