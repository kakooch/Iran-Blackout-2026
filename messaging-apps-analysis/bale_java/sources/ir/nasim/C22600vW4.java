package ir.nasim;

import android.os.Build;
import android.os.ParcelFileDescriptor;

/* renamed from: ir.nasim.vW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22600vW4 implements HW5 {
    private final C16602lZ1 a;

    public C22600vW4(C16602lZ1 c16602lZ1) {
        this.a = c16602lZ1;
    }

    private boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }

    @Override // ir.nasim.HW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DW5 a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, HL4 hl4) {
        return this.a.d(parcelFileDescriptor, i, i2, hl4);
    }

    @Override // ir.nasim.HW5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ParcelFileDescriptor parcelFileDescriptor, HL4 hl4) {
        return e(parcelFileDescriptor) && this.a.o(parcelFileDescriptor);
    }
}
