package android.gov.nist.javax.sip.header.ims;

import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class SecurityClient extends SecurityAgree implements SecurityClientHeader, InterfaceC5634Ke2 {
    public SecurityClient() {
        super("Security-Client");
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }
}
