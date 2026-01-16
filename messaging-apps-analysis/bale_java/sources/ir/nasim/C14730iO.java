package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.iO, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14730iO implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final View c;
    public final TextView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final TextView h;

    private C14730iO(ConstraintLayout constraintLayout, View view, View view2, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = view2;
        this.d = textView;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = textView2;
    }

    public static C14730iO a(View view) {
        View viewA;
        int i = BC5.bottom_margin_view;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.top_margin_view))) != null) {
            i = BC5.top_player_audio_title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.top_player_close_play_bar;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.top_player_play_toggle;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        i = BC5.top_player_speed_voice;
                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView3 != null) {
                            i = BC5.top_player_timer;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                return new C14730iO((ConstraintLayout) view, viewA2, viewA, textView, imageView, imageView2, imageView3, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C14730iO c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.audio_play_bar, viewGroup, false);
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
