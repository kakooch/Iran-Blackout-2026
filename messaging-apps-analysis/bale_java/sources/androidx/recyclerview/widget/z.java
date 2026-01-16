package androidx.recyclerview.widget;

import ir.nasim.C21892uJ3;

/* loaded from: classes2.dex */
interface z {

    public static class a implements z {
        long a = 0;

        /* renamed from: androidx.recyclerview.widget.z$a$a, reason: collision with other inner class name */
        class C0115a implements d {
            private final C21892uJ3 a = new C21892uJ3();

            C0115a() {
            }

            @Override // androidx.recyclerview.widget.z.d
            public long a(long j) {
                Long lValueOf = (Long) this.a.f(j);
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(a.this.b());
                    this.a.l(j, lValueOf);
                }
                return lValueOf.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.z
        public d a() {
            return new C0115a();
        }

        long b() {
            long j = this.a;
            this.a = 1 + j;
            return j;
        }
    }

    public static class b implements z {
        private final d a = new a();

        class a implements d {
            a() {
            }

            @Override // androidx.recyclerview.widget.z.d
            public long a(long j) {
                return -1L;
            }
        }

        @Override // androidx.recyclerview.widget.z
        public d a() {
            return this.a;
        }
    }

    public static class c implements z {
        private final d a = new a();

        class a implements d {
            a() {
            }

            @Override // androidx.recyclerview.widget.z.d
            public long a(long j) {
                return j;
            }
        }

        @Override // androidx.recyclerview.widget.z
        public d a() {
            return this.a;
        }
    }

    public interface d {
        long a(long j);
    }

    d a();
}
