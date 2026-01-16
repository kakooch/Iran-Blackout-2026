package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.C12275eL0;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/* loaded from: classes3.dex */
public final class B {
    public final AdRevenue a;
    public final boolean b;
    public final Wl c;
    public final Ul d;

    public B(AdRevenue adRevenue, boolean z, PublicLogger publicLogger) {
        this.a = adRevenue;
        this.b = z;
        this.c = new Wl(100, "ad revenue strings", publicLogger);
        this.d = new Ul(30720, "ad revenue payload", publicLogger);
    }

    public final XV4 a() {
        C2861t c2861t = new C2861t();
        int length = 0;
        for (XV4 xv4 : AbstractC10360bX0.p(AbstractC4616Fw7.a(this.a.adNetwork, new C2885u(c2861t)), AbstractC4616Fw7.a(this.a.adPlacementId, new C2909v(c2861t)), AbstractC4616Fw7.a(this.a.adPlacementName, new C2933w(c2861t)), AbstractC4616Fw7.a(this.a.adUnitId, new C2957x(c2861t)), AbstractC4616Fw7.a(this.a.adUnitName, new C2981y(c2861t)), AbstractC4616Fw7.a(this.a.precision, new C3005z(c2861t)), AbstractC4616Fw7.a(this.a.currency.getCurrencyCode(), new A(c2861t)))) {
            String str = (String) xv4.e();
            UA2 ua2 = (UA2) xv4.f();
            Wl wl = this.c;
            wl.getClass();
            String strA = wl.a(str);
            byte[] bArrStringToBytesForProtobuf = StringUtils.stringToBytesForProtobuf(str);
            byte[] bArrStringToBytesForProtobuf2 = StringUtils.stringToBytesForProtobuf(strA);
            ua2.invoke(bArrStringToBytesForProtobuf2);
            length += bArrStringToBytesForProtobuf.length - bArrStringToBytesForProtobuf2.length;
        }
        Integer num = (Integer) C.a.get(this.a.adType);
        c2861t.d = num != null ? num.intValue() : 0;
        C2837s c2837s = new C2837s();
        BigDecimal bigDecimal = this.a.adRevenue;
        BigInteger bigInteger = AbstractC2917v7.a;
        int i = -bigDecimal.scale();
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        while (true) {
            if (bigIntegerUnscaledValue.compareTo(AbstractC2917v7.a) <= 0 && bigIntegerUnscaledValue.compareTo(AbstractC2917v7.b) >= 0) {
                break;
            }
            bigIntegerUnscaledValue = bigIntegerUnscaledValue.divide(BigInteger.TEN);
            i++;
        }
        XV4 xv4A = AbstractC4616Fw7.a(Long.valueOf(bigIntegerUnscaledValue.longValue()), Integer.valueOf(i));
        long jLongValue = ((Number) xv4A.e()).longValue();
        int iIntValue = ((Number) xv4A.f()).intValue();
        c2837s.a = jLongValue;
        c2837s.b = iIntValue;
        c2861t.b = c2837s;
        Map<String, String> map = this.a.payload;
        if (map != null) {
            String strB = Ya.b(map);
            Ul ul = this.d;
            ul.getClass();
            byte[] bArrStringToBytesForProtobuf3 = StringUtils.stringToBytesForProtobuf(ul.a(strB));
            c2861t.k = bArrStringToBytesForProtobuf3;
            length += StringUtils.stringToBytesForProtobuf(strB).length - bArrStringToBytesForProtobuf3.length;
        }
        if (this.b) {
            c2861t.a = "autocollected".getBytes(C12275eL0.b);
        }
        return AbstractC4616Fw7.a(MessageNano.toByteArray(c2861t), Integer.valueOf(length));
    }
}
