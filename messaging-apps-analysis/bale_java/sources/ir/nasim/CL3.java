package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class CL3 extends DL3 {
    public CL3(C21193tG5 c21193tG5, DL3 dl3, String str) {
        super(c21193tG5, dl3, str);
    }

    private StringBuffer h(StringBuffer stringBuffer, DL3 dl3) {
        if (dl3.c() != null) {
            h(stringBuffer, dl3.c());
            stringBuffer.append(Separators.SLASH);
        }
        stringBuffer.append(dl3.e());
        return stringBuffer;
    }

    public void A(int i) {
        int i2 = 0;
        while (i2 < i) {
            int iSkipBytes = this.d.skipBytes(i - i2);
            if (iSkipBytes <= 0) {
                throw new EOFException();
            }
            i2 += iSkipBytes;
        }
    }

    public long i() {
        return ((C21193tG5) b()).a() + ((C21193tG5) b()).b();
    }

    public long j() {
        return c().d() - d();
    }

    public String k() {
        return h(new StringBuffer(), this).toString();
    }

    public long l() {
        return ((C21193tG5) b()).b();
    }

    public boolean m() {
        return (a() != null ? a().l() : 0L) < l();
    }

    public CL3 n(String str) throws IOException {
        while (l() > 0) {
            CL3 cl3F = f();
            if (cl3F.e().matches(str)) {
                return cl3F;
            }
        }
        throw new IOException("atom type mismatch, not found: " + str);
    }

    public boolean o() {
        return this.d.readBoolean();
    }

    public byte p() {
        return this.d.readByte();
    }

    public byte[] q() {
        return r((int) l());
    }

    public byte[] r(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.d.readFully(bArr);
        return bArr;
    }

    public int s() {
        return this.d.readInt();
    }

    public BigDecimal t() {
        return new BigDecimal(String.valueOf((int) this.d.readShort()) + "" + String.valueOf(this.d.readUnsignedShort()));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        h(stringBuffer, this);
        stringBuffer.append("[off=");
        stringBuffer.append(j());
        stringBuffer.append(",pos=");
        stringBuffer.append(d());
        stringBuffer.append(",len=");
        stringBuffer.append(i());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public long u() {
        return this.d.readLong();
    }

    public short v() {
        return this.d.readShort();
    }

    public BigDecimal w() {
        return new BigDecimal(String.valueOf((int) this.d.readByte()) + "" + String.valueOf(this.d.readUnsignedByte()));
    }

    public String x(int i, String str) {
        String str2 = new String(r(i), str);
        int iIndexOf = str2.indexOf(0);
        return iIndexOf < 0 ? str2 : str2.substring(0, iIndexOf);
    }

    public String y(String str) {
        return x((int) l(), str);
    }

    public void z() throws EOFException {
        while (l() > 0) {
            if (((C21193tG5) b()).skip(l()) == 0) {
                throw new EOFException("Cannot skip atom");
            }
        }
    }
}
