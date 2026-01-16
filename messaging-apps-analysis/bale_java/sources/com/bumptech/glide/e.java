package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class e {
    private final Map a;

    static final class a {
        private final Map a = new HashMap();

        a() {
        }

        e b() {
            return new e(this);
        }
    }

    e(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    public boolean a(Class cls) {
        return this.a.containsKey(cls);
    }
}
