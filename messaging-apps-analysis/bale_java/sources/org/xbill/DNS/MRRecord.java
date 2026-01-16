package org.xbill.DNS;

/* loaded from: classes8.dex */
public class MRRecord extends SingleNameBase {
    MRRecord() {
    }

    public Name getNewName() {
        return getSingleName();
    }

    public MRRecord(Name name, int i, long j, Name name2) {
        super(name, 9, i, j, name2, "new name");
    }
}
