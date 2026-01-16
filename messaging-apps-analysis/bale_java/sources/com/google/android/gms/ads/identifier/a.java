package com.google.android.gms.ads.identifier;

import android.net.Uri;
import ir.nasim.AbstractC11294cl8;
import java.util.Map;

/* loaded from: classes3.dex */
final class a extends Thread {
    final /* synthetic */ Map a;

    a(AdvertisingIdClient advertisingIdClient, Map map) {
        this.a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Map map = this.a;
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        AbstractC11294cl8.a(builderBuildUpon.build().toString());
    }
}
