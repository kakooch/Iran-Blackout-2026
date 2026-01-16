package ir.nasim;

/* renamed from: ir.nasim.qc6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19591qc6 {
    private float a;
    private float b;

    public C19591qc6(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        return this.a == f && this.b == f2;
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public void d(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public C19591qc6() {
        this(1.0f, 1.0f);
    }
}
