package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes2.dex */
public abstract class JK3 {
    private static final Map a = new HashMap();
    private static final Set b = new HashSet();
    private static final byte[] c = {80, 75, 3, 4};
    private static final byte[] d = {31, -117, 8};

    public static C10255bL3 A(String str, String str2) {
        return x(Okio.source(new ByteArrayInputStream(str.getBytes())), str2);
    }

    public static com.airbnb.lottie.s B(Context context, int i) {
        return C(context, i, b0(context, i));
    }

    public static com.airbnb.lottie.s C(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return k(str, new Callable() { // from class: ir.nasim.HK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JK3.V(weakReference, applicationContext, i, str);
            }
        }, null);
    }

    public static C10255bL3 D(Context context, int i) {
        return E(context, i, b0(context, i));
    }

    public static C10255bL3 E(Context context, int i, String str) {
        C23677xK3 c23677xK3A = str == null ? null : C24267yK3.b().a(str);
        if (c23677xK3A != null) {
            return new C10255bL3(c23677xK3A);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (O(bufferedSourceBuffer).booleanValue()) {
                return J(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (!M(bufferedSourceBuffer).booleanValue()) {
                return u(AbstractC11911dl3.g(bufferedSourceBuffer), str);
            }
            try {
                return s(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
            } catch (IOException e) {
                return new C10255bL3((Throwable) e);
            }
        } catch (Resources.NotFoundException e2) {
            return new C10255bL3((Throwable) e2);
        }
    }

    public static com.airbnb.lottie.s F(Context context, String str) {
        return G(context, str, "url_" + str);
    }

    public static com.airbnb.lottie.s G(final Context context, final String str, final String str2) {
        return k(str2, new Callable() { // from class: ir.nasim.zK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JK3.W(context, str, str2);
            }
        }, null);
    }

    public static com.airbnb.lottie.s H(final Context context, final ZipInputStream zipInputStream, final String str) {
        return k(str, new Callable() { // from class: ir.nasim.CK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JK3.J(context, zipInputStream, str);
            }
        }, new Runnable() { // from class: ir.nasim.DK3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                AbstractC16500lN7.c(zipInputStream);
            }
        });
    }

    public static com.airbnb.lottie.s I(ZipInputStream zipInputStream, String str) {
        return H(null, zipInputStream, str);
    }

    public static C10255bL3 J(Context context, ZipInputStream zipInputStream, String str) {
        return K(context, zipInputStream, str, true);
    }

    public static C10255bL3 K(Context context, ZipInputStream zipInputStream, String str, boolean z) throws IOException {
        try {
            return L(context, zipInputStream, str);
        } finally {
            if (z) {
                AbstractC16500lN7.c(zipInputStream);
            }
        }
    }

    private static C10255bL3 L(Context context, ZipInputStream zipInputStream, String str) throws IOException {
        C23677xK3 c23677xK3A;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            c23677xK3A = null;
        } else {
            try {
                c23677xK3A = C24267yK3.b().a(str);
            } catch (IOException e) {
                return new C10255bL3((Throwable) e);
            }
        }
        if (c23677xK3A != null) {
            return new C10255bL3(c23677xK3A);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        C23677xK3 c23677xK3 = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                c23677xK3 = (C23677xK3) w(AbstractC11911dl3.g(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split(Separators.SLASH);
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split(Separators.SLASH);
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new C10255bL3((Throwable) new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (Throwable th3) {
                    JI3.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th3);
                }
                Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                if (!file.delete()) {
                    JI3.c("Failed to delete temp font file " + file.getAbsolutePath() + Separators.DOT);
                }
                map2.put(str3, typefaceCreateFromFile);
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (c23677xK3 == null) {
            return new C10255bL3((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            VK3 vk3L = l(c23677xK3, (String) entry.getKey());
            if (vk3L != null) {
                vk3L.g(AbstractC16500lN7.m((Bitmap) entry.getValue(), vk3L.f(), vk3L.d()));
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z = false;
            for (C8388Vt2 c8388Vt2 : c23677xK3.g().values()) {
                if (c8388Vt2.a().equals(entry2.getKey())) {
                    c8388Vt2.e((Typeface) entry2.getValue());
                    z = true;
                }
            }
            if (!z) {
                JI3.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it = c23677xK3.j().entrySet().iterator();
            while (it.hasNext()) {
                VK3 vk3 = (VK3) ((Map.Entry) it.next()).getValue();
                if (vk3 == null) {
                    return null;
                }
                String strC = vk3.c();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                        if (bitmapDecodeByteArray != null) {
                            vk3.g(AbstractC16500lN7.m(bitmapDecodeByteArray, vk3.f(), vk3.d()));
                        }
                    } catch (IllegalArgumentException e2) {
                        JI3.d("data URL did not have correct base64 format.", e2);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            C24267yK3.b().c(str, c23677xK3);
        }
        return new C10255bL3(c23677xK3);
    }

    private static Boolean M(BufferedSource bufferedSource) {
        return Z(bufferedSource, d);
    }

    private static boolean N(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean O(BufferedSource bufferedSource) {
        return Z(bufferedSource, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(String str, AtomicBoolean atomicBoolean, C23677xK3 c23677xK3) {
        Map map = a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            a0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            a0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C10255bL3 V(WeakReference weakReference, Context context, int i, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return E(context, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C10255bL3 W(Context context, String str, String str2) {
        C10255bL3 c10255bL3C = AbstractC6219Mr3.k(context).c(context, str, str2);
        if (str2 != null && c10255bL3C.b() != null) {
            C24267yK3.b().c(str2, (C23677xK3) c10255bL3C.b());
        }
        return c10255bL3C;
    }

    private static Boolean Z(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : bArr) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            JI3.b("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static void a0(boolean z) {
        ArrayList arrayList = new ArrayList(b);
        if (arrayList.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(arrayList.get(0));
        throw null;
    }

    private static String b0(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(N(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    private static com.airbnb.lottie.s k(final String str, Callable callable, Runnable runnable) {
        C23677xK3 c23677xK3A = str == null ? null : C24267yK3.b().a(str);
        com.airbnb.lottie.s sVar = c23677xK3A != null ? new com.airbnb.lottie.s(c23677xK3A) : null;
        if (str != null) {
            Map map = a;
            if (map.containsKey(str)) {
                sVar = (com.airbnb.lottie.s) map.get(str);
            }
        }
        if (sVar != null) {
            if (runnable != null) {
                runnable.run();
            }
            return sVar;
        }
        com.airbnb.lottie.s sVar2 = new com.airbnb.lottie.s(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            sVar2.d(new WK3() { // from class: ir.nasim.FK3
                @Override // ir.nasim.WK3
                public final void a(Object obj) {
                    JK3.P(str, atomicBoolean, (C23677xK3) obj);
                }
            });
            sVar2.c(new WK3() { // from class: ir.nasim.GK3
                @Override // ir.nasim.WK3
                public final void a(Object obj) {
                    JK3.Q(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = a;
                map2.put(str, sVar2);
                if (map2.size() == 1) {
                    a0(false);
                }
            }
        }
        return sVar2;
    }

    private static VK3 l(C23677xK3 c23677xK3, String str) {
        for (VK3 vk3 : c23677xK3.j().values()) {
            if (vk3.c().equals(str)) {
                return vk3;
            }
        }
        return null;
    }

    public static com.airbnb.lottie.s m(Context context, String str) {
        return n(context, str, "asset_" + str);
    }

    public static com.airbnb.lottie.s n(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return k(str2, new Callable() { // from class: ir.nasim.EK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JK3.p(applicationContext, str, str2);
            }
        }, null);
    }

    public static C10255bL3 o(Context context, String str) {
        return p(context, str, "asset_" + str);
    }

    public static C10255bL3 p(Context context, String str, String str2) {
        C23677xK3 c23677xK3A = str2 == null ? null : C24267yK3.b().a(str2);
        if (c23677xK3A != null) {
            return new C10255bL3(c23677xK3A);
        }
        try {
            return q(context, context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new C10255bL3((Throwable) e);
        }
    }

    public static C10255bL3 q(Context context, InputStream inputStream, String str) {
        C23677xK3 c23677xK3A = str == null ? null : C24267yK3.b().a(str);
        if (c23677xK3A != null) {
            return new C10255bL3(c23677xK3A);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStream));
            return O(bufferedSourceBuffer).booleanValue() ? J(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str) : M(bufferedSourceBuffer).booleanValue() ? s(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str) : u(AbstractC11911dl3.g(bufferedSourceBuffer), str);
        } catch (IOException e) {
            return new C10255bL3((Throwable) e);
        }
    }

    public static com.airbnb.lottie.s r(final InputStream inputStream, final String str) {
        return k(str, new Callable() { // from class: ir.nasim.AK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JK3.s(inputStream, str);
            }
        }, new Runnable() { // from class: ir.nasim.BK3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                AbstractC16500lN7.c(inputStream);
            }
        });
    }

    public static C10255bL3 s(InputStream inputStream, String str) {
        return t(inputStream, str, true);
    }

    public static C10255bL3 t(InputStream inputStream, String str, boolean z) {
        return y(Okio.source(inputStream), str, z);
    }

    public static C10255bL3 u(AbstractC11911dl3 abstractC11911dl3, String str) {
        return v(abstractC11911dl3, str, true);
    }

    public static C10255bL3 v(AbstractC11911dl3 abstractC11911dl3, String str, boolean z) {
        return w(abstractC11911dl3, str, z);
    }

    private static C10255bL3 w(AbstractC11911dl3 abstractC11911dl3, String str, boolean z) throws IOException {
        C23677xK3 c23677xK3A;
        try {
            if (str == null) {
                c23677xK3A = null;
            } else {
                try {
                    c23677xK3A = C24267yK3.b().a(str);
                } catch (Exception e) {
                    C10255bL3 c10255bL3 = new C10255bL3((Throwable) e);
                    if (z) {
                        AbstractC16500lN7.c(abstractC11911dl3);
                    }
                    return c10255bL3;
                }
            }
            if (c23677xK3A != null) {
                C10255bL3 c10255bL32 = new C10255bL3(c23677xK3A);
                if (z) {
                    AbstractC16500lN7.c(abstractC11911dl3);
                }
                return c10255bL32;
            }
            C23677xK3 c23677xK3A2 = KK3.a(abstractC11911dl3);
            if (str != null) {
                C24267yK3.b().c(str, c23677xK3A2);
            }
            C10255bL3 c10255bL33 = new C10255bL3(c23677xK3A2);
            if (z) {
                AbstractC16500lN7.c(abstractC11911dl3);
            }
            return c10255bL33;
        } catch (Throwable th) {
            if (z) {
                AbstractC16500lN7.c(abstractC11911dl3);
            }
            throw th;
        }
    }

    public static C10255bL3 x(Source source, String str) {
        return y(source, str, true);
    }

    public static C10255bL3 y(Source source, String str, boolean z) {
        return w(AbstractC11911dl3.g(Okio.buffer(source)), str, z);
    }

    public static com.airbnb.lottie.s z(final String str, final String str2) {
        return k(str2, new Callable() { // from class: ir.nasim.IK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JK3.A(str, str2);
            }
        }, null);
    }
}
