package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.GenericURI;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.InterfaceC9088Yl;
import java.text.ParseException;

/* loaded from: classes.dex */
public final class AlertInfo extends ParametersHeader implements InterfaceC9088Yl {
    private static final long serialVersionUID = 4159657362051508719L;
    protected String string;
    protected GenericURI uri;

    public AlertInfo() {
        super(SIPHeaderNames.ALERT_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.core.GenericObject
    public Object clone() {
        AlertInfo alertInfo = (AlertInfo) super.clone();
        GenericURI genericURI = this.uri;
        if (genericURI != null) {
            alertInfo.uri = (GenericURI) genericURI.clone();
        } else {
            String str = this.string;
            if (str != null) {
                alertInfo.string = str;
            }
        }
        return alertInfo;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        if (this.uri != null) {
            sb.append(Separators.LESS_THAN);
            sb.append(this.uri.encode());
            sb.append(Separators.GREATER_THAN);
        } else {
            String str = this.string;
            if (str != null) {
                sb.append(str);
            }
        }
        if (!this.parameters.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            sb.append(this.parameters.encode());
        }
        return sb;
    }

    public InterfaceC21815uA7 getAlertInfo() {
        GenericURI genericURI = this.uri;
        if (genericURI != null) {
            return genericURI;
        }
        try {
            return new GenericURI(this.string);
        } catch (ParseException unused) {
            return null;
        }
    }

    public void setAlertInfo(InterfaceC21815uA7 interfaceC21815uA7) {
        this.uri = (GenericURI) interfaceC21815uA7;
    }

    public void setAlertInfo(String str) {
        this.string = str;
    }
}
