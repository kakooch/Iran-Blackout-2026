package ir.nasim;

/* loaded from: classes8.dex */
class UH6 implements SH6 {
    Class a;
    String b;
    int c;

    UH6(Class cls, String str, int i) {
        this.a = cls;
        this.b = str;
        this.c = i;
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(":");
        stringBuffer.append(b());
        return stringBuffer.toString();
    }
}
