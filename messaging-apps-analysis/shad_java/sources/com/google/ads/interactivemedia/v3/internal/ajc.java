package com.google.ads.interactivemedia.v3.internal;

import java.sql.Date;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajc implements agu {
    ajc() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        if (akzVar.a() == Date.class) {
            return new ajd();
        }
        return null;
    }
}
