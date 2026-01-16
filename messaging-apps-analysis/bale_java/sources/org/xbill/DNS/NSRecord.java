package org.xbill.DNS;

/* loaded from: classes8.dex */
public class NSRecord extends SingleCompressedNameBase {
    NSRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public NSRecord(Name name, int i, long j, Name name2) {
        super(name, 2, i, j, name2, "target");
    }
}
