package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
/* loaded from: classes4.dex */
public final class Result<T> implements Serializable {
    public static final Companion Companion = new Companion(null);

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m542constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m545isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m544isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m543exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* compiled from: Result.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: Result.kt */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
