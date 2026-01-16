package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Cz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3936Cz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final TextView d;
    public final AppBarLayout e;
    public final TextView f;
    public final RecyclerView g;
    public final BaleToolbar h;
    public final TextView i;

    private C3936Cz2(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, AppBarLayout appBarLayout, TextView textView3, RecyclerView recyclerView, BaleToolbar baleToolbar, TextView textView4) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = appBarLayout;
        this.f = textView3;
        this.g = recyclerView;
        this.h = baleToolbar;
        this.i = textView4;
    }

    public static C3936Cz2 a(View view) {
        int i = AbstractC18172oC5.header_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = AbstractC18172oC5.likes_count_text;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC18172oC5.story_remove_text;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = AbstractC18172oC5.story_viewers_appbar;
                    AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                    if (appBarLayout != null) {
                        i = AbstractC18172oC5.story_viewers_empty_state_text;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = AbstractC18172oC5.story_viewers_list;
                            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                            if (recyclerView != null) {
                                i = AbstractC18172oC5.story_viewers_toolbar;
                                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                if (baleToolbar != null) {
                                    i = AbstractC18172oC5.viewers_count_text;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        return new C3936Cz2((ConstraintLayout) view, constraintLayout, textView, textView2, appBarLayout, textView3, recyclerView, baleToolbar, textView4);
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

    public static C3936Cz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story_viewers, viewGroup, false);
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
