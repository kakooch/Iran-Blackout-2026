package android.javax.sdp;

/* loaded from: classes.dex */
public class SdpParseException extends SdpException {
    private int a;
    private int b;

    public SdpParseException(int i, int i2, String str) {
        super(str);
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }
}
