package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import java.util.ArrayList;
import java.util.Comparator;

/* renamed from: ir.nasim.n27, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C17485n27 {
    private static final Size b = new Size(320, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER);
    private static final Comparator c = new C15686k01();
    private final RepeatingStreamConstraintForVideoRecordingQuirk a = (RepeatingStreamConstraintForVideoRecordingQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(RepeatingStreamConstraintForVideoRecordingQuirk.class);

    public Size[] a(Size[] sizeArr) {
        if (this.a == null || !RepeatingStreamConstraintForVideoRecordingQuirk.c()) {
            return sizeArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (c.compare(size, b) >= 0) {
                arrayList.add(size);
            }
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
