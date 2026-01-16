package ir.nasim.database.model.story;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lir/nasim/database/model/story/WidgetCoordinate;", "Landroid/os/Parcelable;", "", "x", "y", "<init>", "(FF)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "(FF)Lir/nasim/database/model/story/WidgetCoordinate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TokenNames.F, "b", "()F", "c", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class WidgetCoordinate implements Parcelable {
    public static final Parcelable.Creator<WidgetCoordinate> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("x")
    private final float x;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("y")
    private final float y;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WidgetCoordinate createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new WidgetCoordinate(parcel.readFloat(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final WidgetCoordinate[] newArray(int i) {
            return new WidgetCoordinate[i];
        }
    }

    public WidgetCoordinate(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public final WidgetCoordinate a(float x, float y) {
        return new WidgetCoordinate(x, y);
    }

    /* renamed from: b, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: c, reason: from getter */
    public final float getY() {
        return this.y;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCoordinate)) {
            return false;
        }
        WidgetCoordinate widgetCoordinate = (WidgetCoordinate) other;
        return Float.compare(this.x, widgetCoordinate.x) == 0 && Float.compare(this.y, widgetCoordinate.y) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "WidgetCoordinate(x=" + this.x + ", y=" + this.y + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeFloat(this.x);
        dest.writeFloat(this.y);
    }
}
