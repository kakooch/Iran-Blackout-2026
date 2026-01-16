package ir.nasim;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Z75 implements Externalizable {
    private boolean A;
    private boolean B0;
    private boolean D;
    private boolean D0;
    private boolean F0;
    private boolean H;
    private boolean H0;
    private boolean J0;
    private boolean L0;
    private boolean N0;
    private boolean P0;
    private boolean T0;
    private boolean V0;
    private boolean X0;
    private boolean Y;
    private boolean Z0;
    private boolean a;
    private boolean c;
    private boolean e;
    private boolean g;
    private boolean i;
    private boolean k;
    private boolean m;
    private boolean o;
    private boolean q;
    private boolean s;
    private boolean u;
    private boolean w;
    private boolean y;
    private boolean z0;
    private C10138b85 b = null;
    private C10138b85 d = null;
    private C10138b85 f = null;
    private C10138b85 h = null;
    private C10138b85 j = null;
    private C10138b85 l = null;
    private C10138b85 n = null;
    private C10138b85 p = null;
    private C10138b85 r = null;
    private C10138b85 t = null;
    private C10138b85 v = null;
    private C10138b85 x = null;
    private C10138b85 z = null;
    private C10138b85 B = null;
    private C10138b85 G = null;
    private C10138b85 J = null;
    private C10138b85 Z = null;
    private String A0 = "";
    private int C0 = 0;
    private String E0 = "";
    private String G0 = "";
    private String I0 = "";
    private String K0 = "";
    private String M0 = "";
    private String O0 = "";
    private boolean Q0 = false;
    private List R0 = new ArrayList();
    private List S0 = new ArrayList();
    private boolean U0 = false;
    private String W0 = "";
    private boolean Y0 = false;
    private boolean a1 = false;

    public boolean C() {
        return this.J0;
    }

    public int D() {
        return e();
    }

    public int E() {
        return l();
    }

    public Z75 F(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.D = true;
        this.G = c10138b85;
        return this;
    }

    public Z75 G(int i) {
        this.B0 = true;
        this.C0 = i;
        return this;
    }

    public Z75 H(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.u = true;
        this.v = c10138b85;
        return this;
    }

    public Z75 J(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.c = true;
        this.d = c10138b85;
        return this;
    }

    public Z75 K(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.a = true;
        this.b = c10138b85;
        return this;
    }

    public Z75 L(String str) {
        this.z0 = true;
        this.A0 = str;
        return this;
    }

    public Z75 M(String str) {
        this.D0 = true;
        this.E0 = str;
        return this;
    }

    public Z75 N(String str) {
        this.V0 = true;
        this.W0 = str;
        return this;
    }

    public Z75 O(boolean z) {
        this.X0 = true;
        this.Y0 = z;
        return this;
    }

    public Z75 P(boolean z) {
        this.T0 = true;
        this.U0 = z;
        return this;
    }

    public Z75 Q(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.e = true;
        this.f = c10138b85;
        return this;
    }

    public Z75 R(boolean z) {
        this.Z0 = true;
        this.a1 = z;
        return this;
    }

    public Z75 S(String str) {
        this.H0 = true;
        this.I0 = str;
        return this;
    }

    public Z75 T(String str) {
        this.L0 = true;
        this.M0 = str;
        return this;
    }

    public Z75 U(String str) {
        this.N0 = true;
        this.O0 = str;
        return this;
    }

    public Z75 V(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.Y = true;
        this.Z = c10138b85;
        return this;
    }

    public Z75 W(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.q = true;
        this.r = c10138b85;
        return this;
    }

    public Z75 X(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.m = true;
        this.n = c10138b85;
        return this;
    }

    public Z75 Y(String str) {
        this.J0 = true;
        this.K0 = str;
        return this;
    }

    public Z75 Z(String str) {
        this.F0 = true;
        this.G0 = str;
        return this;
    }

    public int a() {
        return this.C0;
    }

    public Z75 a0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.i = true;
        this.j = c10138b85;
        return this;
    }

    public C10138b85 b() {
        return this.d;
    }

    public Z75 b0(boolean z) {
        this.P0 = true;
        this.Q0 = z;
        return this;
    }

    public C10138b85 c() {
        return this.b;
    }

    public Z75 c0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.k = true;
        this.l = c10138b85;
        return this;
    }

    public String d() {
        return this.E0;
    }

    public Z75 d0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.y = true;
        this.z = c10138b85;
        return this;
    }

    public int e() {
        return this.S0.size();
    }

    public Z75 e0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.H = true;
        this.J = c10138b85;
        return this;
    }

    public List f() {
        return this.S0;
    }

    public Z75 f0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.A = true;
        this.B = c10138b85;
        return this;
    }

    public C10138b85 g() {
        return this.f;
    }

    public Z75 g0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.g = true;
        this.h = c10138b85;
        return this;
    }

    public Z75 h0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.s = true;
        this.t = c10138b85;
        return this;
    }

    public Z75 i0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.w = true;
        this.x = c10138b85;
        return this;
    }

    public String j() {
        return this.M0;
    }

    public Z75 j0(C10138b85 c10138b85) {
        c10138b85.getClass();
        this.o = true;
        this.p = c10138b85;
        return this;
    }

    public String k() {
        return this.O0;
    }

    public int l() {
        return this.R0.size();
    }

    public List m() {
        return this.R0;
    }

    public C10138b85 n() {
        return this.r;
    }

    public C10138b85 p() {
        return this.n;
    }

    public String q() {
        return this.K0;
    }

    public C10138b85 r() {
        return this.j;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            C10138b85 c10138b85 = new C10138b85();
            c10138b85.readExternal(objectInput);
            K(c10138b85);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b852 = new C10138b85();
            c10138b852.readExternal(objectInput);
            J(c10138b852);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b853 = new C10138b85();
            c10138b853.readExternal(objectInput);
            Q(c10138b853);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b854 = new C10138b85();
            c10138b854.readExternal(objectInput);
            g0(c10138b854);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b855 = new C10138b85();
            c10138b855.readExternal(objectInput);
            a0(c10138b855);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b856 = new C10138b85();
            c10138b856.readExternal(objectInput);
            c0(c10138b856);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b857 = new C10138b85();
            c10138b857.readExternal(objectInput);
            X(c10138b857);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b858 = new C10138b85();
            c10138b858.readExternal(objectInput);
            j0(c10138b858);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b859 = new C10138b85();
            c10138b859.readExternal(objectInput);
            W(c10138b859);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8510 = new C10138b85();
            c10138b8510.readExternal(objectInput);
            h0(c10138b8510);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8511 = new C10138b85();
            c10138b8511.readExternal(objectInput);
            H(c10138b8511);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8512 = new C10138b85();
            c10138b8512.readExternal(objectInput);
            i0(c10138b8512);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8513 = new C10138b85();
            c10138b8513.readExternal(objectInput);
            d0(c10138b8513);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8514 = new C10138b85();
            c10138b8514.readExternal(objectInput);
            f0(c10138b8514);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8515 = new C10138b85();
            c10138b8515.readExternal(objectInput);
            F(c10138b8515);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8516 = new C10138b85();
            c10138b8516.readExternal(objectInput);
            e0(c10138b8516);
        }
        if (objectInput.readBoolean()) {
            C10138b85 c10138b8517 = new C10138b85();
            c10138b8517.readExternal(objectInput);
            V(c10138b8517);
        }
        L(objectInput.readUTF());
        G(objectInput.readInt());
        M(objectInput.readUTF());
        if (objectInput.readBoolean()) {
            Z(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            S(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            Y(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            T(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            U(objectInput.readUTF());
        }
        b0(objectInput.readBoolean());
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Y75 y75 = new Y75();
            y75.readExternal(objectInput);
            this.R0.add(y75);
        }
        int i3 = objectInput.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            Y75 y752 = new Y75();
            y752.readExternal(objectInput);
            this.S0.add(y752);
        }
        P(objectInput.readBoolean());
        if (objectInput.readBoolean()) {
            N(objectInput.readUTF());
        }
        O(objectInput.readBoolean());
        R(objectInput.readBoolean());
    }

    public C10138b85 s() {
        return this.l;
    }

    public C10138b85 u() {
        return this.h;
    }

    public C10138b85 w() {
        return this.t;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.a);
        if (this.a) {
            this.b.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.c);
        if (this.c) {
            this.d.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.e);
        if (this.e) {
            this.f.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.g);
        if (this.g) {
            this.h.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.i);
        if (this.i) {
            this.j.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.k);
        if (this.k) {
            this.l.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.m);
        if (this.m) {
            this.n.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.o);
        if (this.o) {
            this.p.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.q);
        if (this.q) {
            this.r.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.s);
        if (this.s) {
            this.t.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.u);
        if (this.u) {
            this.v.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.w);
        if (this.w) {
            this.x.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.y);
        if (this.y) {
            this.z.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.A);
        if (this.A) {
            this.B.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.D);
        if (this.D) {
            this.G.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.H);
        if (this.H) {
            this.J.writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.Y);
        if (this.Y) {
            this.Z.writeExternal(objectOutput);
        }
        objectOutput.writeUTF(this.A0);
        objectOutput.writeInt(this.C0);
        objectOutput.writeUTF(this.E0);
        objectOutput.writeBoolean(this.F0);
        if (this.F0) {
            objectOutput.writeUTF(this.G0);
        }
        objectOutput.writeBoolean(this.H0);
        if (this.H0) {
            objectOutput.writeUTF(this.I0);
        }
        objectOutput.writeBoolean(this.J0);
        if (this.J0) {
            objectOutput.writeUTF(this.K0);
        }
        objectOutput.writeBoolean(this.L0);
        if (this.L0) {
            objectOutput.writeUTF(this.M0);
        }
        objectOutput.writeBoolean(this.N0);
        if (this.N0) {
            objectOutput.writeUTF(this.O0);
        }
        objectOutput.writeBoolean(this.Q0);
        int iE = E();
        objectOutput.writeInt(iE);
        for (int i = 0; i < iE; i++) {
            ((Y75) this.R0.get(i)).writeExternal(objectOutput);
        }
        int iD = D();
        objectOutput.writeInt(iD);
        for (int i2 = 0; i2 < iD; i2++) {
            ((Y75) this.S0.get(i2)).writeExternal(objectOutput);
        }
        objectOutput.writeBoolean(this.U0);
        objectOutput.writeBoolean(this.V0);
        if (this.V0) {
            objectOutput.writeUTF(this.W0);
        }
        objectOutput.writeBoolean(this.Y0);
        objectOutput.writeBoolean(this.a1);
    }

    public C10138b85 y() {
        return this.x;
    }

    public C10138b85 z() {
        return this.p;
    }
}
