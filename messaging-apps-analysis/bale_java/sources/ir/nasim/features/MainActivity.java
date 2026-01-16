package ir.nasim.features;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import ir.nasim.AbstractC10159bA6;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC7978Tz6;
import ir.nasim.C11458d25;
import ir.nasim.C13923h3;
import ir.nasim.C15225jD4;
import ir.nasim.C22055ub3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.CI6;
import ir.nasim.EnumC18608ow5;
import ir.nasim.FA6;
import ir.nasim.IA6;
import ir.nasim.KB5;
import ir.nasim.PH3;
import ir.nasim.TP;
import ir.nasim.UQ;
import ir.nasim.ZI2;
import ir.nasim.features.forceupdate.ForceUpdateActivity;
import ir.nasim.features.root.RootActivity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0015¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0016\"\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lir/nasim/features/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lir/nasim/jD4$b;", "<init>", "()V", "Lir/nasim/rB7;", "y1", "w1", "A1", "", "r1", "()Z", "u1", "z1", "x1", "s1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "Lir/nasim/TP;", "Z", "Lir/nasim/TP;", "t1", "()Lir/nasim/TP;", "setAuthNavigator", "(Lir/nasim/TP;)V", "authNavigator", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MainActivity extends Hilt_MainActivity implements C15225jD4.b {

    /* renamed from: Z, reason: from kotlin metadata */
    public TP authNavigator;

    private final void A1() {
        if (r1()) {
            startActivity(getIntent().setClass(this, RootActivity.class));
        } else {
            startActivity(t1().g(this, null));
        }
    }

    private final boolean r1() {
        UQ uqA = UQ.a.a(C7183Qq.p().e("auth_state"), UQ.c);
        return (uqA == UQ.g || uqA == UQ.b) ? false : true;
    }

    private final boolean s1() {
        return ZI2.d(C7183Qq.q(EnumC18608ow5.h).e("PREF_JSON_FORCE_UPDATE"), 0L, 0, 6, null);
    }

    private final boolean u1() {
        return C13923h3.a.t();
    }

    private final void w1() {
        if (s1()) {
            startActivity(new Intent(this, (Class<?>) ForceUpdateActivity.class));
        } else if (u1()) {
            A1();
        } else {
            z1();
        }
    }

    private final void x1() {
        List dynamicShortcuts;
        if (Build.VERSION.SDK_INT >= 25) {
            ShortcutManager shortcutManagerA = IA6.a(getSystemService(FA6.a()));
            if (((shortcutManagerA == null || (dynamicShortcuts = shortcutManagerA.getDynamicShortcuts()) == null) ? 0 : dynamicShortcuts.size()) == 0) {
                AbstractC10159bA6.a();
                ShortcutInfo.Builder builderA = AbstractC7978Tz6.a(this, "buy_charge");
                builderA.setShortLabel(getString(AbstractC12217eE5.app_shortcut_buy_charge));
                builderA.setLongLabel(getString(AbstractC12217eE5.app_shortcut_buy_charge));
                builderA.setIcon(Icon.createWithResource(getApplicationContext(), KB5.ba_shortcut_charge));
                C22055ub3 c22055ub3 = C22055ub3.a;
                Context applicationContext = getApplicationContext();
                AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
                C11458d25 c11458d25R = C11458d25.r(41L);
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                builderA.setIntent(c22055ub3.l(applicationContext, c11458d25R));
                ShortcutInfo shortcutInfoBuild = builderA.build();
                AbstractC13042fc3.h(shortcutInfoBuild, "build(...)");
                AbstractC10159bA6.a();
                ShortcutInfo.Builder builderA2 = AbstractC7978Tz6.a(this, "buy_internet");
                builderA2.setShortLabel(getString(AbstractC12217eE5.app_shortcut_buy_internet));
                builderA2.setLongLabel(getString(AbstractC12217eE5.app_shortcut_buy_internet));
                builderA2.setIcon(Icon.createWithResource(getApplicationContext(), KB5.ba_shortcut_internet));
                Context applicationContext2 = getApplicationContext();
                AbstractC13042fc3.h(applicationContext2, "getApplicationContext(...)");
                C11458d25 c11458d25R2 = C11458d25.r(1108996041L);
                AbstractC13042fc3.h(c11458d25R2, "fromUniqueId(...)");
                builderA2.setIntent(c22055ub3.l(applicationContext2, c11458d25R2));
                ShortcutInfo shortcutInfoBuild2 = builderA2.build();
                AbstractC13042fc3.h(shortcutInfoBuild2, "build(...)");
                if (shortcutManagerA != null) {
                    shortcutManagerA.setDynamicShortcuts(AbstractC10360bX0.p(shortcutInfoBuild, shortcutInfoBuild2));
                }
            }
        }
    }

    private final void y1() {
        if (Build.VERSION.SDK_INT >= 31) {
            if (C5495Jo7.a.J2()) {
                getSplashScreen().setSplashScreenTheme(AbstractC23035wE5.Theme_App_Starting_Night);
            } else {
                getSplashScreen().setSplashScreenTheme(AbstractC23035wE5.Theme_App_Starting);
            }
        }
        CI6.b.a(this);
    }

    private final void z1() {
        TP tpT1 = t1();
        Intent intent = getIntent();
        AbstractC13042fc3.h(intent, "getIntent(...)");
        startActivity(TP.b(tpT1, intent, this, null, 4, null));
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        super.attachBaseContext(PH3.h(base));
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        int i = C15225jD4.m;
        if (id == i) {
            Object obj = args[0];
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                Intent intent = new Intent(this, (Class<?>) ForceUpdateActivity.class);
                intent.addFlags(32768);
                startActivity(intent);
            }
            C15225jD4.b().e(this, i);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // ir.nasim.features.Hilt_MainActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        y1();
        C6011Lu2.m(this);
        PH3.h(this);
        super.onCreate(savedInstanceState);
        C5495Jo7.G2(this);
        C15225jD4.b().a(this, C15225jD4.m);
        w1();
        x1();
        finish();
    }

    @Override // ir.nasim.features.Hilt_MainActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C15225jD4.b().e(this, C15225jD4.m);
        super.onDestroy();
    }

    public final TP t1() {
        TP tp = this.authNavigator;
        if (tp != null) {
            return tp;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }
}
