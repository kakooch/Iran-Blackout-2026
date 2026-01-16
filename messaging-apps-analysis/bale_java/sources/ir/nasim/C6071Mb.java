package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.Mb, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6071Mb {
    private final AbstractC6310Nb a;
    private InterfaceC9336Zm4 b;

    /* renamed from: ir.nasim.Mb$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6071Mb.this.b(this);
        }
    }

    public C6071Mb(AbstractC6310Nb abstractC6310Nb) {
        AbstractC13042fc3.i(abstractC6310Nb, "dataLoader");
        this.a = abstractC6310Nb;
        this.b = AbstractC12281eL6.a(new ArrayList());
    }

    public final InterfaceC10258bL6 a() {
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        AbstractC13042fc3.g(interfaceC9336Zm4, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<kotlin.collections.List<ir.nasim.features.advertisement.legacyImpl.entity.AdContent.BaleCustomAd>>");
        return interfaceC9336Zm4;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0057 -> B:18:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.C6071Mb.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Mb$a r0 = (ir.nasim.C6071Mb.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Mb$a r0 = new ir.nasim.Mb$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r2 = r0.c
            java.lang.Object r4 = r0.b
            ir.nasim.Zm4 r4 = (ir.nasim.InterfaceC9336Zm4) r4
            java.lang.Object r5 = r0.a
            ir.nasim.Mb r5 = (ir.nasim.C6071Mb) r5
            ir.nasim.AbstractC10685c16.b(r7)
            goto L5a
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Zm4 r7 = r6.b
            r5 = r6
            r4 = r7
        L42:
            java.lang.Object r2 = r4.getValue()
            r7 = r2
            java.util.List r7 = (java.util.List) r7
            ir.nasim.Nb r7 = r5.a
            r0.a = r5
            r0.b = r4
            r0.c = r2
            r0.f = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L5a
            return r1
        L5a:
            java.util.List r7 = (java.util.List) r7
            boolean r7 = r4.f(r2, r7)
            if (r7 == 0) goto L42
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6071Mb.b(ir.nasim.rm1):java.lang.Object");
    }
}
