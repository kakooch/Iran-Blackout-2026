package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Yk extends BaseRequestConfig.BaseRequestArguments {
    public final String a;
    public final String b;
    public final Map<String, String> c;
    public final boolean d;
    public final List<String> e;

    public Yk(Y3 y3) {
        this(y3.a().d(), y3.a().e(), y3.a().a(), y3.a().i(), y3.a().b());
    }

    public final boolean a(Yk yk) {
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Yk mergeFrom(Yk yk) {
        return new Yk((String) WrapUtils.getOrDefaultNullable(this.a, yk.a), (String) WrapUtils.getOrDefaultNullable(this.b, yk.b), (Map) WrapUtils.getOrDefaultNullable(this.c, yk.c), this.d || yk.d, yk.d ? yk.e : this.e);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    public final boolean compareWithOtherArguments(Object obj) {
        return false;
    }

    public final String toString() {
        return "Arguments{distributionReferrer='" + this.a + "', installReferrerSource='" + this.b + "', clientClids=" + this.c + ", hasNewCustomHosts=" + this.d + ", newCustomHosts=" + this.e + '}';
    }

    public Yk(String str, String str2, Map<String, String> map, boolean z, List<String> list) {
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
        this.e = list;
    }

    public Yk() {
        this(null, null, null, false, null);
    }
}
