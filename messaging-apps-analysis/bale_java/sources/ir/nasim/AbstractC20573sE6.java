package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.sE6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20573sE6 {

    /* renamed from: ir.nasim.sE6$a */
    static final class a extends V06 implements InterfaceC14603iB2 {
        Object a;
        Object b;
        int c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ Iterator h;
        final /* synthetic */ boolean i;
        final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, int i2, Iterator it, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = i;
            this.g = i2;
            this.h = it;
            this.i = z;
            this.j = z2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
            aVar.e = obj;
            return aVar;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(AbstractC6703Op6 abstractC6703Op6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC6703Op6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x014f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0055). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0118 -> B:59:0x011b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0146 -> B:72:0x0149). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 360
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20573sE6.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.sE6$b */
    public static final class b implements InterfaceC23384wp6 {
        final /* synthetic */ InterfaceC23384wp6 a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;

        public b(InterfaceC23384wp6 interfaceC23384wp6, int i, int i2, boolean z, boolean z2) {
            this.a = interfaceC23384wp6;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = z2;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return AbstractC20573sE6.b(this.a.iterator(), this.b, this.c, this.d, this.e);
        }
    }

    public static final void a(int i, int i2) {
        String str;
        if (i <= 0 || i2 <= 0) {
            if (i != i2) {
                str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
            } else {
                str = "size " + i + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final Iterator b(Iterator it, int i, int i2, boolean z, boolean z2) {
        AbstractC13042fc3.i(it, "iterator");
        return !it.hasNext() ? C21780u72.a : AbstractC9131Yp6.a(new a(i, i2, it, z2, z, null));
    }

    public static final InterfaceC23384wp6 c(InterfaceC23384wp6 interfaceC23384wp6, int i, int i2, boolean z, boolean z2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        a(i, i2);
        return new b(interfaceC23384wp6, i, i2, z, z2);
    }
}
