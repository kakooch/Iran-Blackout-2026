package ir.nasim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.lo1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16751lo1 {

    /* renamed from: ir.nasim.lo1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Fragment c;
        final /* synthetic */ j.b d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Fragment fragment, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = fragment;
            this.d = bVar;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                androidx.lifecycle.j lifecycle = this.c.p6().getLifecycle();
                j.b bVar = this.d;
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.b = 1;
                if (androidx.lifecycle.w.a(lifecycle, bVar, interfaceC14603iB2, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lo1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AppCompatActivity c;
        final /* synthetic */ j.b d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AppCompatActivity appCompatActivity, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = appCompatActivity;
            this.d = bVar;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                androidx.lifecycle.j lifecycle = this.c.getLifecycle();
                j.b bVar = this.d;
                InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                this.b = 1;
                if (androidx.lifecycle.w.a(lifecycle, bVar, interfaceC14603iB2, this) == objE) {
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

    public static final AbstractC15087iz3 a(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "<this>");
        InterfaceC18633oz3 interfaceC18633oz3P6 = fragment.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        return AbstractC19224pz3.a(interfaceC18633oz3P6);
    }

    public static final InterfaceC13730gj3 b(AppCompatActivity appCompatActivity, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(appCompatActivity, "<this>");
        AbstractC13042fc3.i(bVar, "state");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC10533bm0.d(AbstractC19224pz3.a(appCompatActivity), null, null, new b(appCompatActivity, bVar, interfaceC14603iB2, null), 3, null);
    }

    public static final InterfaceC13730gj3 c(Fragment fragment, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(fragment, "<this>");
        AbstractC13042fc3.i(bVar, "state");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        InterfaceC18633oz3 interfaceC18633oz3P6 = fragment.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        return AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new a(fragment, bVar, interfaceC14603iB2, null), 3, null);
    }
}
