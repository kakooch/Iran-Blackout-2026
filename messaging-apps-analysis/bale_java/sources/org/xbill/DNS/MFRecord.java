package org.xbill.DNS;

/* loaded from: classes8.dex */
public class MFRecord extends SingleNameBase {
    MFRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getMailAgent() {
        return getSingleName();
    }

    public MFRecord(Name name, int i, long j, Name name2) {
        super(name, 4, i, j, name2, "mail agent");
    }
}
