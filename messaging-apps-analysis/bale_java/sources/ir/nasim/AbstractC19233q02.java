package ir.nasim;

import android.graphics.Paint;
import ir.nasim.AZ6;
import ir.nasim.AbstractC24405yZ6;

/* renamed from: ir.nasim.q02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19233q02 {
    public static final Paint.Cap a(int i) {
        AbstractC24405yZ6.a aVar = AbstractC24405yZ6.a;
        return AbstractC24405yZ6.e(i, aVar.a()) ? Paint.Cap.BUTT : AbstractC24405yZ6.e(i, aVar.b()) ? Paint.Cap.ROUND : AbstractC24405yZ6.e(i, aVar.c()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    public static final Paint.Join b(int i) {
        AZ6.a aVar = AZ6.a;
        return AZ6.e(i, aVar.b()) ? Paint.Join.MITER : AZ6.e(i, aVar.c()) ? Paint.Join.ROUND : AZ6.e(i, aVar.a()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }
}
