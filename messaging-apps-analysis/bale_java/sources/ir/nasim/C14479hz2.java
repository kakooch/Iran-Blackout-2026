package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.designsystem.button.FullWidthButtonSecondary;

/* renamed from: ir.nasim.hz2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14479hz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final RecyclerView b;
    public final C7796Tf6 c;
    public final LinearLayout d;
    public final ScrollView e;
    public final FullWidthButtonSecondary f;

    private C14479hz2(LinearLayout linearLayout, RecyclerView recyclerView, C7796Tf6 c7796Tf6, LinearLayout linearLayout2, ScrollView scrollView, FullWidthButtonSecondary fullWidthButtonSecondary) {
        this.a = linearLayout;
        this.b = recyclerView;
        this.c = c7796Tf6;
        this.d = linearLayout2;
        this.e = scrollView;
        this.f = fullWidthButtonSecondary;
    }

    public static C14479hz2 a(View view) {
        View viewA;
        int i = AbstractC12808fC5.channels_container;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.empty_state_container))) != null) {
            C7796Tf6 c7796Tf6A = C7796Tf6.a(viewA);
            i = AbstractC12808fC5.loading_container;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC12808fC5.loading_container_scroll_view;
                ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                if (scrollView != null) {
                    i = AbstractC12808fC5.see_all_result_btn;
                    FullWidthButtonSecondary fullWidthButtonSecondary = (FullWidthButtonSecondary) AbstractC11738dW7.a(view, i);
                    if (fullWidthButtonSecondary != null) {
                        return new C14479hz2((LinearLayout) view, recyclerView, c7796Tf6A, linearLayout, scrollView, fullWidthButtonSecondary);
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
