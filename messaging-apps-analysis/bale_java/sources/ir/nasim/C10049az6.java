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

/* renamed from: ir.nasim.az6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C10049az6 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final CircleProgressBar b;
    public final AppCompatCheckBox c;
    public final CardView d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final AppCompatImageView h;
    public final TextView i;
    public final TextView j;
    public final FrameLayout k;

    private C10049az6(LinearLayout linearLayout, CircleProgressBar circleProgressBar, AppCompatCheckBox appCompatCheckBox, CardView cardView, LinearLayout linearLayout2, TextView textView, TextView textView2, AppCompatImageView appCompatImageView, TextView textView3, TextView textView4, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = circleProgressBar;
        this.c = appCompatCheckBox;
        this.d = cardView;
        this.e = linearLayout2;
        this.f = textView;
        this.g = textView2;
        this.h = appCompatImageView;
        this.i = textView3;
        this.j = textView4;
        this.k = frameLayout;
    }

    public static C10049az6 a(View view) {
        int i = AbstractC17581nC5.audio_progressView;
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
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = AbstractC17581nC5.duration_txt;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = AbstractC17581nC5.img_downloadState;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                if (appCompatImageView != null) {
                                    i = AbstractC17581nC5.name_txt;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        i = AbstractC17581nC5.title_date;
                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView4 != null) {
                                            i = AbstractC17581nC5.top_spacer;
                                            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                            if (frameLayout != null) {
                                                return new C10049az6((LinearLayout) view, circleProgressBar, appCompatCheckBox, cardView, linearLayout, textView, textView2, appCompatImageView, textView3, textView4, frameLayout);
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

    public static C10049az6 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.shared_media_voice_item, viewGroup, false);
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
