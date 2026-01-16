package org.acra.plugins;

import org.acra.config.CoreConfiguration;

/* loaded from: classes.dex */
public interface Plugin {

    /* renamed from: org.acra.plugins.Plugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$enabled(Plugin plugin, CoreConfiguration coreConfiguration) {
            return true;
        }
    }

    boolean enabled(CoreConfiguration coreConfiguration);
}
