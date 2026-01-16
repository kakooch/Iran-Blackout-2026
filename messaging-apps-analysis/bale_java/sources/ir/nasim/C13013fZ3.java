package ir.nasim;

import android.text.TextUtils;

/* renamed from: ir.nasim.fZ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C13013fZ3 implements ZY3 {
    private String a;
    private int b;
    private int c;

    C13013fZ3(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13013fZ3)) {
            return false;
        }
        C13013fZ3 c13013fZ3 = (C13013fZ3) obj;
        return (this.b < 0 || c13013fZ3.b < 0) ? TextUtils.equals(this.a, c13013fZ3.a) && this.c == c13013fZ3.c : TextUtils.equals(this.a, c13013fZ3.a) && this.b == c13013fZ3.b && this.c == c13013fZ3.c;
    }

    public int hashCode() {
        return FG4.b(this.a, Integer.valueOf(this.c));
    }
}
