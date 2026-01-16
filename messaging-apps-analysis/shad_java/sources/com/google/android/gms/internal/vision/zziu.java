package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zziw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: classes3.dex */
final class zziu<T extends zziw<T>> {
    private static final zziu zzd = new zziu(true);
    final zzlh<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zziu() {
        this.zza = zzlh.zza(16);
    }

    private zziu(boolean z) {
        this(zzlh.zza(0));
        zzb();
    }

    private zziu(zzlh<T, Object> zzlhVar) {
        this.zza = zzlhVar;
        zzb();
    }

    public static <T extends zziw<T>> zziu<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zziu) {
            return this.zza.equals(((zziu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzjq(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzjq(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    public final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzjp)) {
            return obj;
        }
        return zzjp.zza();
    }

    public final void zza(T t, Object obj) {
        if (t.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zzd(t, obj2);
            }
            obj = arrayList;
        } else {
            zzd(t, obj);
        }
        if (obj instanceof zzjp) {
            this.zzc = true;
        }
        this.zza.zza((zzlh<T, Object>) t, (T) obj);
    }

    public final void zzb(T t, Object obj) {
        List arrayList;
        if (!t.zzd()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        zzd(t, obj);
        Object objZza = zza((zziu<T>) t);
        if (objZza == null) {
            arrayList = new ArrayList();
            this.zza.zza((zzlh<T, Object>) t, (T) arrayList);
        } else {
            arrayList = (List) objZza;
        }
        arrayList.add(obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzd(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.vision.zzml r0 = r5.zzb()
            com.google.android.gms.internal.vision.zzjf.zza(r6)
            int[] r1 = com.google.android.gms.internal.vision.zzit.zza
            com.google.android.gms.internal.vision.zzmo r0 = r0.zza()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = 0
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.zzkk
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.zzjp
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.zzje
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.zzht
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
        L34:
            r0 = 1
            goto L47
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.vision.zzml r5 = r5.zzb()
            com.google.android.gms.internal.vision.zzmo r5 = r5.zza()
            r3[r1] = r5
            r5 = 2
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r3[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            goto L79
        L78:
            throw r0
        L79:
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zziu.zzd(com.google.android.gms.internal.vision.zziw, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zziw<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzmo.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzkk) it.next()).zzk()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzkk) {
                    if (!((zzkk) value).zzk()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzjp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zziu<T> zziuVar) {
        for (int i = 0; i < zziuVar.zza.zzc(); i++) {
            zzb(zziuVar.zza.zzb(i));
        }
        Iterator it = zziuVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzkt) {
            return ((zzkt) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzkk zzkkVarZzf;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzjp) {
            value = zzjp.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zziu<T>) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.zza((zzlh<T, Object>) key, (T) objZza);
            return;
        }
        if (key.zzc() == zzmo.MESSAGE) {
            Object objZza2 = zza((zziu<T>) key);
            if (objZza2 == null) {
                this.zza.zza((zzlh<T, Object>) key, (T) zza(value));
                return;
            }
            if (objZza2 instanceof zzkt) {
                zzkkVarZzf = key.zza((zzkt) objZza2, (zzkt) value);
            } else {
                zzkkVarZzf = key.zza(((zzkk) objZza2).zzp(), (zzkk) value).zzf();
            }
            this.zza.zza((zzlh<T, Object>) key, (T) zzkkVarZzf);
            return;
        }
        this.zza.zza((zzlh<T, Object>) key, (T) zza(value));
    }

    public final int zzg() {
        int iZzc = 0;
        for (int i = 0; i < this.zza.zzc(); i++) {
            iZzc += zzc(this.zza.zzb(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzmo.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzjp) {
                return zzii.zzb(entry.getKey().zza(), (zzjp) value);
            }
            return zzii.zzb(entry.getKey().zza(), (zzkk) value);
        }
        return zzc(key, value);
    }

    static int zza(zzml zzmlVar, int i, Object obj) {
        int iZze = zzii.zze(i);
        if (zzmlVar == zzml.zzj) {
            zzjf.zza((zzkk) obj);
            iZze <<= 1;
        }
        return iZze + zza(zzmlVar, obj);
    }

    private static int zza(zzml zzmlVar, Object obj) {
        switch (zzit.zzb[zzmlVar.ordinal()]) {
            case 1:
                return zzii.zzb(((Double) obj).doubleValue());
            case 2:
                return zzii.zzb(((Float) obj).floatValue());
            case 3:
                return zzii.zzd(((Long) obj).longValue());
            case 4:
                return zzii.zze(((Long) obj).longValue());
            case 5:
                return zzii.zzf(((Integer) obj).intValue());
            case 6:
                return zzii.zzg(((Long) obj).longValue());
            case 7:
                return zzii.zzi(((Integer) obj).intValue());
            case 8:
                return zzii.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzii.zzc((zzkk) obj);
            case 10:
                if (obj instanceof zzjp) {
                    return zzii.zza((zzjp) obj);
                }
                return zzii.zzb((zzkk) obj);
            case 11:
                if (obj instanceof zzht) {
                    return zzii.zzb((zzht) obj);
                }
                return zzii.zzb((String) obj);
            case 12:
                if (obj instanceof zzht) {
                    return zzii.zzb((zzht) obj);
                }
                return zzii.zzb((byte[]) obj);
            case 13:
                return zzii.zzg(((Integer) obj).intValue());
            case 14:
                return zzii.zzj(((Integer) obj).intValue());
            case 15:
                return zzii.zzh(((Long) obj).longValue());
            case 16:
                return zzii.zzh(((Integer) obj).intValue());
            case 17:
                return zzii.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzje) {
                    return zzii.zzk(((zzje) obj).zza());
                }
                return zzii.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zziw<?> zziwVar, Object obj) {
        zzml zzmlVarZzb = zziwVar.zzb();
        int iZza = zziwVar.zza();
        if (zziwVar.zzd()) {
            int iZza2 = 0;
            if (zziwVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zza(zzmlVarZzb, it.next());
                }
                return zzii.zze(iZza) + iZza2 + zzii.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzmlVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzmlVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zziu zziuVar = new zziu();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zziuVar.zza((zziu) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zziuVar.zza((zziu) entry.getKey(), entry.getValue());
        }
        zziuVar.zzc = this.zzc;
        return zziuVar;
    }
}
