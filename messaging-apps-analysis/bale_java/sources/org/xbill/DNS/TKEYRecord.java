package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import java.time.Instant;
import java.util.Date;
import org.xbill.DNS.utils.base64;

/* loaded from: classes8.dex */
public class TKEYRecord extends Record {
    public static final int DELETE = 5;
    public static final int DIFFIEHELLMAN = 2;
    public static final int GSSAPI = 3;
    public static final int RESOLVERASSIGNED = 4;
    public static final int SERVERASSIGNED = 1;
    private Name alg;
    private int error;
    private byte[] key;
    private int mode;
    private byte[] other;
    private Instant timeExpire;
    private Instant timeInception;

    TKEYRecord() {
    }

    public Name getAlgorithm() {
        return this.alg;
    }

    public int getError() {
        return this.error;
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getMode() {
        return this.mode;
    }

    public byte[] getOther() {
        return this.other;
    }

    public Instant getTimeExpire() {
        return this.timeExpire;
    }

    public Instant getTimeInception() {
        return this.timeInception;
    }

    protected String modeString() {
        int i = this.mode;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? Integer.toString(i) : "DELETE" : "RESOLVERASSIGNED" : "GSSAPI" : "DIFFIEHELLMAN" : "SERVERASSIGNED";
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        throw tokenizer.exception("no text format defined for TKEY");
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        this.alg = new Name(dNSInput);
        this.timeInception = Instant.ofEpochSecond(dNSInput.readU32());
        this.timeExpire = Instant.ofEpochSecond(dNSInput.readU32());
        this.mode = dNSInput.readU16();
        this.error = dNSInput.readU16();
        int u16 = dNSInput.readU16();
        if (u16 > 0) {
            this.key = dNSInput.readByteArray(u16);
        } else {
            this.key = null;
        }
        int u162 = dNSInput.readU16();
        if (u162 > 0) {
            this.other = dNSInput.readByteArray(u162);
        } else {
            this.other = null;
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.alg);
        sb.append(Separators.SP);
        if (Options.multiline()) {
            sb.append("(\n\t");
        }
        sb.append(FormattedTime.format(this.timeInception));
        sb.append(Separators.SP);
        sb.append(FormattedTime.format(this.timeExpire));
        sb.append(Separators.SP);
        sb.append(modeString());
        sb.append(Separators.SP);
        sb.append(Rcode.TSIGstring(this.error));
        if (Options.multiline()) {
            sb.append(Separators.RETURN);
            byte[] bArr = this.key;
            if (bArr != null) {
                sb.append(base64.formatString(bArr, 64, Separators.HT, false));
                sb.append(Separators.RETURN);
            }
            byte[] bArr2 = this.other;
            if (bArr2 != null) {
                sb.append(base64.formatString(bArr2, 64, Separators.HT, false));
            }
            sb.append(" )");
        } else {
            sb.append(Separators.SP);
            byte[] bArr3 = this.key;
            if (bArr3 != null) {
                sb.append(base64.toString(bArr3));
                sb.append(Separators.SP);
            }
            byte[] bArr4 = this.other;
            if (bArr4 != null) {
                sb.append(base64.toString(bArr4));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.alg.toWire(dNSOutput, null, z);
        dNSOutput.writeU32(this.timeInception.getEpochSecond());
        dNSOutput.writeU32(this.timeExpire.getEpochSecond());
        dNSOutput.writeU16(this.mode);
        dNSOutput.writeU16(this.error);
        byte[] bArr = this.key;
        if (bArr != null) {
            dNSOutput.writeU16(bArr.length);
            dNSOutput.writeByteArray(this.key);
        } else {
            dNSOutput.writeU16(0);
        }
        byte[] bArr2 = this.other;
        if (bArr2 == null) {
            dNSOutput.writeU16(0);
        } else {
            dNSOutput.writeU16(bArr2.length);
            dNSOutput.writeByteArray(this.other);
        }
    }

    public TKEYRecord(Name name, int i, long j, Name name2, Instant instant, Instant instant2, int i2, int i3, byte[] bArr, byte[] bArr2) {
        super(name, 249, i, j);
        this.alg = Record.checkName(ParameterNamesIms.ALG, name2);
        this.timeInception = instant;
        this.timeExpire = instant2;
        this.mode = Record.checkU16("mode", i2);
        this.error = Record.checkU16("error", i3);
        this.key = bArr;
        this.other = bArr2;
    }

    @Deprecated
    public TKEYRecord(Name name, int i, long j, Name name2, Date date, Date date2, int i2, int i3, byte[] bArr, byte[] bArr2) {
        this(name, i, j, name2, date.toInstant(), date2.toInstant(), i2, i3, bArr, bArr2);
    }
}
