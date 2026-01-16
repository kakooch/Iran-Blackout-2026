package io.sentry;

/* loaded from: classes3.dex */
public final class V3 {
    private final Boolean a;
    private final Double b;
    private final Double c;
    private final Boolean d;
    private final Double e;

    public V3(Boolean bool) {
        this(bool, null);
    }

    public Double a() {
        return this.e;
    }

    public Boolean b() {
        return this.d;
    }

    public Double c() {
        return this.c;
    }

    public Double d() {
        return this.b;
    }

    public Boolean e() {
        return this.a;
    }

    public V3(Boolean bool, Double d) {
        this(bool, d, null, Boolean.FALSE, null);
    }

    public V3(Boolean bool, Double d, Double d2) {
        this(bool, d, d2, Boolean.FALSE, null);
    }

    public V3(Boolean bool, Double d, Boolean bool2, Double d2) {
        this(bool, d, null, bool2, d2);
    }

    public V3(Boolean bool, Double d, Double d2, Boolean bool2, Double d3) {
        this.a = bool;
        this.b = d;
        this.c = d2;
        this.d = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.e = d3;
    }
}
