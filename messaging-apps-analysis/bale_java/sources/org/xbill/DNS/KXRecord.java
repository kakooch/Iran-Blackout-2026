package org.xbill.DNS;

/* loaded from: classes8.dex */
public class KXRecord extends U16NameBase {
    KXRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getNameField();
    }

    public int getPreference() {
        return getU16Field();
    }

    public Name getTarget() {
        return getNameField();
    }

    public KXRecord(Name name, int i, long j, int i2, Name name2) {
        super(name, 36, i, j, i2, "preference", name2, "target");
    }
}
