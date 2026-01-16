package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class N13 implements Closeable {
    private final URL a;
    private volatile Future b;
    private Task c;

    private N13(URL url) {
        this.a = url;
    }

    private byte[] c() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = AbstractC7634So0.d(AbstractC7634So0.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.a);
            }
            if (bArrD.length <= 1048576) {
                return bArrD;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static N13 d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new N13(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(C4982Hj7 c4982Hj7) {
        try {
            c4982Hj7.c(b());
        } catch (Exception e) {
            c4982Hj7.b(e);
        }
    }

    public Bitmap b() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.a);
        }
        byte[] bArrC = c();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrC, 0, bArrC.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.a);
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.cancel(true);
    }

    public Task e() {
        return (Task) AbstractC3795Cj5.j(this.c);
    }

    public void j(ExecutorService executorService) {
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        this.b = executorService.submit(new Runnable() { // from class: ir.nasim.M13
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(c4982Hj7);
            }
        });
        this.c = c4982Hj7.a();
    }
}
