package org.xbill.DNS;

import java.util.List;
import org.xbill.DNS.SVCBBase;

/* loaded from: classes8.dex */
public class SVCBRecord extends SVCBBase {
    SVCBRecord() {
    }

    public SVCBRecord(Name name, int i, long j, int i2, Name name2, List<SVCBBase.ParameterBase> list) {
        super(name, 64, i, j, i2, name2, list);
    }
}
