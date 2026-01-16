package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ni8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17880ni8 {
    private final Rm8 a;
    private final Rh8 b;
    private final Context c;
    private final C15516ji8 d;
    private PackageInfo e;

    public C17880ni8(Context context, Rm8 rm8, Rh8 rh8) {
        C15516ji8 c15516ji8 = new C15516ji8(new Ug8(rm8));
        this.a = rm8;
        this.b = rh8;
        this.c = context;
        this.d = c15516ji8;
    }

    private final PackageInfo d() {
        if (this.e == null) {
            try {
                this.e = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return this.e;
    }

    private static X509Certificate e(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    public final boolean a(File[] fileArr) {
        long longVersionCode = Build.VERSION.SDK_INT >= 28 ? d().getLongVersionCode() : r0.versionCode;
        AssetManager assetManager = (AssetManager) com.google.android.play.core.splitinstall.internal.c.c(AssetManager.class);
        int length = fileArr.length;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            this.d.b(assetManager, fileArr[length]);
        } while (longVersionCode == this.d.a());
        return false;
    }

    public final boolean b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!this.a.g(((Intent) it.next()).getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0085, code lost:
    
        android.util.Log.e("SplitCompat", "Downloaded split " + r6 + " is not signed.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.io.File[] r13) {
        /*
            r12 = this;
            java.lang.String r0 = " is not signed."
            java.lang.String r1 = "Downloaded split "
            android.content.pm.PackageInfo r2 = r12.d()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L2a
            android.content.pm.Signature[] r5 = r2.signatures
            if (r5 != 0) goto L11
            goto L2a
        L11:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.pm.Signature[] r2 = r2.signatures
            int r5 = r2.length
            r6 = r4
        L1a:
            if (r6 >= r5) goto L2a
            r7 = r2[r6]
            java.security.cert.X509Certificate r7 = e(r7)
            if (r7 == 0) goto L27
            r3.add(r7)
        L27:
            int r6 = r6 + 1
            goto L1a
        L2a:
            java.lang.String r2 = "SplitCompat"
            if (r3 == 0) goto Lbf
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L36
            goto Lbf
        L36:
            int r5 = r13.length
        L37:
            int r5 = r5 + (-1)
            if (r5 < 0) goto Lbd
            r6 = r13[r5]
            java.lang.String r6 = r6.getAbsolutePath()     // Catch: java.lang.Exception -> L5c
            java.security.cert.X509Certificate[][] r7 = ir.nasim.Qp8.a(r6)     // Catch: java.lang.Exception -> L9b
            if (r7 == 0) goto L85
            int r8 = r7.length     // Catch: java.lang.Exception -> L5c
            if (r8 == 0) goto L85
            r8 = r7[r4]     // Catch: java.lang.Exception -> L5c
            int r8 = r8.length     // Catch: java.lang.Exception -> L5c
            if (r8 != 0) goto L50
            goto L85
        L50:
            boolean r6 = r3.isEmpty()     // Catch: java.lang.Exception -> L5c
            if (r6 == 0) goto L5e
            java.lang.String r13 = "No certificates found for app."
            android.util.Log.e(r2, r13)     // Catch: java.lang.Exception -> L5c
            goto Lb1
        L5c:
            r13 = move-exception
            goto Lb7
        L5e:
            java.util.Iterator r6 = r3.iterator()     // Catch: java.lang.Exception -> L5c
        L62:
            boolean r8 = r6.hasNext()     // Catch: java.lang.Exception -> L5c
            if (r8 == 0) goto L37
            java.lang.Object r8 = r6.next()     // Catch: java.lang.Exception -> L5c
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch: java.lang.Exception -> L5c
            int r9 = r7.length     // Catch: java.lang.Exception -> L5c
            r10 = r4
        L70:
            if (r10 >= r9) goto L7f
            r11 = r7[r10]     // Catch: java.lang.Exception -> L5c
            r11 = r11[r4]     // Catch: java.lang.Exception -> L5c
            boolean r11 = r11.equals(r8)     // Catch: java.lang.Exception -> L5c
            if (r11 != 0) goto L62
            int r10 = r10 + 1
            goto L70
        L7f:
            java.lang.String r13 = "There's an app certificate that doesn't sign the split."
            android.util.Log.i(r2, r13)     // Catch: java.lang.Exception -> L5c
            goto Lb1
        L85:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5c
            r13.<init>()     // Catch: java.lang.Exception -> L5c
            r13.append(r1)     // Catch: java.lang.Exception -> L5c
            r13.append(r6)     // Catch: java.lang.Exception -> L5c
            r13.append(r0)     // Catch: java.lang.Exception -> L5c
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Exception -> L5c
            android.util.Log.e(r2, r13)     // Catch: java.lang.Exception -> L5c
            goto Lb1
        L9b:
            r13 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5c
            r3.<init>()     // Catch: java.lang.Exception -> L5c
            r3.append(r1)     // Catch: java.lang.Exception -> L5c
            r3.append(r6)     // Catch: java.lang.Exception -> L5c
            r3.append(r0)     // Catch: java.lang.Exception -> L5c
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> L5c
            android.util.Log.e(r2, r0, r13)     // Catch: java.lang.Exception -> L5c
        Lb1:
            java.lang.String r13 = "Split verification failure."
            android.util.Log.e(r2, r13)     // Catch: java.lang.Exception -> L5c
            return r4
        Lb7:
            java.lang.String r0 = "Split verification error."
            android.util.Log.e(r2, r0, r13)
            return r4
        Lbd:
            r13 = 1
            return r13
        Lbf:
            java.lang.String r13 = "No app certificates found."
            android.util.Log.e(r2, r13)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17880ni8.c(java.io.File[]):boolean");
    }
}
