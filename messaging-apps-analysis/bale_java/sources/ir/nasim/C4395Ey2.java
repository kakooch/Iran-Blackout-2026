package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Ey2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4395Ey2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final TextView d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final TextView g;
    public final ComposeView h;

    private C4395Ey2(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView2, ComposeView composeView) {
        this.a = frameLayout;
        this.b = linearLayout;
        this.c = imageView;
        this.d = textView;
        this.e = linearLayout2;
        this.f = recyclerView;
        this.g = textView2;
        this.h = composeView;
    }

    public static C4395Ey2 a(View view) {
        int i = AbstractC17581nC5.emptyState_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC17581nC5.emptyState_img;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC17581nC5.empty_txt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC17581nC5.loadState_container;
                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout2 != null) {
                        i = AbstractC17581nC5.media_container;
                        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                        if (recyclerView != null) {
                            i = AbstractC17581nC5.please_wait_txt;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = AbstractC17581nC5.search_file;
                                ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
                                if (composeView != null) {
                                    return new C4395Ey2((FrameLayout) view, linearLayout, imageView, textView, linearLayout2, recyclerView, textView2, composeView);
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
    public FrameLayout getRoot() {
        return this.a;
    }
}
