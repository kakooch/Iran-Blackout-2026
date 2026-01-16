package ir.nasim;

/* renamed from: ir.nasim.pt3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19167pt3 {
    public static final EnumC18576ot3 a(String str) {
        AbstractC13042fc3.i(str, "<this>");
        EnumC18576ot3 enumC18576ot3 = EnumC18576ot3.b;
        if (AbstractC13042fc3.d(str, enumC18576ot3.j())) {
            return enumC18576ot3;
        }
        EnumC18576ot3 enumC18576ot32 = EnumC18576ot3.c;
        if (!AbstractC13042fc3.d(str, enumC18576ot32.j())) {
            enumC18576ot32 = EnumC18576ot3.d;
            if (!AbstractC13042fc3.d(str, enumC18576ot32.j())) {
                enumC18576ot32 = EnumC18576ot3.e;
                if (!AbstractC13042fc3.d(str, enumC18576ot32.j())) {
                    return enumC18576ot3;
                }
            }
        }
        return enumC18576ot32;
    }
}
