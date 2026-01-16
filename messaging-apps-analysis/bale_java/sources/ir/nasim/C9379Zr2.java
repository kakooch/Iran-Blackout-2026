package ir.nasim;

import ai.bale.proto.MessagingStruct$Folder;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19428qK7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogFolderEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Zr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9379Zr2 implements InterfaceC9145Yr2 {
    private final InterfaceC11621dJ7 a;
    private final KM2 b;

    /* renamed from: ir.nasim.Zr2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.Zr2$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[W25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[ExPeerType.values().length];
            try {
                iArr2[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.Zr2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C9379Zr2.this.e(0L, this);
        }
    }

    public C9379Zr2(InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        this.a = interfaceC11621dJ7;
        this.b = km2;
    }

    private final List g() {
        F92 f92 = a.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : f92) {
            if (((EnumC7296Rc4) obj) != EnumC7296Rc4.UNRECOGNIZED) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final AbstractC19428qK7 h(ExPeerType exPeerType) {
        int i = exPeerType == null ? -1 : b.b[exPeerType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractC19428qK7.f.c : AbstractC19428qK7.a.c : AbstractC19428qK7.b.c : AbstractC19428qK7.c.c : AbstractC19428qK7.d.c;
    }

    @Override // ir.nasim.InterfaceC9145Yr2
    public RM1 a(AbstractC3769Cg6 abstractC3769Cg6) {
        AbstractC13042fc3.i(abstractC3769Cg6, "searchModel");
        return new RM1(abstractC3769Cg6.d().u(), abstractC3769Cg6.c(), abstractC3769Cg6.e(), h(abstractC3769Cg6.c()), true, false, false, "", abstractC3769Cg6.a());
    }

    @Override // ir.nasim.InterfaceC9145Yr2
    public C8870Xr2 b(DialogFolderEntity dialogFolderEntity) {
        AbstractC13042fc3.i(dialogFolderEntity, "folderEntity");
        int id = dialogFolderEntity.getId();
        String name = dialogFolderEntity.getName();
        List listG = g();
        boolean z = false;
        if (!(listG instanceof Collection) || !listG.isEmpty()) {
            Iterator it = listG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((EnumC7296Rc4) it.next()).getNumber() == dialogFolderEntity.getId()) {
                    z = true;
                    break;
                }
            }
        }
        return new C8870Xr2(id, name, z, dialogFolderEntity.isActive(), false, false, 48, null);
    }

    @Override // ir.nasim.InterfaceC9145Yr2
    public C8870Xr2 c(MessagingStruct$Folder messagingStruct$Folder) {
        AbstractC13042fc3.i(messagingStruct$Folder, "folder");
        int id = messagingStruct$Folder.getId();
        String name = messagingStruct$Folder.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        List listG = g();
        boolean z = false;
        if (!(listG instanceof Collection) || !listG.isEmpty()) {
            Iterator it = listG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((EnumC7296Rc4) it.next()).getNumber() == messagingStruct$Folder.getId()) {
                    z = true;
                    break;
                }
            }
        }
        return new C8870Xr2(id, name, z, true, false, false, 48, null);
    }

    @Override // ir.nasim.InterfaceC9145Yr2
    public DialogFolderEntity d(MessagingStruct$Folder messagingStruct$Folder, int i, boolean z) {
        AbstractC13042fc3.i(messagingStruct$Folder, "folder");
        int id = messagingStruct$Folder.getId();
        String name = messagingStruct$Folder.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return new DialogFolderEntity(id, name, i, null, false, false, z, 56, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // ir.nasim.InterfaceC9145Yr2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(long r20, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9379Zr2.e(long, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC9145Yr2
    public DialogFolderEntity f(EnumC7296Rc4 enumC7296Rc4, boolean z) {
        AbstractC13042fc3.i(enumC7296Rc4, "reservedFolderId");
        return new DialogFolderEntity(enumC7296Rc4.getNumber(), "", enumC7296Rc4.getNumber(), null, false, false, z, 56, null);
    }
}
