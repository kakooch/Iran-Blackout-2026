package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: ir.nasim.Nq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6461Nq4 {
    private final YK3 a;

    public C6461Nq4(YK3 yk3) {
        this.a = yk3;
    }

    private static String b(String str, EnumC19677ql2 enumC19677ql2, boolean z) throws NoSuchAlgorithmException {
        String strJ = z ? enumC19677ql2.j() : enumC19677ql2.a;
        String strReplaceAll = str.replaceAll("\\W+", "");
        int length = 242 - strJ.length();
        if (strReplaceAll.length() > length) {
            strReplaceAll = d(strReplaceAll, length);
        }
        return "lottie_cache_" + strReplaceAll + strJ;
    }

    private File c(String str) {
        File file = new File(e(), b(str, EnumC19677ql2.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), b(str, EnumC19677ql2.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(e(), b(str, EnumC19677ql2.GZIP, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    private static String d(String str, int i) throws NoSuchAlgorithmException {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return str.substring(0, i);
        }
    }

    private File e() {
        File fileA = this.a.a();
        if (fileA.isFile()) {
            fileA.delete();
        }
        if (!fileA.exists()) {
            fileA.mkdirs();
        }
        return fileA;
    }

    Pair a(String str) {
        try {
            File fileC = c(str);
            if (fileC == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileC);
            EnumC19677ql2 enumC19677ql2 = fileC.getAbsolutePath().endsWith(".zip") ? EnumC19677ql2.ZIP : fileC.getAbsolutePath().endsWith(".gz") ? EnumC19677ql2.GZIP : EnumC19677ql2.JSON;
            JI3.a("Cache hit for " + str + " at " + fileC.getAbsolutePath());
            return new Pair(enumC19677ql2, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void f(String str, EnumC19677ql2 enumC19677ql2) throws NoSuchAlgorithmException {
        File file = new File(e(), b(str, enumC19677ql2, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        JI3.a("Copying temp file to real file (" + file2 + Separators.RPAREN);
        if (zRenameTo) {
            return;
        }
        JI3.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + Separators.DOT);
    }

    File g(String str, InputStream inputStream, EnumC19677ql2 enumC19677ql2) throws NoSuchAlgorithmException, IOException {
        File file = new File(e(), b(str, enumC19677ql2, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
