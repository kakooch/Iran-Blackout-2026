package ir.nasim;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
final /* synthetic */ class N20 implements EI4, InterfaceC22409vB2 {
    private final /* synthetic */ InterfaceC14603iB2 a;

    N20(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "function");
        this.a = interfaceC14603iB2;
    }

    @Override // ir.nasim.EI4
    public final /* synthetic */ void a(View view, MotionEvent motionEvent) {
        this.a.invoke(view, motionEvent);
    }

    @Override // ir.nasim.InterfaceC22409vB2
    public final InterfaceC18751pB2 b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof EI4) && (obj instanceof InterfaceC22409vB2)) {
            return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
        }
        return false;
    }

    public final int hashCode() {
        return b().hashCode();
    }
}
