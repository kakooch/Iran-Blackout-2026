package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.yz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24656yz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final ConstraintLayout f;
    public final ProgressBar g;
    public final RadioButton h;
    public final RadioButton i;
    public final RadioButton j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final AppBarLayout o;
    public final TextView p;
    public final BaleToolbar q;

    private C24656yz2(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ProgressBar progressBar, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView, TextView textView2, TextView textView3, TextView textView4, AppBarLayout appBarLayout, TextView textView5, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = constraintLayout2;
        this.e = constraintLayout3;
        this.f = constraintLayout4;
        this.g = progressBar;
        this.h = radioButton;
        this.i = radioButton2;
        this.j = radioButton3;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = appBarLayout;
        this.p = textView5;
        this.q = baleToolbar;
    }

    public static C24656yz2 a(View view) {
        int i = AbstractC18172oC5.privacy_image_button_exclude;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = AbstractC18172oC5.privacy_image_button_include;
            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView2 != null) {
                i = AbstractC18172oC5.privacy_layout_contacts;
                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                if (constraintLayout != null) {
                    i = AbstractC18172oC5.privacy_layout_exclude;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout2 != null) {
                        i = AbstractC18172oC5.privacy_layout_include;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout3 != null) {
                            i = AbstractC18172oC5.privacy_loading_progressBar;
                            ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                            if (progressBar != null) {
                                i = AbstractC18172oC5.privacy_radio_button_contacts;
                                RadioButton radioButton = (RadioButton) AbstractC11738dW7.a(view, i);
                                if (radioButton != null) {
                                    i = AbstractC18172oC5.privacy_radio_button_exclude;
                                    RadioButton radioButton2 = (RadioButton) AbstractC11738dW7.a(view, i);
                                    if (radioButton2 != null) {
                                        i = AbstractC18172oC5.privacy_radio_button_include;
                                        RadioButton radioButton3 = (RadioButton) AbstractC11738dW7.a(view, i);
                                        if (radioButton3 != null) {
                                            i = AbstractC18172oC5.privacy_subtitle_contacts;
                                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView != null) {
                                                i = AbstractC18172oC5.privacy_subtitle_exclude;
                                                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView2 != null) {
                                                    i = AbstractC18172oC5.privacy_subtitle_include;
                                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView3 != null) {
                                                        i = AbstractC18172oC5.privacy_title;
                                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView4 != null) {
                                                            i = AbstractC18172oC5.story_privacy_appbar;
                                                            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                            if (appBarLayout != null) {
                                                                i = AbstractC18172oC5.story_privacy_bottom_info;
                                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView5 != null) {
                                                                    i = AbstractC18172oC5.story_privacy_toolbar;
                                                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                                    if (baleToolbar != null) {
                                                                        return new C24656yz2((ConstraintLayout) view, imageView, imageView2, constraintLayout, constraintLayout2, constraintLayout3, progressBar, radioButton, radioButton2, radioButton3, textView, textView2, textView3, textView4, appBarLayout, textView5, baleToolbar);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C24656yz2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C24656yz2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_story_privacy, viewGroup, false);
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
