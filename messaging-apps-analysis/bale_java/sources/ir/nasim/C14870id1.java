package ir.nasim;

import java.util.List;
import livekit.org.webrtc.PeerConnection;

/* renamed from: ir.nasim.id1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14870id1 {
    private final boolean a;
    private final List b;
    private final PeerConnection.RTCConfiguration c;
    private final boolean d;
    private final boolean e;
    private final EnumC6275Mx5 f;
    private boolean g;
    private String h;

    public C14870id1(boolean z, List list, PeerConnection.RTCConfiguration rTCConfiguration, boolean z2, boolean z3, EnumC6275Mx5 enumC6275Mx5) {
        AbstractC13042fc3.i(enumC6275Mx5, "protocolVersion");
        this.a = z;
        this.b = list;
        this.c = rTCConfiguration;
        this.d = z2;
        this.e = z3;
        this.f = enumC6275Mx5;
    }

    public static /* synthetic */ C14870id1 b(C14870id1 c14870id1, boolean z, List list, PeerConnection.RTCConfiguration rTCConfiguration, boolean z2, boolean z3, EnumC6275Mx5 enumC6275Mx5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c14870id1.a;
        }
        if ((i & 2) != 0) {
            list = c14870id1.b;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            rTCConfiguration = c14870id1.c;
        }
        PeerConnection.RTCConfiguration rTCConfiguration2 = rTCConfiguration;
        if ((i & 8) != 0) {
            z2 = c14870id1.d;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = c14870id1.e;
        }
        boolean z5 = z3;
        if ((i & 32) != 0) {
            enumC6275Mx5 = c14870id1.f;
        }
        return c14870id1.a(z, list2, rTCConfiguration2, z4, z5, enumC6275Mx5);
    }

    public final C14870id1 a(boolean z, List list, PeerConnection.RTCConfiguration rTCConfiguration, boolean z2, boolean z3, EnumC6275Mx5 enumC6275Mx5) {
        AbstractC13042fc3.i(enumC6275Mx5, "protocolVersion");
        return new C14870id1(z, list, rTCConfiguration, z2, z3, enumC6275Mx5);
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.a;
    }

    public final List e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14870id1)) {
            return false;
        }
        C14870id1 c14870id1 = (C14870id1) obj;
        return this.a == c14870id1.a && AbstractC13042fc3.d(this.b, c14870id1.b) && AbstractC13042fc3.d(this.c, c14870id1.c) && this.d == c14870id1.d && this.e == c14870id1.e && this.f == c14870id1.f;
    }

    public final String f() {
        return this.h;
    }

    public final EnumC6275Mx5 g() {
        return this.f;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        List list = this.b;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        PeerConnection.RTCConfiguration rTCConfiguration = this.c;
        return ((((((iHashCode2 + (rTCConfiguration != null ? rTCConfiguration.hashCode() : 0)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public final PeerConnection.RTCConfiguration i() {
        return this.c;
    }

    public final boolean j() {
        return this.e;
    }

    public final void k(String str) {
        this.h = str;
    }

    public final void l(boolean z) {
        this.g = z;
    }

    public String toString() {
        return "ConnectOptions(autoSubscribe=" + this.a + ", iceServers=" + this.b + ", rtcConfig=" + this.c + ", audio=" + this.d + ", video=" + this.e + ", protocolVersion=" + this.f + ')';
    }

    public /* synthetic */ C14870id1(boolean z, List list, PeerConnection.RTCConfiguration rTCConfiguration, boolean z2, boolean z3, EnumC6275Mx5 enumC6275Mx5, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : list, (i & 4) == 0 ? rTCConfiguration : null, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? EnumC6275Mx5.n : enumC6275Mx5);
    }
}
