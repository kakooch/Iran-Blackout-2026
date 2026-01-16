package ir.nasim;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.provider.ContactsContract;
import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.Qe1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7077Qe1 extends ContentObserver {
    public static final a b = new a(null);
    public static final int c = 8;
    private InterfaceC13730gj3 a;

    /* renamed from: ir.nasim.Qe1$a */
    public static final class a {
        private a() {
        }

        public final void a(ContentResolver contentResolver) {
            AbstractC13042fc3.i(contentResolver, "contentResolver");
            try {
                contentResolver.registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new C7077Qe1());
            } catch (Exception e) {
                C19406qI3.b("ContactContentObserver", e.getMessage());
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Qe1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C5735Kp4.q.i().f1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C7077Qe1() {
        super(null);
    }

    public static final void a(ContentResolver contentResolver) {
        b.a(contentResolver);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        InterfaceC13730gj3 interfaceC13730gj3 = this.a;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.a = AbstractC10533bm0.d(C17050mJ2.a, null, null, new b(null), 3, null);
    }
}
