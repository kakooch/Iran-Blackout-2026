package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.bz3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10662bz3 {

    /* renamed from: ir.nasim.bz3$a */
    public interface a {
        String a(Object obj);
    }

    public static I01 b(String str, String str2) {
        return I01.j(AbstractC9443Zy3.a(str, str2), AbstractC9443Zy3.class);
    }

    public static I01 c(final String str, final a aVar) {
        return I01.k(AbstractC9443Zy3.class).b(C10226bI1.i(Context.class)).f(new Y01() { // from class: ir.nasim.az3
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return AbstractC10662bz3.d(str, aVar, s01);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AbstractC9443Zy3 d(String str, a aVar, S01 s01) {
        return AbstractC9443Zy3.a(str, aVar.a((Context) s01.a(Context.class)));
    }
}
