package org.xbill.DNS;

import java.util.List;

/* loaded from: classes8.dex */
public class SPFRecord extends TXTBase {
    SPFRecord() {
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStrings() {
        return super.getStrings();
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStringsAsByteArrays() {
        return super.getStringsAsByteArrays();
    }

    public SPFRecord(Name name, int i, long j, List<String> list) {
        super(name, 99, i, j, list);
    }

    public SPFRecord(Name name, int i, long j, String str) {
        super(name, 99, i, j, str);
    }
}
