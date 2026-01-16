package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.components.image.view.BouncerImageView;

/* renamed from: ir.nasim.xj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23910xj2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final BouncerImageView c;

    private C23910xj2(ConstraintLayout constraintLayout, TextView textView, BouncerImageView bouncerImageView) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = bouncerImageView;
    }

    public static C23910xj2 a(View view) {
        int i = AbstractC12808fC5.reaction_count_tv;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = AbstractC12808fC5.reaction_iv;
            BouncerImageView bouncerImageView = (BouncerImageView) AbstractC11738dW7.a(view, i);
            if (bouncerImageView != null) {
                return new C23910xj2((ConstraintLayout) view, textView, bouncerImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23910xj2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.feed_reaction_holder, viewGroup, false);
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
