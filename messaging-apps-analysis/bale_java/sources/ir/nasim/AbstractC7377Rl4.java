package ir.nasim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: ir.nasim.Rl4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC7377Rl4 {

    /* renamed from: ir.nasim.Rl4$a */
    class a extends e {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // ir.nasim.AbstractC7377Rl4.e
        Map c() {
            return AbstractC6343Ne5.c(this.a);
        }
    }

    /* renamed from: ir.nasim.Rl4$b */
    class b extends e {
        final /* synthetic */ Comparator a;

        b(Comparator comparator) {
            this.a = comparator;
        }

        @Override // ir.nasim.AbstractC7377Rl4.e
        Map c() {
            return new TreeMap(this.a);
        }
    }

    /* renamed from: ir.nasim.Rl4$c */
    private static final class c implements Q17, Serializable {
        private final int a;

        c(int i) {
            this.a = MW0.b(i, "expectedValuesPerKey");
        }

        @Override // ir.nasim.Q17
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.a);
        }
    }

    /* renamed from: ir.nasim.Rl4$d */
    public static abstract class d extends AbstractC7377Rl4 {
        d() {
            super(null);
        }

        public abstract TB3 e();
    }

    /* renamed from: ir.nasim.Rl4$e */
    public static abstract class e {

        /* renamed from: ir.nasim.Rl4$e$a */
        class a extends d {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // ir.nasim.AbstractC7377Rl4.d
            public TB3 e() {
                return AbstractC7611Sl4.b(e.this.c(), new c(this.a));
            }
        }

        e() {
        }

        public d a() {
            return b(2);
        }

        public d b(int i) {
            MW0.b(i, "expectedValuesPerKey");
            return new a(i);
        }

        abstract Map c();
    }

    private AbstractC7377Rl4() {
    }

    public static e a() {
        return b(8);
    }

    public static e b(int i) {
        MW0.b(i, "expectedKeys");
        return new a(i);
    }

    public static e c() {
        return d(UL4.b());
    }

    public static e d(Comparator comparator) {
        AbstractC4029Dj5.j(comparator);
        return new b(comparator);
    }

    /* synthetic */ AbstractC7377Rl4(a aVar) {
        this();
    }
}
