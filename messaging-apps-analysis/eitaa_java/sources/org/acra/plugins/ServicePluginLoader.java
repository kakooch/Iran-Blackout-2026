package org.acra.plugins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.util.Predicate;

/* loaded from: classes.dex */
public class ServicePluginLoader implements PluginLoader {
    static /* synthetic */ boolean lambda$load$0(Plugin plugin) {
        return true;
    }

    @Override // org.acra.plugins.PluginLoader
    public <T extends Plugin> List<T> load(Class<T> cls) {
        return loadInternal(cls, new Predicate() { // from class: org.acra.plugins.-$$Lambda$ServicePluginLoader$TwbysuGXroq_5daUa2t9GQp9K4I
            @Override // org.acra.util.Predicate
            public final boolean apply(Object obj) {
                return ServicePluginLoader.lambda$load$0((Plugin) obj);
            }
        });
    }

    @Override // org.acra.plugins.PluginLoader
    public <T extends Plugin> List<T> loadEnabled(final CoreConfiguration coreConfiguration, Class<T> cls) {
        return loadInternal(cls, new Predicate() { // from class: org.acra.plugins.-$$Lambda$ServicePluginLoader$AYtVkIOY4DY5DNh6SrpwDElW_f0
            @Override // org.acra.util.Predicate
            public final boolean apply(Object obj) {
                return ((Plugin) obj).enabled(coreConfiguration);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends Plugin> List<T> loadInternal(Class<T> cls, Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(cls, ServicePluginLoader.class.getClassLoader()).iterator();
        while (it.hasNext()) {
            try {
                Plugin plugin = (Plugin) it.next();
                if (predicate.apply(plugin)) {
                    if (ACRA.DEV_LOGGING) {
                        ACRA.log.d(ACRA.LOG_TAG, "Loaded " + cls.getSimpleName() + " of type " + plugin.getClass().getName());
                    }
                    arrayList.add(plugin);
                } else if (ACRA.DEV_LOGGING) {
                    ACRA.log.d(ACRA.LOG_TAG, "Ignoring disabled " + cls.getSimpleName() + " of type " + plugin.getClass().getSimpleName());
                }
            } catch (ServiceConfigurationError e) {
                ACRA.log.e(ACRA.LOG_TAG, "Unable to load " + cls.getSimpleName(), e);
            }
        }
        return arrayList;
    }
}
