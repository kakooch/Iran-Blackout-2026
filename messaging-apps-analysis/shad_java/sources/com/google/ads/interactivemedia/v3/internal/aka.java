package com.google.ads.interactivemedia.v3.internal;

import java.sql.Timestamp;
import java.util.Date;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aka implements agu {
    aka() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        if (akzVar.a() != Timestamp.class) {
            return null;
        }
        return new ajz(ageVar.d(Date.class));
    }
}
