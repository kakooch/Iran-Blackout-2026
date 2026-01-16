package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ar extends as {
    protected final HashSet<String> a;
    protected final JSONObject b;
    protected final long c;

    public ar(ak akVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(akVar);
        this.a = new HashSet<>(hashSet);
        this.b = jSONObject;
        this.c = j;
    }
}
