package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.DividerView;
import ir.nasim.designsystem.TintImageView;
import ir.nasim.features.conversation.view.BubbleTextContainer;
import ir.nasim.features.conversation.view.QuoteMessageView;

/* renamed from: ir.nasim.cx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11407cx2 implements InterfaceC9764aW7 {
    public final FrameLayout A;
    public final TextView B;
    public final TextView C;
    public final RadioButton D;
    public final View E;
    public final FrameLayout F;
    public final TextView G;
    public final TintImageView H;
    public final TintImageView I;
    public final LinearLayout J;
    public final LinearLayout K;
    public final BaleToolbar L;
    public final ImageView M;
    public final ImageView N;
    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final QuoteMessageView R;
    public final QuoteMessageView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final TextView W;
    private final LinearLayout a;
    public final ConstraintLayout b;
    public final FrameLayout c;
    public final TextView d;
    public final RadioButton e;
    public final BubbleTextContainer f;
    public final BubbleTextContainer g;
    public final DividerView h;
    public final DividerView i;
    public final ConstraintLayout j;
    public final RadioGroup k;
    public final RadioButton l;
    public final RadioButton m;
    public final TextView n;
    public final FrameLayout o;
    public final TextView p;
    public final FrameLayout q;
    public final TextView r;
    public final FrameLayout s;
    public final ConstraintLayout t;
    public final SeekBar u;
    public final ImageView v;
    public final ImageView w;
    public final TextView x;
    public final TextView y;
    public final View z;

    private C11407cx2(LinearLayout linearLayout, ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, RadioButton radioButton, BubbleTextContainer bubbleTextContainer, BubbleTextContainer bubbleTextContainer2, DividerView dividerView, DividerView dividerView2, ConstraintLayout constraintLayout2, RadioGroup radioGroup, RadioButton radioButton2, RadioButton radioButton3, TextView textView2, FrameLayout frameLayout2, TextView textView3, FrameLayout frameLayout3, TextView textView4, FrameLayout frameLayout4, ConstraintLayout constraintLayout3, SeekBar seekBar, ImageView imageView, ImageView imageView2, TextView textView5, TextView textView6, View view, FrameLayout frameLayout5, TextView textView7, TextView textView8, RadioButton radioButton4, View view2, FrameLayout frameLayout6, TextView textView9, TintImageView tintImageView, TintImageView tintImageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, BaleToolbar baleToolbar, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, QuoteMessageView quoteMessageView, QuoteMessageView quoteMessageView2, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.a = linearLayout;
        this.b = constraintLayout;
        this.c = frameLayout;
        this.d = textView;
        this.e = radioButton;
        this.f = bubbleTextContainer;
        this.g = bubbleTextContainer2;
        this.h = dividerView;
        this.i = dividerView2;
        this.j = constraintLayout2;
        this.k = radioGroup;
        this.l = radioButton2;
        this.m = radioButton3;
        this.n = textView2;
        this.o = frameLayout2;
        this.p = textView3;
        this.q = frameLayout3;
        this.r = textView4;
        this.s = frameLayout4;
        this.t = constraintLayout3;
        this.u = seekBar;
        this.v = imageView;
        this.w = imageView2;
        this.x = textView5;
        this.y = textView6;
        this.z = view;
        this.A = frameLayout5;
        this.B = textView7;
        this.C = textView8;
        this.D = radioButton4;
        this.E = view2;
        this.F = frameLayout6;
        this.G = textView9;
        this.H = tintImageView;
        this.I = tintImageView2;
        this.J = linearLayout2;
        this.K = linearLayout3;
        this.L = baleToolbar;
        this.M = imageView3;
        this.N = imageView4;
        this.O = imageView5;
        this.P = imageView6;
        this.Q = imageView7;
        this.R = quoteMessageView;
        this.S = quoteMessageView2;
        this.T = textView10;
        this.U = textView11;
        this.V = textView12;
        this.W = textView13;
    }

    public static C11407cx2 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.background;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = BC5.big_sample_layout;
            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
            if (frameLayout != null) {
                i = BC5.big_sample_text_view;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.classic_font;
                    RadioButton radioButton = (RadioButton) AbstractC11738dW7.a(view, i);
                    if (radioButton != null) {
                        i = BC5.container;
                        BubbleTextContainer bubbleTextContainer = (BubbleTextContainer) AbstractC11738dW7.a(view, i);
                        if (bubbleTextContainer != null) {
                            i = BC5.container_first;
                            BubbleTextContainer bubbleTextContainer2 = (BubbleTextContainer) AbstractC11738dW7.a(view, i);
                            if (bubbleTextContainer2 != null) {
                                i = BC5.divider_sapta;
                                DividerView dividerView = (DividerView) AbstractC11738dW7.a(view, i);
                                if (dividerView != null) {
                                    i = BC5.divider_sapta2;
                                    DividerView dividerView2 = (DividerView) AbstractC11738dW7.a(view, i);
                                    if (dividerView2 != null) {
                                        i = BC5.fontContainer;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                        if (constraintLayout2 != null) {
                                            i = BC5.font_radio_group;
                                            RadioGroup radioGroup = (RadioGroup) AbstractC11738dW7.a(view, i);
                                            if (radioGroup != null) {
                                                i = BC5.iran_sans_font;
                                                RadioButton radioButton2 = (RadioButton) AbstractC11738dW7.a(view, i);
                                                if (radioButton2 != null) {
                                                    i = BC5.iransharp_font;
                                                    RadioButton radioButton3 = (RadioButton) AbstractC11738dW7.a(view, i);
                                                    if (radioButton3 != null) {
                                                        i = BC5.message_font_change_hint;
                                                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView2 != null) {
                                                            i = BC5.message_font_change_hint_layout;
                                                            FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                            if (frameLayout2 != null) {
                                                                i = BC5.message_text_size_change_hint;
                                                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView3 != null) {
                                                                    i = BC5.message_text_size_change_hint_layout;
                                                                    FrameLayout frameLayout3 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                    if (frameLayout3 != null) {
                                                                        i = BC5.message_text_size_change_preview_hint;
                                                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView4 != null) {
                                                                            i = BC5.message_text_size_change_preview_hint_layout;
                                                                            FrameLayout frameLayout4 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                            if (frameLayout4 != null) {
                                                                                i = BC5.message_text_size_changer_layout;
                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                if (constraintLayout3 != null) {
                                                                                    i = BC5.message_text_size_seek_bar;
                                                                                    SeekBar seekBar = (SeekBar) AbstractC11738dW7.a(view, i);
                                                                                    if (seekBar != null) {
                                                                                        i = BC5.pfm_tag_iv;
                                                                                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                        if (imageView != null) {
                                                                                            i = BC5.pfm_tag_iv2;
                                                                                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                            if (imageView2 != null) {
                                                                                                i = BC5.pfm_tag_tv;
                                                                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = BC5.pfm_tag_tv2;
                                                                                                    TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                    if (textView6 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.radio_shadow))) != null) {
                                                                                                        i = BC5.seekbar_layout;
                                                                                                        FrameLayout frameLayout5 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                                        if (frameLayout5 != null) {
                                                                                                            i = BC5.sender_name;
                                                                                                            TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = BC5.sender_name_first;
                                                                                                                TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = BC5.shabnam_font;
                                                                                                                    RadioButton radioButton4 = (RadioButton) AbstractC11738dW7.a(view, i);
                                                                                                                    if (radioButton4 != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.shadow))) != null) {
                                                                                                                        i = BC5.small_sample_layout;
                                                                                                                        FrameLayout frameLayout6 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                                                        if (frameLayout6 != null) {
                                                                                                                            i = BC5.small_sample_text_view;
                                                                                                                            TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = BC5.stateIcon;
                                                                                                                                TintImageView tintImageView = (TintImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                if (tintImageView != null) {
                                                                                                                                    i = BC5.stateIcon_first;
                                                                                                                                    TintImageView tintImageView2 = (TintImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                    if (tintImageView2 != null) {
                                                                                                                                        i = BC5.tag_linearContainer_pfm;
                                                                                                                                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                        if (linearLayout != null) {
                                                                                                                                            i = BC5.tag_linearContainer_pfm2;
                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                i = BC5.text_size_toolbar;
                                                                                                                                                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                                                                                                                if (baleToolbar != null) {
                                                                                                                                                    i = BC5.tickmark_1;
                                                                                                                                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                    if (imageView3 != null) {
                                                                                                                                                        i = BC5.tickmark_2;
                                                                                                                                                        ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                        if (imageView4 != null) {
                                                                                                                                                            i = BC5.tickmark_3;
                                                                                                                                                            ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                                i = BC5.tickmark_4;
                                                                                                                                                                ImageView imageView6 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                    i = BC5.tickmark_5;
                                                                                                                                                                    ImageView imageView7 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                        i = BC5.tv_quote;
                                                                                                                                                                        QuoteMessageView quoteMessageView = (QuoteMessageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                        if (quoteMessageView != null) {
                                                                                                                                                                            i = BC5.tv_quote_first;
                                                                                                                                                                            QuoteMessageView quoteMessageView2 = (QuoteMessageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                            if (quoteMessageView2 != null) {
                                                                                                                                                                                i = BC5.tv_text;
                                                                                                                                                                                TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                    i = BC5.tv_text_first;
                                                                                                                                                                                    TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                        i = BC5.tv_time;
                                                                                                                                                                                        TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                            i = BC5.tv_time_first;
                                                                                                                                                                                            TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                return new C11407cx2((LinearLayout) view, constraintLayout, frameLayout, textView, radioButton, bubbleTextContainer, bubbleTextContainer2, dividerView, dividerView2, constraintLayout2, radioGroup, radioButton2, radioButton3, textView2, frameLayout2, textView3, frameLayout3, textView4, frameLayout4, constraintLayout3, seekBar, imageView, imageView2, textView5, textView6, viewA, frameLayout5, textView7, textView8, radioButton4, viewA2, frameLayout6, textView9, tintImageView, tintImageView2, linearLayout, linearLayout2, baleToolbar, imageView3, imageView4, imageView5, imageView6, imageView7, quoteMessageView, quoteMessageView2, textView10, textView11, textView12, textView13);
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

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
