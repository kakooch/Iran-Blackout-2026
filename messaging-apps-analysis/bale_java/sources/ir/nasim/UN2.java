package ir.nasim;

import ir.nasim.core.network.RpcException;

/* loaded from: classes5.dex */
public final class UN2 {
    public static final UN2 a = new UN2();

    private UN2() {
    }

    public static final String a(Throwable th, ZN2 zn2) {
        Integer num;
        AbstractC13042fc3.i(zn2, "groupType");
        int iIntValue = (!(th instanceof RpcException) || (num = (Integer) AbstractC14715iM2.a().get(((RpcException) th).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String())) == null) ? AbstractC12217eE5.default_error : num.intValue();
        String strA = AbstractC5969Lp4.a(C5721Ko.a.d().getString(iIntValue), zn2);
        AbstractC13042fc3.h(strA, "formatGroupType(...)");
        return strA;
    }
}
