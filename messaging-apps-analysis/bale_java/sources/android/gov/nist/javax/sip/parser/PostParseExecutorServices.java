package android.gov.nist.javax.sip.parser;

import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.BlockingQueueDispatchAuditor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class PostParseExecutorServices {
    private static ExecutorService postParseExecutor;
    public static BlockingQueue<Runnable> staticQueue;
    public static BlockingQueueDispatchAuditor staticQueueAuditor;

    public static class NamedThreadFactory implements ThreadFactory {
        static long threadNumber;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            StringBuilder sb = new StringBuilder();
            sb.append("SIP-TCP-Core-PipelineThreadpool-");
            long j = threadNumber;
            threadNumber = 1 + j;
            sb.append(j % 999999999);
            thread.setName(sb.toString());
            return thread;
        }
    }

    public static ExecutorService getPostParseExecutor() {
        return postParseExecutor;
    }

    public static void setPostParseExcutorSize(SipStackImpl sipStackImpl, int i, int i2) {
        ExecutorService executorService = postParseExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        BlockingQueueDispatchAuditor blockingQueueDispatchAuditor = staticQueueAuditor;
        if (blockingQueueDispatchAuditor != null) {
            try {
                blockingQueueDispatchAuditor.stop();
            } catch (Exception unused) {
            }
        }
        if (i <= 0) {
            postParseExecutor = null;
            return;
        }
        staticQueue = new LinkedBlockingQueue();
        postParseExecutor = new ThreadPoolExecutor(i, i, 0L, TimeUnit.SECONDS, staticQueue, new NamedThreadFactory());
        if (sipStackImpl.getStackCongestionControlTimeout() > 0) {
            BlockingQueueDispatchAuditor blockingQueueDispatchAuditor2 = new BlockingQueueDispatchAuditor(staticQueue);
            staticQueueAuditor = blockingQueueDispatchAuditor2;
            blockingQueueDispatchAuditor2.setTimeout(i2);
            staticQueueAuditor.start(2000);
        }
    }

    public static void shutdownThreadpool() {
        ExecutorService executorService = postParseExecutor;
        if (executorService != null) {
            executorService.shutdown();
            postParseExecutor = null;
        }
        BlockingQueueDispatchAuditor blockingQueueDispatchAuditor = staticQueueAuditor;
        if (blockingQueueDispatchAuditor != null) {
            try {
                blockingQueueDispatchAuditor.stop();
            } catch (Exception unused) {
            }
        }
    }
}
