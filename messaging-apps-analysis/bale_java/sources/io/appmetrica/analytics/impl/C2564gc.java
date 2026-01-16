package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.ArrayList;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.gc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2564gc extends C2975xh implements Ca {
    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(Activity activity) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void b(Activity activity) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void c() {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final List<String> f() {
        return new ArrayList();
    }

    @Override // io.appmetrica.analytics.impl.C2975xh, io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
    }

    @Override // io.appmetrica.analytics.impl.C2975xh, io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void b(String str) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(AnrListener anrListener) {
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2968xa
    public final void b(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(ExternalAttribution externalAttribution) {
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2968xa
    public final boolean b() {
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(Cn cn) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(EnumC2742o enumC2742o) {
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2968xa
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Ca
    public final void a(String str, boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Ca, io.appmetrica.analytics.impl.InterfaceC2803qc
    public final void a(boolean z) {
    }
}
