package com.google.common.util.concurrent;

import ir.nasim.AbstractC14535i43;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class CycleDetectingLockFactory {

    public static final class PotentialDeadlockException extends a {
        private final a c;

        @Override // java.lang.Throwable
        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable cause = this.c; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }
    }

    private static class a extends IllegalStateException {
        static final StackTraceElement[] a = new StackTraceElement[0];
        static final AbstractC14535i43 b = AbstractC14535i43.a0(CycleDetectingLockFactory.class.getName(), a.class.getName(), b.class.getName());
    }

    private static class b {
    }
}
