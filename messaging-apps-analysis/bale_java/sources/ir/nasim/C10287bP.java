package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatImageView;

/* renamed from: ir.nasim.bP, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10287bP implements InterfaceC9764aW7 {
    private final View a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final ViewSwitcher h;
    public final AppCompatImageView i;
    public final ViewSwitcher j;

    private C10287bP(View view, TextView textView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ViewSwitcher viewSwitcher, AppCompatImageView appCompatImageView4, ViewSwitcher viewSwitcher2) {
        this.a = view;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = appCompatImageView;
        this.f = appCompatImageView2;
        this.g = appCompatImageView3;
        this.h = viewSwitcher;
        this.i = appCompatImageView4;
        this.j = viewSwitcher2;
    }

    public static C10287bP a(View view) {
        int i = AbstractC9582aC5.cancelSliderTextView;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = AbstractC9582aC5.cancelTextView;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                i = AbstractC9582aC5.durationTextView;
                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView3 != null) {
                    i = AbstractC9582aC5.endImageView;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView != null) {
                        i = AbstractC9582aC5.lockContainerFirstImageView;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                        if (appCompatImageView2 != null) {
                            i = AbstractC9582aC5.lockContainerSecondImageView;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                            if (appCompatImageView3 != null) {
                                i = AbstractC9582aC5.lockViewSwitcher;
                                ViewSwitcher viewSwitcher = (ViewSwitcher) AbstractC11738dW7.a(view, i);
                                if (viewSwitcher != null) {
                                    i = AbstractC9582aC5.startImageView;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                                    if (appCompatImageView4 != null) {
                                        i = AbstractC9582aC5.textViewSwitcher;
                                        ViewSwitcher viewSwitcher2 = (ViewSwitcher) AbstractC11738dW7.a(view, i);
                                        if (viewSwitcher2 != null) {
                                            return new C10287bP(view, textView, textView2, textView3, appCompatImageView, appCompatImageView2, appCompatImageView3, viewSwitcher, appCompatImageView4, viewSwitcher2);
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

    public static C10287bP b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(AbstractC10185bD5.audio_recorder_view, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
