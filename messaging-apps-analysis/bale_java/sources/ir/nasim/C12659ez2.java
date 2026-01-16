package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.ez2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12659ez2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FullWidthButtonPrimary b;
    public final CardView c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final EditText f;
    public final AppBarLayout g;
    public final BaleToolbar h;
    public final TextView i;
    public final TextView j;

    private C12659ez2(ConstraintLayout constraintLayout, FullWidthButtonPrimary fullWidthButtonPrimary, CardView cardView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, AppBarLayout appBarLayout, BaleToolbar baleToolbar, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = fullWidthButtonPrimary;
        this.c = cardView;
        this.d = constraintLayout2;
        this.e = constraintLayout3;
        this.f = editText;
        this.g = appBarLayout;
        this.h = baleToolbar;
        this.i = textView;
        this.j = textView2;
    }

    public static C12659ez2 a(View view) {
        int i = BC5.button_save_report;
        FullWidthButtonPrimary fullWidthButtonPrimary = (FullWidthButtonPrimary) AbstractC11738dW7.a(view, i);
        if (fullWidthButtonPrimary != null) {
            i = BC5.cardView_report;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = BC5.constraint_container_edittext;
                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = BC5.editText_description;
                    EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                    if (editText != null) {
                        i = BC5.report_error_appbar;
                        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                        if (appBarLayout != null) {
                            i = BC5.report_error_toolbar;
                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                            if (baleToolbar != null) {
                                i = BC5.textView_description;
                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView != null) {
                                    i = BC5.textView_title;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        return new C12659ez2(constraintLayout2, fullWidthButtonPrimary, cardView, constraintLayout, constraintLayout2, editText, appBarLayout, baleToolbar, textView, textView2);
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

    public static C12659ez2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_report_error, viewGroup, false);
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
