package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.gov.nist.core.Separators;
import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* renamed from: ir.nasim.k36, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15721k36 {
    private final Context a;
    private boolean b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC9173Yu3 e;

    public C15721k36(Context context) {
        AbstractC13042fc3.i(context, "mContext");
        this.a = context;
        this.b = AbstractC21784u76.c();
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.h36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C15721k36.n(this.a));
            }
        });
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.i36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C15721k36.t(this.a));
            }
        });
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.j36
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C15721k36.s(this.a));
            }
        });
    }

    private final D46 e() {
        HashMap map = new HashMap();
        map.put("ro.debuggable", "1");
        map.put("ro.secure", "0");
        String[] strArrV = v();
        if (strArrV == null) {
            return D46.j;
        }
        for (String str : strArrV) {
            for (String str2 : map.keySet()) {
                if (AbstractC20762sZ6.X(str, str2, false, 2, null)) {
                    String str3 = "[" + ((String) map.get(str2)) + "]";
                    if (AbstractC20762sZ6.X(str, str3, false, 2, null)) {
                        C18635oz5.a.f(str2 + " = " + str3 + " detected!");
                        return D46.e;
                    }
                }
            }
        }
        return D46.j;
    }

    private final D46 f() {
        return d("magisk") ? D46.i : D46.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.D46 g() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15721k36.g():ir.nasim.D46");
    }

    private final D46 h() {
        D46 d46;
        if (d("su")) {
            return D46.d;
        }
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"which", "su"});
            } catch (Throwable th) {
                if (0 != 0) {
                    processExec.destroy();
                }
                throw th;
            }
        } catch (Throwable unused) {
            d46 = D46.j;
            if (0 != 0) {
            }
        }
        if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null) {
            D46 d462 = D46.d;
            processExec.destroy();
            return d462;
        }
        d46 = D46.j;
        processExec.destroy();
        return d46;
    }

    private final boolean k(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        String[] strArr2 = C5624Kd1.c;
        arrayList.addAll(AbstractC10360bX0.p(Arrays.copyOf(strArr2, strArr2.length)));
        if (strArr != null && strArr.length != 0) {
            arrayList.addAll(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
        }
        return q(arrayList);
    }

    private final D46 l() {
        return m(null) ? D46.b : D46.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(C15721k36 c15721k36) {
        AbstractC13042fc3.i(c15721k36, "this$0");
        return c15721k36.i(AbstractC10360bX0.p(c15721k36.l(), c15721k36.j(), c15721k36.e(), c15721k36.g(), c15721k36.o(), c15721k36.h(), c15721k36.f()));
    }

    private final boolean q(List list) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.a.getPackageManager();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                packageManager.getPackageInfo(str, 0);
                C18635oz5.a.b(str + " ROOT management app detected!");
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(C15721k36 c15721k36) {
        AbstractC13042fc3.i(c15721k36, "this$0");
        return c15721k36.r() || c15721k36.d("busybox");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(C15721k36 c15721k36) {
        AbstractC13042fc3.i(c15721k36, "this$0");
        return c15721k36.p() != 0;
    }

    private final String[] u() {
        List listM;
        try {
            InputStream inputStream = Runtime.getRuntime().exec("mount").getInputStream();
            if (inputStream == null) {
                return null;
            }
            String next = new Scanner(inputStream).useDelimiter("\\A").next();
            AbstractC13042fc3.f(next);
            List listM2 = new C20644sM5(Separators.RETURN).m(next, 0);
            if (listM2.isEmpty()) {
                listM = AbstractC10360bX0.m();
            } else {
                ListIterator listIterator = listM2.listIterator(listM2.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
            }
            return (String[]) listM.toArray(new String[0]);
        } catch (IOException e) {
            C18635oz5.a.a(e);
            return null;
        } catch (NoSuchElementException e2) {
            C18635oz5.a.a(e2);
            return null;
        }
    }

    private final String[] v() {
        List listM;
        try {
            InputStream inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
            if (inputStream == null) {
                return null;
            }
            String next = new Scanner(inputStream).useDelimiter("\\A").next();
            AbstractC13042fc3.f(next);
            List listM2 = new C20644sM5(Separators.RETURN).m(next, 0);
            if (listM2.isEmpty()) {
                listM = AbstractC10360bX0.m();
            } else {
                ListIterator listIterator = listM2.listIterator(listM2.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
            }
            return (String[]) listM.toArray(new String[0]);
        } catch (IOException e) {
            C18635oz5.a.a(e);
            return null;
        } catch (NoSuchElementException e2) {
            C18635oz5.a.a(e2);
            return null;
        }
    }

    public final boolean d(String str) {
        AbstractC13042fc3.i(str, "filename");
        for (String str2 : C5624Kd1.a()) {
            String str3 = str2 + str;
            if (new File(str2, str).exists()) {
                C18635oz5.a.f(str3 + " binary detected!");
                return true;
            }
        }
        return false;
    }

    public final int i(List list) {
        AbstractC13042fc3.i(list, "rootTypes");
        Iterator it = list.iterator();
        int iJ = 0;
        while (it.hasNext()) {
            iJ |= ((D46) it.next()).j();
        }
        return iJ;
    }

    public final D46 j() {
        return k(null) ? D46.c : D46.j;
    }

    public final boolean m(String[] strArr) {
        String[] strArr2 = C5624Kd1.b;
        ArrayList arrayList = new ArrayList(AbstractC10360bX0.p(Arrays.copyOf(strArr2, strArr2.length)));
        if (strArr != null && strArr.length != 0) {
            arrayList.addAll(AbstractC10360bX0.p(Arrays.copyOf(strArr, strArr.length)));
        }
        return q(arrayList);
    }

    public final D46 o() {
        String str = Build.TAGS;
        if (str == null) {
            str = null;
        }
        return (str == null || !AbstractC20762sZ6.X(str, "test-keys", false, 2, null)) ? D46.j : D46.g;
    }

    public final int p() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final boolean r() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }
}
