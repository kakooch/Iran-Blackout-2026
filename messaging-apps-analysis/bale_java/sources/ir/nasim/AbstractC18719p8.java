package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import ir.nasim.AbstractC18719p8;
import ir.nasim.AbstractC20510s8;
import ir.nasim.G8;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.p8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18719p8 {

    /* renamed from: ir.nasim.p8$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ C8588Wp4 a;
        final /* synthetic */ I8 b;
        final /* synthetic */ UA2 c;

        a(C8588Wp4 c8588Wp4, I8 i8, UA2 ua2) {
            this.a = c8588Wp4;
            this.b = i8;
            this.c = ua2;
        }

        public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            AbstractC24153y8.e(this.a, this.b, this.c, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.p8$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC19933rB2 a;
        final /* synthetic */ C8588Wp4 b;
        final /* synthetic */ UA2 c;

        b(InterfaceC19933rB2 interfaceC19933rB2, C8588Wp4 c8588Wp4, UA2 ua2) {
            this.a = interfaceC19933rB2;
            this.b = c8588Wp4;
            this.c = ua2;
        }

        private static final String d(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        private static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            interfaceC9102Ym4.setValue(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$searchQuery$delegate");
            AbstractC13042fc3.i(str, "newQuery");
            f(interfaceC9102Ym4, str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(UA2 ua2, String str, String str2, String str3) {
            AbstractC13042fc3.i(ua2, "$handleUiAction");
            AbstractC13042fc3.i(str, "<unused var>");
            AbstractC13042fc3.i(str2, "fullName");
            ua2.invoke(new G8.c(str2));
            return C19938rB7.a;
        }

        public final void c(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            interfaceC22053ub1.W(1521948984);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d("", null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            InterfaceC19933rB2 interfaceC19933rB2 = this.a;
            C12561ep1 c12561ep1B = C12561ep1.a.b();
            C8588Wp4 c8588Wp4 = this.b;
            String strD = d(interfaceC9102Ym4);
            interfaceC22053ub1.W(1521954911);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.q8
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC18719p8.b.h(interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua2 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1521956788);
            boolean zV = interfaceC22053ub1.V(this.c);
            final UA2 ua22 = this.c;
            Object objB3 = interfaceC22053ub1.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new InterfaceC15796kB2() { // from class: ir.nasim.r8
                    @Override // ir.nasim.InterfaceC15796kB2
                    public final Object q(Object obj, Object obj2, Object obj3) {
                        return AbstractC18719p8.b.i(ua22, (String) obj, (String) obj2, (String) obj3);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            interfaceC19933rB2.l(c12561ep1B, c8588Wp4, strD, ua2, (InterfaceC15796kB2) objB3, interfaceC22053ub1, Integer.valueOf(C12561ep1.b | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER));
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            c((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(ir.nasim.C8588Wp4 r22, java.lang.String r23, final ir.nasim.I8 r24, final ir.nasim.UA2 r25, final ir.nasim.InterfaceC19933rB2 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18719p8.c(ir.nasim.Wp4, java.lang.String, ir.nasim.I8, ir.nasim.UA2, ir.nasim.rB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(C8588Wp4 c8588Wp4, I8 i8, UA2 ua2, InterfaceC19933rB2 interfaceC19933rB2, C8120Up4 c8120Up4) {
        AbstractC13042fc3.i(i8, "$addContactUiState");
        AbstractC13042fc3.i(ua2, "$handleUiAction");
        AbstractC13042fc3.i(interfaceC19933rB2, "$chooseScreenCountryContent");
        AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
        AbstractC8354Vp4.c(c8120Up4, AbstractC20510s8.a.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1524518637, true, new a(c8588Wp4, i8, ua2)), 126, null);
        AbstractC8354Vp4.c(c8120Up4, AbstractC20510s8.b.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(2140695690, true, new b(interfaceC19933rB2, c8588Wp4, ua2)), 126, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(C8588Wp4 c8588Wp4, String str, I8 i8, UA2 ua2, InterfaceC19933rB2 interfaceC19933rB2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) throws Resources.NotFoundException {
        AbstractC13042fc3.i(i8, "$addContactUiState");
        AbstractC13042fc3.i(ua2, "$handleUiAction");
        AbstractC13042fc3.i(interfaceC19933rB2, "$chooseScreenCountryContent");
        c(c8588Wp4, str, i8, ua2, interfaceC19933rB2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
