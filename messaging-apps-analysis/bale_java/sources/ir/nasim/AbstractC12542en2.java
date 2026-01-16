package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.FileAlreadyExistsException;
import kotlin.io.FileSystemException;
import kotlin.io.NoSuchFileException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.en2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12542en2 extends AbstractC11930dn2 {
    public static final File n(File file, File file2, boolean z, int i) throws IOException {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(file2, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (file2.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = file2.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    AbstractC7873To0.a(fileInputStream, fileOutputStream, i);
                    YV0.a(fileOutputStream, null);
                    YV0.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!file2.mkdirs()) {
            throw new FileSystemException(file, file2, "Failed to create target directory.");
        }
        return file2;
    }

    public static /* synthetic */ File o(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return n(file, file2, z, i);
    }

    public static boolean p(File file) {
        AbstractC13042fc3.i(file, "<this>");
        while (true) {
            boolean z = true;
            for (File file2 : AbstractC11930dn2.m(file)) {
                if (!file2.delete() && file2.exists()) {
                    z = false;
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        }
    }

    public static String q(File file) {
        AbstractC13042fc3.i(file, "<this>");
        String name = file.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return AbstractC20762sZ6.a1(name, '.', "");
    }

    public static String r(File file) {
        AbstractC13042fc3.i(file, "<this>");
        String name = file.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return AbstractC20762sZ6.l1(name, Separators.DOT, null, 2, null);
    }

    private static final C7609Sl2 s(C7609Sl2 c7609Sl2) {
        return new C7609Sl2(c7609Sl2.a(), t(c7609Sl2.b()));
    }

    private static final List t(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String name = file.getName();
            if (!AbstractC13042fc3.d(name, Separators.DOT)) {
                if (!AbstractC13042fc3.d(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || AbstractC13042fc3.d(((File) AbstractC15401jX0.C0(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    public static File u(File file, File file2) throws IOException {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(file2, "base");
        String strX = x(file, file2);
        if (strX != null) {
            return new File(strX);
        }
        return null;
    }

    public static final File v(File file, File file2) {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(file2, "relative");
        if (AbstractC10545bn2.b(file2)) {
            return file2;
        }
        String string = file.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (!AbstractC20762sZ6.b0(string, c, false, 2, null)) {
                return new File(string + c + file2);
            }
        }
        return new File(string + file2);
    }

    public static File w(File file, String str) {
        AbstractC13042fc3.i(file, "<this>");
        AbstractC13042fc3.i(str, "relative");
        return v(file, new File(str));
    }

    private static final String x(File file, File file2) throws IOException {
        C7609Sl2 c7609Sl2S = s(AbstractC10545bn2.c(file));
        C7609Sl2 c7609Sl2S2 = s(AbstractC10545bn2.c(file2));
        if (!AbstractC13042fc3.d(c7609Sl2S.a(), c7609Sl2S2.a())) {
            return null;
        }
        int iC = c7609Sl2S2.c();
        int iC2 = c7609Sl2S.c();
        int iMin = Math.min(iC2, iC);
        int i = 0;
        while (i < iMin && AbstractC13042fc3.d(c7609Sl2S.b().get(i), c7609Sl2S2.b().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = iC - 1;
        if (i <= i2) {
            while (!AbstractC13042fc3.d(((File) c7609Sl2S2.b().get(i2)).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < iC2) {
            if (i < iC) {
                sb.append(File.separatorChar);
            }
            List listK0 = AbstractC15401jX0.k0(c7609Sl2S.b(), i);
            String str = File.separator;
            AbstractC13042fc3.h(str, "separator");
            AbstractC15401jX0.x0(listK0, sb, (124 & 2) != 0 ? ", " : str, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        return sb.toString();
    }
}
