package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
final class zzij extends zzil {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* synthetic */ zzij(zzii zziiVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzil
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzkh.zzn(obj, j);
        if (list instanceof zzih) {
            objUnmodifiableList = ((zzih) list).zzi();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzje) && (list instanceof zzhz)) {
                zzhz zzhzVar = (zzhz) list;
                if (zzhzVar.zza()) {
                    zzhzVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzkh.zzo(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzil
    final <E> void zzb(Object obj, Object obj2, long j) {
        zzig zzigVar;
        List list = (List) zzkh.zzn(obj2, j);
        int size = list.size();
        List listZze = (List) zzkh.zzn(obj, j);
        if (listZze.isEmpty()) {
            listZze = listZze instanceof zzih ? new zzig(size) : ((listZze instanceof zzje) && (listZze instanceof zzhz)) ? ((zzhz) listZze).zze(size) : new ArrayList(size);
            zzkh.zzo(obj, j, listZze);
        } else {
            if (zza.isAssignableFrom(listZze.getClass())) {
                ArrayList arrayList = new ArrayList(listZze.size() + size);
                arrayList.addAll(listZze);
                zzkh.zzo(obj, j, arrayList);
                zzigVar = arrayList;
            } else if (listZze instanceof zzkb) {
                zzig zzigVar2 = new zzig(listZze.size() + size);
                zzigVar2.addAll(zzigVar2.size(), (zzkb) listZze);
                zzkh.zzo(obj, j, zzigVar2);
                zzigVar = zzigVar2;
            } else if ((listZze instanceof zzje) && (listZze instanceof zzhz)) {
                zzhz zzhzVar = (zzhz) listZze;
                if (!zzhzVar.zza()) {
                    listZze = zzhzVar.zze(listZze.size() + size);
                    zzkh.zzo(obj, j, listZze);
                }
            }
            listZze = zzigVar;
        }
        int size2 = listZze.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZze.addAll(list);
        }
        if (size2 > 0) {
            list = listZze;
        }
        zzkh.zzo(obj, j, list);
    }
}
