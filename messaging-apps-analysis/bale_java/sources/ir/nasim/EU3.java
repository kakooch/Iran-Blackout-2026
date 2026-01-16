package ir.nasim;

/* loaded from: classes2.dex */
public class EU3 {
    private final a a;
    private final C22221us b;
    private final C18562os c;
    private final boolean d;

    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public EU3(a aVar, C22221us c22221us, C18562os c18562os, boolean z) {
        this.a = aVar;
        this.b = c22221us;
        this.c = c18562os;
        this.d = z;
    }

    public a a() {
        return this.a;
    }

    public C22221us b() {
        return this.b;
    }

    public C18562os c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
