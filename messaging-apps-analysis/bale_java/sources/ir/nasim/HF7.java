package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* loaded from: classes5.dex */
public final class HF7 {
    private final InterfaceC12532em2 a;
    private final E84 b;
    private final InterfaceC20315ro1 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ C11458d25 g;
        final /* synthetic */ long h;
        final /* synthetic */ C6035Lx i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11458d25 c11458d25, long j, C6035Lx c6035Lx, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = c11458d25;
            this.h = j;
            this.i = c6035Lx;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return HF7.this.new a(this.g, this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x0145 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HF7.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public HF7(InterfaceC12532em2 interfaceC12532em2, E84 e84, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = interfaceC12532em2;
        this.b = e84;
        this.c = interfaceC20315ro1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(J44 j44, C11458d25 c11458d25, J08 j08, String str) {
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(new File(str)), C12275eL0.b);
        this.b.H0(c11458d25).d(J44.D(j44, 0L, 0L, 0L, 0, null, J08.l.a(j08, VoiceTranscript.c(j08.J(), EnumC9477a18.d, AbstractC8839Xn7.e(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)), false, 4, null)), null, 0, null, null, 0L, null, null, false, null, false, null, null, 262111, null));
    }

    public final InterfaceC13730gj3 d(C11458d25 c11458d25, long j, C6035Lx c6035Lx) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c6035Lx, DialogEntity.COLUMN_MESSAGE);
        return AbstractC10533bm0.d(this.c, C12366eV1.b(), null, new a(c11458d25, j, c6035Lx, null), 2, null);
    }
}
