package ir.nasim;

import android.view.View;

/* loaded from: classes3.dex */
final /* synthetic */ class M20 implements DI4, InterfaceC22409vB2 {
    private final /* synthetic */ UA2 a;

    M20(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "function");
        this.a = ua2;
    }

    @Override // ir.nasim.DI4
    public final /* synthetic */ void a(View view) {
        this.a.invoke(view);
    }

    @Override // ir.nasim.InterfaceC22409vB2
    public final InterfaceC18751pB2 b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof DI4) && (obj instanceof InterfaceC22409vB2)) {
            return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
