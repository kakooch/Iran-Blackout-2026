package io.livekit.android.room.participant;

import io.livekit.android.room.participant.d;
import ir.nasim.C11006ca3;
import ir.nasim.C23116wN5;
import ir.nasim.InterfaceC7720Sx5;
import livekit.LivekitModels$ParticipantInfo;

/* loaded from: classes3.dex */
public final class e implements d.a {
    private final C23116wN5 a;

    e(C23116wN5 c23116wN5) {
        this.a = c23116wN5;
    }

    public static InterfaceC7720Sx5 b(C23116wN5 c23116wN5) {
        return C11006ca3.a(new e(c23116wN5));
    }

    @Override // io.livekit.android.room.participant.d.a
    public d a(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        return this.a.b(livekitModels$ParticipantInfo);
    }
}
