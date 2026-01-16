package io.appmetrica.analytics.impl;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Q5 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<Q5> CREATOR = new P5();
    protected String a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public X9 k;
    public EnumC2585h9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public Q5() {
        this("", 0);
    }

    public final void a(String str, String str2) {
        if (this.f == null) {
            this.f = new Pair(str, str2);
        }
    }

    public final Pair<String, String> b() {
        return this.f;
    }

    public final void c(Bundle bundle) {
        this.m = bundle;
    }

    public final long d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long e() {
        return this.j;
    }

    public final String f() {
        return this.c;
    }

    public final X9 g() {
        return this.k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getBytesTruncated() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getCustomType() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final Map<String, byte[]> getExtras() {
        return this.p;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final String getName() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getType() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final String getValue() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final byte[] getValueBytes() {
        String str = this.b;
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public final Integer h() {
        return this.o;
    }

    public final Bundle i() {
        return this.m;
    }

    public final String j() {
        return this.h;
    }

    public final EnumC2585h9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.a == null;
    }

    public final boolean m() {
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        return -1 == this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setBytesTruncated(int i) {
        this.g = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setCustomType(int i) {
        this.e = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setExtras(Map<String, byte[]> map) {
        this.p = map;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setName(String str) {
        this.a = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setType(int i) {
        this.d = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setValue(String str) {
        this.b = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setValueBytes(byte[] bArr) {
        this.b = bArr == null ? null : new String(Base64.encode(bArr, 0));
    }

    public final String toString() {
        Locale locale = Locale.US;
        String str = this.a;
        String str2 = Ta.a(this.d).b;
        String strSubstring = this.b;
        if (strSubstring == null) {
            strSubstring = null;
        } else if (strSubstring.length() > 500) {
            strSubstring = strSubstring.substring(0, SIPTransactionStack.BASE_TIMER_INTERVAL);
        }
        return String.format(locale, "[event: %s, type: %s, value: %s]", str, str2, strSubstring);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("CounterReport.Event", this.a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.a);
        Bundle bundle2 = this.m;
        if (bundle2 != null) {
            bundle.putParcelable("CounterReport.Payload", bundle2);
        }
        String str = this.c;
        if (str != null) {
            bundle.putString("CounterReport.Environment", str);
        }
        Pair pair = this.f;
        if (pair != null) {
            bundle.putString("CounterReport.AppEnvironmentDiffKey", (String) pair.first);
            bundle.putString("CounterReport.AppEnvironmentDiffValue", (String) pair.second);
        }
        bundle.putLong("CounterReport.CreationElapsedRealtime", this.i);
        bundle.putLong("CounterReport.CreationTimestamp", this.j);
        EnumC2585h9 enumC2585h9 = this.l;
        if (enumC2585h9 != null) {
            bundle.putInt("CounterReport.Source", enumC2585h9.a);
        }
        Boolean bool = this.n;
        if (bool != null) {
            bundle.putBoolean("CounterReport.AttributionIdChanged", bool.booleanValue());
        }
        Integer num = this.o;
        if (num != null) {
            bundle.putInt("CounterReport.OpenId", num.intValue());
        }
        bundle.putBundle("CounterReport.Extras", CollectionUtils.mapToBundle(this.p));
        parcel.writeBundle(bundle);
    }

    public Q5(String str, int i) {
        this("", str, i);
    }

    public static Q5 e(Q5 q5) {
        return a(q5, Ta.EVENT_TYPE_APP_UPDATE);
    }

    public final void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public final Bundle d(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("CounterReport.Object", this);
        return bundle;
    }

    public Q5(String str, String str2, int i) {
        this(str, str2, i, new SystemTimeProvider());
    }

    public final void a(long j) {
        this.i = j;
    }

    public final void b(long j) {
        this.j = j;
    }

    public final Boolean c() {
        return this.n;
    }

    public Q5(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = X9.UNKNOWN;
        this.p = new HashMap();
        this.a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static Q5 b(Bundle bundle) {
        if (bundle != null) {
            try {
                Q5 q5 = (Q5) bundle.getParcelable("CounterReport.Object");
                if (q5 != null) {
                    return q5;
                }
            } catch (Throwable unused) {
                return new Q5("", 0);
            }
        }
        return new Q5("", 0);
    }

    public static Q5 c(Q5 q5) {
        return a(q5, Ta.EVENT_TYPE_INIT);
    }

    public static Q5 d(Q5 q5) {
        Q5 q52 = new Q5("", 0);
        q52.j = q5.j;
        q52.i = q5.i;
        q52.f = q5.f;
        q52.c = q5.c;
        q52.m = q5.m;
        q52.p = q5.p;
        q52.h = q5.h;
        return q52;
    }

    public final void a(X9 x9) {
        this.k = x9;
    }

    public final void a(EnumC2585h9 enumC2585h9) {
        this.l = enumC2585h9;
    }

    public final void a(Boolean bool) {
        this.n = bool;
    }

    public final void a(Integer num) {
        this.o = num;
    }

    public static Pair a(Bundle bundle) {
        if (bundle.containsKey("CounterReport.AppEnvironmentDiffKey") && bundle.containsKey("CounterReport.AppEnvironmentDiffValue")) {
            return new Pair(bundle.getString("CounterReport.AppEnvironmentDiffKey"), bundle.getString("CounterReport.AppEnvironmentDiffValue"));
        }
        return null;
    }

    public static Q5 b(Q5 q5) {
        return a(q5, Ta.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static Q5 a(Q5 q5, Ta ta) {
        Q5 q5D = d(q5);
        q5D.d = ta.a;
        return q5D;
    }

    public static Q5 a(Q5 q5) {
        return a(q5, Ta.EVENT_TYPE_ALIVE);
    }

    public static Q5 a(Q5 q5, G9 g9) {
        Q5 q5A = a(q5, Ta.EVENT_TYPE_START);
        q5A.setValueBytes(MessageNano.toByteArray(new C2656k9().fromModel(new C2632j9((String) g9.a.a()))));
        q5A.j = q5.j;
        q5A.i = q5.i;
        return q5A;
    }

    public static Q5 a(Q5 q5, Collection<PermissionState> collection, E2 e2, C2481d2 c2481d2, List<String> list) {
        String string;
        String str;
        Q5 q5D = d(q5);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (e2 != null) {
                jSONObject.put("background_restricted", e2.b);
                D2 d2 = e2.a;
                c2481d2.getClass();
                if (d2 != null) {
                    int iOrdinal = d2.ordinal();
                    if (iOrdinal == 0) {
                        str = "ACTIVE";
                    } else if (iOrdinal == 1) {
                        str = "WORKING_SET";
                    } else if (iOrdinal == 2) {
                        str = "FREQUENT";
                    } else if (iOrdinal == 3) {
                        str = "RARE";
                    } else if (iOrdinal == 4) {
                        str = "RESTRICTED";
                    }
                    jSONObject.put("app_standby_bucket", str);
                }
                str = null;
                jSONObject.put("app_standby_bucket", str);
            }
            string = new JSONObject().put("permissions", jSONArray).put("background_restrictions", jSONObject).put("available_providers", new JSONArray((Collection) list)).toString();
        } catch (Throwable unused) {
            string = "";
        }
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5D.d = 12288;
        q5D.setValue(string);
        return q5D;
    }

    public static Q5 a(Q5 q5, String str) {
        Q5 q5D = d(q5);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5D.d = 12289;
        q5D.setValue(str);
        return q5D;
    }

    public static Q5 a() {
        Q5 q5 = new Q5("", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 16384;
        return q5;
    }

    public static Q5 a(Se se) {
        String currencyCode = "";
        int i = 0;
        Q5 q5 = new Q5("", "", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 40976;
        ProductInfo productInfo = se.a;
        C2422ai c2422ai = new C2422ai();
        c2422ai.a = productInfo.quantity;
        c2422ai.f = productInfo.priceMicros;
        try {
            currencyCode = Currency.getInstance(productInfo.priceCurrency).getCurrencyCode();
        } catch (Throwable unused) {
        }
        c2422ai.b = currencyCode.getBytes();
        c2422ai.c = productInfo.sku.getBytes();
        Vh vh = new Vh();
        vh.a = productInfo.purchaseOriginalJson.getBytes();
        vh.b = productInfo.signature.getBytes();
        c2422ai.e = vh;
        c2422ai.g = true;
        c2422ai.h = 1;
        c2422ai.i = Re.a[productInfo.type.ordinal()] != 2 ? 1 : 2;
        Zh zh = new Zh();
        zh.a = productInfo.purchaseToken.getBytes();
        zh.b = TimeUnit.MILLISECONDS.toSeconds(productInfo.purchaseTime);
        c2422ai.j = zh;
        if (productInfo.type == ProductType.SUBS) {
            Yh yh = new Yh();
            yh.a = productInfo.autoRenewing;
            Period period = productInfo.subscriptionPeriod;
            if (period != null) {
                Xh xh = new Xh();
                xh.a = period.number;
                int i2 = Re.b[period.timeUnit.ordinal()];
                xh.b = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 4 : 3 : 2 : 1;
                yh.b = xh;
            }
            Wh wh = new Wh();
            wh.a = productInfo.introductoryPriceMicros;
            Period period2 = productInfo.introductoryPricePeriod;
            if (period2 != null) {
                Xh xh2 = new Xh();
                xh2.a = period2.number;
                int i3 = Re.b[period2.timeUnit.ordinal()];
                if (i3 == 1) {
                    i = 1;
                } else if (i3 == 2) {
                    i = 2;
                } else if (i3 == 3) {
                    i = 3;
                } else if (i3 == 4) {
                    i = 4;
                }
                xh2.b = i;
                wh.b = xh2;
            }
            wh.c = productInfo.introductoryPriceCycles;
            yh.c = wh;
            c2422ai.k = yh;
        }
        q5.setValueBytes(MessageNano.toByteArray(c2422ai));
        return q5;
    }

    public static Q5 a(String str) {
        Q5 q5 = new Q5("", 0);
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        q5.d = 12320;
        q5.b = str;
        q5.l = EnumC2585h9.JS;
        return q5;
    }
}
