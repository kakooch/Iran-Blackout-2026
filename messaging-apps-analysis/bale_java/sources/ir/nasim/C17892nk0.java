package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.nk0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17892nk0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BaleButton b;
    public final AppCompatImageView c;
    public final View d;
    public final View e;
    public final View f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final LinearLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final LinearLayout m;
    public final ConstraintLayout n;
    public final AppCompatImageView o;
    public final AppCompatImageView p;
    public final AppCompatImageView q;
    public final ComposeView r;
    public final ComposeView s;
    public final MaterialTextView t;
    public final MaterialTextView u;
    public final MaterialTextView v;

    private C17892nk0(ConstraintLayout constraintLayout, BaleButton baleButton, AppCompatImageView appCompatImageView, View view, View view2, View view3, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, ComposeView composeView, ComposeView composeView2, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3) {
        this.a = constraintLayout;
        this.b = baleButton;
        this.c = appCompatImageView;
        this.d = view;
        this.e = view2;
        this.f = view3;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
        this.i = appCompatImageView4;
        this.j = linearLayout;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.m = linearLayout4;
        this.n = constraintLayout2;
        this.o = appCompatImageView5;
        this.p = appCompatImageView6;
        this.q = appCompatImageView7;
        this.r = composeView;
        this.s = composeView2;
        this.t = materialTextView;
        this.u = materialTextView2;
        this.v = materialTextView3;
    }

    public static C17892nk0 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i = AbstractC18172oC5.btn;
        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
        if (baleButton != null) {
            i = AbstractC18172oC5.btnClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
            if (appCompatImageView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.divider))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.divider2))) != null && (viewA3 = AbstractC11738dW7.a(view, (i = AbstractC18172oC5.divider3))) != null) {
                i = AbstractC18172oC5.img;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView2 != null) {
                    i = AbstractC18172oC5.ivSpecialBadge;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView3 != null) {
                        i = AbstractC18172oC5.ivSpecialRing;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                        if (appCompatImageView4 != null) {
                            i = AbstractC18172oC5.layEnable;
                            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                            if (linearLayout != null) {
                                i = AbstractC18172oC5.laySpecial;
                                LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                if (linearLayout2 != null) {
                                    i = AbstractC18172oC5.layTextEnable;
                                    LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                    if (linearLayout3 != null) {
                                        i = AbstractC18172oC5.layTextSpecial;
                                        LinearLayout linearLayout4 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                        if (linearLayout4 != null) {
                                            i = AbstractC18172oC5.own_story_layout;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                            if (constraintLayout != null) {
                                                i = AbstractC18172oC5.profile_avatar;
                                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                                if (appCompatImageView5 != null) {
                                                    i = AbstractC18172oC5.storyBadge;
                                                    AppCompatImageView appCompatImageView6 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                                    if (appCompatImageView6 != null) {
                                                        i = AbstractC18172oC5.storyRing;
                                                        AppCompatImageView appCompatImageView7 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                                        if (appCompatImageView7 != null) {
                                                            i = AbstractC18172oC5.swEnable;
                                                            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
                                                            if (composeView != null) {
                                                                i = AbstractC18172oC5.swSpecial;
                                                                ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
                                                                if (composeView2 != null) {
                                                                    i = AbstractC18172oC5.title;
                                                                    MaterialTextView materialTextView = (MaterialTextView) AbstractC11738dW7.a(view, i);
                                                                    if (materialTextView != null) {
                                                                        i = AbstractC18172oC5.tvSpecialDesc;
                                                                        MaterialTextView materialTextView2 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                                                                        if (materialTextView2 != null) {
                                                                            i = AbstractC18172oC5.tvSpecialTitle;
                                                                            MaterialTextView materialTextView3 = (MaterialTextView) AbstractC11738dW7.a(view, i);
                                                                            if (materialTextView3 != null) {
                                                                                return new C17892nk0((ConstraintLayout) view, baleButton, appCompatImageView, viewA, viewA2, viewA3, appCompatImageView2, appCompatImageView3, appCompatImageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, constraintLayout, appCompatImageView5, appCompatImageView6, appCompatImageView7, composeView, composeView2, materialTextView, materialTextView2, materialTextView3);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static C17892nk0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.bottom_sheet_story_tag, viewGroup, false);
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
