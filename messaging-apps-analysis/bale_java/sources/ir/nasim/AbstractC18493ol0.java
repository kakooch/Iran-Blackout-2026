package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.ol0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18493ol0 {
    public static C18818pI6 a(C9207Yy1 c9207Yy1) throws IOException {
        C18818pI6 c18818pI6 = new C18818pI6();
        while (!c9207Yy1.a()) {
            long jK = c9207Yy1.k();
            int i = (int) (jK >> 3);
            int i2 = (int) (jK & 7);
            if (i2 == 0) {
                b(i, Long.valueOf(c9207Yy1.k()), c18818pI6);
            } else if (i2 == 2) {
                b(i, c9207Yy1.c((int) c9207Yy1.k()), c18818pI6);
            } else if (i2 == 1) {
                b(i, Long.valueOf(c9207Yy1.e()), c18818pI6);
            } else {
                if (i2 != 5) {
                    throw new IOException("Unknown Wire Type #" + i2);
                }
                b(i, Long.valueOf(c9207Yy1.j()), c18818pI6);
            }
        }
        return c18818pI6;
    }

    private static void b(int i, Object obj, C18818pI6 c18818pI6) {
        if (c18818pI6.d(i) == null) {
            c18818pI6.i(i, obj);
            return;
        }
        if (c18818pI6.d(i) instanceof List) {
            ((List) c18818pI6.d(i)).add(obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c18818pI6.d(i));
        arrayList.add(obj);
        c18818pI6.i(i, arrayList);
    }
}
