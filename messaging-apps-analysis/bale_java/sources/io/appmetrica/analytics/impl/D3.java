package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class D3 {
    public final Context a;
    public final C2661ke b;
    public final String c;
    public final SafePackageManager d;

    public D3(Context context, C2661ke c2661ke, String str, SafePackageManager safePackageManager) {
        this.a = context;
        this.b = c2661ke;
        this.c = str;
        this.d = safePackageManager;
    }

    public final List a() {
        Signature[] apkContentsSigners;
        String sha1;
        List<String> listF = this.b.f();
        boolean zIsEmpty = listF.isEmpty();
        List<String> list = listF;
        if (zIsEmpty) {
            ArrayList arrayList = new ArrayList();
            try {
                if (AndroidUtils.isApiAchieved(28)) {
                    SigningInfo signingInfo = this.d.getPackageInfo(this.a, this.c, 134217728).signingInfo;
                    apkContentsSigners = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
                } else {
                    apkContentsSigners = this.d.getPackageInfo(this.a, this.c, 64).signatures;
                }
                if (apkContentsSigners != null) {
                    for (Signature signature : apkContentsSigners) {
                        try {
                            sha1 = StringUtils.formatSha1(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
                        } catch (Throwable unused) {
                            sha1 = null;
                        }
                        if (sha1 != null) {
                            arrayList.add(sha1);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            Collections.sort(arrayList);
            boolean zIsEmpty2 = arrayList.isEmpty();
            list = arrayList;
            if (!zIsEmpty2) {
                this.b.a(arrayList).b();
                list = arrayList;
            }
        }
        return list;
    }
}
