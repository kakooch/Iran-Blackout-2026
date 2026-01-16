package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.vx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22868vx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final MaterialCardView c;
    public final RecyclerView d;
    public final BaleButton e;
    public final TextView f;
    public final CustomInputView g;
    public final NestedScrollView h;
    public final View i;
    public final TextView j;
    public final TextView k;
    public final BaleToolbar l;

    private C22868vx2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, MaterialCardView materialCardView, RecyclerView recyclerView, BaleButton baleButton, TextView textView, CustomInputView customInputView, NestedScrollView nestedScrollView, View view, TextView textView2, TextView textView3, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = materialCardView;
        this.d = recyclerView;
        this.e = baleButton;
        this.f = textView;
        this.g = customInputView;
        this.h = nestedScrollView;
        this.i = view;
        this.j = textView2;
        this.k = textView3;
        this.l = baleToolbar;
    }

    public static C22868vx2 a(View view) {
        View viewA;
        int i = BC5.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.arbaeen_suggestion_card;
            MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
            if (materialCardView != null) {
                i = BC5.arbaeen_suggestion_recycler;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = BC5.button_continue;
                    BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
                    if (baleButton != null) {
                        i = BC5.message_body;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.mobile_input;
                            CustomInputView customInputView = (CustomInputView) AbstractC11738dW7.a(view, i);
                            if (customInputView != null) {
                                i = BC5.nestedScrollView;
                                NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                if (nestedScrollView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.ok_button_shadow))) != null) {
                                    i = BC5.powerd_by;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        i = BC5.recent_title;
                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView3 != null) {
                                            i = BC5.toolbar;
                                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                            if (baleToolbar != null) {
                                                return new C22868vx2((ConstraintLayout) view, appBarLayout, materialCardView, recyclerView, baleButton, textView, customInputView, nestedScrollView, viewA, textView2, textView3, baleToolbar);
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

    public static C22868vx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_arbaeen_view_status, viewGroup, false);
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
