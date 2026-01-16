package ir.nasim;

import ir.nasim.core.network.dns.model.DnsResolution;

/* loaded from: classes5.dex */
public final class AU2 implements InterfaceC12984fW1 {
    private final C22580vU2 b;

    public AU2(C22580vU2 c22580vU2) {
        AbstractC13042fc3.i(c22580vU2, "hashEndpointStorage");
        this.b = c22580vU2;
    }

    @Override // ir.nasim.InterfaceC12984fW1
    public DnsResolution b(String str) {
        String strC;
        AbstractC13042fc3.i(str, "host");
        C20713sU2 c20713sU2 = (C20713sU2) this.b.e().get(str);
        if (c20713sU2 == null || (strC = c20713sU2.c()) == null) {
            return null;
        }
        DnsResolution dnsResolution = new DnsResolution(str, Long.MAX_VALUE, AbstractC9766aX0.e(strC), true);
        C19406qI3.a("DnsResolver", dnsResolution + " resolved from the hashes.", new Object[0]);
        return dnsResolution;
    }

    public AU2() {
        this(C22580vU2.c.a());
    }
}
