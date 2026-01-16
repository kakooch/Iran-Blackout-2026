package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class ValueOrClosed<T> {
    public static final Companion Companion = new Companion(null);
    private final Object holder;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ValueOrClosed m548boximpl(Object obj) {
        return new ValueOrClosed(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m549constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m550equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ValueOrClosed) && Intrinsics.areEqual(obj, ((ValueOrClosed) obj2).m556unboximpl());
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m553hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return m550equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m553hashCodeimpl(this.holder);
    }

    public String toString() {
        return m555toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m556unboximpl() {
        return this.holder;
    }

    private /* synthetic */ ValueOrClosed(Object obj) {
        this.holder = obj;
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m554isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getValue-impl, reason: not valid java name */
    public static final T m552getValueimpl(Object obj) {
        if (obj instanceof Closed) {
            throw new IllegalStateException("Channel was closed".toString());
        }
        return obj;
    }

    /* renamed from: getCloseCause-impl, reason: not valid java name */
    public static final Throwable m551getCloseCauseimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).cause;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m555toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    /* compiled from: Channel.kt */
    public static final class Closed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    /* compiled from: Channel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
