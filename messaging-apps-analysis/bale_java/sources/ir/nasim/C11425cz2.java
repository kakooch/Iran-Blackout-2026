package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.cz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C11425cz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final LinearLayout d;
    public final TextView e;
    public final RecyclerView f;

    private C11425cz2(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, TextView textView, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = imageView;
        this.d = linearLayout3;
        this.e = textView;
        this.f = recyclerView;
    }

    public static C11425cz2 a(View view) {
        int i = AbstractC17581nC5.empty_place_holder;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC17581nC5.img_link_empty_state;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC17581nC5.loadState_container;
                LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout2 != null) {
                    i = AbstractC17581nC5.please_wait_txt;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = AbstractC17581nC5.recommended_peers_container;
                        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                        if (recyclerView != null) {
                            return new C11425cz2((LinearLayout) view, linearLayout, imageView, linearLayout2, textView, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C11425cz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.fragment_recommended_peer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
