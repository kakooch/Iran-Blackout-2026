package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC21102t68;
import ir.nasim.C21753u45;
import ir.nasim.InterfaceC22053ub1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.t68, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21102t68 {

    /* renamed from: ir.nasim.t68$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C21753u45.g a;
        final /* synthetic */ String b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;

        a(C21753u45.g gVar, String str, SA2 sa2, SA2 sa22) {
            this.a = gVar;
            this.b = str;
            this.c = sa2;
            this.d = sa22;
        }

        private static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(SA2 sa2, Context context) {
            AbstractC13042fc3.i(sa2, "$onRejected");
            AbstractC13042fc3.i(context, "$context");
            sa2.invoke();
            C21753u45.a0(C21753u45.a, context, null, 2, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(SA2 sa2, SA2 sa22, Map map) {
            AbstractC13042fc3.i(sa2, "$onAccepted");
            AbstractC13042fc3.i(sa22, "$onRejected");
            AbstractC13042fc3.i(map, "permissionsMap");
            Collection collectionValues = map.values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                sa2.invoke();
            } else {
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                        sa22.invoke();
                        break;
                    }
                }
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C14725iN3 c14725iN3, C21753u45.g gVar) {
            AbstractC13042fc3.i(c14725iN3, "$permissionLauncher");
            AbstractC13042fc3.i(gVar, "$permissionType");
            c14725iN3.a(gVar.q());
            return C19938rB7.a;
        }

        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            ComponentActivity componentActivityA = AbstractC4277El1.a((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()));
            final Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            C21753u45 c21753u45 = C21753u45.a;
            boolean zW = c21753u45.W(context, this.a.q());
            interfaceC22053ub1.W(-218214097);
            C21753u45.g gVar = this.a;
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.valueOf(componentActivityA != null && c21753u45.e1(componentActivityA, gVar.q())), null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            if (zW) {
                interfaceC22053ub1.W(1825580679);
                c21753u45.J(UY6.d(this.a.r(), new Object[]{this.b}, interfaceC22053ub1, 0), this.a.p(), UY6.d(this.a.j(), new Object[]{this.b}, interfaceC22053ub1, 0), UY6.c(WD5.Done, interfaceC22053ub1, 0), this.c, UY6.c(WD5.Cancel, interfaceC22053ub1, 0), this.d, interfaceC22053ub1, C21753u45.b << 21);
                interfaceC22053ub1.Q();
                return;
            }
            if (f(interfaceC9102Ym4)) {
                interfaceC22053ub1.W(1826118498);
                String strD = UY6.d(this.a.r(), new Object[]{this.b}, interfaceC22053ub1, 0);
                int iP = this.a.p();
                String strD2 = UY6.d(this.a.j(), new Object[]{this.b}, interfaceC22053ub1, 0);
                String strC = UY6.c(AbstractC12217eE5.permission_go_to_settings, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-218175024);
                boolean zV = interfaceC22053ub1.V(this.d) | interfaceC22053ub1.D(context);
                final SA2 sa2 = this.d;
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == aVar.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.q68
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC21102t68.a.h(sa2, context);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                c21753u45.L(strD, iP, strD2, strC, (SA2) objB2, interfaceC22053ub1, C21753u45.b << 15);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(1826678978);
            C19290q6 c19290q6 = new C19290q6();
            interfaceC22053ub1.W(-218165196);
            boolean zV2 = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.d);
            final SA2 sa22 = this.c;
            final SA2 sa23 = this.d;
            Object objB3 = interfaceC22053ub1.B();
            if (zV2 || objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.r68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC21102t68.a.i(sa22, sa23, (Map) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            final C14725iN3 c14725iN3A = A6.a(c19290q6, (UA2) objB3, interfaceC22053ub1, 0);
            String strD3 = UY6.d(this.a.r(), new Object[]{this.b}, interfaceC22053ub1, 0);
            int iP2 = this.a.p();
            String strD4 = UY6.d(this.a.j(), new Object[]{this.b}, interfaceC22053ub1, 0);
            String strC2 = UY6.c(WD5.Done, interfaceC22053ub1, 0);
            String strC3 = UY6.c(WD5.Cancel, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-218145482);
            boolean zD = interfaceC22053ub1.D(c14725iN3A) | interfaceC22053ub1.V(this.a);
            final C21753u45.g gVar2 = this.a;
            Object objB4 = interfaceC22053ub1.B();
            if (zD || objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.s68
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21102t68.a.k(c14725iN3A, gVar2);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            c21753u45.J(strD3, iP2, strD4, strC2, (SA2) objB4, strC3, this.d, interfaceC22053ub1, C21753u45.b << 21);
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final C21753u45.g gVar, final String str, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(gVar, "permissionType");
        AbstractC13042fc3.i(str, "webAppName");
        AbstractC13042fc3.i(sa2, "onAccepted");
        AbstractC13042fc3.i(sa22, "onRejected");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1315102051);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(gVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC6687Oo.a(sa22, new C18876pP1(true, true, false, 4, (ED1) null), AbstractC19242q11.e(-1300998412, true, new a(gVar, str, sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, ((i2 >> 9) & 14) | 432, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.p68
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21102t68.c(gVar, str, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(C21753u45.g gVar, String str, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(gVar, "$permissionType");
        AbstractC13042fc3.i(str, "$webAppName");
        AbstractC13042fc3.i(sa2, "$onAccepted");
        AbstractC13042fc3.i(sa22, "$onRejected");
        b(gVar, str, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
