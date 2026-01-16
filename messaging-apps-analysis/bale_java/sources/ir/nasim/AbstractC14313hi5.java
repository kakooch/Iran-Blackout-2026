package ir.nasim;

import kotlin.KotlinNothingValueException;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.hi5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14313hi5 {
    public static final XI1 a(AbstractC24673z1 abstractC24673z1, kotlinx.serialization.encoding.c cVar, String str) {
        AbstractC13042fc3.i(abstractC24673z1, "<this>");
        AbstractC13042fc3.i(cVar, "decoder");
        XI1 xi1C = abstractC24673z1.c(cVar, str);
        if (xi1C != null) {
            return xi1C;
        }
        A1.b(str, abstractC24673z1.e());
        throw new KotlinNothingValueException();
    }

    public static final InterfaceC22798vq6 b(AbstractC24673z1 abstractC24673z1, Encoder encoder, Object obj) {
        AbstractC13042fc3.i(abstractC24673z1, "<this>");
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(obj, "value");
        InterfaceC22798vq6 interfaceC22798vq6D = abstractC24673z1.d(encoder, obj);
        if (interfaceC22798vq6D != null) {
            return interfaceC22798vq6D;
        }
        A1.a(AbstractC10882cM5.b(obj.getClass()), abstractC24673z1.e());
        throw new KotlinNothingValueException();
    }
}
