package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Wy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8667Wy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialRadioButton b;
    public final RecyclerView c;
    public final MaterialRadioButton d;
    public final RadioGroup e;
    public final AppBarLayout f;
    public final BaleToolbar g;
    public final TextView h;
    public final MaterialCardView i;
    public final TextView j;

    private C8667Wy2(ConstraintLayout constraintLayout, MaterialRadioButton materialRadioButton, RecyclerView recyclerView, MaterialRadioButton materialRadioButton2, RadioGroup radioGroup, AppBarLayout appBarLayout, BaleToolbar baleToolbar, TextView textView, MaterialCardView materialCardView, TextView textView2) {
        this.a = constraintLayout;
        this.b = materialRadioButton;
        this.c = recyclerView;
        this.d = materialRadioButton2;
        this.e = radioGroup;
        this.f = appBarLayout;
        this.g = baleToolbar;
        this.h = textView;
        this.i = materialCardView;
        this.j = textView2;
    }

    public static C8667Wy2 a(View view) {
        int i = BC5.details_tag_deposit_rb;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
        if (materialRadioButton != null) {
            i = BC5.details_tag_rv;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                i = BC5.details_tag_withdraw_rb;
                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                if (materialRadioButton2 != null) {
                    i = BC5.pfm_details_tag_rg;
                    RadioGroup radioGroup = (RadioGroup) AbstractC11738dW7.a(view, i);
                    if (radioGroup != null) {
                        i = BC5.tag_detail_appbar;
                        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                        if (appBarLayout != null) {
                            i = BC5.tag_detail_toolbar;
                            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                            if (baleToolbar != null) {
                                i = BC5.total_amount;
                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView != null) {
                                    i = BC5.total_card;
                                    MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                    if (materialCardView != null) {
                                        i = BC5.total_title;
                                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView2 != null) {
                                            return new C8667Wy2((ConstraintLayout) view, materialRadioButton, recyclerView, materialRadioButton2, radioGroup, appBarLayout, baleToolbar, textView, materialCardView, textView2);
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

    public static C8667Wy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_pfm_details_tag, viewGroup, false);
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
