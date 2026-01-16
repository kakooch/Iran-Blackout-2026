package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Kf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5644Kf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final ImageView f;

    private C5644Kf3(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = textView;
        this.d = textView2;
        this.e = imageView;
        this.f = imageView2;
    }

    public static C5644Kf3 a(View view) {
        int i = BC5.markets;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = BC5.moreItemsTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.title;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.titleDrawable;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.titleHint;
                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView2 != null) {
                            return new C5644Kf3((ConstraintLayout) view, recyclerView, textView, textView2, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5644Kf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_market_row, viewGroup, false);
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
