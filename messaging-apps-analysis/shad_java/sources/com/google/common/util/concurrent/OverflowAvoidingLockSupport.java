package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes3.dex */
final class OverflowAvoidingLockSupport {
    static void parkNanos(Object obj, long j) {
        LockSupport.parkNanos(obj, Math.min(j, 2147483647999999999L));
    }
}
