package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import ir.nasim.AbstractC6771Ox2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.QG4;
import ir.nasim.V01;
import ir.nasim.VX7;
import ir.nasim.XX7;
import ir.nasim.YX7;

/* loaded from: classes2.dex */
public class l extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler W0;
    private boolean f1;
    private Dialog h1;
    private boolean i1;
    private boolean j1;
    private boolean k1;
    private Runnable X0 = new a();
    private DialogInterface.OnCancelListener Y0 = new b();
    private DialogInterface.OnDismissListener Z0 = new c();
    private int a1 = 0;
    private int b1 = 0;
    private boolean c1 = true;
    private boolean d1 = true;
    private int e1 = -1;
    private QG4 g1 = new d();
    private boolean l1 = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.Z0.onDismiss(l.this.h1);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (l.this.h1 != null) {
                l lVar = l.this;
                lVar.onCancel(lVar.h1);
            }
        }
    }

    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (l.this.h1 != null) {
                l lVar = l.this;
                lVar.onDismiss(lVar.h1);
            }
        }
    }

    class d implements QG4 {
        d() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC18633oz3 interfaceC18633oz3) {
            if (interfaceC18633oz3 == null || !l.this.d1) {
                return;
            }
            View viewV7 = l.this.V7();
            if (viewV7.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (l.this.h1 != null) {
                if (FragmentManager.Q0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + l.this.h1);
                }
                l.this.h1.setContentView(viewV7);
            }
        }
    }

    class e extends AbstractC6771Ox2 {
        final /* synthetic */ AbstractC6771Ox2 a;

        e(AbstractC6771Ox2 abstractC6771Ox2) {
            this.a = abstractC6771Ox2;
        }

        @Override // ir.nasim.AbstractC6771Ox2
        public View h(int i) {
            return this.a.i() ? this.a.h(i) : l.this.C8(i);
        }

        @Override // ir.nasim.AbstractC6771Ox2
        public boolean i() {
            return this.a.i() || l.this.D8();
        }
    }

    private void E8(Bundle bundle) {
        if (this.d1 && !this.l1) {
            try {
                this.f1 = true;
                Dialog dialogB8 = B8(bundle);
                this.h1 = dialogB8;
                if (this.d1) {
                    J8(dialogB8, this.a1);
                    Context contextG5 = G5();
                    if (contextG5 instanceof Activity) {
                        this.h1.setOwnerActivity((Activity) contextG5);
                    }
                    this.h1.setCancelable(this.c1);
                    this.h1.setOnCancelListener(this.Y0);
                    this.h1.setOnDismissListener(this.Z0);
                    this.l1 = true;
                } else {
                    this.h1 = null;
                }
                this.f1 = false;
            } catch (Throwable th) {
                this.f1 = false;
                throw th;
            }
        }
    }

    private void w8(boolean z, boolean z2, boolean z3) {
        if (this.j1) {
            return;
        }
        this.j1 = true;
        this.k1 = false;
        Dialog dialog = this.h1;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.h1.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.W0.getLooper()) {
                    onDismiss(this.h1);
                } else {
                    this.W0.post(this.X0);
                }
            }
        }
        this.i1 = true;
        if (this.e1 >= 0) {
            if (z3) {
                V5().n1(this.e1, 1);
            } else {
                V5().l1(this.e1, 1, z);
            }
            this.e1 = -1;
            return;
        }
        x xVarS = V5().s();
        xVarS.v(true);
        xVarS.p(this);
        if (z3) {
            xVarS.j();
        } else if (z) {
            xVarS.i();
        } else {
            xVarS.h();
        }
    }

    public int A8() {
        return this.b1;
    }

    public Dialog B8(Bundle bundle) {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new V01(S7(), A8());
    }

    View C8(int i) {
        Dialog dialog = this.h1;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    boolean D8() {
        return this.l1;
    }

    public final Dialog F8() {
        Dialog dialogY8 = y8();
        if (dialogY8 != null) {
            return dialogY8;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @Override // androidx.fragment.app.Fragment
    public void G6(Bundle bundle) {
        super.G6(bundle);
    }

    public void G8(boolean z) {
        this.c1 = z;
        Dialog dialog = this.h1;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void H8(boolean z) {
        this.d1 = z;
    }

    public void I8(int i, int i2) {
        if (FragmentManager.Q0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2);
        }
        this.a1 = i;
        if (i == 2 || i == 3) {
            this.b1 = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.b1 = i2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void J6(Context context) {
        super.J6(context);
        q6().k(this.g1);
        if (this.k1) {
            return;
        }
        this.j1 = false;
    }

    public void J8(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void K8(FragmentManager fragmentManager, String str) {
        this.j1 = false;
        this.k1 = true;
        x xVarS = fragmentManager.s();
        xVarS.v(true);
        xVarS.e(this, str);
        xVarS.h();
    }

    public void L8(FragmentManager fragmentManager, String str) {
        this.j1 = false;
        this.k1 = true;
        x xVarS = fragmentManager.s();
        xVarS.v(true);
        xVarS.e(this, str);
        xVarS.j();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        this.W0 = new Handler();
        this.d1 = this.A == 0;
        if (bundle != null) {
            this.a1 = bundle.getInt("android:style", 0);
            this.b1 = bundle.getInt("android:theme", 0);
            this.c1 = bundle.getBoolean("android:cancelable", true);
            this.d1 = bundle.getBoolean("android:showsDialog", this.d1);
            this.e1 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        Dialog dialog = this.h1;
        if (dialog != null) {
            this.i1 = true;
            dialog.setOnDismissListener(null);
            this.h1.dismiss();
            if (!this.j1) {
                onDismiss(this.h1);
            }
            this.h1 = null;
            this.l1 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void U6() {
        super.U6();
        if (!this.k1 && !this.j1) {
            this.j1 = true;
        }
        q6().o(this.g1);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater V6(Bundle bundle) {
        LayoutInflater layoutInflaterV6 = super.V6(bundle);
        if (this.d1 && !this.f1) {
            E8(bundle);
            if (FragmentManager.Q0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.h1;
            return dialog != null ? layoutInflaterV6.cloneInContext(dialog.getContext()) : layoutInflaterV6;
        }
        if (FragmentManager.Q0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.d1) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterV6;
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle bundle) {
        super.i7(bundle);
        Dialog dialog = this.h1;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.a1;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.b1;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.c1;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.d1;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.e1;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        Dialog dialog = this.h1;
        if (dialog != null) {
            this.i1 = false;
            dialog.show();
            View decorView = this.h1.getWindow().getDecorView();
            VX7.b(decorView, this);
            YX7.b(decorView, this);
            XX7.b(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
        Dialog dialog = this.h1;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void m7(Bundle bundle) {
        Bundle bundle2;
        super.m7(bundle);
        if (this.h1 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.h1.onRestoreInstanceState(bundle2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.i1) {
            return;
        }
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        w8(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    void t7(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.t7(layoutInflater, viewGroup, bundle);
        if (this.B0 != null || this.h1 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.h1.onRestoreInstanceState(bundle2);
    }

    public void u8() {
        w8(false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    AbstractC6771Ox2 v5() {
        return new e(super.v5());
    }

    public void v8() {
        w8(true, false, false);
    }

    public void x8() {
        w8(false, false, true);
    }

    public Dialog y8() {
        return this.h1;
    }

    public boolean z8() {
        return this.d1;
    }
}
