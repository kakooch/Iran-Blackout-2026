package ir.nasim;

import androidx.camera.core.impl.D;

/* renamed from: ir.nasim.Ak7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3333Ak7 {

    /* renamed from: ir.nasim.Ak7$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[D.b.values().length];
            a = iArr;
            try {
                iArr[D.b.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[D.b.VIDEO_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[D.b.STREAM_SHARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[D.b.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[D.b.IMAGE_ANALYSIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int a(D.b bVar, int i) {
        int i2 = a.a[bVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? 1 : 3 : i == 2 ? 5 : 2;
    }

    public static int b(D.b bVar, int i) {
        int i2 = a.a[bVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? 1 : 3 : i == 2 ? 5 : 1;
    }
}
