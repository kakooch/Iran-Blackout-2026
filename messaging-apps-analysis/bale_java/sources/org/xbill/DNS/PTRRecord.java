package org.xbill.DNS;

/* loaded from: classes8.dex */
public class PTRRecord extends SingleCompressedNameBase {
    PTRRecord() {
    }

    public Name getTarget() {
        return getSingleName();
    }

    public PTRRecord(Name name, int i, long j, Name name2) {
        super(name, 12, i, j, name2, "target");
    }
}
