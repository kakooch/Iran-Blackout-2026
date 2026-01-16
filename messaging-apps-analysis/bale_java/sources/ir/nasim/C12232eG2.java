package ir.nasim;

import android.content.Context;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.eG2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12232eG2 {
    private final C20748sY1 a;
    private final Context b;
    private final Cache c;

    /* renamed from: ir.nasim.eG2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NN6.values().length];
            try {
                iArr[NN6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NN6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NN6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.eG2$b */
    static final class b extends AbstractC19859r37 implements UA2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C12232eG2.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Set setF = C12232eG2.this.c.f();
            AbstractC13042fc3.h(setF, "getKeys(...)");
            Cache cache = C12232eG2.this.c;
            Iterator it = setF.iterator();
            while (it.hasNext()) {
                cache.k((String) it.next());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eG2$c */
    static final class c extends AbstractC19859r37 implements UA2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C12232eG2.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12232eG2.this.k();
                C20748sY1 c20748sY1 = C12232eG2.this.a;
                this.b = 1;
                if (c20748sY1.l(this) == objE) {
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

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12232eG2(C20748sY1 c20748sY1, Context context, Cache cache) {
        AbstractC13042fc3.i(c20748sY1, "downloadManager");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(cache, "videoCache");
        this.a = c20748sY1;
        this.b = context;
        this.c = cache;
    }

    private final String f(EnumC9082Yk2 enumC9082Yk2, NN6 nn6) {
        File cacheDir;
        int i = a.a[nn6.ordinal()];
        if (i == 1) {
            cacheDir = this.b.getCacheDir();
        } else if (i == 2) {
            cacheDir = this.b.getFilesDir();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            cacheDir = this.b.getExternalFilesDir(null);
        }
        File file = new File(cacheDir, enumC9082Yk2.j());
        if (!file.exists()) {
            file = null;
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    private final List g(EnumC9082Yk2... enumC9082Yk2Arr) {
        ArrayList arrayList = new ArrayList();
        for (EnumC9082Yk2 enumC9082Yk2 : enumC9082Yk2Arr) {
            AbstractC13610gX0.D(arrayList, AbstractC10360bX0.r(f(enumC9082Yk2, NN6.a), f(enumC9082Yk2, NN6.b), f(enumC9082Yk2, NN6.c)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(File file, File file2) {
        AbstractC13042fc3.i(file, "root");
        AbstractC13042fc3.i(file2, "child");
        String path = file.getPath();
        AbstractC13042fc3.h(path, "getPath(...)");
        if (!AbstractC20153rZ6.C(path, "/cache", false, 2, null)) {
            return true;
        }
        String absolutePath = file2.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        return AbstractC20153rZ6.C(absolutePath, ".jpg", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(File file, File file2) {
        AbstractC13042fc3.i(file, "root");
        AbstractC13042fc3.i(file2, "child");
        String path = file.getPath();
        AbstractC13042fc3.h(path, "getPath(...)");
        if (!AbstractC20153rZ6.C(path, "/cache", false, 2, null)) {
            return true;
        }
        String absolutePath = file2.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        return AbstractC20153rZ6.C(absolutePath, ".mp4", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.i);
        Set setKeySet = interfaceC3570Bk5Q.getAll().keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String str = (String) obj;
            AbstractC13042fc3.f(str);
            if (AbstractC20153rZ6.S(str, C18495ol2.E.a(), false, 2, null)) {
                arrayList.add(obj);
            }
        }
        interfaceC3570Bk5Q.i(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List h() {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12232eG2.h():java.util.List");
    }
}
