package ir.nasim;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class NF2 {
    private final AbstractC13778go1 a;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QT1 c;
        final /* synthetic */ NF2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(QT1 qt1, NF2 nf2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = qt1;
            this.d = nf2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List listE = this.c.e();
            NF2 nf2 = this.d;
            QT1 qt1 = this.c;
            Iterator it = listE.iterator();
            long jB = 0;
            while (it.hasNext()) {
                jB += nf2.b((File) it.next(), qt1.a());
            }
            return AbstractC6392Nk0.e(jB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public NF2(AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b(File file, InterfaceC6897Pl2 interfaceC6897Pl2) {
        long length;
        long j = 0;
        if (!file.exists()) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                AbstractC13042fc3.f(file2);
                if (interfaceC6897Pl2.a(file, file2)) {
                    arrayList.add(file2);
                }
            }
            for (File file3 : arrayList) {
                if (file3.isDirectory()) {
                    AbstractC13042fc3.f(file3);
                    length = b(file3, interfaceC6897Pl2);
                } else {
                    length = file3.length();
                }
                j += length;
            }
        }
        return j;
    }

    public final Object c(QT1 qt1, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new a(qt1, this, null), interfaceC20295rm1);
    }
}
