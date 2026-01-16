package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C13245fu;
import ir.nasim.R62;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: ir.nasim.Ya1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC8970Ya1 {

    /* renamed from: ir.nasim.Ya1$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        public final void a(CharSequence charSequence, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            R62.b bVarA = R62.A(charSequence);
            if (bVarA == null) {
                return;
            }
            AbstractC11456d23.b(C02.e(bVarA, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(C13193fo7.h(this.a))), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((CharSequence) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ya1$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC15796kB2 a;
        final /* synthetic */ C20493s62 b;

        b(InterfaceC15796kB2 interfaceC15796kB2, C20493s62 c20493s62) {
            this.a = interfaceC15796kB2;
            this.b = c20493s62;
        }

        public final void a(String str, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(str, "it");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                this.a.q(this.b.a(), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((String) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final C23546x62 a(CharSequence charSequence, long j) {
        AbstractC13042fc3.i(charSequence, "$this$composeReplaceEmoji");
        ArrayList<R62.f> arrayListP = R62.P(charSequence, null, 2, null);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(arrayListP, 10));
        for (R62.f fVar : arrayListP) {
            arrayList.add(new C20493s62(fVar.c(), fVar.b(), fVar.a()));
        }
        return d(charSequence, arrayList, 0L, 0L, AbstractC19242q11.c(1741089628, true, new a(j)), 12, null);
    }

    public static /* synthetic */ C23546x62 b(CharSequence charSequence, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = AbstractC13784go7.g(16);
        }
        return a(charSequence, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final C23546x62 c(CharSequence charSequence, List list, long j, long j2, InterfaceC15796kB2 interfaceC15796kB2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        C13245fu c13245fu = charSequence instanceof C13245fu ? (C13245fu) charSequence : null;
        int i = 2;
        if (c13245fu == null) {
            c13245fu = new C13245fu(charSequence.toString(), objArr3 == true ? 1 : 0, i, objArr2 == true ? 1 : 0);
        }
        int iB = 0;
        C13245fu.b bVar = new C13245fu.b(iB, 1, objArr == true ? 1 : 0);
        if (list.isEmpty()) {
            bVar.f(c13245fu);
        } else {
            ArrayList<C20493s62> arrayList = new ArrayList();
            for (Object obj : list) {
                C20493s62 c20493s62 = (C20493s62) obj;
                if (c20493s62.c() <= c20493s62.b()) {
                    arrayList.add(obj);
                }
            }
            for (C20493s62 c20493s622 : arrayList) {
                if (c20493s622.c() > iB) {
                    bVar.f(c13245fu.subSequence(iB, c20493s622.c()));
                }
                String str2 = "emoji_" + c20493s622.c();
                AbstractC13977h83.b(bVar, str2, str, 2, str);
                linkedHashMap.put(str2, new C13386g83(new C23863xe5(j, j2, AbstractC4701Ge5.a.e(), null), AbstractC19242q11.c(179819153, true, new b(interfaceC15796kB2, c20493s622))));
                iB = c20493s622.b();
                str = null;
            }
            if (iB < c13245fu.length()) {
                bVar.f(c13245fu.subSequence(iB, c13245fu.length()));
            }
        }
        return new C23546x62(bVar.o(), linkedHashMap);
    }

    static /* synthetic */ C23546x62 d(CharSequence charSequence, List list, long j, long j2, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj) {
        return c(charSequence, list, (i & 4) != 0 ? AbstractC13784go7.g(16) : j, (i & 8) != 0 ? AbstractC13784go7.g(16) : j2, interfaceC15796kB2);
    }
}
