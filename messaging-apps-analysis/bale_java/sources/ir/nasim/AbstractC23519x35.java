package ir.nasim;

import com.google.android.gms.tasks.Task;

/* renamed from: ir.nasim.x35, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23519x35 {
    private static final Uf8 a = new Pf8();

    /* renamed from: ir.nasim.x35$a */
    public interface a {
        Object a(InterfaceC10069b16 interfaceC10069b16);
    }

    public static Task a(AbstractC22929w35 abstractC22929w35, a aVar) {
        Uf8 uf8 = a;
        C4982Hj7 c4982Hj7 = new C4982Hj7();
        abstractC22929w35.addStatusListener(new Sf8(abstractC22929w35, c4982Hj7, aVar, uf8));
        return c4982Hj7.a();
    }

    public static Task b(AbstractC22929w35 abstractC22929w35) {
        return a(abstractC22929w35, new Tf8());
    }
}
