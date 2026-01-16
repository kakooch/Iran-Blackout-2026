package com.google.firebase.messaging;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C5490Jo2;
import ir.nasim.ExecutorC4596Fu5;
import ir.nasim.InterfaceC20886sm1;
import ir.nasim.InterfaceC7875To2;
import ir.nasim.InterfaceC7959Tx5;
import ir.nasim.N66;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* renamed from: com.google.firebase.messaging.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2376m {
    private final C5490Jo2 a;
    private final o b;
    private final N66 c;
    private final InterfaceC7959Tx5 d;
    private final InterfaceC7959Tx5 e;
    private final InterfaceC7875To2 f;

    C2376m(C5490Jo2 c5490Jo2, o oVar, InterfaceC7959Tx5 interfaceC7959Tx5, InterfaceC7959Tx5 interfaceC7959Tx52, InterfaceC7875To2 interfaceC7875To2) {
        this(c5490Jo2, oVar, new N66(c5490Jo2.j()), interfaceC7959Tx5, interfaceC7959Tx52, interfaceC7875To2);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task d(Task task) {
        return task.h(new ExecutorC4596Fu5(), new InterfaceC20886sm1() { // from class: com.google.firebase.messaging.l
            @Override // ir.nasim.InterfaceC20886sm1
            public final Object a(Task task2) {
                return this.a.i(task2);
            }
        });
    }

    private String e() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.a.l().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String g(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    static boolean h(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i(Task task) {
        return g((Bundle) task.m(IOException.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j(java.lang.String r3, java.lang.String r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "scope"
            r5.putString(r1, r4)
            java.lang.String r4 = "sender"
            r5.putString(r4, r3)
            java.lang.String r4 = "subtype"
            r5.putString(r4, r3)
            ir.nasim.Jo2 r3 = r2.a
            ir.nasim.cp2 r3 = r3.m()
            java.lang.String r3 = r3.c()
            java.lang.String r4 = "gmp_app_id"
            r5.putString(r4, r3)
            com.google.firebase.messaging.o r3 = r2.b
            int r3 = r3.d()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "gmsv"
            r5.putString(r4, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r4 = "osv"
            r5.putString(r4, r3)
            com.google.firebase.messaging.o r3 = r2.b
            java.lang.String r3 = r3.a()
            java.lang.String r4 = "app_ver"
            r5.putString(r4, r3)
            com.google.firebase.messaging.o r3 = r2.b
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "app_ver_name"
            r5.putString(r4, r3)
            java.lang.String r3 = "firebase-app-name-hash"
            java.lang.String r4 = r2.e()
            r5.putString(r3, r4)
            ir.nasim.To2 r3 = r2.f     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            r4 = 0
            com.google.android.gms.tasks.Task r3 = r3.a(r4)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            java.lang.Object r3 = ir.nasim.AbstractC9078Yj7.a(r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            com.google.firebase.installations.f r3 = (com.google.firebase.installations.f) r3     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            java.lang.String r3 = r3.b()     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            if (r4 != 0) goto L7a
            java.lang.String r4 = "Goog-Firebase-Installations-Auth"
            r5.putString(r4, r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            goto L85
        L76:
            r3 = move-exception
            goto L80
        L78:
            r3 = move-exception
            goto L80
        L7a:
            java.lang.String r3 = "FIS auth token is empty"
            android.util.Log.w(r0, r3)     // Catch: java.lang.InterruptedException -> L76 java.util.concurrent.ExecutionException -> L78
            goto L85
        L80:
            java.lang.String r4 = "Failed to get FIS auth token"
            android.util.Log.e(r0, r4, r3)
        L85:
            ir.nasim.To2 r3 = r2.f
            com.google.android.gms.tasks.Task r3 = r3.getId()
            java.lang.Object r3 = ir.nasim.AbstractC9078Yj7.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "appid"
            r5.putString(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fcm-"
            r3.append(r4)
            java.lang.String r4 = "23.1.1"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "cliv"
            r5.putString(r4, r3)
            ir.nasim.Tx5 r3 = r2.e
            java.lang.Object r3 = r3.get()
            ir.nasim.bV2 r3 = (ir.nasim.InterfaceC10344bV2) r3
            ir.nasim.Tx5 r4 = r2.d
            java.lang.Object r4 = r4.get()
            ir.nasim.qI7 r4 = (ir.nasim.InterfaceC19410qI7) r4
            if (r3 == 0) goto Le2
            if (r4 == 0) goto Le2
            java.lang.String r0 = "fire-iid"
            ir.nasim.bV2$a r3 = r3.b(r0)
            ir.nasim.bV2$a r0 = ir.nasim.InterfaceC10344bV2.a.NONE
            if (r3 == r0) goto Le2
            int r3 = r3.a()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r0 = "Firebase-Client-Log-Type"
            r5.putString(r0, r3)
            java.lang.String r3 = "Firebase-Client"
            java.lang.String r4 = r4.getUserAgent()
            r5.putString(r3, r4)
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.C2376m.j(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    private Task k(String str, String str2, Bundle bundle) {
        try {
            j(str, str2, bundle);
            return this.c.a(bundle);
        } catch (InterruptedException | ExecutionException e) {
            return AbstractC9078Yj7.d(e);
        }
    }

    Task c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(k(o.c(this.a), Separators.STAR, bundle));
    }

    Task f() {
        return d(k(o.c(this.a), Separators.STAR, new Bundle()));
    }

    Task l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(k(str, "/topics/" + str2, bundle));
    }

    Task m(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(k(str, "/topics/" + str2, bundle));
    }

    C2376m(C5490Jo2 c5490Jo2, o oVar, N66 n66, InterfaceC7959Tx5 interfaceC7959Tx5, InterfaceC7959Tx5 interfaceC7959Tx52, InterfaceC7875To2 interfaceC7875To2) {
        this.a = c5490Jo2;
        this.b = oVar;
        this.c = n66;
        this.d = interfaceC7959Tx5;
        this.e = interfaceC7959Tx52;
        this.f = interfaceC7875To2;
    }
}
