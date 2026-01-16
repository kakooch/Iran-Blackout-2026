package androidx.camera.core.impl;

import android.content.Context;

/* loaded from: classes.dex */
public interface D {
    public static final D a = new a();

    class a implements D {
        a() {
        }

        @Override // androidx.camera.core.impl.D
        public j a(b bVar, int i) {
            return null;
        }
    }

    public enum b {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE,
        STREAM_SHARING,
        METERING_REPEATING
    }

    public interface c {
        D a(Context context);
    }

    j a(b bVar, int i);
}
