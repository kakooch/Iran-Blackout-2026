package io.sentry.android.replay;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public final class z {
    public static final z a = new z();
    private static final InterfaceC9173Yu3 b;
    private static final InterfaceC9173Yu3 c;
    public static final int d;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() {
            try {
                return Class.forName("com.android.internal.policy.DecorView");
            } catch (Throwable th) {
                Log.d("WindowSpy", "Unexpected exception loading DecorView on API " + Build.VERSION.SDK_INT, th);
                return null;
            }
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() throws NoSuchFieldException, SecurityException {
            Class clsB = z.a.b();
            if (clsB == null) {
                return null;
            }
            try {
                Field declaredField = clsB.getDeclaredField("mWindow");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e2) {
                Log.d("WindowSpy", "Unexpected exception retrieving " + clsB + "#mWindow on API " + Build.VERSION.SDK_INT, e2);
                return null;
            }
        }
    }

    static {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        b = AbstractC13269fw3.b(enumC4870Gx3, a.e);
        c = AbstractC13269fw3.b(enumC4870Gx3, b.e);
        d = 8;
    }

    private z() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class b() {
        return (Class) b.getValue();
    }

    private final Field c() {
        return (Field) c.getValue();
    }

    public final Window d(View view) throws IllegalAccessException, IllegalArgumentException {
        Field fieldC;
        AbstractC13042fc3.i(view, "maybeDecorView");
        Class clsB = b();
        if (clsB == null || !clsB.isInstance(view) || (fieldC = a.c()) == null) {
            return null;
        }
        Object obj = fieldC.get(view);
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type android.view.Window");
        return (Window) obj;
    }
}
