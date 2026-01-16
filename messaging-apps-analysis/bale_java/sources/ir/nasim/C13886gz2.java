package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.gz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13886gz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageButton b;
    public final TextView c;
    public final RecyclerView d;
    public final TextView e;

    private C13886gz2(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.a = constraintLayout;
        this.b = imageButton;
        this.c = textView;
        this.d = recyclerView;
        this.e = textView2;
    }

    public static C13886gz2 a(View view) {
        int i = BC5.arrowDown;
        ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
        if (imageButton != null) {
            i = BC5.description;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.savedRecycler;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = BC5.title;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        return new C13886gz2((ConstraintLayout) view, imageButton, textView, recyclerView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C13886gz2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C13886gz2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_saved_card_list, viewGroup, false);
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
