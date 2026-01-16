package ir.nasim;

import android.content.Context;
import java.io.File;
import java.util.Map;

/* renamed from: ir.nasim.vy3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22878vy3 implements InterfaceC14123hO3 {
    private final Context a;
    private final Map b;

    public C22878vy3(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        XV4 xv4A = AbstractC4616Fw7.a("bale audio", EnumC9082Yk2.e);
        XV4 xv4A2 = AbstractC4616Fw7.a("bale documents", EnumC9082Yk2.d);
        EnumC9082Yk2 enumC9082Yk2 = EnumC9082Yk2.b;
        XV4 xv4A3 = AbstractC4616Fw7.a("bale images", enumC9082Yk2);
        XV4 xv4A4 = AbstractC4616Fw7.a("bale video", EnumC9082Yk2.c);
        XV4 xv4A5 = AbstractC4616Fw7.a("bale stories", enumC9082Yk2);
        EnumC9082Yk2 enumC9082Yk22 = EnumC9082Yk2.h;
        this.b = AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, AbstractC4616Fw7.a("tmp", enumC9082Yk22), AbstractC4616Fw7.a("upload_tmp", enumC9082Yk22), AbstractC4616Fw7.a("cache", enumC9082Yk22));
    }

    private final boolean c(File file, File file2) {
        String absolutePath = file.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        String absolutePath2 = file2.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath2, "getAbsolutePath(...)");
        return AbstractC20153rZ6.S(absolutePath, absolutePath2, false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.C11910dl2 a(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "legacyFilePath"
            ir.nasim.AbstractC13042fc3.i(r10, r0)
            boolean r0 = ir.nasim.AbstractC14836iZ6.n0(r10)
            if (r0 == 0) goto L15
            ir.nasim.dl2 r10 = new ir.nasim.dl2
            ir.nasim.Yk2 r0 = ir.nasim.EnumC9082Yk2.h
            ir.nasim.NN6 r1 = ir.nasim.NN6.c
            r10.<init>(r0, r1)
            return r10
        L15:
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            android.content.Context r10 = r9.a
            r1 = 0
            java.io.File r10 = r10.getExternalFilesDir(r1)
            android.content.Context r2 = r9.a
            java.io.File r2 = r2.getFilesDir()
            if (r2 == 0) goto L4c
            boolean r3 = r9.c(r0, r2)
            if (r3 == 0) goto L4c
            ir.nasim.NN6 r10 = ir.nasim.NN6.b
            java.io.File r0 = ir.nasim.AbstractC9925an2.u(r0, r2)
            if (r0 == 0) goto L49
            java.lang.String r2 = r0.getPath()
            if (r2 == 0) goto L49
            r6 = 4
            r7 = 0
            java.lang.String r3 = "\\"
            java.lang.String r4 = "/"
            r5 = 0
            java.lang.String r0 = ir.nasim.AbstractC14836iZ6.M(r2, r3, r4, r5, r6, r7)
            goto L4a
        L49:
            r0 = r1
        L4a:
            r2 = r0
            goto L72
        L4c:
            if (r10 == 0) goto Ld1
            boolean r2 = r9.c(r0, r10)
            if (r2 == 0) goto Ld1
            ir.nasim.NN6 r2 = ir.nasim.NN6.c
            java.io.File r10 = ir.nasim.AbstractC9925an2.u(r0, r10)
            if (r10 == 0) goto L6f
            java.lang.String r3 = r10.getPath()
            if (r3 == 0) goto L6f
            r7 = 4
            r8 = 0
            java.lang.String r4 = "\\"
            java.lang.String r5 = "/"
            r6 = 0
            java.lang.String r10 = ir.nasim.AbstractC14836iZ6.M(r3, r4, r5, r6, r7, r8)
            r0 = r10
            goto L70
        L6f:
            r0 = r1
        L70:
            r10 = r2
            goto L4a
        L72:
            if (r2 == 0) goto Lc9
            boolean r0 = ir.nasim.AbstractC14836iZ6.n0(r2)
            if (r0 == 0) goto L7b
            goto Lc9
        L7b:
            java.lang.String r0 = "/"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r6 = 6
            r7 = 0
            r4 = 0
            r5 = 0
            java.util.List r0 = ir.nasim.AbstractC14836iZ6.N0(r2, r3, r4, r5, r6, r7)
            java.lang.String r2 = "Bale"
            int r2 = r0.indexOf(r2)
            r3 = -1
            if (r2 == r3) goto La1
            int r2 = r2 + 1
            int r3 = r0.size()
            if (r2 >= r3) goto La1
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        La1:
            if (r1 == 0) goto Lc1
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r2 = "getDefault(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r2)
            java.lang.String r0 = r1.toLowerCase(r0)
            java.lang.String r1 = "toLowerCase(...)"
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            if (r0 == 0) goto Lc1
            java.util.Map r1 = r9.b
            java.lang.Object r0 = r1.get(r0)
            ir.nasim.Yk2 r0 = (ir.nasim.EnumC9082Yk2) r0
            if (r0 != 0) goto Lc3
        Lc1:
            ir.nasim.Yk2 r0 = ir.nasim.EnumC9082Yk2.h
        Lc3:
            ir.nasim.dl2 r1 = new ir.nasim.dl2
            r1.<init>(r0, r10)
            return r1
        Lc9:
            ir.nasim.dl2 r0 = new ir.nasim.dl2
            ir.nasim.Yk2 r1 = ir.nasim.EnumC9082Yk2.h
            r0.<init>(r1, r10)
            return r0
        Ld1:
            ir.nasim.dl2 r10 = new ir.nasim.dl2
            ir.nasim.Yk2 r0 = ir.nasim.EnumC9082Yk2.h
            ir.nasim.NN6 r1 = ir.nasim.NN6.c
            r10.<init>(r0, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22878vy3.a(java.lang.String):ir.nasim.dl2");
    }
}
