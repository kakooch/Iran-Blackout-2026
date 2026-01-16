package ir.nasim;

import ir.nasim.core.network.RpcException;

/* loaded from: classes5.dex */
public final class QQ {
    public static final QQ a = new QQ();

    private QQ() {
    }

    public static final String a(Exception exc) {
        Integer num;
        int iIntValue = (!(exc instanceof RpcException) || (num = (Integer) MP.a().get(((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String())) == null) ? AbstractC12217eE5.default_error : num.intValue();
        String string = C5721Ko.a.d().getString(iIntValue);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }
}
