package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.splitinstall.internal.zzbh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class NI6 {
    private static final AtomicReference e = new AtomicReference(null);
    public static final /* synthetic */ int f = 0;
    private final Rm8 a;
    private final Nj8 b;
    private final Set c = new HashSet();
    private final Ug8 d;

    private NI6(Context context) {
        try {
            Rm8 rm8 = new Rm8(context);
            this.a = rm8;
            this.d = new Ug8(rm8);
            this.b = new Nj8(context);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new zzbh("Failed to initialize FileStorage", e2);
        }
    }

    public static boolean a(Context context) {
        return h(context, false);
    }

    public static boolean d(Context context) {
        return h(context, true);
    }

    public static boolean e() {
        return e.get() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Set set) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Rm8.l(this.a.g((String) it.next()));
        }
        this.b.b();
    }

    private final synchronized void g(Context context, boolean z) {
        ZipFile zipFile;
        try {
            if (z) {
                this.a.k();
            } else {
                Ql8.a().execute(new RunnableC22846vu8(this));
            }
            String packageName = context.getPackageName();
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
                List<String> arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
                Set<Su8> setJ = this.a.j();
                Set setA = this.b.a();
                HashSet hashSet = new HashSet();
                Iterator it = setJ.iterator();
                while (it.hasNext()) {
                    String strB = ((Su8) it.next()).b();
                    if (arrayList.contains(strB) || setA.contains(Ou8.a(strB))) {
                        hashSet.add(strB);
                        it.remove();
                    }
                }
                if (z) {
                    f(hashSet);
                } else if (!hashSet.isEmpty()) {
                    Ql8.a().execute(new Du8(this, hashSet));
                }
                HashSet hashSet2 = new HashSet();
                Iterator it2 = setJ.iterator();
                while (it2.hasNext()) {
                    String strB2 = ((Su8) it2.next()).b();
                    if (!Ou8.c(strB2)) {
                        hashSet2.add(strB2);
                    }
                }
                for (String str : arrayList) {
                    if (!Ou8.c(str)) {
                        hashSet2.add(str);
                    }
                }
                HashSet<Su8> hashSet3 = new HashSet(setJ.size());
                for (Su8 su8 : setJ) {
                    if (Ou8.b(su8.b()) || hashSet2.contains(Ou8.a(su8.b()))) {
                        hashSet3.add(su8);
                    }
                }
                C25190zs8 c25190zs8 = new C25190zs8(this.a);
                InterfaceC19653qi8 interfaceC19653qi8A = AbstractC21540ti8.a();
                ClassLoader classLoader = context.getClassLoader();
                if (z) {
                    interfaceC19653qi8A.b(classLoader, c25190zs8.c());
                } else {
                    Iterator it3 = hashSet3.iterator();
                    while (it3.hasNext()) {
                        Set setB = c25190zs8.b((Su8) it3.next());
                        if (setB == null) {
                            it3.remove();
                        } else {
                            interfaceC19653qi8A.b(classLoader, setB);
                        }
                    }
                }
                HashSet hashSet4 = new HashSet();
                for (Su8 su82 : hashSet3) {
                    try {
                        zipFile = new ZipFile(su82.a());
                    } catch (IOException e2) {
                        e = e2;
                        zipFile = null;
                    }
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry == null || interfaceC19653qi8A.a(classLoader, this.a.a(su82.b()), su82.a(), z)) {
                            hashSet4.add(su82.a());
                        } else {
                            Log.w("SplitCompat", "split was not installed ".concat(su82.a().toString()));
                        }
                    } catch (IOException e3) {
                        e = e3;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(e, e4);
                                } catch (Exception unused) {
                                }
                            }
                        }
                        throw e;
                    }
                }
                this.d.a(context, hashSet4);
                HashSet hashSet5 = new HashSet();
                for (Su8 su83 : hashSet3) {
                    if (hashSet4.contains(su83.a())) {
                        Log.d("SplitCompat", "Split '" + su83.b() + "' installation emulated");
                        hashSet5.add(su83.b());
                    } else {
                        Log.d("SplitCompat", "Split '" + su83.b() + "' installation not emulated.");
                    }
                }
                synchronized (this.c) {
                    this.c.addAll(hashSet5);
                }
            } catch (PackageManager.NameNotFoundException e5) {
                throw new IOException(String.format("Cannot load data for application '%s'", packageName), e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static boolean h(final Context context, boolean z) {
        boolean z2;
        if (i()) {
            return false;
        }
        AtomicReference atomicReference = e;
        NI6 ni6 = new NI6(context);
        while (true) {
            if (AbstractC16775lq5.a(atomicReference, null, ni6)) {
                z2 = true;
                break;
            }
            if (atomicReference.get() != null) {
                z2 = false;
                break;
            }
        }
        NI6 ni62 = (NI6) e.get();
        if (z2) {
            Ws8.INSTANCE.a(new C13725gi8(context, Ql8.a(), new C17880ni8(context, ni62.a, new Rh8()), ni62.a, new Nu8(), null));
            Eu8.a(new It8(ni62));
            Ql8.a().execute(new Runnable() { // from class: ir.nasim.Vs8
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    int i = NI6.f;
                    try {
                        Ev8.f(context2).b(true);
                    } catch (SecurityException unused) {
                        Log.e("SplitCompat", "Failed to set broadcast receiver to always on.");
                    }
                }
            });
        }
        try {
            ni62.g(context, z);
            return true;
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error installing additional splits", e2);
            return false;
        }
    }

    private static boolean i() {
        return false;
    }
}
