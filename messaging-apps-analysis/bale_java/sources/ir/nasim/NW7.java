package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes2.dex */
public abstract class NW7 {

    static final class a extends V06 implements InterfaceC14603iB2 {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ View c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = view;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.c, interfaceC20295rm1);
            aVar.b = obj;
            return aVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC6703Op6 abstractC6703Op6;
            Object objE = AbstractC14862ic3.e();
            int i = this.a;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                abstractC6703Op6 = (AbstractC6703Op6) this.b;
                View view = this.c;
                this.b = abstractC6703Op6;
                this.a = 1;
                if (abstractC6703Op6.c(view, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                abstractC6703Op6 = (AbstractC6703Op6) this.b;
                AbstractC10685c16.b(obj);
            }
            View view2 = this.c;
            if (view2 instanceof ViewGroup) {
                InterfaceC23384wp6 interfaceC23384wp6C = AbstractC24379yW7.c((ViewGroup) view2);
                this.b = null;
                this.a = 2;
                if (abstractC6703Op6.d(interfaceC23384wp6C, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }
    }

    /* synthetic */ class b extends EB2 implements UA2 {
        public static final b a = new b();

        b() {
            super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final ViewParent invoke(ViewParent viewParent) {
            return viewParent.getParent();
        }
    }

    public static final InterfaceC23384wp6 a(View view) {
        return AbstractC9131Yp6.b(new a(view, null));
    }

    public static final InterfaceC23384wp6 b(View view) {
        return AbstractC9962aq6.j(view.getParent(), b.a);
    }
}
