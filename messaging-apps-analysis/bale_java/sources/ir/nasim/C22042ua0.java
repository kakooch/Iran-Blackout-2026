package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.j;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.root.C13090h;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006JA\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0017J-\u0010\u0019\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ-\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u0014J\u001b\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J%\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J#\u0010+\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100)¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0010¢\u0006\u0004\b-\u0010\u0006J\u0017\u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u000bH\u0016¢\u0006\u0004\b/\u00100J#\u00104\u001a\u00020\u0010\"\u0004\b\u0000\u001012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0016¢\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J!\u0010;\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001062\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b=\u00109J!\u0010>\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001062\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\b>\u0010<J\u0019\u0010?\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b?\u00109J!\u0010@\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001062\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\b@\u0010<J9\u0010E\u001a\u00020\u0010\"\u0004\b\u0000\u001012\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A2\u0006\u0010&\u001a\u00020\u00072\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000CH\u0016¢\u0006\u0004\bE\u0010FJ3\u0010G\u001a\u00020\u0010\"\u0004\b\u0000\u001012\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000A2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010CH\u0016¢\u0006\u0004\bG\u0010HJ+\u0010I\u001a\u00020\u0010\"\u0004\b\u0000\u001012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000022\u0006\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\rH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\rH\u0016¢\u0006\u0004\bM\u0010LJ\u0019\u0010N\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bN\u00100J\u0017\u0010O\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\bO\u0010(J\u0017\u0010P\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010(J\u000f\u0010Q\u001a\u00020\u0010H\u0016¢\u0006\u0004\bQ\u0010\u0006J\u0017\u0010S\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u0007H\u0016¢\u0006\u0004\bS\u0010TJ\u0011\u0010V\u001a\u00020\u0010*\u00020U¢\u0006\u0004\bV\u0010WJ\u0011\u0010X\u001a\u00020\u0010*\u00020U¢\u0006\u0004\bX\u0010WJ\u000f\u0010Y\u001a\u00020\u0010H\u0016¢\u0006\u0004\bY\u0010\u0006R\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R*\u0010d\u001a\u00020\r2\u0006\u0010^\u001a\u00020\r8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010L\"\u0004\bb\u0010c¨\u0006e"}, d2 = {"Lir/nasim/ua0;", "Lir/nasim/wf0;", "Lir/nasim/Fa0;", "Lir/nasim/z98;", "Lir/nasim/r00;", "<init>", "()V", "", "containerViewId", "Landroidx/fragment/app/Fragment;", "fragment", "", ParameterNames.TAG, "", "animation", "addToBackStack", "Lir/nasim/rB7;", "s9", "(ILandroidx/fragment/app/Fragment;Ljava/lang/String;ZZ)V", "p9", "(Landroidx/fragment/app/Fragment;)V", "pop", "l9", "(Landroidx/fragment/app/Fragment;Z)V", "n9", "u9", "(Landroidx/fragment/app/Fragment;ZLjava/lang/String;)V", "z9", "B9", "x9", "Landroid/app/Dialog;", "dialog", "q9", "(Landroid/app/Dialog;)Landroid/app/Dialog;", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "r9", "(Landroid/app/Dialog;Landroid/content/DialogInterface$OnDismissListener;)Landroid/app/Dialog;", "title", "D9", "(I)V", "Lkotlin/Function0;", "onCancel", "F9", "(ILir/nasim/SA2;)V", "P8", ParameterNames.TEXT, "I9", "(Ljava/lang/String;)V", TokenNames.T, "Lir/nasim/Nv5;", "promise", "S8", "(Lir/nasim/Nv5;)V", "Landroid/view/View;", "view", "K9", "(Landroid/view/View;)V", "isAnimated", "L9", "(Landroid/view/View;Z)V", "d9", "e9", "Z8", "a9", "Lir/nasim/iZ0;", "cmd", "Lir/nasim/jZ0;", "callback", "R8", "(Lir/nasim/iZ0;ILir/nasim/jZ0;)V", "W8", "(Lir/nasim/iZ0;Lir/nasim/jZ0;)V", "T8", "(Lir/nasim/Nv5;I)V", "h9", "()Z", "a", "J9", "L2", "t2", "R4", "stringId", "Y8", "(I)Ljava/lang/String;", "Landroidx/fragment/app/FragmentActivity;", "j9", "(Landroidx/fragment/app/FragmentActivity;)V", "k9", "i9", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "a1", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "progressDialog", "value", "b1", "Z", "X8", "o0", "(Z)V", "baleResumed", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.ua0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22042ua0 extends C23278wf0 implements InterfaceC4411Fa0, InterfaceC24762z98, InterfaceC19822r00 {

    /* renamed from: a1, reason: from kotlin metadata */
    private AlertDialog progressDialog;

    /* renamed from: b1, reason: from kotlin metadata */
    private boolean baleResumed;

    /* renamed from: ir.nasim.ua0$a */
    public static final class a implements InterfaceC15419jZ0 {
        final /* synthetic */ InterfaceC15419jZ0 b;

        a(InterfaceC15419jZ0 interfaceC15419jZ0) {
            this.b = interfaceC15419jZ0;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void a(Object obj) {
            C22042ua0.this.P8();
            this.b.a(obj);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            C22042ua0.this.P8();
            this.b.onError(exc);
        }
    }

    /* renamed from: ir.nasim.ua0$b */
    public static final class b implements DefaultLifecycleObserver {
        b() {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            super.onStart(interfaceC18633oz3);
            C22042ua0 c22042ua0 = C22042ua0.this;
            View viewV7 = c22042ua0.V7();
            AbstractC13042fc3.h(viewV7, "requireView(...)");
            View viewV72 = C22042ua0.this.V7();
            AbstractC13042fc3.h(viewV72, "requireView(...)");
            c22042ua0.l4(viewV7, viewV72);
            C22042ua0.this.getLifecycle().d(this);
        }
    }

    public static /* synthetic */ void A9(C22042ua0 c22042ua0, Fragment fragment, boolean z, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragmentWithRightSlideInAnimation");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        c22042ua0.z9(fragment, z, str);
    }

    public static /* synthetic */ void C9(C22042ua0 c22042ua0, Fragment fragment, boolean z, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragmentWithRightSlideInAnimationWithAllowStateLoss");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        c22042ua0.B9(fragment, z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(C22042ua0 c22042ua0, int i) {
        AlertDialog alertDialog;
        AbstractC13042fc3.i(c22042ua0, "this$0");
        AlertDialog alertDialog2 = c22042ua0.progressDialog;
        if (alertDialog2 != null && alertDialog2.isShowing() && (alertDialog = c22042ua0.progressDialog) != null) {
            alertDialog.dismiss();
        }
        Context contextS7 = c22042ua0.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AlertDialog alertDialog3 = new AlertDialog(contextS7, 1);
        alertDialog3.S(c22042ua0.h6(i));
        alertDialog3.setCanceledOnTouchOutside(false);
        alertDialog3.setCancelable(false);
        alertDialog3.show();
        c22042ua0.progressDialog = alertDialog3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(C22042ua0 c22042ua0, int i, final SA2 sa2) {
        AlertDialog alertDialog;
        AbstractC13042fc3.i(c22042ua0, "this$0");
        AbstractC13042fc3.i(sa2, "$onCancel");
        AlertDialog alertDialog2 = c22042ua0.progressDialog;
        if (alertDialog2 != null && alertDialog2.isShowing() && (alertDialog = c22042ua0.progressDialog) != null) {
            alertDialog.dismiss();
        }
        Context contextS7 = c22042ua0.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AlertDialog alertDialog3 = new AlertDialog(contextS7, 1);
        alertDialog3.S(c22042ua0.h6(i));
        alertDialog3.setCanceledOnTouchOutside(true);
        alertDialog3.setCancelable(true);
        alertDialog3.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.nasim.ta0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                C22042ua0.H9(sa2, dialogInterface);
            }
        });
        alertDialog3.show();
        c22042ua0.progressDialog = alertDialog3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(SA2 sa2, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(sa2, "$onCancel");
        sa2.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(View view) {
        AbstractC14828iY7.l(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(View view, boolean z) {
        AbstractC14828iY7.m(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q8(C22042ua0 c22042ua0) {
        AbstractC13042fc3.i(c22042ua0, "this$0");
        AlertDialog alertDialog = c22042ua0.progressDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        c22042ua0.progressDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U8(C22042ua0 c22042ua0, Object obj, Exception exc) {
        AbstractC13042fc3.i(c22042ua0, "this$0");
        c22042ua0.P8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V8(C22042ua0 c22042ua0, Object obj, Exception exc) {
        AbstractC13042fc3.i(c22042ua0, "this$0");
        c22042ua0.P8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b9(View view) {
        AbstractC14828iY7.c(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c9(View view, boolean z) {
        AbstractC14828iY7.d(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f9(View view) {
        AbstractC14828iY7.f(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g9(View view, boolean z) {
        AbstractC14828iY7.g(view, z);
    }

    public static /* synthetic */ void m9(C22042ua0 c22042ua0, Fragment fragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeFragment");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        c22042ua0.l9(fragment, z);
    }

    public static /* synthetic */ void o9(C22042ua0 c22042ua0, Fragment fragment, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeFragmentWithAllowingStateLoss");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        c22042ua0.n9(fragment, z);
    }

    public static /* synthetic */ void v9(C22042ua0 c22042ua0, int i, Fragment fragment, String str, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            z2 = true;
        }
        c22042ua0.s9(i, fragment, str2, z3, z2);
    }

    public static /* synthetic */ void w9(C22042ua0 c22042ua0, Fragment fragment, boolean z, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        c22042ua0.u9(fragment, z, str);
    }

    public void B9(Fragment fragment, boolean addToBackStack, String tag) {
        AbstractC13042fc3.i(fragment, "fragment");
        androidx.fragment.app.x xVarS = Q7().B0().s();
        int i = AbstractC9220Yz5.slide_in_right;
        int i2 = AbstractC9220Yz5.empty_transition;
        androidx.fragment.app.x xVarC = xVarS.t(i, i2, i2, AbstractC9220Yz5.slide_out_right).c(BC5.content_frame, fragment, tag);
        if (addToBackStack) {
            xVarC.g(null);
        }
        xVarC.i();
    }

    public final void D9(final int title) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.ma0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.E9(this.a, title);
            }
        });
    }

    public final void F9(final int title, final SA2 onCancel) {
        AbstractC13042fc3.i(onCancel, "onCancel");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.ra0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.G9(this.a, title, onCancel);
            }
        });
    }

    public void I9(String text) {
        AbstractC13042fc3.i(text, ParameterNames.TEXT);
        Toast.makeText(G5(), text, 0).show();
    }

    public void J9(String text) {
        try {
            AbstractC7426Rr.a.U(G5(), text);
        } catch (Exception e) {
            C19406qI3.d("NewBaseFragment", e);
        }
    }

    public void K9(final View view) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.oa0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.M9(view);
            }
        });
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void L2(int text) {
        try {
            AbstractC7426Rr.a.U(G5(), h6(text));
        } catch (Exception e) {
            C19406qI3.d("NewBaseFragment", e);
        }
    }

    public void L9(final View view, final boolean isAnimated) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.ia0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.N9(view, isAnimated);
            }
        });
    }

    public final void P8() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.la0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.Q8(this.a);
            }
        });
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void R4() {
        P8();
    }

    public void R8(InterfaceC14830iZ0 cmd, int title, InterfaceC15419jZ0 callback) {
        AbstractC13042fc3.i(cmd, "cmd");
        AbstractC13042fc3.i(callback, "callback");
        D9(title);
        cmd.a(new a(callback));
    }

    public void S8(C6517Nv5 promise) {
        AbstractC13042fc3.i(promise, "promise");
        D9(AbstractC12217eE5.progress_common);
        promise.z(new InterfaceC3273Ae1() { // from class: ir.nasim.ka0
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C22042ua0.U8(this.a, obj, (Exception) obj2);
            }
        });
    }

    public void T8(C6517Nv5 promise, int title) {
        AbstractC13042fc3.i(promise, "promise");
        D9(title);
        promise.z(new InterfaceC3273Ae1() { // from class: ir.nasim.sa0
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                C22042ua0.V8(this.a, obj, (Exception) obj2);
            }
        });
    }

    public void W8(InterfaceC14830iZ0 cmd, InterfaceC15419jZ0 callback) {
        AbstractC13042fc3.i(cmd, "cmd");
        cmd.a(callback);
    }

    /* renamed from: X8, reason: from getter */
    public boolean getBaleResumed() {
        return this.baleResumed;
    }

    public String Y8(int stringId) {
        String strH6 = h6(stringId);
        AbstractC13042fc3.h(strH6, "getString(...)");
        return strH6;
    }

    public void Z8(final View view) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.qa0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.b9(view);
            }
        });
    }

    public boolean a() {
        return false;
    }

    public void a9(final View view, final boolean isAnimated) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.pa0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.c9(view, isAnimated);
            }
        });
    }

    public void d9(final View view) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.ja0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.f9(view);
            }
        });
    }

    public void e9(final View view, final boolean isAnimated) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.na0
            @Override // java.lang.Runnable
            public final void run() {
                C22042ua0.g9(view, isAnimated);
            }
        });
    }

    public boolean h9() {
        return A6() || A5() == null || v6() || !u6() || o6() == null;
    }

    public void i9() {
        if (!getLifecycle().b().j(j.b.STARTED)) {
            getLifecycle().a(new b());
            return;
        }
        View viewV7 = V7();
        AbstractC13042fc3.h(viewV7, "requireView(...)");
        View viewV72 = V7();
        AbstractC13042fc3.h(viewV72, "requireView(...)");
        l4(viewV7, viewV72);
    }

    public final void j9(FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(fragmentActivity, "<this>");
        List listC0 = fragmentActivity.B0().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        for (Fragment fragment : AbstractC15401jX0.T0(listC0)) {
            if (fragment instanceof C13090h) {
                return;
            }
            if (fragment instanceof C22042ua0) {
                fragmentActivity.onBackPressed();
            }
        }
    }

    public final void k9(FragmentActivity fragmentActivity) {
        AbstractC13042fc3.i(fragmentActivity, "<this>");
        List listC0 = fragmentActivity.B0().C0();
        AbstractC13042fc3.h(listC0, "getFragments(...)");
        for (Fragment fragment : AbstractC15401jX0.T0(listC0)) {
            if (fragment instanceof C13090h) {
                ((C13090h) fragment).ia(0);
                return;
            } else if (fragment instanceof C22042ua0) {
                m9(this, fragment, false, 2, null);
            }
        }
    }

    public final void l9(Fragment fragment, boolean pop) {
        AbstractC13042fc3.i(fragment, "fragment");
        FragmentManager fragmentManagerB0 = Q7().B0();
        if (pop) {
            fragmentManagerB0.k1();
        }
        fragmentManagerB0.s().p(fragment).h();
    }

    public final void n9(Fragment fragment, boolean pop) {
        AbstractC13042fc3.i(fragment, "fragment");
        FragmentManager fragmentManagerB0 = Q7().B0();
        if (pop) {
            fragmentManagerB0.k1();
        }
        fragmentManagerB0.s().p(fragment).i();
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void o0(boolean z) {
        if (this.baleResumed == z) {
            return;
        }
        this.baleResumed = z;
        if (z) {
            S0();
        } else {
            a1();
        }
    }

    public void p9(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        Q7().B0().s().r(BC5.content_frame, fragment, null).h();
    }

    public Dialog q9(Dialog dialog) {
        return r9(dialog, null);
    }

    public Dialog r9(Dialog dialog, DialogInterface.OnDismissListener onDismissListener) {
        BaseActivity baseActivity = (BaseActivity) A5();
        if (baseActivity != null) {
            return baseActivity.Y1(dialog, onDismissListener);
        }
        return null;
    }

    public final void s9(int containerViewId, Fragment fragment, String tag, boolean animation, boolean addToBackStack) {
        AbstractC13042fc3.i(fragment, "fragment");
        androidx.fragment.app.x xVarC = Q7().B0().s().c(containerViewId, fragment, tag);
        if (addToBackStack) {
            xVarC.g(null);
        }
        if (animation) {
            xVarC.w(4097);
        }
        xVarC.h();
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void t2(int title) {
        D9(title);
    }

    public final void t9(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        w9(this, fragment, false, null, 6, null);
    }

    public void u9(Fragment fragment, boolean addToBackStack, String tag) {
        AbstractC13042fc3.i(fragment, "fragment");
        androidx.fragment.app.x xVarC = Q7().B0().s().c(BC5.content_frame, fragment, tag);
        if (addToBackStack) {
            xVarC.g(null);
        }
        xVarC.h();
    }

    public final void x9(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        androidx.fragment.app.x xVarS = Q7().B0().s();
        int i = AbstractC9220Yz5.slide_in_left;
        int i2 = AbstractC9220Yz5.empty_transition;
        xVarS.t(i, i2, i2, AbstractC9220Yz5.slide_out_left).c(BC5.content_frame, fragment, null).g(null).h();
    }

    public final void y9(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        A9(this, fragment, false, null, 6, null);
    }

    public void z9(Fragment fragment, boolean addToBackStack, String tag) {
        AbstractC13042fc3.i(fragment, "fragment");
        androidx.fragment.app.x xVarS = Q7().B0().s();
        int i = AbstractC9220Yz5.slide_in_right;
        int i2 = AbstractC9220Yz5.empty_transition;
        androidx.fragment.app.x xVarC = xVarS.t(i, i2, i2, AbstractC9220Yz5.slide_out_right).c(BC5.content_frame, fragment, tag);
        if (addToBackStack) {
            xVarC.g(null);
        }
        xVarC.h();
    }
}
