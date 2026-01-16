package ir.nasim;

import ir.nasim.core.network.dns.model.DnsResolution;

/* renamed from: ir.nasim.eW1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12375eW1 {
    public static final DnsResolution a(DnsResolution dnsResolution, DnsResolution dnsResolution2) {
        if (dnsResolution == null && dnsResolution2 == null) {
            return null;
        }
        if (dnsResolution == null) {
            return dnsResolution2;
        }
        if (dnsResolution2 != null && AbstractC13042fc3.d(dnsResolution.getHost(), dnsResolution2.getHost())) {
            return DnsResolution.copy$default(dnsResolution, null, Math.min(dnsResolution.getTtlInMillis(), dnsResolution2.getTtlInMillis()), AbstractC15401jX0.j0(AbstractC15401jX0.R0(dnsResolution.getAddresses(), dnsResolution2.getAddresses())), dnsResolution.isVerified() && dnsResolution2.isVerified(), 1, null);
        }
        return dnsResolution;
    }
}
