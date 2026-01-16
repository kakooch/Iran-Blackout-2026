package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class b {
    private final AssetManager a;
    private final Executor b;
    private final f.c c;
    private final File e;
    private final String f;
    private final String g;
    private final String h;
    private c[] j;
    private byte[] k;
    private boolean i = false;
    private final byte[] d = d();

    public b(AssetManager assetManager, Executor executor, f.c cVar, String str, String str2, String str3, File file) {
        this.a = assetManager;
        this.b = executor;
        this.c = cVar;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.e = file;
    }

    private b b(c[] cVarArr, byte[] bArr) throws IOException {
        InputStream inputStreamH;
        try {
            inputStreamH = h(this.a, this.h);
        } catch (FileNotFoundException e) {
            this.c.a(9, e);
        } catch (IOException e2) {
            this.c.a(7, e2);
        } catch (IllegalStateException e3) {
            this.j = null;
            this.c.a(8, e3);
        }
        if (inputStreamH == null) {
            if (inputStreamH != null) {
                inputStreamH.close();
            }
            return null;
        }
        try {
            this.j = g.r(inputStreamH, g.p(inputStreamH, g.b), bArr, cVarArr);
            inputStreamH.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamH.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void c() {
        if (!this.i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return i.a;
        }
        switch (i) {
            case 24:
            case 25:
                return i.e;
            case 26:
                return i.d;
            case 27:
                return i.c;
            case 28:
            case 29:
            case 30:
                return i.b;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.g);
        } catch (FileNotFoundException e) {
            this.c.a(6, e);
            return null;
        } catch (IOException e2) {
            this.c.a(7, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i, Object obj) {
        this.c.a(i, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.c.b(5, null);
            }
            return null;
        }
    }

    private c[] j(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    try {
                        c[] cVarArrX = g.x(inputStream, g.p(inputStream, g.a), this.f);
                        try {
                            inputStream.close();
                            return cVarArrX;
                        } catch (IOException e) {
                            this.c.a(7, e);
                            return cVarArrX;
                        }
                    } catch (IOException e2) {
                        this.c.a(7, e2);
                        return null;
                    }
                } catch (IllegalStateException e3) {
                    this.c.a(8, e3);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                this.c.a(7, e4);
                inputStream.close();
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                this.c.a(7, e5);
            }
            throw th;
        }
    }

    private static boolean k() {
        int i = Build.VERSION.SDK_INT;
        return i >= 31 || i == 24 || i == 25;
    }

    private void l(final int i, final Object obj) {
        this.b.execute(new Runnable() { // from class: ir.nasim.qK1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(i, obj);
            }
        });
    }

    public boolean e() {
        if (this.d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.e.exists()) {
            try {
                if (!this.e.createNewFile()) {
                    l(4, null);
                    return false;
                }
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.e.canWrite()) {
            l(4, null);
            return false;
        }
        this.i = true;
        return true;
    }

    public b i() {
        b bVarB;
        c();
        if (this.d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.a);
        if (inputStreamF != null) {
            this.j = j(inputStreamF);
        }
        c[] cVarArr = this.j;
        return (cVarArr == null || !k() || (bVarB = b(cVarArr, this.d)) == null) ? this : bVarB;
    }

    public b m() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        c[] cVarArr = this.j;
        byte[] bArr = this.d;
        if (cVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    g.F(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.c.a(7, e);
            } catch (IllegalStateException e2) {
                this.c.a(8, e2);
            }
            if (!g.C(byteArrayOutputStream, bArr, cVarArr)) {
                this.c.a(5, null);
                this.j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean n() {
        byte[] bArr = this.k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock fileLockTryLock = channel.tryLock();
                            try {
                                d.l(byteArrayInputStream, fileOutputStream, fileLockTryLock);
                                l(1, null);
                                if (fileLockTryLock != null) {
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                l(6, e);
                return false;
            } catch (IOException e2) {
                l(7, e2);
                return false;
            }
        } finally {
            this.k = null;
            this.j = null;
        }
    }
}
