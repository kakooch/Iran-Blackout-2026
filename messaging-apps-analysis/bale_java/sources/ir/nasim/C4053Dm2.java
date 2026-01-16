package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Random;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: ir.nasim.Dm2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4053Dm2 implements InterfaceC3585Bm2 {
    public static final String c = "Bale Video" + File.separator + "Exo";
    private static int d = 0;
    private final Random a = new Random(AbstractC20507s76.p());
    private boolean b = true;

    private static void A(File file, Long[] lArr) {
        int i = 0;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                int length = fileArrListFiles.length;
                while (i < length) {
                    File file2 = fileArrListFiles[i];
                    if (!file2.getName().contains(".nomedia")) {
                        A(file2, lArr);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        int length2 = lArr.length;
        while (i < length2) {
            if (file.getName().contains(lArr[i].toString()) || file.getName().contains("const_")) {
                return;
            } else {
                i++;
            }
        }
        file.delete();
        d++;
    }

    private String B(String str) {
        return str == null ? "" : str.replaceAll("[\\\\/:*?\"<>|\\x00-\\x1F]", "_");
    }

    public static String C(String str, Bitmap bitmap) throws IOException {
        if (str == null || bitmap == null) {
            return null;
        }
        String strL = l(str, "jpg");
        if (strL != null) {
            File file = new File(strL);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            try {
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                C19406qI3.b("Exception", "File write failed: " + e.toString());
            }
        }
        return strL;
    }

    private String f(long j, String str) {
        String strO;
        String strB;
        String strR;
        String strP;
        if (str == null || str.isEmpty()) {
            C19406qI3.j("AndroidFileSystemProvider", "buildResultFile called with null or empty filename.", new Object[0]);
            str = "unknown_file";
        }
        if (str.startsWith("story_")) {
            String strU = u();
            if (strU == null) {
                C19406qI3.b("AndroidFileSystemProvider", "Stories directory path is null.");
                return null;
            }
            File file = new File(strU, B(str));
            File parentFile = file.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                return file.getAbsolutePath();
            }
            C19406qI3.b("AndroidFileSystemProvider", "Failed to create parent directory for story: " + parentFile.getAbsolutePath());
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        String str2 = "";
        boolean z = true;
        if (iLastIndexOf < 0 || iLastIndexOf >= str.length() - 1) {
            C19406qI3.a("AndroidFileSystemProvider", "Filename has no extension: " + str, new Object[0]);
            strO = null;
            strB = "";
        } else {
            String strSubstring = str.substring(iLastIndexOf + 1);
            strB = B(strSubstring.toLowerCase());
            strO = o(Separators.DOT + strSubstring.toLowerCase());
        }
        if (strO != null) {
            String strSubstring2 = strO.substring(0, strO.indexOf(Separators.SLASH));
            if (strSubstring2.equals("image")) {
                strP = ("avatar.png".equals(str) || "avatar.jpg".equals(str) || "sticker.webp".equals(str)) ? q() : s();
            } else if (strSubstring2.equals(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                strP = v();
            } else if (strSubstring2.equals(MediaStreamTrack.AUDIO_TRACK_KIND)) {
                strP = p();
            } else {
                strR = r();
            }
            strR = strP;
            z = false;
        } else {
            strR = r();
        }
        if (z && (strB.equals("opus") || strB.equals("ogg"))) {
            C19406qI3.a("AndroidFileSystemProvider", "Overriding path to Audio for opus/ogg extension.", new Object[0]);
            strR = p();
        }
        if (strR == null) {
            C19406qI3.b("AndroidFileSystemProvider", "Could not determine a valid destination directory for: " + str + ", mime: " + strO + ", ext: " + strB);
            strR = r();
            if (strR == null) {
                C19406qI3.b("AndroidFileSystemProvider", "Fallback Documents directory is also null. Cannot save file.");
                return null;
            }
        }
        String extensionFromMimeType = strO != null ? MimeTypeMap.getSingleton().getExtensionFromMimeType(strO) : null;
        if (extensionFromMimeType != null && !extensionFromMimeType.isEmpty()) {
            strB = B(extensionFromMimeType);
        } else if (strB.isEmpty()) {
            C19406qI3.a("AndroidFileSystemProvider", "Saving file without extension: " + str, new Object[0]);
            strB = "";
        }
        String str3 = j + "_" + System.nanoTime();
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        if (!strB.isEmpty()) {
            str2 = Separators.DOT + strB;
        }
        sb.append(str2);
        File file2 = new File(strR, sb.toString());
        File parentFile2 = file2.getParentFile();
        if (parentFile2 == null || parentFile2.exists() || parentFile2.mkdirs()) {
            return file2.getAbsolutePath();
        }
        C19406qI3.b("AndroidFileSystemProvider", "Failed to create parent directory for final file: " + parentFile2.getAbsolutePath());
        return null;
    }

    private String g() {
        File externalFilesDir = C5721Ko.b.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + Separators.SLASH + "Bale" + Separators.SLASH + "tmp");
        file.mkdirs();
        return new File(file, "temp_" + this.a.nextLong()).getAbsolutePath();
    }

    public static void h(boolean z) throws IOException {
        String strS = z ? s() : v();
        if (strS != null) {
            try {
                new File(strS, ".nomedia").createNewFile();
            } catch (IOException e) {
                C19406qI3.c("AndroidFileSystemProvider", "checkSaveToGalleryFiles", e);
            }
        }
    }

    private void i() {
        if (this.b) {
            this.b = false;
        }
    }

    private void j(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                FileChannel channel = fileInputStream.getChannel();
                channel.transferTo(0L, channel.size(), fileOutputStream.getChannel());
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String k(String str, boolean z) throws IOException {
        File fileT = t();
        if (fileT != null && fileT.isDirectory()) {
            try {
                File file = new File(t(), str);
                file.mkdirs();
                if (z && file.isDirectory()) {
                    try {
                        new File(file, ".nomedia").createNewFile();
                    } catch (IOException e) {
                        C19406qI3.d("NON_FATAL_EXCEPTION", e);
                    }
                }
                return file.getAbsolutePath() + File.separator;
            } catch (Exception e2) {
                C19406qI3.c("AndroidFileSystemProvider", "createNasimFolders", e2);
            }
        }
        return null;
    }

    public static String l(String str, String str2) {
        File externalFilesDir = C5721Ko.b.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + Separators.SLASH + "Bale" + Separators.SLASH + "tmp");
        file.mkdirs();
        return new File(file, str + "_" + C20590sG5.a() + "" + str2).getAbsolutePath();
    }

    public static String m(String str) {
        File externalFilesDir = C5721Ko.b.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + Separators.SLASH + "Bale" + Separators.SLASH + "upload_tmp");
        file.mkdirs();
        int i = C23073wI7.b;
        C23073wI7.b = i + (-1);
        return new File(file, C20590sG5.a() + "_" + i + Separators.DOT + str).getAbsolutePath();
    }

    public static String n(String str, String str2) {
        File filesDir = C5721Ko.b.getFilesDir();
        File file = new File((filesDir == null ? "data/data/".concat(C5721Ko.b.getPackageName()).concat("/cache") : filesDir.getAbsolutePath()) + Separators.SLASH + "Bale" + Separators.SLASH + "tmp");
        file.mkdirs();
        if (!file.exists()) {
            return null;
        }
        return new File(file, str + "_" + C20590sG5.a() + "" + str2).getAbsolutePath();
    }

    public static String o(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static String p() {
        return k("Bale Audio", true);
    }

    public static String q() throws IOException {
        File externalFilesDir = C5721Ko.b.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + Separators.SLASH + "Bale/cache/");
        file.mkdirs();
        try {
            new File(file, ".nomedia").createNewFile();
        } catch (IOException e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
        return file.getAbsolutePath() + File.separator;
    }

    public static String r() {
        return k("Bale Documents", true);
    }

    public static String s() {
        return k("Bale Images", true);
    }

    private static File t() {
        if (!x()) {
            System.out.println("this Android can't rename files");
            return null;
        }
        try {
            File file = new File(C5721Ko.b.getExternalFilesDir(null), "Bale");
            file.mkdirs();
            return file;
        } catch (Exception e) {
            C19406qI3.c("AndroidFileSystemProvider", "getNasimRootFilePath", e);
            return null;
        }
    }

    public static String u() {
        return k("Bale Stories", true);
    }

    public static String v() {
        return k("Bale Video", true);
    }

    public static String w() {
        return k(c, true);
    }

    private static boolean x() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(long j) {
        C19406qI3.a("AndroidFileSystemProvider", "removeExpiredStoryPhotosRecursive, removed " + d + " story files in " + (System.currentTimeMillis() - j) + " ms", new Object[0]);
    }

    public static void z(Long[] lArr) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        d = 0;
        String strU = u();
        if (strU != null) {
            A(new File(strU), lArr);
        }
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.Cm2
            @Override // java.lang.Runnable
            public final void run() {
                C4053Dm2.y(jCurrentTimeMillis);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3585Bm2
    public synchronized InterfaceC3346Am2 a(String str) {
        i();
        String strG = g();
        if (strG == null) {
            return null;
        }
        try {
            j(new File(str), new File(strG));
            return new C9115Yo(strG);
        } catch (IOException e) {
            C19406qI3.c("AndroidFileSystemProvider", "Failed to create temp file(" + e.getMessage() + Separators.RPAREN, e);
            return null;
        }
    }

    @Override // ir.nasim.InterfaceC3585Bm2
    public synchronized InterfaceC3346Am2 b(String str) {
        i();
        return new C9115Yo(str);
    }

    @Override // ir.nasim.InterfaceC3585Bm2
    public InterfaceC3346Am2 c(InterfaceC3346Am2 interfaceC3346Am2, long j, String str) {
        String strF = f(j, str);
        if (strF != null && new File(interfaceC3346Am2.getDescriptor()).renameTo(new File(strF))) {
            return new C9115Yo(strF);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC3585Bm2
    public synchronized InterfaceC3346Am2 d() {
        i();
        String strG = g();
        if (strG == null) {
            return null;
        }
        return new C9115Yo(strG);
    }
}
