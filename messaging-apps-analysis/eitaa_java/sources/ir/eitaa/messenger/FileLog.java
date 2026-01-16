package ir.eitaa.messenger;

import android.util.Log;
import ir.eitaa.messenger.time.FastDateFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

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
        if (BuildVars.LOGS_ENABLED) {
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
        if (!BuildVars.LOGS_ENABLED) {
            return "";
        }
        try {
            File externalFilesDir = ApplicationLoader.applicationContext.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return "";
            }
            File file = new File(externalFilesDir.getAbsolutePath() + "/logs");
            file.mkdirs();
            getInstance().networkFile = new File(file, getInstance().dateFormat.format(System.currentTimeMillis()) + "_net.txt");
            return getInstance().networkFile.getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getTonlibLogPath() {
        if (!BuildVars.LOGS_ENABLED) {
            return "";
        }
        try {
            File externalFilesDir = ApplicationLoader.applicationContext.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return "";
            }
            File file = new File(externalFilesDir.getAbsolutePath() + "/logs");
            file.mkdirs();
            getInstance().tonlibFile = new File(file, getInstance().dateFormat.format(System.currentTimeMillis()) + "_tonlib.txt");
            return getInstance().tonlibFile.getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void e(final String message, final Throwable exception) throws IOException {
        if (BuildVars.LOGS_ENABLED) {
            ensureInitied();
            Log.e(tag, message, exception);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLog$CR382pZR980Ap-gOnH01gQ7TERk
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$e$0(message, exception);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$e$0(String str, Throwable th) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " E/tmessages: " + str + "\n");
            getInstance().streamWriter.write(th.toString());
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(final String message) {
        if (BuildVars.LOGS_ENABLED) {
            ensureInitied();
            Log.e(tag, message);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLog$MVgT_v5Ru6CR1odXwhOxY41neQY
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$e$1(message);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$e$1(String str) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " E/tmessages: " + str + "\n");
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(final Throwable e) {
        if (BuildVars.LOGS_ENABLED) {
            ensureInitied();
            e.printStackTrace();
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLog$sa61fGtn1gwHiI-ycf9SZOYEs_E
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$e$2(e);
                    }
                });
            } else {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void lambda$e$2(Throwable th) throws IOException {
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

    public static void d(final String message) {
        if (BuildVars.LOGS_ENABLED) {
            ensureInitied();
            Log.d(tag, message);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLog$hftgGWVUVndvEKREj8x-7JjmUKU
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$d$3(message);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$d$3(String str) throws IOException {
        try {
            getInstance().streamWriter.write(getInstance().dateFormat.format(System.currentTimeMillis()) + " D/tmessages: " + str + "\n");
            getInstance().streamWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void w(final String message) throws IOException {
        if (BuildVars.LOGS_ENABLED) {
            ensureInitied();
            Log.w(tag, message);
            if (getInstance().streamWriter != null) {
                getInstance().logQueue.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FileLog$lYQwF_QEHMZdL2Xm5KbiVR3GT_Y
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        FileLog.lambda$w$4(message);
                    }
                });
            }
        }
    }

    static /* synthetic */ void lambda$w$4(String str) throws IOException {
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
