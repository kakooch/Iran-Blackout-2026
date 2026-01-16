package ir.nasim.features.mxp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17902nl0;
import ir.nasim.AbstractC18386oa3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.C19084pl0;
import ir.nasim.C19675ql0;
import ir.nasim.C24411ya3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR*\u0010%\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001c\u0012\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R6\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001e\u0012\u0004\b)\u0010$\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lir/nasim/features/mxp/entity/PuppetGroup;", "Lir/nasim/nl0;", "Landroid/os/Parcelable;", "", "_name", "", "Lir/nasim/features/mxp/entity/PuppetUser;", "_puppets", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lir/nasim/pl0;", "values", "Lir/nasim/rB7;", "parse", "(Lir/nasim/pl0;)V", "Lir/nasim/ql0;", "writer", "serialize", "(Lir/nasim/ql0;)V", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "Ljava/lang/String;", "b", "Ljava/util/List;", "value", "c", "getName", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "d", "q", "()Ljava/util/List;", "getPuppets$annotations", "puppets", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PuppetGroup extends AbstractC17902nl0 implements Parcelable {
    public static final Parcelable.Creator<PuppetGroup> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata */
    private final String _name;

    /* renamed from: b, reason: from kotlin metadata */
    private final List _puppets;

    /* renamed from: c, reason: from kotlin metadata */
    private String name;

    /* renamed from: d, reason: from kotlin metadata */
    private List puppets;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PuppetGroup createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PuppetUser.CREATOR.createFromParcel(parcel));
            }
            return new PuppetGroup(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PuppetGroup[] newArray(int i) {
            return new PuppetGroup[i];
        }
    }

    public PuppetGroup(String str, List list) {
        AbstractC13042fc3.i(str, "_name");
        AbstractC13042fc3.i(list, "_puppets");
        this._name = str;
        this._puppets = list;
        this.name = str;
        this.puppets = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getName() {
        return this.name;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 values) {
        if (values != null) {
            this.name = values.r(1);
            C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, values.m(2));
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(c24411ya3Y, 10));
            Iterator it = c24411ya3Y.iterator();
            while (it.hasNext()) {
                ((AbstractC18386oa3) it).b();
                arrayList.add(new PuppetUser(0, ir.nasim.features.mxp.entity.a.e));
            }
            this.puppets = values.p(2, arrayList);
        }
    }

    /* renamed from: q, reason: from getter */
    public final List getPuppets() {
        return this.puppets;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 writer) {
        if (writer != null) {
            writer.o(1, this.name);
        }
        if (writer != null) {
            writer.m(2, this.puppets);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this._name);
        List list = this._puppets;
        dest.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PuppetUser) it.next()).writeToParcel(dest, flags);
        }
    }
}
