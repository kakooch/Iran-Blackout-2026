package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.address.ParameterNames;
import ir.nasim.core.runtime.mtproto.ConnectionEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public class L82 implements LZ2 {
    private final C18610ow7[] a;
    private final O82 b;
    private final SA2 c;
    private boolean d = false;
    private boolean e = false;
    private int f = 0;

    class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            C19406qI3.d("Endpoints", iOException);
            L82.this.f++;
            if (L82.this.f > 5) {
                return;
            }
            try {
                L82.this.k();
            } catch (Exception e) {
                C19406qI3.d("Endpoints", e);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody == null) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("Endpoint list content is null!"));
                    return;
                }
                L82.this.b(responseBodyBody.bytes(), response.headers().get("signBale"));
                return;
            }
            C19406qI3.b("Endpoints", "Code: \n" + response.code());
            L82 l82 = L82.this;
            l82.f = l82.f + 1;
            if (L82.this.f > 5) {
                return;
            }
            try {
                L82.this.k();
            } catch (Exception e) {
                C19406qI3.d("Endpoints", e);
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }
    }

    public L82(ConnectionEndpoint[] connectionEndpointArr, C18610ow7[] c18610ow7Arr, SA2 sa2) {
        this.a = c18610ow7Arr;
        this.c = sa2;
        this.b = new O82(Arrays.asList(connectionEndpointArr));
    }

    private ConnectionEndpoint[] j(String[] strArr) throws NumberFormatException {
        List listSingletonList;
        String str;
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            String strTrim = str2.trim();
            String lowerCase = strTrim.substring(0, strTrim.indexOf(":")).toLowerCase();
            String strSubstring = strTrim.substring(strTrim.indexOf("://") + 3);
            String str3 = null;
            if (lowerCase.contains(Separators.AT)) {
                String[] strArrSplit = lowerCase.split(Separators.AT);
                String str4 = strArrSplit[0];
                listSingletonList = Collections.singletonList(strArrSplit[1]);
                lowerCase = str4;
            } else {
                listSingletonList = null;
            }
            if (strSubstring.endsWith(Separators.SLASH)) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            String str5 = strSubstring;
            long j = 1;
            int i = -1;
            try {
                if (str5.contains(Separators.POUND)) {
                    String[] strArrSplit2 = str5.split(Separators.POUND);
                    str5 = strArrSplit2[0];
                    j = Long.parseLong(strArrSplit2[1]);
                }
                if (str5.contains(":")) {
                    String[] strArrSplit3 = str5.split(":");
                    str5 = strArrSplit3[0];
                    i = Integer.parseInt(strArrSplit3[1]);
                }
            } catch (Exception e) {
                C19406qI3.d("Endpoints", e);
            }
            long j2 = j;
            if (str5.contains(Separators.AT)) {
                String[] strArrSplit4 = str5.split(Separators.AT);
                String str6 = strArrSplit4[0];
                str3 = strArrSplit4[1];
                str = str6;
            } else {
                str = str5;
            }
            String str7 = str3;
            if (lowerCase.equals("ssl") || lowerCase.equals(ParameterNames.TLS)) {
                if (i <= 0) {
                    i = 443;
                }
                arrayList.add(new ConnectionEndpoint(str, i, (List<String>) listSingletonList, str7, 1, j2));
            } else if (lowerCase.equals(ParameterNames.TCP)) {
                if (i <= 0) {
                    i = 80;
                }
                arrayList.add(new ConnectionEndpoint(str, i, (List<String>) listSingletonList, str7, 0, j2));
            } else if (lowerCase.equals("ws")) {
                if (i <= 0) {
                    i = 80;
                }
                arrayList.add(new ConnectionEndpoint(str, i, (List<String>) listSingletonList, str7, 2, j2));
            } else {
                if (!lowerCase.equals("wss")) {
                    throw new RuntimeException("Endpoints=> Unknown scheme type: " + lowerCase);
                }
                if (i <= 0) {
                    i = 443;
                }
                arrayList.add(new ConnectionEndpoint(str, i, (List<String>) listSingletonList, str7, 3, j2));
            }
        }
        return (ConnectionEndpoint[]) arrayList.toArray(new ConnectionEndpoint[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            if (this.d) {
                return;
            }
            C19406qI3.a("Endpoints", "getFreshEndpoints: Getting fresh endpoints", new Object[0]);
            Request.Builder builderUrl = new Request.Builder().url("http://ep.bale.ai/ep/endpoints-android.json");
            try {
                Integer num = (Integer) this.c.invoke();
                if (num != null) {
                    builderUrl.addHeader("user_id", num.toString());
                }
            } catch (Exception unused) {
            }
            XS2.a().newCall(builderUrl.build()).enqueue(new a());
        } catch (Exception e) {
            C19406qI3.d("Endpoints", e);
        }
    }

    @Override // ir.nasim.LZ2
    public ConnectionEndpoint a(boolean z) throws Exception {
        if (!this.e) {
            this.e = true;
            try {
                k();
            } catch (Exception e) {
                C19406qI3.d("Endpoints", e);
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }
        List listG = this.b.g();
        if (z) {
            for (int i = 0; i < listG.size(); i++) {
                ConnectionEndpoint connectionEndpoint = (ConnectionEndpoint) listG.get(i);
                int type = connectionEndpoint.getType();
                if (type == 1 || type == 3) {
                    return connectionEndpoint;
                }
            }
            throw new Exception("Endpoint should be encrypted");
        }
        ConnectionEndpoint connectionEndpoint2 = null;
        ConnectionEndpoint connectionEndpoint3 = null;
        for (int i2 = 0; i2 < listG.size(); i2++) {
            ConnectionEndpoint connectionEndpoint4 = (ConnectionEndpoint) listG.get(i2);
            int type2 = connectionEndpoint4.getType();
            if (connectionEndpoint2 == null && (type2 == 0 || type2 == 2)) {
                connectionEndpoint2 = connectionEndpoint4;
            } else if (connectionEndpoint3 == null && (type2 == 1 || type2 == 3)) {
                connectionEndpoint3 = connectionEndpoint4;
            }
        }
        if (connectionEndpoint2 == null && connectionEndpoint3 != null) {
            return connectionEndpoint3;
        }
        if (connectionEndpoint2 != null) {
            return connectionEndpoint2;
        }
        throw new Exception("No valid Endpoint exists");
    }

    @Override // ir.nasim.LZ2
    public void b(byte[] bArr, String str) {
        boolean z;
        ConnectionEndpoint[] connectionEndpointArrJ;
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("Endpoint list content or sign is null!"));
            return;
        }
        if (!AbstractC6028Lw1.e(AbstractC22589vV2.a("1e89fe4deb27e7c663a03fe76117f9af18b514037019afd21e1de441135b5f24"), bArr, AbstractC22589vV2.a(str.toLowerCase()))) {
            C19406qI3.b("Endpoints", "Endpoints had been corrupted!");
            return;
        }
        String[] strArrSplit = new String(bArr).split(Separators.RETURN);
        if (strArrSplit.length <= 1) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("Endpoint list should have at least 2 lines!"));
            return;
        }
        if (strArrSplit[0].equals("s")) {
            C19406qI3.a("Endpoints", "Selecting type is Sequential", new Object[0]);
            z = false;
        } else if (!strArrSplit[0].equals("r")) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("Type of selecting endpoints is not specified"));
            return;
        } else {
            C19406qI3.a("Endpoints", "Selecting type is Random", new Object[0]);
            z = true;
        }
        String[] strArr = (String[]) Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length);
        if (z) {
            Random random = new Random();
            for (int length = strArr.length - 1; length >= 0; length--) {
                int iNextInt = random.nextInt(length + 1);
                String str2 = strArr[iNextInt];
                strArr[iNextInt] = strArr[length];
                strArr[length] = str2;
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            C19406qI3.a("Endpoints", "Endpoints loaded. endpoint no #" + i, new Object[0]);
        }
        try {
            connectionEndpointArrJ = j(strArr);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
            connectionEndpointArrJ = null;
        }
        if (connectionEndpointArrJ != null) {
            e(connectionEndpointArrJ);
        } else {
            C19406qI3.b("Endpoints", "Connection Endpoint Array is null");
        }
        this.d = true;
    }

    @Override // ir.nasim.LZ2
    public C18610ow7[] c() {
        return this.a;
    }

    @Override // ir.nasim.LZ2
    public void d(ConnectionEndpoint connectionEndpoint) {
        this.b.l(connectionEndpoint);
    }

    @Override // ir.nasim.LZ2
    public void e(ConnectionEndpoint[] connectionEndpointArr) {
        this.b.m(Arrays.asList(connectionEndpointArr));
    }

    @Override // ir.nasim.LZ2
    public void f(ConnectionEndpoint connectionEndpoint) {
        this.b.k(connectionEndpoint);
    }
}
