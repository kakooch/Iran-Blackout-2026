package ir.nasim.features.mxp.entity;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17902nl0;
import ir.nasim.C19084pl0;
import ir.nasim.C19675ql0;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\"\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u0012\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\u0018R*\u0010'\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001c\u0012\u0004\b&\u0010!\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lir/nasim/features/mxp/entity/PuppetUser;", "Lir/nasim/nl0;", "Landroid/os/Parcelable;", "", "_userId", "Lir/nasim/features/mxp/entity/a;", "_puppetType", "<init>", "(ILir/nasim/features/mxp/entity/a;)V", "Lir/nasim/pl0;", "values", "Lir/nasim/rB7;", "parse", "(Lir/nasim/pl0;)V", "Lir/nasim/ql0;", "writer", "serialize", "(Lir/nasim/ql0;)V", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", TokenNames.I, "b", "Lir/nasim/features/mxp/entity/a;", "value", "c", "r", "getUserId$annotations", "()V", "userId", "d", "q", "()Lir/nasim/features/mxp/entity/a;", "getPuppetType$annotations", DialogEntity.COLUMN_PUPPET_TYPE, "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PuppetUser extends AbstractC17902nl0 implements Parcelable {
    public static final Parcelable.Creator<PuppetUser> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata */
    private final int _userId;

    /* renamed from: b, reason: from kotlin metadata */
    private final ir.nasim.features.mxp.entity.a _puppetType;

    /* renamed from: c, reason: from kotlin metadata */
    private int userId;

    /* renamed from: d, reason: from kotlin metadata */
    private ir.nasim.features.mxp.entity.a puppetType;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PuppetUser createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new PuppetUser(parcel.readInt(), ir.nasim.features.mxp.entity.a.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PuppetUser[] newArray(int i) {
            return new PuppetUser[i];
        }
    }

    public PuppetUser(int i, ir.nasim.features.mxp.entity.a aVar) {
        AbstractC13042fc3.i(aVar, "_puppetType");
        this._userId = i;
        this._puppetType = aVar;
        this.userId = i;
        this.puppetType = aVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 values) {
        if (values != null) {
            this.userId = values.g(1);
            ir.nasim.features.mxp.entity.a aVarA = ir.nasim.features.mxp.entity.a.d.a(values.g(2));
            if (aVarA == null) {
                aVarA = ir.nasim.features.mxp.entity.a.e;
            }
            this.puppetType = aVarA;
        }
    }

    /* renamed from: q, reason: from getter */
    public final ir.nasim.features.mxp.entity.a getPuppetType() {
        return this.puppetType;
    }

    /* renamed from: r, reason: from getter */
    public final int getUserId() {
        return this.userId;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 writer) {
        if (writer != null) {
            writer.f(1, this.userId);
        }
        if (writer != null) {
            writer.f(2, this.puppetType.r());
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this._userId);
        dest.writeString(this._puppetType.name());
    }
}
