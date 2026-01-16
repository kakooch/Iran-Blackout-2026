package ir.nasim;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.window.SplashScreenView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class CI6 {
    public static final a b = new a(null);
    private final c a;

    public static final class a {
        private a() {
        }

        public final CI6 a(Activity activity) {
            AbstractC13042fc3.i(activity, "<this>");
            CI6 ci6 = new CI6(activity, null);
            ci6.b();
            return ci6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static class c {
        private final Activity a;
        private int b;
        private Integer c;
        private Integer d;
        private Drawable e;
        private boolean f;
        private d g;

        public c(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
            this.a = activity;
            this.g = new d() { // from class: ir.nasim.DI6
            };
        }

        public final Activity a() {
            return this.a;
        }

        public void b() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.a.getTheme();
            if (theme.resolveAttribute(AbstractC18745pA5.windowSplashScreenBackground, typedValue, true)) {
                this.c = Integer.valueOf(typedValue.resourceId);
                this.d = Integer.valueOf(typedValue.data);
            }
            if (theme.resolveAttribute(AbstractC18745pA5.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.e = theme.getDrawable(typedValue.resourceId);
            }
            if (theme.resolveAttribute(AbstractC18745pA5.splashScreenIconSize, typedValue, true)) {
                this.f = typedValue.resourceId == AbstractC10167bB5.splashscreen_icon_size_with_background;
            }
            AbstractC13042fc3.h(theme, "currentTheme");
            c(theme, typedValue);
        }

        protected final void c(Resources.Theme theme, TypedValue typedValue) {
            AbstractC13042fc3.i(theme, "currentTheme");
            AbstractC13042fc3.i(typedValue, "typedValue");
            if (theme.resolveAttribute(AbstractC18745pA5.postSplashScreenTheme, typedValue, true)) {
                int i = typedValue.resourceId;
                this.b = i;
                if (i != 0) {
                    this.a.setTheme(i);
                }
            }
        }
    }

    public interface d {
    }

    public /* synthetic */ CI6(Activity activity, ED1 ed1) {
        this(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        this.a.b();
    }

    private CI6(Activity activity) {
        this.a = Build.VERSION.SDK_INT >= 31 ? new b(activity) : new c(activity);
    }

    private static final class b extends c {
        private boolean h;
        private final ViewGroup.OnHierarchyChangeListener i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity) {
            super(activity);
            AbstractC13042fc3.i(activity, "activity");
            this.h = true;
            this.i = new a(activity);
        }

        @Override // ir.nasim.CI6.c
        public void b() {
            Resources.Theme theme = a().getTheme();
            AbstractC13042fc3.h(theme, "activity.theme");
            c(theme, new TypedValue());
            ((ViewGroup) a().getWindow().getDecorView()).setOnHierarchyChangeListener(this.i);
        }

        public final boolean d(SplashScreenView splashScreenView) {
            AbstractC13042fc3.i(splashScreenView, "child");
            WindowInsets windowInsetsBuild = EI6.a().build();
            AbstractC13042fc3.h(windowInsetsBuild, "Builder().build()");
            Rect rect = new Rect(RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, Integer.MAX_VALUE);
            return (windowInsetsBuild == splashScreenView.getRootView().computeSystemWindowInsets(windowInsetsBuild, rect) && rect.isEmpty()) ? false : true;
        }

        public final void e(boolean z) {
            this.h = z;
        }

        public static final class a implements ViewGroup.OnHierarchyChangeListener {
            final /* synthetic */ Activity b;

            a(Activity activity) {
                this.b = activity;
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (HI6.a(view2)) {
                    b bVar = b.this;
                    bVar.e(bVar.d(II6.a(view2)));
                    ((ViewGroup) this.b.getWindow().getDecorView()).setOnHierarchyChangeListener(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }
        }
    }
}
