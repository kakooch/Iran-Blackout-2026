package ir.nasim;

import ir.nasim.C3593Bn1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class MO6 extends AbstractC21707u0 {
    public static String d;
    private final C9057Yh4 b;
    private final OK c;

    public MO6(C9057Yh4 c9057Yh4, AbstractC9119Yo3 abstractC9119Yo3) {
        super(c9057Yh4);
        this.b = c9057Yh4;
        this.c = new OK(abstractC9119Yo3, "D_db");
        if (AbstractC20507s76.E()) {
            d = "PASS_KEY_P";
        } else {
            d = "PASS_KEY";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D() {
        C15225jD4.b().c(C15225jD4.j, new ArrayList());
    }

    public void B() {
        KN6.b("ls_chat_");
        ArrayList arrayList = new ArrayList();
        for (String str : v().getAll().keySet()) {
            if (str.startsWith("conv_")) {
                arrayList.add(str);
            }
        }
        v().i(arrayList);
        Iterator it = this.b.G().A0().values().iterator();
        while (it.hasNext()) {
            ((C9528a7) it.next()).d(new C3593Bn1.d(true));
        }
        KN6.s().c();
    }

    public OK C() {
        return this.c;
    }

    public void E() {
        this.b.G().I0().j();
        KN6.b("ls_chat_");
        ArrayList arrayList = new ArrayList();
        for (String str : v().getAll().keySet()) {
            if (str.startsWith("conv_")) {
                arrayList.add(str);
            }
        }
        v().i(arrayList);
        Iterator it = this.b.G().A0().values().iterator();
        while (it.hasNext()) {
            ((C9528a7) it.next()).d(new C3593Bn1.d(true));
        }
        this.b.A().m0().l(false);
        v().remove("contact_list");
        KN6.s().c();
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.LO6
            @Override // java.lang.Runnable
            public final void run() {
                MO6.D();
            }
        });
    }
}
