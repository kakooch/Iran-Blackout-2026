package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.AbstractC11961dq4;
import ir.nasim.C6650Oj7;
import ir.nasim.C7289Rb6;
import ir.nasim.H5;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.JH3;
import ir.nasim.OD;
import ir.nasim.VX7;
import ir.nasim.WX7;
import ir.nasim.X5;
import ir.nasim.XX7;
import ir.nasim.YX7;

/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements OD, C6650Oj7.a {
    private androidx.appcompat.app.b B;
    private Resources D;

    class a implements C7289Rb6.c {
        a() {
        }

        @Override // ir.nasim.C7289Rb6.c
        public Bundle b() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.T0().D(bundle);
            return bundle;
        }
    }

    class b implements InterfaceC10854cJ4 {
        b() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            androidx.appcompat.app.b bVarT0 = AppCompatActivity.this.T0();
            bVarT0.u();
            bVarT0.z(AppCompatActivity.this.v1().b("androidx:appcompat"));
        }
    }

    public AppCompatActivity() {
        V0();
    }

    private void V0() {
        v1().h("androidx:appcompat", new a());
        g0(new b());
    }

    private void W0() {
        VX7.b(getWindow().getDecorView(), this);
        YX7.b(getWindow().getDecorView(), this);
        XX7.b(getWindow().getDecorView(), this);
        WX7.b(getWindow().getDecorView(), this);
    }

    private boolean f1(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    public androidx.appcompat.app.b T0() {
        if (this.B == null) {
            this.B = androidx.appcompat.app.b.j(this, this);
        }
        return this.B;
    }

    public ActionBar U0() {
        return T0().t();
    }

    public void X0(C6650Oj7 c6650Oj7) {
        c6650Oj7.i(this);
    }

    protected void Z0(int i) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        W0();
        T0().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(T0().i(context));
    }

    public void c1() {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar actionBarU0 = U0();
        if (getWindow().hasFeature(0)) {
            if (actionBarU0 == null || !actionBarU0.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar actionBarU0 = U0();
        if (keyCode == 82 && actionBarU0 != null && actionBarU0.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean e1() {
        Intent intentH = h();
        if (intentH == null) {
            return false;
        }
        if (!j1(intentH)) {
            i1(intentH);
            return true;
        }
        C6650Oj7 c6650Oj7O = C6650Oj7.o(this);
        X0(c6650Oj7O);
        a1(c6650Oj7O);
        c6650Oj7O.r();
        try {
            X5.r(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        return T0().l(i);
    }

    public void g1(Toolbar toolbar) {
        T0().P(toolbar);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return T0().r();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.D == null && E.d()) {
            this.D = new E(this, super.getResources());
        }
        Resources resources = this.D;
        return resources == null ? super.getResources() : resources;
    }

    @Override // ir.nasim.C6650Oj7.a
    public Intent h() {
        return AbstractC11961dq4.a(this);
    }

    public void i1(Intent intent) {
        AbstractC11961dq4.e(this, intent);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        T0().v();
    }

    public boolean j1(Intent intent) {
        return AbstractC11961dq4.f(this, intent);
    }

    @Override // ir.nasim.OD
    public H5 n(H5.a aVar) {
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        T0().y(configuration);
        if (this.D != null) {
            this.D.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        c1();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        T0().A();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (f1(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar actionBarU0 = U0();
        if (menuItem.getItemId() != 16908332 || actionBarU0 == null || (actionBarU0.j() & 4) == 0) {
            return false;
        }
        return e1();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        T0().B(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        T0().C();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        T0().E();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        T0().F();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        T0().R(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar actionBarU0 = U0();
        if (getWindow().hasFeature(0)) {
            if (actionBarU0 == null || !actionBarU0.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        W0();
        T0().K(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        T0().Q(i);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        W0();
        T0().L(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        W0();
        T0().M(view, layoutParams);
    }

    @Override // ir.nasim.OD
    public void E(H5 h5) {
    }

    @Override // ir.nasim.OD
    public void I(H5 h5) {
    }

    protected void Y0(JH3 jh3) {
    }

    public void a1(C6650Oj7 c6650Oj7) {
    }
}
