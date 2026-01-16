package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
public final class VZ2 {
    public static final VZ2 a = new VZ2();
    private static final ThreadLocal b = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] initialValue() {
            return new byte[4096];
        }
    }

    private VZ2() {
    }

    public static final void a(File file, File file2) throws IOException {
        AbstractC13042fc3.i(file, "src");
        AbstractC13042fc3.i(file2, "dst");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = (byte[]) b.get();
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i <= 0) {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            } else {
                Thread.yield();
                fileOutputStream.write(bArr, 0, i);
            }
        }
    }

    public static final void b(InputStream inputStream, File file) throws IOException {
        AbstractC13042fc3.i(inputStream, "input");
        AbstractC13042fc3.i(file, "dst");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = (byte[]) b.get();
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                fileOutputStream.close();
                return;
            } else {
                Thread.yield();
                fileOutputStream.write(bArr, 0, i);
            }
        }
    }

    public static final String c(String str) {
        AbstractC13042fc3.i(str, "name");
        int iR0 = AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null);
        if (iR0 == -1) {
            return "";
        }
        String strSubstring = str.substring(iR0 + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }
}
