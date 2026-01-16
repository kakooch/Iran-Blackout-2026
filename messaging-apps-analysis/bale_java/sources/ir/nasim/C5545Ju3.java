package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.story.ui.viewfragment.views.ReactionButton;

/* renamed from: ir.nasim.Ju3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5545Ju3 implements InterfaceC9764aW7 {
    private final View a;
    public final View b;
    public final AppCompatImageView c;
    public final ReactionButton d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    private C5545Ju3(View view, View view2, AppCompatImageView appCompatImageView, ReactionButton reactionButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = view2;
        this.c = appCompatImageView;
        this.d = reactionButton;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
    }

    public static C5545Ju3 a(View view) {
        int i = AbstractC18172oC5.divider;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = AbstractC18172oC5.ivViewCount;
            AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
            if (appCompatImageView != null) {
                i = AbstractC18172oC5.reactionBtn;
                ReactionButton reactionButton = (ReactionButton) AbstractC11738dW7.a(view, i);
                if (reactionButton != null) {
                    i = AbstractC18172oC5.tvReactionCount;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                    if (appCompatTextView != null) {
                        i = AbstractC18172oC5.tvViewCount;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                        if (appCompatTextView2 != null) {
                            return new C5545Ju3(view, viewA, appCompatImageView, reactionButton, appCompatTextView, appCompatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5545Ju3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(RC5.layout_popular_story_bar, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
