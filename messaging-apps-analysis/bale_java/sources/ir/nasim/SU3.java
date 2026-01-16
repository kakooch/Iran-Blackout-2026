package ir.nasim;

import ir.nasim.OU3;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes8.dex */
final class SU3 implements OU3 {
    private final Matcher a;
    private final CharSequence b;
    private final NU3 c;
    private List d;

    public static final class a extends AbstractC11442d1 {
        a() {
        }

        public /* bridge */ int C(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int E(String str) {
            return super.lastIndexOf(str);
        }

        @Override // ir.nasim.G0, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(String str) {
            return super.contains(str);
        }

        @Override // ir.nasim.G0
        public int getSize() {
            return SU3.this.f().groupCount() + 1;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return C((String) obj);
            }
            return -1;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String get(int i) {
            String strGroup = SU3.this.f().group(i);
            return strGroup == null ? "" : strGroup;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return E((String) obj);
            }
            return -1;
        }
    }

    public static final class b extends G0 implements NU3 {

        static final class a extends AbstractC8614Ws3 implements UA2 {
            a() {
                super(1);
            }

            public final MU3 a(int i) {
                return b.this.get(i);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        b() {
        }

        @Override // ir.nasim.G0, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof MU3) {
                return f((MU3) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(MU3 mu3) {
            return super.contains(mu3);
        }

        @Override // ir.nasim.NU3
        public MU3 get(int i) {
            C24411ya3 c24411ya3H = AbstractC22511vM5.h(SU3.this.f(), i);
            if (c24411ya3H.f().intValue() < 0) {
                return null;
            }
            String strGroup = SU3.this.f().group(i);
            AbstractC13042fc3.h(strGroup, "group(...)");
            return new MU3(strGroup, c24411ya3H);
        }

        @Override // ir.nasim.G0
        public int getSize() {
            return SU3.this.f().groupCount() + 1;
        }

        @Override // ir.nasim.G0, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC11342cq6.C(AbstractC15401jX0.g0(AbstractC10360bX0.n(this)), new a()).iterator();
        }
    }

    public SU3(Matcher matcher, CharSequence charSequence) {
        AbstractC13042fc3.i(matcher, "matcher");
        AbstractC13042fc3.i(charSequence, "input");
        this.a = matcher;
        this.b = charSequence;
        this.c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MatchResult f() {
        return this.a;
    }

    @Override // ir.nasim.OU3
    public OU3.b a() {
        return OU3.a.a(this);
    }

    @Override // ir.nasim.OU3
    public List b() {
        if (this.d == null) {
            this.d = new a();
        }
        List list = this.d;
        AbstractC13042fc3.f(list);
        return list;
    }

    @Override // ir.nasim.OU3
    public C24411ya3 c() {
        return AbstractC22511vM5.g(f());
    }

    @Override // ir.nasim.OU3
    public NU3 d() {
        return this.c;
    }

    @Override // ir.nasim.OU3
    public String getValue() {
        String strGroup = f().group();
        AbstractC13042fc3.h(strGroup, "group(...)");
        return strGroup;
    }

    @Override // ir.nasim.OU3
    public OU3 next() {
        int iEnd = f().end() + (f().end() == f().start() ? 1 : 0);
        if (iEnd > this.b.length()) {
            return null;
        }
        Matcher matcher = this.a.pattern().matcher(this.b);
        AbstractC13042fc3.h(matcher, "matcher(...)");
        return AbstractC22511vM5.e(matcher, iEnd, this.b);
    }
}
