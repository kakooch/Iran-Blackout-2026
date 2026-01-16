package ir.nasim;

import androidx.compose.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.It, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5298It {
    private final SA2 a;
    private final SA2 b;
    private final l c = new l(new s());
    private final d d;
    private final e e;
    private final Set f;
    private final Set g;
    private final Set h;

    /* renamed from: ir.nasim.It$a */
    public static final class a extends j {

        /* renamed from: ir.nasim.It$a$a, reason: collision with other inner class name */
        static final class C0426a extends AbstractC8614Ws3 implements UA2 {
            C0426a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(e.b bVar) {
                boolean z;
                if (AbstractC13042fc3.d(bVar.getClass().getName(), "androidx.compose.animation.SizeAnimationModifierElement")) {
                    a.this.b().add(bVar);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }

        /* renamed from: ir.nasim.It$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            public static final b e = new b();

            b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(e.b bVar) {
                return Boolean.valueOf(AbstractC13042fc3.d(bVar.getClass().getName(), "androidx.compose.animation.SizeAnimationModifierElement"));
            }
        }

        public a(UA2 ua2) {
            super(ua2);
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : collection) {
                if (!((AbstractC15886kL2) obj).e().isEmpty()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((AbstractC15886kL2) it.next()).e().iterator();
                while (it2.hasNext()) {
                    ((C19038pg4) it2.next()).a().d(new C0426a());
                }
            }
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            if (!abstractC15886kL2.e().isEmpty()) {
                List listE = abstractC15886kL2.e();
                if (!(listE instanceof Collection) || !listE.isEmpty()) {
                    Iterator it = listE.iterator();
                    while (it.hasNext()) {
                        if (((C19038pg4) it.next()).a().d(b.e)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: ir.nasim.It$b */
    public static final class b extends j {
        public b(UA2 ua2) {
            super(ua2);
        }

        private final C15607js f(C13256fv0 c13256fv0) {
            Object next;
            List listM;
            Object next2;
            Object next3;
            Iterator it = c13256fv0.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next instanceof C15607js) {
                    break;
                }
            }
            if (!(next instanceof C15607js)) {
                next = null;
            }
            C15607js c15607js = (C15607js) next;
            if (c15607js == null || (listM = AbstractC9766aX0.e(c15607js)) == null) {
                listM = AbstractC10360bX0.m();
            }
            List list = listM;
            Collection collectionB = c13256fv0.b();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionB.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((AbstractC15886kL2) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (next3 instanceof C15607js) {
                        break;
                    }
                }
                if (!(next3 instanceof C15607js)) {
                    next3 = null;
                }
                C15607js c15607js2 = (C15607js) next3;
                if (c15607js2 != null) {
                    arrayList.add(c15607js2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = collectionB.iterator();
            while (it4.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2E = AbstractC9364Zp5.e((AbstractC15886kL2) it4.next(), C5532Jt.e);
                if (abstractC15886kL2E != null) {
                    arrayList2.add(abstractC15886kL2E);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                Iterator it6 = ((AbstractC15886kL2) it5.next()).c().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it6.next();
                    if (next2 instanceof C15607js) {
                        break;
                    }
                }
                if (!(next2 instanceof C15607js)) {
                    next2 = null;
                }
                C15607js c15607js3 = (C15607js) next2;
                if (c15607js3 != null) {
                    arrayList3.add(c15607js3);
                }
            }
            return (C15607js) AbstractC15401jX0.s0(AbstractC15401jX0.R0(list, AbstractC15401jX0.R0(arrayList, arrayList3)));
        }

        private final InterfaceC5766Kt g(C13256fv0 c13256fv0) {
            Collection collectionB = c13256fv0.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionB) {
                if (AbstractC13042fc3.d(((AbstractC15886kL2) obj).f(), "rememberUpdatedState")) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList2, ((AbstractC15886kL2) it.next()).b());
            }
            List listR0 = AbstractC15401jX0.R0(arrayList, arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = listR0.iterator();
            while (it2.hasNext()) {
                AbstractC13610gX0.D(arrayList3, ((AbstractC15886kL2) it2.next()).c());
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (obj2 instanceof InterfaceC9664aL6) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = new ArrayList(AbstractC10976cX0.x(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(((InterfaceC9664aL6) it3.next()).getValue());
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : arrayList5) {
                if (obj3 instanceof InterfaceC5766Kt) {
                    arrayList6.add(obj3);
                }
            }
            return (InterfaceC5766Kt) AbstractC15401jX0.s0(arrayList6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [ir.nasim.It$c] */
        private final List h(Collection collection) {
            ArrayList<C13256fv0> arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                C13256fv0 c13256fv0J = j((AbstractC15886kL2) it.next());
                if (c13256fv0J != null) {
                    arrayList.add(c13256fv0J);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (C13256fv0 c13256fv0 : arrayList) {
                C15607js c15607jsF = f(c13256fv0);
                InterfaceC5766Kt interfaceC5766KtG = g(c13256fv0);
                InterfaceC9102Ym4 interfaceC9102Ym4I = i(c13256fv0);
                if (c15607jsF != null && interfaceC5766KtG != null && interfaceC9102Ym4I != null) {
                    if (interfaceC9102Ym4I.getValue() == null) {
                        interfaceC9102Ym4I.setValue(new C5522Jr7(c15607jsF.q()));
                    }
                    Object value = interfaceC9102Ym4I.getValue();
                    cVar = value instanceof C5522Jr7 ? (C5522Jr7) value : null;
                    if (cVar == null) {
                        cVar = new C5522Jr7(c15607jsF.q());
                    }
                    cVar = new c(c15607jsF, interfaceC5766KtG, cVar);
                }
                if (cVar != null) {
                    arrayList2.add(cVar);
                }
            }
            return arrayList2;
        }

        private final InterfaceC9102Ym4 i(AbstractC15886kL2 abstractC15886kL2) {
            Object next;
            List listM;
            Object next2;
            Object next3;
            Iterator it = abstractC15886kL2.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next instanceof InterfaceC9102Ym4) {
                    break;
                }
            }
            if (!(next instanceof InterfaceC9102Ym4)) {
                next = null;
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) next;
            if (interfaceC9102Ym4 == null || (listM = AbstractC9766aX0.e(interfaceC9102Ym4)) == null) {
                listM = AbstractC10360bX0.m();
            }
            List list = listM;
            Collection collectionB = abstractC15886kL2.b();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionB.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((AbstractC15886kL2) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    if (next3 instanceof InterfaceC9102Ym4) {
                        break;
                    }
                }
                if (!(next3 instanceof InterfaceC9102Ym4)) {
                    next3 = null;
                }
                InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) next3;
                if (interfaceC9102Ym42 != null) {
                    arrayList.add(interfaceC9102Ym42);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = collectionB.iterator();
            while (it4.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2E = AbstractC9364Zp5.e((AbstractC15886kL2) it4.next(), C5532Jt.e);
                if (abstractC15886kL2E != null) {
                    arrayList2.add(abstractC15886kL2E);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                Iterator it6 = ((AbstractC15886kL2) it5.next()).c().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it6.next();
                    if (next2 instanceof InterfaceC9102Ym4) {
                        break;
                    }
                }
                if (!(next2 instanceof InterfaceC9102Ym4)) {
                    next2 = null;
                }
                InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) next2;
                if (interfaceC9102Ym43 != null) {
                    arrayList3.add(interfaceC9102Ym43);
                }
            }
            return (InterfaceC9102Ym4) AbstractC15401jX0.s0(AbstractC15401jX0.R0(list, AbstractC15401jX0.R0(arrayList, arrayList3)));
        }

        private final C13256fv0 j(AbstractC15886kL2 abstractC15886kL2) {
            if (abstractC15886kL2.d() == null || !AbstractC13042fc3.d(abstractC15886kL2.f(), "animateValueAsState")) {
                abstractC15886kL2 = null;
            }
            if (abstractC15886kL2 == null || !(abstractC15886kL2 instanceof C13256fv0)) {
                return null;
            }
            return (C13256fv0) abstractC15886kL2;
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            b().addAll(h(collection));
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            C13256fv0 c13256fv0J = j(abstractC15886kL2);
            return (c13256fv0J == null || f(c13256fv0J) == null || g(c13256fv0J) == null || i(c13256fv0J) == null) ? false : true;
        }
    }

    /* renamed from: ir.nasim.It$c */
    public static final class c {
        private final C15607js a;
        private final InterfaceC5766Kt b;
        private final C5522Jr7 c;

        public c(C15607js c15607js, InterfaceC5766Kt interfaceC5766Kt, C5522Jr7 c5522Jr7) {
            this.a = c15607js;
            this.b = interfaceC5766Kt;
            this.c = c5522Jr7;
        }

        public final C15607js a() {
            return this.a;
        }

        public final InterfaceC5766Kt b() {
            return this.b;
        }

        public final C5522Jr7 c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AnimateXAsStateSearchInfo(animatable=" + this.a + ", animationSpec=" + this.b + ", toolingState=" + this.c + ')';
        }
    }

    /* renamed from: ir.nasim.It$d */
    public static final class d extends j {
        public d(UA2 ua2) {
            super(ua2);
        }

        private final AbstractC15886kL2 f(AbstractC15886kL2 abstractC15886kL2) {
            Object obj = null;
            if (abstractC15886kL2.d() == null || !AbstractC13042fc3.d(abstractC15886kL2.f(), "AnimatedContent")) {
                abstractC15886kL2 = null;
            }
            if (abstractC15886kL2 == null) {
                return null;
            }
            Iterator it = abstractC15886kL2.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (AbstractC13042fc3.d(((AbstractC15886kL2) next).f(), "updateTransition")) {
                    obj = next;
                    break;
                }
            }
            return (AbstractC15886kL2) obj;
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            Object next;
            Object next2;
            Set setB = b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2F = f((AbstractC15886kL2) it.next());
                if (abstractC15886kL2F != null) {
                    arrayList.add(abstractC15886kL2F);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Iterator it3 = ((AbstractC15886kL2) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it3.next();
                        if (next2 instanceof C21669tv7) {
                            break;
                        }
                    }
                }
                C21669tv7 c21669tv7 = (C21669tv7) (next2 instanceof C21669tv7 ? next2 : null);
                if (c21669tv7 != null) {
                    arrayList2.add(c21669tv7);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2E = AbstractC9364Zp5.e((AbstractC15886kL2) it4.next(), C5532Jt.e);
                if (abstractC15886kL2E != null) {
                    arrayList3.add(abstractC15886kL2E);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                Iterator it6 = ((AbstractC15886kL2) it5.next()).c().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it6.next();
                        if (next instanceof C21669tv7) {
                            break;
                        }
                    }
                }
                if (!(next instanceof C21669tv7)) {
                    next = null;
                }
                C21669tv7 c21669tv72 = (C21669tv7) next;
                if (c21669tv72 != null) {
                    arrayList4.add(c21669tv72);
                }
            }
            setB.addAll(AbstractC15401jX0.R0(arrayList2, arrayList4));
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            return f(abstractC15886kL2) != null;
        }
    }

    /* renamed from: ir.nasim.It$e */
    public static final class e extends j {
        public e(UA2 ua2) {
            super(ua2);
        }

        private final AbstractC15886kL2 f(AbstractC15886kL2 abstractC15886kL2) {
            Object obj = null;
            if (abstractC15886kL2.d() == null || !AbstractC13042fc3.d(abstractC15886kL2.f(), "AnimatedVisibility")) {
                abstractC15886kL2 = null;
            }
            if (abstractC15886kL2 == null) {
                return null;
            }
            Iterator it = abstractC15886kL2.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (AbstractC13042fc3.d(((AbstractC15886kL2) next).f(), "updateTransition")) {
                    obj = next;
                    break;
                }
            }
            return (AbstractC15886kL2) obj;
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            Object next;
            Object next2;
            Set setB = b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2F = f((AbstractC15886kL2) it.next());
                if (abstractC15886kL2F != null) {
                    arrayList.add(abstractC15886kL2F);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Iterator it3 = ((AbstractC15886kL2) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it3.next();
                        if (next2 instanceof C21669tv7) {
                            break;
                        }
                    }
                }
                C21669tv7 c21669tv7 = (C21669tv7) (next2 instanceof C21669tv7 ? next2 : null);
                if (c21669tv7 != null) {
                    arrayList2.add(c21669tv7);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2E = AbstractC9364Zp5.e((AbstractC15886kL2) it4.next(), C5532Jt.e);
                if (abstractC15886kL2E != null) {
                    arrayList3.add(abstractC15886kL2E);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                Iterator it6 = ((AbstractC15886kL2) it5.next()).c().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it6.next();
                        if (next instanceof C21669tv7) {
                            break;
                        }
                    }
                }
                if (!(next instanceof C21669tv7)) {
                    next = null;
                }
                C21669tv7 c21669tv72 = (C21669tv7) next;
                if (c21669tv72 != null) {
                    arrayList4.add(c21669tv72);
                }
            }
            setB.addAll(AbstractC15401jX0.R0(arrayList2, arrayList4));
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            return f(abstractC15886kL2) != null;
        }
    }

    /* renamed from: ir.nasim.It$f */
    public static final class f extends i {
        public f(UA2 ua2) {
            super(AbstractC10882cM5.b(C9569aB1.class), ua2);
        }
    }

    /* renamed from: ir.nasim.It$g */
    public static final class g extends j {
        public g(UA2 ua2) {
            super(ua2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v6, types: [ir.nasim.It$h] */
        private final List f(Collection collection) {
            C5522Jr7 hVar;
            Object next;
            ArrayList<C13256fv0> arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                C13256fv0 c13256fv0H = h((AbstractC15886kL2) it.next());
                if (c13256fv0H != null) {
                    arrayList.add(c13256fv0H);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (C13256fv0 c13256fv0 : arrayList) {
                Collection collectionC = c13256fv0.c();
                Collection collectionB = c13256fv0.b();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = collectionB.iterator();
                while (it2.hasNext()) {
                    AbstractC13610gX0.D(arrayList3, ((AbstractC15886kL2) it2.next()).c());
                }
                Iterator it3 = AbstractC15401jX0.R0(collectionC, arrayList3).iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    if (next instanceof C21097t63) {
                        break;
                    }
                }
                if (!(next instanceof C21097t63)) {
                    next = null;
                }
                C21097t63 c21097t63 = (C21097t63) next;
                InterfaceC9102Ym4 interfaceC9102Ym4G = g(c13256fv0);
                if (c21097t63 != null && interfaceC9102Ym4G != null) {
                    if (interfaceC9102Ym4G.getValue() == null) {
                        interfaceC9102Ym4G.setValue(new C5522Jr7(0L));
                    }
                    Object value = interfaceC9102Ym4G.getValue();
                    hVar = value instanceof C5522Jr7 ? (C5522Jr7) value : null;
                    if (hVar == null) {
                        hVar = new C5522Jr7(0L);
                    }
                    hVar = new h(c21097t63, hVar);
                }
                if (hVar != null) {
                    arrayList2.add(hVar);
                }
            }
            return arrayList2;
        }

        private final InterfaceC9102Ym4 g(AbstractC15886kL2 abstractC15886kL2) {
            Object next;
            Collection collectionC = abstractC15886kL2.c();
            Collection collectionB = abstractC15886kL2.b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionB.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, ((AbstractC15886kL2) it.next()).b());
            }
            List listR0 = AbstractC15401jX0.R0(collectionB, arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = listR0.iterator();
            while (it2.hasNext()) {
                AbstractC13610gX0.D(arrayList2, ((AbstractC15886kL2) it2.next()).c());
            }
            Iterator it3 = AbstractC15401jX0.R0(collectionC, arrayList2).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                if (next instanceof InterfaceC9102Ym4) {
                    break;
                }
            }
            return (InterfaceC9102Ym4) (next instanceof InterfaceC9102Ym4 ? next : null);
        }

        private final C13256fv0 h(AbstractC15886kL2 abstractC15886kL2) {
            if (abstractC15886kL2.d() == null || !AbstractC13042fc3.d(abstractC15886kL2.f(), "rememberInfiniteTransition")) {
                abstractC15886kL2 = null;
            }
            if (abstractC15886kL2 == null || !(abstractC15886kL2 instanceof C13256fv0)) {
                return null;
            }
            return (C13256fv0) abstractC15886kL2;
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            b().addAll(f(collection));
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            Object next;
            if (h(abstractC15886kL2) == null) {
                return false;
            }
            Collection collectionC = abstractC15886kL2.c();
            Collection collectionB = abstractC15886kL2.b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collectionB.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, ((AbstractC15886kL2) it.next()).c());
            }
            Iterator it2 = AbstractC15401jX0.R0(collectionC, arrayList).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (next instanceof C21097t63) {
                    break;
                }
            }
            return (((C21097t63) (next instanceof C21097t63 ? next : null)) == null || g(abstractC15886kL2) == null) ? false : true;
        }
    }

    /* renamed from: ir.nasim.It$h */
    public static final class h {
        public static final int c = C21097t63.f;
        private final C21097t63 a;
        private final C5522Jr7 b;

        public h(C21097t63 c21097t63, C5522Jr7 c5522Jr7) {
            this.a = c21097t63;
            this.b = c5522Jr7;
        }

        public final C21097t63 a() {
            return this.a;
        }

        public final C5522Jr7 b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return AbstractC13042fc3.d(this.a, hVar.a) && AbstractC13042fc3.d(this.b, hVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "InfiniteTransitionSearchInfo(infiniteTransition=" + this.a + ", toolingState=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.It$i */
    public static class i extends j {
        private final InterfaceC11299cm3 c;

        public i(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
            super(ua2);
            this.c = interfaceC11299cm3;
        }

        private final Object f(AbstractC15886kL2 abstractC15886kL2, InterfaceC11299cm3 interfaceC11299cm3) {
            Object obj;
            Iterator it = abstractC15886kL2.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (AbstractC13042fc3.d(next != null ? AbstractC4762Gl3.e(next.getClass()) : null, interfaceC11299cm3)) {
                    obj = next;
                    break;
                }
            }
            return AbstractC14353hm3.b(interfaceC11299cm3, obj);
        }

        private final List g(Collection collection, InterfaceC11299cm3 interfaceC11299cm3) {
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Object objF = f((AbstractC15886kL2) it.next(), interfaceC11299cm3);
                if (objF != null) {
                    arrayList.add(objF);
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : collection) {
                if (((AbstractC15886kL2) obj).d() != null) {
                    arrayList.add(obj);
                }
            }
            b().addAll(AbstractC15401jX0.r1(g(arrayList, this.c)));
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            return (abstractC15886kL2.d() == null || f(abstractC15886kL2, this.c) == null) ? false : true;
        }
    }

    /* renamed from: ir.nasim.It$j */
    public static abstract class j {
        private final UA2 a;
        private final Set b = new LinkedHashSet();

        public j(UA2 ua2) {
            this.a = ua2;
        }

        public abstract void a(Collection collection);

        public final Set b() {
            return this.b;
        }

        public abstract boolean c(AbstractC15886kL2 abstractC15886kL2);

        public final boolean d(Collection collection) {
            Collection collection2 = collection;
            if ((collection2 instanceof Collection) && collection2.isEmpty()) {
                return false;
            }
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                if (c((AbstractC15886kL2) it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final void e() {
            List listT0 = AbstractC15401jX0.T0(this.b);
            UA2 ua2 = this.a;
            Iterator it = listT0.iterator();
            while (it.hasNext()) {
                ua2.invoke(it.next());
            }
        }
    }

    /* renamed from: ir.nasim.It$k */
    public static final class k extends i {
        public k(UA2 ua2) {
            super(AbstractC10882cM5.b(C23915xj7.class), ua2);
        }
    }

    /* renamed from: ir.nasim.It$l */
    public static final class l extends j {
        public l(UA2 ua2) {
            super(ua2);
        }

        private final AbstractC15886kL2 f(AbstractC15886kL2 abstractC15886kL2) {
            if (abstractC15886kL2.d() == null || !AbstractC13042fc3.d(abstractC15886kL2.f(), "updateTransition")) {
                return null;
            }
            return abstractC15886kL2;
        }

        @Override // ir.nasim.C5298It.j
        public void a(Collection collection) {
            Object next;
            Object next2;
            Set setB = b();
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2F = f((AbstractC15886kL2) it.next());
                if (abstractC15886kL2F != null) {
                    arrayList.add(abstractC15886kL2F);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Iterator it3 = ((AbstractC15886kL2) it2.next()).c().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it3.next();
                        if (next2 instanceof C21669tv7) {
                            break;
                        }
                    }
                }
                C21669tv7 c21669tv7 = (C21669tv7) (next2 instanceof C21669tv7 ? next2 : null);
                if (c21669tv7 != null) {
                    arrayList2.add(c21669tv7);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                AbstractC15886kL2 abstractC15886kL2E = AbstractC9364Zp5.e((AbstractC15886kL2) it4.next(), C5532Jt.e);
                if (abstractC15886kL2E != null) {
                    arrayList3.add(abstractC15886kL2E);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                Iterator it6 = ((AbstractC15886kL2) it5.next()).c().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it6.next();
                        if (next instanceof C21669tv7) {
                            break;
                        }
                    }
                }
                if (!(next instanceof C21669tv7)) {
                    next = null;
                }
                C21669tv7 c21669tv72 = (C21669tv7) next;
                if (c21669tv72 != null) {
                    arrayList4.add(c21669tv72);
                }
            }
            setB.addAll(AbstractC15401jX0.R0(arrayList2, arrayList4));
        }

        @Override // ir.nasim.C5298It.j
        public boolean c(AbstractC15886kL2 abstractC15886kL2) {
            return f(abstractC15886kL2) != null;
        }
    }

    /* renamed from: ir.nasim.It$m */
    static final class m extends AbstractC8614Ws3 implements UA2 {
        m() {
            super(1);
        }

        public final void a(c cVar) {
            ((C9355Zo5) C5298It.this.a.invoke()).l(cVar);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$n */
    static final class n extends AbstractC8614Ws3 implements UA2 {
        n() {
            super(1);
        }

        public final void a(C21669tv7 c21669tv7) {
            ((C9355Zo5) C5298It.this.a.invoke()).m(c21669tv7);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C21669tv7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$o */
    static final class o extends AbstractC8614Ws3 implements UA2 {
        o() {
            super(1);
        }

        public final void a(C21669tv7 c21669tv7) {
            ((C9355Zo5) C5298It.this.a.invoke()).n(c21669tv7, C5298It.this.b);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C21669tv7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$p */
    static final class p extends AbstractC8614Ws3 implements UA2 {
        public static final p e = new p();

        p() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC15886kL2 abstractC15886kL2) {
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.It$q */
    static final class q extends AbstractC8614Ws3 implements UA2 {
        q() {
            super(1);
        }

        public final void a(h hVar) {
            ((C9355Zo5) C5298It.this.a.invoke()).q(hVar);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((h) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$r */
    static final class r extends AbstractC8614Ws3 implements UA2 {
        public static final r e = new r();

        r() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC15886kL2 abstractC15886kL2) {
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.It$s */
    static final class s extends AbstractC8614Ws3 implements UA2 {
        s() {
            super(1);
        }

        public final void a(C21669tv7 c21669tv7) {
            ((C9355Zo5) C5298It.this.a.invoke()).s(c21669tv7);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C21669tv7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$t */
    static final class t extends AbstractC8614Ws3 implements UA2 {
        t() {
            super(1);
        }

        public final void a(Object obj) {
            ((C9355Zo5) C5298It.this.a.invoke()).k(obj);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$u */
    static final class u extends AbstractC8614Ws3 implements UA2 {
        u() {
            super(1);
        }

        public final void a(C23915xj7 c23915xj7) {
            ((C9355Zo5) C5298It.this.a.invoke()).r(c23915xj7);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23915xj7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.It$v */
    static final class v extends AbstractC8614Ws3 implements UA2 {
        v() {
            super(1);
        }

        public final void a(C9569aB1 c9569aB1) {
            ((C9355Zo5) C5298It.this.a.invoke()).p(c9569aB1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C9569aB1) obj);
            return C19938rB7.a;
        }
    }

    public C5298It(SA2 sa2, SA2 sa22) {
        this.a = sa2;
        this.b = sa22;
        d dVar = new d(new n());
        this.d = dVar;
        this.e = new e(new o());
        Set setG = g();
        this.f = setG;
        Set setL = AbstractC4846Gu6.l(setG, h());
        this.g = setL;
        this.h = AbstractC4846Gu6.l(setL, AbstractC4363Eu6.c(dVar));
    }

    private final Collection c() {
        return C5289Is.g.a() ? AbstractC4363Eu6.c(new b(new m())) : AbstractC10360bX0.m();
    }

    private final Set e() {
        return C22361v63.f.a() ? AbstractC4363Eu6.c(new g(new q())) : AbstractC4597Fu6.d();
    }

    private final Set g() {
        return AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4597Fu6.i(this.c, this.e), c()), e()), C5523Js.e.a() ? AbstractC4363Eu6.c(this.d) : AbstractC4597Fu6.d());
    }

    private final Collection h() {
        return C10794cC7.e.b() ? AbstractC4597Fu6.i(new a(new t()), new k(new u()), new f(new v())) : AbstractC10360bX0.m();
    }

    public final void d(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            List listB = AbstractC9364Zp5.b((AbstractC15886kL2) it.next(), p.e);
            Iterator it2 = this.h.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(listB);
            }
            this.c.b().removeAll(this.e.b());
            this.c.b().removeAll(this.d.b());
        }
        Iterator it3 = this.g.iterator();
        while (it3.hasNext()) {
            ((j) it3.next()).e();
        }
    }

    public final boolean f(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return false;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            List listB = AbstractC9364Zp5.b((AbstractC15886kL2) it.next(), r.e);
            Set set = this.f;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (((j) it2.next()).d(listB)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
