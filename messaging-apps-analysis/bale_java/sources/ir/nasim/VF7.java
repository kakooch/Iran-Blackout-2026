package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.UsersOuterClass$UpdateUserContactsChanged;
import com.google.protobuf.StringValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class VF7 implements InterfaceC14123hO3 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17082mM7.values().length];
            try {
                iArr[EnumC17082mM7.ContactType_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17082mM7.ContactType_EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC17082mM7.ContactType_WEB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC17082mM7.ContactType_SOCIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC17082mM7.UNRECOGNIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    private final EnumC14458hx b(InterfaceC16491lM7 interfaceC16491lM7) {
        EnumC17082mM7 type = interfaceC16491lM7.getType();
        int i = type == null ? -1 : a.a[type.ordinal()];
        if (i == 1) {
            return EnumC14458hx.PHONE;
        }
        if (i == 2) {
            return EnumC14458hx.EMAIL;
        }
        if (i == 3) {
            return EnumC14458hx.WEB;
        }
        if (i == 4) {
            return EnumC14458hx.SOCIAL;
        }
        if (i == 5) {
            return EnumC14458hx.UNSUPPORTED_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UF7 a(UsersOuterClass$UpdateUserContactsChanged usersOuterClass$UpdateUserContactsChanged) {
        AbstractC13042fc3.i(usersOuterClass$UpdateUserContactsChanged, "input");
        int uid = usersOuterClass$UpdateUserContactsChanged.getUid();
        List<? extends InterfaceC16491lM7> contactRecordsOrBuilderList = usersOuterClass$UpdateUserContactsChanged.getContactRecordsOrBuilderList();
        AbstractC13042fc3.h(contactRecordsOrBuilderList, "getContactRecordsOrBuilderList(...)");
        ArrayList arrayList = new ArrayList();
        for (InterfaceC16491lM7 interfaceC16491lM7 : contactRecordsOrBuilderList) {
            AbstractC13042fc3.f(interfaceC16491lM7);
            EnumC14458hx enumC14458hxB = b(interfaceC16491lM7);
            StringValue stringValue = interfaceC16491lM7.getStringValue();
            String value = stringValue != null ? stringValue.getValue() : null;
            CollectionsStruct$Int64Value longValue = interfaceC16491lM7.getLongValue();
            Long lValueOf = longValue != null ? Long.valueOf(longValue.getValue()) : null;
            StringValue title = interfaceC16491lM7.getTitle();
            String value2 = title != null ? title.getValue() : null;
            StringValue subtitle = interfaceC16491lM7.getSubtitle();
            String value3 = subtitle != null ? subtitle.getValue() : null;
            StringValue typeSpec = interfaceC16491lM7.getTypeSpec();
            arrayList.add(new C13865gx(enumC14458hxB, value, lValueOf, value2, value3, typeSpec != null ? typeSpec.getValue() : null));
        }
        return new UF7(uid, arrayList);
    }
}
