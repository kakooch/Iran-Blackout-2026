package io.livekit.android.room;

import io.livekit.android.room.h;
import ir.nasim.C11006ca3;
import ir.nasim.C24287yM5;
import ir.nasim.InterfaceC7720Sx5;
import java.net.URI;

/* loaded from: classes3.dex */
public final class i implements h.a {
    private final C24287yM5 a;

    i(C24287yM5 c24287yM5) {
        this.a = c24287yM5;
    }

    public static InterfaceC7720Sx5 b(C24287yM5 c24287yM5) {
        return C11006ca3.a(new i(c24287yM5));
    }

    @Override // io.livekit.android.room.h.a
    public h a(URI uri, String str) {
        return this.a.b(uri, str);
    }
}
