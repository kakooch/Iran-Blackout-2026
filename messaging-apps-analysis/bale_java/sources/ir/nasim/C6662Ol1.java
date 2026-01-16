package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Ol1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6662Ol1 implements InterfaceC9764aW7 {
    private final LinearLayoutCompat a;
    public final RecyclerView b;
    public final LinearLayout c;
    public final ImageView d;
    public final TextView e;
    public final RecyclerView f;

    private C6662Ol1(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, LinearLayout linearLayout, ImageView imageView, TextView textView, RecyclerView recyclerView2) {
        this.a = linearLayoutCompat;
        this.b = recyclerView;
        this.c = linearLayout;
        this.d = imageView;
        this.e = textView;
        this.f = recyclerView2;
    }

    public static C6662Ol1 a(View view) {
        int i = AbstractC19354qC5.actionItemsRecyclerView;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC19354qC5.magazine_suggest;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC19354qC5.magazine_suggest_iv;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC19354qC5.magazine_suggest_tv;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = AbstractC19354qC5.reactionsRecyclerView;
                        RecyclerView recyclerView2 = (RecyclerView) AbstractC11738dW7.a(view, i);
                        if (recyclerView2 != null) {
                            return new C6662Ol1((LinearLayoutCompat) view, recyclerView, linearLayout, imageView, textView, recyclerView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
