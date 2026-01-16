package ir.nasim;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* renamed from: ir.nasim.pA0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC18740pA0 {

    /* renamed from: ir.nasim.pA0$a */
    public static final class a {
        public static void a(InterfaceC18740pA0 interfaceC18740pA0, Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            if (AbstractC19922rA0.a(interfaceC18740pA0) == objArr.length) {
                return;
            }
            throw new IllegalArgumentException("Callable expects " + AbstractC19922rA0.a(interfaceC18740pA0) + " arguments, but " + objArr.length + " were provided.");
        }
    }

    List a();

    Member b();

    Object call(Object[] objArr);

    Type getReturnType();
}
