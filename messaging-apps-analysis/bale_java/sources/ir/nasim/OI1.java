package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC15194jA0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes8.dex */
public abstract class OI1 {
    public static final C9424Zw2 a = new C9424Zw2("kotlin.jvm.JvmName");

    public static boolean A(InterfaceC12795fB1 interfaceC12795fB1) {
        return D(interfaceC12795fB1, AU0.ENUM_CLASS);
    }

    public static boolean B(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(34);
        }
        return D(interfaceC12795fB1, AU0.ENUM_ENTRY);
    }

    public static boolean C(InterfaceC12795fB1 interfaceC12795fB1) {
        return D(interfaceC12795fB1, AU0.INTERFACE);
    }

    private static boolean D(InterfaceC12795fB1 interfaceC12795fB1, AU0 au0) {
        if (au0 == null) {
            a(35);
        }
        return (interfaceC12795fB1 instanceof InterfaceC21331tU0) && ((InterfaceC21331tU0) interfaceC12795fB1).f() == au0;
    }

    public static boolean E(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(1);
        }
        while (interfaceC12795fB1 != null) {
            if (u(interfaceC12795fB1) || y(interfaceC12795fB1)) {
                return true;
            }
            interfaceC12795fB1 = interfaceC12795fB1.b();
        }
        return false;
    }

    private static boolean F(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC12795fB1 interfaceC12795fB1) {
        if (abstractC4099Dr3 == null) {
            a(28);
        }
        if (interfaceC12795fB1 == null) {
            a(29);
        }
        MU0 mu0D = abstractC4099Dr3.K0().t();
        if (mu0D == null) {
            return false;
        }
        InterfaceC12795fB1 interfaceC12795fB1A = mu0D.a();
        return (interfaceC12795fB1A instanceof MU0) && (interfaceC12795fB1 instanceof MU0) && ((MU0) interfaceC12795fB1).j().equals(((MU0) interfaceC12795fB1A).j());
    }

    public static boolean G(InterfaceC12795fB1 interfaceC12795fB1) {
        return (D(interfaceC12795fB1, AU0.CLASS) || D(interfaceC12795fB1, AU0.INTERFACE)) && ((InterfaceC21331tU0) interfaceC12795fB1).r() == EnumC11067cg4.SEALED;
    }

    public static boolean H(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21331tU0 interfaceC21331tU02) {
        if (interfaceC21331tU0 == null) {
            a(26);
        }
        if (interfaceC21331tU02 == null) {
            a(27);
        }
        return I(interfaceC21331tU0.p(), interfaceC21331tU02.a());
    }

    public static boolean I(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC12795fB1 interfaceC12795fB1) {
        if (abstractC4099Dr3 == null) {
            a(30);
        }
        if (interfaceC12795fB1 == null) {
            a(31);
        }
        if (F(abstractC4099Dr3, interfaceC12795fB1)) {
            return true;
        }
        Iterator it = abstractC4099Dr3.K0().b().iterator();
        while (it.hasNext()) {
            if (I((AbstractC4099Dr3) it.next(), interfaceC12795fB1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(InterfaceC12795fB1 interfaceC12795fB1) {
        return interfaceC12795fB1 != null && (interfaceC12795fB1.b() instanceof InterfaceC24340yS4);
    }

    public static boolean K(FQ7 fq7, AbstractC4099Dr3 abstractC4099Dr3) {
        if (fq7 == null) {
            a(61);
        }
        if (abstractC4099Dr3 == null) {
            a(62);
        }
        if (fq7.P() || AbstractC4816Gr3.a(abstractC4099Dr3)) {
            return false;
        }
        if (AbstractC7497Ry7.b(abstractC4099Dr3)) {
            return true;
        }
        AbstractC19738qr3 abstractC19738qr3G = PI1.g(fq7);
        if (!AbstractC19738qr3.y0(abstractC4099Dr3)) {
            InterfaceC4333Er3 interfaceC4333Er3 = InterfaceC4333Er3.a;
            if (!interfaceC4333Er3.c(abstractC19738qr3G.V(), abstractC4099Dr3) && !interfaceC4333Er3.c(abstractC19738qr3G.K().p(), abstractC4099Dr3) && !interfaceC4333Er3.c(abstractC19738qr3G.i(), abstractC4099Dr3) && !C9584aC7.d(abstractC4099Dr3)) {
                return false;
            }
        }
        return true;
    }

    public static InterfaceC15194jA0 L(InterfaceC15194jA0 interfaceC15194jA0) {
        if (interfaceC15194jA0 == null) {
            a(57);
        }
        while (interfaceC15194jA0.f() == InterfaceC15194jA0.a.FAKE_OVERRIDE) {
            Collection collectionD = interfaceC15194jA0.d();
            if (collectionD.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + interfaceC15194jA0);
            }
            interfaceC15194jA0 = (InterfaceC15194jA0) collectionD.iterator().next();
        }
        return interfaceC15194jA0;
    }

    public static InterfaceC16977mB1 M(InterfaceC16977mB1 interfaceC16977mB1) {
        if (interfaceC16977mB1 == null) {
            a(59);
        }
        if (interfaceC16977mB1 instanceof InterfaceC15194jA0) {
            return L((InterfaceC15194jA0) interfaceC16977mB1);
        }
        if (interfaceC16977mB1 == null) {
            a(60);
        }
        return interfaceC16977mB1;
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            case 89:
            case 91:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            case 89:
            case 91:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 55:
            case Type.NINFO /* 56 */:
            case 57:
            case 59:
            case 77:
            case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
            case 92:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            case 89:
            case 91:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = "first";
                break;
            case 15:
                objArr[0] = "second";
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case 43:
            case 62:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = "other";
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case 36:
            case 37:
            case 39:
            case 42:
            case 46:
            case Type.TLSA /* 52 */:
            case 63:
            case 64:
            case 65:
            case 72:
            case 73:
                objArr[0] = "classDescriptor";
                break;
            case 44:
                objArr[0] = "typeConstructor";
                break;
            case 53:
                objArr[0] = "innerClassName";
                break;
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                objArr[0] = "location";
                break;
            case 61:
                objArr[0] = "variable";
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                objArr[0] = "f";
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
                objArr[0] = "current";
                break;
            case 69:
                objArr[0] = "result";
                break;
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
                objArr[0] = "memberDescriptor";
                break;
            case 74:
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                objArr[0] = "annotated";
                break;
            case 80:
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case 85:
            case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
                objArr[0] = "scope";
                break;
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
            case 86:
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case 38:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 40:
            case 41:
                objArr[1] = "getSuperClassType";
                break;
            case 45:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 67:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
                objArr[1] = "getContainingSourceFile";
                break;
            case 81:
                objArr[1] = "getAllDescriptors";
                break;
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
                objArr[1] = "getFunctionByName";
                break;
            case 89:
                objArr[1] = "getPropertyByName";
                break;
            case 91:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            case 89:
            case 91:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case 36:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 39:
                objArr[2] = "getSuperClassType";
                break;
            case 42:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 43:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 44:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 46:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case Type.TLSA /* 52 */:
            case 53:
            case SetUpdatesStruct$ComposedUpdates.MESSAGE_RECEIVED_FIELD_NUMBER /* 54 */:
                objArr[2] = "getInnerClassByName";
                break;
            case 55:
                objArr[2] = "isStaticNestedClass";
                break;
            case Type.NINFO /* 56 */:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 57:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 61:
            case 62:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 63:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 64:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 65:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case WKSRecord.Protocol.RVD /* 66 */:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case WKSRecord.Service.BOOTPC /* 68 */:
            case 69:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case SetRpcStruct$ComposedRpc.LEAVE_GROUP_FIELD_NUMBER /* 70 */:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 72:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 73:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 74:
                objArr[2] = "getJvmName";
                break;
            case SetRpcStruct$ComposedRpc.SUBSCRIBE_FROM_GROUP_ONLINE_FIELD_NUMBER /* 75 */:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 77:
                objArr[2] = "getContainingSourceFile";
                break;
            case 80:
                objArr[2] = "getAllDescriptors";
                break;
            case SetRpcStruct$ComposedRpc.TERMINATE_SESSION_FIELD_NUMBER /* 82 */:
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                objArr[2] = "getFunctionByName";
                break;
            case 85:
            case 86:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case SetRpcStruct$ComposedRpc.GET_CONTACTS_FIELD_NUMBER /* 87 */:
            case SetRpcStruct$ComposedRpc.RESPONSE_GET_CONTACTS_FIELD_NUMBER /* 88 */:
                objArr[2] = "getPropertyByName";
                break;
            case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
                objArr[2] = "getDirectMember";
                break;
            case 92:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case WKSRecord.Protocol.WB_MON /* 78 */:
            case 79:
            case 81:
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
            case 89:
            case 91:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
        if (interfaceC12795fB1 == null) {
            a(14);
        }
        if (interfaceC12795fB12 == null) {
            a(15);
        }
        return g(interfaceC12795fB1).equals(g(interfaceC12795fB12));
    }

    private static void c(InterfaceC14592iA0 interfaceC14592iA0, Set set) {
        if (interfaceC14592iA0 == null) {
            a(68);
        }
        if (set == null) {
            a(69);
        }
        if (set.contains(interfaceC14592iA0)) {
            return;
        }
        Iterator it = interfaceC14592iA0.a().d().iterator();
        while (it.hasNext()) {
            InterfaceC14592iA0 interfaceC14592iA0A = ((InterfaceC14592iA0) it.next()).a();
            c(interfaceC14592iA0A, set);
            set.add(interfaceC14592iA0A);
        }
    }

    public static Set d(InterfaceC14592iA0 interfaceC14592iA0) {
        if (interfaceC14592iA0 == null) {
            a(66);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(interfaceC14592iA0.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static InterfaceC21331tU0 e(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(43);
        }
        return f(abstractC4099Dr3.K0());
    }

    public static InterfaceC21331tU0 f(InterfaceC13882gy7 interfaceC13882gy7) {
        if (interfaceC13882gy7 == null) {
            a(44);
        }
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) interfaceC13882gy7.t();
        if (interfaceC21331tU0 == null) {
            a(45);
        }
        return interfaceC21331tU0;
    }

    public static InterfaceC8507Wg4 g(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(19);
        }
        InterfaceC8507Wg4 interfaceC8507Wg4H = h(interfaceC12795fB1);
        if (interfaceC8507Wg4H == null) {
            a(20);
        }
        return interfaceC8507Wg4H;
    }

    public static InterfaceC8507Wg4 h(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(21);
        }
        while (interfaceC12795fB1 != null) {
            if (interfaceC12795fB1 instanceof InterfaceC8507Wg4) {
                return (InterfaceC8507Wg4) interfaceC12795fB1;
            }
            if (interfaceC12795fB1 instanceof OS4) {
                return ((OS4) interfaceC12795fB1).A0();
            }
            interfaceC12795fB1 = interfaceC12795fB1.b();
        }
        return null;
    }

    public static InterfaceC8507Wg4 i(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            a(18);
        }
        MU0 mu0D = abstractC4099Dr3.K0().t();
        if (mu0D == null) {
            return null;
        }
        return h(mu0D);
    }

    public static KH6 j(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(77);
        }
        if (interfaceC12795fB1 instanceof InterfaceC4146Dw5) {
            interfaceC12795fB1 = ((InterfaceC4146Dw5) interfaceC12795fB1).V();
        }
        if (interfaceC12795fB1 instanceof InterfaceC16386lB1) {
            KH6 kh6B = ((InterfaceC16386lB1) interfaceC12795fB1).i().b();
            if (kh6B == null) {
                a(78);
            }
            return kh6B;
        }
        KH6 kh6 = KH6.a;
        if (kh6 == null) {
            a(79);
        }
        return kh6;
    }

    public static RI1 k(InterfaceC21331tU0 interfaceC21331tU0, boolean z) {
        if (interfaceC21331tU0 == null) {
            a(46);
        }
        AU0 au0F = interfaceC21331tU0.f();
        if (au0F == AU0.ENUM_CLASS || au0F.a()) {
            RI1 ri1 = QI1.a;
            if (ri1 == null) {
                a(47);
            }
            return ri1;
        }
        if (G(interfaceC21331tU0)) {
            if (z) {
                RI1 ri12 = QI1.d;
                if (ri12 == null) {
                    a(48);
                }
                return ri12;
            }
            RI1 ri13 = QI1.a;
            if (ri13 == null) {
                a(49);
            }
            return ri13;
        }
        if (u(interfaceC21331tU0)) {
            RI1 ri14 = QI1.l;
            if (ri14 == null) {
                a(50);
            }
            return ri14;
        }
        RI1 ri15 = QI1.e;
        if (ri15 == null) {
            a(51);
        }
        return ri15;
    }

    public static ZI5 l(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(0);
        }
        if (interfaceC12795fB1 instanceof InterfaceC21331tU0) {
            return ((InterfaceC21331tU0) interfaceC12795fB1).H0();
        }
        return null;
    }

    public static C10027ax2 m(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(2);
        }
        C9424Zw2 c9424Zw2O = o(interfaceC12795fB1);
        return c9424Zw2O != null ? c9424Zw2O.j() : p(interfaceC12795fB1);
    }

    public static C9424Zw2 n(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(3);
        }
        C9424Zw2 c9424Zw2O = o(interfaceC12795fB1);
        if (c9424Zw2O == null) {
            c9424Zw2O = p(interfaceC12795fB1).l();
        }
        if (c9424Zw2O == null) {
            a(4);
        }
        return c9424Zw2O;
    }

    private static C9424Zw2 o(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(5);
        }
        if ((interfaceC12795fB1 instanceof InterfaceC8507Wg4) || AbstractC14230ha2.r(interfaceC12795fB1)) {
            return C9424Zw2.c;
        }
        if (interfaceC12795fB1 instanceof OS4) {
            return ((OS4) interfaceC12795fB1).e();
        }
        if (interfaceC12795fB1 instanceof InterfaceC24340yS4) {
            return ((InterfaceC24340yS4) interfaceC12795fB1).e();
        }
        return null;
    }

    private static C10027ax2 p(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(6);
        }
        C10027ax2 c10027ax2C = m(interfaceC12795fB1.b()).c(interfaceC12795fB1.getName());
        if (c10027ax2C == null) {
            a(7);
        }
        return c10027ax2C;
    }

    public static InterfaceC12795fB1 q(InterfaceC12795fB1 interfaceC12795fB1, Class cls) {
        if (cls == null) {
            a(16);
        }
        return r(interfaceC12795fB1, cls, true);
    }

    public static InterfaceC12795fB1 r(InterfaceC12795fB1 interfaceC12795fB1, Class cls, boolean z) {
        if (cls == null) {
            a(17);
        }
        if (interfaceC12795fB1 == null) {
            return null;
        }
        if (z) {
            interfaceC12795fB1 = interfaceC12795fB1.b();
        }
        while (interfaceC12795fB1 != null) {
            if (cls.isInstance(interfaceC12795fB1)) {
                return interfaceC12795fB1;
            }
            interfaceC12795fB1 = interfaceC12795fB1.b();
        }
        return null;
    }

    public static InterfaceC21331tU0 s(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(42);
        }
        Iterator it = interfaceC21331tU0.j().b().iterator();
        while (it.hasNext()) {
            InterfaceC21331tU0 interfaceC21331tU0E = e((AbstractC4099Dr3) it.next());
            if (interfaceC21331tU0E.f() != AU0.INTERFACE) {
                return interfaceC21331tU0E;
            }
        }
        return null;
    }

    public static boolean t(InterfaceC12795fB1 interfaceC12795fB1) {
        return D(interfaceC12795fB1, AU0.ANNOTATION_CLASS);
    }

    public static boolean u(InterfaceC12795fB1 interfaceC12795fB1) {
        if (interfaceC12795fB1 == null) {
            a(32);
        }
        return v(interfaceC12795fB1) && interfaceC12795fB1.getName().equals(AbstractC23662xI6.a);
    }

    public static boolean v(InterfaceC12795fB1 interfaceC12795fB1) {
        return D(interfaceC12795fB1, AU0.CLASS);
    }

    public static boolean w(InterfaceC12795fB1 interfaceC12795fB1) {
        return v(interfaceC12795fB1) || A(interfaceC12795fB1);
    }

    public static boolean x(InterfaceC12795fB1 interfaceC12795fB1) {
        return D(interfaceC12795fB1, AU0.OBJECT) && ((InterfaceC21331tU0) interfaceC12795fB1).b0();
    }

    public static boolean y(InterfaceC12795fB1 interfaceC12795fB1) {
        return (interfaceC12795fB1 instanceof InterfaceC16977mB1) && ((InterfaceC16977mB1) interfaceC12795fB1).getVisibility() == QI1.f;
    }

    public static boolean z(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21331tU0 interfaceC21331tU02) {
        if (interfaceC21331tU0 == null) {
            a(24);
        }
        if (interfaceC21331tU02 == null) {
            a(25);
        }
        Iterator it = interfaceC21331tU0.j().b().iterator();
        while (it.hasNext()) {
            if (F((AbstractC4099Dr3) it.next(), interfaceC21331tU02.a())) {
                return true;
            }
        }
        return false;
    }
}
