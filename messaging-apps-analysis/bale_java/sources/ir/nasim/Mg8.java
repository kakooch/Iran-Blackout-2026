package ir.nasim;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes3.dex */
public abstract class Mg8 implements IInterface {
    private final IBinder a;
    private final String h;

    protected Mg8(IBinder iBinder, String str) {
        this.a = iBinder;
        this.h = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
