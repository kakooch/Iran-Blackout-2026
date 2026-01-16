package ir.nasim;

import android.view.View;
import com.google.android.material.button.MaterialButton;

/* renamed from: ir.nasim.Od3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6587Od3 implements InterfaceC9764aW7 {
    private final MaterialButton a;

    private C6587Od3(MaterialButton materialButton) {
        this.a = materialButton;
    }

    public static C6587Od3 a(View view) {
        if (view != null) {
            return new C6587Od3((MaterialButton) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialButton getRoot() {
        return this.a;
    }
}
