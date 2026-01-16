package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.divider.MaterialDivider;
import ir.nasim.features.smiles.panel.gif.GifRecyclerView;

/* renamed from: ir.nasim.oz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18632oz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final MaterialDivider c;
    public final AppCompatImageView d;
    public final GifRecyclerView e;
    public final AppCompatTextView f;
    public final TextView g;

    private C18632oz2(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialDivider materialDivider, AppCompatImageView appCompatImageView, GifRecyclerView gifRecyclerView, AppCompatTextView appCompatTextView, TextView textView) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = materialDivider;
        this.d = appCompatImageView;
        this.e = gifRecyclerView;
        this.f = appCompatTextView;
        this.g = textView;
    }

    public static C18632oz2 a(View view) {
        int i = BC5.btn_add_more_gifs;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.divider_gifs;
            MaterialDivider materialDivider = (MaterialDivider) AbstractC11738dW7.a(view, i);
            if (materialDivider != null) {
                i = BC5.img_add_more_gifs;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = BC5.recycler_gifs;
                    GifRecyclerView gifRecyclerView = (GifRecyclerView) AbstractC11738dW7.a(view, i);
                    if (gifRecyclerView != null) {
                        i = BC5.tvNoPermission;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) AbstractC11738dW7.a(view, i);
                        if (appCompatTextView != null) {
                            i = BC5.txt_page_title_gifs;
                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView != null) {
                                return new C18632oz2((ConstraintLayout) view, materialButton, materialDivider, appCompatImageView, gifRecyclerView, appCompatTextView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C18632oz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_smiles_gif, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
