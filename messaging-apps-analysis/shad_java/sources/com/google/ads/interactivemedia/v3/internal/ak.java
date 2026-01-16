package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ak {
    private JSONObject a;
    private final at b;

    public ak(at atVar) {
        this.b = atVar;
    }

    public final void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.a(new aw(this, hashSet, jSONObject, j));
    }

    public final void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.a(new av(this, hashSet, jSONObject, j));
    }

    public final void c() {
        this.b.a(new au(this));
    }

    public final JSONObject d() {
        return this.a;
    }

    public final void e(JSONObject jSONObject) {
        this.a = jSONObject;
    }
}
