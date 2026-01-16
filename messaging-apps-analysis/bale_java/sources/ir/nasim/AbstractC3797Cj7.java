package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Cj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3797Cj7 {
    public static String a(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return AbstractC6059Lz5.a("|", arrayList);
    }

    public static boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
