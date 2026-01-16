package ir.nasim;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Y75 implements Externalizable {
    private boolean a;
    private boolean c;
    private boolean f;
    private boolean h;
    private boolean j;
    private String b = "";
    private String d = "";
    private List e = new ArrayList();
    private String g = "";
    private boolean i = false;
    private String k = "";

    public String a() {
        return this.k;
    }

    public String b() {
        return this.d;
    }

    public String c(int i) {
        return (String) this.e.get(i);
    }

    public int d() {
        return this.e.size();
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.b;
    }

    public int g() {
        return d();
    }

    public Y75 j(String str) {
        this.j = true;
        this.k = str;
        return this;
    }

    public Y75 k(String str) {
        this.c = true;
        this.d = str;
        return this;
    }

    public Y75 l(String str) {
        this.f = true;
        this.g = str;
        return this;
    }

    public Y75 m(boolean z) {
        this.h = true;
        this.i = z;
        return this;
    }

    public Y75 n(String str) {
        this.a = true;
        this.b = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        n(objectInput.readUTF());
        k(objectInput.readUTF());
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.e.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            l(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            j(objectInput.readUTF());
        }
        m(objectInput.readBoolean());
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.b);
        objectOutput.writeUTF(this.d);
        int iG = g();
        objectOutput.writeInt(iG);
        for (int i = 0; i < iG; i++) {
            objectOutput.writeUTF((String) this.e.get(i));
        }
        objectOutput.writeBoolean(this.f);
        if (this.f) {
            objectOutput.writeUTF(this.g);
        }
        objectOutput.writeBoolean(this.j);
        if (this.j) {
            objectOutput.writeUTF(this.k);
        }
        objectOutput.writeBoolean(this.i);
    }
}
