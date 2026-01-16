package ir.nasim;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.a85, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C9544a85 implements Externalizable {
    private List a = new ArrayList();

    public int a() {
        return this.a.size();
    }

    public List b() {
        return this.a;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Z75 z75 = new Z75();
            z75.readExternal(objectInput);
            this.a.add(z75);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        int iA = a();
        objectOutput.writeInt(iA);
        for (int i = 0; i < iA; i++) {
            ((Z75) this.a.get(i)).writeExternal(objectOutput);
        }
    }
}
