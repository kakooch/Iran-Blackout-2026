package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.BaleButton;

/* renamed from: ir.nasim.ux2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22272ux2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final CardView b;
    public final SwitchCompat c;
    public final TextView d;
    public final AppBarLayout e;
    public final BaleButton f;
    public final TextView g;
    public final TextView h;
    public final FrameLayout i;
    public final TextView j;
    public final NestedScrollView k;
    public final View l;
    public final TextView m;
    public final BaleToolbar n;

    private C22272ux2(ConstraintLayout constraintLayout, CardView cardView, SwitchCompat switchCompat, TextView textView, AppBarLayout appBarLayout, BaleButton baleButton, TextView textView2, TextView textView3, FrameLayout frameLayout, TextView textView4, NestedScrollView nestedScrollView, View view, TextView textView5, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = cardView;
        this.c = switchCompat;
        this.d = textView;
        this.e = appBarLayout;
        this.f = baleButton;
        this.g = textView2;
        this.h = textView3;
        this.i = frameLayout;
        this.j = textView4;
        this.k = nestedScrollView;
        this.l = view;
        this.m = textView5;
        this.n = baleToolbar;
    }

    public static C22272ux2 a(View view) {
        View viewA;
        int i = BC5.add_to_story_layout;
        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
        if (cardView != null) {
            i = BC5.add_to_story_switch;
            SwitchCompat switchCompat = (SwitchCompat) AbstractC11738dW7.a(view, i);
            if (switchCompat != null) {
                i = BC5.add_to_story_text;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.appbar;
                    AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                    if (appBarLayout != null) {
                        i = BC5.button_continue;
                        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
                        if (baleButton != null) {
                            i = BC5.last_viewer;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.message_body;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.message_edit_text_layout;
                                    FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                    if (frameLayout != null) {
                                        i = BC5.message_title;
                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView4 != null) {
                                            i = BC5.nestedScrollView;
                                            NestedScrollView nestedScrollView = (NestedScrollView) AbstractC11738dW7.a(view, i);
                                            if (nestedScrollView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.ok_button_shadow))) != null) {
                                                i = BC5.powerd_by;
                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView5 != null) {
                                                    i = BC5.toolbar;
                                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                    if (baleToolbar != null) {
                                                        return new C22272ux2((ConstraintLayout) view, cardView, switchCompat, textView, appBarLayout, baleButton, textView2, textView3, frameLayout, textView4, nestedScrollView, viewA, textView5, baleToolbar);
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

    public static C22272ux2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_arbaeen_set_status, viewGroup, false);
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
