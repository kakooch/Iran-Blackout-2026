package ir.nasim;

import ir.nasim.core.network.RpcException;

/* loaded from: classes5.dex */
public final class XH2 {
    public static final XH2 a = new XH2();

    private XH2() {
    }

    public static final int a(Exception exc) {
        if (!(exc instanceof RpcException)) {
            return AbstractC12217eE5.default_error;
        }
        Integer num = (Integer) AbstractC15259jH2.a().get(((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String());
        return num != null ? num.intValue() : AbstractC12217eE5.default_error;
    }
}
