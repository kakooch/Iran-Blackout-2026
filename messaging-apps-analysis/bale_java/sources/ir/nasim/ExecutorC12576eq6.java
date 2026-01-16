package ir.nasim;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.eq6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ExecutorC12576eq6 implements Executor {
    private final Executor b;
    final Deque a = new ArrayDeque();
    private final b c = new b();
    c d = c.IDLE;
    long e = 0;

    /* renamed from: ir.nasim.eq6$a */
    class a implements Runnable {
        final /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    /* renamed from: ir.nasim.eq6$b */
    final class b implements Runnable {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004b, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        
            ir.nasim.PI3.d("SequentialExecutor", "Exception while executing runnable " + r3, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = r0
            L2:
                ir.nasim.eq6 r2 = ir.nasim.ExecutorC12576eq6.this     // Catch: java.lang.Throwable -> L4f
                java.util.Deque r2 = r2.a     // Catch: java.lang.Throwable -> L4f
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
                if (r0 != 0) goto L28
                ir.nasim.eq6 r0 = ir.nasim.ExecutorC12576eq6.this     // Catch: java.lang.Throwable -> L1c
                ir.nasim.eq6$c r3 = r0.d     // Catch: java.lang.Throwable -> L1c
                ir.nasim.eq6$c r4 = ir.nasim.ExecutorC12576eq6.c.RUNNING     // Catch: java.lang.Throwable -> L1c
                if (r3 != r4) goto L1e
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L1b
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1b:
                return
            L1c:
                r0 = move-exception
                goto L69
            L1e:
                long r5 = r0.e     // Catch: java.lang.Throwable -> L1c
                r7 = 1
                long r5 = r5 + r7
                r0.e = r5     // Catch: java.lang.Throwable -> L1c
                r0.d = r4     // Catch: java.lang.Throwable -> L1c
                r0 = 1
            L28:
                ir.nasim.eq6 r3 = ir.nasim.ExecutorC12576eq6.this     // Catch: java.lang.Throwable -> L1c
                java.util.Deque r3 = r3.a     // Catch: java.lang.Throwable -> L1c
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1c
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L1c
                if (r3 != 0) goto L45
                ir.nasim.eq6 r0 = ir.nasim.ExecutorC12576eq6.this     // Catch: java.lang.Throwable -> L1c
                ir.nasim.eq6$c r3 = ir.nasim.ExecutorC12576eq6.c.IDLE     // Catch: java.lang.Throwable -> L1c
                r0.d = r3     // Catch: java.lang.Throwable -> L1c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L44
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L44:
                return
            L45:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L4f
                r1 = r1 | r2
                r3.run()     // Catch: java.lang.Throwable -> L4f java.lang.RuntimeException -> L51
                goto L2
            L4f:
                r0 = move-exception
                goto L6b
            L51:
                r2 = move-exception
                java.lang.String r4 = "SequentialExecutor"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
                r5.<init>()     // Catch: java.lang.Throwable -> L4f
                java.lang.String r6 = "Exception while executing runnable "
                r5.append(r6)     // Catch: java.lang.Throwable -> L4f
                r5.append(r3)     // Catch: java.lang.Throwable -> L4f
                java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L4f
                ir.nasim.PI3.d(r4, r3, r2)     // Catch: java.lang.Throwable -> L4f
                goto L2
            L69:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                throw r0     // Catch: java.lang.Throwable -> L4f
            L6b:
                if (r1 == 0) goto L74
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L74:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ExecutorC12576eq6.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e) {
                synchronized (ExecutorC12576eq6.this.a) {
                    ExecutorC12576eq6.this.d = c.IDLE;
                    throw e;
                }
            }
        }
    }

    /* renamed from: ir.nasim.eq6$c */
    enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    ExecutorC12576eq6(Executor executor) {
        this.b = (Executor) AbstractC4980Hj5.g(executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(java.lang.Runnable r8) {
        /*
            r7 = this;
            ir.nasim.AbstractC4980Hj5.g(r8)
            java.util.Deque r0 = r7.a
            monitor-enter(r0)
            ir.nasim.eq6$c r1 = r7.d     // Catch: java.lang.Throwable -> L6d
            ir.nasim.eq6$c r2 = ir.nasim.ExecutorC12576eq6.c.RUNNING     // Catch: java.lang.Throwable -> L6d
            if (r1 == r2) goto L6f
            ir.nasim.eq6$c r2 = ir.nasim.ExecutorC12576eq6.c.QUEUED     // Catch: java.lang.Throwable -> L6d
            if (r1 != r2) goto L11
            goto L6f
        L11:
            long r3 = r7.e     // Catch: java.lang.Throwable -> L6d
            ir.nasim.eq6$a r1 = new ir.nasim.eq6$a     // Catch: java.lang.Throwable -> L6d
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L6d
            java.util.Deque r8 = r7.a     // Catch: java.lang.Throwable -> L6d
            r8.add(r1)     // Catch: java.lang.Throwable -> L6d
            ir.nasim.eq6$c r8 = ir.nasim.ExecutorC12576eq6.c.QUEUING     // Catch: java.lang.Throwable -> L6d
            r7.d = r8     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.Executor r0 = r7.b     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            ir.nasim.eq6$b r5 = r7.c     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            r0.execute(r5)     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            ir.nasim.eq6$c r0 = r7.d
            if (r0 == r8) goto L2e
            return
        L2e:
            java.util.Deque r0 = r7.a
            monitor-enter(r0)
            long r5 = r7.e     // Catch: java.lang.Throwable -> L3e
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L40
            ir.nasim.eq6$c r1 = r7.d     // Catch: java.lang.Throwable -> L3e
            if (r1 != r8) goto L40
            r7.d = r2     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r8 = move-exception
            goto L42
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r8
        L44:
            r8 = move-exception
            goto L47
        L46:
            r8 = move-exception
        L47:
            java.util.Deque r2 = r7.a
            monitor-enter(r2)
            ir.nasim.eq6$c r0 = r7.d     // Catch: java.lang.Throwable -> L55
            ir.nasim.eq6$c r3 = ir.nasim.ExecutorC12576eq6.c.IDLE     // Catch: java.lang.Throwable -> L55
            if (r0 == r3) goto L57
            ir.nasim.eq6$c r3 = ir.nasim.ExecutorC12576eq6.c.QUEUING     // Catch: java.lang.Throwable -> L55
            if (r0 != r3) goto L61
            goto L57
        L55:
            r8 = move-exception
            goto L6b
        L57:
            java.util.Deque r0 = r7.a     // Catch: java.lang.Throwable -> L55
            boolean r0 = r0.removeLastOccurrence(r1)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L61
            r0 = 1
            goto L62
        L61:
            r0 = 0
        L62:
            boolean r1 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L6a
            if (r0 != 0) goto L6a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            return
        L6a:
            throw r8     // Catch: java.lang.Throwable -> L55
        L6b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            throw r8
        L6d:
            r8 = move-exception
            goto L76
        L6f:
            java.util.Deque r1 = r7.a     // Catch: java.lang.Throwable -> L6d
            r1.add(r8)     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            return
        L76:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ExecutorC12576eq6.execute(java.lang.Runnable):void");
    }
}
