package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.nasim.features.smiles.widget.StickerRecyclerView;

/* renamed from: ir.nasim.vP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22534vP1 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final View b;
    public final LinearLayout c;
    public final View d;
    public final LinearLayout e;
    public final CircularProgressIndicator f;
    public final StickerRecyclerView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;

    private C22534vP1(LinearLayout linearLayout, View view, LinearLayout linearLayout2, View view2, LinearLayout linearLayout3, CircularProgressIndicator circularProgressIndicator, StickerRecyclerView stickerRecyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = linearLayout;
        this.b = view;
        this.c = linearLayout2;
        this.d = view2;
        this.e = linearLayout3;
        this.f = circularProgressIndicator;
        this.g = stickerRecyclerView;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
    }

    public static C22534vP1 a(View view) {
        View viewA;
        int i = BC5.divider;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null) {
            i = BC5.frNotFound;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.handler))) != null) {
                LinearLayout linearLayout2 = (LinearLayout) view;
                i = BC5.prg;
                CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) AbstractC11738dW7.a(view, i);
                if (circularProgressIndicator != null) {
                    i = BC5.rcMxpContact;
                    StickerRecyclerView stickerRecyclerView = (StickerRecyclerView) AbstractC11738dW7.a(view, i);
                    if (stickerRecyclerView != null) {
                        i = BC5.textViewMxpNoFound;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                        if (appCompatTextView != null) {
                            i = BC5.tvTitle;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                            if (appCompatTextView2 != null) {
                                return new C22534vP1(linearLayout2, viewA2, linearLayout, viewA, linearLayout2, circularProgressIndicator, stickerRecyclerView, appCompatTextView, appCompatTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C22534vP1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.dialog_select_mxp_contact, viewGroup, false);
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
