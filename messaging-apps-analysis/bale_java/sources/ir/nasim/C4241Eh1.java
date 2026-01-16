package ir.nasim;

import android.view.View;

/* renamed from: ir.nasim.Eh1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4241Eh1 implements InterfaceC9764aW7 {
    private final View a;

    private C4241Eh1(View view) {
        this.a = view;
    }

    public static C4241Eh1 a(View view) {
        if (view != null) {
            return new C4241Eh1(view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
