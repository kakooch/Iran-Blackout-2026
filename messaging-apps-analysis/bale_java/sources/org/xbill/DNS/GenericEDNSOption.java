package org.xbill.DNS;

import android.gov.nist.core.Separators;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public class GenericEDNSOption extends EDNSOption {
    private byte[] data;

    GenericEDNSOption(int i) {
        super(i);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        return Separators.LESS_THAN + base16.toString(this.data) + Separators.GREATER_THAN;
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.data);
    }

    public GenericEDNSOption(int i, byte[] bArr) {
        super(i);
        this.data = Record.checkByteArrayLength("option data", bArr, 65535);
    }
}
