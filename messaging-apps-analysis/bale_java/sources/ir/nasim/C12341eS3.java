package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.eS3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12341eS3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;

    private C12341eS3(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, ImageView imageView) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = textView;
        this.d = textView2;
        this.e = imageView;
    }

    public static C12341eS3 a(View view) {
        int i = AbstractC12808fC5.markets;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC12808fC5.moreItemsTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC12808fC5.title;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = AbstractC12808fC5.titleHint;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        return new C12341eS3((ConstraintLayout) view, recyclerView, textView, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C12341eS3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.market_row_holder, viewGroup, false);
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
