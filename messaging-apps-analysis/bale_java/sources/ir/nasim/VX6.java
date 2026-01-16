package ir.nasim;

import java.util.Map;

/* loaded from: classes3.dex */
public abstract class VX6 {
    private final String a;
    private final String b;
    private final long c;
    private final Long d;
    private final Map e;

    public /* synthetic */ VX6(String str, String str2, long j, Long l, Map map, ED1 ed1) {
        this(str, str2, j, l, map);
    }

    public abstract String a();

    public abstract String b();

    public abstract Long c();

    private VX6(String str, String str2, long j, Long l, Map map) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = l;
        this.e = map;
    }
}
