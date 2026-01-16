package ir.nasim;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class Q76 implements InterfaceC13330g27, SG1 {
    private final Context a;
    private final String b;
    private final File c;
    private final Callable d;
    private final int e;
    private final InterfaceC13330g27 f;
    private C5822Kz1 g;
    private boolean h;

    public Q76(Context context, String str, File file, Callable callable, int i, InterfaceC13330g27 interfaceC13330g27) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC13330g27, "delegate");
        this.a = context;
        this.b = str;
        this.c = file;
        this.d = callable;
        this.e = i;
        this.f = interfaceC13330g27;
    }

    private final void b(File file, boolean z) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.b != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.a.getAssets().open(this.b));
            AbstractC13042fc3.h(readableByteChannelNewChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.c != null) {
            readableByteChannelNewChannel = new FileInputStream(this.c).getChannel();
            AbstractC13042fc3.h(readableByteChannelNewChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable callable = this.d;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel((InputStream) callable.call());
                AbstractC13042fc3.h(readableByteChannelNewChannel, "newChannel(inputStream)");
            } catch (Exception e) {
                throw new IOException("inputStreamCallable exception on call", e);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        AbstractC13042fc3.h(channel, "output");
        AbstractC5706Km2.a(readableByteChannelNewChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        AbstractC13042fc3.h(fileCreateTempFile, "intermediateFile");
        c(fileCreateTempFile, z);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final void c(File file, boolean z) {
        C5822Kz1 c5822Kz1 = this.g;
        if (c5822Kz1 == null) {
            AbstractC13042fc3.y("databaseConfiguration");
            c5822Kz1 = null;
        }
        c5822Kz1.getClass();
    }

    private final void e(boolean z) throws IOException {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        File databasePath = this.a.getDatabasePath(databaseName);
        C5822Kz1 c5822Kz1 = this.g;
        C5822Kz1 c5822Kz12 = null;
        if (c5822Kz1 == null) {
            AbstractC13042fc3.y("databaseConfiguration");
            c5822Kz1 = null;
        }
        C6954Pr5 c6954Pr5 = new C6954Pr5(databaseName, this.a.getFilesDir(), c5822Kz1.s);
        try {
            C6954Pr5.c(c6954Pr5, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    AbstractC13042fc3.h(databasePath, "databaseFile");
                    b(databasePath, z);
                    c6954Pr5.d();
                    return;
                } catch (IOException e) {
                    throw new RuntimeException("Unable to copy database file.", e);
                }
            }
            try {
                AbstractC13042fc3.h(databasePath, "databaseFile");
                int iD = AbstractC7716Sx1.d(databasePath);
                if (iD == this.e) {
                    c6954Pr5.d();
                    return;
                }
                C5822Kz1 c5822Kz13 = this.g;
                if (c5822Kz13 == null) {
                    AbstractC13042fc3.y("databaseConfiguration");
                } else {
                    c5822Kz12 = c5822Kz13;
                }
                if (c5822Kz12.a(iD, this.e)) {
                    c6954Pr5.d();
                    return;
                }
                if (this.a.deleteDatabase(databaseName)) {
                    try {
                        b(databasePath, z);
                    } catch (IOException e2) {
                        Log.w("ROOM", "Unable to copy database file.", e2);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                c6954Pr5.d();
                return;
            } catch (IOException e3) {
                Log.w("ROOM", "Unable to read database version.", e3);
                c6954Pr5.d();
                return;
            }
        } catch (Throwable th) {
            c6954Pr5.d();
            throw th;
        }
        c6954Pr5.d();
        throw th;
    }

    @Override // ir.nasim.InterfaceC13330g27
    public InterfaceC12694f27 E() throws IOException {
        if (!this.h) {
            e(true);
            this.h = true;
        }
        return a().E();
    }

    @Override // ir.nasim.SG1
    public InterfaceC13330g27 a() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC13330g27, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        a().close();
        this.h = false;
    }

    public final void d(C5822Kz1 c5822Kz1) {
        AbstractC13042fc3.i(c5822Kz1, "databaseConfiguration");
        this.g = c5822Kz1;
    }

    @Override // ir.nasim.InterfaceC13330g27
    public String getDatabaseName() {
        return a().getDatabaseName();
    }

    @Override // ir.nasim.InterfaceC13330g27
    public void setWriteAheadLoggingEnabled(boolean z) {
        a().setWriteAheadLoggingEnabled(z);
    }
}
