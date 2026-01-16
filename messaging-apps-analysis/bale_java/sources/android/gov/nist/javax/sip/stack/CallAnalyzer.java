package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CallAnalyzer {
    private SipStackImpl stack;
    private static StackLogger logger = CommonLogger.getLogger(CallAnalyzer.class);
    static int count = 0;
    private Map<Thread, HashMap<MetricReference, Object>> threadMap = new WeakHashMap();
    private MetricReferenceMap metricStatisticsMap = new MetricReferenceMap();
    private Timer timer = new Timer();

    public static class MetricReference {
        public String name;

        public MetricReference(String str) {
            this.name = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof MetricReference) {
                return ((MetricReference) obj).name.equals(this.name);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    public static class MetricReferenceMap extends WeakHashMap<MetricReference, TImeMetricInfo> {
        private static final long serialVersionUID = 393231609328924828L;

        @Override // java.util.WeakHashMap, java.util.AbstractMap, java.util.Map
        public TImeMetricInfo get(Object obj) {
            if (super.get(obj) == null) {
                super.put((MetricReference) obj, new TImeMetricInfo());
            }
            return (TImeMetricInfo) super.get(obj);
        }
    }

    public static class StackTrace {
        public int delta;
        public String trace;

        public StackTrace(int i, String str) {
            this.delta = i;
            this.trace = str;
        }
    }

    public static class TImeMetricInfo {
        protected TimerTask task;
        public Long totalTime = new Long(0);
        public Long numberOfEvents = new Long(0);
        public Long averageTime = new Long(1);
        public Long lastLoggedEventTime = new Long(0);
        protected MetricAnalysisConfiguration config = new MetricAnalysisConfiguration(5000, 5000, 5000);
    }

    public static class ThreadInfo {
        public Object data;
        public LinkedList<StackTrace> stackTraces = new LinkedList<>();
    }

    public CallAnalyzer(SipStackImpl sipStackImpl) {
        this.stack = sipStackImpl;
    }

    public static void main(String[] strArr) throws InterruptedException {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        CallAnalyzer callAnalyzer = new CallAnalyzer();
        final MetricReference metricReference = new MetricReference("sec");
        MetricReference metricReference2 = new MetricReference("se111c");
        callAnalyzer.configure(metricReference, new MetricAnalysisConfiguration(SIPTransactionStack.BASE_TIMER_INTERVAL, SIPTransactionStack.BASE_TIMER_INTERVAL, SIPTransactionStack.BASE_TIMER_INTERVAL));
        callAnalyzer.startAnalysis(metricReference);
        callAnalyzer.startAnalysis(metricReference2);
        Runnable runnable = new Runnable() { // from class: android.gov.nist.javax.sip.stack.CallAnalyzer.2
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                CallAnalyzer.this.enter(metricReference);
                try {
                    int i = CallAnalyzer.count + 1;
                    CallAnalyzer.count = i;
                    if (i % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND == 0) {
                        System.out.println("Avg " + CallAnalyzer.this.getMetricStats(metricReference).averageTime);
                        Thread.sleep(1000L);
                    }
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CallAnalyzer.this.leave(metricReference);
            }
        };
        for (int i = 0; i < 2000000; i++) {
            executorServiceNewFixedThreadPool.execute(runnable);
        }
        PrintStream printStream = System.out;
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        executorServiceNewFixedThreadPool.shutdown();
        executorServiceNewFixedThreadPool.awaitTermination(200L, TimeUnit.SECONDS);
        executorServiceNewFixedThreadPool.shutdownNow();
        System.gc();
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        Thread.sleep(5000L);
        System.gc();
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        System.gc();
        Thread.sleep(5000L);
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        System.gc();
        Thread.sleep(5000L);
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        Thread.sleep(5000L);
        System.gc();
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        System.gc();
        Thread.sleep(5000L);
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        System.gc();
        Thread.sleep(5000L);
        printStream.println("size:" + callAnalyzer.threadMap.size() + Separators.SP + callAnalyzer.metricStatisticsMap.size());
        System.gc();
        if (callAnalyzer.threadMap.size() > 0) {
            throw new RuntimeException("Should be zero by this point. Leak.");
        }
    }

    public void configure(MetricReference metricReference, MetricAnalysisConfiguration metricAnalysisConfiguration) {
        this.metricStatisticsMap.get((Object) metricReference).config = metricAnalysisConfiguration;
        if (isAnalysisStarted(metricReference)) {
            return;
        }
        startAnalysis(metricReference);
    }

    public void enter(MetricReference metricReference) {
        enter(Thread.currentThread(), metricReference);
    }

    public synchronized HashMap<MetricReference, Object> getAttributes(Thread thread) {
        HashMap<MetricReference, Object> map;
        map = this.threadMap.get(thread);
        if (map == null) {
            map = new HashMap<>();
            this.threadMap.put(thread, map);
        }
        return map;
    }

    public String getCurrentStack(Thread thread) {
        StringBuilder sb = new StringBuilder();
        sb.append(Separators.RETURN + thread.getName() + Separators.SP + thread.getId() + Separators.SP + thread.getState().toString() + Separators.RETURN);
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append(Separators.SP + stackTraceElement.toString() + Separators.RETURN);
        }
        return sb.toString();
    }

    public TImeMetricInfo getMetricStats(MetricReference metricReference) {
        return this.metricStatisticsMap.get((Object) metricReference);
    }

    public int getNumberOfThreads() {
        return this.threadMap.size();
    }

    public Object getObject(Thread thread, String str) {
        return getAttributes(thread).get(str);
    }

    public String getThreadDump() {
        StringBuilder sb = new StringBuilder();
        Thread[] threadArr = new Thread[5000];
        int iEnumerate = Thread.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            sb.append(getCurrentStack(threadArr[i]));
        }
        return sb.toString();
    }

    public Long getTime(Thread thread, MetricReference metricReference) {
        return (Long) getAttributes(thread).get(metricReference);
    }

    public boolean isAnalysisStarted(MetricReference metricReference) {
        return this.metricStatisticsMap.get((Object) metricReference).task != null;
    }

    public void leave(MetricReference metricReference) {
        leave(Thread.currentThread(), metricReference);
    }

    public void resetStats(MetricReference metricReference) {
        TImeMetricInfo tImeMetricInfo = this.metricStatisticsMap.get((Object) metricReference);
        tImeMetricInfo.totalTime = new Long(0L);
        tImeMetricInfo.numberOfEvents = new Long(0L);
        tImeMetricInfo.averageTime = new Long(1L);
        tImeMetricInfo.lastLoggedEventTime = new Long(0L);
    }

    public void setObject(Thread thread, MetricReference metricReference, Object obj) {
        getAttributes(thread).put(metricReference, obj);
    }

    public void startAnalysis(final MetricReference metricReference) {
        stopAnalysis(metricReference);
        resetStats(metricReference);
        final TImeMetricInfo tImeMetricInfo = this.metricStatisticsMap.get((Object) metricReference);
        TimerTask timerTask = new TimerTask() { // from class: android.gov.nist.javax.sip.stack.CallAnalyzer.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    if (System.currentTimeMillis() - tImeMetricInfo.lastLoggedEventTime.longValue() > tImeMetricInfo.config.minimumDumpInterval.longValue()) {
                        for (Map.Entry entry : CallAnalyzer.this.threadMap.entrySet()) {
                            Long l = (Long) ((HashMap) entry.getValue()).get(metricReference);
                            if (!l.equals(Long.MIN_VALUE)) {
                                long jCurrentTimeMillis = System.currentTimeMillis() - l.longValue();
                                if (CallAnalyzer.logger != null && jCurrentTimeMillis > tImeMetricInfo.config.stuckTimeBeforeDump.longValue()) {
                                    CallAnalyzer.logger.logWarning("Offending thread:\n" + CallAnalyzer.this.getCurrentStack((Thread) entry.getKey()));
                                    StringBuilder sb = new StringBuilder();
                                    Thread[] threadArr = new Thread[5000];
                                    int iEnumerate = Thread.enumerate(threadArr);
                                    for (int i = 0; i < iEnumerate; i++) {
                                        if (((HashMap) CallAnalyzer.this.threadMap.get(threadArr[i])) != null) {
                                            Long l2 = (Long) ((HashMap) CallAnalyzer.this.threadMap.get(threadArr[i])).get(metricReference);
                                            long jCurrentTimeMillis2 = l2 != null ? System.currentTimeMillis() - l2.longValue() : 0L;
                                            if (l2.longValue() != Long.MIN_VALUE) {
                                                sb.append("->Stuck time:" + jCurrentTimeMillis2 + Separators.SP + CallAnalyzer.this.getCurrentStack(threadArr[i]));
                                            }
                                        }
                                    }
                                    CallAnalyzer.logger.logWarning(sb.toString());
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        tImeMetricInfo.task = timerTask;
        this.timer.scheduleAtFixedRate(timerTask, tImeMetricInfo.config.checkingInterval.longValue(), tImeMetricInfo.config.checkingInterval.longValue());
    }

    public void stop() {
        this.timer.cancel();
        this.timer = null;
    }

    public void stopAnalysis(MetricReference metricReference) {
        TImeMetricInfo tImeMetricInfo = this.metricStatisticsMap.get((Object) metricReference);
        TimerTask timerTask = tImeMetricInfo.task;
        if (timerTask != null) {
            timerTask.cancel();
            tImeMetricInfo.task = null;
        }
    }

    public void enter(Thread thread, MetricReference metricReference) {
        getAttributes(thread).put(metricReference, Long.valueOf(System.currentTimeMillis()));
    }

    public void leave(Thread thread, MetricReference metricReference) {
        TImeMetricInfo tImeMetricInfo = this.metricStatisticsMap.get((Object) metricReference);
        HashMap<MetricReference, Object> attributes = getAttributes(thread);
        tImeMetricInfo.totalTime = Long.valueOf(tImeMetricInfo.totalTime.longValue() + (System.currentTimeMillis() - ((Long) attributes.get(metricReference)).longValue()));
        tImeMetricInfo.numberOfEvents = Long.valueOf(tImeMetricInfo.numberOfEvents.longValue() + 1);
        tImeMetricInfo.averageTime = Long.valueOf(tImeMetricInfo.totalTime.longValue() / tImeMetricInfo.numberOfEvents.longValue());
        attributes.put(metricReference, Long.MIN_VALUE);
    }

    public static class MetricAnalysisConfiguration {
        protected Long checkingInterval;
        protected Long minimumDumpInterval;
        protected Long stuckTimeBeforeDump;

        public MetricAnalysisConfiguration(Long l, Long l2, Long l3) {
            this.checkingInterval = l;
            this.minimumDumpInterval = l2;
            this.stuckTimeBeforeDump = l3;
        }

        public MetricAnalysisConfiguration(int i, int i2, int i3) {
            this.checkingInterval = new Long(i);
            this.minimumDumpInterval = new Long(i2);
            this.stuckTimeBeforeDump = new Long(i3);
        }
    }

    public CallAnalyzer() {
    }
}
