package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.cct.d;
import com.google.firebase.encoders.EncodingException;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AI3;
import ir.nasim.AbstractC18065o16;
import ir.nasim.AbstractC21883uI3;
import ir.nasim.AbstractC21997uV0;
import ir.nasim.AbstractC22662vd0;
import ir.nasim.AbstractC7747Ta2;
import ir.nasim.AbstractC7863Tn;
import ir.nasim.AbstractC7895Tq4;
import ir.nasim.BI3;
import ir.nasim.C11515d82;
import ir.nasim.EnumC23479wz5;
import ir.nasim.InterfaceC12187eB2;
import ir.nasim.InterfaceC22910w16;
import ir.nasim.InterfaceC5558Jv7;
import ir.nasim.InterfaceC8198Uy1;
import ir.nasim.QV0;
import ir.nasim.SI3;
import ir.nasim.X72;
import ir.nasim.YV;
import ir.nasim.ZV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
final class d implements InterfaceC5558Jv7 {
    private final InterfaceC8198Uy1 a;
    private final ConnectivityManager b;
    private final Context c;
    final URL d;
    private final QV0 e;
    private final QV0 f;
    private final int g;

    static final class a {
        final URL a;
        final AbstractC22662vd0 b;
        final String c;

        a(URL url, AbstractC22662vd0 abstractC22662vd0, String str) {
            this.a = url;
            this.b = abstractC22662vd0;
            this.c = str;
        }

        a a(URL url) {
            return new a(url, this.b, this.c);
        }
    }

    static final class b {
        final int a;
        final URL b;
        final long c;

        b(int i, URL url, long j) {
            this.a = i;
            this.b = url;
            this.c = j;
        }
    }

    d(Context context, QV0 qv0, QV0 qv02, int i) {
        this.a = AbstractC22662vd0.b();
        this.c = context;
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = n(com.google.android.datatransport.cct.a.c);
        this.e = qv02;
        this.f = qv0;
        this.g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e(a aVar) throws IOException {
        SI3.f("CctTransportBackend", "Making request to: %s", aVar.a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty(SIPHeaderNames.USER_AGENT, String.format("datatransport/%s android/", "3.1.8"));
        httpURLConnection.setRequestProperty(SIPHeaderNames.CONTENT_ENCODING, "gzip");
        httpURLConnection.setRequestProperty(SIPHeaderNames.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty(SIPHeaderNames.ACCEPT_ENCODING, "gzip");
        String str = aVar.c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.a.a(aVar.b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    SI3.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    SI3.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField(SIPHeaderNames.CONTENT_TYPE));
                    SI3.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField(SIPHeaderNames.CONTENT_ENCODING));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM = m(inputStream, httpURLConnection.getHeaderField(SIPHeaderNames.CONTENT_ENCODING));
                        try {
                            b bVar = new b(responseCode, null, BI3.b(new BufferedReader(new InputStreamReader(inputStreamM))).c());
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e) {
            e = e;
            SI3.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (ConnectException e2) {
            e = e2;
            SI3.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(SIPTransactionStack.BASE_TIMER_INTERVAL, null, 0L);
        } catch (UnknownHostException e3) {
            e = e3;
            SI3.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(SIPTransactionStack.BASE_TIMER_INTERVAL, null, 0L);
        } catch (IOException e4) {
            e = e4;
            SI3.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return AbstractC7895Tq4.b.UNKNOWN_MOBILE_SUBTYPE.j();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return AbstractC7895Tq4.b.COMBINED.j();
        }
        if (AbstractC7895Tq4.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int g(NetworkInfo networkInfo) {
        return networkInfo == null ? AbstractC7895Tq4.c.NONE.j() : networkInfo.getType();
    }

    private static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            SI3.d("CctTransportBackend", "Unable to find version code for package", e);
            return -1;
        }
    }

    private AbstractC22662vd0 i(YV yv) {
        AbstractC21883uI3.a aVarJ;
        HashMap map = new HashMap();
        for (AbstractC7747Ta2 abstractC7747Ta2 : yv.b()) {
            String strJ = abstractC7747Ta2.j();
            if (map.containsKey(strJ)) {
                ((List) map.get(strJ)).add(abstractC7747Ta2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(abstractC7747Ta2);
                map.put(strJ, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            AbstractC7747Ta2 abstractC7747Ta22 = (AbstractC7747Ta2) ((List) entry.getValue()).get(0);
            AI3.a aVarB = AI3.a().f(EnumC23479wz5.DEFAULT).g(this.f.getTime()).h(this.e.getTime()).b(AbstractC21997uV0.a().c(AbstractC21997uV0.b.ANDROID_FIREBASE).b(AbstractC7863Tn.a().m(Integer.valueOf(abstractC7747Ta22.g("sdk-version"))).j(abstractC7747Ta22.b(CommonUrlParts.MODEL)).f(abstractC7747Ta22.b("hardware")).d(abstractC7747Ta22.b("device")).l(abstractC7747Ta22.b("product")).k(abstractC7747Ta22.b("os-uild")).h(abstractC7747Ta22.b(CommonUrlParts.MANUFACTURER)).e(abstractC7747Ta22.b("fingerprint")).c(abstractC7747Ta22.b("country")).g(abstractC7747Ta22.b(CommonUrlParts.LOCALE)).i(abstractC7747Ta22.b("mcc_mnc")).b(abstractC7747Ta22.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (AbstractC7747Ta2 abstractC7747Ta23 : (List) entry.getValue()) {
                X72 x72E = abstractC7747Ta23.e();
                C11515d82 c11515d82B = x72E.b();
                if (c11515d82B.equals(C11515d82.b("proto"))) {
                    aVarJ = AbstractC21883uI3.j(x72E.a());
                } else if (c11515d82B.equals(C11515d82.b("json"))) {
                    aVarJ = AbstractC21883uI3.i(new String(x72E.a(), Charset.forName("UTF-8")));
                } else {
                    SI3.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", c11515d82B);
                }
                aVarJ.c(abstractC7747Ta23.f()).d(abstractC7747Ta23.k()).h(abstractC7747Ta23.h("tz-offset")).e(AbstractC7895Tq4.a().c(AbstractC7895Tq4.c.a(abstractC7747Ta23.g("net-type"))).b(AbstractC7895Tq4.b.a(abstractC7747Ta23.g("mobile-subtype"))).a());
                if (abstractC7747Ta23.d() != null) {
                    aVarJ.b(abstractC7747Ta23.d());
                }
                arrayList3.add(aVarJ.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return AbstractC22662vd0.a(arrayList2);
    }

    private static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ a l(a aVar, b bVar) {
        URL url = bVar.b;
        if (url == null) {
            return null;
        }
        SI3.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.b);
    }

    private static InputStream m(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    @Override // ir.nasim.InterfaceC5558Jv7
    public ZV a(YV yv) {
        AbstractC22662vd0 abstractC22662vd0I = i(yv);
        URL urlN = this.d;
        if (yv.c() != null) {
            try {
                com.google.android.datatransport.cct.a aVarC = com.google.android.datatransport.cct.a.c(yv.c());
                strD = aVarC.d() != null ? aVarC.d() : null;
                if (aVarC.e() != null) {
                    urlN = n(aVarC.e());
                }
            } catch (IllegalArgumentException unused) {
                return ZV.a();
            }
        }
        try {
            b bVar = (b) AbstractC18065o16.a(5, new a(urlN, abstractC22662vd0I, strD), new InterfaceC12187eB2() { // from class: com.google.android.datatransport.cct.b
                @Override // ir.nasim.InterfaceC12187eB2
                public final Object apply(Object obj) {
                    return this.a.e((d.a) obj);
                }
            }, new InterfaceC22910w16() { // from class: com.google.android.datatransport.cct.c
                @Override // ir.nasim.InterfaceC22910w16
                public final Object a(Object obj, Object obj2) {
                    return d.l((d.a) obj, (d.b) obj2);
                }
            });
            int i = bVar.a;
            if (i == 200) {
                return ZV.e(bVar.c);
            }
            if (i < 500 && i != 404) {
                return i == 400 ? ZV.d() : ZV.a();
            }
            return ZV.f();
        } catch (IOException e) {
            SI3.d("CctTransportBackend", "Could not make request to the backend", e);
            return ZV.f();
        }
    }

    @Override // ir.nasim.InterfaceC5558Jv7
    public AbstractC7747Ta2 b(AbstractC7747Ta2 abstractC7747Ta2) {
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        return abstractC7747Ta2.l().a("sdk-version", Build.VERSION.SDK_INT).c(CommonUrlParts.MODEL, Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c(CommonUrlParts.MANUFACTURER, Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c(CommonUrlParts.LOCALE, Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.c).getSimOperator()).c("application_build", Integer.toString(h(this.c))).d();
    }

    d(Context context, QV0 qv0, QV0 qv02) {
        this(context, qv0, qv02, 130000);
    }
}
