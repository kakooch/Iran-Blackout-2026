package androidx.camera.core;

/* loaded from: classes.dex */
public class ImageCaptureException extends Exception {
    private final int a;

    public ImageCaptureException(int i, String str, Throwable th) {
        super(str, th);
        this.a = i;
    }
}
