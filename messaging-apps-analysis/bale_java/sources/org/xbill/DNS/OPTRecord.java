package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import org.xbill.DNS.EDNSOption;

/* loaded from: classes8.dex */
public class OPTRecord extends Record {
    private List<EDNSOption> options;

    OPTRecord() {
    }

    @Override // org.xbill.DNS.Record
    public boolean equals(Object obj) {
        return super.equals(obj) && this.ttl == ((OPTRecord) obj).ttl;
    }

    public int getExtendedRcode() {
        return (int) (this.ttl >>> 24);
    }

    public int getFlags() {
        return (int) (this.ttl & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    public List<EDNSOption> getOptions() {
        List<EDNSOption> list = this.options;
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public int getPayloadSize() {
        return this.dclass;
    }

    public int getVersion() {
        return (int) ((this.ttl >>> 16) & 255);
    }

    @Override // org.xbill.DNS.Record
    public int hashCode() {
        int i = 0;
        for (byte b : toWireCanonical()) {
            i += (i << 3) + (b & 255);
        }
        return i;
    }

    void printPseudoSection(StringBuilder sb) {
        sb.append(";; OPT PSEUDOSECTION: \n; EDNS: version: ");
        sb.append(getVersion());
        sb.append("; flags: ");
        for (int i = 0; i < 16; i++) {
            if ((getFlags() & (1 << (15 - i))) != 0) {
                sb.append(ExtendedFlags.stringFromBit(i));
                sb.append(Separators.SP);
            }
        }
        sb.append("; udp: ");
        sb.append(getPayloadSize());
        List<EDNSOption> list = this.options;
        if (list != null) {
            for (EDNSOption eDNSOption : list) {
                sb.append("\n; ");
                sb.append(EDNSOption.Code.string(eDNSOption.getCode()));
                sb.append(": ");
                sb.append(eDNSOption.optionToString());
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        throw tokenizer.exception("no text format defined for OPT");
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        if (dNSInput.remaining() > 0) {
            this.options = new ArrayList();
        }
        while (dNSInput.remaining() > 0) {
            this.options.add(EDNSOption.fromWire(dNSInput));
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        List<EDNSOption> list = this.options;
        if (list != null) {
            sb.append(list);
            sb.append(Separators.SP);
        }
        sb.append(" ; payload ");
        sb.append(getPayloadSize());
        sb.append(", xrcode ");
        sb.append(getExtendedRcode());
        sb.append(", version ");
        sb.append(getVersion());
        sb.append(", flags ");
        sb.append(getFlags());
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        List<EDNSOption> list = this.options;
        if (list == null) {
            return;
        }
        Iterator<EDNSOption> it = list.iterator();
        while (it.hasNext()) {
            it.next().toWire(dNSOutput);
        }
    }

    @Override // org.xbill.DNS.Record
    public String toString() {
        return Name.root + "\t\t\t\t" + Type.string(this.type) + Separators.HT + rrToString();
    }

    public OPTRecord(int i, int i2, int i3, int i4, EDNSOption... eDNSOptionArr) {
        this(i, i2, i3, i4);
        if (eDNSOptionArr != null) {
            this.options = new ArrayList(Arrays.asList(eDNSOptionArr));
        }
    }

    public OPTRecord(int i, int i2, int i3, int i4, List<EDNSOption> list) {
        this(i, i2, i3, i4);
        if (list != null) {
            this.options = new ArrayList(list);
        }
    }

    public List<EDNSOption> getOptions(int i) {
        if (this.options == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (EDNSOption eDNSOption : this.options) {
            if (eDNSOption.getCode() == i) {
                arrayList.add(eDNSOption);
            }
        }
        return arrayList;
    }

    public OPTRecord(int i, int i2, int i3, int i4) {
        super(Name.root, 41, i, 0L);
        Record.checkU16("payloadSize", i);
        Record.checkU8("xrcode", i2);
        Record.checkU8(ParameterNames.VERSION, i3);
        Record.checkU16("flags", i4);
        this.ttl = (i2 << 24) + (i3 << 16) + i4;
    }

    public OPTRecord(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }
}
