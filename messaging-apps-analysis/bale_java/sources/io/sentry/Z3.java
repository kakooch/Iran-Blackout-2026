package io.sentry;

import java.lang.Thread;

/* loaded from: classes3.dex */
interface Z3 {

    public static final class a implements Z3 {
        private static final a a = new a();

        private a() {
        }

        static Z3 c() {
            return a;
        }

        @Override // io.sentry.Z3
        public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        @Override // io.sentry.Z3
        public Thread.UncaughtExceptionHandler b() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    Thread.UncaughtExceptionHandler b();
}
