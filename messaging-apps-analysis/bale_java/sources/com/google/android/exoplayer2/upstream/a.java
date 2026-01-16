package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC25209zu7;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public interface a extends InterfaceC18631oz1 {

    /* renamed from: com.google.android.exoplayer2.upstream.a$a, reason: collision with other inner class name */
    public interface InterfaceC0163a {
        a a();
    }

    long b(b bVar);

    void close();

    default Map d() {
        return Collections.emptyMap();
    }

    Uri getUri();

    void i(InterfaceC25209zu7 interfaceC25209zu7);
}
