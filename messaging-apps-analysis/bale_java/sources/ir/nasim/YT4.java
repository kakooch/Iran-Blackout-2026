package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
public abstract class YT4 {
    private final C9245Zc3 a = new C9245Zc3(c.e, null, 2, 0 == true ? 1 : 0);

    public static abstract class a {
        public static final b c = new b(null);
        private final int a;
        private final boolean b;

        /* renamed from: ir.nasim.YT4$a$a, reason: collision with other inner class name */
        public static final class C0790a extends a {
            private final Object d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0790a(Object obj, int i, boolean z) {
                super(i, z, null);
                AbstractC13042fc3.i(obj, "key");
                this.d = obj;
            }

            @Override // ir.nasim.YT4.a
            public Object a() {
                return this.d;
            }
        }

        public static final class b {

            /* renamed from: ir.nasim.YT4$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0791a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC16433lG3.values().length];
                    try {
                        iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC16433lG3.PREPEND.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC16433lG3.APPEND.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            private b() {
            }

            public final a a(EnumC16433lG3 enumC16433lG3, Object obj, int i, boolean z) {
                AbstractC13042fc3.i(enumC16433lG3, "loadType");
                int i2 = C0791a.a[enumC16433lG3.ordinal()];
                if (i2 == 1) {
                    return new d(obj, i, z);
                }
                if (i2 == 2) {
                    if (obj != null) {
                        return new c(obj, i, z);
                    }
                    throw new IllegalArgumentException("key cannot be null for prepend".toString());
                }
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (obj != null) {
                    return new C0790a(obj, i, z);
                }
                throw new IllegalArgumentException("key cannot be null for append".toString());
            }

            public /* synthetic */ b(ED1 ed1) {
                this();
            }
        }

        public static final class c extends a {
            private final Object d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Object obj, int i, boolean z) {
                super(i, z, null);
                AbstractC13042fc3.i(obj, "key");
                this.d = obj;
            }

            @Override // ir.nasim.YT4.a
            public Object a() {
                return this.d;
            }
        }

        public static final class d extends a {
            private final Object d;

            public d(Object obj, int i, boolean z) {
                super(i, z, null);
                this.d = obj;
            }

            @Override // ir.nasim.YT4.a
            public Object a() {
                return this.d;
            }
        }

        public /* synthetic */ a(int i, boolean z, ED1 ed1) {
            this(i, z);
        }

        public abstract Object a();

        public final int b() {
            return this.a;
        }

        private a(int i, boolean z) {
            this.a = i;
            this.b = z;
        }
    }

    public static abstract class b {

        public static final class a extends b {
            private final Throwable a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Throwable th) {
                super(null);
                AbstractC13042fc3.i(th, "throwable");
                this.a = th;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
            }

            public final Throwable f() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return AbstractC16016kZ6.i("LoadResult.Error(\n                    |   throwable: " + this.a + "\n                    |) ", null, 1, null);
            }
        }

        /* renamed from: ir.nasim.YT4$b$b, reason: collision with other inner class name */
        public static final class C0792b extends b {
            public C0792b() {
                super(null);
            }

            public String toString() {
                return "LoadResult.Invalid";
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }

        public static final class c extends b implements Iterable, InterfaceC17915nm3 {
            public static final a f = new a(null);
            private static final c g = new c(AbstractC10360bX0.m(), null, null, 0, 0);
            private final List a;
            private final Object b;
            private final Object c;
            private final int d;
            private final int e;

            public static final class a {
                private a() {
                }

                public /* synthetic */ a(ED1 ed1) {
                    this();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, Object obj, Object obj2, int i, int i2) {
                super(null);
                AbstractC13042fc3.i(list, "data");
                this.a = list;
                this.b = obj;
                this.c = obj2;
                this.d = i;
                this.e = i2;
                if (i != Integer.MIN_VALUE && i < 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
                }
                if (i2 != Integer.MIN_VALUE && i2 < 0) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && this.d == cVar.d && this.e == cVar.e;
            }

            public final List f() {
                return this.a;
            }

            public final int h() {
                return this.e;
            }

            public int hashCode() {
                int iHashCode = this.a.hashCode() * 31;
                Object obj = this.b;
                int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
                Object obj2 = this.c;
                return ((((iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
            }

            public final int i() {
                return this.d;
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return this.a.listIterator();
            }

            public final Object j() {
                return this.c;
            }

            public final Object o() {
                return this.b;
            }

            public String toString() {
                return AbstractC16016kZ6.i("LoadResult.Page(\n                    |   data size: " + this.a.size() + "\n                    |   first Item: " + AbstractC15401jX0.s0(this.a) + "\n                    |   last Item: " + AbstractC15401jX0.F0(this.a) + "\n                    |   nextKey: " + this.c + "\n                    |   prevKey: " + this.b + "\n                    |   itemsBefore: " + this.d + "\n                    |   itemsAfter: " + this.e + "\n                    |) ", null, 1, null);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public c(List list, Object obj, Object obj2) {
                this(list, obj, obj2, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION);
                AbstractC13042fc3.i(list, "data");
            }
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final void a(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "it");
            sa2.invoke();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SA2) obj);
            return C19938rB7.a;
        }
    }

    public final boolean a() {
        return this.a.a();
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public abstract Object d(ZT4 zt4);

    public final void e() {
        if (this.a.b()) {
            XT4 xt4 = XT4.a;
            if (xt4.a(3)) {
                xt4.b(3, "Invalidated PagingSource " + this, null);
            }
        }
    }

    public abstract Object f(a aVar, InterfaceC20295rm1 interfaceC20295rm1);

    public final void g(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onInvalidatedCallback");
        this.a.c(sa2);
    }

    public final void h(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onInvalidatedCallback");
        this.a.d(sa2);
    }
}
