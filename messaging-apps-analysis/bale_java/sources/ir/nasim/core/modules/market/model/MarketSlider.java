package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0015\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u001a\u0010\u0012J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0007R(\u0010#\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b#\u0010$\u0012\u0004\b(\u0010\n\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lir/nasim/core/modules/market/model/MarketSlider;", "Landroid/os/Parcelable;", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/market/model/MarketSlideItem;", "Lkotlin/collections/ArrayList;", "slides", "<init>", "(Ljava/util/ArrayList;)V", "Lir/nasim/rB7;", "validate", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/ArrayList;", "copy", "(Ljava/util/ArrayList;)Lir/nasim/core/modules/market/model/MarketSlider;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getSlides", "setSlides", "sliderPosition", TokenNames.I, "getSliderPosition", "setSliderPosition", "(I)V", "getSliderPosition$annotations", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketSlider implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketSlider> CREATOR = new a();
    private int sliderPosition;

    @InterfaceC23984xq6("banner")
    private ArrayList<MarketSlideItem> slides;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketSlider createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(MarketSlideItem.CREATOR.createFromParcel(parcel));
            }
            return new MarketSlider(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketSlider[] newArray(int i) {
            return new MarketSlider[i];
        }
    }

    public MarketSlider(ArrayList<MarketSlideItem> arrayList) {
        AbstractC13042fc3.i(arrayList, "slides");
        this.slides = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketSlider copy$default(MarketSlider marketSlider, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = marketSlider.slides;
        }
        return marketSlider.copy(arrayList);
    }

    public static /* synthetic */ void getSliderPosition$annotations() {
    }

    public final ArrayList<MarketSlideItem> component1() {
        return this.slides;
    }

    public final MarketSlider copy(ArrayList<MarketSlideItem> slides) {
        AbstractC13042fc3.i(slides, "slides");
        return new MarketSlider(slides);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MarketSlider) && AbstractC13042fc3.d(this.slides, ((MarketSlider) other).slides);
    }

    public final int getSliderPosition() {
        return this.sliderPosition;
    }

    public final ArrayList<MarketSlideItem> getSlides() {
        return this.slides;
    }

    public int hashCode() {
        return this.slides.hashCode();
    }

    public final void setSliderPosition(int i) {
        this.sliderPosition = i;
    }

    public final void setSlides(ArrayList<MarketSlideItem> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.slides = arrayList;
    }

    public String toString() {
        return "MarketSlider(slides=" + this.slides + Separators.RPAREN;
    }

    public final void validate() {
        Iterator<T> it = this.slides.iterator();
        while (it.hasNext()) {
            ((MarketSlideItem) it.next()).validate();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        ArrayList<MarketSlideItem> arrayList = this.slides;
        dest.writeInt(arrayList.size());
        Iterator<MarketSlideItem> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
