package ir.nasim;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.List;

/* renamed from: ir.nasim.hP4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14133hP4 extends BarDataSet {
    private List m;
    private MA n;

    public /* synthetic */ C14133hP4(List list, MA ma, List list2, String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC10360bX0.m() : list, (i & 2) != 0 ? null : ma, (i & 4) != 0 ? AbstractC10360bX0.m() : list2, (i & 8) != 0 ? "" : str);
    }

    @Override // com.github.mikephil.charting.data.DataSet, com.github.mikephil.charting.interfaces.datasets.IDataSet
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int getEntryIndex(BarEntry barEntry) {
        AbstractC13042fc3.i(barEntry, "barEntry");
        return super.getEntryIndex(barEntry);
    }

    public final void d(MA ma) {
        this.n = ma;
    }

    public final void e(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.m = list;
    }

    @Override // com.github.mikephil.charting.data.BaseDataSet, com.github.mikephil.charting.interfaces.datasets.IDataSet
    public int getColor(int i) {
        if (this.m.contains(Integer.valueOf(i))) {
            Integer num = this.mColors.get(0);
            AbstractC13042fc3.f(num);
            return num.intValue();
        }
        Integer num2 = this.n == MA.TOPUP ? this.mColors.get(1) : this.mColors.get(2);
        AbstractC13042fc3.f(num2);
        return num2.intValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14133hP4(List list, MA ma, List list2, String str) {
        super(list2, str);
        AbstractC13042fc3.i(list, "zeroIndex");
        AbstractC13042fc3.i(list2, "yValues");
        AbstractC13042fc3.i(str, "label");
        this.m = list;
        this.n = ma;
    }
}
