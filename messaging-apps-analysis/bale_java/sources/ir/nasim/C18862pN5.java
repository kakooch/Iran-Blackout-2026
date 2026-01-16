package ir.nasim;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.pN5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18862pN5 {
    private final String a;
    private final CharSequence b;
    private final CharSequence[] c;
    private final boolean d;
    private final int e;
    private final Bundle f;
    private final Set g;

    /* renamed from: ir.nasim.pN5$a */
    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(C18862pN5 c18862pN5) {
            Set setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(c18862pN5.i()).setLabel(c18862pN5.h()).setChoices(c18862pN5.e()).setAllowFreeFormInput(c18862pN5.c()).addExtras(c18862pN5.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = c18862pN5.d()) != null) {
                Iterator it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, c18862pN5.f());
            }
            return builderAddExtras.build();
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* renamed from: ir.nasim.pN5$b */
    static class b {
        static void a(C18862pN5 c18862pN5, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(C18862pN5.a(c18862pN5), intent, map);
        }

        static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z) {
            return builder.setAllowDataType(str, z);
        }
    }

    /* renamed from: ir.nasim.pN5$c */
    static class c {
        static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder b(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }
    }

    /* renamed from: ir.nasim.pN5$d */
    public static final class d {
        private final String a;
        private CharSequence d;
        private CharSequence[] e;
        private final Set b = new HashSet();
        private final Bundle c = new Bundle();
        private boolean f = true;
        private int g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.a = str;
        }

        public C18862pN5 a() {
            return new C18862pN5(this.a, this.d, this.e, this.f, this.g, this.c, this.b);
        }

        public d b(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    C18862pN5(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set set) {
        this.a = str;
        this.b = charSequence;
        this.c = charSequenceArr;
        this.d = z;
        this.e = i;
        this.f = bundle;
        this.g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    static RemoteInput a(C18862pN5 c18862pN5) {
        return a.b(c18862pN5);
    }

    static RemoteInput[] b(C18862pN5[] c18862pN5Arr) {
        if (c18862pN5Arr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c18862pN5Arr.length];
        for (int i = 0; i < c18862pN5Arr.length; i++) {
            remoteInputArr[i] = a(c18862pN5Arr[i]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return a.c(intent);
    }

    public boolean c() {
        return this.d;
    }

    public Set d() {
        return this.g;
    }

    public CharSequence[] e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public Bundle g() {
        return this.f;
    }

    public CharSequence h() {
        return this.b;
    }

    public String i() {
        return this.a;
    }

    public boolean k() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
