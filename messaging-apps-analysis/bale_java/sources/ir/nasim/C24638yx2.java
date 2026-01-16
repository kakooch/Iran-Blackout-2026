package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.yx2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24638yx2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final C7796Tf6 b;
    public final LinearLayout c;
    public final TextView d;
    public final RecyclerView e;

    private C24638yx2(FrameLayout frameLayout, C7796Tf6 c7796Tf6, LinearLayout linearLayout, TextView textView, RecyclerView recyclerView) {
        this.a = frameLayout;
        this.b = c7796Tf6;
        this.c = linearLayout;
        this.d = textView;
        this.e = recyclerView;
    }

    public static C24638yx2 a(View view) {
        int i = AbstractC12808fC5.empty_state_container;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            C7796Tf6 c7796Tf6A = C7796Tf6.a(viewA);
            i = AbstractC12808fC5.loadState_container;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC12808fC5.please_wait_txt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC12808fC5.recycler;
                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                    if (recyclerView != null) {
                        return new C24638yx2((FrameLayout) view, c7796Tf6A, linearLayout, textView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
