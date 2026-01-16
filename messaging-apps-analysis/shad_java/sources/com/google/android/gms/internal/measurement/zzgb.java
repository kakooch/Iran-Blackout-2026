package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public abstract class zzgb<MessageType extends zzgb<MessageType, BuilderType>, BuilderType extends zzga<MessageType, BuilderType>> implements zzix {
    protected int zzb = 0;

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void zzbs(Iterable<T> iterable, List<? super T> list) {
        zzia.zza(iterable);
        if (iterable instanceof zzih) {
            List<?> listZzh = ((zzih) iterable).zzh();
            zzih zzihVar = (zzih) list;
            int size = list.size();
            for (Object obj : listZzh) {
                if (obj == null) {
                    int size2 = zzihVar.size();
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2 - size);
                    sb.append(" is null.");
                    String string = sb.toString();
                    int size3 = zzihVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            throw new NullPointerException(string);
                        }
                        zzihVar.remove(size3);
                    }
                } else if (obj instanceof zzgs) {
                    zzihVar.zzf((zzgs) obj);
                } else {
                    zzihVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzje) {
            list.addAll(iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size();
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5 - size4);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                int size6 = list.size();
                while (true) {
                    size6--;
                    if (size6 < size4) {
                        throw new NullPointerException(string2);
                    }
                    list.remove(size6);
                }
            } else {
                list.add(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzix
    public final zzgs zzbo() {
        try {
            int iZzbw = zzbw();
            zzgs zzgsVar = zzgs.zzb;
            byte[] bArr = new byte[iZzbw];
            zzgz zzgzVarZzt = zzgz.zzt(bArr);
            zzbv(zzgzVarZzt);
            zzgzVarZzt.zzC();
            return new zzgq(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] zzbp() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzgz zzgzVarZzt = zzgz.zzt(bArr);
            zzbv(zzgzVarZzt);
            zzgzVarZzt.zzC();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    int zzbq() {
        throw null;
    }

    void zzbr(int i) {
        throw null;
    }
}
