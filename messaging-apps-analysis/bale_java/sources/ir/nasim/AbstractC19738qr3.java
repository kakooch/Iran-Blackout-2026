package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.gov.nist.core.Separators;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC15427ja;
import ir.nasim.InterfaceC8256Ve5;
import ir.nasim.PJ6;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.qr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19738qr3 {
    public static final C6432No4 f = C6432No4.s("<built-ins module>");
    private C8773Xg4 a;
    private final InterfaceC23016wC4 b;
    private final InterfaceC23016wC4 c;
    private final I34 d;
    private final ON6 e;

    /* renamed from: ir.nasim.qr3$a */
    class a implements SA2 {
        a() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection invoke() {
            return Arrays.asList(AbstractC19738qr3.this.a.z0(PJ6.m), AbstractC19738qr3.this.a.z0(PJ6.o), AbstractC19738qr3.this.a.z0(PJ6.p), AbstractC19738qr3.this.a.z0(PJ6.n));
        }
    }

    /* renamed from: ir.nasim.qr3$b */
    class b implements SA2 {
        b() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(EnumC4809Gq5.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (EnumC4809Gq5 enumC4809Gq5 : EnumC4809Gq5.valuesCustom()) {
                XC6 xc6Q = AbstractC19738qr3.this.q(enumC4809Gq5.q().h());
                XC6 xc6Q2 = AbstractC19738qr3.this.q(enumC4809Gq5.j().h());
                enumMap.put((EnumMap) enumC4809Gq5, (EnumC4809Gq5) xc6Q2);
                map.put(xc6Q, xc6Q2);
                map2.put(xc6Q2, xc6Q);
            }
            return new e(enumMap, map, map2, null);
        }
    }

    /* renamed from: ir.nasim.qr3$c */
    class c implements UA2 {
        c() {
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC21331tU0 invoke(C6432No4 c6432No4) {
            MU0 mu0E = AbstractC19738qr3.this.s().e(c6432No4, FA4.FROM_BUILTINS);
            if (mu0E == null) {
                throw new AssertionError("Built-in class " + PJ6.m.c(c6432No4) + " is not found");
            }
            if (mu0E instanceof InterfaceC21331tU0) {
                return (InterfaceC21331tU0) mu0E;
            }
            throw new AssertionError("Must be a class descriptor " + c6432No4 + ", but was " + mu0E);
        }
    }

    /* renamed from: ir.nasim.qr3$d */
    class d implements SA2 {
        final /* synthetic */ C8773Xg4 a;

        d(C8773Xg4 c8773Xg4) {
            this.a = c8773Xg4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (AbstractC19738qr3.this.a == null) {
                AbstractC19738qr3.this.a = this.a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + AbstractC19738qr3.this.a + " (attempting to reset to " + this.a + Separators.RPAREN);
        }
    }

    /* renamed from: ir.nasim.qr3$e */
    private static class e {
        public final Map a;
        public final Map b;
        public final Map c;

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(Map map, Map map2, Map map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.a = map;
            this.b = map2;
            this.c = map3;
        }
    }

    protected AbstractC19738qr3(ON6 on6) {
        if (on6 == null) {
            a(0);
        }
        this.e = on6;
        this.c = on6.c(new a());
        this.b = on6.c(new b());
        this.d = on6.e(new c());
    }

    private static AbstractC4099Dr3 A(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC8507Wg4 interfaceC8507Wg4) {
        C24948zU0 c24948zU0H;
        C24948zU0 c24948zU0A;
        InterfaceC21331tU0 interfaceC21331tU0A;
        if (abstractC4099Dr3 == null) {
            a(70);
        }
        if (interfaceC8507Wg4 == null) {
            a(71);
        }
        MU0 mu0D = abstractC4099Dr3.K0().d();
        if (mu0D == null) {
            return null;
        }
        C9584aC7 c9584aC7 = C9584aC7.a;
        if (!c9584aC7.b(mu0D.getName()) || (c24948zU0H = PI1.h(mu0D)) == null || (c24948zU0A = c9584aC7.a(c24948zU0H)) == null || (interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4, c24948zU0A)) == null) {
            return null;
        }
        return interfaceC21331tU0A.p();
    }

    public static boolean A0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(119);
        }
        return i0(abstractC4099Dr3, PJ6.a.m);
    }

    public static boolean B0(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(Type.L64);
        }
        return e(interfaceC21331tU0, PJ6.a.b) || e(interfaceC21331tU0, PJ6.a.c);
    }

    public static boolean C0(AbstractC4099Dr3 abstractC4099Dr3) {
        return abstractC4099Dr3 != null && s0(abstractC4099Dr3, PJ6.a.h);
    }

    public static boolean D0(InterfaceC13882gy7 interfaceC13882gy7, C10027ax2 c10027ax2) {
        if (interfaceC13882gy7 == null) {
            a(100);
        }
        if (c10027ax2 == null) {
            a(101);
        }
        MU0 mu0D = interfaceC13882gy7.d();
        return (mu0D instanceof InterfaceC21331tU0) && e(mu0D, c10027ax2);
    }

    public static boolean E0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(127);
        }
        return i0(abstractC4099Dr3, PJ6.a.x0.j());
    }

    public static boolean F0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(129);
        }
        return i0(abstractC4099Dr3, PJ6.a.z0.j());
    }

    public static boolean G0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(130);
        }
        return i0(abstractC4099Dr3, PJ6.a.A0.j());
    }

    public static boolean H0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(128);
        }
        return i0(abstractC4099Dr3, PJ6.a.y0.j());
    }

    public static boolean I0(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(9);
        }
        while (interfaceC12795fB1 != null) {
            if (interfaceC12795fB1 instanceof InterfaceC24340yS4) {
                return ((InterfaceC24340yS4) interfaceC12795fB1).e().i(PJ6.l);
            }
            interfaceC12795fB1 = interfaceC12795fB1.b();
        }
        return false;
    }

    public static boolean J0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.EMFIS_CNTL);
        }
        return s0(abstractC4099Dr3, PJ6.a.f);
    }

    public static boolean K0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(131);
        }
        return E0(abstractC4099Dr3) || H0(abstractC4099Dr3) || F0(abstractC4099Dr3) || G0(abstractC4099Dr3);
    }

    public static EnumC4809Gq5 O(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(76);
        }
        if (PJ6.a.C0.contains(interfaceC12795fB1.getName())) {
            return (EnumC4809Gq5) PJ6.a.E0.get(OI1.m(interfaceC12795fB1));
        }
        return null;
    }

    private InterfaceC21331tU0 P(EnumC4809Gq5 enumC4809Gq5) {
        if (enumC4809Gq5 == null) {
            a(15);
        }
        return p(enumC4809Gq5.q().h());
    }

    public static EnumC4809Gq5 R(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(75);
        }
        if (PJ6.a.B0.contains(interfaceC12795fB1.getName())) {
            return (EnumC4809Gq5) PJ6.a.D0.get(OI1.m(interfaceC12795fB1));
        }
        return null;
    }

    public static boolean Z(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(107);
        }
        return e(interfaceC21331tU0, PJ6.a.b);
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
            case 73:
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case Type.TLSA /* 52 */:
            case WKSRecord.Protocol.RVD /* 66 */:
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
            case 71:
            case 72:
            case 74:
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
            case 77:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
            case 73:
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
            case 85:
            case 86:
                i2 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case Type.TLSA /* 52 */:
            case WKSRecord.Protocol.RVD /* 66 */:
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
            case 71:
            case 72:
            case 74:
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
            case 77:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
            case 73:
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
            case 95:
            case 102:
            case Type.L64 /* 106 */:
            case 107:
            case SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER /* 144 */:
            case SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER /* 145 */:
            case 147:
            case 155:
            case 156:
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER /* 157 */:
                objArr[0] = "descriptor";
                break;
            case 11:
            case WKSRecord.Service.SWIFT_RVF /* 97 */:
            case 99:
            case 101:
            case 103:
            case 105:
            case 134:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case Type.TLSA /* 52 */:
            case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
            case 89:
            case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case Type.EUI48 /* 108 */:
            case 109:
            case 110:
            case SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER /* 112 */:
            case 113:
            case 114:
            case 115:
            case 116:
            case WKSRecord.Service.UUCP_PATH /* 117 */:
            case SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER /* 118 */:
            case 119:
            case SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 120 */:
            case WKSRecord.Service.ERPC /* 121 */:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case WKSRecord.Service.CISCO_SYS /* 132 */:
            case WKSRecord.Service.STATSRV /* 133 */:
            case 135:
            case 136:
            case 137:
            case WKSRecord.Service.NETBIOS_DGM /* 138 */:
            case WKSRecord.Service.NETBIOS_SSN /* 139 */:
            case WKSRecord.Service.EMFIS_DATA /* 140 */:
            case WKSRecord.Service.EMFIS_CNTL /* 141 */:
            case WKSRecord.Service.BL_IDM /* 142 */:
            case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER /* 143 */:
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER /* 146 */:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER /* 153 */:
            case 154:
            case 159:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                objArr[0] = "arrayType";
                break;
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case WKSRecord.Service.SUNRPC /* 111 */:
                objArr[0] = "classDescriptor";
                break;
            case 158:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case Type.TLSA /* 52 */:
            case WKSRecord.Protocol.RVD /* 66 */:
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
            case 71:
            case 72:
            case 74:
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
            case 77:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case Type.NINFO /* 56 */:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
            case 73:
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case Type.TLSA /* 52 */:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                objArr[2] = "getArrayElementType";
                break;
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
                objArr[2] = "getArrayType";
                break;
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
                objArr[2] = "getEnumType";
                break;
            case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
                objArr[2] = "isArray";
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case WKSRecord.Service.SWIFT_RVF /* 97 */:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case Type.L64 /* 106 */:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case Type.EUI48 /* 108 */:
                objArr[2] = "isAny";
                break;
            case 109:
            case WKSRecord.Service.SUNRPC /* 111 */:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER /* 112 */:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case WKSRecord.Service.UUCP_PATH /* 117 */:
                objArr[2] = "isLong";
                break;
            case SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER /* 118 */:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER /* 120 */:
                objArr[2] = "isFloat";
                break;
            case WKSRecord.Service.ERPC /* 121 */:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case 125:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case 127:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case 129:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case 131:
                objArr[2] = "isUnsignedArrayType";
                break;
            case WKSRecord.Service.CISCO_SYS /* 132 */:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case WKSRecord.Service.STATSRV /* 133 */:
            case 134:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 135:
                objArr[2] = "isNothing";
                break;
            case 136:
                objArr[2] = "isNullableNothing";
                break;
            case 137:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case WKSRecord.Service.NETBIOS_DGM /* 138 */:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case WKSRecord.Service.NETBIOS_SSN /* 139 */:
                objArr[2] = "isNullableAny";
                break;
            case WKSRecord.Service.EMFIS_DATA /* 140 */:
                objArr[2] = "isDefaultBound";
                break;
            case WKSRecord.Service.EMFIS_CNTL /* 141 */:
                objArr[2] = "isUnit";
                break;
            case WKSRecord.Service.BL_IDM /* 142 */:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER /* 143 */:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER /* 144 */:
                objArr[2] = "isMemberOfAny";
                break;
            case SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER /* 145 */:
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER /* 146 */:
                objArr[2] = "isEnum";
                break;
            case 147:
            case 148:
                objArr[2] = "isComparable";
                break;
            case 149:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 150:
                objArr[2] = "isListOrNullableList";
                break;
            case 151:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 152:
                objArr[2] = "isMapOrNullableMap";
                break;
            case SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER /* 153 */:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 154:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 155:
                objArr[2] = "isKClass";
                break;
            case 156:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER /* 157 */:
                objArr[2] = "isCloneable";
                break;
            case 158:
                objArr[2] = "isDeprecated";
                break;
            case 159:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
            case 73:
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
            case 85:
            case 86:
                throw new IllegalStateException(str2);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case Type.TLSA /* 52 */:
            case WKSRecord.Protocol.RVD /* 66 */:
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
            case 71:
            case 72:
            case 74:
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
            case 77:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean a0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.NETBIOS_DGM);
        }
        return h0(abstractC4099Dr3, PJ6.a.b);
    }

    public static boolean b0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(87);
        }
        return h0(abstractC4099Dr3, PJ6.a.i);
    }

    public static boolean c0(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(88);
        }
        return e(interfaceC21331tU0, PJ6.a.i) || O(interfaceC21331tU0) != null;
    }

    public static boolean d0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(109);
        }
        return i0(abstractC4099Dr3, PJ6.a.j);
    }

    private static boolean e(MU0 mu0, C10027ax2 c10027ax2) {
        if (mu0 == null) {
            a(102);
        }
        if (c10027ax2 == null) {
            a(103);
        }
        return mu0.getName().equals(c10027ax2.i()) && c10027ax2.equals(OI1.m(mu0));
    }

    public static boolean e0(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(8);
        }
        return OI1.r(interfaceC12795fB1, InterfaceC14958im0.class, false) != null;
    }

    public static boolean f0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(116);
        }
        return i0(abstractC4099Dr3, PJ6.a.l);
    }

    public static boolean g0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(113);
        }
        return i0(abstractC4099Dr3, PJ6.a.k);
    }

    private static boolean h0(AbstractC4099Dr3 abstractC4099Dr3, C10027ax2 c10027ax2) {
        if (abstractC4099Dr3 == null) {
            a(96);
        }
        if (c10027ax2 == null) {
            a(97);
        }
        return D0(abstractC4099Dr3.K0(), c10027ax2);
    }

    private static boolean i0(AbstractC4099Dr3 abstractC4099Dr3, C10027ax2 c10027ax2) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.STATSRV);
        }
        if (c10027ax2 == null) {
            a(134);
        }
        return h0(abstractC4099Dr3, c10027ax2) && !abstractC4099Dr3.L0();
    }

    public static boolean j0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.EMFIS_DATA);
        }
        return v0(abstractC4099Dr3);
    }

    public static boolean k0(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(158);
        }
        if (interfaceC12795fB1.a().getAnnotations().M1(PJ6.a.y)) {
            return true;
        }
        if (!(interfaceC12795fB1 instanceof InterfaceC20989sw5)) {
            return false;
        }
        InterfaceC20989sw5 interfaceC20989sw5 = (InterfaceC20989sw5) interfaceC12795fB1;
        boolean zP = interfaceC20989sw5.P();
        InterfaceC22266uw5 interfaceC22266uw5G = interfaceC20989sw5.g();
        InterfaceC4146Dw5 interfaceC4146Dw5J = interfaceC20989sw5.J();
        if (interfaceC22266uw5G != null && k0(interfaceC22266uw5G)) {
            if (!zP) {
                return true;
            }
            if (interfaceC4146Dw5J != null && k0(interfaceC4146Dw5J)) {
                return true;
            }
        }
        return false;
    }

    public static boolean l0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(122);
        }
        return m0(abstractC4099Dr3) && !abstractC4099Dr3.L0();
    }

    public static boolean m0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.CISCO_SYS);
        }
        return h0(abstractC4099Dr3, PJ6.a.q);
    }

    public static boolean n0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        }
        return o0(abstractC4099Dr3) && !abstractC4099Dr3.L0();
    }

    public static boolean o0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.ERPC);
        }
        return h0(abstractC4099Dr3, PJ6.a.p);
    }

    private InterfaceC21331tU0 p(String str) {
        if (str == null) {
            a(13);
        }
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) this.d.invoke(C6432No4.p(str));
        if (interfaceC21331tU0 == null) {
            a(14);
        }
        return interfaceC21331tU0;
    }

    public static boolean p0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(115);
        }
        return i0(abstractC4099Dr3, PJ6.a.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public XC6 q(String str) {
        if (str == null) {
            a(45);
        }
        XC6 xc6P = p(str).p();
        if (xc6P == null) {
            a(46);
        }
        return xc6P;
    }

    public static boolean q0(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(155);
        }
        return e(interfaceC21331tU0, PJ6.a.d0);
    }

    public static boolean r0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.UUCP_PATH);
        }
        return i0(abstractC4099Dr3, PJ6.a.o);
    }

    private static boolean s0(AbstractC4099Dr3 abstractC4099Dr3, C10027ax2 c10027ax2) {
        if (abstractC4099Dr3 == null) {
            a(104);
        }
        if (c10027ax2 == null) {
            a(105);
        }
        return !abstractC4099Dr3.L0() && h0(abstractC4099Dr3, c10027ax2);
    }

    public static boolean t0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(135);
        }
        return u0(abstractC4099Dr3) && !AbstractC7497Ry7.l(abstractC4099Dr3);
    }

    public static boolean u0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(137);
        }
        return h0(abstractC4099Dr3, PJ6.a.c);
    }

    public static boolean v0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(WKSRecord.Service.NETBIOS_SSN);
        }
        return a0(abstractC4099Dr3) && abstractC4099Dr3.L0();
    }

    public static boolean w0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(90);
        }
        MU0 mu0D = abstractC4099Dr3.K0().d();
        return (mu0D == null || O(mu0D) == null) ? false : true;
    }

    public static boolean x0(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(95);
        }
        return R(interfaceC21331tU0) != null;
    }

    public static boolean y0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(93);
        }
        return !abstractC4099Dr3.L0() && z0(abstractC4099Dr3);
    }

    public static boolean z0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(94);
        }
        MU0 mu0D = abstractC4099Dr3.K0().d();
        return (mu0D instanceof InterfaceC21331tU0) && x0((InterfaceC21331tU0) mu0D);
    }

    public XC6 B() {
        XC6 xc6Q = Q(EnumC4809Gq5.FLOAT);
        if (xc6Q == null) {
            a(59);
        }
        return xc6Q;
    }

    public InterfaceC21331tU0 C(int i) {
        return p(PJ6.b(i));
    }

    public XC6 D() {
        XC6 xc6Q = Q(EnumC4809Gq5.INT);
        if (xc6Q == null) {
            a(57);
        }
        return xc6Q;
    }

    public InterfaceC21331tU0 E() {
        InterfaceC21331tU0 interfaceC21331tU0O = o(PJ6.a.d0.l());
        if (interfaceC21331tU0O == null) {
            a(20);
        }
        return interfaceC21331tU0O;
    }

    public XC6 F() {
        XC6 xc6Q = Q(EnumC4809Gq5.LONG);
        if (xc6Q == null) {
            a(58);
        }
        return xc6Q;
    }

    public InterfaceC21331tU0 G() {
        return p("Nothing");
    }

    public XC6 H() {
        XC6 xc6P = G().p();
        if (xc6P == null) {
            a(47);
        }
        return xc6P;
    }

    public XC6 I() {
        XC6 xc6R0 = i().O0(true);
        if (xc6R0 == null) {
            a(50);
        }
        return xc6R0;
    }

    public XC6 J() {
        XC6 xc6R0 = H().O0(true);
        if (xc6R0 == null) {
            a(48);
        }
        return xc6R0;
    }

    public InterfaceC21331tU0 K() {
        return p("Number");
    }

    public XC6 L() {
        XC6 xc6P = K().p();
        if (xc6P == null) {
            a(54);
        }
        return xc6P;
    }

    public void L0(C8773Xg4 c8773Xg4) {
        if (c8773Xg4 == null) {
            a(1);
        }
        this.e.i(new d(c8773Xg4));
    }

    protected InterfaceC8256Ve5 M() {
        InterfaceC8256Ve5.b bVar = InterfaceC8256Ve5.b.a;
        if (bVar == null) {
            a(3);
        }
        return bVar;
    }

    public XC6 N(EnumC4809Gq5 enumC4809Gq5) {
        if (enumC4809Gq5 == null) {
            a(72);
        }
        XC6 xc6 = (XC6) ((e) this.b.invoke()).a.get(enumC4809Gq5);
        if (xc6 == null) {
            a(73);
        }
        return xc6;
    }

    public XC6 Q(EnumC4809Gq5 enumC4809Gq5) {
        if (enumC4809Gq5 == null) {
            a(52);
        }
        XC6 xc6P = P(enumC4809Gq5).p();
        if (xc6P == null) {
            a(53);
        }
        return xc6P;
    }

    public XC6 S() {
        XC6 xc6Q = Q(EnumC4809Gq5.SHORT);
        if (xc6Q == null) {
            a(56);
        }
        return xc6Q;
    }

    protected ON6 T() {
        ON6 on6 = this.e;
        if (on6 == null) {
            a(5);
        }
        return on6;
    }

    public InterfaceC21331tU0 U() {
        return p("String");
    }

    public XC6 V() {
        XC6 xc6P = U().p();
        if (xc6P == null) {
            a(64);
        }
        return xc6P;
    }

    public InterfaceC21331tU0 W(int i) {
        InterfaceC21331tU0 interfaceC21331tU0O = o(PJ6.d.c(C6432No4.p(PJ6.d(i))));
        if (interfaceC21331tU0O == null) {
            a(17);
        }
        return interfaceC21331tU0O;
    }

    public InterfaceC21331tU0 X() {
        return p("Unit");
    }

    public XC6 Y() {
        XC6 xc6P = X().p();
        if (xc6P == null) {
            a(63);
        }
        return xc6P;
    }

    protected void f(boolean z) {
        C8773Xg4 c8773Xg4 = new C8773Xg4(f, this.e, this, null);
        this.a = c8773Xg4;
        c8773Xg4.Q0(InterfaceC13757gm0.a.a().a(this.e, this.a, v(), M(), g(), z));
        C8773Xg4 c8773Xg42 = this.a;
        c8773Xg42.W0(c8773Xg42);
    }

    protected InterfaceC15427ja g() {
        InterfaceC15427ja.a aVar = InterfaceC15427ja.a.a;
        if (aVar == null) {
            a(2);
        }
        return aVar;
    }

    public InterfaceC21331tU0 h() {
        return p("Any");
    }

    public XC6 i() {
        XC6 xc6P = h().p();
        if (xc6P == null) {
            a(49);
        }
        return xc6P;
    }

    public InterfaceC21331tU0 j() {
        return p("Array");
    }

    public AbstractC4099Dr3 k(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC4099Dr3 abstractC4099Dr3A;
        if (abstractC4099Dr3 == null) {
            a(66);
        }
        if (b0(abstractC4099Dr3)) {
            if (abstractC4099Dr3.J0().size() != 1) {
                throw new IllegalStateException();
            }
            AbstractC4099Dr3 type = ((InterfaceC3932Cy7) abstractC4099Dr3.J0().get(0)).getType();
            if (type == null) {
                a(67);
            }
            return type;
        }
        AbstractC4099Dr3 abstractC4099Dr3N = AbstractC7497Ry7.n(abstractC4099Dr3);
        AbstractC4099Dr3 abstractC4099Dr32 = (AbstractC4099Dr3) ((e) this.b.invoke()).c.get(abstractC4099Dr3N);
        if (abstractC4099Dr32 != null) {
            return abstractC4099Dr32;
        }
        InterfaceC8507Wg4 interfaceC8507Wg4I = OI1.i(abstractC4099Dr3N);
        if (interfaceC8507Wg4I != null && (abstractC4099Dr3A = A(abstractC4099Dr3N, interfaceC8507Wg4I)) != null) {
            return abstractC4099Dr3A;
        }
        throw new IllegalStateException("not array: " + abstractC4099Dr3);
    }

    public XC6 l(KQ7 kq7, AbstractC4099Dr3 abstractC4099Dr3) {
        if (kq7 == null) {
            a(81);
        }
        if (abstractC4099Dr3 == null) {
            a(82);
        }
        XC6 xc6M = m(kq7, abstractC4099Dr3, InterfaceC4356Eu.W.b());
        if (xc6M == null) {
            a(83);
        }
        return xc6M;
    }

    public XC6 m(KQ7 kq7, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC4356Eu interfaceC4356Eu) {
        if (kq7 == null) {
            a(77);
        }
        if (abstractC4099Dr3 == null) {
            a(78);
        }
        if (interfaceC4356Eu == null) {
            a(79);
        }
        XC6 xc6G = C4567Fr3.g(interfaceC4356Eu, j(), Collections.singletonList(new C4400Ey7(kq7, abstractC4099Dr3)));
        if (xc6G == null) {
            a(80);
        }
        return xc6G;
    }

    public XC6 n() {
        XC6 xc6Q = Q(EnumC4809Gq5.BOOLEAN);
        if (xc6Q == null) {
            a(62);
        }
        return xc6Q;
    }

    public InterfaceC21331tU0 o(C9424Zw2 c9424Zw2) {
        if (c9424Zw2 == null) {
            a(11);
        }
        InterfaceC21331tU0 interfaceC21331tU0A = NI1.a(this.a, c9424Zw2, FA4.FROM_BUILTINS);
        if (interfaceC21331tU0A == null) {
            a(12);
        }
        return interfaceC21331tU0A;
    }

    public C8773Xg4 r() {
        C8773Xg4 c8773Xg4 = this.a;
        if (c8773Xg4 == null) {
            a(6);
        }
        return c8773Xg4;
    }

    public W24 s() {
        W24 w24O = this.a.z0(PJ6.m).o();
        if (w24O == null) {
            a(10);
        }
        return w24O;
    }

    public XC6 t() {
        XC6 xc6Q = Q(EnumC4809Gq5.BYTE);
        if (xc6Q == null) {
            a(55);
        }
        return xc6Q;
    }

    public XC6 u() {
        XC6 xc6Q = Q(EnumC4809Gq5.CHAR);
        if (xc6Q == null) {
            a(61);
        }
        return xc6Q;
    }

    protected Iterable v() {
        List listSingletonList = Collections.singletonList(new C11918dm0(this.e, this.a));
        if (listSingletonList == null) {
            a(4);
        }
        return listSingletonList;
    }

    public InterfaceC21331tU0 w() {
        InterfaceC21331tU0 interfaceC21331tU0O = o(PJ6.a.P);
        if (interfaceC21331tU0O == null) {
            a(33);
        }
        return interfaceC21331tU0O;
    }

    public InterfaceC21331tU0 x() {
        return p("Comparable");
    }

    public XC6 y() {
        XC6 xc6I = I();
        if (xc6I == null) {
            a(51);
        }
        return xc6I;
    }

    public XC6 z() {
        XC6 xc6Q = Q(EnumC4809Gq5.DOUBLE);
        if (xc6Q == null) {
            a(60);
        }
        return xc6Q;
    }
}
