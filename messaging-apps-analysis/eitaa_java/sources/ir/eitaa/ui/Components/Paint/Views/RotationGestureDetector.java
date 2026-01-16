package ir.eitaa.ui.Components.Paint.Views;

/* loaded from: classes3.dex */
public class RotationGestureDetector {
    private float angle;
    private float fX;
    private float fY;
    private OnRotationGestureListener mListener;
    private float sX;
    private float sY;
    private float startAngle;

    public interface OnRotationGestureListener {
        void onRotation(RotationGestureDetector rotationDetector);

        void onRotationBegin(RotationGestureDetector rotationDetector);

        void onRotationEnd(RotationGestureDetector rotationDetector);
    }

    public float getAngle() {
        return this.angle;
    }

    public float getStartAngle() {
        return this.startAngle;
    }

    public RotationGestureDetector(OnRotationGestureListener listener) {
        this.mListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = r14.getPointerCount()
            r1 = 2
            r2 = 0
            if (r0 == r1) goto L9
            return r2
        L9:
            int r0 = r14.getActionMasked()
            r3 = 1
            if (r0 == 0) goto L68
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == r3) goto L65
            if (r0 == r1) goto L2a
            r1 = 3
            if (r0 == r1) goto L65
            r1 = 5
            if (r0 == r1) goto L68
            r14 = 6
            if (r0 == r14) goto L20
            goto L80
        L20:
            r13.startAngle = r4
            ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector$OnRotationGestureListener r14 = r13.mListener
            if (r14 == 0) goto L80
            r14.onRotationEnd(r13)
            goto L80
        L2a:
            float r11 = r14.getX(r2)
            float r12 = r14.getY(r2)
            float r9 = r14.getX(r3)
            float r10 = r14.getY(r3)
            float r5 = r13.fX
            float r6 = r13.fY
            float r7 = r13.sX
            float r8 = r13.sY
            r4 = r13
            float r14 = r4.angleBetweenLines(r5, r6, r7, r8, r9, r10, r11, r12)
            r13.angle = r14
            ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector$OnRotationGestureListener r14 = r13.mListener
            if (r14 == 0) goto L80
            float r14 = r13.startAngle
            boolean r14 = java.lang.Float.isNaN(r14)
            if (r14 == 0) goto L5f
            float r14 = r13.angle
            r13.startAngle = r14
            ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector$OnRotationGestureListener r14 = r13.mListener
            r14.onRotationBegin(r13)
            goto L80
        L5f:
            ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector$OnRotationGestureListener r14 = r13.mListener
            r14.onRotation(r13)
            goto L80
        L65:
            r13.startAngle = r4
            goto L80
        L68:
            float r0 = r14.getX(r2)
            r13.sX = r0
            float r0 = r14.getY(r2)
            r13.sY = r0
            float r0 = r14.getX(r3)
            r13.fX = r0
            float r14 = r14.getY(r3)
            r13.fY = r14
        L80:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private float angleBetweenLines(float fX, float fY, float sX, float sY, float nfX, float nfY, float nsX, float nsY) {
        float degrees = ((float) Math.toDegrees(((float) Math.atan2(fY - sY, fX - sX)) - ((float) Math.atan2(nfY - nsY, nfX - nsX)))) % 360.0f;
        if (degrees < -180.0f) {
            degrees += 360.0f;
        }
        return degrees > 180.0f ? degrees - 360.0f : degrees;
    }
}
