package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class akx {
    private static final akx a;

    static {
        a = ahs.a() < 9 ? new akw() : new aky();
    }

    public static akx b() {
        return a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
