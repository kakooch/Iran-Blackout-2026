package ir.nasim;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: ir.nasim.zs8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C25190zs8 {
    private static final Pattern b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");
    private final Rm8 a;

    C25190zs8(Rm8 rm8) {
        this.a = rm8;
    }

    static /* bridge */ /* synthetic */ Set a(C25190zs8 c25190zs8, Set set, Su8 su8, ZipFile zipFile) {
        HashSet hashSet = new HashSet();
        c25190zs8.f(su8, set, new C25170zq8(c25190zs8, hashSet, su8, zipFile));
        return hashSet;
    }

    private static void e(Su8 su8, InterfaceC9974ar8 interfaceC9974ar8) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(su8.a());
        } catch (IOException e) {
            e = e;
            zipFile = null;
        }
        try {
            String strB = su8.b();
            HashMap map = new HashMap();
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Matcher matcher = b.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", strB, strGroup2, strGroup));
                    Set hashSet = (Set) map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new Wr8(zipEntryNextElement, strGroup2));
                }
            }
            HashMap map2 = new HashMap();
            for (String str : Build.SUPPORTED_ABIS) {
                if (map.containsKey(str)) {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", str));
                    for (Wr8 wr8 : (Set) map.get(str)) {
                        if (map2.containsKey(wr8.a)) {
                            Log.d("SplitCompat", String.format("NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI", wr8.a, str));
                        } else {
                            map2.put(wr8.a, wr8);
                            Log.d("SplitCompat", String.format("NativeLibraryExtractor: using library %s for ABI %s", wr8.a, str));
                        }
                    }
                } else {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", str));
                }
            }
            interfaceC9974ar8.a(zipFile, new HashSet(map2.values()));
            zipFile.close();
        } catch (IOException e2) {
            e = e2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e3);
                }
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Su8 su8, Set set, Er8 er8) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Wr8 wr8 = (Wr8) it.next();
            File fileC = this.a.c(su8.b(), wr8.a);
            boolean z = false;
            if (fileC.exists() && fileC.length() == wr8.b.getSize() && Rm8.p(fileC)) {
                z = true;
            }
            er8.a(wr8, fileC, z);
        }
    }

    final Set b(Su8 su8) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        e(su8, new Po8(this, su8, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }

    final Set c() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<Su8> setJ = this.a.j();
        for (String str : this.a.h()) {
            Iterator it = setJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", str));
                    this.a.n(str);
                    break;
                }
                if (((Su8) it.next()).b().equals(str)) {
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Su8 su8 : setJ) {
            HashSet hashSet2 = new HashSet();
            e(su8, new Pp8(this, hashSet2, su8));
            for (File file : this.a.i(su8.b())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", file.getAbsolutePath(), su8.b(), su8.a().getAbsolutePath()));
                    this.a.o(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }
}
