package ir.nasim.core.modules.file.storage;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StatFs;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC13822gs5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.GJ0;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16204ks5;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.core.modules.file.storage.a;
import ir.nasim.core.modules.file.storage.d;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes5.dex */
public final class a {
    private static final C0996a g = new C0996a(null);
    public static final int h = 8;
    private final Context a;
    private final int b;
    private final InterfaceC20315ro1 c;
    private final AbstractC13778go1 d;
    private final SettingsModule e;
    private final InterfaceC10258bL6 f;

    /* renamed from: ir.nasim.core.modules.file.storage.a$a, reason: collision with other inner class name */
    private static final class C0996a {
        private C0996a() {
        }

        public /* synthetic */ C0996a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(a aVar, StorageStateTracker storageStateTracker) {
            aVar.a.unregisterReceiver(storageStateTracker);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(InterfaceC16204ks5 interfaceC16204ks5, a aVar, String str) {
            interfaceC16204ks5.h(aVar.e(str));
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = a.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String action;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                final a aVar = a.this;
                final StorageStateTracker storageStateTracker = new StorageStateTracker(new UA2() { // from class: ir.nasim.core.modules.file.storage.b
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return a.b.z(interfaceC16204ks5, aVar, (String) obj2);
                    }
                });
                Intent intentRegisterReceiver = a.this.a.registerReceiver(storageStateTracker, StorageStateTracker.INSTANCE.a());
                if (intentRegisterReceiver != null && (action = intentRegisterReceiver.getAction()) != null) {
                    GJ0.b(interfaceC16204ks5.h(a.this.e(action)));
                }
                final a aVar2 = a.this;
                SA2 sa2 = new SA2() { // from class: ir.nasim.core.modules.file.storage.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return a.b.D(aVar2, storageStateTracker);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C19406qI3.d("GetStorageStateUseCase", (Throwable) this.d);
                d.c cVar = d.c.a;
                this.c = null;
                this.b = 1;
                if (interfaceC4806Gq2.a(cVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(interfaceC20295rm1);
            cVar.c = interfaceC4806Gq2;
            cVar.d = th;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    public a(Context context, int i, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, SettingsModule settingsModule) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = context;
        this.b = i;
        this.c = interfaceC20315ro1;
        this.d = abstractC13778go1;
        this.e = settingsModule;
        this.f = AbstractC6459Nq2.o0(AbstractC6459Nq2.h(AbstractC6459Nq2.F(AbstractC6459Nq2.V(AbstractC6459Nq2.f(new b(null)), abstractC13778go1)), new c(null)), interfaceC20315ro1, InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 0L, 0L, 3, null), d());
    }

    private final long c() {
        long blockSize;
        long availableBlocks;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (this.b >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return (blockSize * availableBlocks) / 1048576;
    }

    private final d d() {
        try {
            long jC = c();
            return jC <= ((long) this.e.X2()) ? new d.a(jC) : new d.b(jC);
        } catch (Exception e) {
            C19406qI3.d("GetStorageStateUseCase", e);
            return d.c.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d e(String str) {
        if (AbstractC13042fc3.d(str, "android.intent.action.DEVICE_STORAGE_OK")) {
            long jC = c();
            return jC <= ((long) this.e.X2()) ? new d.a(jC) : new d.b(jC);
        }
        if (AbstractC13042fc3.d(str, "android.intent.action.DEVICE_STORAGE_LOW")) {
            return new d.a(c());
        }
        return null;
    }

    public final InterfaceC10258bL6 f() {
        return this.f;
    }
}
