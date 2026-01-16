package android.gov.nist.javax.sip;

import android.gov.nist.core.net.AddressResolver;
import android.gov.nist.javax.sip.stack.HopImpl;
import android.gov.nist.javax.sip.stack.MessageProcessor;
import ir.nasim.FY2;

/* loaded from: classes.dex */
public class DefaultAddressResolver implements AddressResolver {
    @Override // android.gov.nist.core.net.AddressResolver
    public FY2 resolveAddress(FY2 fy2) {
        return fy2.getPort() != -1 ? fy2 : new HopImpl(fy2.getHost(), MessageProcessor.getDefaultPort(fy2.getTransport()), fy2.getTransport());
    }
}
