package io.github.inflationx.viewpump;

import io.github.inflationx.viewpump.internal.FallbackViewCreationInterceptor;
import io.github.inflationx.viewpump.internal.InterceptorChain;
import io.github.inflationx.viewpump.internal.ReflectiveFallbackViewCreator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ViewPump.kt */
/* loaded from: classes.dex */
public final class ViewPump {
    private static ViewPump INSTANCE;
    private final List<Interceptor> interceptors;
    private final List<Interceptor> interceptorsWithFallback;
    private final boolean isCustomViewCreation;
    private final boolean isReflection;
    private final boolean isStoreLayoutResId;
    public static final Companion Companion = new Companion(null);
    private static final Lazy reflectiveFallbackViewCreator$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ReflectiveFallbackViewCreator>() { // from class: io.github.inflationx.viewpump.ViewPump$Companion$reflectiveFallbackViewCreator$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReflectiveFallbackViewCreator invoke() {
            return new ReflectiveFallbackViewCreator();
        }
    });

    public static final Builder builder() {
        return Companion.builder();
    }

    public static final void init(ViewPump viewPump) {
        Companion.init(viewPump);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ViewPump(List<? extends Interceptor> list, boolean z, boolean z2, boolean z3) {
        this.interceptors = list;
        this.isReflection = z;
        this.isCustomViewCreation = z2;
        this.isStoreLayoutResId = z3;
        this.interceptorsWithFallback = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt___CollectionsKt.plus(list, new FallbackViewCreationInterceptor()));
    }

    public /* synthetic */ ViewPump(List list, boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, z2, z3);
    }

    public final boolean isReflection() {
        return this.isReflection;
    }

    public final boolean isCustomViewCreation() {
        return this.isCustomViewCreation;
    }

    public final boolean isStoreLayoutResId() {
        return this.isStoreLayoutResId;
    }

    public final InflateResult inflate(InflateRequest originalRequest) {
        Intrinsics.checkParameterIsNotNull(originalRequest, "originalRequest");
        return new InterceptorChain(this.interceptorsWithFallback, 0, originalRequest).proceed(originalRequest);
    }

    /* compiled from: ViewPump.kt */
    public static final class Builder {
        private boolean storeLayoutResId;
        private final List<Interceptor> interceptors = new ArrayList();
        private boolean reflection = true;
        private boolean customViewCreation = true;

        public final Builder addInterceptor(Interceptor interceptor) {
            Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final ViewPump build() {
            return new ViewPump(CollectionsKt___CollectionsKt.toList(this.interceptors), this.reflection, this.customViewCreation, this.storeLayoutResId, null);
        }
    }

    /* compiled from: ViewPump.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "reflectiveFallbackViewCreator", "getReflectiveFallbackViewCreator()Lio/github/inflationx/viewpump/FallbackViewCreator;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void init(ViewPump viewPump) {
            ViewPump.INSTANCE = viewPump;
        }

        public final ViewPump get() {
            ViewPump viewPump = ViewPump.INSTANCE;
            if (viewPump != null) {
                return viewPump;
            }
            ViewPump viewPumpBuild = builder().build();
            ViewPump.INSTANCE = viewPumpBuild;
            return viewPumpBuild;
        }

        public final Builder builder() {
            return new Builder();
        }
    }
}
