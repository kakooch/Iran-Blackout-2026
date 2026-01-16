package org.rbmain.messenger;

import android.util.Log;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import org.rbmain.messenger.time.FastDateFormat;

/* loaded from: classes.dex */
public class FileLog {
    private static volatile FileLog Instance = null;
    private static final String tag = "tmessages";
    private boolean initied;
    private OutputStreamWriter streamWriter = null;
    private FastDateFormat dateFormat = null;
    private DispatchQueue logQueue = null;
    private File currentFile = null;
    private File networkFile = null;
    private File tonlibFile = null;

    public static FileLog getInstance() {
        FileLog fileLog = Instance;
        if (fileLog == null) {
            synchronized (FileLog.class) {
                fileLog = Instance;
                if (fileLog == null) {
                    fileLog = new FileLog();
                    Instance = fileLog;
                }
            }
        }
        return fileLog;
    }

    public FileLog() throws IOException {
        if (BuildVars.LOGS_ENABLED || MyLog.isDebugAble) {
            init();
        }
    }

    public void init() throws IOException {
        File externalFilesDir;
        if (this.initied) {
            return;
        }
        this.dateFormat = FastDateFormat.getInstance("dd_MM_yyyy_HH_mm_ss", Locale.US);
        try {
            externalFilesDir = ApplicationLoader.applicationContext.getExternalFilesDir(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (externalFilesDir == null) {
            return;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + "/logs");
        file.mkdirs();
        this.currentFile = new File(file, this.dateFormat.format(System.currentTimeMillis()) + ".txt");
        try {
            this.logQueue = new DispatchQueue("logQueue");
            this.currentFile.createNewFile();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.currentFile));
            this.streamWriter = outputStreamWriter;
            outputStreamWriter.write("-----start log " + this.dateFormat.format(System.currentTimeMillis()) + "-----\n");
            this.streamWriter.flush();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.initied = true;
    }

    public static void ensureInitied() throws IOException {
        getInstance().init();
    }

    public static String getNetworkLogPath() {
        if (!BuildVars.LOGS_ENABLED && !MyLog.isDebugAble) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        try {
            File externalFilesDir = ApplicationLoader.applicationContext.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            File file = new File(externalFilesDir.getAbsolutePath() + "/logs");
            file.mkdirs();
            getInstance().networkFile = new File(file, getInstance().dateFormat.format(System.currentTimeMillis()) + "_net.txt");
            return getInstance().networkFile.getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    public static String getTonlibLogPath() {
        if (!BuildVars.LOGS_ENABLED && !MyLog.isDebugAble) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        try {
            File externalFilesDir = ApplicationLoader.applicationContext.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            File file = new File(externalFilesDir.getAbsolutePath() + "/logs");
            file.mkdirs();
            getInstance().tonlibFile = new File(file, getInstance().dateFormat.format(System.currentTimeMillis()) + "_tonlib.txt");
            return getInstance().tonlibFile.getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    public static void e(Throwable th, boolean z) {
        e(th);
    }

    public static void e(final String str, final Throwable th) {
        if (BuildVars.LOGS_ENABLED || MyLog.isDebugAble) {
            ensureInitied();
            Log.e(tag, str, th);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLog$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$e$0(str, th);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$e$0(String str, Throwable th) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " E/tmessages: " + str + "\n");
            getInstance().streamWriter.write(th.toString());
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(final String str) {
        if (BuildVars.LOGS_ENABLED || MyLog.isDebugAble) {
            ensureInitied();
            Log.e(tag, str);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLog$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$e$1(str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$e$1(String str) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " E/tmessages: " + str + "\n");
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(final Throwable th) {
        if (BuildVars.LOGS_ENABLED || MyLog.isDebugAble) {
            ensureInitied();
            th.printStackTrace();
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLog$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$e$2(th);
                    }
                });
            } else {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$e$2(Throwable th) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " E/tmessages: " + th + "\n");
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " E/tmessages: " + stackTraceElement + "\n");
            }
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(final String str) {
        if (BuildVars.LOGS_ENABLED || MyLog.isDebugAble) {
            ensureInitied();
            Log.d(tag, str);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLog$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$d$3(str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$d$3(String str) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " D/tmessages: " + str + "\n");
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void w(final String str) throws IOException {
        if (BuildVars.LOGS_ENABLED || MyLog.isDebugAble) {
            ensureInitied();
            Log.w(tag, str);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.FileLog$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$w$4(str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$w$4(String str) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " W/tmessages: " + str + "\n");
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cleanupLogs() throws IOException {
        ensureInitied();
        File externalFilesDir = ApplicationLoader.applicationContext.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return;
        }
        File[] fileArrListFiles = new File(externalFilesDir.getAbsolutePath() + "/logs").listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if ((getInstance().currentFile == null || !file.getAbsolutePath().equals(getInstance().currentFile.getAbsolutePath())) && ((getInstance().networkFile == null || !file.getAbsolutePath().equals(getInstance().networkFile.getAbsolutePath())) && (getInstance().tonlibFile == null || !file.getAbsolutePath().equals(getInstance().tonlibFile.getAbsolutePath())))) {
                    file.delete();
                }
            }
        }
    }
}
