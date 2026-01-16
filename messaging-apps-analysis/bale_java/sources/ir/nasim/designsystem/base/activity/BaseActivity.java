package ir.nasim.designsystem.base.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14201hX0;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9220Yz5;
import ir.nasim.C19406qI3;
import ir.nasim.C20919sp4;
import ir.nasim.C21352tW3;
import ir.nasim.C22042ua0;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C6517Nv5;
import ir.nasim.C7183Qq;
import ir.nasim.ED1;
import ir.nasim.EnumC18608ow5;
import ir.nasim.InterfaceC14830iZ0;
import ir.nasim.InterfaceC15004iq6;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19822r00;
import ir.nasim.InterfaceC3273Ae1;
import ir.nasim.InterfaceC4103Dr7;
import ir.nasim.InterfaceC4411Fa0;
import ir.nasim.KD;
import ir.nasim.OI2;
import ir.nasim.OY0;
import ir.nasim.PH3;
import ir.nasim.U5;
import ir.nasim.XZ;
import ir.nasim.Z17;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0089\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u00020\u000b2\b\b\u0001\u0010 \u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b$\u0010%J+\u0010&\u001a\u00020\u000b2\b\b\u0001\u0010 \u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b&\u0010%J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0012H\u0016¢\u0006\u0004\b(\u0010\u0015J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0014¢\u0006\u0004\b+\u0010,J%\u00101\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u0010\u0005J-\u0010:\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\t2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u0016062\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J)\u0010?\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010=H\u0014¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ#\u0010G\u001a\u00020\u000b\"\u0004\b\u0000\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000EH\u0016¢\u0006\u0004\bG\u0010HJ+\u0010I\u001a\u00020\u000b\"\u0004\b\u0000\u0010D2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\bI\u0010JJ9\u0010O\u001a\u00020\u000b\"\u0004\b\u0000\u0010D2\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000K2\u0006\u0010\n\u001a\u00020\t2\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000MH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u000bH\u0016¢\u0006\u0004\bQ\u0010\u0005J\u000f\u0010R\u001a\u00020\u000bH\u0014¢\u0006\u0004\bR\u0010\u0005J\u000f\u0010S\u001a\u00020\u000bH\u0014¢\u0006\u0004\bS\u0010\u0005J\u000f\u0010T\u001a\u00020\u000bH\u0014¢\u0006\u0004\bT\u0010\u0005J\u000f\u0010U\u001a\u00020\u000bH\u0014¢\u0006\u0004\bU\u0010\u0005J\u000f\u0010V\u001a\u00020\u000bH\u0014¢\u0006\u0004\bV\u0010\u0005J\u0017\u0010X\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u001cH\u0014¢\u0006\u0004\bX\u0010\u001fJ\u000f\u0010Y\u001a\u0004\u0018\u00010!¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020AH\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u000bH\u0016¢\u0006\u0004\b^\u0010\u0005J\u0017\u0010a\u001a\u00020A2\u0006\u0010`\u001a\u00020_H\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\tH\u0016¢\u0006\u0004\bd\u0010\rJ\u000f\u0010e\u001a\u00020\u000bH\u0016¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020AH\u0016¢\u0006\u0004\bf\u0010CR\u0018\u0010i\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR$\u0010y\u001a\u0004\u0018\u00010r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010gR\u001a\u0010~\u001a\u00020A8\u0014X\u0094D¢\u0006\f\n\u0004\b|\u0010g\u001a\u0004\b}\u0010CR\u0018\u0010\u0081\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001¨\u0006\u008a\u0001"}, d2 = {"Lir/nasim/designsystem/base/activity/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lir/nasim/Fa0;", "Lir/nasim/Dr7;", "<init>", "()V", "Lir/nasim/KD$b;", "M1", "()Lir/nasim/KD$b;", "", "title", "Lir/nasim/rB7;", "f2", "(I)V", "O1", "N1", "z1", "P1", "Landroid/content/res/Configuration;", "overrideConfiguration", "applyOverrideConfiguration", "(Landroid/content/res/Configuration;)V", "", "name", "mode", "Landroid/content/SharedPreferences;", "getSharedPreferences", "(Ljava/lang/String;I)Landroid/content/SharedPreferences;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "containerViewId", "Landroidx/fragment/app/Fragment;", "fragment", ParameterNames.TAG, "b2", "(ILandroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Q1", "newConfig", "onConfigurationChanged", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/app/Dialog;", "dialog", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "Y1", "(Landroid/app/Dialog;Landroid/content/DialogInterface$OnDismissListener;)Landroid/app/Dialog;", "i2", "D1", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "C1", "()Z", TokenNames.T, "Lir/nasim/Nv5;", "promise", "H1", "(Lir/nasim/Nv5;)V", "I1", "(Lir/nasim/Nv5;I)V", "Lir/nasim/iZ0;", "cmd", "Lir/nasim/jZ0;", "callback", "F1", "(Lir/nasim/iZ0;ILir/nasim/jZ0;)V", "R4", "onStart", "onResume", "onPause", "onDestroy", "onStop", "outState", "onSaveInstanceState", "L1", "()Landroidx/fragment/app/Fragment;", "isFromToolbar", "i", "(Z)V", "onBackPressed", "Landroid/view/KeyEvent;", "event", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "level", "onTrimMemory", "finish", "W1", "Z", "Landroid/app/Dialog;", "visibleDialog", "Lir/nasim/sp4;", "z0", "Lir/nasim/sp4;", "binder", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "A0", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "progressDialog", "Lir/nasim/U5;", "B0", "Lir/nasim/U5;", "getActivityBridgeInterface", "()Lir/nasim/U5;", "T1", "(Lir/nasim/U5;)V", "activityBridgeInterface", "C0", "isResumed", "D0", "K1", "defaultStatusBarBackgroundEnabled", "E0", "Lir/nasim/KD$b;", "currentTheme", "Landroidx/fragment/app/FragmentManager$n;", "F0", "Landroidx/fragment/app/FragmentManager$n;", "backstackObserver", "G0", "baleFragmentResumeObserver", "H0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class BaseActivity extends Hilt_BaseActivity implements InterfaceC4411Fa0, InterfaceC4103Dr7 {

    /* renamed from: H0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int I0 = 8;
    private static KD.b J0;

    /* renamed from: A0, reason: from kotlin metadata */
    private AlertDialog progressDialog;

    /* renamed from: B0, reason: from kotlin metadata */
    private U5 activityBridgeInterface;

    /* renamed from: C0, reason: from kotlin metadata */
    private boolean isResumed;

    /* renamed from: E0, reason: from kotlin metadata */
    private KD.b currentTheme;

    /* renamed from: Z, reason: from kotlin metadata */
    private Dialog visibleDialog;

    /* renamed from: z0, reason: from kotlin metadata */
    private final C20919sp4 binder = new C20919sp4();

    /* renamed from: D0, reason: from kotlin metadata */
    private final boolean defaultStatusBarBackgroundEnabled = true;

    /* renamed from: F0, reason: from kotlin metadata */
    private final FragmentManager.n backstackObserver = new FragmentManager.n() { // from class: ir.nasim.m90
        @Override // androidx.fragment.app.FragmentManager.n
        public final void e() {
            BaseActivity.A1(this.a);
        }
    };

    /* renamed from: G0, reason: from kotlin metadata */
    private final FragmentManager.n baleFragmentResumeObserver = new FragmentManager.n() { // from class: ir.nasim.n90
        @Override // androidx.fragment.app.FragmentManager.n
        public final void e() {
            BaseActivity.B1(this.a);
        }
    };

    /* renamed from: ir.nasim.designsystem.base.activity.BaseActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final void a(KD.b bVar) {
            BaseActivity.J0 = bVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements InterfaceC15419jZ0 {
        final /* synthetic */ InterfaceC15419jZ0 b;

        b(InterfaceC15419jZ0 interfaceC15419jZ0) {
            this.b = interfaceC15419jZ0;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void a(Object obj) {
            BaseActivity.this.D1();
            this.b.a(obj);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            BaseActivity.this.D1();
            this.b.onError(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(BaseActivity baseActivity) {
        Object objPrevious;
        AbstractC13042fc3.i(baseActivity, "this$0");
        List listC0 = baseActivity.B0().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        ListIterator listIterator = listC0.listIterator(listC0.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                objPrevious = listIterator.previous();
                if (((Fragment) objPrevious).o6() != null) {
                    break;
                }
            } else {
                objPrevious = null;
                break;
            }
        }
        InterfaceC18633oz3 interfaceC18633oz3 = (Fragment) objPrevious;
        if (interfaceC18633oz3 == null) {
            return;
        }
        ArrayList<XZ> arrayList = new ArrayList();
        for (Object obj : listC0) {
            if (obj instanceof XZ) {
                arrayList.add(obj);
            }
        }
        for (XZ xz : arrayList) {
            if (xz != interfaceC18633oz3 && xz.getHasBeenResumed()) {
                C19406qI3.a("BaleFragmentLifecycleOwner", "onPauseConfirmed(): " + xz, new Object[0]);
                XZ.p4(xz, false, 1, null);
            }
        }
        if (interfaceC18633oz3 instanceof XZ) {
            C19406qI3.a("BaleFragmentLifecycleOwner", "state: " + interfaceC18633oz3.getLifecycle().b(), new Object[0]);
            if (!interfaceC18633oz3.getLifecycle().b().j(j.b.RESUMED)) {
                if (interfaceC18633oz3.getLifecycle().b().j(j.b.STARTED)) {
                    C19406qI3.a("BaleFragmentLifecycleOwner", "onResumeConfirmed(): " + interfaceC18633oz3, new Object[0]);
                    XZ.N4((XZ) interfaceC18633oz3, false, 1, null);
                    return;
                }
                return;
            }
            XZ xz2 = (XZ) interfaceC18633oz3;
            if (xz2.getHasBeenResumed()) {
                C19406qI3.a("BaleFragmentLifecycleOwner", "onPauseConfirmed(): " + interfaceC18633oz3, new Object[0]);
                XZ.p4(xz2, false, 1, null);
                return;
            }
            C19406qI3.a("BaleFragmentLifecycleOwner", "onResumeConfirmed(): " + interfaceC18633oz3, new Object[0]);
            XZ.N4(xz2, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(BaseActivity baseActivity) {
        AbstractC13042fc3.i(baseActivity, "this$0");
        List listC0 = baseActivity.B0().C0();
        AbstractC13042fc3.f(listC0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listC0) {
            if (obj instanceof InterfaceC19822r00) {
                arrayList.add(obj);
            }
        }
        int i = 0;
        for (Object obj2 : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            InterfaceC19822r00 interfaceC19822r00 = (InterfaceC19822r00) obj2;
            boolean z = true;
            if (i != listC0.size() - 1) {
                z = false;
            }
            interfaceC19822r00.o0(z);
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(BaseActivity baseActivity) {
        AbstractC13042fc3.i(baseActivity, "this$0");
        AlertDialog alertDialog = baseActivity.progressDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        baseActivity.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(BaseActivity baseActivity, Object obj, Exception exc) {
        AbstractC13042fc3.i(baseActivity, "this$0");
        baseActivity.D1();
    }

    private final KD.b M1() {
        String strE = C7183Qq.q(EnumC18608ow5.d).e("selected_theme");
        if (strE != null) {
            int iHashCode = strE.hashCode();
            if (iHashCode != -2032180703) {
                if (iHashCode == 1571603570 && strE.equals("CLASSIC")) {
                    return KD.b.c;
                }
            } else if (strE.equals("DEFAULT")) {
                return KD.b.b;
            }
        }
        return KD.b.b;
    }

    private final void N1() {
        if (this.isResumed) {
            this.isResumed = false;
            AbstractC5969Lp4.d().N2();
        }
    }

    private final void O1() {
        if (this.isResumed) {
            return;
        }
        this.isResumed = true;
        AbstractC5969Lp4.d().O2();
    }

    private final void P1() {
        B0().w1(this.baleFragmentResumeObserver);
    }

    public static /* synthetic */ void S1(BaseActivity baseActivity, int i, Fragment fragment, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceFragment");
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        baseActivity.Q1(i, fragment, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(DialogInterface.OnDismissListener onDismissListener, BaseActivity baseActivity, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(baseActivity, "this$0");
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        baseActivity.visibleDialog = null;
    }

    public static /* synthetic */ void d2(BaseActivity baseActivity, int i, Fragment fragment, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        baseActivity.b2(i, fragment, str);
    }

    private final void f2(final int title) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.o90
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.g2(this.a, title);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(BaseActivity baseActivity, int i) {
        AlertDialog alertDialog;
        AbstractC13042fc3.i(baseActivity, "this$0");
        AlertDialog alertDialog2 = baseActivity.progressDialog;
        if (alertDialog2 != null && alertDialog2.isShowing() && (alertDialog = baseActivity.progressDialog) != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog3 = new AlertDialog(baseActivity, 1);
        alertDialog3.S(baseActivity.getString(i));
        alertDialog3.setCanceledOnTouchOutside(false);
        alertDialog3.setCancelable(false);
        alertDialog3.show();
        baseActivity.progressDialog = alertDialog3;
    }

    private final void z1() {
        B0().n(this.baleFragmentResumeObserver);
    }

    public boolean C1() {
        return false;
    }

    public final void D1() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.l90
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.E1(this.a);
            }
        });
    }

    public void F1(InterfaceC14830iZ0 cmd, int title, InterfaceC15419jZ0 callback) {
        AbstractC13042fc3.i(cmd, "cmd");
        AbstractC13042fc3.i(callback, "callback");
        f2(title);
        cmd.a(new b(callback));
    }

    public void H1(C6517Nv5 promise) {
        AbstractC13042fc3.i(promise, "promise");
        I1(promise, AbstractC12217eE5.progress_common);
    }

    public void I1(C6517Nv5 promise, int title) {
        AbstractC13042fc3.i(promise, "promise");
        f2(title);
        promise.z(new InterfaceC3273Ae1() { // from class: ir.nasim.p90
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                BaseActivity.J1(this.a, obj, (Exception) obj2);
            }
        });
    }

    /* renamed from: K1, reason: from getter */
    protected boolean getDefaultStatusBarBackgroundEnabled() {
        return this.defaultStatusBarBackgroundEnabled;
    }

    public final Fragment L1() {
        List listC0 = B0().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        for (Fragment fragment : AbstractC14201hX0.V(listC0)) {
            if (!(fragment instanceof Z17)) {
                return fragment;
            }
        }
        return null;
    }

    public final void Q1(int containerViewId, Fragment fragment, String tag) {
        AbstractC13042fc3.i(fragment, "fragment");
        B0().s().r(containerViewId, fragment, tag).w(4097).h();
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void R4() {
        D1();
    }

    public final void T1(U5 u5) {
        this.activityBridgeInterface = u5;
    }

    public boolean W1() {
        return true;
    }

    public Dialog Y1(Dialog dialog, final DialogInterface.OnDismissListener onDismissListener) {
        Dialog dialog2 = this.visibleDialog;
        if (dialog2 != null) {
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            this.visibleDialog = null;
        }
        try {
            this.visibleDialog = dialog;
            if (dialog != null) {
                dialog.setCanceledOnTouchOutside(true);
            }
            Dialog dialog3 = this.visibleDialog;
            if (dialog3 != null) {
                dialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.k90
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        BaseActivity.a2(onDismissListener, this, dialogInterface);
                    }
                });
            }
        } catch (Exception unused) {
        }
        if (dialog != null) {
            dialog.show();
        }
        return dialog;
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
        if (overrideConfiguration != null) {
            int i = overrideConfiguration.uiMode;
            overrideConfiguration.setTo(getBaseContext().getResources().getConfiguration());
            overrideConfiguration.uiMode = i;
        }
        super.applyOverrideConfiguration(overrideConfiguration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        super.attachBaseContext(PH3.h(base));
    }

    public final void b2(int containerViewId, Fragment fragment, String tag) {
        AbstractC13042fc3.i(fragment, "fragment");
        B0().s().c(containerViewId, fragment, tag).g(null).w(4097).h();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        AbstractC13042fc3.i(event, "event");
        if (C21352tW3.d(event.getKeyCode())) {
            return true;
        }
        try {
            return super.dispatchKeyEvent(event);
        } catch (IllegalStateException e) {
            C19406qI3.j("BaseActivity", "Focus search failed: " + e.getMessage(), new Object[0]);
            return true;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (W1()) {
            overridePendingTransition(AbstractC9220Yz5.empty_transition, AbstractC9220Yz5.slide_out_right);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return getApplicationContext().getSharedPreferences(name, mode);
    }

    @Override // ir.nasim.InterfaceC4103Dr7
    public void i(boolean isFromToolbar) {
        AbstractC13042fc3.h(B0().C0(), "getFragments(...)");
        if (!r0.isEmpty()) {
            h hVarL1 = L1();
            if (hVarL1 instanceof C22042ua0) {
                if (((C22042ua0) hVarL1).a()) {
                    return;
                }
                if (hVarL1 instanceof InterfaceC15004iq6) {
                    ((InterfaceC15004iq6) hVarL1).D1(isFromToolbar);
                }
            }
        }
        super.onBackPressed();
    }

    public void i2() {
        this.binder.d0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        U5 u5 = this.activityBridgeInterface;
        if (u5 != null) {
            AbstractC13042fc3.f(u5);
            u5.c(requestCode, resultCode, data);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        i(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        C5735Kp4.w().L();
        KD.b bVarM1 = M1();
        this.currentTheme = bVarM1;
        getTheme().applyStyle(bVarM1.j(), true);
        B0().n(this.backstackObserver);
        if (W1()) {
            overridePendingTransition(AbstractC9220Yz5.slide_in_right, AbstractC9220Yz5.empty_transition);
        }
        super.onCreate(savedInstanceState);
        C5495Jo7.G2(this);
        z1();
        C6011Lu2.m(this);
        PH3.h(this);
        if (getDefaultStatusBarBackgroundEnabled()) {
            if (getTheme().resolveAttribute(AbstractC21139tA5.statusBarBackgroundColor, new TypedValue(), true)) {
                AbstractC7426Rr.a.Q(this, OY0.b(this, AbstractC21139tA5.statusBarBackgroundColor));
            }
            Drawable drawableC = OY0.c(this, AbstractC21139tA5.statusBarBackgroundDrawable);
            if (drawableC != null) {
                AbstractC7426Rr.a.P(this, drawableC);
            }
        }
        AbstractC7426Rr.a.R(getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM)));
        O1();
    }

    @Override // ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        B0().w1(this.backstackObserver);
        super.onDestroy();
        P1();
        i2();
        N1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        N1();
        AbstractC7426Rr.a.L(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        U5 u5 = this.activityBridgeInterface;
        if (u5 != null) {
            AbstractC13042fc3.f(u5);
            u5.d(requestCode, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        O1();
        AbstractC7426Rr.a.L(false);
        KD.b bVar = J0;
        if (bVar != null) {
            KD.b bVar2 = this.currentTheme;
            if (bVar2 == null) {
                AbstractC13042fc3.y("currentTheme");
                bVar2 = null;
            }
            if (bVar != bVar2) {
                recreate();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        outState.putString("Keep it from crashing", "Don't remove this.");
        super.onSaveInstanceState(outState);
        N1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        AbstractC7426Rr.a.M(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        N1();
        AbstractC7426Rr.a.M(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        OI2.a(this).r(level);
        OI2.a(C5721Ko.a.d()).r(level);
    }
}
