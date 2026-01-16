package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Gc implements ModuleSelfReporter {
    public final C2523ej a = AbstractC2648k1.a();
    public final int b = 4;

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, Throwable th) {
        C2523ej c2523ej = this.a;
        c2523ej.getClass();
        c2523ej.a(new C2498dj(str, th));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str) {
        C2523ej c2523ej = this.a;
        ModuleEvent moduleEventBuild = ModuleEvent.newBuilder(this.b).withName(str).build();
        c2523ej.getClass();
        c2523ej.a(new Ti(moduleEventBuild));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportError(String str, String str2) {
        this.a.reportError(str, str2);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, Map<String, ? extends Object> map) {
        C2523ej c2523ej = this.a;
        ModuleEvent moduleEventBuild = ModuleEvent.newBuilder(this.b).withName(str).withAttributes(map).build();
        c2523ej.getClass();
        c2523ej.a(new Ti(moduleEventBuild));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(String str, String str2) {
        C2523ej c2523ej = this.a;
        ModuleEvent moduleEventBuild = ModuleEvent.newBuilder(this.b).withName(str).withValue(str2).build();
        c2523ej.getClass();
        c2523ej.a(new Ti(moduleEventBuild));
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter
    public final void reportEvent(int i, String str, String str2) {
        C2523ej c2523ej = this.a;
        ModuleEvent moduleEventBuild = ModuleEvent.newBuilder(i).withName(str).withValue(str2).build();
        c2523ej.getClass();
        c2523ej.a(new Ti(moduleEventBuild));
    }
}
