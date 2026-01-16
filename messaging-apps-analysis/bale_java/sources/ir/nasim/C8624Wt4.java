package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* renamed from: ir.nasim.Wt4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8624Wt4 implements InterfaceC9764aW7 {
    public final ConstraintLayout A;
    public final TextView B;
    public final TextView C;
    public final ConstraintLayout D;
    public final TextView E;
    public final ConstraintLayout F;
    public final AvatarViewGlide G;
    public final TextView H;
    public final TextView I;
    public final ImageView J;
    public final ImageView K;
    public final TextView L;
    public final ConstraintLayout M;
    public final ImageView N;
    public final ImageView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final ConstraintLayout S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final ConstraintLayout W;
    public final View X;
    public final View Y;
    public final View Z;
    private final FrameLayout a;
    public final View a0;
    public final LottieAnimationView b;
    public final TextView b0;
    public final TextView c;
    public final TextView c0;
    public final ImageView d;
    public final LottieAnimationView d0;
    public final ConstraintLayout e;
    public final TextView e0;
    public final AppBarLayout f;
    public final ConstraintLayout f0;
    public final View g;
    public final Guideline g0;
    public final TextView h;
    public final Guideline h0;
    public final TextView i;
    public final Guideline i0;
    public final TextView j;
    public final Guideline j0;
    public final TextView k;
    public final TextView k0;
    public final O50 l;
    public final ConstraintLayout l0;
    public final TextView m;
    public final TextView n;
    public final RecyclerView o;
    public final TextView p;
    public final ConstraintLayout q;
    public final C24842zI2 r;
    public final ScrollView s;
    public final TextView t;
    public final TextView u;
    public final ConstraintLayout v;
    public final TextView w;
    public final ConstraintLayout x;
    public final ConstraintLayout y;
    public final TextView z;

    private C8624Wt4(FrameLayout frameLayout, LottieAnimationView lottieAnimationView, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, AppBarLayout appBarLayout, View view, TextView textView2, TextView textView3, TextView textView4, TextView textView5, O50 o50, TextView textView6, TextView textView7, RecyclerView recyclerView, TextView textView8, ConstraintLayout constraintLayout2, C24842zI2 c24842zI2, ScrollView scrollView, TextView textView9, TextView textView10, ConstraintLayout constraintLayout3, TextView textView11, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView12, ConstraintLayout constraintLayout6, TextView textView13, TextView textView14, ConstraintLayout constraintLayout7, TextView textView15, ConstraintLayout constraintLayout8, AvatarViewGlide avatarViewGlide, TextView textView16, TextView textView17, ImageView imageView2, ImageView imageView3, TextView textView18, ConstraintLayout constraintLayout9, ImageView imageView4, ImageView imageView5, TextView textView19, TextView textView20, TextView textView21, ConstraintLayout constraintLayout10, TextView textView22, TextView textView23, TextView textView24, ConstraintLayout constraintLayout11, View view2, View view3, View view4, View view5, TextView textView25, TextView textView26, LottieAnimationView lottieAnimationView2, TextView textView27, ConstraintLayout constraintLayout12, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TextView textView28, ConstraintLayout constraintLayout13) {
        this.a = frameLayout;
        this.b = lottieAnimationView;
        this.c = textView;
        this.d = imageView;
        this.e = constraintLayout;
        this.f = appBarLayout;
        this.g = view;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = o50;
        this.m = textView6;
        this.n = textView7;
        this.o = recyclerView;
        this.p = textView8;
        this.q = constraintLayout2;
        this.r = c24842zI2;
        this.s = scrollView;
        this.t = textView9;
        this.u = textView10;
        this.v = constraintLayout3;
        this.w = textView11;
        this.x = constraintLayout4;
        this.y = constraintLayout5;
        this.z = textView12;
        this.A = constraintLayout6;
        this.B = textView13;
        this.C = textView14;
        this.D = constraintLayout7;
        this.E = textView15;
        this.F = constraintLayout8;
        this.G = avatarViewGlide;
        this.H = textView16;
        this.I = textView17;
        this.J = imageView2;
        this.K = imageView3;
        this.L = textView18;
        this.M = constraintLayout9;
        this.N = imageView4;
        this.O = imageView5;
        this.P = textView19;
        this.Q = textView20;
        this.R = textView21;
        this.S = constraintLayout10;
        this.T = textView22;
        this.U = textView23;
        this.V = textView24;
        this.W = constraintLayout11;
        this.X = view2;
        this.Y = view3;
        this.Z = view4;
        this.a0 = view5;
        this.b0 = textView25;
        this.c0 = textView26;
        this.d0 = lottieAnimationView2;
        this.e0 = textView27;
        this.f0 = constraintLayout12;
        this.g0 = guideline;
        this.h0 = guideline2;
        this.i0 = guideline3;
        this.j0 = guideline4;
        this.k0 = textView28;
        this.l0 = constraintLayout13;
    }

    public static C8624Wt4 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        View viewA6;
        View viewA7;
        int i = BC5.gift_loading_result_lottie_animation;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
        if (lottieAnimationView != null) {
            i = BC5.gift_packet_amount_gift;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.gift_packet_big_icon;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.gift_packet_gift_title;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = BC5.gift_packet_header;
                        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                        if (appBarLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.gift_packet_header_shadow))) != null) {
                            i = BC5.gift_packet_owner_received_count;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.gift_packet_owner_remain_count;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.gift_packet_owner_title_received;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = BC5.gift_packet_owner_title_remain;
                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView5 != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.gift_packet_progress_bar_view))) != null) {
                                            O50 o50A = O50.a(viewA2);
                                            i = BC5.gift_packet_receiver_received_count;
                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView6 != null) {
                                                i = BC5.gift_packet_receiver_title_received;
                                                TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView7 != null) {
                                                    i = BC5.gift_packet_recyclerView;
                                                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                    if (recyclerView != null) {
                                                        i = BC5.gift_packet_result_back;
                                                        TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView8 != null) {
                                                            i = BC5.gift_packet_result_container;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                            if (constraintLayout2 != null && (viewA3 = AbstractC11738dW7.a(view, (i = BC5.gift_packet_result_empty_state_container))) != null) {
                                                                C24842zI2 c24842zI2A = C24842zI2.a(viewA3);
                                                                i = BC5.gift_packet_result_list;
                                                                ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                                                                if (scrollView != null) {
                                                                    i = BC5.gift_packet_result_loading_message;
                                                                    TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView9 != null) {
                                                                        i = BC5.gift_packet_result_loser_amount;
                                                                        TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView10 != null) {
                                                                            i = BC5.gift_packet_result_loser_amount_constraint;
                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                            if (constraintLayout3 != null) {
                                                                                i = BC5.gift_packet_result_loser_amount_rial;
                                                                                TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView11 != null) {
                                                                                    i = BC5.gift_packet_result_owner;
                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                    if (constraintLayout4 != null) {
                                                                                        i = BC5.gift_packet_result_receiver;
                                                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                        if (constraintLayout5 != null) {
                                                                                            i = BC5.gift_packet_result_receiver_count;
                                                                                            TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                            if (textView12 != null) {
                                                                                                i = BC5.gift_packet_result_receiver_count_container;
                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                if (constraintLayout6 != null) {
                                                                                                    i = BC5.gift_packet_result_receiver_count_title;
                                                                                                    TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                    if (textView13 != null) {
                                                                                                        i = BC5.gift_packet_result_remain_count;
                                                                                                        TextView textView14 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                        if (textView14 != null) {
                                                                                                            i = BC5.gift_packet_result_remain_count_layout;
                                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                            if (constraintLayout7 != null) {
                                                                                                                i = BC5.gift_packet_result_remain_count_text;
                                                                                                                TextView textView15 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = BC5.gift_packet_result_sender;
                                                                                                                    ConstraintLayout constraintLayout8 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                    if (constraintLayout8 != null) {
                                                                                                                        i = BC5.gift_packet_result_sender_avatar;
                                                                                                                        AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                                                        if (avatarViewGlide != null) {
                                                                                                                            i = BC5.gift_packet_result_sender_name;
                                                                                                                            TextView textView16 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i = BC5.gift_packet_result_status_text;
                                                                                                                                TextView textView17 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    i = BC5.gift_packet_result_status_text_bottom;
                                                                                                                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                    if (imageView2 != null) {
                                                                                                                                        i = BC5.gift_packet_result_status_text_top;
                                                                                                                                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                        if (imageView3 != null) {
                                                                                                                                            i = BC5.gift_packet_result_timer;
                                                                                                                                            TextView textView18 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                            if (textView18 != null) {
                                                                                                                                                i = BC5.gift_packet_result_timer_bg;
                                                                                                                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                if (constraintLayout9 != null) {
                                                                                                                                                    i = BC5.gift_packet_result_timer_icon;
                                                                                                                                                    ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                    if (imageView4 != null) {
                                                                                                                                                        i = BC5.gift_packet_result_timer_icon_title;
                                                                                                                                                        ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                        if (imageView5 != null) {
                                                                                                                                                            i = BC5.gift_packet_result_timer_title;
                                                                                                                                                            TextView textView19 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                i = BC5.gift_packet_result_title;
                                                                                                                                                                TextView textView20 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                    i = BC5.gift_packet_result_win_amount;
                                                                                                                                                                    TextView textView21 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                        i = BC5.gift_packet_result_win_amount_constraint;
                                                                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                                                                            i = BC5.gift_packet_result_win_amount_rial;
                                                                                                                                                                            TextView textView22 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                i = BC5.gift_packet_result_win_status;
                                                                                                                                                                                TextView textView23 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                    i = BC5.gift_packet_result_win_status_done;
                                                                                                                                                                                    TextView textView24 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                        i = BC5.gift_packet_title_container;
                                                                                                                                                                                        ConstraintLayout constraintLayout11 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                        if (constraintLayout11 != null && (viewA4 = AbstractC11738dW7.a(view, (i = BC5.gift_packet_title_separator))) != null && (viewA5 = AbstractC11738dW7.a(view, (i = BC5.gift_packet_title_separator_2))) != null && (viewA6 = AbstractC11738dW7.a(view, (i = BC5.gift_packet_title_separator_2_receiver))) != null && (viewA7 = AbstractC11738dW7.a(view, (i = BC5.gift_packet_title_separator_receiver))) != null) {
                                                                                                                                                                                            i = BC5.gift_packet_total;
                                                                                                                                                                                            TextView textView25 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                i = BC5.gift_packet_total_title_remain;
                                                                                                                                                                                                TextView textView26 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                    i = BC5.gift_packet_winner_animation;
                                                                                                                                                                                                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                    if (lottieAnimationView2 != null) {
                                                                                                                                                                                                        i = BC5.gift_packet_your_gift;
                                                                                                                                                                                                        TextView textView27 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                            i = BC5.gift_root;
                                                                                                                                                                                                            ConstraintLayout constraintLayout12 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                            if (constraintLayout12 != null) {
                                                                                                                                                                                                                i = BC5.guidline_gift_packet;
                                                                                                                                                                                                                Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                if (guideline != null) {
                                                                                                                                                                                                                    i = BC5.guidline_gift_packet_owner;
                                                                                                                                                                                                                    Guideline guideline2 = (Guideline) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                    if (guideline2 != null) {
                                                                                                                                                                                                                        i = BC5.guidline_gift_packet_receiver;
                                                                                                                                                                                                                        Guideline guideline3 = (Guideline) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                        if (guideline3 != null) {
                                                                                                                                                                                                                            i = BC5.guidline_gift_packet_win;
                                                                                                                                                                                                                            Guideline guideline4 = (Guideline) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                            if (guideline4 != null) {
                                                                                                                                                                                                                                i = BC5.snack_bar;
                                                                                                                                                                                                                                TextView textView28 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                if (textView28 != null) {
                                                                                                                                                                                                                                    i = BC5.status_of_packet_counts;
                                                                                                                                                                                                                                    ConstraintLayout constraintLayout13 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                    if (constraintLayout13 != null) {
                                                                                                                                                                                                                                        return new C8624Wt4((FrameLayout) view, lottieAnimationView, textView, imageView, constraintLayout, appBarLayout, viewA, textView2, textView3, textView4, textView5, o50A, textView6, textView7, recyclerView, textView8, constraintLayout2, c24842zI2A, scrollView, textView9, textView10, constraintLayout3, textView11, constraintLayout4, constraintLayout5, textView12, constraintLayout6, textView13, textView14, constraintLayout7, textView15, constraintLayout8, avatarViewGlide, textView16, textView17, imageView2, imageView3, textView18, constraintLayout9, imageView4, imageView5, textView19, textView20, textView21, constraintLayout10, textView22, textView23, textView24, constraintLayout11, viewA4, viewA5, viewA6, viewA7, textView25, textView26, lottieAnimationView2, textView27, constraintLayout12, guideline, guideline2, guideline3, guideline4, textView28, constraintLayout13);
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

    public static C8624Wt4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.new_gift_packet_recycler_result_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
