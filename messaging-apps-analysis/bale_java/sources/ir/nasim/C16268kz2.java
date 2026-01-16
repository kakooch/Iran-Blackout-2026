package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.settings.component.AutoDownloadSeekBar;

/* renamed from: ir.nasim.kz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16268kz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final AppBarLayout b;
    public final LinearLayout c;
    public final TextView d;
    public final LinearLayout e;
    public final CheckBox f;
    public final CheckBox g;
    public final CheckBox h;
    public final TextView i;
    public final CheckBox j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final BaleToolbar n;
    public final TextView o;
    public final LinearLayout p;
    public final CheckBox q;
    public final CheckBox r;
    public final CheckBox s;
    public final TextView t;
    public final CheckBox u;
    public final FrameLayout v;
    public final FrameLayout w;
    public final ScrollView x;
    public final AutoDownloadSeekBar y;

    private C16268kz2(LinearLayout linearLayout, AppBarLayout appBarLayout, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, TextView textView2, CheckBox checkBox4, TextView textView3, TextView textView4, TextView textView5, BaleToolbar baleToolbar, TextView textView6, LinearLayout linearLayout4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, TextView textView7, CheckBox checkBox8, FrameLayout frameLayout, FrameLayout frameLayout2, ScrollView scrollView, AutoDownloadSeekBar autoDownloadSeekBar) {
        this.a = linearLayout;
        this.b = appBarLayout;
        this.c = linearLayout2;
        this.d = textView;
        this.e = linearLayout3;
        this.f = checkBox;
        this.g = checkBox2;
        this.h = checkBox3;
        this.i = textView2;
        this.j = checkBox4;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
        this.n = baleToolbar;
        this.o = textView6;
        this.p = linearLayout4;
        this.q = checkBox5;
        this.r = checkBox6;
        this.s = checkBox7;
        this.t = textView7;
        this.u = checkBox8;
        this.v = frameLayout;
        this.w = frameLayout2;
        this.x = scrollView;
        this.y = autoDownloadSeekBar;
    }

    public static C16268kz2 a(View view) {
        int i = BC5.auto_download_appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.auto_download_config;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = BC5.auto_download_current_limit;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.autoDownloadData;
                    LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout2 != null) {
                        i = BC5.autoDownloadDataFile;
                        CheckBox checkBox = (CheckBox) AbstractC11738dW7.a(view, i);
                        if (checkBox != null) {
                            i = BC5.autoDownloadDataGif;
                            CheckBox checkBox2 = (CheckBox) AbstractC11738dW7.a(view, i);
                            if (checkBox2 != null) {
                                i = BC5.autoDownloadDataPhoto;
                                CheckBox checkBox3 = (CheckBox) AbstractC11738dW7.a(view, i);
                                if (checkBox3 != null) {
                                    i = BC5.auto_download_data_text;
                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView2 != null) {
                                        i = BC5.autoDownloadDataVideo;
                                        CheckBox checkBox4 = (CheckBox) AbstractC11738dW7.a(view, i);
                                        if (checkBox4 != null) {
                                            i = BC5.auto_download_limit_text;
                                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView3 != null) {
                                                i = BC5.auto_download_max_limit;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    i = BC5.auto_download_min_limit;
                                                    TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView5 != null) {
                                                        i = BC5.auto_download_toolbar;
                                                        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                        if (baleToolbar != null) {
                                                            i = BC5.auto_download_voice_description;
                                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView6 != null) {
                                                                i = BC5.autoDownloadWifi;
                                                                LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                                if (linearLayout3 != null) {
                                                                    i = BC5.autoDownloadWifiFile;
                                                                    CheckBox checkBox5 = (CheckBox) AbstractC11738dW7.a(view, i);
                                                                    if (checkBox5 != null) {
                                                                        i = BC5.autoDownloadWifiGif;
                                                                        CheckBox checkBox6 = (CheckBox) AbstractC11738dW7.a(view, i);
                                                                        if (checkBox6 != null) {
                                                                            i = BC5.autoDownloadWifiPhoto;
                                                                            CheckBox checkBox7 = (CheckBox) AbstractC11738dW7.a(view, i);
                                                                            if (checkBox7 != null) {
                                                                                i = BC5.auto_download_wifi_text;
                                                                                TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = BC5.autoDownloadWifiVideo;
                                                                                    CheckBox checkBox8 = (CheckBox) AbstractC11738dW7.a(view, i);
                                                                                    if (checkBox8 != null) {
                                                                                        i = BC5.big_divider;
                                                                                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                        if (frameLayout != null) {
                                                                                            i = BC5.big_divider2;
                                                                                            FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                            if (frameLayout2 != null) {
                                                                                                i = BC5.scrollContainer;
                                                                                                ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                                                                                                if (scrollView != null) {
                                                                                                    i = BC5.seekbar;
                                                                                                    AutoDownloadSeekBar autoDownloadSeekBar = (AutoDownloadSeekBar) AbstractC11738dW7.a(view, i);
                                                                                                    if (autoDownloadSeekBar != null) {
                                                                                                        return new C16268kz2((LinearLayout) view, appBarLayout, linearLayout, textView, linearLayout2, checkBox, checkBox2, checkBox3, textView2, checkBox4, textView3, textView4, textView5, baleToolbar, textView6, linearLayout3, checkBox5, checkBox6, checkBox7, textView7, checkBox8, frameLayout, frameLayout2, scrollView, autoDownloadSeekBar);
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

    public static C16268kz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_settings_auto_download, viewGroup, false);
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
