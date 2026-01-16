package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache;
import ir.nasim.AbstractC10667c;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16865m;
import ir.nasim.AbstractC17456n;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC18638p;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.C19525qV5;
import ir.nasim.C21144tB1;
import ir.nasim.ED1;
import ir.nasim.EnumC14254hc6;
import ir.nasim.EnumC21699tz1;
import ir.nasim.FT1;
import ir.nasim.I07;
import ir.nasim.II3;
import ir.nasim.IL4;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC3955Db3;
import ir.nasim.InterfaceC8217Va2;
import ir.nasim.PD6;
import ir.nasim.Q82;
import ir.nasim.W23;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {
    public static final a d = new a(null);
    private final InterfaceC18663p23 a;
    private final C19525qV5 b;
    private final II3 c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public c(InterfaceC18663p23 interfaceC18663p23, C19525qV5 c19525qV5, II3 ii3) {
        this.a = interfaceC18663p23;
        this.b = c19525qV5;
        this.c = ii3;
    }

    private final String b(MemoryCache.b bVar) {
        Object obj = bVar.b().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private final boolean d(MemoryCache.b bVar) {
        Object obj = bVar.b().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean e(W23 w23, MemoryCache.Key key, MemoryCache.b bVar, PD6 pd6, EnumC14254hc6 enumC14254hc6) {
        String str;
        boolean zD = d(bVar);
        if (AbstractC17456n.b(pd6)) {
            if (!zD) {
                return true;
            }
            II3 ii3 = this.c;
            if (ii3 != null && ii3.a() <= 3) {
                ii3.b("MemoryCacheService", 3, w23.m() + ": Requested original size, but cached image is sampled.", null);
            }
            return false;
        }
        String str2 = (String) key.getExtras().get("coil#transformation_size");
        if (str2 != null) {
            return AbstractC13042fc3.d(str2, pd6.toString());
        }
        int width = bVar.a().getWidth();
        int height = bVar.a().getHeight();
        FT1 ft1D = pd6.d();
        int i = ft1D instanceof FT1.a ? ((FT1.a) ft1D).a : Integer.MAX_VALUE;
        FT1 ft1C = pd6.c();
        int i2 = ft1C instanceof FT1.a ? ((FT1.a) ft1C).a : Integer.MAX_VALUE;
        double dC = C21144tB1.c(width, height, i, i2, enumC14254hc6);
        boolean zA = AbstractC16865m.a(w23);
        if (zA) {
            double dG = AbstractC23053wG5.g(dC, 1.0d);
            str = "MemoryCacheService";
            if (Math.abs(i - (width * dG)) <= 1.0d || Math.abs(i2 - (dG * height)) <= 1.0d) {
                return true;
            }
        } else {
            str = "MemoryCacheService";
            if ((AbstractC18638p.s(i) || Math.abs(i - width) <= 1) && (AbstractC18638p.s(i2) || Math.abs(i2 - height) <= 1)) {
                return true;
            }
        }
        if (dC != 1.0d && !zA) {
            II3 ii32 = this.c;
            if (ii32 == null || ii32.a() > 3) {
                return false;
            }
            ii32.b(str, 3, w23.m() + ": Cached image's request size (" + width + ", " + height + ") does not exactly match the requested size (" + pd6.d() + ", " + pd6.c() + ", " + enumC14254hc6 + ").", null);
            return false;
        }
        String str3 = str;
        if (dC <= 1.0d || !zD) {
            return true;
        }
        II3 ii33 = this.c;
        if (ii33 == null || ii33.a() > 3) {
            return false;
        }
        ii33.b(str3, 3, w23.m() + ": Cached image's request size (" + width + ", " + height + ") is smaller than the requested size (" + pd6.d() + ", " + pd6.c() + ", " + enumC14254hc6 + ").", null);
        return false;
    }

    public final MemoryCache.b a(W23 w23, MemoryCache.Key key, PD6 pd6, EnumC14254hc6 enumC14254hc6) {
        if (!w23.C().j()) {
            return null;
        }
        MemoryCache memoryCacheE = this.a.e();
        MemoryCache.b bVarB = memoryCacheE != null ? memoryCacheE.b(key) : null;
        if (bVarB == null || !c(w23, key, bVarB, pd6, enumC14254hc6)) {
            return null;
        }
        return bVarB;
    }

    public final boolean c(W23 w23, MemoryCache.Key key, MemoryCache.b bVar, PD6 pd6, EnumC14254hc6 enumC14254hc6) {
        if (this.b.c(w23, AbstractC10667c.c(bVar.a()))) {
            return e(w23, key, bVar, pd6, enumC14254hc6);
        }
        II3 ii3 = this.c;
        if (ii3 == null || ii3.a() > 3) {
            return false;
        }
        ii3.b("MemoryCacheService", 3, w23.m() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", null);
        return false;
    }

    public final MemoryCache.Key f(W23 w23, Object obj, IL4 il4, InterfaceC8217Va2 interfaceC8217Va2) {
        MemoryCache.Key keyB = w23.B();
        if (keyB != null) {
            return keyB;
        }
        interfaceC8217Va2.q(w23, obj);
        String strF = this.a.getComponents().f(obj, il4);
        interfaceC8217Va2.j(w23, strF);
        if (strF == null) {
            return null;
        }
        List listO = w23.O();
        Map mapH = w23.E().h();
        if (listO.isEmpty() && mapH.isEmpty()) {
            return new MemoryCache.Key(strF, null, 2, null);
        }
        Map mapA = AbstractC20051rO3.A(mapH);
        if (!listO.isEmpty()) {
            List listO2 = w23.O();
            if (listO2.size() > 0) {
                AbstractC18350oW3.a(listO2.get(0));
                StringBuilder sb = new StringBuilder();
                sb.append("coil#transformation_");
                sb.append(0);
                throw null;
            }
            mapA.put("coil#transformation_size", il4.o().toString());
        }
        return new MemoryCache.Key(strF, mapA);
    }

    public final I07 g(InterfaceC3955Db3.a aVar, W23 w23, MemoryCache.Key key, MemoryCache.b bVar) {
        return new I07(new BitmapDrawable(w23.l().getResources(), bVar.a()), w23, EnumC21699tz1.a, key, b(bVar), d(bVar), AbstractC18638p.t(aVar));
    }

    public final boolean h(MemoryCache.Key key, W23 w23, Q82.b bVar) {
        MemoryCache memoryCacheE;
        Bitmap bitmap;
        if (w23.C().p() && (memoryCacheE = this.a.e()) != null && key != null) {
            Drawable drawableE = bVar.e();
            BitmapDrawable bitmapDrawable = drawableE instanceof BitmapDrawable ? (BitmapDrawable) drawableE : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(bVar.f()));
                String strD = bVar.d();
                if (strD != null) {
                    linkedHashMap.put("coil#disk_cache_key", strD);
                }
                memoryCacheE.c(key, new MemoryCache.b(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }
}
