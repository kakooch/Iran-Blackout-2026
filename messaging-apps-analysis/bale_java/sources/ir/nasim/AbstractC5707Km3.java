package ir.nasim;

import ir.nasim.AbstractC19331qA0;
import ir.nasim.AbstractC5473Jm3;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* renamed from: ir.nasim.Km3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5707Km3 {

    /* renamed from: ir.nasim.Km3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC5473Jm3.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC5473Jm3.a aVar) {
            super(0);
            this.e = aVar;
        }

        public final boolean a() {
            return this.e.E().D().getAnnotations().M1(AbstractC14729iN7.g());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(a());
        }
    }

    /* renamed from: ir.nasim.Km3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC5473Jm3.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC5473Jm3.a aVar) {
            super(0);
            this.e = aVar;
        }

        public final boolean a() {
            return !AbstractC7497Ry7.l(this.e.E().D().getType());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(a());
        }
    }

    /* renamed from: ir.nasim.Km3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC5473Jm3.a e;
        final /* synthetic */ boolean f;
        final /* synthetic */ b g;
        final /* synthetic */ a h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC5473Jm3.a aVar, boolean z, b bVar, a aVar2) {
            super(1);
            this.e = aVar;
            this.f = z;
            this.g = bVar;
            this.h = aVar2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC19331qA0 invoke(Field field) {
            AbstractC13042fc3.i(field, "field");
            return (AbstractC5707Km3.e(this.e.E().D()) || !Modifier.isStatic(field.getModifiers())) ? this.f ? this.e.C() ? new AbstractC19331qA0.f.a(field, AbstractC5707Km3.d(this.e)) : new AbstractC19331qA0.f.c(field) : this.e.C() ? new AbstractC19331qA0.g.a(field, this.g.a(), AbstractC5707Km3.d(this.e)) : new AbstractC19331qA0.g.c(field, this.g.a()) : this.h.a() ? this.f ? this.e.C() ? new AbstractC19331qA0.f.b(field) : new AbstractC19331qA0.f.d(field) : this.e.C() ? new AbstractC19331qA0.g.b(field, this.g.a()) : new AbstractC19331qA0.g.d(field, this.g.a()) : this.f ? new AbstractC19331qA0.f.e(field) : new AbstractC19331qA0.g.e(field, this.g.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.InterfaceC18740pA0 c(ir.nasim.AbstractC5473Jm3.a r7, boolean r8) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5707Km3.c(ir.nasim.Jm3$a, boolean):ir.nasim.pA0");
    }

    public static final Object d(AbstractC5473Jm3.a aVar) {
        AbstractC13042fc3.i(aVar, "$this$boundReceiver");
        return aVar.E().E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(InterfaceC20989sw5 interfaceC20989sw5) {
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC20989sw5.b();
        AbstractC13042fc3.h(interfaceC12795fB1B, "containingDeclaration");
        if (!OI1.x(interfaceC12795fB1B)) {
            return false;
        }
        InterfaceC12795fB1 interfaceC12795fB1B2 = interfaceC12795fB1B.b();
        return !(OI1.C(interfaceC12795fB1B2) || OI1.t(interfaceC12795fB1B2)) || ((interfaceC20989sw5 instanceof C16458lJ1) && C8083Ul3.f(((C16458lJ1) interfaceC20989sw5).g0()));
    }
}
