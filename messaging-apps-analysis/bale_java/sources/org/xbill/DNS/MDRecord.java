package org.xbill.DNS;

/* loaded from: classes8.dex */
public class MDRecord extends SingleNameBase {
    MDRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getMailAgent() {
        return getSingleName();
    }

    public MDRecord(Name name, int i, long j, Name name2) {
        super(name, 3, i, j, name2, "mail agent");
    }
}
