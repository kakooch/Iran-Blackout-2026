package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.Zx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9433Zx2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final MaterialButton b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final MaterialCardView g;
    public final MaterialButton h;
    public final TextView i;

    private C9433Zx2(LinearLayout linearLayout, MaterialButton materialButton, ImageView imageView, TextView textView, TextView textView2, TextView textView3, MaterialCardView materialCardView, MaterialButton materialButton2, TextView textView4) {
        this.a = linearLayout;
        this.b = materialButton;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = materialCardView;
        this.h = materialButton2;
        this.i = textView4;
    }

    public static C9433Zx2 a(View view) {
        int i = BC5.cancelBtn;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.copyImg;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.description;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.linkDescTxt;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.linkTxt;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.materialCardView;
                            MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                            if (materialCardView != null) {
                                i = BC5.shareBtn;
                                MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
                                if (materialButton2 != null) {
                                    i = BC5.title;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        return new C9433Zx2((LinearLayout) view, materialButton, imageView, textView, textView2, textView3, materialCardView, materialButton2, textView4);
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

    public static C9433Zx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_crowdfunding_copy_link, viewGroup, false);
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
