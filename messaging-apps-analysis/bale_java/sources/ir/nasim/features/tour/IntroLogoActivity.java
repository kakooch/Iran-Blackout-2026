package ir.nasim.features.tour;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AI7;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.BC5;
import ir.nasim.C13955h61;
import ir.nasim.C14551i6;
import ir.nasim.C15225jD4;
import ir.nasim.C16731lm1;
import ir.nasim.C17213mb2;
import ir.nasim.C18987pb3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C6604Of2;
import ir.nasim.EnumC9389Zs3;
import ir.nasim.HN1;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KS2;
import ir.nasim.L93;
import ir.nasim.O98;
import ir.nasim.OY0;
import ir.nasim.PH3;
import ir.nasim.SA2;
import ir.nasim.SQ;
import ir.nasim.TA5;
import ir.nasim.TP;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.tour.IntroLogoActivity;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u001b\u0010\u001b\u001a\u00020\u0005*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0005H\u0014¢\u0006\u0004\b,\u0010\u0004J\u0017\u0010-\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b-\u0010\nJ\u000f\u0010.\u001a\u00020\u0005H\u0014¢\u0006\u0004\b.\u0010\u0004J/\u00104\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\u0016\u00103\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010201\"\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010E\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020!8\u0002X\u0082D¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u001b\u0010X\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^¨\u0006b"}, d2 = {"Lir/nasim/features/tour/IntroLogoActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "Lir/nasim/jD4$b;", "<init>", "()V", "Lir/nasim/rB7;", "F2", "Landroid/content/Intent;", "intent", "C2", "(Landroid/content/Intent;)V", "", "code", "J2", "(Ljava/lang/String;)V", "W2", "K2", "O2", "U2", "q2", "Q2", "T2", "H2", "I2", "Landroid/widget/RadioButton;", "Lir/nasim/Zs3;", "language", "D2", "(Landroid/widget/RadioButton;Lir/nasim/Zs3;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "W1", "()Z", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "onDestroy", "onNewIntent", "onResume", "", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "Lir/nasim/Bk5;", "L0", "Lir/nasim/Bk5;", "B2", "()Lir/nasim/Bk5;", "setPreferencesStorage", "(Lir/nasim/Bk5;)V", "preferencesStorage", "Lir/nasim/TP;", "M0", "Lir/nasim/TP;", "v2", "()Lir/nasim/TP;", "setAuthNavigator", "(Lir/nasim/TP;)V", "authNavigator", "N0", "Z", "walkThroughEnabled", "O0", "Ljava/lang/String;", "termAndConditionLink", "P0", TokenNames.I, "gravity", "Lir/nasim/i6;", "Q0", "Lir/nasim/i6;", "binding", "Lir/nasim/lm1;", "R0", "Lir/nasim/Yu3;", "x2", "()Lir/nasim/lm1;", "contextThemeWrapper", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "S0", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "languageDialog", "A2", "()Lir/nasim/Zs3;", "currentLanguage", "T0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class IntroLogoActivity extends Hilt_IntroLogoActivity implements C15225jD4.b {
    public static final int U0 = 8;

    /* renamed from: L0, reason: from kotlin metadata */
    public InterfaceC3570Bk5 preferencesStorage;

    /* renamed from: M0, reason: from kotlin metadata */
    public TP authNavigator;

    /* renamed from: N0, reason: from kotlin metadata */
    private final boolean walkThroughEnabled;

    /* renamed from: Q0, reason: from kotlin metadata */
    private C14551i6 binding;

    /* renamed from: S0, reason: from kotlin metadata */
    private AlertDialog languageDialog;

    /* renamed from: O0, reason: from kotlin metadata */
    private final String termAndConditionLink = "https://terms.bale.ai";

    /* renamed from: P0, reason: from kotlin metadata */
    private int gravity = 8388611;

    /* renamed from: R0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 contextThemeWrapper = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xc3
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return IntroLogoActivity.r2(this.a);
        }
    });

    private final EnumC9389Zs3 A2() {
        String strD = PH3.d();
        EnumC9389Zs3 enumC9389Zs3 = EnumC9389Zs3.b;
        if (AbstractC13042fc3.d(strD, enumC9389Zs3.toString())) {
            return enumC9389Zs3;
        }
        EnumC9389Zs3 enumC9389Zs32 = EnumC9389Zs3.d;
        if (AbstractC13042fc3.d(strD, enumC9389Zs32.toString())) {
            return enumC9389Zs32;
        }
        EnumC9389Zs3 enumC9389Zs33 = EnumC9389Zs3.c;
        return AbstractC13042fc3.d(strD, enumC9389Zs33.toString()) ? enumC9389Zs33 : EnumC9389Zs3.a;
    }

    private final void C2(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("isUiTest", false);
        Uri data = intent.getData();
        if (data != null) {
            String string = data.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            if (AbstractC20762sZ6.X(string, "/sign-up/from-telegram/", false, 2, null)) {
                C14551i6 c14551i6 = this.binding;
                if (c14551i6 == null) {
                    AbstractC13042fc3.y("binding");
                    c14551i6 = null;
                }
                BaleButton baleButton = c14551i6.g;
                AbstractC13042fc3.h(baleButton, "introStart");
                baleButton.setVisibility(8);
                if (AbstractC13042fc3.d(data.getLastPathSegment(), "-1")) {
                    BaseActivity.S1(this, BC5.activity_base_login, v2().c(), null, 4, null);
                } else {
                    J2(data.getLastPathSegment());
                }
            }
        }
        if (booleanExtra) {
            return;
        }
        intent.replaceExtras(new Bundle()).setAction(null).setData(null).setFlags(0);
        setIntent(null);
    }

    private final void D2(RadioButton radioButton, final EnumC9389Zs3 enumC9389Zs3) {
        radioButton.setBackground(AbstractC4310Eo7.g());
        if (A2() == enumC9389Zs3) {
            radioButton.setChecked(true);
        }
        radioButton.setTypeface(C6011Lu2.k());
        radioButton.setGravity(radioButton.getGravity());
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.Cc3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                IntroLogoActivity.E2(this.a, enumC9389Zs3, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(IntroLogoActivity introLogoActivity, EnumC9389Zs3 enumC9389Zs3, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(introLogoActivity, "this$0");
        AbstractC13042fc3.i(enumC9389Zs3, "$language");
        AbstractC13042fc3.i(compoundButton, "<unused var>");
        if (z) {
            PH3.i(introLogoActivity, enumC9389Zs3.toString());
            AlertDialog alertDialog = introLogoActivity.languageDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            introLogoActivity.recreate();
        }
    }

    private final void F2() {
        C14551i6 c14551i6 = this.binding;
        if (c14551i6 == null) {
            AbstractC13042fc3.y("binding");
            c14551i6 = null;
        }
        AbstractC12990fW7.E0(c14551i6.b, new InterfaceC22474vI4() { // from class: ir.nasim.zc3
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return IntroLogoActivity.G2(this.a, view, o98);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 G2(IntroLogoActivity introLogoActivity, View view, O98 o98) {
        AbstractC13042fc3.i(introLogoActivity, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.i());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        L93 l93F2 = o98.f(O98.m.g());
        AbstractC13042fc3.h(l93F2, "getInsets(...)");
        C14551i6 c14551i6 = introLogoActivity.binding;
        C14551i6 c14551i62 = null;
        if (c14551i6 == null) {
            AbstractC13042fc3.y("binding");
            c14551i6 = null;
        }
        ConstraintLayout constraintLayout = c14551i6.b;
        C14551i6 c14551i63 = introLogoActivity.binding;
        if (c14551i63 == null) {
            AbstractC13042fc3.y("binding");
            c14551i63 = null;
        }
        int paddingLeft = c14551i63.b.getPaddingLeft();
        int i = l93F.b;
        C14551i6 c14551i64 = introLogoActivity.binding;
        if (c14551i64 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c14551i62 = c14551i64;
        }
        constraintLayout.setPadding(paddingLeft, i, c14551i62.b.getPaddingRight(), l93F2.d);
        return o98;
    }

    private final void H2() {
        if (this.walkThroughEnabled) {
            startActivity(new Intent(this, (Class<?>) NewIntroActivity.class));
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("sign_type", 4);
            C5735Kp4.w().B(this, bundle);
        }
        finish();
    }

    private final void I2() {
        AlertDialog.a aVar = new AlertDialog.a(this);
        HN1 hn1C = HN1.c(getLayoutInflater());
        AbstractC13042fc3.h(hn1C, "inflate(...)");
        RadioGroup root = hn1C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        aVar.n(root);
        aVar.m(getString(AbstractC12217eE5.lang_dialog_title));
        this.gravity = 5;
        RadioButton radioButton = hn1C.d;
        AbstractC13042fc3.h(radioButton, "radioFarsi");
        D2(radioButton, EnumC9389Zs3.a);
        RadioButton radioButton2 = hn1C.b;
        AbstractC13042fc3.h(radioButton2, "radioArabic");
        D2(radioButton2, EnumC9389Zs3.c);
        RadioButton radioButton3 = hn1C.e;
        AbstractC13042fc3.h(radioButton3, "radioTorki");
        D2(radioButton3, EnumC9389Zs3.d);
        RadioButton radioButton4 = hn1C.c;
        AbstractC13042fc3.h(radioButton4, "radioEnglish");
        D2(radioButton4, EnumC9389Zs3.b);
        this.languageDialog = aVar.o();
    }

    private final void J2(String code) {
        KS2 ks2 = new KS2();
        TP tpV2 = v2();
        long j = B2().getLong("PREF_KET_FULL_NUMBER", 0L);
        String string = B2().getString("PREF_KEY_TRANSACTION_HASH", "");
        AbstractC13042fc3.h(string, "getString(...)");
        ArrayList arrayList = new ArrayList();
        Object objK = ks2.k(B2().e("PREF_KEY_SEND_CODE_TYPE"), SQ.class);
        AbstractC13042fc3.h(objK, "fromJson(...)");
        long j2 = B2().getLong("PREF_KEY_SEND_CODE_TIME", 0L);
        Object objK2 = ks2.k(B2().e("PREF_KEY_SEND_NEXT_CODE_TYPE"), SQ.class);
        AbstractC13042fc3.h(objK2, "fromJson(...)");
        BaseActivity.S1(this, BC5.activity_base_login, tpV2.a(j, string, arrayList, (SQ) objK, j2, (SQ) objK2, B2().getLong("PREF_KEY_SEND_NEXT_CODE_TIME", 0L), code), null, 4, null);
    }

    private final void K2() {
        int iL1 = C5495Jo7.l1(this);
        Configuration configuration = getApplicationContext().getResources().getConfiguration();
        if (iL1 == 1) {
            configuration.uiMode = 16;
        } else if (iL1 == 2) {
            configuration.uiMode = 32;
        }
        getApplicationContext().getResources().getConfiguration().setTo(configuration);
    }

    private final void O2() {
        C14551i6 c14551i6 = this.binding;
        if (c14551i6 == null) {
            AbstractC13042fc3.y("binding");
            c14551i6 = null;
        }
        TextView textView = c14551i6.c;
        textView.setTypeface(C6011Lu2.i());
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yc3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntroLogoActivity.P2(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(IntroLogoActivity introLogoActivity, View view) {
        AbstractC13042fc3.i(introLogoActivity, "this$0");
        introLogoActivity.I2();
    }

    private final void Q2() {
        C14551i6 c14551i6 = this.binding;
        if (c14551i6 == null) {
            AbstractC13042fc3.y("binding");
            c14551i6 = null;
        }
        BaleButton baleButton = c14551i6.g;
        AbstractC13042fc3.f(baleButton);
        baleButton.setVisibility(0);
        baleButton.setTypeface(C6011Lu2.i());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ac3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntroLogoActivity.S2(this.a, view);
            }
        });
        baleButton.setBackground(AbstractC4310Eo7.j(OY0.b(x2(), AbstractC21139tA5.colorPrimary), OY0.b(x2(), AbstractC21139tA5.colorPrimaryHover), 45));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S2(IntroLogoActivity introLogoActivity, View view) {
        AbstractC13042fc3.i(introLogoActivity, "this$0");
        C6604Of2.a.a(Long.valueOf(System.currentTimeMillis()));
        C17213mb2.g(C17213mb2.a, "start_button_click", null, 2, null);
        introLogoActivity.H2();
    }

    private final void T2() {
        C14551i6 c14551i6 = this.binding;
        if (c14551i6 == null) {
            AbstractC13042fc3.y("binding");
            c14551i6 = null;
        }
        TextView textView = c14551i6.h;
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(C5495Jo7.a.o0());
    }

    private final void U2() {
        C14551i6 c14551i6 = this.binding;
        if (c14551i6 == null) {
            AbstractC13042fc3.y("binding");
            c14551i6 = null;
        }
        final TextView textView = c14551i6.j;
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(textView.getResources().getColor(TA5.c9));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Bc3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntroLogoActivity.V2(this.a, textView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(IntroLogoActivity introLogoActivity, TextView textView, View view) {
        AbstractC13042fc3.i(introLogoActivity, "this$0");
        AbstractC13042fc3.i(textView, "$this_apply");
        if (C18987pb3.a.J1(introLogoActivity.termAndConditionLink, textView.getContext())) {
            return;
        }
        introLogoActivity.q2();
    }

    private final void W2() {
        K2();
    }

    private final void q2() {
        AbstractC21375tZ.c(this, this, null, C13955h61.a.c(), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16731lm1 r2(IntroLogoActivity introLogoActivity) {
        AbstractC13042fc3.i(introLogoActivity, "this$0");
        return new C16731lm1(introLogoActivity, AbstractC23035wE5.Theme_Bale_Base);
    }

    private final C16731lm1 x2() {
        return (C16731lm1) this.contextThemeWrapper.getValue();
    }

    public final InterfaceC3570Bk5 B2() {
        InterfaceC3570Bk5 interfaceC3570Bk5 = this.preferencesStorage;
        if (interfaceC3570Bk5 != null) {
            return interfaceC3570Bk5;
        }
        AbstractC13042fc3.y("preferencesStorage");
        return null;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        super.attachBaseContext(PH3.h(base));
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.l) {
            recreate();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C6011Lu2.m(this);
        AbstractC19329q98.b(getWindow(), false);
        super.onCreate(savedInstanceState);
        C14551i6 c14551i6C = C14551i6.c(getLayoutInflater());
        this.binding = c14551i6C;
        if (c14551i6C == null) {
            AbstractC13042fc3.y("binding");
            c14551i6C = null;
        }
        setContentView(c14551i6C.getRoot());
        F2();
        W2();
        T2();
        Q2();
        U2();
        O2();
        AI7.b(false);
        C15225jD4.b().a(this, C15225jD4.l);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C15225jD4.b().e(this, C15225jD4.l);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        C2(intent);
        super.onNewIntent(intent);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Intent intent = getIntent();
        if (intent != null) {
            C2(intent);
        }
        super.onResume();
    }

    public final TP v2() {
        TP tp = this.authNavigator;
        if (tp != null) {
            return tp;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }
}
