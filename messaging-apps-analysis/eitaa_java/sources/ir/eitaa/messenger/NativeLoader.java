package ir.eitaa.messenger;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

/* loaded from: classes.dex */
public class NativeLoader {
    private static final String LIB_NAME = "tmessages.40";
    private static final String LIB_SO_NAME = "libtmessages.40.so";
    private static final int LIB_VERSION = 40;
    private static final String LOCALE_LIB_SO_NAME = "libtmessages.40loc.so";
    private static volatile boolean nativeLoaded = false;
    private String crashPath = "";

    private static native void init(String path, boolean enable);

    private static File getNativeLibraryDir(Context context) {
        File file;
        if (context != null) {
            try {
                file = new File((String) ApplicationInfo.class.getField("nativeLibraryDir").get(context.getApplicationInfo()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            file = null;
        }
        if (file == null) {
            file = new File(context.getApplicationInfo().dataDir, "lib");
        }
        if (file.isDirectory()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode", "SetWorldReadable"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean loadFromZip(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NativeLoader.loadFromZip(android.content.Context, java.io.File, java.io.File, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00da A[Catch: all -> 0x001c, TryCatch #5 {all -> 0x001c, blocks: (B:9:0x000a, B:11:0x0015, B:17:0x0020, B:18:0x0023, B:42:0x008d, B:44:0x0095, B:47:0x00a0, B:49:0x00bb, B:51:0x00bf, B:52:0x00c4, B:57:0x00d6, B:59:0x00da, B:60:0x00ee, B:56:0x00d0, B:21:0x0032, B:24:0x003d, B:27:0x0048, B:30:0x0053, B:33:0x0060, B:36:0x006b, B:38:0x0071, B:41:0x0088), top: B:78:0x000a, outer: #3, inners: #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5 A[RETURN] */
    @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void initNativeLibs(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.NativeLoader.initNativeLibs(android.content.Context):void");
    }
}
