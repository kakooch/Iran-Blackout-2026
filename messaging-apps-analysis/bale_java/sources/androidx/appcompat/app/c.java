package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.F;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.lifecycle.j;
import ir.nasim.AX7;
import ir.nasim.AbstractC11961dq4;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.AbstractC15808kC5;
import ir.nasim.AbstractC16222ku3;
import ir.nasim.AbstractC17599nE5;
import ir.nasim.AbstractC21595to3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC7822Ti5;
import ir.nasim.AbstractC9594aE;
import ir.nasim.AbstractWindowCallbackC18738p98;
import ir.nasim.C11568dE;
import ir.nasim.C16731lm1;
import ir.nasim.C23798xX7;
import ir.nasim.C24792zC6;
import ir.nasim.H5;
import ir.nasim.HA5;
import ir.nasim.HE5;
import ir.nasim.IJ6;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.JH3;
import ir.nasim.O98;
import ir.nasim.OB1;
import ir.nasim.OD;
import ir.nasim.PC5;
import ir.nasim.SD;
import ir.nasim.TD;
import ir.nasim.U17;
import ir.nasim.VW5;
import ir.nasim.X17;
import ir.nasim.YD;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xbill.DNS.Type;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class c extends androidx.appcompat.app.b implements e.a, LayoutInflater.Factory2 {
    private static final C24792zC6 a1 = new C24792zC6();
    private static final boolean b1 = false;
    private static final int[] c1 = {R.attr.windowBackground};
    private static final boolean d1 = !"robolectric".equals(Build.FINGERPRINT);
    private static final boolean e1 = true;
    private boolean A;
    boolean A0;
    ViewGroup B;
    boolean B0;
    private boolean C0;
    private TextView D;
    private t[] D0;
    private t E0;
    private boolean F0;
    private View G;
    private boolean G0;
    private boolean H;
    private boolean H0;
    boolean I0;
    private boolean J;
    private Configuration J0;
    private int K0;
    private int L0;
    private int M0;
    private boolean N0;
    private p O0;
    private p P0;
    boolean Q0;
    int R0;
    private final Runnable S0;
    private boolean T0;
    private Rect U0;
    private Rect V0;
    private C11568dE W0;
    private androidx.appcompat.app.g X0;
    boolean Y;
    private OnBackInvokedDispatcher Y0;
    boolean Z;
    private OnBackInvokedCallback Z0;
    final Object j;
    final Context k;
    Window l;
    private n m;
    final OD n;
    ActionBar o;
    MenuInflater p;
    private CharSequence q;
    private OB1 r;
    private g s;
    private u t;
    H5 u;
    ActionBarContextView v;
    PopupWindow w;
    Runnable x;
    C23798xX7 y;
    private boolean z;
    boolean z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if ((cVar.R0 & 1) != 0) {
                cVar.j0(0);
            }
            c cVar2 = c.this;
            if ((cVar2.R0 & 4096) != 0) {
                cVar2.j0(Type.EUI48);
            }
            c cVar3 = c.this;
            cVar3.Q0 = false;
            cVar3.R0 = 0;
        }
    }

    class b implements InterfaceC22474vI4 {
        b() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int iM = o98.m();
            int iG1 = c.this.g1(o98, null);
            if (iM != iG1) {
                o98 = o98.t(o98.k(), iG1, o98.l(), o98.j());
            }
            return AbstractC12990fW7.b0(view, o98);
        }
    }

    /* renamed from: androidx.appcompat.app.c$c, reason: collision with other inner class name */
    class C0013c implements ContentFrameLayout.a {
        C0013c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            c.this.h0();
        }
    }

    class d implements Runnable {

        class a extends AX7 {
            a() {
            }

            @Override // ir.nasim.InterfaceC24982zX7
            public void b(View view) {
                c.this.v.setAlpha(1.0f);
                c.this.y.h(null);
                c.this.y = null;
            }

            @Override // ir.nasim.AX7, ir.nasim.InterfaceC24982zX7
            public void c(View view) {
                c.this.v.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.w.showAtLocation(cVar.v, 55, 0, 0);
            c.this.k0();
            if (!c.this.V0()) {
                c.this.v.setAlpha(1.0f);
                c.this.v.setVisibility(0);
            } else {
                c.this.v.setAlpha(0.0f);
                c cVar2 = c.this;
                cVar2.y = AbstractC12990fW7.e(cVar2.v).b(1.0f);
                c.this.y.h(new a());
            }
        }
    }

    class e extends AX7 {
        e() {
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void b(View view) {
            c.this.v.setAlpha(1.0f);
            c.this.y.h(null);
            c.this.y = null;
        }

        @Override // ir.nasim.AX7, ir.nasim.InterfaceC24982zX7
        public void c(View view) {
            c.this.v.setVisibility(0);
            if (c.this.v.getParent() instanceof View) {
                AbstractC12990fW7.m0((View) c.this.v.getParent());
            }
        }
    }

    interface f {
        boolean a(int i);

        View onCreatePanelView(int i);
    }

    private final class g implements j.a {
        g() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            c.this.a0(eVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackW0 = c.this.w0();
            if (callbackW0 == null) {
                return true;
            }
            callbackW0.onMenuOpened(Type.EUI48, eVar);
            return true;
        }
    }

    class h implements H5.a {
        private H5.a a;

        class a extends AX7 {
            a() {
            }

            @Override // ir.nasim.InterfaceC24982zX7
            public void b(View view) {
                c.this.v.setVisibility(8);
                c cVar = c.this;
                PopupWindow popupWindow = cVar.w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (cVar.v.getParent() instanceof View) {
                    AbstractC12990fW7.m0((View) c.this.v.getParent());
                }
                c.this.v.k();
                c.this.y.h(null);
                c cVar2 = c.this;
                cVar2.y = null;
                AbstractC12990fW7.m0(cVar2.B);
            }
        }

        public h(H5.a aVar) {
            this.a = aVar;
        }

        @Override // ir.nasim.H5.a
        public boolean a(H5 h5, Menu menu) {
            return this.a.a(h5, menu);
        }

        @Override // ir.nasim.H5.a
        public boolean b(H5 h5, Menu menu) {
            AbstractC12990fW7.m0(c.this.B);
            return this.a.b(h5, menu);
        }

        @Override // ir.nasim.H5.a
        public boolean c(H5 h5, MenuItem menuItem) {
            return this.a.c(h5, menuItem);
        }

        @Override // ir.nasim.H5.a
        public void d(H5 h5) {
            this.a.d(h5);
            c cVar = c.this;
            if (cVar.w != null) {
                cVar.l.getDecorView().removeCallbacks(c.this.x);
            }
            c cVar2 = c.this;
            if (cVar2.v != null) {
                cVar2.k0();
                c cVar3 = c.this;
                cVar3.y = AbstractC12990fW7.e(cVar3.v).b(0.0f);
                c.this.y.h(new a());
            }
            c cVar4 = c.this;
            OD od = cVar4.n;
            if (od != null) {
                od.E(cVar4.u);
            }
            c cVar5 = c.this;
            cVar5.u = null;
            AbstractC12990fW7.m0(cVar5.B);
            c.this.e1();
        }
    }

    static class i {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.densityDpi;
            int i2 = configuration2.densityDpi;
            if (i != i2) {
                configuration3.densityDpi = i2;
            }
        }

        static void c(Configuration configuration, Locale locale) {
            configuration.setLayoutDirection(locale);
        }

        static void d(Configuration configuration, Locale locale) {
            configuration.setLocale(locale);
        }
    }

    static class j {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class k {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        static JH3 b(Configuration configuration) {
            return JH3.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(JH3 jh3) {
            LocaleList.setDefault(LocaleList.forLanguageTags(jh3.g()));
        }

        static void d(Configuration configuration, JH3 jh3) {
            configuration.setLocales(LocaleList.forLanguageTags(jh3.g()));
        }
    }

    static class l {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    static class m {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(Object obj, final c cVar) {
            Objects.requireNonNull(cVar);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.d
                public final void onBackInvoked() {
                    cVar.E0();
                }
            };
            TD.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            TD.a(obj).unregisterOnBackInvokedCallback(SD.a(obj2));
        }
    }

    class n extends AbstractWindowCallbackC18738p98 {
        private f b;
        private boolean c;
        private boolean d;
        private boolean e;

        n(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.c = true;
                callback.onContentChanged();
            } finally {
                this.c = false;
            }
        }

        public void d(Window.Callback callback, int i, Menu menu) {
            try {
                this.e = true;
                callback.onPanelClosed(i, menu);
            } finally {
                this.e = false;
            }
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.d ? a().dispatchKeyEvent(keyEvent) : c.this.i0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || c.this.H0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(f fVar) {
            this.b = fVar;
        }

        final ActionMode f(ActionMode.Callback callback) {
            U17.a aVar = new U17.a(c.this.k, callback);
            H5 h5Y0 = c.this.Y0(aVar);
            if (h5Y0 != null) {
                return aVar.e(h5Y0);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.c) {
                a().onContentChanged();
            }
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            View viewOnCreatePanelView;
            f fVar = this.b;
            return (fVar == null || (viewOnCreatePanelView = fVar.onCreatePanelView(i)) == null) ? super.onCreatePanelView(i) : viewOnCreatePanelView;
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            c.this.K0(i);
            return true;
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            if (this.e) {
                a().onPanelClosed(i, menu);
            } else {
                super.onPanelClosed(i, menu);
                c.this.L0(i);
            }
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.e0(true);
            }
            f fVar = this.b;
            boolean zOnPreparePanel = fVar != null && fVar.a(i);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i, view, menu);
            }
            if (eVar != null) {
                eVar.e0(false);
            }
            return zOnPreparePanel;
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            androidx.appcompat.view.menu.e eVar;
            t tVarU0 = c.this.u0(0, true);
            if (tVarU0 == null || (eVar = tVarU0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // ir.nasim.AbstractWindowCallbackC18738p98, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (c.this.C0() && i == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    private class o extends p {
        private final PowerManager c;

        o(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.c.p
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.c.p
        public int c() {
            return j.a(this.c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.c.p
        public void d() {
            c.this.f();
        }
    }

    abstract class p {
        private BroadcastReceiver a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        p() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    c.this.k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            c.this.k.registerReceiver(this.a, intentFilterB);
        }
    }

    private class q extends p {
        private final androidx.appcompat.app.l c;

        q(androidx.appcompat.app.l lVar) {
            super();
            this.c = lVar;
        }

        @Override // androidx.appcompat.app.c.p
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.c.p
        public int c() {
            return this.c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.c.p
        public void d() {
            c.this.f();
        }
    }

    private static class r {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class s extends ContentFrameLayout {
        public s(Context context) {
            super(context);
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return c.this.i0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            c.this.c0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AbstractC9594aE.b(getContext(), i));
        }
    }

    protected static final class t {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.e j;
        androidx.appcompat.view.menu.c k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        t(int i) {
            this.a = i;
        }

        androidx.appcompat.view.menu.k a(j.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.l, PC5.abc_list_menu_item_layout);
                this.k = cVar;
                cVar.e(aVar);
                this.j.b(this.k);
            }
            return this.k.b(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.Q(this.k);
            }
            this.j = eVar;
            if (eVar == null || (cVar = this.k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(AbstractC15790kA5.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                themeNewTheme.applyStyle(i, true);
            }
            themeNewTheme.resolveAttribute(AbstractC15790kA5.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            } else {
                themeNewTheme.applyStyle(AbstractC17599nE5.Theme_AppCompat_CompactMenu, true);
            }
            C16731lm1 c16731lm1 = new C16731lm1(context, 0);
            c16731lm1.getTheme().setTo(themeNewTheme);
            this.l = c16731lm1;
            TypedArray typedArrayObtainStyledAttributes = c16731lm1.obtainStyledAttributes(HE5.AppCompatTheme);
            this.b = typedArrayObtainStyledAttributes.getResourceId(HE5.AppCompatTheme_panelBackground, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(HE5.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final class u implements j.a {
        u() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            androidx.appcompat.view.menu.e eVarF = eVar.F();
            boolean z2 = eVarF != eVar;
            c cVar = c.this;
            if (z2) {
                eVar = eVarF;
            }
            t tVarN0 = cVar.n0(eVar);
            if (tVarN0 != null) {
                if (!z2) {
                    c.this.d0(tVarN0, z);
                } else {
                    c.this.Z(tVarN0.a, tVarN0, eVarF);
                    c.this.d0(tVarN0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackW0;
            if (eVar != eVar.F()) {
                return true;
            }
            c cVar = c.this;
            if (!cVar.Y || (callbackW0 = cVar.w0()) == null || c.this.I0) {
                return true;
            }
            callbackW0.onMenuOpened(Type.EUI48, eVar);
            return true;
        }
    }

    c(Activity activity, OD od) {
        this(activity, null, od, activity);
    }

    private boolean A0(t tVar) {
        Resources.Theme themeNewTheme;
        Context context = this.k;
        int i2 = tVar.a;
        if ((i2 == 0 || i2 == 108) && this.r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(AbstractC15790kA5.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(AbstractC15790kA5.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(AbstractC15790kA5.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                C16731lm1 c16731lm1 = new C16731lm1(context, 0);
                c16731lm1.getTheme().setTo(themeNewTheme);
                context = c16731lm1;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.V(this);
        tVar.c(eVar);
        return true;
    }

    private void B0(int i2) {
        this.R0 = (1 << i2) | this.R0;
        if (this.Q0) {
            return;
        }
        AbstractC12990fW7.h0(this.l.getDecorView(), this.S0);
        this.Q0 = true;
    }

    private boolean G0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        t tVarU0 = u0(i2, true);
        if (tVarU0.o) {
            return false;
        }
        return Q0(tVarU0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean J0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            ir.nasim.H5 r0 = r4.u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.c$t r2 = r4.u0(r5, r0)
            if (r5 != 0) goto L43
            ir.nasim.OB1 r5 = r4.r
            if (r5 == 0) goto L43
            boolean r5 = r5.a()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            ir.nasim.OB1 r5 = r4.r
            boolean r5 = r5.d()
            if (r5 != 0) goto L3c
            boolean r5 = r4.I0
            if (r5 != 0) goto L62
            boolean r5 = r4.Q0(r2, r6)
            if (r5 == 0) goto L62
            ir.nasim.OB1 r5 = r4.r
            boolean r0 = r5.c()
            goto L68
        L3c:
            ir.nasim.OB1 r5 = r4.r
            boolean r0 = r5.b()
            goto L68
        L43:
            boolean r5 = r2.o
            if (r5 != 0) goto L64
            boolean r3 = r2.n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.m
            if (r5 == 0) goto L62
            boolean r5 = r2.r
            if (r5 == 0) goto L5b
            r2.m = r1
            boolean r5 = r4.Q0(r2, r6)
            goto L5c
        L5b:
            r5 = r0
        L5c:
            if (r5 == 0) goto L62
            r4.N0(r2, r6)
            goto L68
        L62:
            r0 = r1
            goto L68
        L64:
            r4.d0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r5 = r4.k
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            goto L85
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.J0(int, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void N0(androidx.appcompat.app.c.t r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.N0(androidx.appcompat.app.c$t, android.view.KeyEvent):void");
    }

    private boolean P0(t tVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((tVar.m || Q0(tVar, keyEvent)) && (eVar = tVar.j) != null) {
            zPerformShortcut = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.r == null) {
            d0(tVar, true);
        }
        return zPerformShortcut;
    }

    private boolean Q0(t tVar, KeyEvent keyEvent) {
        OB1 ob1;
        OB1 ob12;
        OB1 ob13;
        if (this.I0) {
            return false;
        }
        if (tVar.m) {
            return true;
        }
        t tVar2 = this.E0;
        if (tVar2 != null && tVar2 != tVar) {
            d0(tVar2, false);
        }
        Window.Callback callbackW0 = w0();
        if (callbackW0 != null) {
            tVar.i = callbackW0.onCreatePanelView(tVar.a);
        }
        int i2 = tVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (ob13 = this.r) != null) {
            ob13.setMenuPrepared();
        }
        if (tVar.i == null && (!z || !(O0() instanceof androidx.appcompat.app.j))) {
            androidx.appcompat.view.menu.e eVar = tVar.j;
            if (eVar == null || tVar.r) {
                if (eVar == null && (!A0(tVar) || tVar.j == null)) {
                    return false;
                }
                if (z && this.r != null) {
                    if (this.s == null) {
                        this.s = new g();
                    }
                    this.r.setMenu(tVar.j, this.s);
                }
                tVar.j.h0();
                if (!callbackW0.onCreatePanelMenu(tVar.a, tVar.j)) {
                    tVar.c(null);
                    if (z && (ob1 = this.r) != null) {
                        ob1.setMenu(null, this.s);
                    }
                    return false;
                }
                tVar.r = false;
            }
            tVar.j.h0();
            Bundle bundle = tVar.s;
            if (bundle != null) {
                tVar.j.R(bundle);
                tVar.s = null;
            }
            if (!callbackW0.onPreparePanel(0, tVar.i, tVar.j)) {
                if (z && (ob12 = this.r) != null) {
                    ob12.setMenu(null, this.s);
                }
                tVar.j.g0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            tVar.p = z2;
            tVar.j.setQwertyMode(z2);
            tVar.j.g0();
        }
        tVar.m = true;
        tVar.n = false;
        this.E0 = tVar;
        return true;
    }

    private void R0(boolean z) {
        OB1 ob1 = this.r;
        if (ob1 == null || !ob1.a() || (ViewConfiguration.get(this.k).hasPermanentMenuKey() && !this.r.e())) {
            t tVarU0 = u0(0, true);
            tVarU0.q = true;
            d0(tVarU0, false);
            N0(tVarU0, null);
            return;
        }
        Window.Callback callbackW0 = w0();
        if (this.r.d() && z) {
            this.r.b();
            if (this.I0) {
                return;
            }
            callbackW0.onPanelClosed(Type.EUI48, u0(0, true).j);
            return;
        }
        if (callbackW0 == null || this.I0) {
            return;
        }
        if (this.Q0 && (this.R0 & 1) != 0) {
            this.l.getDecorView().removeCallbacks(this.S0);
            this.S0.run();
        }
        t tVarU02 = u0(0, true);
        androidx.appcompat.view.menu.e eVar = tVarU02.j;
        if (eVar == null || tVarU02.r || !callbackW0.onPreparePanel(0, tVarU02.i, eVar)) {
            return;
        }
        callbackW0.onMenuOpened(Type.EUI48, tVarU02.j);
        this.r.c();
    }

    private int S0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return Type.EUI48;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean T(boolean z) {
        return U(z, true);
    }

    private boolean U(boolean z, boolean z2) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        if (this.I0) {
            return false;
        }
        int iY = Y();
        int iD0 = D0(this.k, iY);
        JH3 jh3X = Build.VERSION.SDK_INT < 33 ? X(this.k) : null;
        if (!z2 && jh3X != null) {
            jh3X = t0(this.k.getResources().getConfiguration());
        }
        boolean zD1 = d1(iD0, jh3X, z);
        if (iY == 0) {
            s0(this.k).e();
        } else {
            p pVar = this.O0;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (iY == 3) {
            r0(this.k).e();
        } else {
            p pVar2 = this.P0;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return zD1;
    }

    private void V() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.B.findViewById(R.id.content);
        View decorView = this.l.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.k.obtainStyledAttributes(HE5.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(HE5.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(HE5.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(HE5.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(HE5.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(HE5.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(HE5.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(HE5.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(HE5.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(HE5.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(HE5.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void W(Window window) {
        if (this.l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        n nVar = new n(callback);
        this.m = nVar;
        window.setCallback(nVar);
        C cU = C.u(this.k, null, c1);
        Drawable drawableH = cU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        cU.w();
        this.l = window;
        if (Build.VERSION.SDK_INT < 33 || this.Y0 != null) {
            return;
        }
        O(null);
    }

    private boolean W0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || AbstractC12990fW7.S((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int Y() {
        int i2 = this.K0;
        return i2 != -100 ? i2 : androidx.appcompat.app.b.o();
    }

    private void a1() {
        if (this.A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void b0() {
        p pVar = this.O0;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.P0;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    private AppCompatActivity b1() {
        for (Context baseContext = this.k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c1(Configuration configuration) {
        Activity activity = (Activity) this.j;
        if (activity instanceof InterfaceC18633oz3) {
            if (((InterfaceC18633oz3) activity).getLifecycle().b().j(j.b.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.H0 || this.I0) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean d1(int r9, ir.nasim.JH3 r10, boolean r11) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r8 = this;
            android.content.Context r1 = r8.k
            r4 = 0
            r5 = 0
            r0 = r8
            r2 = r9
            r3 = r10
            android.content.res.Configuration r0 = r0.e0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r8.k
            int r1 = r8.q0(r1)
            android.content.res.Configuration r2 = r8.J0
            if (r2 != 0) goto L1f
            android.content.Context r2 = r8.k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            ir.nasim.JH3 r2 = r8.t0(r2)
            r5 = 0
            if (r10 != 0) goto L30
            r0 = r5
            goto L34
        L30:
            ir.nasim.JH3 r0 = r8.t0(r0)
        L34:
            r6 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r3 = r6
        L3b:
            if (r0 == 0) goto L45
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r7 = 1
            if (r2 == 0) goto L6f
            if (r11 == 0) goto L6f
            boolean r11 = r8.G0
            if (r11 == 0) goto L6f
            boolean r11 = androidx.appcompat.app.c.d1
            if (r11 != 0) goto L58
            boolean r11 = r8.H0
            if (r11 == 0) goto L6f
        L58:
            java.lang.Object r11 = r8.j
            boolean r2 = r11 instanceof android.app.Activity
            if (r2 == 0) goto L6f
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L6f
            java.lang.Object r11 = r8.j
            android.app.Activity r11 = (android.app.Activity) r11
            ir.nasim.X5.v(r11)
            r11 = r7
            goto L70
        L6f:
            r11 = r6
        L70:
            if (r11 != 0) goto L7d
            if (r3 == 0) goto L7d
            r11 = r3 & r1
            if (r11 != r3) goto L79
            r6 = r7
        L79:
            r8.f1(r4, r0, r6, r5)
            goto L7e
        L7d:
            r7 = r11
        L7e:
            if (r7 == 0) goto L9a
            java.lang.Object r11 = r8.j
            boolean r1 = r11 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L9a
            r1 = r3 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L8f
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            r11.Z0(r9)
        L8f:
            r9 = r3 & 4
            if (r9 == 0) goto L9a
            java.lang.Object r9 = r8.j
            androidx.appcompat.app.AppCompatActivity r9 = (androidx.appcompat.app.AppCompatActivity) r9
            r9.Y0(r10)
        L9a:
            if (r7 == 0) goto Laf
            if (r0 == 0) goto Laf
            android.content.Context r9 = r8.k
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            ir.nasim.JH3 r9 = r8.t0(r9)
            r8.U0(r9)
        Laf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.d1(int, ir.nasim.JH3, boolean):boolean");
    }

    private Configuration e0(Context context, int i2, JH3 jh3, Configuration configuration, boolean z) {
        int i3 = i2 != 1 ? i2 != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (jh3 != null) {
            T0(configuration2, jh3);
        }
        return configuration2;
    }

    private ViewGroup f0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.k.obtainStyledAttributes(HE5.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(HE5.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(HE5.AppCompatTheme_windowNoTitle, false)) {
            I(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(HE5.AppCompatTheme_windowActionBar, false)) {
            I(Type.EUI48);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(HE5.AppCompatTheme_windowActionBarOverlay, false)) {
            I(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(HE5.AppCompatTheme_windowActionModeOverlay, false)) {
            I(10);
        }
        this.A0 = typedArrayObtainStyledAttributes.getBoolean(HE5.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        m0();
        this.l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.k);
        if (this.B0) {
            viewGroup = this.z0 ? (ViewGroup) layoutInflaterFrom.inflate(PC5.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(PC5.abc_screen_simple, (ViewGroup) null);
        } else if (this.A0) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(PC5.abc_dialog_title_material, (ViewGroup) null);
            this.Z = false;
            this.Y = false;
        } else if (this.Y) {
            TypedValue typedValue = new TypedValue();
            this.k.getTheme().resolveAttribute(AbstractC15790kA5.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C16731lm1(this.k, typedValue.resourceId) : this.k).inflate(PC5.abc_screen_toolbar, (ViewGroup) null);
            OB1 ob1 = (OB1) viewGroup.findViewById(AbstractC15808kC5.decor_content_parent);
            this.r = ob1;
            ob1.setWindowCallback(w0());
            if (this.Z) {
                this.r.f(109);
            }
            if (this.H) {
                this.r.f(2);
            }
            if (this.J) {
                this.r.f(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.Y + ", windowActionBarOverlay: " + this.Z + ", android:windowIsFloating: " + this.A0 + ", windowActionModeOverlay: " + this.z0 + ", windowNoTitle: " + this.B0 + " }");
        }
        AbstractC12990fW7.E0(viewGroup, new b());
        if (this.r == null) {
            this.D = (TextView) viewGroup.findViewById(AbstractC15808kC5.title);
        }
        F.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(AbstractC15808kC5.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C0013c());
        return viewGroup;
    }

    private void f1(int i2, JH3 jh3, boolean z, Configuration configuration) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Resources resources = this.k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (jh3 != null) {
            T0(configuration2, jh3);
        }
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.i.a(resources);
        }
        int i3 = this.L0;
        if (i3 != 0) {
            this.k.setTheme(i3);
            this.k.getTheme().applyStyle(this.L0, true);
        }
        if (z && (this.j instanceof Activity)) {
            c1(configuration2);
        }
    }

    private void h1(View view) {
        view.setBackgroundColor((AbstractC12990fW7.L(view) & 8192) != 0 ? AbstractC4043Dl1.c(this.k, HA5.abc_decor_view_status_guard_light) : AbstractC4043Dl1.c(this.k, HA5.abc_decor_view_status_guard));
    }

    private void l0() {
        if (this.A) {
            return;
        }
        this.B = f0();
        CharSequence charSequenceV0 = v0();
        if (!TextUtils.isEmpty(charSequenceV0)) {
            OB1 ob1 = this.r;
            if (ob1 != null) {
                ob1.setWindowTitle(charSequenceV0);
            } else if (O0() != null) {
                O0().t(charSequenceV0);
            } else {
                TextView textView = this.D;
                if (textView != null) {
                    textView.setText(charSequenceV0);
                }
            }
        }
        V();
        M0(this.B);
        this.A = true;
        t tVarU0 = u0(0, false);
        if (this.I0) {
            return;
        }
        if (tVarU0 == null || tVarU0.j == null) {
            B0(Type.EUI48);
        }
    }

    private void m0() {
        if (this.l == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                W(((Activity) obj).getWindow());
            }
        }
        if (this.l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration o0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            k.a(configuration, configuration2, configuration3);
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                l.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            i.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private int q0(Context context) throws PackageManager.NameNotFoundException {
        if (!this.N0 && (this.j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.j.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : 786432);
                if (activityInfo != null) {
                    this.M0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.M0 = 0;
            }
        }
        this.N0 = true;
        return this.M0;
    }

    private p r0(Context context) {
        if (this.P0 == null) {
            this.P0 = new o(context);
        }
        return this.P0;
    }

    private p s0(Context context) {
        if (this.O0 == null) {
            this.O0 = new q(androidx.appcompat.app.l.a(context));
        }
        return this.O0;
    }

    private void x0() {
        l0();
        if (this.Y && this.o == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                this.o = new androidx.appcompat.app.m((Activity) this.j, this.Z);
            } else if (obj instanceof Dialog) {
                this.o = new androidx.appcompat.app.m((Dialog) this.j);
            }
            ActionBar actionBar = this.o;
            if (actionBar != null) {
                actionBar.r(this.T0);
            }
        }
    }

    private boolean y0(t tVar) {
        View view = tVar.i;
        if (view != null) {
            tVar.h = view;
            return true;
        }
        if (tVar.j == null) {
            return false;
        }
        if (this.t == null) {
            this.t = new u();
        }
        View view2 = (View) tVar.a(this.t);
        tVar.h = view2;
        return view2 != null;
    }

    private boolean z0(t tVar) {
        tVar.d(p0());
        tVar.g = new s(tVar.l);
        tVar.c = 81;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.b.G(r3)
        L9:
            boolean r0 = r3.Q0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.S0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.I0 = r0
            int r0 = r3.K0
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            ir.nasim.zC6 r0 = androidx.appcompat.app.c.a1
            java.lang.Object r1 = r3.j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.K0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            ir.nasim.zC6 r0 = androidx.appcompat.app.c.a1
            java.lang.Object r1 = r3.j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.o
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.b0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.A():void");
    }

    @Override // androidx.appcompat.app.b
    public void B(Bundle bundle) {
        l0();
    }

    @Override // androidx.appcompat.app.b
    public void C() {
        ActionBar actionBarT = t();
        if (actionBarT != null) {
            actionBarT.s(true);
        }
    }

    public boolean C0() {
        return this.z;
    }

    @Override // androidx.appcompat.app.b
    public void D(Bundle bundle) {
    }

    int D0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return s0(context).c();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return r0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.app.b
    public void E() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        U(true, false);
    }

    boolean E0() {
        boolean z = this.F0;
        this.F0 = false;
        t tVarU0 = u0(0, false);
        if (tVarU0 != null && tVarU0.o) {
            if (!z) {
                d0(tVarU0, true);
            }
            return true;
        }
        H5 h5 = this.u;
        if (h5 != null) {
            h5.c();
            return true;
        }
        ActionBar actionBarT = t();
        return actionBarT != null && actionBarT.h();
    }

    @Override // androidx.appcompat.app.b
    public void F() {
        ActionBar actionBarT = t();
        if (actionBarT != null) {
            actionBarT.s(false);
        }
    }

    boolean F0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.F0 = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            G0(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean H0(int i2, KeyEvent keyEvent) {
        ActionBar actionBarT = t();
        if (actionBarT != null && actionBarT.o(i2, keyEvent)) {
            return true;
        }
        t tVar = this.E0;
        if (tVar != null && P0(tVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            t tVar2 = this.E0;
            if (tVar2 != null) {
                tVar2.n = true;
            }
            return true;
        }
        if (this.E0 == null) {
            t tVarU0 = u0(0, true);
            Q0(tVarU0, keyEvent);
            boolean zP0 = P0(tVarU0, keyEvent.getKeyCode(), keyEvent, 1);
            tVarU0.m = false;
            if (zP0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.b
    public boolean I(int i2) {
        int iS0 = S0(i2);
        if (this.B0 && iS0 == 108) {
            return false;
        }
        if (this.Y && iS0 == 1) {
            this.Y = false;
        }
        if (iS0 == 1) {
            a1();
            this.B0 = true;
            return true;
        }
        if (iS0 == 2) {
            a1();
            this.H = true;
            return true;
        }
        if (iS0 == 5) {
            a1();
            this.J = true;
            return true;
        }
        if (iS0 == 10) {
            a1();
            this.z0 = true;
            return true;
        }
        if (iS0 == 108) {
            a1();
            this.Y = true;
            return true;
        }
        if (iS0 != 109) {
            return this.l.requestFeature(iS0);
        }
        a1();
        this.Z = true;
        return true;
    }

    boolean I0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                J0(0, keyEvent);
                return true;
            }
        } else if (E0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.b
    public void K(int i2) {
        l0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.k).inflate(i2, viewGroup);
        this.m.c(this.l.getCallback());
    }

    void K0(int i2) {
        ActionBar actionBarT;
        if (i2 != 108 || (actionBarT = t()) == null) {
            return;
        }
        actionBarT.i(true);
    }

    @Override // androidx.appcompat.app.b
    public void L(View view) {
        l0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.m.c(this.l.getCallback());
    }

    void L0(int i2) {
        if (i2 == 108) {
            ActionBar actionBarT = t();
            if (actionBarT != null) {
                actionBarT.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            t tVarU0 = u0(i2, true);
            if (tVarU0.o) {
                d0(tVarU0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.b
    public void M(View view, ViewGroup.LayoutParams layoutParams) {
        l0();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.m.c(this.l.getCallback());
    }

    void M0(ViewGroup viewGroup) {
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // androidx.appcompat.app.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.O(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.Y0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.Z0
            if (r1 == 0) goto L11
            androidx.appcompat.app.c.m.c(r0, r1)
            r0 = 0
            r2.Z0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.j
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.c.m.a(r3)
            r2.Y0 = r3
            goto L2e
        L2c:
            r2.Y0 = r3
        L2e:
            r2.e1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.O(android.window.OnBackInvokedDispatcher):void");
    }

    final ActionBar O0() {
        return this.o;
    }

    @Override // androidx.appcompat.app.b
    public void P(Toolbar toolbar) {
        if (this.j instanceof Activity) {
            ActionBar actionBarT = t();
            if (actionBarT instanceof androidx.appcompat.app.m) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.p = null;
            if (actionBarT != null) {
                actionBarT.n();
            }
            this.o = null;
            if (toolbar != null) {
                androidx.appcompat.app.j jVar = new androidx.appcompat.app.j(toolbar, v0(), this.m);
                this.o = jVar;
                this.m.e(jVar.c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.m.e(null);
            }
            v();
        }
    }

    @Override // androidx.appcompat.app.b
    public void Q(int i2) {
        this.L0 = i2;
    }

    @Override // androidx.appcompat.app.b
    public final void R(CharSequence charSequence) {
        this.q = charSequence;
        OB1 ob1 = this.r;
        if (ob1 != null) {
            ob1.setWindowTitle(charSequence);
            return;
        }
        if (O0() != null) {
            O0().t(charSequence);
            return;
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    void T0(Configuration configuration, JH3 jh3) {
        k.d(configuration, jh3);
    }

    void U0(JH3 jh3) {
        k.c(jh3);
    }

    final boolean V0() {
        ViewGroup viewGroup;
        return this.A && (viewGroup = this.B) != null && AbstractC12990fW7.T(viewGroup);
    }

    JH3 X(Context context) {
        JH3 jh3S;
        if (Build.VERSION.SDK_INT >= 33 || (jh3S = androidx.appcompat.app.b.s()) == null) {
            return null;
        }
        JH3 jh3T0 = t0(context.getApplicationContext().getResources().getConfiguration());
        JH3 jh3B = androidx.appcompat.app.h.b(jh3S, jh3T0);
        return jh3B.e() ? jh3T0 : jh3B;
    }

    boolean X0() {
        if (this.Y0 == null) {
            return false;
        }
        t tVarU0 = u0(0, false);
        return (tVarU0 != null && tVarU0.o) || this.u != null;
    }

    public H5 Y0(H5.a aVar) {
        OD od;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        H5 h5 = this.u;
        if (h5 != null) {
            h5.c();
        }
        h hVar = new h(aVar);
        ActionBar actionBarT = t();
        if (actionBarT != null) {
            H5 h5U = actionBarT.u(hVar);
            this.u = h5U;
            if (h5U != null && (od = this.n) != null) {
                od.I(h5U);
            }
        }
        if (this.u == null) {
            this.u = Z0(hVar);
        }
        e1();
        return this.u;
    }

    void Z(int i2, t tVar, Menu menu) {
        if (menu == null) {
            if (tVar == null && i2 >= 0) {
                t[] tVarArr = this.D0;
                if (i2 < tVarArr.length) {
                    tVar = tVarArr[i2];
                }
            }
            if (tVar != null) {
                menu = tVar.j;
            }
        }
        if ((tVar == null || tVar.o) && !this.I0) {
            this.m.d(this.l.getCallback(), i2, menu);
        }
    }

    H5 Z0(H5.a aVar) {
        H5 h5N;
        Context c16731lm1;
        OD od;
        k0();
        H5 h5 = this.u;
        if (h5 != null) {
            h5.c();
        }
        if (!(aVar instanceof h)) {
            aVar = new h(aVar);
        }
        OD od2 = this.n;
        if (od2 == null || this.I0) {
            h5N = null;
        } else {
            try {
                h5N = od2.n(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (h5N != null) {
            this.u = h5N;
        } else {
            if (this.v == null) {
                if (this.A0) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.k.getTheme();
                    theme.resolveAttribute(AbstractC15790kA5.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        c16731lm1 = new C16731lm1(this.k, 0);
                        c16731lm1.getTheme().setTo(themeNewTheme);
                    } else {
                        c16731lm1 = this.k;
                    }
                    this.v = new ActionBarContextView(c16731lm1);
                    PopupWindow popupWindow = new PopupWindow(c16731lm1, (AttributeSet) null, AbstractC15790kA5.actionModePopupWindowStyle);
                    this.w = popupWindow;
                    AbstractC7822Ti5.b(popupWindow, 2);
                    this.w.setContentView(this.v);
                    this.w.setWidth(-1);
                    c16731lm1.getTheme().resolveAttribute(AbstractC15790kA5.actionBarSize, typedValue, true);
                    this.v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c16731lm1.getResources().getDisplayMetrics()));
                    this.w.setHeight(-2);
                    this.x = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.B.findViewById(AbstractC15808kC5.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(p0()));
                        this.v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.v != null) {
                k0();
                this.v.k();
                IJ6 ij6 = new IJ6(this.v.getContext(), this.v, aVar, this.w == null);
                if (aVar.a(ij6, ij6.e())) {
                    ij6.k();
                    this.v.h(ij6);
                    this.u = ij6;
                    if (V0()) {
                        this.v.setAlpha(0.0f);
                        C23798xX7 c23798xX7B = AbstractC12990fW7.e(this.v).b(1.0f);
                        this.y = c23798xX7B;
                        c23798xX7B.h(new e());
                    } else {
                        this.v.setAlpha(1.0f);
                        this.v.setVisibility(0);
                        if (this.v.getParent() instanceof View) {
                            AbstractC12990fW7.m0((View) this.v.getParent());
                        }
                    }
                    if (this.w != null) {
                        this.l.getDecorView().post(this.x);
                    }
                } else {
                    this.u = null;
                }
            }
        }
        H5 h52 = this.u;
        if (h52 != null && (od = this.n) != null) {
            od.I(h52);
        }
        e1();
        return this.u;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        t tVarN0;
        Window.Callback callbackW0 = w0();
        if (callbackW0 == null || this.I0 || (tVarN0 = n0(eVar.F())) == null) {
            return false;
        }
        return callbackW0.onMenuItemSelected(tVarN0.a, menuItem);
    }

    void a0(androidx.appcompat.view.menu.e eVar) {
        if (this.C0) {
            return;
        }
        this.C0 = true;
        this.r.g();
        Window.Callback callbackW0 = w0();
        if (callbackW0 != null && !this.I0) {
            callbackW0.onPanelClosed(Type.EUI48, eVar);
        }
        this.C0 = false;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        R0(true);
    }

    void c0(int i2) {
        d0(u0(i2, true), true);
    }

    void d0(t tVar, boolean z) {
        ViewGroup viewGroup;
        OB1 ob1;
        if (z && tVar.a == 0 && (ob1 = this.r) != null && ob1.d()) {
            a0(tVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
        if (windowManager != null && tVar.o && (viewGroup = tVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                Z(tVar.a, tVar, null);
            }
        }
        tVar.m = false;
        tVar.n = false;
        tVar.o = false;
        tVar.h = null;
        tVar.q = true;
        if (this.E0 == tVar) {
            this.E0 = null;
        }
        if (tVar.a == 0) {
            e1();
        }
    }

    @Override // androidx.appcompat.app.b
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        l0();
        ((ViewGroup) this.B.findViewById(R.id.content)).addView(view, layoutParams);
        this.m.c(this.l.getCallback());
    }

    void e1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zX0 = X0();
            if (zX0 && this.Z0 == null) {
                this.Z0 = m.b(this.Y0, this);
            } else {
                if (zX0 || (onBackInvokedCallback = this.Z0) == null) {
                    return;
                }
                m.c(this.Y0, onBackInvokedCallback);
            }
        }
    }

    @Override // androidx.appcompat.app.b
    public boolean f() {
        return T(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View g0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.W0 == null) {
            String string = this.k.obtainStyledAttributes(HE5.AppCompatTheme).getString(HE5.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.W0 = new C11568dE();
            } else {
                try {
                    this.W0 = (C11568dE) this.k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.W0 = new C11568dE();
                }
            }
        }
        boolean z2 = b1;
        boolean zW0 = false;
        if (z2) {
            if (this.X0 == null) {
                this.X0 = new androidx.appcompat.app.g();
            }
            if (this.X0.a(attributeSet)) {
                z = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zW0 = W0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zW0 = true;
                }
                z = zW0;
            }
        } else {
            z = zW0;
        }
        return this.W0.r(view, str, context, attributeSet, z, z2, true, E.d());
    }

    final int g1(O98 o98, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z;
        boolean z2;
        int iM = o98 != null ? o98.m() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
            if (this.v.isShown()) {
                if (this.U0 == null) {
                    this.U0 = new Rect();
                    this.V0 = new Rect();
                }
                Rect rect2 = this.U0;
                Rect rect3 = this.V0;
                if (o98 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(o98.k(), o98.m(), o98.l(), o98.j());
                }
                F.a(this.B, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                O98 o98H = AbstractC12990fW7.H(this.B);
                int iK = o98H == null ? 0 : o98H.k();
                int iL = o98H == null ? 0 : o98H.l();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.G != null) {
                    View view = this.G;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != iK || marginLayoutParams2.rightMargin != iL) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = iK;
                            marginLayoutParams2.rightMargin = iL;
                            this.G.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.k);
                    this.G = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iK;
                    layoutParams.rightMargin = iL;
                    this.B.addView(this.G, -1, layoutParams);
                }
                View view3 = this.G;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    h1(this.G);
                }
                if (!this.z0 && z) {
                    iM = 0;
                }
                z = z;
                z = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z = false;
            }
            if (z) {
                this.v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.G;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return iM;
    }

    void h0() {
        androidx.appcompat.view.menu.e eVar;
        OB1 ob1 = this.r;
        if (ob1 != null) {
            ob1.g();
        }
        if (this.w != null) {
            this.l.getDecorView().removeCallbacks(this.x);
            if (this.w.isShowing()) {
                try {
                    this.w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.w = null;
        }
        k0();
        t tVarU0 = u0(0, false);
        if (tVarU0 == null || (eVar = tVarU0.j) == null) {
            return;
        }
        eVar.close();
    }

    @Override // androidx.appcompat.app.b
    public Context i(Context context) {
        this.G0 = true;
        int iD0 = D0(context, Y());
        if (androidx.appcompat.app.b.w(context)) {
            androidx.appcompat.app.b.S(context);
        }
        JH3 jh3X = X(context);
        if (e1 && (context instanceof ContextThemeWrapper)) {
            try {
                r.a((ContextThemeWrapper) context, e0(context, iD0, jh3X, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof C16731lm1) {
            try {
                ((C16731lm1) context).a(e0(context, iD0, jh3X, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!d1) {
            return super.i(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = i.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationE0 = e0(context, iD0, jh3X, !configuration2.equals(configuration3) ? o0(configuration2, configuration3) : null, true);
        C16731lm1 c16731lm1 = new C16731lm1(context, AbstractC17599nE5.Theme_AppCompat_Empty);
        c16731lm1.a(configurationE0);
        try {
            if (context.getTheme() != null) {
                VW5.f.a(c16731lm1.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.i(c16731lm1);
    }

    boolean i0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.j;
        if (((obj instanceof AbstractC21595to3.a) || (obj instanceof YD)) && (decorView = this.l.getDecorView()) != null && AbstractC21595to3.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.m.b(this.l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? F0(keyCode, keyEvent) : I0(keyCode, keyEvent);
    }

    void j0(int i2) {
        t tVarU0;
        t tVarU02 = u0(i2, true);
        if (tVarU02.j != null) {
            Bundle bundle = new Bundle();
            tVarU02.j.T(bundle);
            if (bundle.size() > 0) {
                tVarU02.s = bundle;
            }
            tVarU02.j.h0();
            tVarU02.j.clear();
        }
        tVarU02.r = true;
        tVarU02.q = true;
        if ((i2 != 108 && i2 != 0) || this.r == null || (tVarU0 = u0(0, false)) == null) {
            return;
        }
        tVarU0.m = false;
        Q0(tVarU0, null);
    }

    void k0() {
        C23798xX7 c23798xX7 = this.y;
        if (c23798xX7 != null) {
            c23798xX7.c();
        }
    }

    @Override // androidx.appcompat.app.b
    public View l(int i2) {
        l0();
        return this.l.findViewById(i2);
    }

    @Override // androidx.appcompat.app.b
    public Context n() {
        return this.k;
    }

    t n0(Menu menu) {
        t[] tVarArr = this.D0;
        int length = tVarArr != null ? tVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            t tVar = tVarArr[i2];
            if (tVar != null && tVar.j == menu) {
                return tVar;
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return g0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.b
    public int p() {
        return this.K0;
    }

    final Context p0() {
        ActionBar actionBarT = t();
        Context contextK = actionBarT != null ? actionBarT.k() : null;
        return contextK == null ? this.k : contextK;
    }

    @Override // androidx.appcompat.app.b
    public MenuInflater r() {
        if (this.p == null) {
            x0();
            ActionBar actionBar = this.o;
            this.p = new X17(actionBar != null ? actionBar.k() : this.k);
        }
        return this.p;
    }

    @Override // androidx.appcompat.app.b
    public ActionBar t() {
        x0();
        return this.o;
    }

    JH3 t0(Configuration configuration) {
        return k.b(configuration);
    }

    @Override // androidx.appcompat.app.b
    public void u() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.k);
        if (layoutInflaterFrom.getFactory() == null) {
            AbstractC16222ku3.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof c) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    protected t u0(int i2, boolean z) {
        t[] tVarArr = this.D0;
        if (tVarArr == null || tVarArr.length <= i2) {
            t[] tVarArr2 = new t[i2 + 1];
            if (tVarArr != null) {
                System.arraycopy(tVarArr, 0, tVarArr2, 0, tVarArr.length);
            }
            this.D0 = tVarArr2;
            tVarArr = tVarArr2;
        }
        t tVar = tVarArr[i2];
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(i2);
        tVarArr[i2] = tVar2;
        return tVar2;
    }

    @Override // androidx.appcompat.app.b
    public void v() {
        if (O0() == null || t().l()) {
            return;
        }
        B0(0);
    }

    final CharSequence v0() {
        Object obj = this.j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
    }

    final Window.Callback w0() {
        return this.l.getCallback();
    }

    @Override // androidx.appcompat.app.b
    public void y(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        ActionBar actionBarT;
        if (this.Y && this.A && (actionBarT = t()) != null) {
            actionBarT.m(configuration);
        }
        androidx.appcompat.widget.g.b().g(this.k);
        this.J0 = new Configuration(this.k.getResources().getConfiguration());
        U(false, false);
    }

    @Override // androidx.appcompat.app.b
    public void z(Bundle bundle) {
        String strC;
        this.G0 = true;
        T(false);
        m0();
        Object obj = this.j;
        if (obj instanceof Activity) {
            try {
                strC = AbstractC11961dq4.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                ActionBar actionBarO0 = O0();
                if (actionBarO0 == null) {
                    this.T0 = true;
                } else {
                    actionBarO0.r(true);
                }
            }
            androidx.appcompat.app.b.d(this);
        }
        this.J0 = new Configuration(this.k.getResources().getConfiguration());
        this.H0 = true;
    }

    c(Dialog dialog, OD od) {
        this(dialog.getContext(), dialog.getWindow(), od, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private c(Context context, Window window, OD od, Object obj) {
        AppCompatActivity appCompatActivityB1;
        this.y = null;
        this.z = true;
        this.K0 = -100;
        this.S0 = new a();
        this.k = context;
        this.n = od;
        this.j = obj;
        if (this.K0 == -100 && (obj instanceof Dialog) && (appCompatActivityB1 = b1()) != null) {
            this.K0 = appCompatActivityB1.T0().p();
        }
        if (this.K0 == -100) {
            C24792zC6 c24792zC6 = a1;
            Integer num = (Integer) c24792zC6.get(obj.getClass().getName());
            if (num != null) {
                this.K0 = num.intValue();
                c24792zC6.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            W(window);
        }
        androidx.appcompat.widget.g.h();
    }
}
