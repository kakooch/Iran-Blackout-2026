package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.util.Optional;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public class CookieOption extends EDNSOption {
    private byte[] clientCookie;
    private byte[] serverCookie;

    CookieOption() {
        super(10);
    }

    public byte[] getClientCookie() {
        return this.clientCookie;
    }

    public Optional<byte[]> getServerCookie() {
        return Optional.ofNullable(this.serverCookie);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) throws WireParseException {
        int iRemaining = dNSInput.remaining();
        if (iRemaining < 8) {
            throw new WireParseException("invalid length of client cookie");
        }
        this.clientCookie = dNSInput.readByteArray(8);
        if (iRemaining > 8) {
            if (iRemaining < 16 || iRemaining > 40) {
                throw new WireParseException("invalid length of server cookie");
            }
            this.serverCookie = dNSInput.readByteArray();
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        if (this.serverCookie == null) {
            return base16.toString(this.clientCookie);
        }
        return base16.toString(this.clientCookie) + Separators.SP + base16.toString(this.serverCookie);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.clientCookie);
        byte[] bArr = this.serverCookie;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    public CookieOption(byte[] bArr) {
        this(bArr, null);
    }

    public CookieOption(byte[] bArr, byte[] bArr2) {
        int length;
        this();
        if (bArr != null) {
            if (bArr.length == 8) {
                this.clientCookie = bArr;
                if (bArr2 != null && ((length = bArr2.length) < 8 || length > 32)) {
                    throw new IllegalArgumentException("server cookie must consist of 8 to 32 bytes");
                }
                this.serverCookie = bArr2;
                return;
            }
            throw new IllegalArgumentException("client cookie must consist of eight bytes");
        }
        throw new IllegalArgumentException("client cookie must not be null");
    }
}
