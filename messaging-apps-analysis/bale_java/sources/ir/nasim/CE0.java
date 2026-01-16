package ir.nasim;

import androidx.work.impl.WorkDatabase;
import ir.nasim.InterfaceC15297jL4;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class CE0 implements Runnable {
    private final C18843pL4 a = new C18843pL4();

    class a extends CE0 {
        final /* synthetic */ Za8 b;
        final /* synthetic */ UUID c;

        a(Za8 za8, UUID uuid) {
            this.b = za8;
            this.c = uuid;
        }

        @Override // ir.nasim.CE0
        void h() {
            WorkDatabase workDatabaseO = this.b.o();
            workDatabaseO.e();
            try {
                a(this.b, this.c.toString());
                workDatabaseO.F();
                workDatabaseO.j();
                g(this.b);
            } catch (Throwable th) {
                workDatabaseO.j();
                throw th;
            }
        }
    }

    class b extends CE0 {
        final /* synthetic */ Za8 b;
        final /* synthetic */ String c;

        b(Za8 za8, String str) {
            this.b = za8;
            this.c = str;
        }

        @Override // ir.nasim.CE0
        void h() {
            WorkDatabase workDatabaseO = this.b.o();
            workDatabaseO.e();
            try {
                Iterator it = workDatabaseO.Q().h(this.c).iterator();
                while (it.hasNext()) {
                    a(this.b, (String) it.next());
                }
                workDatabaseO.F();
                workDatabaseO.j();
                g(this.b);
            } catch (Throwable th) {
                workDatabaseO.j();
                throw th;
            }
        }
    }

    class c extends CE0 {
        final /* synthetic */ Za8 b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;

        c(Za8 za8, String str, boolean z) {
            this.b = za8;
            this.c = str;
            this.d = z;
        }

        @Override // ir.nasim.CE0
        void h() {
            WorkDatabase workDatabaseO = this.b.o();
            workDatabaseO.e();
            try {
                Iterator it = workDatabaseO.Q().e(this.c).iterator();
                while (it.hasNext()) {
                    a(this.b, (String) it.next());
                }
                workDatabaseO.F();
                workDatabaseO.j();
                if (this.d) {
                    g(this.b);
                }
            } catch (Throwable th) {
                workDatabaseO.j();
                throw th;
            }
        }
    }

    public static CE0 b(UUID uuid, Za8 za8) {
        return new a(za8, uuid);
    }

    public static CE0 c(String str, Za8 za8, boolean z) {
        return new c(za8, str, z);
    }

    public static CE0 d(String str, Za8 za8) {
        return new b(za8, str);
    }

    private void f(WorkDatabase workDatabase, String str) {
        InterfaceC18401ob8 interfaceC18401ob8Q = workDatabase.Q();
        InterfaceC11606dI1 interfaceC11606dI1I = workDatabase.I();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            Ta8 ta8F = interfaceC18401ob8Q.f(str2);
            if (ta8F != Ta8.SUCCEEDED && ta8F != Ta8.FAILED) {
                interfaceC18401ob8Q.b(Ta8.CANCELLED, str2);
            }
            linkedList.addAll(interfaceC11606dI1I.b(str2));
        }
    }

    void a(Za8 za8, String str) {
        f(za8.o(), str);
        za8.m().l(str);
        Iterator it = za8.n().iterator();
        while (it.hasNext()) {
            ((InterfaceC4435Fc6) it.next()).a(str);
        }
    }

    public InterfaceC15297jL4 e() {
        return this.a;
    }

    void g(Za8 za8) {
        AbstractC10449bd6.b(za8.i(), za8.o(), za8.n());
    }

    abstract void h();

    @Override // java.lang.Runnable
    public void run() {
        try {
            h();
            this.a.a(InterfaceC15297jL4.a);
        } catch (Throwable th) {
            this.a.a(new InterfaceC15297jL4.b.a(th));
        }
    }
}
