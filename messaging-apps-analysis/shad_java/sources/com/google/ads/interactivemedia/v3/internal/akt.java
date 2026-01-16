package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.Enum;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akt<T extends Enum<T>> extends agt<T> {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();

    public akt(Class<T> cls) {
        try {
            for (T t : cls.getEnumConstants()) {
                String strName = t.name();
                agw agwVar = (agw) cls.getField(strName).getAnnotation(agw.class);
                if (agwVar != null) {
                    strName = agwVar.a();
                    for (String str : agwVar.b()) {
                        this.a.put(str, t);
                    }
                }
                this.a.put(strName, t);
                this.b.put(t, strName);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Object read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return this.a.get(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Object obj) throws IOException {
        Enum r3 = (Enum) obj;
        aldVar.k(r3 == null ? null : this.b.get(r3));
    }
}
