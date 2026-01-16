package io.github.inflationx.viewpump;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import io.github.inflationx.viewpump.internal.ViewPumpLayoutInflater;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ViewPumpContextWrapper.kt */
/* loaded from: classes3.dex */
public final class ViewPumpContextWrapper extends ContextWrapper {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ViewPumpContextWrapper.class), "inflater", "getInflater()Lio/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater;"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy inflater$delegate;

    private final ViewPumpLayoutInflater getInflater() {
        Lazy lazy = this.inflater$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ViewPumpLayoutInflater) lazy.getValue();
    }

    public static final ContextWrapper wrap(Context context) {
        return Companion.wrap(context);
    }

    private ViewPumpContextWrapper(Context context) {
        super(context);
        this.inflater$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewPumpLayoutInflater>() { // from class: io.github.inflationx.viewpump.ViewPumpContextWrapper$inflater$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewPumpLayoutInflater invoke() {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.this$0.getBaseContext());
                Intrinsics.checkExpressionValueIsNotNull(layoutInflaterFrom, "LayoutInflater.from(baseContext)");
                return new ViewPumpLayoutInflater(layoutInflaterFrom, this.this$0, false);
            }
        });
    }

    public /* synthetic */ ViewPumpContextWrapper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            return getInflater();
        }
        return super.getSystemService(name);
    }

    /* compiled from: ViewPumpContextWrapper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContextWrapper wrap(Context base) {
            Intrinsics.checkParameterIsNotNull(base, "base");
            return new ViewPumpContextWrapper(base, null);
        }
    }
}
