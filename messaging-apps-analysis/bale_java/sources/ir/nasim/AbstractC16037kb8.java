package ir.nasim;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.kb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16037kb8 {
    private UUID a;
    private C17810nb8 b;
    private Set c;

    /* renamed from: ir.nasim.kb8$a */
    public static abstract class a {
        C17810nb8 c;
        Class e;
        boolean a = false;
        Set d = new HashSet();
        UUID b = UUID.randomUUID();

        a(Class cls) {
            this.e = cls;
            this.c = new C17810nb8(this.b.toString(), cls.getName());
            a(cls.getName());
        }

        public final a a(String str) {
            this.d.add(str);
            return d();
        }

        public final AbstractC16037kb8 b() {
            AbstractC16037kb8 abstractC16037kb8C = c();
            C18424oe1 c18424oe1 = this.c.j;
            boolean z = c18424oe1.e() || c18424oe1.f() || c18424oe1.g() || c18424oe1.h();
            C17810nb8 c17810nb8 = this.c;
            if (c17810nb8.q) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (c17810nb8.g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.b = UUID.randomUUID();
            C17810nb8 c17810nb82 = new C17810nb8(this.c);
            this.c = c17810nb82;
            c17810nb82.a = this.b.toString();
            return abstractC16037kb8C;
        }

        abstract AbstractC16037kb8 c();

        abstract a d();

        public final a e(EnumC9756aW enumC9756aW, long j, TimeUnit timeUnit) {
            this.a = true;
            C17810nb8 c17810nb8 = this.c;
            c17810nb8.l = enumC9756aW;
            c17810nb8.e(timeUnit.toMillis(j));
            return d();
        }

        public final a f(C18424oe1 c18424oe1) {
            this.c.j = c18424oe1;
            return d();
        }

        public a g(long j, TimeUnit timeUnit) {
            this.c.g = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.c.g) {
                return d();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final a h(androidx.work.b bVar) {
            this.c.e = bVar;
            return d();
        }
    }

    protected AbstractC16037kb8(UUID uuid, C17810nb8 c17810nb8, Set set) {
        this.a = uuid;
        this.b = c17810nb8;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }

    public Set b() {
        return this.c;
    }

    public C17810nb8 c() {
        return this.b;
    }
}
