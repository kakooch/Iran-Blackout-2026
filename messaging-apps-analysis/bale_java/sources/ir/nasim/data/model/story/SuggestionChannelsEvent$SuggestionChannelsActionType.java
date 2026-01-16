package ir.nasim.data.model.story;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.F92;
import ir.nasim.G92;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000fj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"ir/nasim/data/model/story/SuggestionChannelsEvent$SuggestionChannelsActionType", "Landroid/os/Parcelable;", "", "Lir/nasim/data/model/story/SuggestionChannelsEvent$SuggestionChannelsActionType;", "", "index", "<init>", "(Ljava/lang/String;II)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", TokenNames.I, "j", "b", "c", "d", "e", "f", "data_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class SuggestionChannelsEvent$SuggestionChannelsActionType implements Parcelable {
    public static final Parcelable.Creator<SuggestionChannelsEvent$SuggestionChannelsActionType> CREATOR;
    public static final SuggestionChannelsEvent$SuggestionChannelsActionType b = new SuggestionChannelsEvent$SuggestionChannelsActionType("VIEW", 0, 2);
    public static final SuggestionChannelsEvent$SuggestionChannelsActionType c = new SuggestionChannelsEvent$SuggestionChannelsActionType("CLICK", 1, 3);
    public static final SuggestionChannelsEvent$SuggestionChannelsActionType d = new SuggestionChannelsEvent$SuggestionChannelsActionType("JOIN", 2, 4);
    public static final SuggestionChannelsEvent$SuggestionChannelsActionType e = new SuggestionChannelsEvent$SuggestionChannelsActionType("JOIN_WITH_BUTTON", 3, 5);
    public static final SuggestionChannelsEvent$SuggestionChannelsActionType f = new SuggestionChannelsEvent$SuggestionChannelsActionType("CLIENT_SUGGESTION", 4, 6);
    private static final /* synthetic */ SuggestionChannelsEvent$SuggestionChannelsActionType[] g;
    private static final /* synthetic */ F92 h;

    /* renamed from: a, reason: from kotlin metadata */
    private final int index;

    static {
        SuggestionChannelsEvent$SuggestionChannelsActionType[] suggestionChannelsEvent$SuggestionChannelsActionTypeArrA = a();
        g = suggestionChannelsEvent$SuggestionChannelsActionTypeArrA;
        h = G92.a(suggestionChannelsEvent$SuggestionChannelsActionTypeArrA);
        CREATOR = new Parcelable.Creator() { // from class: ir.nasim.data.model.story.SuggestionChannelsEvent$SuggestionChannelsActionType.a
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SuggestionChannelsEvent$SuggestionChannelsActionType createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return SuggestionChannelsEvent$SuggestionChannelsActionType.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SuggestionChannelsEvent$SuggestionChannelsActionType[] newArray(int i) {
                return new SuggestionChannelsEvent$SuggestionChannelsActionType[i];
            }
        };
    }

    private SuggestionChannelsEvent$SuggestionChannelsActionType(String str, int i, int i2) {
        this.index = i2;
    }

    private static final /* synthetic */ SuggestionChannelsEvent$SuggestionChannelsActionType[] a() {
        return new SuggestionChannelsEvent$SuggestionChannelsActionType[]{b, c, d, e, f};
    }

    public static SuggestionChannelsEvent$SuggestionChannelsActionType valueOf(String str) {
        return (SuggestionChannelsEvent$SuggestionChannelsActionType) Enum.valueOf(SuggestionChannelsEvent$SuggestionChannelsActionType.class, str);
    }

    public static SuggestionChannelsEvent$SuggestionChannelsActionType[] values() {
        return (SuggestionChannelsEvent$SuggestionChannelsActionType[]) g.clone();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: j, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(name());
    }
}
