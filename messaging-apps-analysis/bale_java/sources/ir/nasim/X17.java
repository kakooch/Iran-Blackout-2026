package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class X17 extends MenuInflater {
    static final Class[] e;
    static final Class[] f;
    final Object[] a;
    final Object[] b;
    Context c;
    private Object d;

    private static class a implements MenuItem.OnMenuItemClickListener {
        private static final Class[] c = {MenuItem.class};
        private Object a;
        private Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        J5 A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, X17.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (X17.this.c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(X17.this.b(), this.z));
            }
            if (this.r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.g) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof MenuItemC21752u44) {
                    ((MenuItemC21752u44) menuItem).h(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, X17.e, X17.this.a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i2);
                }
            }
            J5 j5 = this.A;
            if (j5 != null) {
                AbstractC19866r44.a(menuItem, j5);
            }
            AbstractC19866r44.c(menuItem, this.B);
            AbstractC19866r44.g(menuItem, this.C);
            AbstractC19866r44.b(menuItem, this.n, this.o);
            AbstractC19866r44.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                AbstractC19866r44.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                AbstractC19866r44.d(menuItem, colorStateList);
            }
        }

        public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.h = true;
            i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.h = true;
            SubMenu subMenuAddSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = X17.this.c.obtainStyledAttributes(attributeSet, HE5.MenuGroup);
            this.b = typedArrayObtainStyledAttributes.getResourceId(HE5.MenuGroup_android_id, 0);
            this.c = typedArrayObtainStyledAttributes.getInt(HE5.MenuGroup_android_menuCategory, 0);
            this.d = typedArrayObtainStyledAttributes.getInt(HE5.MenuGroup_android_orderInCategory, 0);
            this.e = typedArrayObtainStyledAttributes.getInt(HE5.MenuGroup_android_checkableBehavior, 0);
            this.f = typedArrayObtainStyledAttributes.getBoolean(HE5.MenuGroup_android_visible, true);
            this.g = typedArrayObtainStyledAttributes.getBoolean(HE5.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            androidx.appcompat.widget.C cU = androidx.appcompat.widget.C.u(X17.this.c, attributeSet, HE5.MenuItem);
            this.i = cU.n(HE5.MenuItem_android_id, 0);
            this.j = (cU.k(HE5.MenuItem_android_menuCategory, this.c) & (-65536)) | (cU.k(HE5.MenuItem_android_orderInCategory, this.d) & 65535);
            this.k = cU.p(HE5.MenuItem_android_title);
            this.l = cU.p(HE5.MenuItem_android_titleCondensed);
            this.m = cU.n(HE5.MenuItem_android_icon, 0);
            this.n = c(cU.o(HE5.MenuItem_android_alphabeticShortcut));
            this.o = cU.k(HE5.MenuItem_alphabeticModifiers, 4096);
            this.p = c(cU.o(HE5.MenuItem_android_numericShortcut));
            this.q = cU.k(HE5.MenuItem_numericModifiers, 4096);
            if (cU.s(HE5.MenuItem_android_checkable)) {
                this.r = cU.a(HE5.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = cU.a(HE5.MenuItem_android_checked, false);
            this.t = cU.a(HE5.MenuItem_android_visible, this.f);
            this.u = cU.a(HE5.MenuItem_android_enabled, this.g);
            this.v = cU.k(HE5.MenuItem_showAsAction, -1);
            this.z = cU.o(HE5.MenuItem_android_onClick);
            this.w = cU.n(HE5.MenuItem_actionLayout, 0);
            this.x = cU.o(HE5.MenuItem_actionViewClass);
            String strO = cU.o(HE5.MenuItem_actionProviderClass);
            this.y = strO;
            boolean z = strO != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (J5) e(strO, X17.f, X17.this.b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = cU.p(HE5.MenuItem_contentDescription);
            this.C = cU.p(HE5.MenuItem_tooltipText);
            if (cU.s(HE5.MenuItem_iconTintMode)) {
                this.E = androidx.appcompat.widget.r.e(cU.k(HE5.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (cU.s(HE5.MenuItem_iconTint)) {
                this.D = cU.c(HE5.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            cU.w();
            this.h = false;
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public X17(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        z2 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            J5 j5 = bVar.A;
                            if (j5 == null || !j5.a()) {
                                bVar.a();
                            } else {
                                bVar.b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z2 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    Object b() {
        if (this.d == null) {
            this.d = a(this.c);
        }
        return this.d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof W17)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.c.getResources().getLayout(i);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
