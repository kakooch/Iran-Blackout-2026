package io.appmetrica.analytics.networktasks.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLifecycleObserver;", "<init>", "()V", "Lir/nasim/rB7;", "onCreate", "onDestroy", "Lio/appmetrica/analytics/networktasks/internal/NetworkCore;", "a", "Lio/appmetrica/analytics/networktasks/internal/NetworkCore;", "getNetworkCore", "()Lio/appmetrica/analytics/networktasks/internal/NetworkCore;", "networkCore", "Companion", "network-tasks_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class NetworkServiceLocator implements NetworkServiceLifecycleObserver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile NetworkServiceLocator b;

    /* renamed from: a, reason: from kotlin metadata */
    private final NetworkCore networkCore;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator$Companion;", "", "Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "getInstance", "()Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "Lir/nasim/rB7;", "init", "()V", "networkServiceLocator", "(Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;)V", "instance", "Lio/appmetrica/analytics/networktasks/internal/NetworkServiceLocator;", "network-tasks_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }

        public final NetworkServiceLocator getInstance() {
            NetworkServiceLocator networkServiceLocator = NetworkServiceLocator.b;
            if (networkServiceLocator != null) {
                return networkServiceLocator;
            }
            AbstractC13042fc3.y("instance");
            return null;
        }

        public final void init() {
            if (NetworkServiceLocator.b == null) {
                synchronized (NetworkServiceLocator.class) {
                    try {
                        if (NetworkServiceLocator.b == null) {
                            NetworkServiceLocator.b = new NetworkServiceLocator();
                        }
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        private Companion() {
        }

        public final void init(NetworkServiceLocator networkServiceLocator) {
            NetworkServiceLocator.b = networkServiceLocator;
        }
    }

    public NetworkServiceLocator() {
        NetworkCore networkCore = new NetworkCore();
        networkCore.setName("IAA-NC");
        networkCore.start();
        this.networkCore = networkCore;
    }

    public static final NetworkServiceLocator getInstance() {
        return INSTANCE.getInstance();
    }

    public static final void init() {
        INSTANCE.init();
    }

    public final NetworkCore getNetworkCore() {
        return this.networkCore;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkServiceLifecycleObserver
    public void onCreate() {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkServiceLifecycleObserver
    public void onDestroy() {
        this.networkCore.stopTasks();
    }

    public static final void init(NetworkServiceLocator networkServiceLocator) {
        INSTANCE.init(networkServiceLocator);
    }
}
