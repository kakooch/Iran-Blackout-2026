package ir.nasim;

import android.os.Bundle;
import ir.nasim.C7289Rb6;
import java.util.Map;

/* renamed from: ir.nasim.Ob6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6572Ob6 implements C7289Rb6.c {
    private final C7289Rb6 a;
    private boolean b;
    private Bundle c;
    private final InterfaceC9173Yu3 d;

    /* renamed from: ir.nasim.Ob6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC15408jX7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15408jX7 interfaceC15408jX7) {
            super(0);
            this.e = interfaceC15408jX7;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6811Pb6 invoke() {
            return androidx.lifecycle.B.e(this.e);
        }
    }

    public C6572Ob6(C7289Rb6 c7289Rb6, InterfaceC15408jX7 interfaceC15408jX7) {
        AbstractC13042fc3.i(c7289Rb6, "savedStateRegistry");
        AbstractC13042fc3.i(interfaceC15408jX7, "viewModelStoreOwner");
        this.a = c7289Rb6;
        this.d = AbstractC13269fw3.a(new a(interfaceC15408jX7));
    }

    private final C6811Pb6 c() {
        return (C6811Pb6) this.d.getValue();
    }

    public final Bundle a(String str) {
        AbstractC13042fc3.i(str, "key");
        d();
        Bundle bundle = this.c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    @Override // ir.nasim.C7289Rb6.c
    public Bundle b() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().P0().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleB = ((androidx.lifecycle.y) entry.getValue()).e().b();
            if (!AbstractC13042fc3.d(bundleB, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleB);
            }
        }
        this.b = false;
        return bundle;
    }

    public final void d() {
        if (this.b) {
            return;
        }
        Bundle bundleB = this.a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.c = bundle;
        this.b = true;
        c();
    }
}
