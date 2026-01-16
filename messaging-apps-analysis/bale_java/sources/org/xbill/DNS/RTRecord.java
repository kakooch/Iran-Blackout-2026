package org.xbill.DNS;

/* loaded from: classes8.dex */
public class RTRecord extends U16NameBase {
    RTRecord() {
    }

    public Name getIntermediateHost() {
        return getNameField();
    }

    public int getPreference() {
        return getU16Field();
    }

    public RTRecord(Name name, int i, long j, int i2, Name name2) {
        super(name, 21, i, j, i2, "preference", name2, "intermediateHost");
    }
}
