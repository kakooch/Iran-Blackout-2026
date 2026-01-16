package ir.nasim.animation.view.transition.sharedelement;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\nJ-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\nR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010\nR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"\"\u0004\b)\u0010\nR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b*\u0010\n¨\u0006+"}, d2 = {"Lir/nasim/animation/view/transition/sharedelement/Corners;", "Landroid/os/Parcelable;", "", "topRight", "topLeft", "bottomRight", "bottomLeft", "<init>", "(FFFF)V", "corner", "(F)V", "Lir/nasim/rB7;", "g", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "(FFFF)Lir/nasim/animation/view/transition/sharedelement/Corners;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TokenNames.F, "f", "()F", "setTopRight", "b", "e", "setTopLeft", "c", "d", "setBottomRight", "setBottomLeft", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes3.dex */
public final /* data */ class Corners implements Parcelable {
    public static final Parcelable.Creator<Corners> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private float topRight;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private float topLeft;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private float bottomRight;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private float bottomLeft;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Corners createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new Corners(parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Corners[] newArray(int i) {
            return new Corners[i];
        }
    }

    public Corners(float f, float f2, float f3, float f4) {
        this.topRight = f;
        this.topLeft = f2;
        this.bottomRight = f3;
        this.bottomLeft = f4;
    }

    public static /* synthetic */ Corners b(Corners corners, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = corners.topRight;
        }
        if ((i & 2) != 0) {
            f2 = corners.topLeft;
        }
        if ((i & 4) != 0) {
            f3 = corners.bottomRight;
        }
        if ((i & 8) != 0) {
            f4 = corners.bottomLeft;
        }
        return corners.a(f, f2, f3, f4);
    }

    public final Corners a(float topRight, float topLeft, float bottomRight, float bottomLeft) {
        return new Corners(topRight, topLeft, bottomRight, bottomLeft);
    }

    /* renamed from: c, reason: from getter */
    public final float getBottomLeft() {
        return this.bottomLeft;
    }

    /* renamed from: d, reason: from getter */
    public final float getBottomRight() {
        return this.bottomRight;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final float getTopLeft() {
        return this.topLeft;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Corners)) {
            return false;
        }
        Corners corners = (Corners) other;
        return Float.compare(this.topRight, corners.topRight) == 0 && Float.compare(this.topLeft, corners.topLeft) == 0 && Float.compare(this.bottomRight, corners.bottomRight) == 0 && Float.compare(this.bottomLeft, corners.bottomLeft) == 0;
    }

    /* renamed from: f, reason: from getter */
    public final float getTopRight() {
        return this.topRight;
    }

    public final void g(float topRight, float topLeft, float bottomRight, float bottomLeft) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.topRight) * 31) + Float.hashCode(this.topLeft)) * 31) + Float.hashCode(this.bottomRight)) * 31) + Float.hashCode(this.bottomLeft);
    }

    public String toString() {
        return "Corners(topRight=" + this.topRight + ", topLeft=" + this.topLeft + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeFloat(this.topRight);
        dest.writeFloat(this.topLeft);
        dest.writeFloat(this.bottomRight);
        dest.writeFloat(this.bottomLeft);
    }

    public /* synthetic */ Corners(float f, float f2, float f3, float f4, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4);
    }

    public Corners(float f) {
        this(f, f, f, f);
    }
}
