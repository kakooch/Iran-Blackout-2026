package ir.nasim;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.fm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13166fm0 extends AbstractC7310Re0 {
    public static final a g = new a(null);
    public static final C13166fm0 h = new C13166fm0(1, 0, 7);
    public static final C13166fm0 i = new C13166fm0(new int[0]);

    /* renamed from: ir.nasim.fm0$a */
    public static final class a {
        private a() {
        }

        public final C13166fm0 a(InputStream inputStream) {
            AbstractC13042fc3.i(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            C24411ya3 c24411ya3 = new C24411ya3(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(c24411ya3, 10));
            Iterator it = c24411ya3.iterator();
            while (it.hasNext()) {
                ((AbstractC18386oa3) it).b();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] iArrL1 = AbstractC15401jX0.l1(arrayList);
            int[] iArr = new int[iArrL1.length];
            System.arraycopy(iArrL1, 0, iArr, 0, iArrL1.length);
            return new C13166fm0(iArr);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C13166fm0(int... iArr) {
        AbstractC13042fc3.i(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
    }

    public boolean h() {
        return f(h);
    }
}
