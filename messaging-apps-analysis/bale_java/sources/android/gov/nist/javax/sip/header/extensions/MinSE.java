package android.gov.nist.javax.sip.header.extensions;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParametersHeader;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class MinSE extends ParametersHeader implements InterfaceC5634Ke2, MinSEHeader {
    public static final String NAME = "Min-SE";
    private static final long serialVersionUID = 3134344915465784267L;
    public int expires;

    public MinSE() {
        super("Min-SE");
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        sb.append(Integer.toString(this.expires));
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }

    public int getExpires() {
        return this.expires;
    }

    public void setExpires(int i) throws InvalidArgumentException {
        if (i >= 0) {
            this.expires = i;
            return;
        }
        throw new InvalidArgumentException("bad argument " + i);
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }
}
