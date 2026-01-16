package android.javax.sip;

/* loaded from: classes.dex */
public class InvalidArgumentException extends Exception {
    protected Throwable a;

    public InvalidArgumentException() {
        this.a = null;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public InvalidArgumentException(String str) {
        super(str);
        this.a = null;
    }

    public InvalidArgumentException(String str, Throwable th) {
        super(str);
        this.a = th;
    }
}
