package ir.nasim.story.ui.storyadder;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.F92;
import ir.nasim.G92;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000ej\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/story/ui/storyadder/StoryAdderSourceCallerEnum;", "Landroid/os/Parcelable;", "", "", "actionType", "<init>", "(Ljava/lang/String;II)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", TokenNames.I, "j", "b", "c", "d", "e", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class StoryAdderSourceCallerEnum implements Parcelable {
    public static final Parcelable.Creator<StoryAdderSourceCallerEnum> CREATOR;
    public static final StoryAdderSourceCallerEnum b = new StoryAdderSourceCallerEnum("MY_STORY", 0, 2);
    public static final StoryAdderSourceCallerEnum c = new StoryAdderSourceCallerEnum("JARYAN_TAB", 1, 1);
    public static final StoryAdderSourceCallerEnum d = new StoryAdderSourceCallerEnum("PROFILE", 2, 3);
    public static final StoryAdderSourceCallerEnum e = new StoryAdderSourceCallerEnum("DEEP_LINK", 3, 4);
    private static final /* synthetic */ StoryAdderSourceCallerEnum[] f;
    private static final /* synthetic */ F92 g;

    /* renamed from: a, reason: from kotlin metadata */
    private final int actionType;

    static {
        StoryAdderSourceCallerEnum[] storyAdderSourceCallerEnumArrA = a();
        f = storyAdderSourceCallerEnumArrA;
        g = G92.a(storyAdderSourceCallerEnumArrA);
        CREATOR = new Parcelable.Creator() { // from class: ir.nasim.story.ui.storyadder.StoryAdderSourceCallerEnum.a
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final StoryAdderSourceCallerEnum createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return StoryAdderSourceCallerEnum.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final StoryAdderSourceCallerEnum[] newArray(int i) {
                return new StoryAdderSourceCallerEnum[i];
            }
        };
    }

    private StoryAdderSourceCallerEnum(String str, int i, int i2) {
        this.actionType = i2;
    }

    private static final /* synthetic */ StoryAdderSourceCallerEnum[] a() {
        return new StoryAdderSourceCallerEnum[]{b, c, d, e};
    }

    public static StoryAdderSourceCallerEnum valueOf(String str) {
        return (StoryAdderSourceCallerEnum) Enum.valueOf(StoryAdderSourceCallerEnum.class, str);
    }

    public static StoryAdderSourceCallerEnum[] values() {
        return (StoryAdderSourceCallerEnum[]) f.clone();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: j, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(name());
    }
}
