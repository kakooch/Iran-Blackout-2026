package android.javax.sip;

/* loaded from: classes.dex */
public class SipException extends Exception {
    protected Throwable m_Cause;

    public SipException() {
        this.m_Cause = null;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.m_Cause;
    }

    public SipException(String str) {
        super(str);
        this.m_Cause = null;
    }

    public SipException(String str, Throwable th) {
        super(str);
        this.m_Cause = th;
    }
}
