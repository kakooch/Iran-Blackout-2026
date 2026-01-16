package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.j;

/* loaded from: classes.dex */
public class V01 extends Dialog implements InterfaceC18633oz3, AI4, InterfaceC7760Tb6 {
    private androidx.lifecycle.p a;
    private final C7523Sb6 b;
    private final C23660xI4 c;

    public /* synthetic */ V01(Context context, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    private final androidx.lifecycle.p b() {
        androidx.lifecycle.p pVar = this.a;
        if (pVar != null) {
            return pVar;
        }
        androidx.lifecycle.p pVar2 = new androidx.lifecycle.p(this);
        this.a = pVar2;
        return pVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(V01 v01) {
        AbstractC13042fc3.i(v01, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC13042fc3.i(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public void c() {
        Window window = getWindow();
        AbstractC13042fc3.f(window);
        View decorView = window.getDecorView();
        AbstractC13042fc3.h(decorView, "window!!.decorView");
        VX7.b(decorView, this);
        Window window2 = getWindow();
        AbstractC13042fc3.f(window2);
        View decorView2 = window2.getDecorView();
        AbstractC13042fc3.h(decorView2, "window!!.decorView");
        WX7.b(decorView2, this);
        Window window3 = getWindow();
        AbstractC13042fc3.f(window3);
        View decorView3 = window3.getDecorView();
        AbstractC13042fc3.h(decorView3, "window!!.decorView");
        XX7.b(decorView3, this);
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        return b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.c.l();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            C23660xI4 c23660xI4 = this.c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            AbstractC13042fc3.h(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            c23660xI4.o(onBackInvokedDispatcher);
        }
        this.b.d(bundle);
        b().i(j.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        AbstractC13042fc3.h(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().i(j.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().i(j.a.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        c();
        super.setContentView(i);
    }

    @Override // ir.nasim.InterfaceC7760Tb6
    public C7289Rb6 v1() {
        return this.b.b();
    }

    @Override // ir.nasim.AI4
    public final C23660xI4 z2() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V01(Context context, int i) {
        super(context, i);
        AbstractC13042fc3.i(context, "context");
        this.b = C7523Sb6.d.a(this);
        this.c = new C23660xI4(new Runnable() { // from class: ir.nasim.U01
            @Override // java.lang.Runnable
            public final void run() {
                V01.d(this.a);
            }
        });
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        AbstractC13042fc3.i(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC13042fc3.i(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
