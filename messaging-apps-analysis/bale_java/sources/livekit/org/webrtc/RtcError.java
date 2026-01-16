package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class RtcError {
    private final RtcException error;

    private RtcError(RtcException rtcException) {
        this.error = rtcException;
    }

    @CalledByNative
    public static RtcError error(String str) {
        return new RtcError(new RtcException(str));
    }

    @CalledByNative
    public static RtcError success() {
        return new RtcError(null);
    }

    public boolean isError() {
        return this.error != null;
    }

    public boolean isSuccess() {
        return this.error == null;
    }

    public void throwError() {
        RtcException rtcException = this.error;
        if (rtcException != null) {
            throw rtcException;
        }
    }

    public RtcException error() {
        return this.error;
    }
}
