package io.github.inflationx.viewpump;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InflateResult.kt */
/* loaded from: classes3.dex */
public final class InflateResult {
    private final AttributeSet attrs;
    private final Context context;
    private final String name;
    private final View view;

    static {
        new Companion(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InflateResult)) {
            return false;
        }
        InflateResult inflateResult = (InflateResult) obj;
        return Intrinsics.areEqual(this.view, inflateResult.view) && Intrinsics.areEqual(this.name, inflateResult.name) && Intrinsics.areEqual(this.context, inflateResult.context) && Intrinsics.areEqual(this.attrs, inflateResult.attrs);
    }

    public int hashCode() {
        View view = this.view;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Context context = this.context;
        int iHashCode3 = (iHashCode2 + (context != null ? context.hashCode() : 0)) * 31;
        AttributeSet attributeSet = this.attrs;
        return iHashCode3 + (attributeSet != null ? attributeSet.hashCode() : 0);
    }

    public String toString() {
        return "InflateResult(view=" + this.view + ", name=" + this.name + ", context=" + this.context + ", attrs=" + this.attrs + ")";
    }

    public InflateResult(View view, String name, Context context, AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.view = view;
        this.name = name;
        this.context = context;
        this.attrs = attributeSet;
    }

    public final View view() {
        return this.view;
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

    public final Builder toBuilder() {
        return new Builder(this);
    }

    /* compiled from: InflateResult.kt */
    public static final class Builder {
        private AttributeSet attrs;
        private Context context;
        private String name;
        private View view;

        public Builder(InflateResult result) {
            Intrinsics.checkParameterIsNotNull(result, "result");
            this.view = result.view();
            this.name = result.name();
            this.context = result.context();
            this.attrs = result.attrs();
        }

        public final Builder view(View view) {
            this.view = view;
            return this;
        }

        public final InflateResult build() {
            String str = this.name;
            if (str == null) {
                throw new IllegalStateException("name == null".toString());
            }
            View view = this.view;
            if (view == null) {
                view = null;
            } else if (!Intrinsics.areEqual(str, view.getClass().getName())) {
                throw new IllegalStateException(("name (" + str + ") must be the view's fully qualified name (" + view.getClass().getName() + ')').toString());
            }
            Context context = this.context;
            if (context != null) {
                return new InflateResult(view, str, context, this.attrs);
            }
            throw new IllegalStateException("context == null");
        }
    }

    /* compiled from: InflateResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
