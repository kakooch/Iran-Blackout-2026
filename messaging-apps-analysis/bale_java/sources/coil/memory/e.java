package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import ir.nasim.AbstractC10667c;
import ir.nasim.C17660nL3;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e implements g {
    private final h a;
    private final b b;

    private static final class a {
        private final Bitmap a;
        private final Map b;
        private final int c;

        public a(Bitmap bitmap, Map map, int i) {
            this.a = bitmap;
            this.b = map;
            this.c = i;
        }

        public final Bitmap a() {
            return this.a;
        }

        public final Map b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }
    }

    public static final class b extends C17660nL3 {
        final /* synthetic */ e j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, e eVar) {
            super(i);
            this.j = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.C17660nL3
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void b(boolean z, MemoryCache.Key key, a aVar, a aVar2) {
            this.j.a.c(key, aVar.a(), aVar.b(), aVar.c());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.C17660nL3
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public int j(MemoryCache.Key key, a aVar) {
            return aVar.c();
        }
    }

    public e(int i, h hVar) {
        this.a = hVar;
        this.b = new b(i, this);
    }

    @Override // coil.memory.g
    public void a(int i) {
        if (i >= 40) {
            e();
        } else {
            if (10 > i || i >= 20) {
                return;
            }
            this.b.l(g() / 2);
        }
    }

    @Override // coil.memory.g
    public MemoryCache.b b(MemoryCache.Key key) {
        a aVar = (a) this.b.d(key);
        if (aVar != null) {
            return new MemoryCache.b(aVar.a(), aVar.b());
        }
        return null;
    }

    @Override // coil.memory.g
    public void c(MemoryCache.Key key, Bitmap bitmap, Map map) {
        int iA = AbstractC10667c.a(bitmap);
        if (iA <= f()) {
            this.b.f(key, new a(bitmap, map, iA));
        } else {
            this.b.g(key);
            this.a.c(key, bitmap, map, iA);
        }
    }

    public void e() {
        this.b.c();
    }

    public int f() {
        return this.b.e();
    }

    public int g() {
        return this.b.i();
    }
}
