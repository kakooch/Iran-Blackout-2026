package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.javax.sip.InvalidArgumentException;
import ir.nasim.Y38;
import java.text.ParseException;

/* loaded from: classes.dex */
public class Warning extends SIPHeader implements Y38 {
    private static final long serialVersionUID = -3433328864230783899L;
    protected String agent;
    protected int code;
    protected String text;

    public Warning() {
        super(SIPHeaderNames.WARNING);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        String str;
        if (this.text != null) {
            sb.append(Integer.toString(this.code));
            sb.append(Separators.SP);
            sb.append(this.agent);
            sb.append(Separators.SP);
            str = Separators.DOUBLE_QUOTE;
            sb.append(Separators.DOUBLE_QUOTE);
            sb.append(this.text);
        } else {
            sb.append(Integer.toString(this.code));
            sb.append(Separators.SP);
            str = this.agent;
        }
        sb.append(str);
        return sb;
    }

    public String getAgent() {
        return this.agent;
    }

    public int getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }

    public void setAgent(String str) {
        if (str == null) {
            throw new NullPointerException("the host parameter in the Warning header is null");
        }
        this.agent = str;
    }

    public void setCode(int i) throws InvalidArgumentException {
        if (i > 99 && i < 1000) {
            this.code = i;
            return;
        }
        throw new InvalidArgumentException("Code parameter in the Warning header is invalid: code=" + i);
    }

    public void setText(String str) throws ParseException {
        if (str == null) {
            throw new ParseException("The text parameter in the Warning header is null", 0);
        }
        this.text = str;
    }
}
