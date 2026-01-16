package ir.nasim.features.libphotovideo.Paint.Views;

/* loaded from: classes3.dex */
public class a {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private InterfaceC1172a g;

    /* renamed from: ir.nasim.features.libphotovideo.Paint.Views.a$a, reason: collision with other inner class name */
    public interface InterfaceC1172a {
        void a(a aVar);

        void b(a aVar);
    }

    public a(InterfaceC1172a interfaceC1172a) {
        this.g = interfaceC1172a;
    }

    private float a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float degrees = ((float) Math.toDegrees(((float) Math.atan2(f2 - f4, f - f3)) - ((float) Math.atan2(f6 - f8, f5 - f7)))) % 360.0f;
        if (degrees < -180.0f) {
            degrees += 360.0f;
        }
        return degrees > 180.0f ? degrees - 360.0f : degrees;
    }

    public float b() {
        return this.e;
    }

    public float c() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(android.view.MotionEvent r15) {
        /*
            r14 = this;
            int r0 = r15.getPointerCount()
            r1 = 0
            r2 = 2
            if (r0 == r2) goto L9
            return r1
        L9:
            int r0 = r15.getActionMasked()
            r3 = 1
            if (r0 == 0) goto L61
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == r3) goto L5e
            if (r0 == r2) goto L23
            r2 = 3
            if (r0 == r2) goto L5e
            r2 = 5
            if (r0 == r2) goto L61
            r15 = 6
            if (r0 == r15) goto L20
            goto L79
        L20:
            r14.f = r4
            goto L79
        L23:
            float r12 = r15.getX(r1)
            float r13 = r15.getY(r1)
            float r10 = r15.getX(r3)
            float r11 = r15.getY(r3)
            float r6 = r14.a
            float r7 = r14.b
            float r8 = r14.c
            float r9 = r14.d
            r5 = r14
            float r15 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13)
            r14.e = r15
            ir.nasim.features.libphotovideo.Paint.Views.a$a r15 = r14.g
            if (r15 == 0) goto L79
            float r15 = r14.f
            boolean r15 = java.lang.Float.isNaN(r15)
            if (r15 == 0) goto L58
            float r15 = r14.e
            r14.f = r15
            ir.nasim.features.libphotovideo.Paint.Views.a$a r15 = r14.g
            r15.a(r14)
            goto L79
        L58:
            ir.nasim.features.libphotovideo.Paint.Views.a$a r15 = r14.g
            r15.b(r14)
            goto L79
        L5e:
            r14.f = r4
            goto L79
        L61:
            float r0 = r15.getX(r1)
            r14.c = r0
            float r0 = r15.getY(r1)
            r14.d = r0
            float r0 = r15.getX(r3)
            r14.a = r0
            float r15 = r15.getY(r3)
            r14.b = r15
        L79:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.libphotovideo.Paint.Views.a.d(android.view.MotionEvent):boolean");
    }
}
