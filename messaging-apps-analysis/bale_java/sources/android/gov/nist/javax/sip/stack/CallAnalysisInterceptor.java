package android.gov.nist.javax.sip.stack;

import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.CallAnalyzer;
import ir.nasim.K44;
import ir.nasim.MD6;
import java.util.Properties;

/* loaded from: classes.dex */
public class CallAnalysisInterceptor implements SIPEventInterceptor {
    private static final CallAnalyzer.MetricReference interceptorCheckpoint = new CallAnalyzer.MetricReference("ick");
    private CallAnalyzer callAnalyzer;

    @Override // android.gov.nist.javax.sip.stack.SIPEventInterceptor
    public void afterMessage(K44 k44) {
        this.callAnalyzer.leave(interceptorCheckpoint);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPEventInterceptor
    public void beforeMessage(K44 k44) {
        this.callAnalyzer.enter(interceptorCheckpoint);
    }

    @Override // android.gov.nist.javax.sip.stack.SIPEventInterceptor
    public void destroy() {
        this.callAnalyzer.stop();
        this.callAnalyzer = null;
    }

    @Override // android.gov.nist.javax.sip.stack.SIPEventInterceptor
    public void init(MD6 md6) {
        SipStackImpl sipStackImpl = (SipStackImpl) md6;
        this.callAnalyzer = new CallAnalyzer(sipStackImpl);
        Properties configurationProperties = sipStackImpl.getConfigurationProperties();
        this.callAnalyzer.configure(interceptorCheckpoint, new CallAnalyzer.MetricAnalysisConfiguration(Long.valueOf(Long.parseLong(configurationProperties.getProperty(CallAnalysisInterceptor.class.getName() + ".checkingInterval", "1000"))), Long.valueOf(Long.parseLong(configurationProperties.getProperty(CallAnalysisInterceptor.class.getName() + ".minTimeBetweenDumps", "2000"))), Long.valueOf(Long.parseLong(configurationProperties.getProperty(CallAnalysisInterceptor.class.getName() + ".minStuckTIme", "4000")))));
    }
}
