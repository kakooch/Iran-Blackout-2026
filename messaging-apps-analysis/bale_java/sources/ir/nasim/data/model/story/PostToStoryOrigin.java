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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000ej\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lir/nasim/data/model/story/PostToStoryOrigin;", "Landroid/os/Parcelable;", "", "", "index", "<init>", "(Ljava/lang/String;II)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", TokenNames.I, "j", "b", "c", "data_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class PostToStoryOrigin implements Parcelable {
    public static final Parcelable.Creator<PostToStoryOrigin> CREATOR;
    public static final PostToStoryOrigin b = new PostToStoryOrigin("MENU", 0, 1);
    public static final PostToStoryOrigin c = new PostToStoryOrigin("BUBBLE", 1, 2);
    private static final /* synthetic */ PostToStoryOrigin[] d;
    private static final /* synthetic */ F92 e;

    /* renamed from: a, reason: from kotlin metadata */
    private final int index;

    static {
        PostToStoryOrigin[] postToStoryOriginArrA = a();
        d = postToStoryOriginArrA;
        e = G92.a(postToStoryOriginArrA);
        CREATOR = new Parcelable.Creator() { // from class: ir.nasim.data.model.story.PostToStoryOrigin.a
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PostToStoryOrigin createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return PostToStoryOrigin.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PostToStoryOrigin[] newArray(int i) {
                return new PostToStoryOrigin[i];
            }
        };
    }

    private PostToStoryOrigin(String str, int i, int i2) {
        this.index = i2;
    }

    private static final /* synthetic */ PostToStoryOrigin[] a() {
        return new PostToStoryOrigin[]{b, c};
    }

    public static PostToStoryOrigin valueOf(String str) {
        return (PostToStoryOrigin) Enum.valueOf(PostToStoryOrigin.class, str);
    }

    public static PostToStoryOrigin[] values() {
        return (PostToStoryOrigin[]) d.clone();
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
