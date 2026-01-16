package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public abstract class Yc extends AbstractC2685le implements InterfaceC2882tk {
    public Yc(Ba ba, String str) {
        super(ba, str);
    }

    public final String c(String str, String str2) {
        return this.a.getString(f(str), str2);
    }

    public final InterfaceC2882tk d(String str, String str2) {
        return (InterfaceC2882tk) b(f(str), str2);
    }

    public final boolean e(String str) {
        return this.a.a(f(str));
    }

    public abstract String f(String str);

    public final InterfaceC2882tk g(String str) {
        return (InterfaceC2882tk) d(f(str));
    }

    public Yc(Ba ba) {
        this(ba, null);
    }

    public final InterfaceC2882tk d(String str, int i) {
        return (InterfaceC2882tk) b(f(str), i);
    }

    public final int c(String str, int i) {
        return this.a.getInt(f(str), i);
    }

    public final InterfaceC2882tk d(String str, long j) {
        return (InterfaceC2882tk) b(f(str), j);
    }

    public final InterfaceC2882tk d(String str, boolean z) {
        return (InterfaceC2882tk) b(f(str), z);
    }

    public final long c(String str, long j) {
        return this.a.getLong(f(str), j);
    }

    public final boolean c(String str, boolean z) {
        return this.a.getBoolean(f(str), z);
    }
}
