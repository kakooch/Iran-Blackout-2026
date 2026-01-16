package android.gov.nist.javax.sip.header.ims;

import ir.nasim.InterfaceC5634Ke2;
import java.text.ParseException;

/* loaded from: classes.dex */
public class SecurityVerify extends SecurityAgree implements SecurityVerifyHeader, InterfaceC5634Ke2 {
    public SecurityVerify() {
        super("Security-Verify");
    }

    public void setValue(String str) throws ParseException {
        throw new ParseException(str, 0);
    }
}
