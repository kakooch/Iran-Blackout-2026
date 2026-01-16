package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import java.util.List;

/* loaded from: classes3.dex */
public interface Ca extends InterfaceC2968xa, InterfaceC2803qc {
    void a(Activity activity);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void a(Location location);

    void a(AnrListener anrListener);

    void a(ExternalAttribution externalAttribution);

    void a(Cn cn);

    void a(EnumC2742o enumC2742o);

    @Override // io.appmetrica.analytics.impl.InterfaceC2968xa
    /* synthetic */ void a(String str);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void a(String str, String str2);

    void a(String str, boolean z);

    @Override // io.appmetrica.analytics.impl.InterfaceC2803qc
    /* synthetic */ void a(boolean z);

    void b(Activity activity);

    void b(String str);

    @Override // io.appmetrica.analytics.impl.InterfaceC2968xa
    /* synthetic */ void b(String str, String str2);

    @Override // io.appmetrica.analytics.impl.InterfaceC2968xa
    /* synthetic */ boolean b();

    void c();

    List<String> f();
}
