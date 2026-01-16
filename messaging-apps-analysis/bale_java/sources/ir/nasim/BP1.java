package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.nasim.designsystem.button.FullWidthButtonError;
import ir.nasim.designsystem.button.FullWidthButtonSecondary;
import ir.nasim.features.smiles.widget.StickerRecyclerView;

/* loaded from: classes5.dex */
public final class BP1 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final FullWidthButtonSecondary b;
    public final FullWidthButtonError c;
    public final View d;
    public final FrameLayout e;
    public final LinearLayout f;
    public final View g;
    public final LinearLayout h;
    public final CircularProgressIndicator i;
    public final StickerRecyclerView j;
    public final AppCompatTextView k;

    private BP1(FrameLayout frameLayout, FullWidthButtonSecondary fullWidthButtonSecondary, FullWidthButtonError fullWidthButtonError, View view, FrameLayout frameLayout2, LinearLayout linearLayout, View view2, LinearLayout linearLayout2, CircularProgressIndicator circularProgressIndicator, StickerRecyclerView stickerRecyclerView, AppCompatTextView appCompatTextView) {
        this.a = frameLayout;
        this.b = fullWidthButtonSecondary;
        this.c = fullWidthButtonError;
        this.d = view;
        this.e = frameLayout2;
        this.f = linearLayout;
        this.g = view2;
        this.h = linearLayout2;
        this.i = circularProgressIndicator;
        this.j = stickerRecyclerView;
        this.k = appCompatTextView;
    }

    public static BP1 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.btnAdd;
        FullWidthButtonSecondary fullWidthButtonSecondary = (FullWidthButtonSecondary) AbstractC11738dW7.a(view, i);
        if (fullWidthButtonSecondary != null) {
            i = BC5.btnRemove;
            FullWidthButtonError fullWidthButtonError = (FullWidthButtonError) AbstractC11738dW7.a(view, i);
            if (fullWidthButtonError != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i = BC5.frBtn;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.handler))) != null) {
                    i = BC5.linearLayout;
                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout2 != null) {
                        i = BC5.prg;
                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) AbstractC11738dW7.a(view, i);
                        if (circularProgressIndicator != null) {
                            i = BC5.rcStickers;
                            StickerRecyclerView stickerRecyclerView = (StickerRecyclerView) AbstractC11738dW7.a(view, i);
                            if (stickerRecyclerView != null) {
                                i = BC5.tvTitle;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                                if (appCompatTextView != null) {
                                    return new BP1(frameLayout, fullWidthButtonSecondary, fullWidthButtonError, viewA, frameLayout, linearLayout, viewA2, linearLayout2, circularProgressIndicator, stickerRecyclerView, appCompatTextView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BP1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static BP1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.dialog_sticker_pack, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
