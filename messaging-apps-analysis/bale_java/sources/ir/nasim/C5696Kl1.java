package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.Kl1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5696Kl1 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final LinearLayout b;
    public final TextView c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final TextView f;

    private C5696Kl1(MaterialCardView materialCardView, LinearLayout linearLayout, TextView textView, AppCompatImageView appCompatImageView, RecyclerView recyclerView, TextView textView2) {
        this.a = materialCardView;
        this.b = linearLayout;
        this.c = textView;
        this.d = appCompatImageView;
        this.e = recyclerView;
        this.f = textView2;
    }

    public static C5696Kl1 a(View view) {
        int i = AbstractC19354qC5.context_item;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC19354qC5.detailTextView;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC19354qC5.iconImageView;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = AbstractC19354qC5.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                    if (recyclerView != null) {
                        i = AbstractC19354qC5.titleTextView;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            return new C5696Kl1((MaterialCardView) view, linearLayout, textView, appCompatImageView, recyclerView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5696Kl1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(TC5.context_menu_action_item_holder, viewGroup, false);
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
