package io.sentry.transport;

/* loaded from: classes3.dex */
public abstract class C {

    private static final class b extends C {
        private final int a;

        b(int i) {
            super();
            this.a = i;
        }

        @Override // io.sentry.transport.C
        public int c() {
            return this.a;
        }

        @Override // io.sentry.transport.C
        public boolean d() {
            return false;
        }
    }

    private static final class c extends C {
        static final c a = new c();

        private c() {
            super();
        }

        @Override // io.sentry.transport.C
        public int c() {
            return -1;
        }

        @Override // io.sentry.transport.C
        public boolean d() {
            return true;
        }
    }

    private C() {
    }

    public static C a() {
        return b(-1);
    }

    public static C b(int i) {
        return new b(i);
    }

    public static C e() {
        return c.a;
    }

    public abstract int c();

    public abstract boolean d();
}
