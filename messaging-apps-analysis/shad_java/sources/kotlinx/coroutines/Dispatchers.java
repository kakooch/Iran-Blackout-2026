package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Dispatchers.kt */
/* loaded from: classes4.dex */
public final class Dispatchers {
    private static final CoroutineDispatcher Default;
    private static final CoroutineDispatcher IO;

    static {
        new Dispatchers();
        Default = CoroutineContextKt.createDefaultDispatcher();
        Unconfined unconfined = Unconfined.INSTANCE;
        IO = DefaultScheduler.INSTANCE.getIO();
    }

    private Dispatchers() {
    }

    public static final CoroutineDispatcher getDefault() {
        return Default;
    }

    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }
}
