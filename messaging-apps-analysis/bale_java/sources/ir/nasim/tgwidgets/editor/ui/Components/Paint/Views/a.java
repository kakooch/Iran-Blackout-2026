package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

/* loaded from: classes7.dex */
public class a {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private InterfaceC1586a g;

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a$a, reason: collision with other inner class name */
    public interface InterfaceC1586a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);
    }

    public a(InterfaceC1586a interfaceC1586a) {
        this.g = interfaceC1586a;
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = r14.getPointerCount()
            r1 = 0
            r2 = 2
            if (r0 == r2) goto L9
            return r1
        L9:
            int r0 = r14.getActionMasked()
            r3 = 1
            if (r0 == 0) goto L68
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == r3) goto L65
            if (r0 == r2) goto L2a
            r2 = 3
            if (r0 == r2) goto L65
            r2 = 5
            if (r0 == r2) goto L68
            r14 = 6
            if (r0 == r14) goto L20
            goto L80
        L20:
            r13.f = r4
            ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a$a r14 = r13.g
            if (r14 == 0) goto L80
            r14.b(r13)
            goto L80
        L2a:
            float r11 = r14.getX(r1)
            float r12 = r14.getY(r1)
            float r9 = r14.getX(r3)
            float r10 = r14.getY(r3)
            float r5 = r13.a
            float r6 = r13.b
            float r7 = r13.c
            float r8 = r13.d
            r4 = r13
            float r14 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12)
            r13.e = r14
            ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a$a r14 = r13.g
            if (r14 == 0) goto L80
            float r14 = r13.f
            boolean r14 = java.lang.Float.isNaN(r14)
            if (r14 == 0) goto L5f
            float r14 = r13.e
            r13.f = r14
            ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a$a r14 = r13.g
            r14.c(r13)
            goto L80
        L5f:
            ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a$a r14 = r13.g
            r14.a(r13)
            goto L80
        L65:
            r13.f = r4
            goto L80
        L68:
            float r0 = r14.getX(r1)
            r13.c = r0
            float r0 = r14.getY(r1)
            r13.d = r0
            float r0 = r14.getX(r3)
            r13.a = r0
            float r14 = r14.getY(r3)
            r13.b = r14
        L80:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a.d(android.view.MotionEvent):boolean");
    }
}
