package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.features.smiles.widget.StickerRecyclerView;
import ir.nasim.features.smiles.widget.TabLayoutRecycler;

/* renamed from: ir.nasim.pz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19223pz2 implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final MaterialButton b;
    public final AppCompatImageView c;
    public final FrameLayout d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final StickerRecyclerView g;
    public final TabLayoutRecycler h;
    public final AppCompatTextView i;

    private C19223pz2(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, AppCompatImageView appCompatImageView, FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, StickerRecyclerView stickerRecyclerView, TabLayoutRecycler tabLayoutRecycler, AppCompatTextView appCompatTextView) {
        this.a = coordinatorLayout;
        this.b = materialButton;
        this.c = appCompatImageView;
        this.d = frameLayout;
        this.e = linearLayout;
        this.f = linearLayout2;
        this.g = stickerRecyclerView;
        this.h = tabLayoutRecycler;
        this.i = appCompatTextView;
    }

    public static C19223pz2 a(View view) {
        int i = BC5.btnAddStickers;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.btnShowAllStickers;
            AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
            if (appCompatImageView != null) {
                i = BC5.containerAddStickers;
                FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout != null) {
                    i = BC5.linearLayout;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        i = BC5.llTabContainer;
                        LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout2 != null) {
                            i = BC5.rcSmilesSticker;
                            StickerRecyclerView stickerRecyclerView = (StickerRecyclerView) AbstractC11738dW7.a(view, i);
                            if (stickerRecyclerView != null) {
                                i = BC5.tlrSmilesSticker;
                                TabLayoutRecycler tabLayoutRecycler = (TabLayoutRecycler) AbstractC11738dW7.a(view, i);
                                if (tabLayoutRecycler != null) {
                                    i = BC5.tvNoPermission;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                                    if (appCompatTextView != null) {
                                        return new C19223pz2((CoordinatorLayout) view, materialButton, appCompatImageView, frameLayout, linearLayout, linearLayout2, stickerRecyclerView, tabLayoutRecycler, appCompatTextView);
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

    public static C19223pz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_smiles_sticker, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
