package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InflateRequest.kt */
/* loaded from: classes3.dex */
public final class InflateRequest {
    private final AttributeSet attrs;
    private final Context context;
    private final FallbackViewCreator fallbackViewCreator;
    private final String name;
    private final View parent;

    static {
        new Companion(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InflateRequest)) {
            return false;
        }
        InflateRequest inflateRequest = (InflateRequest) obj;
        return Intrinsics.areEqual(this.name, inflateRequest.name) && Intrinsics.areEqual(this.context, inflateRequest.context) && Intrinsics.areEqual(this.attrs, inflateRequest.attrs) && Intrinsics.areEqual(this.parent, inflateRequest.parent) && Intrinsics.areEqual(this.fallbackViewCreator, inflateRequest.fallbackViewCreator);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Context context = this.context;
        int iHashCode2 = (iHashCode + (context != null ? context.hashCode() : 0)) * 31;
        AttributeSet attributeSet = this.attrs;
        int iHashCode3 = (iHashCode2 + (attributeSet != null ? attributeSet.hashCode() : 0)) * 31;
        View view = this.parent;
        int iHashCode4 = (iHashCode3 + (view != null ? view.hashCode() : 0)) * 31;
        FallbackViewCreator fallbackViewCreator = this.fallbackViewCreator;
        return iHashCode4 + (fallbackViewCreator != null ? fallbackViewCreator.hashCode() : 0);
    }

    public String toString() {
        return "InflateRequest(name=" + this.name + ", context=" + this.context + ", attrs=" + this.attrs + ", parent=" + this.parent + ", fallbackViewCreator=" + this.fallbackViewCreator + ")";
    }

    public InflateRequest(String name, Context context, AttributeSet attributeSet, View view, FallbackViewCreator fallbackViewCreator) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(fallbackViewCreator, "fallbackViewCreator");
        this.name = name;
        this.context = context;
        this.attrs = attributeSet;
        this.parent = view;
        this.fallbackViewCreator = fallbackViewCreator;
    }

    public final String name() {
        return this.name;
    }

    public final Context context() {
        return this.context;
    }

    public final AttributeSet attrs() {
        return this.attrs;
    }

    public /* synthetic */ InflateRequest(String str, Context context, AttributeSet attributeSet, View view, FallbackViewCreator fallbackViewCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, (i & 4) != 0 ? null : attributeSet, (i & 8) != 0 ? null : view, fallbackViewCreator);
    }

    public final View parent() {
        return this.parent;
    }

    public final FallbackViewCreator fallbackViewCreator() {
        return this.fallbackViewCreator;
    }

    /* compiled from: InflateRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
