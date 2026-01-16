package com.google.android.gms.internal.vision;

import ir.nasim.InterfaceC18561or8;
import ir.nasim.Yq8;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class D implements InterfaceC18561or8 {
    protected int zza = 0;

    protected static void a(Iterable iterable, List list) {
        AbstractC2184m0.d(iterable);
        if (iterable instanceof Yq8) {
            List listD = ((Yq8) iterable).d();
            Yq8 yq8 = (Yq8) list;
            int size = list.size();
            for (Object obj : listD) {
                if (obj == null) {
                    int size2 = yq8.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = yq8.size() - 1; size3 >= size; size3--) {
                        yq8.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof K) {
                    yq8.A1((K) obj);
                } else {
                    yq8.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof L0) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                int size5 = list.size() - size4;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(string2);
            }
            list.add(obj2);
        }
    }

    abstract void c(int i);

    public final byte[] d() {
        try {
            byte[] bArr = new byte[f()];
            zzii zziiVarD = zzii.d(bArr);
            k(zziiVarD);
            zziiVarD.J();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    abstract int e();
}
