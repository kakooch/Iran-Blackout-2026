package ir.nasim.contact.data;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lir/nasim/contact/data/ContactItem;", "Landroid/os/Parcelable;", "BaleContactItem", "PhoneBookContactItem", "SeparatorTitleItem", "InvitationCard", "PermissionCard", "InvitationViaLink", "MxpPuppetContactItem", "Lir/nasim/contact/data/ContactItem$BaleContactItem;", "Lir/nasim/contact/data/ContactItem$InvitationCard;", "Lir/nasim/contact/data/ContactItem$InvitationViaLink;", "Lir/nasim/contact/data/ContactItem$MxpPuppetContactItem;", "Lir/nasim/contact/data/ContactItem$PermissionCard;", "Lir/nasim/contact/data/ContactItem$PhoneBookContactItem;", "Lir/nasim/contact/data/ContactItem$SeparatorTitleItem;", "contact_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ContactItem extends Parcelable {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÇ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0018\u0010\u0013J\u001a\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H×\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b#\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lir/nasim/contact/data/ContactItem$BaleContactItem;", "Lir/nasim/contact/data/ContactItem;", "", "id", "", "name", "Lir/nasim/contact/data/ContactItem$BaleContactItem$b;", "image", "", ContactEntity.COLUMN_IS_BOT, "<init>", "(ILjava/lang/String;Lir/nasim/contact/data/ContactItem$BaleContactItem$b;Z)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "a", "(ILjava/lang/String;Lir/nasim/contact/data/ContactItem$BaleContactItem$b;Z)Lir/nasim/contact/data/ContactItem$BaleContactItem;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "c", "b", "Ljava/lang/String;", "e", "Lir/nasim/contact/data/ContactItem$BaleContactItem$b;", "d", "()Lir/nasim/contact/data/ContactItem$BaleContactItem$b;", "Z", "f", "()Z", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class BaleContactItem implements ContactItem {
        public static final Parcelable.Creator<BaleContactItem> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final String name;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final b image;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        private final boolean isBot;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final BaleContactItem createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new BaleContactItem(parcel.readInt(), parcel.readString(), (b) parcel.readValue(BaleContactItem.class.getClassLoader()), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final BaleContactItem[] newArray(int i) {
                return new BaleContactItem[i];
            }
        }

        public static abstract class b {

            public static final class a extends b {
                private final Avatar a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(Avatar avatar) {
                    super(null);
                    AbstractC13042fc3.i(avatar, "avatar");
                    this.a = avatar;
                }

                public final Avatar a() {
                    return this.a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
                }

                public int hashCode() {
                    return this.a.hashCode();
                }

                public String toString() {
                    return "AvatarImage(avatar=" + this.a + Separators.RPAREN;
                }
            }

            /* renamed from: ir.nasim.contact.data.ContactItem$BaleContactItem$b$b, reason: collision with other inner class name */
            public static final class C0986b extends b {
                private final int a;

                public C0986b(int i) {
                    super(null);
                    this.a = i;
                }

                public final int a() {
                    return this.a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C0986b) && this.a == ((C0986b) obj).a;
                }

                public int hashCode() {
                    return Integer.hashCode(this.a);
                }

                public String toString() {
                    return "ResourceImage(resourceId=" + this.a + Separators.RPAREN;
                }
            }

            private b() {
            }

            public /* synthetic */ b(ED1 ed1) {
                this();
            }
        }

        public BaleContactItem(int i, String str, b bVar, boolean z) {
            AbstractC13042fc3.i(str, "name");
            this.id = i;
            this.name = str;
            this.image = bVar;
            this.isBot = z;
        }

        public static /* synthetic */ BaleContactItem b(BaleContactItem baleContactItem, int i, String str, b bVar, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = baleContactItem.id;
            }
            if ((i2 & 2) != 0) {
                str = baleContactItem.name;
            }
            if ((i2 & 4) != 0) {
                bVar = baleContactItem.image;
            }
            if ((i2 & 8) != 0) {
                z = baleContactItem.isBot;
            }
            return baleContactItem.a(i, str, bVar, z);
        }

        public final BaleContactItem a(int id, String name, b image, boolean isBot) {
            AbstractC13042fc3.i(name, "name");
            return new BaleContactItem(id, name, image, isBot);
        }

        /* renamed from: c, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: d, reason: from getter */
        public final b getImage() {
            return this.image;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BaleContactItem)) {
                return false;
            }
            BaleContactItem baleContactItem = (BaleContactItem) other;
            return this.id == baleContactItem.id && AbstractC13042fc3.d(this.name, baleContactItem.name) && AbstractC13042fc3.d(this.image, baleContactItem.image) && this.isBot == baleContactItem.isBot;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsBot() {
            return this.isBot;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
            b bVar = this.image;
            return ((iHashCode + (bVar == null ? 0 : bVar.hashCode())) * 31) + Boolean.hashCode(this.isBot);
        }

        public String toString() {
            return "BaleContactItem(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", isBot=" + this.isBot + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeValue(this.image);
            dest.writeInt(this.isBot ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/contact/data/ContactItem$InvitationCard;", "Lir/nasim/contact/data/ContactItem;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class InvitationCard implements ContactItem {
        public static final InvitationCard a = new InvitationCard();
        public static final Parcelable.Creator<InvitationCard> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InvitationCard createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return InvitationCard.a;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InvitationCard[] newArray(int i) {
                return new InvitationCard[i];
            }
        }

        private InvitationCard() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof InvitationCard);
        }

        public int hashCode() {
            return 773339083;
        }

        public String toString() {
            return "InvitationCard";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/contact/data/ContactItem$InvitationViaLink;", "Lir/nasim/contact/data/ContactItem;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class InvitationViaLink implements ContactItem {
        public static final InvitationViaLink a = new InvitationViaLink();
        public static final Parcelable.Creator<InvitationViaLink> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InvitationViaLink createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return InvitationViaLink.a;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InvitationViaLink[] newArray(int i) {
                return new InvitationViaLink[i];
            }
        }

        private InvitationViaLink() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof InvitationViaLink);
        }

        public int hashCode() {
            return 235469453;
        }

        public String toString() {
            return "InvitationViaLink";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e¨\u0006\u001f"}, d2 = {"Lir/nasim/contact/data/ContactItem$MxpPuppetContactItem;", "Lir/nasim/contact/data/ContactItem;", "", "name", "", "Lir/nasim/features/mxp/entity/PuppetUser;", "puppets", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "Ljava/util/List;", "()Ljava/util/List;", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class MxpPuppetContactItem implements ContactItem {
        public static final Parcelable.Creator<MxpPuppetContactItem> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final String name;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final List puppets;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MxpPuppetContactItem createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                String string = parcel.readString();
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(MxpPuppetContactItem.class.getClassLoader()));
                }
                return new MxpPuppetContactItem(string, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MxpPuppetContactItem[] newArray(int i) {
                return new MxpPuppetContactItem[i];
            }
        }

        public MxpPuppetContactItem(String str, List list) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(list, "puppets");
            this.name = str;
            this.puppets = list;
        }

        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final List getPuppets() {
            return this.puppets;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MxpPuppetContactItem)) {
                return false;
            }
            MxpPuppetContactItem mxpPuppetContactItem = (MxpPuppetContactItem) other;
            return AbstractC13042fc3.d(this.name, mxpPuppetContactItem.name) && AbstractC13042fc3.d(this.puppets, mxpPuppetContactItem.puppets);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.puppets.hashCode();
        }

        public String toString() {
            return "MxpPuppetContactItem(name=" + this.name + ", puppets=" + this.puppets + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.name);
            List list = this.puppets;
            dest.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable((Parcelable) it.next(), flags);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0010\u0010\fJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H×\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lir/nasim/contact/data/ContactItem$PermissionCard;", "Lir/nasim/contact/data/ContactItem;", "<init>", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class PermissionCard implements ContactItem {
        public static final PermissionCard a = new PermissionCard();
        public static final Parcelable.Creator<PermissionCard> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PermissionCard createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                parcel.readInt();
                return PermissionCard.a;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PermissionCard[] newArray(int i) {
                return new PermissionCard[i];
            }
        }

        private PermissionCard() {
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof PermissionCard);
        }

        public int hashCode() {
            return -1289716991;
        }

        public String toString() {
            return "PermissionCard";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH×\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0013¨\u0006 "}, d2 = {"Lir/nasim/contact/data/ContactItem$PhoneBookContactItem;", "Lir/nasim/contact/data/ContactItem;", "", "id", "", "name", "phoneNumber", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "()J", "b", "Ljava/lang/String;", "c", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class PhoneBookContactItem implements ContactItem {
        public static final Parcelable.Creator<PhoneBookContactItem> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final long id;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final String name;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final String phoneNumber;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PhoneBookContactItem createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new PhoneBookContactItem(parcel.readLong(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PhoneBookContactItem[] newArray(int i) {
                return new PhoneBookContactItem[i];
            }
        }

        public PhoneBookContactItem(long j, String str, String str2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "phoneNumber");
            this.id = j;
            this.name = str;
            this.phoneNumber = str2;
        }

        /* renamed from: a, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: c, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PhoneBookContactItem)) {
                return false;
            }
            PhoneBookContactItem phoneBookContactItem = (PhoneBookContactItem) other;
            return this.id == phoneBookContactItem.id && AbstractC13042fc3.d(this.name, phoneBookContactItem.name) && AbstractC13042fc3.d(this.phoneNumber, phoneBookContactItem.phoneNumber);
        }

        public int hashCode() {
            return (((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + this.phoneNumber.hashCode();
        }

        public String toString() {
            return "PhoneBookContactItem(id=" + this.id + ", name=" + this.name + ", phoneNumber=" + this.phoneNumber + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeLong(this.id);
            dest.writeString(this.name);
            dest.writeString(this.phoneNumber);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H×\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c¨\u0006\u001d"}, d2 = {"Lir/nasim/contact/data/ContactItem$SeparatorTitleItem;", "Lir/nasim/contact/data/ContactItem;", "", "textResourceId", "iconResourceId", "<init>", "(ILjava/lang/Integer;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", TokenNames.I, "b", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "contact_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class SeparatorTitleItem implements ContactItem {
        public static final Parcelable.Creator<SeparatorTitleItem> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final int textResourceId;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final Integer iconResourceId;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SeparatorTitleItem createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new SeparatorTitleItem(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SeparatorTitleItem[] newArray(int i) {
                return new SeparatorTitleItem[i];
            }
        }

        public SeparatorTitleItem(int i, Integer num) {
            this.textResourceId = i;
            this.iconResourceId = num;
        }

        /* renamed from: a, reason: from getter */
        public final Integer getIconResourceId() {
            return this.iconResourceId;
        }

        /* renamed from: b, reason: from getter */
        public final int getTextResourceId() {
            return this.textResourceId;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeparatorTitleItem)) {
                return false;
            }
            SeparatorTitleItem separatorTitleItem = (SeparatorTitleItem) other;
            return this.textResourceId == separatorTitleItem.textResourceId && AbstractC13042fc3.d(this.iconResourceId, separatorTitleItem.iconResourceId);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.textResourceId) * 31;
            Integer num = this.iconResourceId;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "SeparatorTitleItem(textResourceId=" + this.textResourceId + ", iconResourceId=" + this.iconResourceId + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            int iIntValue;
            AbstractC13042fc3.i(dest, "dest");
            dest.writeInt(this.textResourceId);
            Integer num = this.iconResourceId;
            if (num == null) {
                iIntValue = 0;
            } else {
                dest.writeInt(1);
                iIntValue = num.intValue();
            }
            dest.writeInt(iIntValue);
        }

        public /* synthetic */ SeparatorTitleItem(int i, Integer num, int i2, ED1 ed1) {
            this(i, (i2 & 2) != 0 ? null : num);
        }
    }
}
