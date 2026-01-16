package ir.nasim;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* renamed from: ir.nasim.lm1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C16731lm1 extends ContextWrapper {
    private static Configuration f;
    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    /* renamed from: ir.nasim.lm1$a */
    static class a {
        static Context a(C16731lm1 c16731lm1, Configuration configuration) {
            return c16731lm1.createConfigurationContext(configuration);
        }
    }

    public C16731lm1(Context context, int i) {
        super(context);
        this.a = i;
    }

    private Resources b() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && e(configuration))) {
                this.e = super.getResources();
            } else {
                this.e = a.a(this, this.d).getResources();
            }
        }
        return this.e;
    }

    private void d() {
        boolean z = this.b == null;
        if (z) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        f(this.b, this.a, z);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f = configuration2;
        }
        return configuration.equals(f);
    }

    public void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.a;
    }

    protected void f(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = AbstractC17599nE5.Theme_AppCompat_Light;
        }
        d();
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            d();
        }
    }

    public C16731lm1(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }
}
