package org.xbill.DNS;

/* loaded from: classes8.dex */
public class NSAP_PTRRecord extends SingleNameBase {
    NSAP_PTRRecord() {
    }

    public Name getTarget() {
        return getSingleName();
    }

    public NSAP_PTRRecord(Name name, int i, long j, Name name2) {
        super(name, 23, i, j, name2, "target");
    }
}
