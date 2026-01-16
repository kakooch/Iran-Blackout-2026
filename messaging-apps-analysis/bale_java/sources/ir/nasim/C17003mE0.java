package ir.nasim;

import android.hardware.Camera;

/* renamed from: ir.nasim.mE0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C17003mE0 {
    public final Camera a;
    public final int b;

    private C17003mE0(Camera camera, int i) {
        if (camera == null) {
            throw new NullPointerException("Camera cannot be null");
        }
        this.a = camera;
        this.b = i;
    }

    public static C17003mE0 a(Camera camera, int i) {
        if (camera == null) {
            return null;
        }
        return new C17003mE0(camera, i);
    }
}
