package ir.nasim.features.forceupdate;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22735vk3;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C13923h3;
import ir.nasim.C13953h6;
import ir.nasim.C19231q00;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C8542Wk3;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC9989at3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.PH3;
import ir.nasim.RB6;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.forceupdate.ForceUpdateActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0016\u0010\u0003R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010!R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00102\u001a\u00020\u001f8\u0006X\u0086D¢\u0006\f\n\u0004\b0\u0010!\u001a\u0004\b1\u0010&R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lir/nasim/features/forceupdate/ForceUpdateActivity;", "Lir/nasim/designsystem/base/activity/BaseActivity;", "<init>", "()V", "Lir/nasim/rB7;", "B2", "E2", "x2", "D2", "Lir/nasim/at3;", "o2", "()Lir/nasim/at3;", "v2", "q2", "A2", "", "W1", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lir/nasim/RB6;", "L0", "Lir/nasim/RB6;", "r2", "()Lir/nasim/RB6;", "setSignOutUseCase", "(Lir/nasim/RB6;)V", "signOutUseCase", "", "M0", "Ljava/lang/String;", "description", "N0", "Lir/nasim/Yu3;", "p2", "()Ljava/lang/String;", "defaultDescription", "O0", "url", "P0", "Z", "shouldLogout", "Q0", "Lir/nasim/at3;", "currentLocale", "R0", "getTAG", "TAG", "Lir/nasim/h6;", "S0", "Lir/nasim/h6;", "_binding", "n2", "()Lir/nasim/h6;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ForceUpdateActivity extends Hilt_ForceUpdateActivity {

    /* renamed from: L0, reason: from kotlin metadata */
    public RB6 signOutUseCase;

    /* renamed from: M0, reason: from kotlin metadata */
    private String description;

    /* renamed from: O0, reason: from kotlin metadata */
    private String url;

    /* renamed from: P0, reason: from kotlin metadata */
    private boolean shouldLogout;

    /* renamed from: Q0, reason: from kotlin metadata */
    private EnumC9989at3 currentLocale;

    /* renamed from: S0, reason: from kotlin metadata */
    private C13953h6 _binding;

    /* renamed from: N0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 defaultDescription = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bv2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ForceUpdateActivity.l2(this.a);
        }
    });

    /* renamed from: R0, reason: from kotlin metadata */
    private final String TAG = "ForceUpdateActivity";

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC9989at3.values().length];
            try {
                iArr[EnumC9989at3.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return ForceUpdateActivity.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RB6 rb6R2 = ForceUpdateActivity.this.r2();
                this.b = 1;
                if (rb6R2.a(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void A2() {
        TextView textView = n2().f;
        String str = this.description;
        if (str == null) {
            AbstractC13042fc3.y("description");
            str = null;
        }
        textView.setText(str);
    }

    private final void B2() {
        BaleButton baleButton = n2().b;
        baleButton.setTypeface(C6011Lu2.i());
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cv2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForceUpdateActivity.C2(this.a, view);
            }
        });
        baleButton.setBackground(AbstractC4310Eo7.j(baleButton.getResources().getColor(TA5.secondary), baleButton.getResources().getColor(TA5.secondary_tint), 45));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(ForceUpdateActivity forceUpdateActivity, View view) {
        AbstractC13042fc3.i(forceUpdateActivity, "this$0");
        try {
            String str = forceUpdateActivity.url;
            if (str == null) {
                AbstractC13042fc3.y("url");
                str = null;
            }
            forceUpdateActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException e) {
            C19406qI3.c(forceUpdateActivity.TAG, "Error in setUpUpdateBtn, " + e.getMessage(), e);
        }
    }

    private final void D2() {
        this.currentLocale = o2();
    }

    private final void E2() {
        x2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String l2(ForceUpdateActivity forceUpdateActivity) {
        AbstractC13042fc3.i(forceUpdateActivity, "this$0");
        return forceUpdateActivity.getResources().getString(AbstractC12217eE5.force_update_title);
    }

    private final C13953h6 n2() {
        C13953h6 c13953h6 = this._binding;
        AbstractC13042fc3.f(c13953h6);
        return c13953h6;
    }

    private final EnumC9989at3 o2() {
        String strE = PH3.e();
        if (strE != null) {
            String lowerCase = strE.toLowerCase();
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (!AbstractC13042fc3.d(lowerCase, "fa")) {
                String lowerCase2 = strE.toLowerCase();
                AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
                if (AbstractC13042fc3.d(lowerCase2, "en")) {
                    return EnumC9989at3.b;
                }
                String lowerCase3 = strE.toLowerCase();
                AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
                if (AbstractC13042fc3.d(lowerCase3, "ks")) {
                    return EnumC9989at3.d;
                }
                String lowerCase4 = strE.toLowerCase();
                AbstractC13042fc3.h(lowerCase4, "toLowerCase(...)");
                return AbstractC13042fc3.d(lowerCase4, "ar") ? EnumC9989at3.c : EnumC9989at3.a;
            }
        }
        return EnumC9989at3.a;
    }

    private final String p2() {
        Object value = this.defaultDescription.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (String) value;
    }

    private final void q2() {
        String strP2;
        String strE = C7183Qq.q(EnumC18608ow5.h).e("PREF_JSON_FORCE_UPDATE");
        if (strE == null || strE.length() <= 0) {
            return;
        }
        try {
            AbstractC22735vk3 abstractC22735vk3G = new C19231q00(strE).g(ConstantDeviceInfo.APP_PLATFORM);
            if (abstractC22735vk3G != null) {
                C8542Wk3 c8542Wk3O = abstractC22735vk3G.o();
                AbstractC13042fc3.h(c8542Wk3O, "getAsJsonObject(...)");
                C19231q00 c19231q00 = new C19231q00(c8542Wk3O);
                this.url = c19231q00.o("url", "market://details?id=" + getPackageName());
                this.shouldLogout = c19231q00.i("shouldLogout", false);
                AbstractC22735vk3 abstractC22735vk3G2 = c19231q00.g("description");
                if (abstractC22735vk3G2 == null || !abstractC22735vk3G2.A()) {
                    strP2 = p2();
                } else {
                    C8542Wk3 c8542Wk3O2 = abstractC22735vk3G2.o();
                    AbstractC13042fc3.h(c8542Wk3O2, "getAsJsonObject(...)");
                    C19231q00 c19231q002 = new C19231q00(c8542Wk3O2);
                    EnumC9989at3 enumC9989at3 = this.currentLocale;
                    if (enumC9989at3 == null) {
                        AbstractC13042fc3.y("currentLocale");
                        enumC9989at3 = null;
                    }
                    strP2 = a.a[enumC9989at3.ordinal()] == 1 ? c19231q002.o("en", p2()) : c19231q002.o("fa", p2());
                }
                this.description = strP2;
            }
        } catch (Exception e) {
            C19406qI3.a(this.TAG, e.getMessage(), new Object[0]);
        }
    }

    private final void v2() {
        if (this.shouldLogout && C13923h3.a.t()) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
        }
    }

    private final void x2() {
        int iL1 = C5495Jo7.l1(this);
        Configuration configuration = getApplicationContext().getResources().getConfiguration();
        if (iL1 == 1) {
            configuration.uiMode = 16;
        } else if (iL1 == 2) {
            configuration.uiMode = 32;
        }
        getApplicationContext().getResources().getConfiguration().setTo(configuration);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C6011Lu2.m(this);
        super.onCreate(savedInstanceState);
        this._binding = C13953h6.c(getLayoutInflater());
        AbstractC5969Lp4.d().P2(true);
        setContentView(n2().getRoot());
        E2();
        D2();
        q2();
        v2();
        B2();
        A2();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        AbstractC5969Lp4.d().P2(false);
    }

    public final RB6 r2() {
        RB6 rb6 = this.signOutUseCase;
        if (rb6 != null) {
            return rb6;
        }
        AbstractC13042fc3.y("signOutUseCase");
        return null;
    }
}
