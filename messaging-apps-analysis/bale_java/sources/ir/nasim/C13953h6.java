package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.h6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13953h6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BaleButton b;
    public final Guideline c;
    public final Guideline d;
    public final AppCompatImageView e;
    public final TextView f;

    private C13953h6(ConstraintLayout constraintLayout, BaleButton baleButton, Guideline guideline, Guideline guideline2, AppCompatImageView appCompatImageView, TextView textView) {
        this.a = constraintLayout;
        this.b = baleButton;
        this.c = guideline;
        this.d = guideline2;
        this.e = appCompatImageView;
        this.f = textView;
    }

    public static C13953h6 a(View view) {
        int i = BC5.btn_force_update;
        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
        if (baleButton != null) {
            i = BC5.guideline1;
            Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
            if (guideline != null) {
                i = BC5.guideline2;
                Guideline guideline2 = (Guideline) AbstractC11738dW7.a(view, i);
                if (guideline2 != null) {
                    i = BC5.iv_logo_force_update;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView != null) {
                        i = BC5.tv_description_force_update;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            return new C13953h6((ConstraintLayout) view, baleButton, guideline, guideline2, appCompatImageView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C13953h6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C13953h6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_force_update, viewGroup, false);
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
