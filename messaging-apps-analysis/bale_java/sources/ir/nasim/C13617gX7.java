package ir.nasim;

import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;

/* renamed from: ir.nasim.gX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13617gX7 {
    public static final C13617gX7 a = new C13617gX7();

    /* renamed from: ir.nasim.gX7$a */
    public static final class a implements AbstractC20375ru1.b {
        public static final a a = new a();

        private a() {
        }
    }

    private C13617gX7() {
    }

    public final AbstractC20375ru1 a(InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(interfaceC15408jX7, "owner");
        return interfaceC15408jX7 instanceof androidx.lifecycle.h ? ((androidx.lifecycle.h) interfaceC15408jX7).p3() : AbstractC20375ru1.a.b;
    }

    public final G.c b(InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(interfaceC15408jX7, "owner");
        return interfaceC15408jX7 instanceof androidx.lifecycle.h ? ((androidx.lifecycle.h) interfaceC15408jX7).n3() : C19386qG1.b;
    }

    public final String c(InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        String strA = AbstractC14208hX7.a(interfaceC11299cm3);
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
        }
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + strA;
    }

    public final VW7 d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
