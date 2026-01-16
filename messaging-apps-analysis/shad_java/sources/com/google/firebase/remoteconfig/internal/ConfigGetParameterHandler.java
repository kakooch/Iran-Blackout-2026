package com.google.firebase.remoteconfig.internal;

import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.util.BiConsumer;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ConfigGetParameterHandler {
    private final Executor executor;
    private final Set<BiConsumer<String, ConfigContainer>> listeners = new HashSet();

    static {
        Charset.forName(Utf8Charset.NAME);
        Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.executor = executor;
    }

    public void addListener(BiConsumer<String, ConfigContainer> biConsumer) {
        synchronized (this.listeners) {
            this.listeners.add(biConsumer);
        }
    }
}
