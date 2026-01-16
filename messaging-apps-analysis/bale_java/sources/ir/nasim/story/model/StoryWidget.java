package ir.nasim.story.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.C9475a16;
import ir.nasim.ED1;
import ir.nasim.XV4;
import ir.nasim.database.model.story.WidgetCoordinate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\t\n\u000bJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0003\u0003\u0006\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lir/nasim/story/model/StoryWidget;", "Landroid/os/Parcelable;", "", "Lir/nasim/story/model/StoryWidget$LinkWidget;", "f0", "(Ljava/util/List;)Lir/nasim/story/model/StoryWidget$LinkWidget;", "Lir/nasim/story/model/StoryWidget$PostWidget;", "k0", "(Ljava/util/List;)Lir/nasim/story/model/StoryWidget$PostWidget;", "PostWidget", "LinkWidget", "Unknown", "Lir/nasim/story/model/StoryWidget$Unknown;", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public interface StoryWidget extends Parcelable {

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\u00052\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00052\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ%\u0010\u0010\u001a\u00020\u00052\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\nH×\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH×\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u001aR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lir/nasim/story/model/StoryWidget$PostWidget;", "Lir/nasim/story/model/StoryWidget;", "", "link", "", "Lir/nasim/database/model/story/WidgetCoordinate;", "widgetCoordinates", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lir/nasim/XV4;", "", "Lir/nasim/story/model/Scale;", "scale", "b", "(Lir/nasim/XV4;)Lir/nasim/database/model/story/WidgetCoordinate;", "d", "a", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "Ljava/util/List;", "e", "()Ljava/util/List;", "story_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class PostWidget implements StoryWidget {
        public static final Parcelable.Creator<PostWidget> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final String link;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final List widgetCoordinates;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PostWidget createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                String string = parcel.readString();
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(PostWidget.class.getClassLoader()));
                }
                return new PostWidget(string, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PostWidget[] newArray(int i) {
                return new PostWidget[i];
            }
        }

        public PostWidget(String str, List list) {
            AbstractC13042fc3.i(str, "link");
            AbstractC13042fc3.i(list, "widgetCoordinates");
            this.link = str;
            this.widgetCoordinates = list;
        }

        public final WidgetCoordinate a(XV4 scale) {
            Object objB;
            Iterator it;
            AbstractC13042fc3.i(scale, "scale");
            try {
                C9475a16.a aVar = C9475a16.b;
                it = getWidgetCoordinates().iterator();
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                float x = ((WidgetCoordinate) next).getX();
                do {
                    Object next2 = it.next();
                    float x2 = ((WidgetCoordinate) next2).getX();
                    if (Float.compare(x, x2) < 0) {
                        next = next2;
                        x = x2;
                    }
                } while (it.hasNext());
            }
            float x3 = ((WidgetCoordinate) next).getX() * ((Number) scale.e()).floatValue();
            Iterator it2 = getWidgetCoordinates().iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next3 = it2.next();
            if (it2.hasNext()) {
                float y = ((WidgetCoordinate) next3).getY();
                do {
                    Object next4 = it2.next();
                    float y2 = ((WidgetCoordinate) next4).getY();
                    if (Float.compare(y, y2) < 0) {
                        next3 = next4;
                        y = y2;
                    }
                } while (it2.hasNext());
            }
            objB = C9475a16.b(new WidgetCoordinate(x3, ((WidgetCoordinate) next3).getY() * ((Number) scale.f()).floatValue()));
            WidgetCoordinate widgetCoordinate = new WidgetCoordinate(0.0f, 0.0f);
            if (C9475a16.g(objB)) {
                objB = widgetCoordinate;
            }
            return (WidgetCoordinate) objB;
        }

        public final WidgetCoordinate b(XV4 scale) {
            AbstractC13042fc3.i(scale, "scale");
            try {
                C9475a16.a aVar = C9475a16.b;
                WidgetCoordinate widgetCoordinateD = d(scale);
                WidgetCoordinate widgetCoordinateA = a(scale);
                float f = 2;
                return new WidgetCoordinate((widgetCoordinateD.getX() + widgetCoordinateA.getX()) / f, (widgetCoordinateD.getY() + widgetCoordinateA.getY()) / f);
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                Object objB = C9475a16.b(AbstractC10685c16.a(th));
                WidgetCoordinate widgetCoordinate = new WidgetCoordinate(0.0f, 0.0f);
                if (C9475a16.g(objB)) {
                    objB = widgetCoordinate;
                }
                return (WidgetCoordinate) objB;
            }
        }

        /* renamed from: c, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        public final WidgetCoordinate d(XV4 scale) {
            Object objB;
            Iterator it;
            AbstractC13042fc3.i(scale, "scale");
            try {
                C9475a16.a aVar = C9475a16.b;
                it = getWidgetCoordinates().iterator();
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                float x = ((WidgetCoordinate) next).getX();
                do {
                    Object next2 = it.next();
                    float x2 = ((WidgetCoordinate) next2).getX();
                    if (Float.compare(x, x2) > 0) {
                        next = next2;
                        x = x2;
                    }
                } while (it.hasNext());
            }
            float x3 = ((WidgetCoordinate) next).getX() * ((Number) scale.e()).floatValue();
            Iterator it2 = getWidgetCoordinates().iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next3 = it2.next();
            if (it2.hasNext()) {
                float y = ((WidgetCoordinate) next3).getY();
                do {
                    Object next4 = it2.next();
                    float y2 = ((WidgetCoordinate) next4).getY();
                    if (Float.compare(y, y2) > 0) {
                        next3 = next4;
                        y = y2;
                    }
                } while (it2.hasNext());
            }
            objB = C9475a16.b(new WidgetCoordinate(x3, ((WidgetCoordinate) next3).getY() * ((Number) scale.f()).floatValue()));
            WidgetCoordinate widgetCoordinate = new WidgetCoordinate(0.0f, 0.0f);
            if (C9475a16.g(objB)) {
                objB = widgetCoordinate;
            }
            return (WidgetCoordinate) objB;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public List getWidgetCoordinates() {
            return this.widgetCoordinates;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PostWidget)) {
                return false;
            }
            PostWidget postWidget = (PostWidget) other;
            return AbstractC13042fc3.d(this.link, postWidget.link) && AbstractC13042fc3.d(this.widgetCoordinates, postWidget.widgetCoordinates);
        }

        public int hashCode() {
            return (this.link.hashCode() * 31) + this.widgetCoordinates.hashCode();
        }

        public String toString() {
            return "PostWidget(link=" + this.link + ", widgetCoordinates=" + this.widgetCoordinates + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.link);
            List list = this.widgetCoordinates;
            dest.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable((Parcelable) it.next(), flags);
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015R&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lir/nasim/story/model/StoryWidget$Unknown;", "Lir/nasim/story/model/StoryWidget;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lir/nasim/database/model/story/WidgetCoordinate;", "b", "Ljava/util/List;", "getWidgetCoordinates", "()Ljava/util/List;", "getWidgetCoordinates$annotations", "widgetCoordinates", "story_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Unknown implements StoryWidget {
        public static final Unknown a = new Unknown();

        /* renamed from: b, reason: from kotlin metadata */
        private static final List widgetCoordinates = AbstractC10360bX0.m();
        public static final int c = 8;
        public static final Parcelable.Creator<Unknown> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Unknown createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return Unknown.a;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Unknown[] newArray(int i) {
                return new Unknown[i];
            }
        }

        private Unknown() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Unknown);
        }

        public int hashCode() {
            return 239995912;
        }

        public String toString() {
            return "Unknown";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    default LinkWidget f0(List list) {
        Object next;
        AbstractC13042fc3.i(list, "<this>");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((StoryWidget) next) instanceof LinkWidget) {
                break;
            }
        }
        if (next instanceof LinkWidget) {
            return (LinkWidget) next;
        }
        return null;
    }

    default PostWidget k0(List list) {
        Object next;
        AbstractC13042fc3.i(list, "<this>");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((StoryWidget) next) instanceof PostWidget) {
                break;
            }
        }
        if (next instanceof PostWidget) {
            return (PostWidget) next;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0011\u0010!\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014¨\u0006\""}, d2 = {"Lir/nasim/story/model/StoryWidget$LinkWidget;", "Lir/nasim/story/model/StoryWidget;", "", "_link", "title", "", "Lir/nasim/database/model/story/WidgetCoordinate;", "widgetCoordinates", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "c", "Ljava/util/List;", "()Ljava/util/List;", "link", "story_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class LinkWidget implements StoryWidget {
        public static final Parcelable.Creator<LinkWidget> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final String _link;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final String title;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final List widgetCoordinates;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final LinkWidget createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                String string = parcel.readString();
                String string2 = parcel.readString();
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(LinkWidget.class.getClassLoader()));
                }
                return new LinkWidget(string, string2, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final LinkWidget[] newArray(int i) {
                return new LinkWidget[i];
            }
        }

        public LinkWidget(String str, String str2, List list) {
            AbstractC13042fc3.i(str, "_link");
            AbstractC13042fc3.i(str2, "title");
            AbstractC13042fc3.i(list, "widgetCoordinates");
            this._link = str;
            this.title = str2;
            this.widgetCoordinates = list;
        }

        public final String a() {
            if (AbstractC20153rZ6.S(this._link, "http", false, 2, null)) {
                return this._link;
            }
            return "https://" + this._link;
        }

        /* renamed from: b, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: c, reason: from getter */
        public List getWidgetCoordinates() {
            return this.widgetCoordinates;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkWidget)) {
                return false;
            }
            LinkWidget linkWidget = (LinkWidget) other;
            return AbstractC13042fc3.d(this._link, linkWidget._link) && AbstractC13042fc3.d(this.title, linkWidget.title) && AbstractC13042fc3.d(this.widgetCoordinates, linkWidget.widgetCoordinates);
        }

        public int hashCode() {
            return (((this._link.hashCode() * 31) + this.title.hashCode()) * 31) + this.widgetCoordinates.hashCode();
        }

        public String toString() {
            return "LinkWidget(_link=" + this._link + ", title=" + this.title + ", widgetCoordinates=" + this.widgetCoordinates + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this._link);
            dest.writeString(this.title);
            List list = this.widgetCoordinates;
            dest.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable((Parcelable) it.next(), flags);
            }
        }

        public /* synthetic */ LinkWidget(String str, String str2, List list, int i, ED1 ed1) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? AbstractC10360bX0.m() : list);
        }
    }
}
