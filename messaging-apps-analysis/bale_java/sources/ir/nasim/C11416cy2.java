package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.cy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11416cy2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final CheckBox b;
    public final CheckBox c;
    public final CheckBox d;
    public final CheckBox e;
    public final CheckBox f;
    public final ConstraintLayout g;
    public final BaleToolbar h;
    public final ScrollView i;
    public final TextView j;

    private C11416cy2(LinearLayout linearLayout, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, ConstraintLayout constraintLayout, BaleToolbar baleToolbar, ScrollView scrollView, TextView textView) {
        this.a = linearLayout;
        this.b = checkBox;
        this.c = checkBox2;
        this.d = checkBox3;
        this.e = checkBox4;
        this.f = checkBox5;
        this.g = constraintLayout;
        this.h = baleToolbar;
        this.i = scrollView;
        this.j = textView;
    }

    public static C11416cy2 a(View view) {
        int i = BC5.ckb_show_all_tab;
        CheckBox checkBox = (CheckBox) AbstractC11738dW7.a(view, i);
        if (checkBox != null) {
            i = BC5.ckb_show_bot_tab;
            CheckBox checkBox2 = (CheckBox) AbstractC11738dW7.a(view, i);
            if (checkBox2 != null) {
                i = BC5.ckb_show_channel_tab;
                CheckBox checkBox3 = (CheckBox) AbstractC11738dW7.a(view, i);
                if (checkBox3 != null) {
                    i = BC5.ckb_show_group_tab;
                    CheckBox checkBox4 = (CheckBox) AbstractC11738dW7.a(view, i);
                    if (checkBox4 != null) {
                        i = BC5.ckb_show_private_tab;
                        CheckBox checkBox5 = (CheckBox) AbstractC11738dW7.a(view, i);
                        if (checkBox5 != null) {
                            i = BC5.ctl_tabs_settings_content;
                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                            if (constraintLayout != null) {
                                i = BC5.dialogs_tabs_setting_toolbar;
                                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                if (baleToolbar != null) {
                                    i = BC5.scv_tabs_settings_scroll;
                                    ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                                    if (scrollView != null) {
                                        i = BC5.tv_show_tabs_text;
                                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView != null) {
                                            return new C11416cy2((LinearLayout) view, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, constraintLayout, baleToolbar, scrollView, textView);
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

    public static C11416cy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_dialog_tabs_settings, viewGroup, false);
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
