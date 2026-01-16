package ir.nasim;

import android.view.View;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.Oe3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6596Oe3 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final TextView b;

    private C6596Oe3(MaterialCardView materialCardView, TextView textView) {
        this.a = materialCardView;
        this.b = textView;
    }

    public static C6596Oe3 a(View view) {
        int i = BC5.blocked_message;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C6596Oe3((MaterialCardView) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.a;
    }
}
