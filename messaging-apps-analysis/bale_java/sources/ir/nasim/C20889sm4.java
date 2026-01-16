package ir.nasim;

import ir.nasim.AbstractC13460gG3;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.sm4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20889sm4 {
    private AbstractC13460gG3 a;
    private AbstractC13460gG3 b;
    private AbstractC13460gG3 c;

    /* renamed from: ir.nasim.sm4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C20889sm4() {
        AbstractC13460gG3.c.a aVar = AbstractC13460gG3.c.b;
        this.a = aVar.b();
        this.b = aVar.b();
        this.c = aVar.b();
    }

    public final AbstractC13460gG3 a(EnumC16433lG3 enumC16433lG3) {
        AbstractC13042fc3.i(enumC16433lG3, "loadType");
        int i = a.a[enumC16433lG3.ordinal()];
        if (i == 1) {
            return this.a;
        }
        if (i == 2) {
            return this.c;
        }
        if (i == 3) {
            return this.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void b(C14653iG3 c14653iG3) {
        AbstractC13042fc3.i(c14653iG3, "states");
        this.a = c14653iG3.f();
        this.c = c14653iG3.d();
        this.b = c14653iG3.e();
    }

    public final void c(EnumC16433lG3 enumC16433lG3, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(enumC16433lG3, "type");
        AbstractC13042fc3.i(abstractC13460gG3, "state");
        int i = a.a[enumC16433lG3.ordinal()];
        if (i == 1) {
            this.a = abstractC13460gG3;
        } else if (i == 2) {
            this.c = abstractC13460gG3;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.b = abstractC13460gG3;
        }
    }

    public final C14653iG3 d() {
        return new C14653iG3(this.a, this.b, this.c);
    }
}
