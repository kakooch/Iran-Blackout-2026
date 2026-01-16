package ir.nasim;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.b85, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C10138b85 implements Externalizable {
    private boolean a;
    private boolean e;
    private String b = "";
    private List c = new ArrayList();
    private List d = new ArrayList();
    private String f = "";

    public String a() {
        return this.b;
    }

    public int b(int i) {
        return ((Integer) this.c.get(i)).intValue();
    }

    public int c() {
        return this.c.size();
    }

    public List d() {
        return this.c;
    }

    public int e() {
        return this.d.size();
    }

    public List f() {
        return this.d;
    }

    public C10138b85 g(String str) {
        this.e = true;
        this.f = str;
        return this;
    }

    public C10138b85 j(String str) {
        this.a = true;
        this.b = str;
        return this;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            j(objectInput.readUTF());
        }
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.c.add(Integer.valueOf(objectInput.readInt()));
        }
        int i3 = objectInput.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.d.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            g(objectInput.readUTF());
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.a);
        if (this.a) {
            objectOutput.writeUTF(this.b);
        }
        int iC = c();
        objectOutput.writeInt(iC);
        for (int i = 0; i < iC; i++) {
            objectOutput.writeInt(((Integer) this.c.get(i)).intValue());
        }
        int iE = e();
        objectOutput.writeInt(iE);
        for (int i2 = 0; i2 < iE; i2++) {
            objectOutput.writeInt(((Integer) this.d.get(i2)).intValue());
        }
        objectOutput.writeBoolean(this.e);
        if (this.e) {
            objectOutput.writeUTF(this.f);
        }
    }
}
