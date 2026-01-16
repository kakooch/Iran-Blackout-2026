package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.designsystem.DividerView;

/* renamed from: ir.nasim.Fy2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4644Fy2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final DividerView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final RecyclerView g;
    public final TextView h;
    public final ComposeView i;

    private C4644Fy2(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, DividerView dividerView, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, TextView textView, ComposeView composeView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = imageView;
        this.d = dividerView;
        this.e = linearLayout3;
        this.f = linearLayout4;
        this.g = recyclerView;
        this.h = textView;
        this.i = composeView;
    }

    public static C4644Fy2 a(View view) {
        int i = AbstractC17581nC5.add_member_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC17581nC5.add_user_img;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC17581nC5.divider;
                DividerView dividerView = (DividerView) AbstractC11738dW7.a(view, i);
                if (dividerView != null) {
                    i = AbstractC17581nC5.empty_place_holder;
                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout2 != null) {
                        i = AbstractC17581nC5.loadState_container;
                        LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout3 != null) {
                            i = AbstractC17581nC5.member_container;
                            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                            if (recyclerView != null) {
                                i = AbstractC17581nC5.please_wait_txt;
                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView != null) {
                                    i = AbstractC17581nC5.search_member;
                                    ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
                                    if (composeView != null) {
                                        return new C4644Fy2((LinearLayout) view, linearLayout, imageView, dividerView, linearLayout2, linearLayout3, recyclerView, textView, composeView);
                                    }
                                }
                            }
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
