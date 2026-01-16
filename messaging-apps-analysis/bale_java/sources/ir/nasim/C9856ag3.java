package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.ag3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9856ag3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;

    private C9856ag3(ConstraintLayout constraintLayout, TextView textView) {
        this.a = constraintLayout;
        this.b = textView;
    }

    public static C9856ag3 a(View view) {
        int i = BC5.title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C9856ag3((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
