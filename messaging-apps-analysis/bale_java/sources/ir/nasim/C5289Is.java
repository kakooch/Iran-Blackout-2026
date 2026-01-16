package ir.nasim;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import ir.nasim.C5298It;
import java.util.Set;

/* renamed from: ir.nasim.Is, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5289Is implements ComposeAnimation {
    public static final a g = new a(null);
    public static final int h = 8;
    private static boolean i;
    private final C5522Jr7 a;
    private final InterfaceC5766Kt b;
    private final C15607js c;
    private final ComposeAnimationType d;
    private final Set e;
    private final String f;

    /* renamed from: ir.nasim.Is$a */
    public static final class a {
        private a() {
        }

        public final boolean a() {
            return C5289Is.i;
        }

        public final C5289Is b(C5298It.c cVar) {
            ED1 ed1 = null;
            if (a() && cVar.a().q() != null) {
                return new C5289Is(cVar.c(), cVar.b(), cVar.a(), ed1);
            }
            return null;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ComposeAnimationType[] composeAnimationTypeArrValues = ComposeAnimationType.values();
        int length = composeAnimationTypeArrValues.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (AbstractC13042fc3.d(composeAnimationTypeArrValues[i2].name(), "ANIMATE_X_AS_STATE")) {
                z = true;
                break;
            }
            i2++;
        }
        i = z;
    }

    public /* synthetic */ C5289Is(C5522Jr7 c5522Jr7, InterfaceC5766Kt interfaceC5766Kt, C15607js c15607js, ED1 ed1) {
        this(c5522Jr7, interfaceC5766Kt, c15607js);
    }

    public C15607js b() {
        return this.c;
    }

    public final InterfaceC5766Kt c() {
        return this.b;
    }

    public final C5522Jr7 d() {
        return this.a;
    }

    private C5289Is(C5522Jr7 c5522Jr7, InterfaceC5766Kt interfaceC5766Kt, C15607js c15607js) {
        Set setS1;
        this.a = c5522Jr7;
        this.b = interfaceC5766Kt;
        this.c = c15607js;
        this.d = ComposeAnimationType.ANIMATE_X_AS_STATE;
        Object objQ = b().q();
        AbstractC13042fc3.g(objQ, "null cannot be cast to non-null type kotlin.Any");
        Object[] enumConstants = objQ.getClass().getEnumConstants();
        this.e = (enumConstants == null || (setS1 = AbstractC10242bK.s1(enumConstants)) == null) ? AbstractC4363Eu6.c(objQ) : setS1;
        this.f = b().m();
    }
}
