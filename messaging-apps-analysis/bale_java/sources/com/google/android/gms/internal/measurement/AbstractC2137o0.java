package com.google.android.gms.internal.measurement;

import ir.nasim.InterfaceC23996xr8;
import ir.nasim.Qr8;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.o0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2137o0 implements Qr8 {
    protected int zzb = 0;

    protected static void f(Iterable iterable, List list) {
        R0.e(iterable);
        if (iterable instanceof InterfaceC23996xr8) {
            List listK = ((InterfaceC23996xr8) iterable).k();
            InterfaceC23996xr8 interfaceC23996xr8 = (InterfaceC23996xr8) list;
            int size = list.size();
            for (Object obj : listK) {
                if (obj == null) {
                    String str = "Element at index " + (interfaceC23996xr8.size() - size) + " is null.";
                    int size2 = interfaceC23996xr8.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        interfaceC23996xr8.remove(size2);
                    }
                } else if (obj instanceof A0) {
                    interfaceC23996xr8.w1((A0) obj);
                } else {
                    interfaceC23996xr8.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof k1) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    abstract int a(o1 o1Var);

    public final byte[] g() {
        try {
            byte[] bArr = new byte[d()];
            E0 e0C = E0.c(bArr);
            b(e0C);
            e0C.d();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
