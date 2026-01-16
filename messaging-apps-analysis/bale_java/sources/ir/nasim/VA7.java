package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class VA7 {
    private final InterfaceC16978mB2 a;
    private final InterfaceC22299v01 b;
    private final InterfaceC19699qn4 c;
    private final InterfaceC22299v01[] d;
    private final Object[] e;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return VA7.this.a(0, null, this);
        }
    }

    public VA7(InterfaceC16978mB2 interfaceC16978mB2) {
        AbstractC13042fc3.i(interfaceC16978mB2, "send");
        this.a = interfaceC16978mB2;
        this.b = AbstractC23485x01.c(null, 1, null);
        this.c = AbstractC20899sn4.b(false, 1, null);
        InterfaceC22299v01[] interfaceC22299v01Arr = new InterfaceC22299v01[2];
        for (int i = 0; i < 2; i++) {
            interfaceC22299v01Arr[i] = AbstractC23485x01.c(null, 1, null);
        }
        this.d = interfaceC22299v01Arr;
        Object[] objArr = new Object[2];
        for (int i2 = 0; i2 < 2; i2++) {
            objArr[i2] = AbstractC6209Mq2.a;
        }
        this.e = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(int r17, java.lang.Object r18, ir.nasim.InterfaceC20295rm1 r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VA7.a(int, java.lang.Object, ir.nasim.rm1):java.lang.Object");
    }
}
