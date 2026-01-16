package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.util.Map;

/* loaded from: classes2.dex */
public interface h {
    void a(int i);

    MemoryCache.b b(MemoryCache.Key key);

    void c(MemoryCache.Key key, Bitmap bitmap, Map map, int i);
}
