package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class z extends ContextWrapper {
    private static final Object c = new Object();
    private static ArrayList d;
    private final Resources a;
    private final Resources.Theme b;

    private z(Context context) {
        super(context);
        if (!E.d()) {
            this.a = new B(this, context.getResources());
            this.b = null;
            return;
        }
        E e = new E(this, context.getResources());
        this.a = e;
        Resources.Theme themeNewTheme = e.newTheme();
        this.b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof z) || (context.getResources() instanceof B) || (context.getResources() instanceof E)) {
            return false;
        }
        return E.d();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (c) {
            try {
                ArrayList arrayList = d;
                if (arrayList == null) {
                    d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            d.remove(size);
                        }
                    }
                    for (int size2 = d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) d.get(size2);
                        z zVar = weakReference2 != null ? (z) weakReference2.get() : null;
                        if (zVar != null && zVar.getBaseContext() == context) {
                            return zVar;
                        }
                    }
                }
                z zVar2 = new z(context);
                d.add(new WeakReference(zVar2));
                return zVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
