package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public interface Headers {
    public static final Headers DEFAULT;

    Map<String, String> getHeaders();

    static {
        new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
            @Override // com.bumptech.glide.load.model.Headers
            public Map<String, String> getHeaders() {
                return Collections.emptyMap();
            }
        };
        DEFAULT = new LazyHeaders.Builder().build();
    }
}
