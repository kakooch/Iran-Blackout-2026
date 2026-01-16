package ir.nasim;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class NW0 {
    public static final NW0 a = new NW0();

    private NW0() {
    }

    public final void a(byte[] bArr, Collection collection) {
        AbstractC13042fc3.i(bArr, "bytes");
        AbstractC13042fc3.i(collection, "collection");
        int length = bArr.length / 4;
        for (int i = 0; i < length; i++) {
            int i2 = i * 4;
            collection.add(Integer.valueOf((bArr[i2] & 255) | (bArr[i2 + 3] << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8)));
        }
    }

    public final byte[] b(Collection collection) {
        AbstractC13042fc3.i(collection, "collection");
        byte[] bArr = new byte[collection.size() * 4];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            int iIntValue = ((Number) it.next()).intValue();
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[(i * 4) + i3] = (byte) (iIntValue >> (i3 * 8));
            }
            i = i2;
        }
        return bArr;
    }
}
