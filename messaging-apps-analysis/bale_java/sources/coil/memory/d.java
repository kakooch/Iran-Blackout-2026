package coil.memory;

import coil.memory.MemoryCache;
import ir.nasim.AbstractC12074e;

/* loaded from: classes2.dex */
public final class d implements MemoryCache {
    private final g a;
    private final h b;

    public d(g gVar, h hVar) {
        this.a = gVar;
        this.b = hVar;
    }

    @Override // coil.memory.MemoryCache
    public void a(int i) {
        this.a.a(i);
        this.b.a(i);
    }

    @Override // coil.memory.MemoryCache
    public MemoryCache.b b(MemoryCache.Key key) {
        MemoryCache.b bVarB = this.a.b(key);
        return bVarB == null ? this.b.b(key) : bVarB;
    }

    @Override // coil.memory.MemoryCache
    public void c(MemoryCache.Key key, MemoryCache.b bVar) {
        this.a.c(MemoryCache.Key.b(key, null, AbstractC12074e.b(key.getExtras()), 1, null), bVar.a(), AbstractC12074e.b(bVar.b()));
    }
}
