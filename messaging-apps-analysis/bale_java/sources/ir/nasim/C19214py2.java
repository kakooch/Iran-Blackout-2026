package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.py2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19214py2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final RecyclerView d;
    public final LinearLayout e;
    public final TextView f;

    private C19214py2(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, RecyclerView recyclerView, LinearLayout linearLayout3, TextView textView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = imageView;
        this.d = recyclerView;
        this.e = linearLayout3;
        this.f = textView;
    }

    public static C19214py2 a(View view) {
        int i = AbstractC17581nC5.empty_place_holder;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC17581nC5.img_link_empty_state;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC17581nC5.link_container;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    i = AbstractC17581nC5.loadState_container;
                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout2 != null) {
                        i = AbstractC17581nC5.please_wait_txt;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            return new C19214py2((LinearLayout) view, linearLayout, imageView, recyclerView, linearLayout2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
