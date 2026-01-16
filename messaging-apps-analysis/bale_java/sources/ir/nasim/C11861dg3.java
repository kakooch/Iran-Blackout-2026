package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.button.MaterialButton;

/* renamed from: ir.nasim.dg3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11861dg3 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final MaterialButton b;

    private C11861dg3(FrameLayout frameLayout, MaterialButton materialButton) {
        this.a = frameLayout;
        this.b = materialButton;
    }

    public static C11861dg3 a(View view) {
        int i = BC5.sponsored_action_button;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            return new C11861dg3((FrameLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
