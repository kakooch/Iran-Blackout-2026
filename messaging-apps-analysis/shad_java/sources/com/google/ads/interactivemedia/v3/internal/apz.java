package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apz {
    public static apy a(Object obj) {
        return new apy(obj.getClass().getSimpleName());
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean c(afv afvVar) {
        aps apsVar = (aps) afvVar.a().getAnnotation(aps.class);
        return apsVar != null && Arrays.asList(apsVar.b()).contains(afvVar.b());
    }
}
