package coil.compose;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.drawable.Drawable;
import ir.nasim.AbstractC13301g;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.C12700f33;
import ir.nasim.EV4;
import ir.nasim.FT1;
import ir.nasim.GK;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC18663p23;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4856Gv7;
import ir.nasim.OD6;
import ir.nasim.PD6;
import ir.nasim.R93;
import ir.nasim.T92;
import ir.nasim.U92;
import ir.nasim.UA2;
import ir.nasim.W23;
import ir.nasim.Y03;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public abstract class b {
    private static final a a = new a();

    public static final class a implements InterfaceC4856Gv7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC4856Gv7
        public Drawable d() {
            return null;
        }
    }

    public static final AsyncImagePainter c(Object obj, InterfaceC18663p23 interfaceC18663p23, UA2 ua2, UA2 ua22, InterfaceC13157fl1 interfaceC13157fl1, int i, T92 t92, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        interfaceC22053ub1.A(1645646697);
        UA2 ua2A = (i3 & 4) != 0 ? AsyncImagePainter.INSTANCE.a() : ua2;
        UA2 ua23 = (i3 & 8) != 0 ? null : ua22;
        InterfaceC13157fl1 interfaceC13157fl1E = (i3 & 16) != 0 ? InterfaceC13157fl1.a.e() : interfaceC13157fl1;
        int iB = (i3 & 32) != 0 ? InterfaceC17460n02.i0.b() : i;
        T92 t92A = (i3 & 64) != 0 ? U92.a() : t92;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1645646697, i2, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:166)");
        }
        int i4 = i2 >> 3;
        AsyncImagePainter asyncImagePainterD = d(new GK(obj, t92A, interfaceC18663p23), ua2A, ua23, interfaceC13157fl1E, iB, interfaceC22053ub1, (i4 & 57344) | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 896) | (i4 & 7168));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return asyncImagePainterD;
    }

    private static final AsyncImagePainter d(GK gk, UA2 ua2, UA2 ua22, InterfaceC13157fl1 interfaceC13157fl1, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.A(952940650);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(952940650, i2, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:199)");
        }
        W23 w23G = g.g(gk.b(), interfaceC22053ub1, 8);
        h(w23G);
        interfaceC22053ub1.A(294038899);
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = new AsyncImagePainter(w23G, gk.a());
            interfaceC22053ub1.s(objB);
        }
        AsyncImagePainter asyncImagePainter = (AsyncImagePainter) objB;
        interfaceC22053ub1.U();
        asyncImagePainter.M(ua2);
        asyncImagePainter.H(ua22);
        asyncImagePainter.E(interfaceC13157fl1);
        asyncImagePainter.F(i);
        asyncImagePainter.J(((Boolean) interfaceC22053ub1.H(R93.a())).booleanValue());
        asyncImagePainter.G(gk.a());
        asyncImagePainter.K(w23G);
        asyncImagePainter.b();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return asyncImagePainter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PD6 e(long j) {
        if (j == OD6.b.a()) {
            return PD6.d;
        }
        if (!g.e(j)) {
            return null;
        }
        float fI = OD6.i(j);
        FT1 ft1A = (Float.isInfinite(fI) || Float.isNaN(fI)) ? FT1.b.a : AbstractC13301g.a(AbstractC20723sV3.d(OD6.i(j)));
        float fG = OD6.g(j);
        return new PD6(ft1A, (Float.isInfinite(fG) || Float.isNaN(fG)) ? FT1.b.a : AbstractC13301g.a(AbstractC20723sV3.d(OD6.g(j))));
    }

    private static final Void f(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    static /* synthetic */ Void g(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return f(str, str2);
    }

    private static final void h(W23 w23) {
        Object objM = w23.m();
        if (objM instanceof W23.a) {
            f("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new KotlinNothingValueException();
        }
        if (objM instanceof Y03) {
            g("ImageBitmap", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (objM instanceof C12700f33) {
            g("ImageVector", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (objM instanceof EV4) {
            g("Painter", null, 2, null);
            throw new KotlinNothingValueException();
        }
        if (w23.M() != null) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
    }
}
