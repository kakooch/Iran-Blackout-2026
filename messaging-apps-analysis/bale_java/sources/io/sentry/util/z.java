package io.sentry.util;

/* loaded from: classes3.dex */
public abstract class z {
    private static final b a = new b();

    private static class b extends ThreadLocal {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public x initialValue() {
            return new x();
        }
    }

    public static x a() {
        return (x) a.get();
    }
}
