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
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.ky6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16263ky6 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final CircleProgressBar c;
    public final AppCompatCheckBox d;
    public final CardView e;
    public final LinearLayout f;
    public final TextView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final FrameLayout m;

    private C16263ky6(LinearLayout linearLayout, TextView textView, CircleProgressBar circleProgressBar, AppCompatCheckBox appCompatCheckBox, CardView cardView, LinearLayout linearLayout2, TextView textView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView3, TextView textView4, TextView textView5, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = textView;
        this.c = circleProgressBar;
        this.d = appCompatCheckBox;
        this.e = cardView;
        this.f = linearLayout2;
        this.g = textView2;
        this.h = appCompatImageView;
        this.i = appCompatImageView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
        this.m = frameLayout;
    }

    public static C16263ky6 a(View view) {
        int i = AbstractC17581nC5.artist_name_txt;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = AbstractC17581nC5.audio_progressView;
            CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
            if (circleProgressBar != null) {
                i = AbstractC17581nC5.chb_selected;
                AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) AbstractC11738dW7.a(view, i);
                if (appCompatCheckBox != null) {
                    i = AbstractC17581nC5.container_downloadState;
                    CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                    if (cardView != null) {
                        i = AbstractC17581nC5.content_container;
                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout != null) {
                            i = AbstractC17581nC5.date_txt;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = AbstractC17581nC5.img_background;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                if (appCompatImageView != null) {
                                    i = AbstractC17581nC5.img_downloadState;
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
                                                        return new C16263ky6((LinearLayout) view, textView, circleProgressBar, appCompatCheckBox, cardView, linearLayout, textView2, appCompatImageView, appCompatImageView2, textView3, textView4, textView5, frameLayout);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16263ky6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.shared_media_audio_item, viewGroup, false);
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
