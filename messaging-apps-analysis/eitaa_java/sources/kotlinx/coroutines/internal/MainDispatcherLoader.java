package kotlinx.coroutines.internal;

import defpackage.C$$ServiceLoaderMethods;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class MainDispatcherLoader {
    private static final boolean FAST_SERVICE_LOADER_ENABLED;
    public static final MainDispatcherLoader INSTANCE;
    public static final MainCoroutineDispatcher dispatcher;

    private MainDispatcherLoader() {
    }

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        INSTANCE = mainDispatcherLoader;
        FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = mainDispatcherLoader.loadMainDispatcher();
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        List<MainDispatcherFactory> list;
        Object next;
        try {
            if (FAST_SERVICE_LOADER_ENABLED) {
                list = FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();
            } else {
                list = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(C$$ServiceLoaderMethods.$load$79754()));
            }
            Iterator<T> it = list.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            MainCoroutineDispatcher mainCoroutineDispatcherTryCreateDispatcher = mainDispatcherFactory == null ? null : MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory, list);
            return mainCoroutineDispatcherTryCreateDispatcher == null ? MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null) : mainCoroutineDispatcherTryCreateDispatcher;
        } catch (Throwable th) {
            return MainDispatchersKt.createMissingDispatcher$default(th, null, 2, null);
        }
    }
}
