package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Pu3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6979Pu3 implements InterfaceC9764aW7 {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final RecyclerView d;

    private C6979Pu3(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = appCompatImageView2;
        this.d = recyclerView;
    }

    public static C6979Pu3 a(View view) {
        int i = AbstractC18172oC5.ivCloseReactionStory;
        AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
        if (appCompatImageView != null) {
            i = AbstractC18172oC5.ivNub;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
            if (appCompatImageView2 != null) {
                i = AbstractC18172oC5.rcReactionStory;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    return new C6979Pu3((LinearLayoutCompat) view, appCompatImageView, appCompatImageView2, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6979Pu3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.layout_story_reaction, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
