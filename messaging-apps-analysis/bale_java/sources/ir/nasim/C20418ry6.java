package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

/* renamed from: ir.nasim.ry6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20418ry6 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppCompatCheckBox b;
    public final LinearLayout c;
    public final TextView d;
    public final CardView e;
    public final TextView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final FrameLayout l;

    private C20418ry6(LinearLayout linearLayout, AppCompatCheckBox appCompatCheckBox, LinearLayout linearLayout2, TextView textView, CardView cardView, TextView textView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView3, TextView textView4, TextView textView5, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = appCompatCheckBox;
        this.c = linearLayout2;
        this.d = textView;
        this.e = cardView;
        this.f = textView2;
        this.g = appCompatImageView;
        this.h = appCompatImageView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = frameLayout;
    }

    public static C20418ry6 a(View view) {
        int i = AbstractC17581nC5.chb_selected;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) AbstractC11738dW7.a(view, i);
        if (appCompatCheckBox != null) {
            i = AbstractC17581nC5.content_container;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = AbstractC17581nC5.date_txt;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = AbstractC17581nC5.downloadState_container;
                    CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                    if (cardView != null) {
                        i = AbstractC17581nC5.ext_txt;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = AbstractC17581nC5.img_downloadState;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                            if (appCompatImageView != null) {
                                i = AbstractC17581nC5.img_logo;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                if (appCompatImageView2 != null) {
                                    i = AbstractC17581nC5.name_txt;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        i = AbstractC17581nC5.size_txt;
                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView4 != null) {
                                            i = AbstractC17581nC5.title_date;
                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView5 != null) {
                                                i = AbstractC17581nC5.top_spacer;
                                                FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                if (frameLayout != null) {
                                                    return new C20418ry6((LinearLayout) view, appCompatCheckBox, linearLayout, textView, cardView, textView2, appCompatImageView, appCompatImageView2, textView3, textView4, textView5, frameLayout);
                                                }
                                            }
                                        }
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

    public static C20418ry6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.shared_media_file_item, viewGroup, false);
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
