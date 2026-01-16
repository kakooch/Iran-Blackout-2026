package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC16812lu2;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.ap, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9942ap implements InterfaceC9848af5 {
    private final Context a;
    private final Object b;

    /* renamed from: ir.nasim.ap$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C9942ap.this.a(null, this);
        }
    }

    public C9942ap(Context context) {
        this.a = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC9848af5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC8154Ut2 r5, ir.nasim.InterfaceC20295rm1 r6) throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C9942ap.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.ap$a r0 = (ir.nasim.C9942ap.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.ap$a r0 = new ir.nasim.ap$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            if (r2 == 0) goto L40
            r5 = 1
            if (r2 == r5) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.b
            ir.nasim.Ut2 r5 = (ir.nasim.InterfaceC8154Ut2) r5
            java.lang.Object r0 = r0.a
            ir.nasim.ap r0 = (ir.nasim.C9942ap) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L5a
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            ir.nasim.AbstractC10685c16.b(r6)
            return r6
        L40:
            ir.nasim.AbstractC10685c16.b(r6)
            boolean r6 = r5 instanceof ir.nasim.MW5
            if (r6 == 0) goto L69
            r6 = r5
            ir.nasim.MW5 r6 = (ir.nasim.MW5) r6
            android.content.Context r2 = r4.a
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = ir.nasim.AbstractC10562bp.b(r6, r2, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r4
        L5a:
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            ir.nasim.MW5 r5 = (ir.nasim.MW5) r5
            ir.nasim.Eu2 r5 = r5.e()
            android.content.Context r0 = r0.a
            android.graphics.Typeface r5 = ir.nasim.AbstractC3759Cf5.c(r6, r5, r0)
            return r5
        L69:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown font type: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9942ap.a(ir.nasim.Ut2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC9848af5
    public Object b() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC9848af5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Typeface c(InterfaceC8154Ut2 interfaceC8154Ut2) {
        Object objB;
        Typeface typefaceC;
        if (!(interfaceC8154Ut2 instanceof MW5)) {
            return null;
        }
        int iA = interfaceC8154Ut2.a();
        AbstractC16812lu2.a aVar = AbstractC16812lu2.a;
        if (AbstractC16812lu2.e(iA, aVar.b())) {
            typefaceC = AbstractC10562bp.c((MW5) interfaceC8154Ut2, this.a);
        } else {
            if (!AbstractC16812lu2.e(iA, aVar.c())) {
                if (AbstractC16812lu2.e(iA, aVar.a())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) AbstractC16812lu2.g(interfaceC8154Ut2.a())));
            }
            try {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10562bp.c((MW5) interfaceC8154Ut2, this.a));
            } catch (Throwable th) {
                C9475a16.a aVar3 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            typefaceC = (Typeface) (C9475a16.g(objB) ? null : objB);
        }
        return AbstractC3759Cf5.c(typefaceC, ((MW5) interfaceC8154Ut2).e(), this.a);
    }
}
