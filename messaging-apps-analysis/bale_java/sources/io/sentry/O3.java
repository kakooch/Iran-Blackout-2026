package io.sentry;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import java.util.Locale;

/* loaded from: classes3.dex */
public enum O3 implements A0 {
    OK(0, 399),
    CANCELLED(499),
    INTERNAL_ERROR(SIPTransactionStack.BASE_TIMER_INTERVAL),
    UNKNOWN(SIPTransactionStack.BASE_TIMER_INTERVAL),
    UNKNOWN_ERROR(SIPTransactionStack.BASE_TIMER_INTERVAL),
    INVALID_ARGUMENT(400),
    DEADLINE_EXCEEDED(504),
    NOT_FOUND(404),
    ALREADY_EXISTS(409),
    PERMISSION_DENIED(403),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(400),
    ABORTED(409),
    OUT_OF_RANGE(400),
    UNIMPLEMENTED(501),
    UNAVAILABLE(503),
    DATA_LOSS(SIPTransactionStack.BASE_TIMER_INTERVAL),
    UNAUTHENTICATED(401);

    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public O3 a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            return O3.valueOf(interfaceC3118g1.T0().toUpperCase(Locale.ROOT));
        }
    }

    O3(int i) {
        this.minHttpStatusCode = i;
        this.maxHttpStatusCode = i;
    }

    public static O3 fromApiNameSafely(String str) {
        if (str == null) {
            return null;
        }
        try {
            return valueOf(str.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static O3 fromHttpStatusCode(int i) {
        for (O3 o3 : values()) {
            if (o3.matches(i)) {
                return o3;
            }
        }
        return null;
    }

    private boolean matches(int i) {
        return i >= this.minHttpStatusCode && i <= this.maxHttpStatusCode;
    }

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.h(apiName());
    }

    public static O3 fromHttpStatusCode(Integer num, O3 o3) {
        O3 o3FromHttpStatusCode = num != null ? fromHttpStatusCode(num.intValue()) : o3;
        return o3FromHttpStatusCode != null ? o3FromHttpStatusCode : o3;
    }

    O3(int i, int i2) {
        this.minHttpStatusCode = i;
        this.maxHttpStatusCode = i2;
    }
}
