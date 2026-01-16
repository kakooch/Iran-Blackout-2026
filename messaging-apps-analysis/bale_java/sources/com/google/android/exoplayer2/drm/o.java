package com.google.android.exoplayer2.drm;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC13937h43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C19445qM6;
import ir.nasim.C22289uz1;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class o implements p {
    private final a.InterfaceC0163a a;
    private final String b;
    private final boolean c;
    private final Map d;

    public o(String str, boolean z, a.InterfaceC0163a interfaceC0163a) {
        AbstractC20011rK.a((z && TextUtils.isEmpty(str)) ? false : true);
        this.a = interfaceC0163a;
        this.b = str;
        this.c = z;
        this.d = new HashMap();
    }

    private static byte[] c(a.InterfaceC0163a interfaceC0163a, String str, byte[] bArr, Map map) throws MediaDrmCallbackException {
        C19445qM6 c19445qM6 = new C19445qM6(interfaceC0163a.a());
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0164b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i = 0;
        com.google.android.exoplayer2.upstream.b bVarA2 = bVarA;
        while (true) {
            try {
                C22289uz1 c22289uz1 = new C22289uz1(c19445qM6, bVarA2);
                try {
                    try {
                        return AbstractC9683aN7.X0(c22289uz1);
                    } catch (HttpDataSource.InvalidResponseCodeException e) {
                        String strD = d(e, i);
                        if (strD == null) {
                            throw e;
                        }
                        i++;
                        bVarA2 = bVarA2.a().j(strD).a();
                    }
                } finally {
                    AbstractC9683aN7.m(c22289uz1);
                }
            } catch (Exception e2) {
                throw new MediaDrmCallbackException(bVarA, (Uri) AbstractC20011rK.e(c19445qM6.o()), c19445qM6.d(), c19445qM6.n(), e2);
            }
        }
    }

    private static String d(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i) {
        Map map;
        List list;
        int i2 = invalidResponseCodeException.d;
        if ((i2 != 307 && i2 != 308) || i >= 5 || (map = invalidResponseCodeException.f) == null || (list = (List) map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.p
    public byte[] a(UUID uuid, m.d dVar) {
        return c(this.a, dVar.b() + "&signedRequest=" + AbstractC9683aN7.B(dVar.a()), null, Collections.emptyMap());
    }

    @Override // com.google.android.exoplayer2.drm.p
    public byte[] b(UUID uuid, m.a aVar) throws MediaDrmCallbackException {
        String strB = aVar.b();
        if (this.c || TextUtils.isEmpty(strB)) {
            strB = this.b;
        }
        if (TextUtils.isEmpty(strB)) {
            b.C0164b c0164b = new b.C0164b();
            Uri uri = Uri.EMPTY;
            throw new MediaDrmCallbackException(c0164b.i(uri).a(), uri, AbstractC13937h43.p(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = AbstractC9350Zo0.e;
        map.put(SIPHeaderNames.CONTENT_TYPE, uuid2.equals(uuid) ? "text/xml" : AbstractC9350Zo0.c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.d) {
            map.putAll(this.d);
        }
        return c(this.a, strB, aVar.a(), map);
    }

    public void e(String str, String str2) {
        AbstractC20011rK.e(str);
        AbstractC20011rK.e(str2);
        synchronized (this.d) {
            this.d.put(str, str2);
        }
    }
}
