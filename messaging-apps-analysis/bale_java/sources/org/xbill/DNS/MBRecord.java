package org.xbill.DNS;

/* loaded from: classes8.dex */
public class MBRecord extends SingleNameBase {
    MBRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getMailbox() {
        return getSingleName();
    }

    public MBRecord(Name name, int i, long j, Name name2) {
        super(name, 7, i, j, name2, "mailbox");
    }
}
