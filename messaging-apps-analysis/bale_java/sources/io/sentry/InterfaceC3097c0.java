package io.sentry;

import java.util.concurrent.Future;

/* renamed from: io.sentry.c0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC3097c0 {
    void a();

    void b(long j);

    Future c(Runnable runnable, long j);

    boolean isClosed();

    Future submit(Runnable runnable);
}
