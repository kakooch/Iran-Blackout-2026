package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.wi1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23309wi1 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final TextView b;

    private C23309wi1(MaterialCardView materialCardView, TextView textView) {
        this.a = materialCardView;
        this.b = textView;
    }

    public static C23309wi1 a(View view) {
        int i = BC5.invitation_text;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C23309wi1((MaterialCardView) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23309wi1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.contacts_invitation_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.a;
    }
}
