package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.entity.ContactEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lir/nasim/rz0;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "T9", "(Landroid/content/Context;)Landroid/widget/FrameLayout;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/rB7;", "h7", "T6", "Landroid/widget/RadioButton;", "h1", "Landroid/widget/RadioButton;", "everyBody", "i1", "justContacts", "j1", "nobody", "Landroid/widget/RadioGroup;", "k1", "Landroid/widget/RadioGroup;", "radioGroup", "Landroid/widget/LinearLayout;", "l1", "Landroid/widget/LinearLayout;", "rootLayout", "Lir/nasim/core/modules/settings/SettingsModule;", "m1", "Lir/nasim/core/modules/settings/SettingsModule;", "settingsModule", "n1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.rz0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20421rz0 extends XV2 {

    /* renamed from: n1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int o1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private RadioButton everyBody;

    /* renamed from: i1, reason: from kotlin metadata */
    private RadioButton justContacts;

    /* renamed from: j1, reason: from kotlin metadata */
    private RadioButton nobody;

    /* renamed from: k1, reason: from kotlin metadata */
    private RadioGroup radioGroup;

    /* renamed from: l1, reason: from kotlin metadata */
    private LinearLayout rootLayout;

    /* renamed from: m1, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: ir.nasim.rz0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C20421rz0 a() {
            return new C20421rz0();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final FrameLayout T9(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(C14433hu3.a(-1, 16.0f));
        frameLayout.setBackgroundColor(C5495Jo7.a.o());
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
    public static final void U9(C20421rz0 c20421rz0, RadioGroup radioGroup, int i) {
        SettingsModule settingsModule;
        AbstractC13042fc3.i(c20421rz0, "this$0");
        RadioButton radioButton = c20421rz0.everyBody;
        if (radioButton != null && i == radioButton.getId()) {
            SettingsModule settingsModule2 = c20421rz0.settingsModule;
            if (settingsModule2 != null) {
                settingsModule2.t6("always");
                return;
            }
            return;
        }
        RadioButton radioButton2 = c20421rz0.justContacts;
        if (radioButton2 != null && i == radioButton2.getId()) {
            SettingsModule settingsModule3 = c20421rz0.settingsModule;
            if (settingsModule3 != null) {
                settingsModule3.t6(ContactEntity.TABLE_NAME);
                return;
            }
            return;
        }
        RadioButton radioButton3 = c20421rz0.nobody;
        if (radioButton3 == null || i != radioButton3.getId() || (settingsModule = c20421rz0.settingsModule) == null) {
            return;
        }
        settingsModule.t6("none");
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        LinearLayout linearLayout = new LinearLayout(S7());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackgroundColor(c5495Jo7.O0());
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        linearLayout.setLayoutParams(C14433hu3.d(-1, -1));
        BaleToolbar.Companion companion = BaleToolbar.INSTANCE;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        String strH6 = h6(AbstractC12217eE5.call_header);
        AbstractC13042fc3.h(strH6, "getString(...)");
        BaleToolbar baleToolbarD = BaleToolbar.Companion.d(companion, fragmentActivityQ7, strH6, false, 4, null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AppBarLayout appBarLayoutA = companion.a(contextS7);
        appBarLayoutA.addView(baleToolbarD);
        linearLayout.addView(appBarLayoutA);
        this.rootLayout = linearLayout;
        RelativeLayout relativeLayout = new RelativeLayout(S7());
        relativeLayout.setBackground(S7().getResources().getDrawable(KB5.selector));
        relativeLayout.setLayoutParams(C14433hu3.d(-1, -2));
        relativeLayout.setPadding(C22078ud6.a(0.0f), C22078ud6.a(8.0f), C22078ud6.a(0.0f), C22078ud6.a(8.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (JF5.g()) {
            layoutParams.addRule(11);
            layoutParams.addRule(15);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(15);
        }
        layoutParams.setMargins(C22078ud6.a(16.0f), C22078ud6.a(4.0f), C22078ud6.a(16.0f), C22078ud6.a(8.0f));
        RadioGroup radioGroup = new RadioGroup(S7());
        radioGroup.setId(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        radioGroup.setLayoutParams(layoutParams);
        RadioButton radioButton = new RadioButton(S7());
        radioButton.setText(AbstractC12217eE5.privacy_choice_everybody);
        radioButton.setTextSize(2, 16.0f);
        radioButton.setTextColor(c5495Jo7.g1());
        radioButton.setTypeface(C6011Lu2.k());
        radioButton.setGravity(JF5.g() ? 5 : 3);
        radioButton.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(8.0f));
        this.everyBody = radioButton;
        RadioButton radioButton2 = new RadioButton(S7());
        radioButton2.setText(AbstractC12217eE5.privacy_choice_contacts);
        radioButton2.setTextSize(2, 16.0f);
        radioButton2.setTextColor(c5495Jo7.g1());
        radioButton2.setTypeface(C6011Lu2.k());
        radioButton2.setGravity(JF5.g() ? 5 : 3);
        radioButton2.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(8.0f));
        this.justContacts = radioButton2;
        RadioButton radioButton3 = new RadioButton(S7());
        radioButton3.setText(AbstractC12217eE5.privacy_choice_nobody);
        radioButton3.setTextSize(2, 16.0f);
        radioButton3.setTextColor(c5495Jo7.g1());
        radioButton3.setTypeface(C6011Lu2.k());
        radioButton3.setGravity(JF5.g() ? 5 : 3);
        radioButton3.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(8.0f));
        this.nobody = radioButton3;
        radioGroup.addView(this.everyBody);
        radioGroup.addView(this.justContacts);
        radioGroup.addView(this.nobody);
        relativeLayout.addView(radioGroup);
        this.radioGroup = radioGroup;
        TextView textView = new TextView(S7());
        textView.setText(AbstractC12217eE5.call_description);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(c5495Jo7.g0());
        textView.setTypeface(C6011Lu2.k());
        textView.setGravity(JF5.g() ? 5 : 3);
        textView.setLayoutParams(C14433hu3.f(-1, -2, 16.0f, 8.0f, 16.0f, 8.0f));
        textView.setPadding(C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f), C22078ud6.a(4.0f));
        View view = new View(S7());
        view.setLayoutParams(C14433hu3.d(-1, 1));
        view.setBackgroundColor(c5495Jo7.a1());
        LinearLayout linearLayout2 = this.rootLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(textView);
        }
        LinearLayout linearLayout3 = this.rootLayout;
        if (linearLayout3 != null) {
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            linearLayout3.addView(T9(contextS72));
        }
        LinearLayout linearLayout4 = this.rootLayout;
        if (linearLayout4 != null) {
            linearLayout4.addView(relativeLayout);
        }
        return this.rootLayout;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.rootLayout = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        if (this.radioGroup != null) {
            RadioButton radioButton = this.everyBody;
            if (radioButton != null) {
                SettingsModule settingsModule = this.settingsModule;
                radioButton.setChecked(AbstractC13042fc3.d(settingsModule != null ? settingsModule.S0() : null, "always"));
            }
            RadioButton radioButton2 = this.justContacts;
            if (radioButton2 != null) {
                SettingsModule settingsModule2 = this.settingsModule;
                radioButton2.setChecked(AbstractC13042fc3.d(settingsModule2 != null ? settingsModule2.S0() : null, ContactEntity.TABLE_NAME));
            }
            RadioButton radioButton3 = this.nobody;
            if (radioButton3 != null) {
                SettingsModule settingsModule3 = this.settingsModule;
                radioButton3.setChecked(AbstractC13042fc3.d(settingsModule3 != null ? settingsModule3.S0() : null, "none"));
            }
            RadioGroup radioGroup = this.radioGroup;
            if (radioGroup != null) {
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: ir.nasim.qz0
                    @Override // android.widget.RadioGroup.OnCheckedChangeListener
                    public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                        C20421rz0.U9(this.a, radioGroup2, i);
                    }
                });
            }
        }
    }
}
