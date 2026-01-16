package android.gov.nist.javax.sip.header.ims;

import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class SecurityServer extends SecurityAgree implements SecurityServerHeader, InterfaceC5634Ke2 {
    public SecurityServer() {
        super("Security-Server");
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }
}
