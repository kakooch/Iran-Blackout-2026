package ir.nasim;

import androidx.compose.ui.focus.FocusTargetNode;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Nr2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6468Nr2 {
    private final C7386Rm4 a = AbstractC22068uc6.b();
    private final C12544en4 b = new C12544en4(new SA2[16], 0);
    private boolean c;
    private int d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.a.k();
        this.c = false;
        C12544en4 c12544en4 = this.b;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            ((SA2) objArr[i]).invoke();
        }
        this.b.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r14 = this;
            ir.nasim.Rm4 r0 = r14.a
            java.lang.Object[] r1 = r0.b
            long[] r0 = r0.a
            int r2 = r0.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L47
            r4 = r3
        Ld:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L42
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L27:
            if (r9 >= r7) goto L40
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3c
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            r10.z2()
        L3c:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L27
        L40:
            if (r7 != r8) goto L47
        L42:
            if (r4 == r2) goto L47
            int r4 = r4 + 1
            goto Ld
        L47:
            ir.nasim.Rm4 r0 = r14.a
            r0.k()
            r14.c = r3
            ir.nasim.en4 r0 = r14.b
            r0.k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6468Nr2.g():void");
    }

    public final int h() {
        return this.d;
    }

    public final boolean i() {
        return this.c;
    }

    public final EnumC5751Kr2 j(FocusTargetNode focusTargetNode) {
        if (C15439jb1.g) {
            throw new IllegalStateException("uncommittedFocusState must not be accessed when isTrackFocusEnabled is on".toString());
        }
        return (EnumC5751Kr2) this.a.e(focusTargetNode);
    }

    public final void k(FocusTargetNode focusTargetNode, EnumC5751Kr2 enumC5751Kr2) {
        if (C15439jb1.g) {
            return;
        }
        EnumC5751Kr2 enumC5751Kr22 = (EnumC5751Kr2) this.a.e(focusTargetNode);
        if (enumC5751Kr22 == null) {
            enumC5751Kr22 = EnumC5751Kr2.d;
        }
        if (enumC5751Kr22 != enumC5751Kr2) {
            this.d++;
        }
        C7386Rm4 c7386Rm4 = this.a;
        if (enumC5751Kr2 != null) {
            c7386Rm4.x(focusTargetNode, enumC5751Kr2);
        } else {
            M73.c("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }
}
