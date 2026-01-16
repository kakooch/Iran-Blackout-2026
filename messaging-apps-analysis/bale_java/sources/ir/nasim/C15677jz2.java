package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.jz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15677jz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final RecyclerView c;
    public final TextView d;
    public final ImageView e;

    private C15677jz2(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, TextView textView, ImageView imageView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = recyclerView;
        this.d = textView;
        this.e = imageView;
    }

    public static C15677jz2 a(View view) {
        int i = BC5.divider;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = BC5.options_recycler;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                i = BC5.quotaAmountTxt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.swipeIconImg;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        return new C15677jz2((ConstraintLayout) view, viewA, recyclerView, textView, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15677jz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_selectable_options, viewGroup, false);
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
