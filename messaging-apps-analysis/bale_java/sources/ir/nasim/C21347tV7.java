package ir.nasim;

import android.view.View;
import ir.nasim.InterfaceC10698c3;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.tV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21347tV7 implements InterfaceC10698c3 {
    private final WeakReference a;

    public C21347tV7(View view) {
        AbstractC13042fc3.i(view, "view");
        this.a = new WeakReference(view);
    }

    @Override // ir.nasim.InterfaceC10698c3
    public boolean a(View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(view, "view");
        View view2 = (View) this.a.get();
        if (view2 == null) {
            return true;
        }
        view2.performClick();
        return true;
    }
}
