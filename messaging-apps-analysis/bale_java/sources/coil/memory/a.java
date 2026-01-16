package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import ir.nasim.AbstractC10667c;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements g {
    private final h a;

    public a(h hVar) {
        this.a = hVar;
    }

    @Override // coil.memory.g
    public void a(int i) {
    }

    @Override // coil.memory.g
    public MemoryCache.b b(MemoryCache.Key key) {
        return null;
    }

    @Override // coil.memory.g
    public void c(MemoryCache.Key key, Bitmap bitmap, Map map) {
        this.a.c(key, bitmap, map, AbstractC10667c.a(bitmap));
    }
}
