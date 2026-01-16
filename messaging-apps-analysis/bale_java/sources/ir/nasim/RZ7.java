package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes6.dex */
public final class RZ7 {
    public static final RZ7 a = new RZ7();
    private static final HashMap b = new HashMap();
    public static final int c = 8;

    private RZ7() {
    }

    public final byte[] a(int i) {
        byte[] bArr;
        HashMap map = b;
        synchronized (map) {
            try {
                ArrayList arrayList = (ArrayList) map.get(Integer.valueOf(i));
                if (arrayList == null || (bArr = (byte[]) AbstractC13610gX0.M(arrayList)) == null) {
                    bArr = new byte[i];
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    public final void b(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "byteArray");
        HashMap map = b;
        synchronized (map) {
            try {
                Integer numValueOf = Integer.valueOf(bArr.length);
                Object arrayList = map.get(numValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(numValueOf, arrayList);
                }
                ((ArrayList) arrayList).add(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
