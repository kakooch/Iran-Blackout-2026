package ir.nasim;

import ir.nasim.AbstractC21649tt7;
import java.util.Observable;

/* renamed from: ir.nasim.cV7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10965cV7 extends Observable {
    public void a() {
        deleteObservers();
    }

    public abstract boolean b();

    public final void c() {
        setChanged();
        notifyObservers();
    }

    public abstract AbstractC21649tt7.e d();
}
