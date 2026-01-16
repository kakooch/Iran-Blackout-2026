package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.UserNamePlaceHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class GI7 {
    private final Context a;
    private final int b;
    private final InterfaceC20315ro1 c;
    private final AbstractC13778go1 d;
    private final InterfaceC11621dJ7 e;

    public static final class a {
        private final Context a;
        private final int b;
        private final Set c;

        public a(Context context, int i) {
            AbstractC13042fc3.i(context, "context");
            this.a = context;
            this.b = i;
            this.c = new LinkedHashSet();
        }

        private final String a(int i) {
            if (i == this.b) {
                String string = this.a.getString(FD5.f51me);
                AbstractC13042fc3.f(string);
                return string;
            }
            String str = "{USER-" + i + "}";
            this.c.add(new UserNamePlaceHolder(str, i));
            return str;
        }

        public static /* synthetic */ String e(a aVar, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return aVar.d(i, z);
        }

        public final Set b() {
            return AbstractC15401jX0.r1(this.c);
        }

        public final String c(int i, ExPeerType exPeerType) {
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            if (exPeerType == ExPeerType.GROUP) {
                return e(this, i, false, 2, null);
            }
            return null;
        }

        public final String d(int i, boolean z) {
            String strA = a(i);
            if (!z) {
                return strA;
            }
            return "«" + strA + "»";
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return GI7.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC11621dJ7 interfaceC11621dJ7 = GI7.this.e;
                Set setB = this.d.b();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setB, 10));
                Iterator it = setB.iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC6392Nk0.d(((UserNamePlaceHolder) it.next()).getUserId()));
                }
                this.b = 1;
                if (interfaceC11621dJ7.u(arrayList, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public GI7(Context context, int i, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        this.a = context;
        this.b = i;
        this.c = interfaceC20315ro1;
        this.d = abstractC13778go1;
        this.e = interfaceC11621dJ7;
    }

    public final Object b(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "block");
        a aVar = new a(this.a, this.b);
        Object objInvoke = ua2.invoke(aVar);
        AbstractC10533bm0.d(this.c, this.d, null, new b(aVar, null), 2, null);
        return objInvoke;
    }
}
