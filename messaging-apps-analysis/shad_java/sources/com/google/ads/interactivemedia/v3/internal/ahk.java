package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ahk implements aid {
    final /* synthetic */ Type a;

    ahk(Type type) {
        this.a = type;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aid
    public final Object a() {
        Type type = this.a;
        if (!(type instanceof ParameterizedType)) {
            throw new agk("Invalid EnumSet type: " + this.a.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        throw new agk("Invalid EnumSet type: " + this.a.toString());
    }
}
