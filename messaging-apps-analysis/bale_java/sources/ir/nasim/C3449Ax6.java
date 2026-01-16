package ir.nasim;

import android.graphics.Paint;
import java.util.List;

/* renamed from: ir.nasim.Ax6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3449Ax6 implements InterfaceC9904al1 {
    private final String a;
    private final C17380ms b;
    private final List c;
    private final C16789ls d;
    private final C18562os e;
    private final C17380ms f;
    private final a g;
    private final b h;
    private final float i;
    private final boolean j;

    /* renamed from: ir.nasim.Ax6$a */
    public enum a {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap j() {
            int iOrdinal = ordinal();
            return iOrdinal != 0 ? iOrdinal != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* renamed from: ir.nasim.Ax6$b */
    public enum b {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join j() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return Paint.Join.MITER;
            }
            if (iOrdinal == 1) {
                return Paint.Join.ROUND;
            }
            if (iOrdinal != 2) {
                return null;
            }
            return Paint.Join.BEVEL;
        }
    }

    public C3449Ax6(String str, C17380ms c17380ms, List list, C16789ls c16789ls, C18562os c18562os, C17380ms c17380ms2, a aVar, b bVar, float f, boolean z) {
        this.a = str;
        this.b = c17380ms;
        this.c = list;
        this.d = c16789ls;
        this.e = c18562os;
        this.f = c17380ms2;
        this.g = aVar;
        this.h = bVar;
        this.i = f;
        this.j = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C24999zZ6(qVar, abstractC3236Aa0, this);
    }

    public a b() {
        return this.g;
    }

    public C16789ls c() {
        return this.d;
    }

    public C17380ms d() {
        return this.b;
    }

    public b e() {
        return this.h;
    }

    public List f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public C18562os i() {
        return this.e;
    }

    public C17380ms j() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }
}
