package androidx.camera.core;

/* loaded from: classes.dex */
public class CameraUnavailableException extends Exception {
    private final int a;

    public CameraUnavailableException(int i, String str) {
        super(str);
        this.a = i;
    }

    public CameraUnavailableException(int i, Throwable th) {
        super(th);
        this.a = i;
    }
}
