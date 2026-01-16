package android.javax.sdp;

/* loaded from: classes.dex */
public class SdpFactoryException extends SdpException {
    protected Exception a;

    @Override // java.lang.Throwable
    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        Exception exc = this.a;
        if (exc != null) {
            return exc.getMessage();
        }
        return null;
    }
}
