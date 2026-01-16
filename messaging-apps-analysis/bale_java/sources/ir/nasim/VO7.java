package ir.nasim;

/* loaded from: classes.dex */
public abstract class VO7 {
    private static final InterfaceC11600dH4 a = new UO7(InterfaceC11600dH4.a.a(), 0, 0);

    public static final C18600ov7 c(QY7 qy7, C13245fu c13245fu) {
        C18600ov7 c18600ov7A = qy7.a(c13245fu);
        f(c18600ov7A, c13245fu.length(), 0, 2, null);
        return new C18600ov7(c18600ov7A.b(), new UO7(c18600ov7A.a(), c13245fu.length(), c18600ov7A.b().length()));
    }

    public static final InterfaceC11600dH4 d() {
        return a;
    }

    public static final void e(C18600ov7 c18600ov7, int i, int i2) {
        int length = c18600ov7.b().length();
        int iMin = Math.min(i, i2);
        for (int i3 = 0; i3 < iMin; i3++) {
            g(c18600ov7.a().b(i3), length, i3);
        }
        g(c18600ov7.a().b(i), length, i);
        int iMin2 = Math.min(length, i2);
        for (int i4 = 0; i4 < iMin2; i4++) {
            h(c18600ov7.a().a(i4), i, i4);
        }
        h(c18600ov7.a().a(length), i, length);
    }

    public static /* synthetic */ void f(C18600ov7 c18600ov7, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 100;
        }
        e(c18600ov7, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        P73.c("OffsetMapping.originalToTransformed returned invalid mapping: " + i3 + " -> " + i + " is not in range of transformed text [0, " + i2 + ']');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        P73.c("OffsetMapping.transformedToOriginal returned invalid mapping: " + i3 + " -> " + i + " is not in range of original text [0, " + i2 + ']');
    }
}
