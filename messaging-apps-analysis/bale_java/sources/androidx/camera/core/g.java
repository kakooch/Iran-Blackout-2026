package androidx.camera.core;

import android.media.ImageReader;
import ir.nasim.O23;

/* loaded from: classes.dex */
public abstract class g {
    public static O23 a(int i, int i2, int i3, int i4) {
        return new d(ImageReader.newInstance(i, i2, i3, i4));
    }
}
