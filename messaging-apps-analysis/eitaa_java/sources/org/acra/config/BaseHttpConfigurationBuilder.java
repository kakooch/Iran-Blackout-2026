package org.acra.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BaseHttpConfigurationBuilder {
    private final Map<String, String> httpHeaders = new HashMap();

    BaseHttpConfigurationBuilder() {
    }

    Map<String, String> httpHeaders() {
        return this.httpHeaders;
    }
}
