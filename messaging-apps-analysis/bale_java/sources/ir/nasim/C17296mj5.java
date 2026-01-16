package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.mj5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17296mj5 implements InterfaceC16114kj5 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(InterfaceC14603iB2 interfaceC14603iB2, List list, String str) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onUploadStory");
        AbstractC13042fc3.i(list, "coordinates");
        AbstractC13042fc3.i(str, "link");
        interfaceC14603iB2.invoke(list, str);
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC16114kj5
    public void a(Fragment fragment, AbstractC22357v6 abstractC22357v6, I35 i35, Context context, C16731lm1 c16731lm1, C8967Xz7 c8967Xz7, ViewGroup viewGroup, IQ0 iq0, SA2 sa2, final InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(abstractC22357v6, "requestPermissionLauncher");
        AbstractC13042fc3.i(i35, "permissionResultCallback");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c16731lm1, "contextThemeWrapper");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(viewGroup, "rootView");
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(sa2, "onCloseEditor");
        AbstractC13042fc3.i(interfaceC14603iB2, "onUploadStory");
        C12971fU6.a.p(fragment, abstractC22357v6, i35, 0L).l(context, c16731lm1, c8967Xz7, viewGroup, iq0, sa2, new InterfaceC14603iB2() { // from class: ir.nasim.lj5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C17296mj5.c(interfaceC14603iB2, (List) obj, (String) obj2);
            }
        });
    }
}
