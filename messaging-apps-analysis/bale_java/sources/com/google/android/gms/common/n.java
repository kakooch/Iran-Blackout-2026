package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.CG4;
import ir.nasim.InterfaceC14306hh8;
import ir.nasim.Mv8;
import ir.nasim.XZ2;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes3.dex */
abstract class n extends Mv8 {
    private final int a;

    protected n(byte[] bArr) {
        AbstractC3795Cj5.a(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] D2(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    abstract byte[] E2();

    @Override // ir.nasim.InterfaceC14306hh8
    public final XZ2 d() {
        return CG4.E2(E2());
    }

    @Override // ir.nasim.InterfaceC14306hh8
    public final int e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        XZ2 xz2D;
        if (obj != null && (obj instanceof InterfaceC14306hh8)) {
            try {
                InterfaceC14306hh8 interfaceC14306hh8 = (InterfaceC14306hh8) obj;
                if (interfaceC14306hh8.e() == this.a && (xz2D = interfaceC14306hh8.d()) != null) {
                    return Arrays.equals(E2(), (byte[]) CG4.D2(xz2D));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
