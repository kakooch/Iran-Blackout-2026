package org.rbmain.messenger;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

/* loaded from: classes.dex */
public class NativeLoader {
    private static final String LIB_NAME = "tmessages.38";
    private static final String LIB_SO_NAME = "libtmessages.38.so";
    private static final int LIB_VERSION = 38;
    private static final String LOCALE_LIB_SO_NAME = "libtmessages.38loc.so";
    public static volatile boolean nativeLoaded = false;
    private String crashPath = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;

    private static native void init(String str, boolean z);

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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean loadFromZip(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NativeLoader.loadFromZip(android.content.Context, java.io.File, java.io.File, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00d5 A[Catch: all -> 0x001c, TryCatch #4 {all -> 0x001c, blocks: (B:9:0x000a, B:11:0x0015, B:17:0x0020, B:18:0x0023, B:42:0x0089, B:44:0x0091, B:47:0x009b, B:49:0x00b6, B:51:0x00ba, B:52:0x00bf, B:57:0x00d1, B:59:0x00d5, B:60:0x00e9, B:56:0x00cb, B:21:0x0030, B:24:0x003b, B:27:0x0046, B:30:0x0051, B:33:0x005c, B:36:0x0067, B:38:0x006d, B:41:0x0084), top: B:75:0x000a, outer: #0, inners: #1, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void initNativeLibs(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.NativeLoader.initNativeLibs(android.content.Context):void");
    }
}
