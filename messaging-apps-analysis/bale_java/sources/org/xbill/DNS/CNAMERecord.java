package org.xbill.DNS;

/* loaded from: classes8.dex */
public class CNAMERecord extends SingleCompressedNameBase {
    CNAMERecord() {
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public CNAMERecord(Name name, int i, long j, Name name2) {
        super(name, 5, i, j, name2, "target");
    }
}
