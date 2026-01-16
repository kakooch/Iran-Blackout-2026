package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.vD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22425vD0 {
    public static int a(int i, int i2, boolean z) {
        int i3 = z ? ((i2 - i) + 360) % 360 : (i2 + i) % 360;
        if (PI3.h("CameraOrientationUtil")) {
            PI3.a("CameraOrientationUtil", String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)));
        }
        return i3;
    }

    public static int b(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
        }
        if (i == 3) {
            return 270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i);
    }
}
