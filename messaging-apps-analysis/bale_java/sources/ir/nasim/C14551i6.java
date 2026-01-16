package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.i6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14551i6 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final ConstraintLayout d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final BaleButton g;
    public final TextView h;
    public final AppCompatImageView i;
    public final TextView j;

    private C14551i6(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, BaleButton baleButton, TextView textView2, AppCompatImageView appCompatImageView3, TextView textView3) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = textView;
        this.d = constraintLayout3;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = baleButton;
        this.h = textView2;
        this.i = appCompatImageView3;
        this.j = textView3;
    }

    public static C14551i6 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = BC5.change_language;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.farsi_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout2 != null) {
                i = BC5.intro_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = BC5.intro_logo;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView2 != null) {
                        i = BC5.intro_start;
                        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
                        if (baleButton != null) {
                            i = BC5.intro_text;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.separator;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                if (appCompatImageView3 != null) {
                                    i = BC5.term_and_condition;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        return new C14551i6(constraintLayout, constraintLayout, textView, constraintLayout2, appCompatImageView, appCompatImageView2, baleButton, textView2, appCompatImageView3, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C14551i6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C14551i6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_intro_logo, viewGroup, false);
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
