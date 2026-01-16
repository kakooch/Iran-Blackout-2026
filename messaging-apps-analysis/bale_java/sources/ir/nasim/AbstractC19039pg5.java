package ir.nasim;

import java.util.ArrayList;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.pg5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19039pg5 {
    public static final void a(int i, int i2, SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & i2;
        for (int i4 = 0; i4 < 32; i4++) {
            if ((i3 & 1) != 0) {
                arrayList.add(serialDescriptor.e(i4));
            }
            i3 >>>= 1;
        }
        throw new MissingFieldException(arrayList, serialDescriptor.i());
    }
}
