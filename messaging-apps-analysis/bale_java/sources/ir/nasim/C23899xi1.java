package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.xi1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23899xi1 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;

    private C23899xi1(ConstraintLayout constraintLayout, TextView textView) {
        this.a = constraintLayout;
        this.b = textView;
    }

    public static C23899xi1 a(View view) {
        int i = BC5.title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C23899xi1((ConstraintLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23899xi1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.contacts_invitation_via_link, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
