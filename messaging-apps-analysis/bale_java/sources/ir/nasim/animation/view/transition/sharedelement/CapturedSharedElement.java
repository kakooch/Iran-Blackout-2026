package ir.nasim.animation.view.transition.sharedelement;

import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J0\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0001HÇ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH×\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u001d\u0010\u0011J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH×\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010\u0017¨\u0006)"}, d2 = {"Lir/nasim/animation/view/transition/sharedelement/CapturedSharedElement;", "Landroid/os/Parcelable;", "Lir/nasim/animation/view/transition/sharedelement/Corners;", "corners", "Landroid/graphics/Rect;", "clipBounds", "parcelable", "<init>", "(Lir/nasim/animation/view/transition/sharedelement/Corners;Landroid/graphics/Rect;Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lir/nasim/animation/view/transition/sharedelement/Corners;", "component2", "()Landroid/graphics/Rect;", "component3", "()Landroid/os/Parcelable;", "copy", "(Lir/nasim/animation/view/transition/sharedelement/Corners;Landroid/graphics/Rect;Landroid/os/Parcelable;)Lir/nasim/animation/view/transition/sharedelement/CapturedSharedElement;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/animation/view/transition/sharedelement/Corners;", "getCorners", "Landroid/graphics/Rect;", "getClipBounds", "Landroid/os/Parcelable;", "getParcelable", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes3.dex */
public final /* data */ class CapturedSharedElement implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CapturedSharedElement> CREATOR = new a();
    private final Rect clipBounds;
    private final Corners corners;
    private final Parcelable parcelable;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CapturedSharedElement createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new CapturedSharedElement(Corners.CREATOR.createFromParcel(parcel), (Rect) parcel.readParcelable(CapturedSharedElement.class.getClassLoader()), parcel.readParcelable(CapturedSharedElement.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CapturedSharedElement[] newArray(int i) {
            return new CapturedSharedElement[i];
        }
    }

    public CapturedSharedElement(Corners corners, Rect rect, Parcelable parcelable) {
        AbstractC13042fc3.i(corners, "corners");
        AbstractC13042fc3.i(parcelable, "parcelable");
        this.corners = corners;
        this.clipBounds = rect;
        this.parcelable = parcelable;
    }

    public static /* synthetic */ CapturedSharedElement copy$default(CapturedSharedElement capturedSharedElement, Corners corners, Rect rect, Parcelable parcelable, int i, Object obj) {
        if ((i & 1) != 0) {
            corners = capturedSharedElement.corners;
        }
        if ((i & 2) != 0) {
            rect = capturedSharedElement.clipBounds;
        }
        if ((i & 4) != 0) {
            parcelable = capturedSharedElement.parcelable;
        }
        return capturedSharedElement.copy(corners, rect, parcelable);
    }

    /* renamed from: component1, reason: from getter */
    public final Corners getCorners() {
        return this.corners;
    }

    /* renamed from: component2, reason: from getter */
    public final Rect getClipBounds() {
        return this.clipBounds;
    }

    /* renamed from: component3, reason: from getter */
    public final Parcelable getParcelable() {
        return this.parcelable;
    }

    public final CapturedSharedElement copy(Corners corners, Rect clipBounds, Parcelable parcelable) {
        AbstractC13042fc3.i(corners, "corners");
        AbstractC13042fc3.i(parcelable, "parcelable");
        return new CapturedSharedElement(corners, clipBounds, parcelable);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CapturedSharedElement)) {
            return false;
        }
        CapturedSharedElement capturedSharedElement = (CapturedSharedElement) other;
        return AbstractC13042fc3.d(this.corners, capturedSharedElement.corners) && AbstractC13042fc3.d(this.clipBounds, capturedSharedElement.clipBounds) && AbstractC13042fc3.d(this.parcelable, capturedSharedElement.parcelable);
    }

    public final Rect getClipBounds() {
        return this.clipBounds;
    }

    public final Corners getCorners() {
        return this.corners;
    }

    public final Parcelable getParcelable() {
        return this.parcelable;
    }

    public int hashCode() {
        int iHashCode = this.corners.hashCode() * 31;
        Rect rect = this.clipBounds;
        return ((iHashCode + (rect == null ? 0 : rect.hashCode())) * 31) + this.parcelable.hashCode();
    }

    public String toString() {
        return "CapturedSharedElement(corners=" + this.corners + ", clipBounds=" + this.clipBounds + ", parcelable=" + this.parcelable + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        this.corners.writeToParcel(dest, flags);
        dest.writeParcelable(this.clipBounds, flags);
        dest.writeParcelable(this.parcelable, flags);
    }
}
