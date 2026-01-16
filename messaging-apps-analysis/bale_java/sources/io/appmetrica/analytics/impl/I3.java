package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13042fc3;
import java.util.Map;

/* loaded from: classes3.dex */
public final class I3 implements N7 {
    public final Map a;
    public final M7 b;

    public I3(Map<String, String> map, M7 m7) {
        this.a = map;
        this.b = m7;
    }

    public final I3 a(Map<String, String> map, M7 m7) {
        return new I3(map, m7);
    }

    public final Map<String, String> b() {
        return this.a;
    }

    public final M7 c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I3)) {
            return false;
        }
        I3 i3 = (I3) obj;
        return AbstractC13042fc3.d(this.a, i3.a) && this.b == i3.b;
    }

    public final int hashCode() {
        Map map = this.a;
        return this.b.hashCode() + ((map == null ? 0 : map.hashCode()) * 31);
    }

    public final String toString() {
        return "Candidate(clids=" + this.a + ", source=" + this.b + ')';
    }

    public static I3 a(I3 i3, Map map, M7 m7, int i, Object obj) {
        if ((i & 1) != 0) {
            map = i3.a;
        }
        if ((i & 2) != 0) {
            m7 = i3.b;
        }
        i3.getClass();
        return new I3(map, m7);
    }

    @Override // io.appmetrica.analytics.impl.N7
    public final M7 a() {
        return this.b;
    }
}
