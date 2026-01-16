package ir.nasim;

import ir.nasim.AbstractC6718Or3;
import livekit.org.webrtc.PeerConnectionFactory;

/* renamed from: ir.nasim.z25, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24689z25 {
    private final PeerConnectionFactory a;
    private boolean b;

    public C24689z25(PeerConnectionFactory peerConnectionFactory) {
        AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
        this.a = peerConnectionFactory;
    }

    public final void a() {
        if (this.b) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Calling dispose multiple times on PeerConnectionFactory?", new Object[0]);
            return;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            throw new IllegalStateException("PeerConnectionFactory must be disposed on the RTC thread!");
        }
        this.b = true;
        this.a.dispose();
    }

    public final PeerConnectionFactory b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24689z25) && AbstractC13042fc3.d(this.a, ((C24689z25) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "PeerConnectionFactoryManager(peerConnectionFactory=" + this.a + ')';
    }
}
