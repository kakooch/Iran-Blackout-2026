package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;

/* loaded from: classes3.dex */
public abstract class K2 implements ModulePreferences {
    public final InterfaceC2882tk a;

    public K2(InterfaceC2882tk interfaceC2882tk) {
        this.a = interfaceC2882tk;
    }

    public abstract String a(String str);

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Yc) this.a).c(str, z);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final int getInt(String str, int i) {
        return ((Yc) this.a).c(str, i);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final long getLong(String str, long j) {
        return ((Yc) this.a).c(a(str), j);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final String getString(String str, String str2) {
        return ((Yc) this.a).c(a(str), str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putBoolean(String str, boolean z) {
        Yc yc = (Yc) this.a;
        ((AbstractC2685le) ((InterfaceC2882tk) yc.b(yc.f(a(str)), z))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putInt(String str, int i) {
        Yc yc = (Yc) this.a;
        ((AbstractC2685le) ((InterfaceC2882tk) yc.b(yc.f(str), i))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putLong(String str, long j) {
        Yc yc = (Yc) this.a;
        ((AbstractC2685le) ((InterfaceC2882tk) yc.b(yc.f(a(str)), j))).b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences
    public final void putString(String str, String str2) {
        Yc yc = (Yc) this.a;
        ((AbstractC2685le) ((InterfaceC2882tk) yc.b(yc.f(a(str)), str2))).b();
    }
}
