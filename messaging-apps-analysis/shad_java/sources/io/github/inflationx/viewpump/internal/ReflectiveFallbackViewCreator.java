package io.github.inflationx.viewpump.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import io.github.inflationx.viewpump.FallbackViewCreator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: -ReflectiveFallbackViewCreator.kt */
/* renamed from: io.github.inflationx.viewpump.internal.-ReflectiveFallbackViewCreator, reason: invalid class name */
/* loaded from: classes3.dex */
public final class ReflectiveFallbackViewCreator implements FallbackViewCreator {
    private static final Class<? extends Object>[] CONSTRUCTOR_SIGNATURE_1;
    private static final Class<? extends Object>[] CONSTRUCTOR_SIGNATURE_2;

    /* compiled from: -ReflectiveFallbackViewCreator.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ReflectiveFallbackViewCreator$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new Companion(null);
        CONSTRUCTOR_SIGNATURE_1 = new Class[]{Context.class};
        CONSTRUCTOR_SIGNATURE_2 = new Class[]{Context.class, AttributeSet.class};
    }

    @Override // io.github.inflationx.viewpump.FallbackViewCreator
    public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) throws Exception {
        Constructor constructor;
        Object[] objArr;
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(context, "context");
        try {
            Class<? extends U> clsAsSubclass = Class.forName(name).asSubclass(View.class);
            try {
                Class<? extends Object>[] clsArr = CONSTRUCTOR_SIGNATURE_2;
                constructor = clsAsSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                Intrinsics.checkExpressionValueIsNotNull(constructor, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_2)");
                objArr = new Object[]{context, attributeSet};
            } catch (NoSuchMethodException unused) {
                Class<? extends Object>[] clsArr2 = CONSTRUCTOR_SIGNATURE_1;
                constructor = clsAsSubclass.getConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                Intrinsics.checkExpressionValueIsNotNull(constructor, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_1)");
                objArr = new Context[]{context};
            }
            constructor.setAccessible(true);
            return (View) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                e.printStackTrace();
                return null;
            }
            if (e instanceof NoSuchMethodException) {
                e.printStackTrace();
                return null;
            }
            if (e instanceof IllegalAccessException) {
                e.printStackTrace();
                return null;
            }
            if (e instanceof InstantiationException) {
                e.printStackTrace();
                return null;
            }
            if (e instanceof InvocationTargetException) {
                e.printStackTrace();
                return null;
            }
            throw e;
        }
    }
}
