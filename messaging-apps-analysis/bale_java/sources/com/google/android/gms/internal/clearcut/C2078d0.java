package com.google.android.gms.internal.clearcut;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.EnumC14348hl8;
import java.lang.reflect.Field;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.clearcut.d0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2078d0 {
    private int A;
    private int B;
    private Field C;
    private Object D;
    private Object E;
    private Object F;
    private final C2080e0 a;
    private final Object[] b;
    private Class c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int[] n;
    private int o;
    private int p;
    private int q = Integer.MAX_VALUE;
    private int r = RecyclerView.UNDEFINED_DURATION;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x;
    private int y;
    private int z;

    C2078d0(Class cls, String str, Object[] objArr) {
        this.c = cls;
        C2080e0 c2080e0 = new C2080e0(str);
        this.a = c2080e0;
        this.b = objArr;
        this.d = c2080e0.b();
        int iB = c2080e0.b();
        this.e = iB;
        if (iB == 0) {
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.l = 0;
            this.k = 0;
            this.m = 0;
            this.n = null;
            return;
        }
        int iB2 = c2080e0.b();
        this.f = iB2;
        int iB3 = c2080e0.b();
        this.g = iB3;
        this.h = c2080e0.b();
        this.i = c2080e0.b();
        this.l = c2080e0.b();
        this.k = c2080e0.b();
        this.j = c2080e0.b();
        this.m = c2080e0.b();
        int iB4 = c2080e0.b();
        this.n = iB4 != 0 ? new int[iB4] : null;
        this.o = (iB2 << 1) + iB3;
    }

    private static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private final Object f() {
        Object[] objArr = this.b;
        int i = this.o;
        this.o = i + 1;
        return objArr[i];
    }

    private final boolean i() {
        return (this.d & 1) == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean a() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C2078d0.a():boolean");
    }

    final int g() {
        return this.x;
    }

    final int h() {
        return this.z;
    }

    final boolean k() {
        return this.z > EnumC14348hl8.U0.a();
    }

    final Field l() {
        int i = this.A << 1;
        Object obj = this.b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldC = c(this.c, (String) obj);
        this.b[i] = fieldC;
        return fieldC;
    }

    final Field m() {
        int i = (this.A << 1) + 1;
        Object obj = this.b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldC = c(this.c, (String) obj);
        this.b[i] = fieldC;
        return fieldC;
    }

    final Field n() {
        return this.C;
    }

    final boolean o() {
        return i() && this.z <= EnumC14348hl8.w.a();
    }

    final Field p() {
        int i = (this.f << 1) + (this.B / 32);
        Object obj = this.b[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field fieldC = c(this.c, (String) obj);
        this.b[i] = fieldC;
        return fieldC;
    }

    final int q() {
        return this.B % 32;
    }

    final boolean r() {
        return (this.y & 256) != 0;
    }

    final boolean s() {
        return (this.y & 512) != 0;
    }

    final Object t() {
        return this.D;
    }

    final Object u() {
        return this.E;
    }

    final Object v() {
        return this.F;
    }
}
