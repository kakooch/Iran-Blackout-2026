package ir.nasim;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;

/* renamed from: ir.nasim.f27, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC12694f27 extends Closeable {
    String A();

    boolean D1();

    void I();

    List N();

    boolean N1();

    void O(String str);

    Cursor P1(InterfaceC14514i27 interfaceC14514i27);

    InterfaceC15121j27 Z0(String str);

    void h0();

    void i0(String str, Object[] objArr);

    boolean isOpen();

    void j0();

    Cursor p0(InterfaceC14514i27 interfaceC14514i27, CancellationSignal cancellationSignal);

    Cursor r1(String str);

    void t0();
}
