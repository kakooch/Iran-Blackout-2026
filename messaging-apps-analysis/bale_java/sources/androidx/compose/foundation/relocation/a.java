package androidx.compose.foundation.relocation;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12544en4;
import ir.nasim.CK5;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC7598Sk0;
import ir.nasim.SA2;

/* loaded from: classes.dex */
final class a implements InterfaceC7598Sk0 {
    private final C12544en4 a = new C12544en4(new d[16], 0);

    /* renamed from: androidx.compose.foundation.relocation.a$a, reason: collision with other inner class name */
    static final class C0047a extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        int d;
        /* synthetic */ Object e;
        int g;

        C0047a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return a.this.a(null, this);
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ CK5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CK5 ck5) {
            super(0);
            this.e = ck5;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CK5 invoke() {
            return this.e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0069 -> B:19:0x006c). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC7598Sk0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.CK5 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.relocation.a.C0047a
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.foundation.relocation.a$a r0 = (androidx.compose.foundation.relocation.a.C0047a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            androidx.compose.foundation.relocation.a$a r0 = new androidx.compose.foundation.relocation.a$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r10 = r0.d
            int r2 = r0.c
            java.lang.Object r4 = r0.b
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r5 = r0.a
            ir.nasim.CK5 r5 = (ir.nasim.CK5) r5
            ir.nasim.AbstractC10685c16.b(r11)
            r11 = r5
            goto L6c
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.en4 r11 = r9.a
            java.lang.Object[] r2 = r11.a
            int r11 = r11.o()
            r4 = 0
            r7 = r11
            r11 = r10
            r10 = r7
            r8 = r4
            r4 = r2
            r2 = r8
        L50:
            if (r2 >= r10) goto L6e
            r5 = r4[r2]
            androidx.compose.foundation.relocation.d r5 = (androidx.compose.foundation.relocation.d) r5
            androidx.compose.foundation.relocation.a$b r6 = new androidx.compose.foundation.relocation.a$b
            r6.<init>(r11)
            r0.a = r11
            r0.b = r4
            r0.c = r2
            r0.d = r10
            r0.g = r3
            java.lang.Object r5 = ir.nasim.AbstractC7130Qk0.a(r5, r6, r0)
            if (r5 != r1) goto L6c
            return r1
        L6c:
            int r2 = r2 + r3
            goto L50
        L6e:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.a.a(ir.nasim.CK5, ir.nasim.rm1):java.lang.Object");
    }

    public final C12544en4 b() {
        return this.a;
    }
}
