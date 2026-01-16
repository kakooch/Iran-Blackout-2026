package io.livekit.android.room;

import android.content.Context;
import io.livekit.android.room.Room;
import ir.nasim.C11006ca3;
import ir.nasim.InterfaceC7720Sx5;

/* loaded from: classes3.dex */
public final class k implements Room.a {
    private final j a;

    k(j jVar) {
        this.a = jVar;
    }

    public static InterfaceC7720Sx5 b(j jVar) {
        return C11006ca3.a(new k(jVar));
    }

    @Override // io.livekit.android.room.Room.a
    public Room a(Context context) {
        return this.a.b(context);
    }
}
