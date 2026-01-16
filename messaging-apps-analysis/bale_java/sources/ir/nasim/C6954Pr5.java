package ir.nasim;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.Pr5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6954Pr5 {
    public static final a e = new a(null);
    private static final Map f = new HashMap();
    private final boolean a;
    private final File b;
    private final Lock c;
    private FileChannel d;

    /* renamed from: ir.nasim.Pr5$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (C6954Pr5.f) {
                try {
                    Map map = C6954Pr5.f;
                    Object reentrantLock = map.get(str);
                    if (reentrantLock == null) {
                        reentrantLock = new ReentrantLock();
                        map.put(str, reentrantLock);
                    }
                    lock = (Lock) reentrantLock;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C6954Pr5(String str, File file, boolean z) {
        File file2;
        AbstractC13042fc3.i(str, "name");
        this.a = z;
        if (file != null) {
            file2 = new File(file, str + ".lck");
        } else {
            file2 = null;
        }
        this.b = file2;
        this.c = e.b(str);
    }

    public static /* synthetic */ void c(C6954Pr5 c6954Pr5, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = c6954Pr5.a;
        }
        c6954Pr5.b(z);
    }

    public final void b(boolean z) throws IOException {
        this.c.lock();
        if (z) {
            try {
                File file = this.b;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.b).getChannel();
                channel.lock();
                this.d = channel;
            } catch (IOException e2) {
                this.d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e2);
            }
        }
    }

    public final void d() throws IOException {
        try {
            FileChannel fileChannel = this.d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.c.unlock();
    }
}
