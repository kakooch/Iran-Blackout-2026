package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzhj<T extends zzhi<T>> {
    private static final zzhj zzd = new zzhj(true);
    final zzjs<T, Object> zza = new zzjl(16);
    private boolean zzb;
    private boolean zzc;

    private zzhj() {
    }

    public static <T extends zzhi<T>> zzhj<T> zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzd(T r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.measurement.zzko r0 = r4.zzb()
            com.google.android.gms.internal.measurement.zzia.zza(r5)
            com.google.android.gms.internal.measurement.zzko r1 = com.google.android.gms.internal.measurement.zzko.zza
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.INT
            com.google.android.gms.internal.measurement.zzkp r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L3d;
                case 1: goto L3a;
                case 2: goto L37;
                case 3: goto L34;
                case 4: goto L31;
                case 5: goto L2e;
                case 6: goto L25;
                case 7: goto L1c;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L42
        L17:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzix
            if (r0 == 0) goto L42
            goto L41
        L1c:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L41
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzhu
            if (r0 == 0) goto L42
            goto L41
        L25:
            boolean r0 = r5 instanceof com.google.android.gms.internal.measurement.zzgs
            if (r0 != 0) goto L41
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L42
            goto L41
        L2e:
            boolean r0 = r5 instanceof java.lang.String
            goto L3f
        L31:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L3f
        L34:
            boolean r0 = r5 instanceof java.lang.Double
            goto L3f
        L37:
            boolean r0 = r5 instanceof java.lang.Float
            goto L3f
        L3a:
            boolean r0 = r5 instanceof java.lang.Long
            goto L3f
        L3d:
            boolean r0 = r5 instanceof java.lang.Integer
        L3f:
            if (r0 == 0) goto L42
        L41:
            return
        L42:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzko r4 = r4.zzb()
            com.google.android.gms.internal.measurement.zzkp r4 = r4.zza()
            r1[r2] = r4
            r4 = 2
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r1[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhj.zzd(com.google.android.gms.internal.measurement.zzhi, java.lang.Object):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhj zzhjVar = new zzhj();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzd = this.zza.zzd(i);
            zzhjVar.zzc((zzhi) entryZzd.getKey(), entryZzd.getValue());
        }
        Iterator it = this.zza.zze().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzhjVar.zzc((zzhi) entry.getKey(), entry.getValue());
        }
        zzhjVar.zzc = this.zzc;
        return zzhjVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhj) {
            return this.zza.equals(((zzhj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final void zzc(T t, Object obj) {
        if (!t.zzc()) {
            zzd(t, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t, arrayList.get(i));
            }
            obj = arrayList;
        }
        this.zza.put(t, obj);
    }

    private zzhj(boolean z) {
        zzb();
        zzb();
    }
}
