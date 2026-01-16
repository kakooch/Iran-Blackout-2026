package ir.nasim;

import android.content.Context;
import android.os.Build;
import androidx.tracing.perfetto.security.IncorrectChecksumException;
import androidx.tracing.perfetto.security.MissingChecksumException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.q96, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19327q96 {
    private final List a;

    /* renamed from: ir.nasim.q96$a */
    private static final class a {
        public static final a a = new a();

        private a() {
        }

        public final File a(Context context) {
            AbstractC13042fc3.i(context, "context");
            return context.getCodeCacheDir();
        }
    }

    /* renamed from: ir.nasim.q96$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final CharSequence a(byte b) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            AbstractC13042fc3.h(str, "format(this, *args)");
            return str;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).byteValue());
        }
    }

    /* renamed from: ir.nasim.q96$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke(File file) {
            AbstractC13042fc3.i(file, "it");
            return file.getParentFile();
        }
    }

    public C19327q96(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = AbstractC10360bX0.r(d(context), context.getCacheDir());
    }

    private final String a(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bArr = new byte[1024];
        InputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
        while (true) {
            try {
                int i = bufferedInputStream.read(bArr);
                if (i <= 0) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    YV0.a(bufferedInputStream, null);
                    byte[] bArrDigest = messageDigest.digest();
                    AbstractC13042fc3.h(bArrDigest, "digest.digest()");
                    return AbstractC10242bK.B0(bArrDigest, "", null, null, 0, null, b.e, 30, null);
                }
                messageDigest.update(bArr, 0, i);
            } finally {
            }
        }
    }

    private final File b(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("Cannot locate library file: " + file);
        }
        List list = this.a;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (e(file, (File) it.next())) {
                    return file;
                }
            }
        }
        File file2 = (File) AbstractC15401jX0.q0(this.a);
        String name = file.getName();
        AbstractC13042fc3.h(name, "file.name");
        return AbstractC12542en2.o(file, AbstractC12542en2.w(file2, name), true, 0, 4, null);
    }

    private final String c(Map map) {
        String[] strArr = Build.SUPPORTED_ABIS;
        AbstractC13042fc3.h(strArr, "SUPPORTED_ABIS");
        String str = (String) AbstractC10242bK.b0(strArr);
        AbstractC13042fc3.h(str, "abi");
        Object obj = map.get(str);
        if (obj != null) {
            return (String) obj;
        }
        throw new MissingChecksumException("Cannot locate checksum for ABI: " + str + " in " + map);
    }

    private final File d(Context context) {
        return a.a.a(context);
    }

    private final boolean e(File file, File file2) {
        Iterator it = AbstractC9962aq6.j(file.getParentFile(), c.e).iterator();
        while (it.hasNext()) {
            if (AbstractC13042fc3.d((File) it.next(), file2)) {
                return true;
            }
        }
        return false;
    }

    private final void g(File file, String str) {
        if (AbstractC13042fc3.d(a(file), str)) {
            return;
        }
        throw new IncorrectChecksumException("Invalid checksum for file: " + file + ". Ensure you are using correct version of the library and clear local caches.");
    }

    public final void f(File file, Map map) throws FileNotFoundException {
        AbstractC13042fc3.i(file, "file");
        AbstractC13042fc3.i(map, "abiToSha256Map");
        File fileB = b(file);
        g(fileB, c(map));
        System.load(fileB.getAbsolutePath());
    }
}
