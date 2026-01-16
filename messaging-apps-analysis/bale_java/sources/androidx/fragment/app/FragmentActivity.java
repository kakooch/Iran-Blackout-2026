package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.j;
import ir.nasim.A44;
import ir.nasim.AI4;
import ir.nasim.AbstractC23051wG3;
import ir.nasim.AbstractC24133y6;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.B6;
import ir.nasim.C14819iX7;
import ir.nasim.C23660xI4;
import ir.nasim.C7289Rb6;
import ir.nasim.DJ4;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC15879kK4;
import ir.nasim.InterfaceC17502n44;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterfaceC7258Qy2;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.OJ4;
import ir.nasim.X5;
import ir.nasim.YI4;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class FragmentActivity extends ComponentActivity implements X5.e {
    boolean y;
    boolean z;
    final n w = n.b(new a());
    final androidx.lifecycle.p x = new androidx.lifecycle.p(this);
    boolean A = true;

    class a extends p implements YI4, InterfaceC15879kK4, DJ4, OJ4, InterfaceC15408jX7, AI4, B6, InterfaceC7760Tb6, InterfaceC7258Qy2, InterfaceC17502n44 {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // ir.nasim.YI4
        public void B(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.B(interfaceC25043ze1);
        }

        @Override // ir.nasim.InterfaceC17502n44
        public void C(A44 a44) {
            FragmentActivity.this.C(a44);
        }

        @Override // ir.nasim.DJ4
        public void a(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.a(interfaceC25043ze1);
        }

        @Override // ir.nasim.InterfaceC15879kK4
        public void b(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.b(interfaceC25043ze1);
        }

        @Override // ir.nasim.DJ4
        public void c(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.c(interfaceC25043ze1);
        }

        @Override // ir.nasim.InterfaceC7258Qy2
        public void d(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.L0(fragment);
        }

        @Override // ir.nasim.InterfaceC15408jX7
        public C14819iX7 d1() {
            return FragmentActivity.this.d1();
        }

        @Override // ir.nasim.InterfaceC17502n44
        public void e(A44 a44) {
            FragmentActivity.this.e(a44);
        }

        @Override // ir.nasim.B6
        /* renamed from: f */
        public AbstractC24133y6 getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // ir.nasim.InterfaceC18633oz3
        public androidx.lifecycle.j getLifecycle() {
            return FragmentActivity.this.x;
        }

        @Override // ir.nasim.AbstractC6771Ox2
        public View h(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // ir.nasim.AbstractC6771Ox2
        public boolean i() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // ir.nasim.InterfaceC15879kK4
        public void l(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.l(interfaceC25043ze1);
        }

        @Override // ir.nasim.YI4
        public void o(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.o(interfaceC25043ze1);
        }

        @Override // androidx.fragment.app.p
        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.p
        public LayoutInflater r() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // ir.nasim.OJ4
        public void t(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.t(interfaceC25043ze1);
        }

        @Override // androidx.fragment.app.p
        public boolean u(String str) {
            return X5.z(FragmentActivity.this, str);
        }

        @Override // ir.nasim.InterfaceC7760Tb6
        public C7289Rb6 v1() {
            return FragmentActivity.this.v1();
        }

        @Override // ir.nasim.OJ4
        public void w(InterfaceC25043ze1 interfaceC25043ze1) {
            FragmentActivity.this.w(interfaceC25043ze1);
        }

        @Override // androidx.fragment.app.p
        public void x() {
            y();
        }

        public void y() {
            FragmentActivity.this.m0();
        }

        @Override // androidx.fragment.app.p
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public FragmentActivity q() {
            return FragmentActivity.this;
        }

        @Override // ir.nasim.AI4
        public C23660xI4 z2() {
            return FragmentActivity.this.z2();
        }
    }

    public FragmentActivity() {
        D0();
    }

    private void D0() {
        v1().h("android:support:lifecycle", new C7289Rb6.c() { // from class: ir.nasim.ex2
            @Override // ir.nasim.C7289Rb6.c
            public final Bundle b() {
                return this.a.E0();
            }
        });
        B(new InterfaceC25043ze1() { // from class: ir.nasim.fx2
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.F0((Configuration) obj);
            }
        });
        h0(new InterfaceC25043ze1() { // from class: ir.nasim.gx2
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.G0((Intent) obj);
            }
        });
        g0(new InterfaceC10854cJ4() { // from class: ir.nasim.hx2
            @Override // ir.nasim.InterfaceC10854cJ4
            public final void a(Context context) {
                this.a.H0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle E0() {
        J0();
        this.x.i(j.a.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Configuration configuration) {
        this.w.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(Intent intent) {
        this.w.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(Context context) {
        this.w.a(null);
    }

    private static boolean K0(FragmentManager fragmentManager, j.b bVar) {
        boolean zK0 = false;
        for (Fragment fragment : fragmentManager.C0()) {
            if (fragment != null) {
                if (fragment.P5() != null) {
                    zK0 |= K0(fragment.F5(), bVar);
                }
                B b = fragment.N0;
                if (b != null && b.getLifecycle().b().j(j.b.STARTED)) {
                    fragment.N0.f(bVar);
                    zK0 = true;
                }
                if (fragment.M0.b().j(j.b.STARTED)) {
                    fragment.M0.n(bVar);
                    zK0 = true;
                }
            }
        }
        return zK0;
    }

    final View A0(View view, String str, Context context, AttributeSet attributeSet) {
        return this.w.n(view, str, context, attributeSet);
    }

    public FragmentManager B0() {
        return this.w.l();
    }

    public AbstractC23051wG3 C0() {
        return AbstractC23051wG3.b(this);
    }

    void J0() {
        while (K0(B0(), j.b.CREATED)) {
        }
    }

    public void L0(Fragment fragment) {
    }

    protected void M0() {
        this.x.i(j.a.ON_RESUME);
        this.w.h();
    }

    public void N0(AbstractC9203Yx6 abstractC9203Yx6) {
        X5.x(this, abstractC9203Yx6);
    }

    public void O0(AbstractC9203Yx6 abstractC9203Yx6) {
        X5.y(this, abstractC9203Yx6);
    }

    public void P0() {
        X5.s(this);
    }

    public void Q0() {
        X5.u(this);
    }

    public void S0() {
        X5.C(this);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (K(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.y);
            printWriter.print(" mResumed=");
            printWriter.print(this.z);
            printWriter.print(" mStopped=");
            printWriter.print(this.A);
            if (getApplication() != null) {
                AbstractC23051wG3.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.w.l().d0(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.w.m();
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x.i(j.a.ON_CREATE);
        this.w.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewA0 = A0(view, str, context, attributeSet);
        return viewA0 == null ? super.onCreateView(view, str, context, attributeSet) : viewA0;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.w.f();
        this.x.i(j.a.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.w.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.z = false;
        this.w.g();
        this.x.i(j.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        M0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.w.m();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.w.m();
        super.onResume();
        this.z = true;
        this.w.k();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.w.m();
        super.onStart();
        this.A = false;
        if (!this.y) {
            this.y = true;
            this.w.c();
        }
        this.w.k();
        this.x.i(j.a.ON_START);
        this.w.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.w.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.A = true;
        J0();
        this.w.j();
        this.x.i(j.a.ON_STOP);
    }

    @Override // ir.nasim.X5.e
    public final void s(int i) {
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewA0 = A0(null, str, context, attributeSet);
        return viewA0 == null ? super.onCreateView(str, context, attributeSet) : viewA0;
    }
}
