package io.sentry.android.replay;

import android.util.Log;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class x {
    public static final x a = new x();
    private static final InterfaceC9173Yu3 b;
    private static final InterfaceC9173Yu3 c;
    private static final InterfaceC9173Yu3 d;
    public static final int e;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() throws NoSuchFieldException, SecurityException {
            Class clsC = x.a.c();
            if (clsC == null) {
                return null;
            }
            Field declaredField = clsC.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            return declaredField;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class invoke() {
            try {
                return Class.forName("android.view.WindowManagerGlobal");
            } catch (Throwable th) {
                Log.w("WindowManagerSpy", th);
                return null;
            }
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            Method method;
            Class clsC = x.a.c();
            if (clsC == null || (method = clsC.getMethod("getInstance", null)) == null) {
                return null;
            }
            return method.invoke(null, null);
        }
    }

    static {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        b = AbstractC13269fw3.b(enumC4870Gx3, b.e);
        c = AbstractC13269fw3.b(enumC4870Gx3, c.e);
        d = AbstractC13269fw3.b(enumC4870Gx3, a.e);
        e = 8;
    }

    private x() {
    }

    private final Field b() {
        return (Field) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class c() {
        return (Class) b.getValue();
    }

    private final Object d() {
        return c.getValue();
    }

    public final void e(UA2 ua2) {
        Field fieldB;
        AbstractC13042fc3.i(ua2, "swap");
        try {
            Object objD = d();
            if (objD == null || (fieldB = a.b()) == null) {
                return;
            }
            Object obj = fieldB.get(objD);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type java.util.ArrayList<android.view.View>{ kotlin.collections.TypeAliasesKt.ArrayList<android.view.View> }");
            fieldB.set(objD, ua2.invoke((ArrayList) obj));
        } catch (Throwable th) {
            Log.w("WindowManagerSpy", th);
        }
    }
}
