package io.github.inflationx.viewpump.internal;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BuildCompat;
import io.github.inflationx.viewpump.FallbackViewCreator;
import io.github.inflationx.viewpump.InflateRequest;
import io.github.inflationx.viewpump.R$id;
import io.github.inflationx.viewpump.ViewPump;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: -ViewPumpLayoutInflater.kt */
/* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater, reason: invalid class name */
/* loaded from: classes3.dex */
public final class ViewPumpLayoutInflater extends LayoutInflater {
    private final boolean IS_AT_LEAST_Q;
    private final FallbackViewCreator nameAndAttrsViewCreator;
    private final FallbackViewCreator parentAndNameAndAttrsViewCreator;
    private boolean setPrivateFactory;
    private boolean storeLayoutResId;
    public static final Companion Companion = new Companion(null);
    private static final Set<String> CLASS_PREFIX_LIST = SetsKt__SetsKt.setOf((Object[]) new String[]{"android.widget.", "android.webkit."});
    private static final Lazy CONSTRUCTOR_ARGS_FIELD$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Field>() { // from class: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$Companion$CONSTRUCTOR_ARGS_FIELD$2
        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() throws NoSuchFieldException {
            Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
            if (declaredField == null) {
                throw new IllegalArgumentException("No constructor arguments field found in LayoutInflater!".toString());
            }
            declaredField.setAccessible(true);
            return declaredField;
        }
    });

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPumpLayoutInflater(LayoutInflater original, Context newContext, boolean z) {
        super(original, newContext);
        Intrinsics.checkParameterIsNotNull(original, "original");
        Intrinsics.checkParameterIsNotNull(newContext, "newContext");
        this.IS_AT_LEAST_Q = Build.VERSION.SDK_INT > 28 || BuildCompat.isAtLeastQ();
        this.nameAndAttrsViewCreator = new NameAndAttrsViewCreator(this);
        this.parentAndNameAndAttrsViewCreator = new ParentAndNameAndAttrsViewCreator(this);
        this.storeLayoutResId = ViewPump.Companion.get().isStoreLayoutResId();
        setUpLayoutFactories(z);
    }

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context newContext) {
        Intrinsics.checkParameterIsNotNull(newContext, "newContext");
        return new ViewPumpLayoutInflater(this, newContext, true);
    }

    @Override // android.view.LayoutInflater
    public View inflate(int i, ViewGroup viewGroup, boolean z) {
        View viewInflate = super.inflate(i, viewGroup, z);
        if (viewInflate != null && this.storeLayoutResId) {
            viewInflate.setTag(R$id.viewpump_layout_res, Integer.valueOf(i));
        }
        return viewInflate;
    }

    @Override // android.view.LayoutInflater
    public View inflate(XmlPullParser parser, ViewGroup viewGroup, boolean z) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkParameterIsNotNull(parser, "parser");
        setPrivateFactoryInternal();
        View viewInflate = super.inflate(parser, viewGroup, z);
        Intrinsics.checkExpressionValueIsNotNull(viewInflate, "super.inflate(parser, root, attachToRoot)");
        return viewInflate;
    }

    private final void setUpLayoutFactories(boolean z) {
        if (z) {
            return;
        }
        if (getFactory2() != null && !(getFactory2() instanceof WrapperFactory2)) {
            setFactory2(getFactory2());
        }
        if (getFactory() == null || (getFactory() instanceof WrapperFactory)) {
            return;
        }
        setFactory(getFactory());
    }

    @Override // android.view.LayoutInflater
    public void setFactory(LayoutInflater.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "factory");
        if (!(factory instanceof WrapperFactory)) {
            super.setFactory(new WrapperFactory(factory));
        } else {
            super.setFactory(factory);
        }
    }

    @Override // android.view.LayoutInflater
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        Intrinsics.checkParameterIsNotNull(factory2, "factory2");
        if (!(factory2 instanceof WrapperFactory2)) {
            super.setFactory2(new WrapperFactory2(factory2));
        } else {
            super.setFactory2(factory2);
        }
    }

    private final void setPrivateFactoryInternal() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.setPrivateFactory && ViewPump.Companion.get().isReflection()) {
            if (!(getContext() instanceof LayoutInflater.Factory2)) {
                this.setPrivateFactory = true;
                return;
            }
            Method accessibleMethod = ReflectionUtils.getAccessibleMethod(LayoutInflater.class, "setPrivateFactory");
            Object[] objArr = new Object[1];
            Object context = getContext();
            if (context != null) {
                objArr[0] = new PrivateWrapperFactory2((LayoutInflater.Factory2) context, this);
                ReflectionUtils.invokeMethod(accessibleMethod, this, objArr);
                this.setPrivateFactory = true;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
        }
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(View view, String name, AttributeSet attributeSet) throws ClassNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        ViewPump viewPump = ViewPump.Companion.get();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return viewPump.inflate(new InflateRequest(name, context, attributeSet, view, this.parentAndNameAndAttrsViewCreator)).view();
    }

    @Override // android.view.LayoutInflater
    protected View onCreateView(String name, AttributeSet attributeSet) throws ClassNotFoundException {
        Intrinsics.checkParameterIsNotNull(name, "name");
        ViewPump viewPump = ViewPump.Companion.get();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return viewPump.inflate(new InflateRequest(name, context, attributeSet, null, this.nameAndAttrsViewCreator, 8, null)).view();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View createCustomViewInternal(View view, String str, Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        Field constructor_args_field;
        if (!ViewPump.Companion.get().isCustomViewCreation() || view != null || StringsKt__StringsKt.indexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) <= -1) {
            return view;
        }
        if (this.IS_AT_LEAST_Q) {
            return cloneInContext(context).createView(str, null, attributeSet);
        }
        Companion companion = Companion;
        Object obj = companion.getCONSTRUCTOR_ARGS_FIELD().get(this);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        }
        Object[] objArr = (Object[]) obj;
        Object obj2 = objArr[0];
        objArr[0] = context;
        ReflectionUtils.setValueQuietly(companion.getCONSTRUCTOR_ARGS_FIELD(), this, objArr);
        try {
            view = createView(str, null, attributeSet);
            objArr[0] = obj2;
            constructor_args_field = companion.getCONSTRUCTOR_ARGS_FIELD();
        } catch (ClassNotFoundException unused) {
            objArr[0] = obj2;
            constructor_args_field = Companion.getCONSTRUCTOR_ARGS_FIELD();
        } catch (Throwable th) {
            objArr[0] = obj2;
            ReflectionUtils.setValueQuietly(Companion.getCONSTRUCTOR_ARGS_FIELD(), this, objArr);
            throw th;
        }
        ReflectionUtils.setValueQuietly(constructor_args_field, this, objArr);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View superOnCreateView(View view, String str, AttributeSet attributeSet) {
        try {
            return super.onCreateView(view, str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View superOnCreateView(String str, AttributeSet attributeSet) {
        try {
            return super.onCreateView(str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$ParentAndNameAndAttrsViewCreator */
    private static final class ParentAndNameAndAttrsViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        public ParentAndNameAndAttrsViewCreator(ViewPumpLayoutInflater inflater) {
            Intrinsics.checkParameterIsNotNull(inflater, "inflater");
            this.inflater = inflater;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return this.inflater.superOnCreateView(view, name, attributeSet);
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$NameAndAttrsViewCreator */
    private static final class NameAndAttrsViewCreator implements FallbackViewCreator {
        private final ViewPumpLayoutInflater inflater;

        public NameAndAttrsViewCreator(ViewPumpLayoutInflater inflater) {
            Intrinsics.checkParameterIsNotNull(inflater, "inflater");
            this.inflater = inflater;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) throws InflateException, ClassNotFoundException {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            Iterator it = ViewPumpLayoutInflater.CLASS_PREFIX_LIST.iterator();
            View viewCreateView = null;
            while (it.hasNext()) {
                try {
                    viewCreateView = this.inflater.createView(name, (String) it.next(), attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (viewCreateView != null) {
                    break;
                }
            }
            return viewCreateView == null ? this.inflater.superOnCreateView(name, attributeSet) : viewCreateView;
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactory */
    private static final class WrapperFactory implements LayoutInflater.Factory {
        private final FallbackViewCreator viewCreator;

        public WrapperFactory(LayoutInflater.Factory factory) {
            Intrinsics.checkParameterIsNotNull(factory, "factory");
            this.viewCreator = new WrapperFactoryViewCreator(factory);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return ViewPump.Companion.get().inflate(new InflateRequest(name, context, attributeSet, null, this.viewCreator, 8, null)).view();
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactoryViewCreator */
    private static final class WrapperFactoryViewCreator implements FallbackViewCreator {
        private final LayoutInflater.Factory factory;

        public WrapperFactoryViewCreator(LayoutInflater.Factory factory) {
            Intrinsics.checkParameterIsNotNull(factory, "factory");
            this.factory = factory;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return this.factory.onCreateView(name, context, attributeSet);
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactory2 */
    private static class WrapperFactory2 implements LayoutInflater.Factory2 {
        private final WrapperFactory2ViewCreator viewCreator;

        public WrapperFactory2(LayoutInflater.Factory2 factory2) {
            Intrinsics.checkParameterIsNotNull(factory2, "factory2");
            this.viewCreator = new WrapperFactory2ViewCreator(factory2);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return onCreateView(null, name, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return ViewPump.Companion.get().inflate(new InflateRequest(name, context, attributeSet, view, this.viewCreator)).view();
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$WrapperFactory2ViewCreator */
    private static class WrapperFactory2ViewCreator implements FallbackViewCreator {
        private final LayoutInflater.Factory2 factory2;

        public WrapperFactory2ViewCreator(LayoutInflater.Factory2 factory2) {
            Intrinsics.checkParameterIsNotNull(factory2, "factory2");
            this.factory2 = factory2;
        }

        protected final LayoutInflater.Factory2 getFactory2() {
            return this.factory2;
        }

        @Override // io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return this.factory2.onCreateView(view, name, context, attributeSet);
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$PrivateWrapperFactory2 */
    private static final class PrivateWrapperFactory2 extends WrapperFactory2 {
        private final PrivateWrapperFactory2ViewCreator viewCreator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateWrapperFactory2(LayoutInflater.Factory2 factory2, ViewPumpLayoutInflater inflater) {
            super(factory2);
            Intrinsics.checkParameterIsNotNull(factory2, "factory2");
            Intrinsics.checkParameterIsNotNull(inflater, "inflater");
            this.viewCreator = new PrivateWrapperFactory2ViewCreator(factory2, inflater);
        }

        @Override // io.github.inflationx.viewpump.internal.ViewPumpLayoutInflater.WrapperFactory2, android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return ViewPump.Companion.get().inflate(new InflateRequest(name, context, attributeSet, view, this.viewCreator)).view();
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$PrivateWrapperFactory2ViewCreator */
    private static final class PrivateWrapperFactory2ViewCreator extends WrapperFactory2ViewCreator {
        private final ViewPumpLayoutInflater inflater;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateWrapperFactory2ViewCreator(LayoutInflater.Factory2 factory2, ViewPumpLayoutInflater inflater) {
            super(factory2);
            Intrinsics.checkParameterIsNotNull(factory2, "factory2");
            Intrinsics.checkParameterIsNotNull(inflater, "inflater");
            this.inflater = inflater;
        }

        @Override // io.github.inflationx.viewpump.internal.ViewPumpLayoutInflater.WrapperFactory2ViewCreator, io.github.inflationx.viewpump.FallbackViewCreator
        public View onCreateView(View view, String name, Context context, AttributeSet attributeSet) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(context, "context");
            return this.inflater.createCustomViewInternal(getFactory2().onCreateView(view, name, context, attributeSet), name, context, attributeSet);
        }
    }

    /* compiled from: -ViewPumpLayoutInflater.kt */
    /* renamed from: io.github.inflationx.viewpump.internal.-ViewPumpLayoutInflater$Companion */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "CONSTRUCTOR_ARGS_FIELD", "getCONSTRUCTOR_ARGS_FIELD()Ljava/lang/reflect/Field;"))};

        /* JADX INFO: Access modifiers changed from: private */
        public final Field getCONSTRUCTOR_ARGS_FIELD() {
            Lazy lazy = ViewPumpLayoutInflater.CONSTRUCTOR_ARGS_FIELD$delegate;
            Companion companion = ViewPumpLayoutInflater.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (Field) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
