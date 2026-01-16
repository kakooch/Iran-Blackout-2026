package j$.util;

/* loaded from: classes2.dex */
public final class v {
    private final String a;
    private final String b;
    private final String c;
    private StringBuilder d;
    private String e;

    public v(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        if (charSequence2 == null) {
            throw new NullPointerException("The prefix must not be null");
        }
        if (charSequence == null) {
            throw new NullPointerException("The delimiter must not be null");
        }
        if (charSequence3 == null) {
            throw new NullPointerException("The suffix must not be null");
        }
        String string = charSequence2.toString();
        this.a = string;
        this.b = charSequence.toString();
        String string2 = charSequence3.toString();
        this.c = string2;
        this.e = string + string2;
    }

    private StringBuilder c() {
        StringBuilder sb = this.d;
        if (sb != null) {
            sb.append(this.b);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.a);
            this.d = sb2;
        }
        return this.d;
    }

    public v a(CharSequence charSequence) {
        c().append(charSequence);
        return this;
    }

    public v b(v vVar) {
        vVar.getClass();
        StringBuilder sb = vVar.d;
        if (sb != null) {
            c().append((CharSequence) vVar.d, vVar.a.length(), sb.length());
        }
        return this;
    }

    public String toString() {
        if (this.d == null) {
            return this.e;
        }
        if (this.c.equals("")) {
            return this.d.toString();
        }
        int length = this.d.length();
        StringBuilder sb = this.d;
        sb.append(this.c);
        String string = sb.toString();
        this.d.setLength(length);
        return string;
    }
}
