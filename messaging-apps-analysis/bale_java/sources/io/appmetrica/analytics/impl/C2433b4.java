package io.appmetrica.analytics.impl;

import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.XV4;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.b4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2433b4 extends Q5 {
    public HashMap q;
    public Wl r;
    public Ul s;
    public Ul t;
    public C2794q3 u;
    public Wl v;

    public C2433b4(PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
    }

    public static Q5 b(String str, String str2) {
        Q5 q5 = new Q5("", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 5376;
        q5.a(str, str2);
        return q5;
    }

    public static Q5 n() {
        Q5 q5 = new Q5("", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 5632;
        return q5;
    }

    public static Q5 o() {
        Q5 q5 = new Q5("", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 40961;
        return q5;
    }

    public final void a(String str, String str2, EnumC2408a4 enumC2408a4) {
        if (!StringUtils.equalsNullSafety(str, str2)) {
            this.q.put(enumC2408a4, Integer.valueOf(StringUtils.getUTF8Bytes(str).length - StringUtils.getUTF8Bytes(str2).length));
        } else {
            this.q.remove(enumC2408a4);
        }
        Iterator it = this.q.values().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next()).intValue();
        }
        this.g = iIntValue;
    }

    @Override // io.appmetrica.analytics.impl.Q5
    public final void c(String str) {
        Wl wl = this.v;
        wl.getClass();
        this.h = wl.a(str);
    }

    public final String d(String str) {
        Wl wl = this.r;
        wl.getClass();
        String strA = wl.a(str);
        a(str, strA, EnumC2408a4.NAME);
        return strA;
    }

    public final String e(String str) throws UnsupportedEncodingException {
        Ul ul = this.s;
        ul.getClass();
        String strA = ul.a(str);
        a(str, strA, EnumC2408a4.VALUE);
        return strA;
    }

    public final C2433b4 f(String str) throws UnsupportedEncodingException {
        Ul ul = this.t;
        ul.getClass();
        String strA = ul.a(str);
        a(str, strA, EnumC2408a4.VALUE);
        this.b = strA;
        return this;
    }

    public final HashMap<EnumC2408a4, Integer> p() {
        return this.q;
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setName(String str) {
        this.a = d(str);
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValue(String str) {
        this.b = e(str);
    }

    @Override // io.appmetrica.analytics.impl.Q5, io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setValueBytes(byte[] bArr) {
        a(bArr);
    }

    public C2433b4(String str, int i, PublicLogger publicLogger) {
        this("", str, i, publicLogger);
    }

    public C2433b4(String str, String str2, int i, PublicLogger publicLogger) {
        this(str, str2, i, 0, publicLogger);
    }

    public C2433b4(String str, String str2, int i, int i2, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        this.b = e(str);
        this.a = d(str2);
        setType(i);
        setCustomType(i2);
    }

    public final C2433b4 a(HashMap<EnumC2408a4, Integer> map) {
        this.q = map;
        return this;
    }

    public final void a(PublicLogger publicLogger) {
        this.r = new Wl(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, "event name", publicLogger);
        this.s = new Ul(245760, "event value", publicLogger);
        this.t = new Ul(1024000, "event extended value", publicLogger);
        this.u = new C2794q3(245760, "event value bytes", publicLogger);
        this.v = new Wl(200, "user profile id", publicLogger);
    }

    public C2433b4(byte[] bArr, String str, int i, PublicLogger publicLogger) {
        this.q = new HashMap();
        a(publicLogger);
        a(bArr);
        this.a = d(str);
        setType(i);
    }

    public final void a(byte[] bArr) {
        C2794q3 c2794q3 = this.u;
        c2794q3.getClass();
        byte[] bArrA = c2794q3.a(bArr);
        EnumC2408a4 enumC2408a4 = EnumC2408a4.VALUE;
        if (bArr.length != bArrA.length) {
            this.q.put(enumC2408a4, Integer.valueOf(bArr.length - bArrA.length));
        } else {
            this.q.remove(enumC2408a4);
        }
        Iterator it = this.q.values().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += ((Integer) it.next()).intValue();
        }
        this.g = iIntValue;
        super.setValueBytes(bArrA);
    }

    public static Q5 a(en enVar) {
        Q5 q5O = o();
        q5O.setValue(new String(Base64.encode(MessageNano.toByteArray(enVar), 0)));
        return q5O;
    }

    public static C2433b4 a(PublicLogger publicLogger, C2472ci c2472ci) {
        int length;
        C2433b4 c2433b4 = new C2433b4(publicLogger);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        c2433b4.d = 40976;
        C2422ai c2422ai = new C2422ai();
        c2422ai.b = c2472ci.a.currency.getCurrencyCode().getBytes();
        c2422ai.f = c2472ci.a.priceMicros;
        c2422ai.c = StringUtils.stringToBytesForProtobuf(new Wl(200, "revenue productID", c2472ci.e).a(c2472ci.a.productID));
        c2422ai.a = ((Integer) WrapUtils.getOrDefault(c2472ci.a.quantity, 1)).intValue();
        Ul ul = c2472ci.b;
        String str = c2472ci.a.payload;
        ul.getClass();
        c2422ai.d = StringUtils.stringToBytesForProtobuf(ul.a(str));
        if (hn.a(c2472ci.a.receipt)) {
            Vh vh = new Vh();
            String str2 = (String) c2472ci.c.a(c2472ci.a.receipt.data);
            length = true ^ StringUtils.equalsNullSafety(c2472ci.a.receipt.data, str2) ? c2472ci.a.receipt.data.length() : 0;
            String str3 = (String) c2472ci.d.a(c2472ci.a.receipt.signature);
            vh.a = StringUtils.stringToBytesForProtobuf(str2);
            vh.b = StringUtils.stringToBytesForProtobuf(str3);
            c2422ai.e = vh;
        } else {
            length = 0;
        }
        Pair pair = new Pair(MessageNano.toByteArray(c2422ai), Integer.valueOf(length));
        c2433b4.b = c2433b4.e(new String(Base64.encode((byte[]) pair.first, 0)));
        c2433b4.g = ((Integer) pair.second).intValue();
        return c2433b4;
    }

    public static C2433b4 a(PublicLogger publicLogger, B b) {
        C2433b4 c2433b4 = new C2433b4(publicLogger);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        c2433b4.d = 40977;
        XV4 xv4A = b.a();
        c2433b4.b = c2433b4.e(new String(Base64.encode((byte[]) xv4A.e(), 0)));
        c2433b4.g = ((Integer) xv4A.f()).intValue();
        return c2433b4;
    }
}
