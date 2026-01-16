package org.xbill.DNS.dnssec;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import org.xbill.DNS.DNSKEYRecord;
import org.xbill.DNS.DSRecord;
import org.xbill.DNS.Name;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;

/* loaded from: classes8.dex */
final class DefaultTrustAnchorStore implements TrustAnchorStore {
    private final Map<String, RRset> map = new HashMap();

    private String key(Name name, int i) {
        return TokenNames.T + i + Separators.SLASH + name.canonicalize();
    }

    private RRset lookup(String str) {
        return this.map.get(str);
    }

    @Override // org.xbill.DNS.dnssec.TrustAnchorStore
    public void clear() {
        this.map.clear();
    }

    @Override // org.xbill.DNS.dnssec.TrustAnchorStore
    public RRset find(Name name, int i) {
        while (name.labels() > 0) {
            RRset rRsetLookup = lookup(key(name, i));
            if (rRsetLookup != null) {
                return rRsetLookup;
            }
            name = new Name(name, 1);
        }
        return null;
    }

    @Override // org.xbill.DNS.dnssec.TrustAnchorStore
    public Collection<RRset> items() {
        return Collections.unmodifiableCollection(this.map.values());
    }

    @Override // org.xbill.DNS.dnssec.TrustAnchorStore
    public void store(final RRset rRset) {
        if (rRset.getType() != 43 && rRset.getType() != 48) {
            throw new IllegalArgumentException("Trust anchors can only be DS or DNSKEY records");
        }
        if (rRset.getType() == 48) {
            SRRset sRRset = new SRRset();
            Iterator<Record> it = rRset.rrs().iterator();
            while (it.hasNext()) {
                DNSKEYRecord dNSKEYRecord = (DNSKEYRecord) it.next();
                sRRset.addRR(new DSRecord(dNSKEYRecord.getName(), dNSKEYRecord.getDClass(), dNSKEYRecord.getTTL(), 4, dNSKEYRecord));
            }
            rRset = sRRset;
        }
        RRset rRsetPut = this.map.put(key(rRset.getName(), rRset.getDClass()), rRset);
        if (rRsetPut != null) {
            rRsetPut.rrs().forEach(new Consumer() { // from class: ir.nasim.kG1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    rRset.addRR((Record) obj);
                }
            });
        }
    }
}
