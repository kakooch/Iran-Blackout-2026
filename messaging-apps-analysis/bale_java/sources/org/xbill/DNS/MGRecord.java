package org.xbill.DNS;

/* loaded from: classes8.dex */
public class MGRecord extends SingleNameBase {
    MGRecord() {
    }

    public Name getMailbox() {
        return getSingleName();
    }

    public MGRecord(Name name, int i, long j, Name name2) {
        super(name, 8, i, j, name2, "mailbox");
    }
}
