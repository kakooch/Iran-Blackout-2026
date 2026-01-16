package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001\u0017B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lir/nasim/uX4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "R9", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "S9", "(Landroid/content/Context;)Landroid/widget/FrameLayout;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "h7", "T6", "", "a", "()Z", "Landroidx/appcompat/widget/SwitchCompat;", "c1", "Landroidx/appcompat/widget/SwitchCompat;", "switchCompat", "Landroid/widget/TextView;", "d1", "Landroid/widget/TextView;", "changePasscodeTV", "Landroid/widget/LinearLayout;", "e1", "Landroid/widget/LinearLayout;", "rootLayout", "f1", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.uX4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22019uX4 extends C22042ua0 {

    /* renamed from: f1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int g1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private SwitchCompat switchCompat;

    /* renamed from: d1, reason: from kotlin metadata */
    private TextView changePasscodeTV;

    /* renamed from: e1, reason: from kotlin metadata */
    private LinearLayout rootLayout;

    /* renamed from: ir.nasim.uX4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C22019uX4 a() {
            return new C22019uX4();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final void R9() {
        C23073wI7.n = false;
        C23073wI7.g = "";
        C23073wI7.e();
    }

    private final FrameLayout S9(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(C14433hu3.a(-1, 16.0f));
        frameLayout.setBackgroundColor(C5495Jo7.a.a1());
        View view = new View(context);
        view.setLayoutParams(C14433hu3.c(-1, 4, 48));
        view.setBackground(context.getDrawable(KB5.card_shadow_bottom));
        View view2 = new View(context);
        view2.setLayoutParams(C14433hu3.c(-1, 1, 80));
        view2.setBackground(context.getDrawable(KB5.card_shadow_top));
        frameLayout.addView(view);
        frameLayout.addView(view2);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(C22019uX4 c22019uX4, View view) {
        AbstractC13042fc3.i(c22019uX4, "this$0");
        C22042ua0.A9(c22019uX4, C18951pX4.INSTANCE.a(true), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(SwitchCompat switchCompat, View view) {
        AbstractC13042fc3.i(switchCompat, "$this_apply");
        switchCompat.setChecked(!switchCompat.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(C22019uX4 c22019uX4, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(c22019uX4, "this$0");
        if (z) {
            C22042ua0.A9(c22019uX4, C18951pX4.INSTANCE.a(true), false, null, 6, null);
            return;
        }
        c22019uX4.R9();
        TextView textView = c22019uX4.changePasscodeTV;
        AbstractC13042fc3.f(textView);
        textView.setEnabled(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(G5());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackgroundColor(c5495Jo7.O0());
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -1));
        this.rootLayout = linearLayout;
        BaleToolbar.Companion companion = BaleToolbar.INSTANCE;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        String strH6 = h6(AbstractC12217eE5.passcode_header);
        AbstractC13042fc3.h(strH6, "getString(...)");
        BaleToolbar baleToolbarD = BaleToolbar.Companion.d(companion, fragmentActivityQ7, strH6, false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AppBarLayout appBarLayoutA = companion.a(contextS7);
        appBarLayoutA.addView(baleToolbarD);
        LinearLayout linearLayout2 = this.rootLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(appBarLayoutA);
        }
        RelativeLayout relativeLayout = new RelativeLayout(G5());
        relativeLayout.setBackground(S7().getDrawable(KB5.selector));
        relativeLayout.setLayoutParams(C14433hu3.d(-1, -2));
        relativeLayout.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (JF5.g()) {
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.addRule(1, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            layoutParams.addRule(0, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
        layoutParams.setMargins(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(8.0f));
        TextView textView = new TextView(G5());
        textView.setId(WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY);
        textView.setTextSize(2, 16.0f);
        textView.setText(AbstractC12217eE5.setting_passcode);
        textView.setGravity(8388611);
        textView.setTextColor(c5495Jo7.W0());
        textView.setTypeface(C6011Lu2.k());
        textView.setLayoutParams(layoutParams);
        TextView textView2 = new TextView(G5());
        textView2.setText(AbstractC12217eE5.change_passcode);
        textView2.setTextSize(2, 16.0f);
        textView2.setTextColor(c5495Jo7.g1());
        textView2.setBackground(S7().getDrawable(KB5.selector));
        textView2.setTypeface(C6011Lu2.k());
        textView2.setGravity(JF5.g() ? 5 : 3);
        textView2.setLayoutParams(C14433hu3.d(-1, -2));
        textView2.setPadding(C22078ud6.a(24.0f), C22078ud6.a(8.0f), C22078ud6.a(24.0f), C22078ud6.a(8.0f));
        this.changePasscodeTV = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sX4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C22019uX4.T9(this.a, view);
            }
        });
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (JF5.g()) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(15);
        } else {
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
        }
        layoutParams2.setMargins(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(8.0f));
        final SwitchCompat switchCompat = new SwitchCompat(S7());
        switchCompat.setId(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        switchCompat.setLayoutParams(layoutParams2);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tX4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C22019uX4.U9(switchCompat, view);
            }
        });
        relativeLayout.addView(textView);
        relativeLayout.addView(switchCompat);
        this.switchCompat = switchCompat;
        TextView textView3 = new TextView(G5());
        textView3.setText(AbstractC12217eE5.passcode_description);
        textView3.setTextSize(2, 14.0f);
        textView3.setTextColor(c5495Jo7.y0(c5495Jo7.g0(), 48));
        textView3.setTypeface(C6011Lu2.k());
        textView3.setGravity(JF5.g() ? 5 : 3);
        textView3.setLayoutParams(C14433hu3.f(-1, -2, 4.0f, 8.0f, 4.0f, 8.0f));
        textView3.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f));
        LinearLayout linearLayout3 = this.rootLayout;
        if (linearLayout3 != null) {
            linearLayout3.addView(relativeLayout);
        }
        LinearLayout linearLayout4 = this.rootLayout;
        if (linearLayout4 != null) {
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            linearLayout4.addView(S9(contextS72));
        }
        LinearLayout linearLayout5 = this.rootLayout;
        if (linearLayout5 != null) {
            linearLayout5.addView(this.changePasscodeTV);
        }
        LinearLayout linearLayout6 = this.rootLayout;
        if (linearLayout6 != null) {
            Context contextS73 = S7();
            AbstractC13042fc3.h(contextS73, "requireContext(...)");
            linearLayout6.addView(S9(contextS73));
        }
        LinearLayout linearLayout7 = this.rootLayout;
        if (linearLayout7 != null) {
            linearLayout7.addView(textView3);
        }
        return this.rootLayout;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.rootLayout = null;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        List listC0 = Q7().B0().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        Iterator it = listC0.iterator();
        while (it.hasNext()) {
            if (!(((Fragment) it.next()) instanceof C4747Gj6)) {
                Q7().B0().k1();
            }
        }
        return true;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        SwitchCompat switchCompat = this.switchCompat;
        if (switchCompat != null) {
            AbstractC13042fc3.f(switchCompat);
            switchCompat.setChecked(C23073wI7.n);
            SwitchCompat switchCompat2 = this.switchCompat;
            AbstractC13042fc3.f(switchCompat2);
            switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.rX4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    C22019uX4.V9(this.a, compoundButton, z);
                }
            });
        }
    }
}
