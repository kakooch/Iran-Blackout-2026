package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import ir.nasim.designsystem.DividerView;
import ir.nasim.features.audioplayer.ui.AudioPlayBar;
import ir.nasim.features.story.avatarwithstory.AvatarWithStory;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;

/* renamed from: ir.nasim.My2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6281My2 implements InterfaceC9764aW7 {
    public final LinearLayout A;
    public final ComposeView B;
    public final TextView C;
    public final FrameLayout D;
    public final CardView E;
    public final ImageView F;
    public final LinearLayout G;
    public final ImageView H;
    public final ImageView I;
    public final ImageView J;
    public final FrameLayout K;
    public final LinearLayout L;
    public final LinearLayout M;
    public final LinearLayout N;
    public final CoordinatorLayout O;
    public final LinearLayout P;
    public final TextView Q;
    public final ConstraintLayout R;
    public final TextView S;
    public final TextView T;
    public final ConstraintLayout U;
    public final SwitchCompat V;
    public final TextView W;
    public final DividerView X;
    public final ViewPager2 Y;
    public final LinearLayout Z;
    private final ConstraintLayout a;
    public final TextView a0;
    public final LinearLayout b;
    public final TextView b0;
    public final TextView c;
    public final RLottieImageView c0;
    public final TextView d;
    public final TextView d0;
    public final ComposeView e;
    public final LinearLayout e0;
    public final TextView f;
    public final ImageView f0;
    public final LinearLayout g;
    public final CardView g0;
    public final ImageView h;
    public final ImageView h0;
    public final TextView i;
    public final LinearLayout i0;
    public final AvatarWithStory j;
    public final TabLayout j0;
    public final CollapsingToolbarLayout k;
    public final AppBarLayout k0;
    public final LinearLayout l;
    public final AudioPlayBar l0;
    public final AppBarLayout m;
    public final TextView m0;
    public final ComposeView n;
    public final TextView n0;
    public final ConstraintLayout o;
    public final TextView o0;
    public final SwitchCompat p;
    public final TextView q;
    public final TextView r;
    public final LinearLayout s;
    public final FloatingActionButton t;
    public final CardView u;
    public final ImageView v;
    public final CardView w;
    public final ImageView x;
    public final CardView y;
    public final ImageView z;

    private C6281My2(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, ComposeView composeView, TextView textView3, LinearLayout linearLayout2, ImageView imageView, TextView textView4, AvatarWithStory avatarWithStory, CollapsingToolbarLayout collapsingToolbarLayout, LinearLayout linearLayout3, AppBarLayout appBarLayout, ComposeView composeView2, ConstraintLayout constraintLayout2, SwitchCompat switchCompat, TextView textView5, TextView textView6, LinearLayout linearLayout4, FloatingActionButton floatingActionButton, CardView cardView, ImageView imageView2, CardView cardView2, ImageView imageView3, CardView cardView3, ImageView imageView4, LinearLayout linearLayout5, ComposeView composeView3, TextView textView7, FrameLayout frameLayout, CardView cardView4, ImageView imageView5, LinearLayout linearLayout6, ImageView imageView6, ImageView imageView7, ImageView imageView8, FrameLayout frameLayout2, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout10, TextView textView8, ConstraintLayout constraintLayout3, TextView textView9, TextView textView10, ConstraintLayout constraintLayout4, SwitchCompat switchCompat2, TextView textView11, DividerView dividerView, ViewPager2 viewPager2, LinearLayout linearLayout11, TextView textView12, TextView textView13, RLottieImageView rLottieImageView, TextView textView14, LinearLayout linearLayout12, ImageView imageView9, CardView cardView5, ImageView imageView10, LinearLayout linearLayout13, TabLayout tabLayout, AppBarLayout appBarLayout2, AudioPlayBar audioPlayBar, TextView textView15, TextView textView16, TextView textView17) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = textView;
        this.d = textView2;
        this.e = composeView;
        this.f = textView3;
        this.g = linearLayout2;
        this.h = imageView;
        this.i = textView4;
        this.j = avatarWithStory;
        this.k = collapsingToolbarLayout;
        this.l = linearLayout3;
        this.m = appBarLayout;
        this.n = composeView2;
        this.o = constraintLayout2;
        this.p = switchCompat;
        this.q = textView5;
        this.r = textView6;
        this.s = linearLayout4;
        this.t = floatingActionButton;
        this.u = cardView;
        this.v = imageView2;
        this.w = cardView2;
        this.x = imageView3;
        this.y = cardView3;
        this.z = imageView4;
        this.A = linearLayout5;
        this.B = composeView3;
        this.C = textView7;
        this.D = frameLayout;
        this.E = cardView4;
        this.F = imageView5;
        this.G = linearLayout6;
        this.H = imageView6;
        this.I = imageView7;
        this.J = imageView8;
        this.K = frameLayout2;
        this.L = linearLayout7;
        this.M = linearLayout8;
        this.N = linearLayout9;
        this.O = coordinatorLayout;
        this.P = linearLayout10;
        this.Q = textView8;
        this.R = constraintLayout3;
        this.S = textView9;
        this.T = textView10;
        this.U = constraintLayout4;
        this.V = switchCompat2;
        this.W = textView11;
        this.X = dividerView;
        this.Y = viewPager2;
        this.Z = linearLayout11;
        this.a0 = textView12;
        this.b0 = textView13;
        this.c0 = rLottieImageView;
        this.d0 = textView14;
        this.e0 = linearLayout12;
        this.f0 = imageView9;
        this.g0 = cardView5;
        this.h0 = imageView10;
        this.i0 = linearLayout13;
        this.j0 = tabLayout;
        this.k0 = appBarLayout2;
        this.l0 = audioPlayBar;
        this.m0 = textView15;
        this.n0 = textView16;
        this.o0 = textView17;
    }

    public static C6281My2 a(View view) {
        int i = AbstractC17581nC5.about_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC17581nC5.about_title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC17581nC5.about_txt;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = AbstractC17581nC5.ad_discount_promotion_notice_bar;
                    ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
                    if (composeView != null) {
                        i = AbstractC17581nC5.add_story_text;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = AbstractC17581nC5.admin_list_container;
                            LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                            if (linearLayout2 != null) {
                                i = AbstractC17581nC5.admin_list_img;
                                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView != null) {
                                    i = AbstractC17581nC5.admin_list_title;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = AbstractC17581nC5.avatar;
                                        AvatarWithStory avatarWithStory = (AvatarWithStory) AbstractC11738dW7.a(view, i);
                                        if (avatarWithStory != null) {
                                            i = AbstractC17581nC5.body_container;
                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) AbstractC11738dW7.a(view, i);
                                            if (collapsingToolbarLayout != null) {
                                                i = AbstractC17581nC5.body_container1;
                                                LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                if (linearLayout3 != null) {
                                                    i = AbstractC17581nC5.body_container_toolbar;
                                                    AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                    if (appBarLayout != null) {
                                                        i = AbstractC17581nC5.bot_items_compose_view;
                                                        ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
                                                        if (composeView2 != null) {
                                                            i = AbstractC17581nC5.call_notif_sound_container;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                            if (constraintLayout != null) {
                                                                i = AbstractC17581nC5.call_notif_sound_switch;
                                                                SwitchCompat switchCompat = (SwitchCompat) AbstractC11738dW7.a(view, i);
                                                                if (switchCompat != null) {
                                                                    i = AbstractC17581nC5.call_notif_sound_title;
                                                                    TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView5 != null) {
                                                                        i = AbstractC17581nC5.channel_management;
                                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView6 != null) {
                                                                            i = AbstractC17581nC5.channel_management_container;
                                                                            LinearLayout linearLayout4 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                            if (linearLayout4 != null) {
                                                                                i = AbstractC17581nC5.chat_fab;
                                                                                FloatingActionButton floatingActionButton = (FloatingActionButton) AbstractC11738dW7.a(view, i);
                                                                                if (floatingActionButton != null) {
                                                                                    i = AbstractC17581nC5.close_container;
                                                                                    CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                                                                    if (cardView != null) {
                                                                                        i = AbstractC17581nC5.close_img;
                                                                                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                        if (imageView2 != null) {
                                                                                            i = AbstractC17581nC5.delete_container;
                                                                                            CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                            if (cardView2 != null) {
                                                                                                i = AbstractC17581nC5.delete_img;
                                                                                                ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                if (imageView3 != null) {
                                                                                                    i = AbstractC17581nC5.download_container;
                                                                                                    CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                                    if (cardView3 != null) {
                                                                                                        i = AbstractC17581nC5.download_img;
                                                                                                        ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                        if (imageView4 != null) {
                                                                                                            i = AbstractC17581nC5.earn_money_ln;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i = AbstractC17581nC5.earn_money_notice_bar;
                                                                                                                ComposeView composeView3 = (ComposeView) AbstractC11738dW7.a(view, i);
                                                                                                                if (composeView3 != null) {
                                                                                                                    i = AbstractC17581nC5.earn_money_tv;
                                                                                                                    TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i = AbstractC17581nC5.fakeLayout;
                                                                                                                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                                                        if (frameLayout != null) {
                                                                                                                            i = AbstractC17581nC5.forward_container;
                                                                                                                            CardView cardView4 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                                                            if (cardView4 != null) {
                                                                                                                                i = AbstractC17581nC5.forward_img;
                                                                                                                                ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                if (imageView5 != null) {
                                                                                                                                    i = AbstractC17581nC5.full_container;
                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                        i = AbstractC17581nC5.img_back_button;
                                                                                                                                        ImageView imageView6 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                        if (imageView6 != null) {
                                                                                                                                            i = AbstractC17581nC5.img_more;
                                                                                                                                            ImageView imageView7 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                i = AbstractC17581nC5.img_voice_call;
                                                                                                                                                ImageView imageView8 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                    i = AbstractC17581nC5.last_divider;
                                                                                                                                                    FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                    if (frameLayout2 != null) {
                                                                                                                                                        i = AbstractC17581nC5.linear_support;
                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                                            i = AbstractC17581nC5.live_container;
                                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                                i = AbstractC17581nC5.loading_state_container;
                                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                                    i = AbstractC17581nC5.main_body;
                                                                                                                                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                    if (coordinatorLayout != null) {
                                                                                                                                                                        i = AbstractC17581nC5.name_presence_container;
                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                            i = AbstractC17581nC5.new_tv;
                                                                                                                                                                            TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                                i = AbstractC17581nC5.nick_container;
                                                                                                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                if (constraintLayout2 != null) {
                                                                                                                                                                                    i = AbstractC17581nC5.nick_title;
                                                                                                                                                                                    TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                        i = AbstractC17581nC5.nick_txt;
                                                                                                                                                                                        TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                            i = AbstractC17581nC5.notif_container;
                                                                                                                                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                            if (constraintLayout3 != null) {
                                                                                                                                                                                                i = AbstractC17581nC5.notif_switch;
                                                                                                                                                                                                SwitchCompat switchCompat2 = (SwitchCompat) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                if (switchCompat2 != null) {
                                                                                                                                                                                                    i = AbstractC17581nC5.notif_title;
                                                                                                                                                                                                    TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                        i = AbstractC17581nC5.notif_title_divider;
                                                                                                                                                                                                        DividerView dividerView = (DividerView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                        if (dividerView != null) {
                                                                                                                                                                                                            i = AbstractC17581nC5.pager;
                                                                                                                                                                                                            ViewPager2 viewPager2 = (ViewPager2) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                            if (viewPager2 != null) {
                                                                                                                                                                                                                i = AbstractC17581nC5.phone_container;
                                                                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                                                                    i = AbstractC17581nC5.phone_title;
                                                                                                                                                                                                                    TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                                        i = AbstractC17581nC5.phone_txt;
                                                                                                                                                                                                                        TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                            i = AbstractC17581nC5.premiumBadge;
                                                                                                                                                                                                                            RLottieImageView rLottieImageView = (RLottieImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                            if (rLottieImageView != null) {
                                                                                                                                                                                                                                i = AbstractC17581nC5.selected_count_txt;
                                                                                                                                                                                                                                TextView textView14 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                    i = AbstractC17581nC5.selected_item_container;
                                                                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                                                                        i = AbstractC17581nC5.share_nick_img;
                                                                                                                                                                                                                                        ImageView imageView9 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                        if (imageView9 != null) {
                                                                                                                                                                                                                                            i = AbstractC17581nC5.show_in_message_container;
                                                                                                                                                                                                                                            CardView cardView5 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                            if (cardView5 != null) {
                                                                                                                                                                                                                                                i = AbstractC17581nC5.show_in_message_img;
                                                                                                                                                                                                                                                ImageView imageView10 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                                                                                    i = AbstractC17581nC5.story_container;
                                                                                                                                                                                                                                                    LinearLayout linearLayout13 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                    if (linearLayout13 != null) {
                                                                                                                                                                                                                                                        i = AbstractC17581nC5.tab_layout;
                                                                                                                                                                                                                                                        TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                        if (tabLayout != null) {
                                                                                                                                                                                                                                                            i = AbstractC17581nC5.toolbar_container;
                                                                                                                                                                                                                                                            AppBarLayout appBarLayout2 = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                            if (appBarLayout2 != null) {
                                                                                                                                                                                                                                                                i = AbstractC17581nC5.top_audio_play_bar;
                                                                                                                                                                                                                                                                AudioPlayBar audioPlayBar = (AudioPlayBar) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                                if (audioPlayBar != null) {
                                                                                                                                                                                                                                                                    i = AbstractC17581nC5.txt_name;
                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                        i = AbstractC17581nC5.txt_presence;
                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                            i = AbstractC17581nC5.txt_support;
                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                return new C6281My2((ConstraintLayout) view, linearLayout, textView, textView2, composeView, textView3, linearLayout2, imageView, textView4, avatarWithStory, collapsingToolbarLayout, linearLayout3, appBarLayout, composeView2, constraintLayout, switchCompat, textView5, textView6, linearLayout4, floatingActionButton, cardView, imageView2, cardView2, imageView3, cardView3, imageView4, linearLayout5, composeView3, textView7, frameLayout, cardView4, imageView5, linearLayout6, imageView6, imageView7, imageView8, frameLayout2, linearLayout7, linearLayout8, linearLayout9, coordinatorLayout, linearLayout10, textView8, constraintLayout2, textView9, textView10, constraintLayout3, switchCompat2, textView11, dividerView, viewPager2, linearLayout11, textView12, textView13, rLottieImageView, textView14, linearLayout12, imageView9, cardView5, imageView10, linearLayout13, tabLayout, appBarLayout2, audioPlayBar, textView15, textView16, textView17);
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
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
