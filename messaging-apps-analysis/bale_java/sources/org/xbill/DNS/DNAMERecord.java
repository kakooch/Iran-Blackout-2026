package org.xbill.DNS;

/* loaded from: classes8.dex */
public class DNAMERecord extends SingleNameBase {
    DNAMERecord() {
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public DNAMERecord(Name name, int i, long j, Name name2) {
        super(name, 39, i, j, name2, "alias");
    }
}
