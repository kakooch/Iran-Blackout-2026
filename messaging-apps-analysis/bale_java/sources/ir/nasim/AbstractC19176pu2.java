package ir.nasim;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import ir.nasim.AbstractC6245Mu2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.pu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC19176pu2 {
    private static final Comparator a = new Comparator() { // from class: ir.nasim.ou2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC19176pu2.g((byte[]) obj, (byte[]) obj2);
        }
    };

    /* renamed from: ir.nasim.pu2$a */
    private interface a {
        static a a(Context context, Uri uri) {
            return new b(context, uri);
        }

        Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* renamed from: ir.nasim.pu2$b */
    private static class b implements a {
        private final ContentProviderClient a;

        b(Context context, Uri uri) {
            this.a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // ir.nasim.AbstractC19176pu2.a
        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // ir.nasim.AbstractC19176pu2.a
        public void close() {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List d(C19767qu2 c19767qu2, Resources resources) {
        return c19767qu2.b() != null ? c19767qu2.b() : AbstractC20967su2.c(resources, c19767qu2.c());
    }

    static AbstractC6245Mu2.a e(Context context, C19767qu2 c19767qu2, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), c19767qu2, context.getResources());
        return providerInfoF == null ? AbstractC6245Mu2.a.a(1, null) : AbstractC6245Mu2.a.a(0, h(context, c19767qu2, providerInfoF.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, C19767qu2 c19767qu2, Resources resources) throws PackageManager.NameNotFoundException {
        String strE = c19767qu2.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(c19767qu2.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + c19767qu2.f());
        }
        List listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, a);
        List listD = d(c19767qu2, resources);
        for (int i = 0; i < listD.size(); i++) {
            ArrayList arrayList = new ArrayList((Collection) listD.get(i));
            Collections.sort(arrayList, a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            byte b3 = bArr2[i];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static ir.nasim.AbstractC6245Mu2.b[] h(android.content.Context r16, ir.nasim.C19767qu2 r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            r0 = r18
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r0)
            android.net.Uri r2 = r2.build()
            android.net.Uri$Builder r4 = new android.net.Uri$Builder
            r4.<init>()
            android.net.Uri$Builder r3 = r4.scheme(r3)
            android.net.Uri$Builder r0 = r3.authority(r0)
            java.lang.String r3 = "file"
            android.net.Uri$Builder r0 = r0.appendPath(r3)
            android.net.Uri r0 = r0.build()
            r3 = r16
            ir.nasim.pu2$a r3 = ir.nasim.AbstractC19176pu2.a.a(r3, r2)
            r11 = 0
            java.lang.String r4 = "_id"
            java.lang.String r5 = "file_id"
            java.lang.String r6 = "font_ttc_index"
            java.lang.String r7 = "font_variation_settings"
            java.lang.String r8 = "font_weight"
            java.lang.String r9 = "font_italic"
            java.lang.String r10 = "result_code"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10}     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = "query = ?"
            java.lang.String r4 = r17.g()     // Catch: java.lang.Throwable -> L9c
            java.lang.String[] r8 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L9c
            r9 = 0
            r4 = r3
            r5 = r2
            r10 = r19
            android.database.Cursor r11 = r4.b(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9c
            if (r11 == 0) goto Ldd
            int r5 = r11.getCount()     // Catch: java.lang.Throwable -> L9c
            if (r5 <= 0) goto Ldd
            java.lang.String r1 = "result_code"
            int r1 = r11.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L9c
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9c
            r5.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r6 = "_id"
            int r6 = r11.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r7 = "file_id"
            int r7 = r11.getColumnIndex(r7)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r8 = "font_ttc_index"
            int r8 = r11.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r9 = "font_weight"
            int r9 = r11.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r10 = "font_italic"
            int r10 = r11.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L9c
        L8e:
            boolean r12 = r11.moveToNext()     // Catch: java.lang.Throwable -> L9c
            if (r12 == 0) goto Ldc
            r12 = -1
            if (r1 == r12) goto L9e
            int r13 = r11.getInt(r1)     // Catch: java.lang.Throwable -> L9c
            goto L9f
        L9c:
            r0 = move-exception
            goto Lef
        L9e:
            r13 = 0
        L9f:
            if (r8 == r12) goto La6
            int r14 = r11.getInt(r8)     // Catch: java.lang.Throwable -> L9c
            goto La7
        La6:
            r14 = 0
        La7:
            if (r7 != r12) goto Lb4
            r17 = r5
            long r4 = r11.getLong(r6)     // Catch: java.lang.Throwable -> L9c
            android.net.Uri r4 = android.content.ContentUris.withAppendedId(r2, r4)     // Catch: java.lang.Throwable -> L9c
            goto Lbe
        Lb4:
            r17 = r5
            long r4 = r11.getLong(r7)     // Catch: java.lang.Throwable -> L9c
            android.net.Uri r4 = android.content.ContentUris.withAppendedId(r0, r4)     // Catch: java.lang.Throwable -> L9c
        Lbe:
            if (r9 == r12) goto Lc5
            int r5 = r11.getInt(r9)     // Catch: java.lang.Throwable -> L9c
            goto Lc7
        Lc5:
            r5 = 400(0x190, float:5.6E-43)
        Lc7:
            if (r10 == r12) goto Ld1
            int r12 = r11.getInt(r10)     // Catch: java.lang.Throwable -> L9c
            r15 = 1
            if (r12 != r15) goto Ld1
            goto Ld2
        Ld1:
            r15 = 0
        Ld2:
            ir.nasim.Mu2$b r4 = ir.nasim.AbstractC6245Mu2.b.a(r4, r14, r5, r15, r13)     // Catch: java.lang.Throwable -> L9c
            r5 = r17
            r5.add(r4)     // Catch: java.lang.Throwable -> L9c
            goto L8e
        Ldc:
            r1 = r5
        Ldd:
            if (r11 == 0) goto Le2
            r11.close()
        Le2:
            r3.close()
            r0 = 0
            ir.nasim.Mu2$b[] r0 = new ir.nasim.AbstractC6245Mu2.b[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            ir.nasim.Mu2$b[] r0 = (ir.nasim.AbstractC6245Mu2.b[]) r0
            return r0
        Lef:
            if (r11 == 0) goto Lf4
            r11.close()
        Lf4:
            r3.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19176pu2.h(android.content.Context, ir.nasim.qu2, java.lang.String, android.os.CancellationSignal):ir.nasim.Mu2$b[]");
    }
}
