package ir.nasim.features.call.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.gov.nist.core.Separators;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12895fM2;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.AbstractC9559aA0;
import ir.nasim.C08;
import ir.nasim.C10857cJ7;
import ir.nasim.C11458d25;
import ir.nasim.C12366eV1;
import ir.nasim.C15838kG;
import ir.nasim.C17448mz0;
import ir.nasim.C17637nI7;
import ir.nasim.C18039nz0;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20384rv0;
import ir.nasim.C21002sy0;
import ir.nasim.C21231tK7;
import ir.nasim.C21250tN;
import ir.nasim.C21352tW3;
import ir.nasim.C21786u78;
import ir.nasim.C22376v78;
import ir.nasim.C5074Hu0;
import ir.nasim.C5161Id6;
import ir.nasim.C5335Ix0;
import ir.nasim.C5344Iy0;
import ir.nasim.C6409Nm;
import ir.nasim.C8386Vt0;
import ir.nasim.C8942Xx0;
import ir.nasim.C9728aS7;
import ir.nasim.ED1;
import ir.nasim.EnumC12029dv0;
import ir.nasim.EnumC13941h47;
import ir.nasim.EnumC21689ty0;
import ir.nasim.EnumC23259wd1;
import ir.nasim.EnumC23959xo1;
import ir.nasim.HG1;
import ir.nasim.InterfaceC11621dJ7;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18490ok7;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.K04;
import ir.nasim.P17;
import ir.nasim.Q12;
import ir.nasim.S37;
import ir.nasim.SA2;
import ir.nasim.T12;
import ir.nasim.TN;
import ir.nasim.UA2;
import ir.nasim.W12;
import ir.nasim.W25;
import ir.nasim.WM3;
import ir.nasim.Y08;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.service.CallService;
import ir.nasim.features.call.ui.CallActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u0000 \u009b\u00022\u00020\u0001:\u0002\u009c\u0002B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0015H\u0002¢\u0006\u0004\b#\u0010\"J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u0010\u0003J\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020*H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u0010\u0003J\u001b\u00109\u001a\u00020\u00042\n\u00108\u001a\u000606j\u0002`7H\u0002¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00042\n\u00108\u001a\u000606j\u0002`7H\u0002¢\u0006\u0004\b;\u0010:J!\u0010@\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020*H\u0002¢\u0006\u0004\bB\u0010,J\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0004H\u0002¢\u0006\u0004\bD\u0010\u0003J\u0017\u0010E\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\tJ\u0017\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0004H\u0002¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010\u0003J\u000f\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020>H\u0002¢\u0006\u0004\bQ\u0010RJ1\u0010X\u001a\u00020\u00042\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S2\u0012\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0V0SH\u0002¢\u0006\u0004\bX\u0010YJ2\u0010Z\u001a\u00020\u00042\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S2\u0012\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0V0SH\u0082@¢\u0006\u0004\bZ\u0010[J2\u0010\\\u001a\u00020\u00042\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S2\u0012\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0V0SH\u0082@¢\u0006\u0004\b\\\u0010[J\u000f\u0010]\u001a\u00020MH\u0002¢\u0006\u0004\b]\u0010OJ\u000f\u0010^\u001a\u00020\u0004H\u0002¢\u0006\u0004\b^\u0010\u0003J1\u0010a\u001a\u00020\u00042\u0006\u0010_\u001a\u00020>2\u0006\u0010`\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\ba\u0010bJ)\u0010c\u001a\u00020\u00042\u0006\u0010`\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bc\u0010dJ)\u0010e\u001a\u00020\u00042\u0006\u0010`\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\be\u0010dJ)\u0010f\u001a\u00020\u00042\u0006\u0010`\u001a\u00020F2\u0006\u0010G\u001a\u00020F2\b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\u0004H\u0016¢\u0006\u0004\bg\u0010\u0003J'\u0010m\u001a\u00020l2\u0006\u0010i\u001a\u00020h2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\bm\u0010nJ'\u0010q\u001a\u00020>2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010o\u001a\u00020>2\u0006\u0010p\u001a\u00020>H\u0016¢\u0006\u0004\bq\u0010rJ\u0017\u0010s\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\bs\u0010\u001eJ3\u0010v\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010u\u001a\u00020t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0004¢\u0006\u0004\bv\u0010wJ3\u0010x\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010u\u001a\u00020t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0004¢\u0006\u0004\bx\u0010wJ!\u0010|\u001a\u00020\u00152\u0006\u0010y\u001a\u00020>2\b\b\u0002\u0010{\u001a\u00020zH\u0004¢\u0006\u0004\b|\u0010}J3\u0010\u007f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010u\u001a\u00020t2\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0004¢\u0006\u0004\b\u007f\u0010wJ=\u0010\u0081\u0001\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010u\u001a\u00020t2\u0019\u0010~\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00040\u0080\u0001H\u0004¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001JC\u0010\u0083\u0001\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010u\u001a\u00020t2\u001f\u0010~\u001a\u001b\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0S\u0012\u0004\u0012\u00020\u00040\u0080\u0001H\u0004¢\u0006\u0006\b\u0083\u0001\u0010\u0082\u0001J\u0019\u0010\u0084\u0001\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0005\b\u0084\u0001\u0010\u001eJ\u0019\u0010\u0086\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020z¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J.\u0010\u0088\u0001\u001a\u00020\u00042\u0006\u00102\u001a\u00020*2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0004¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J.\u0010\u008a\u0001\u001a\u00020\u00042\u0006\u00102\u001a\u00020*2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u0014H\u0004¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J\u001c\u0010\u008c\u0001\u001a\u00020\u00042\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0005\b\u008c\u0001\u0010\u001eJ\u0011\u0010\u008d\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u008d\u0001\u0010\u0003J\u000f\u0010\u008e\u0001\u001a\u00020\u0004¢\u0006\u0005\b\u008e\u0001\u0010\u0003J\u0018\u0010\u0090\u0001\u001a\u00020\u00042\u0007\u0010\u008f\u0001\u001a\u00020*¢\u0006\u0005\b\u0090\u0001\u00104J\u0011\u0010\u0091\u0001\u001a\u00020\u0004H\u0014¢\u0006\u0005\b\u0091\u0001\u0010\u0003J\u001f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001c\u0010\u0097\u0001\u001a\u00020\u00042\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0014¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0019\u0010\u009b\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001e\u0010k\u001a\u00020j8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001f\u0010£\u0001\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b \u0001\u0010¡\u0001\u001a\u0005\b¢\u0001\u0010OR\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R*\u0010«\u0001\u001a\u0004\u0018\u00010M8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\b§\u0001\u0010¥\u0001\u001a\u0005\b¨\u0001\u0010O\"\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R!\u0010´\u0001\u001a\n\u0018\u00010°\u0001R\u00030±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R+\u0010½\u0001\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Å\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u001c\u0010Ì\u0001\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0019\u0010Ï\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0019\u0010Ð\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u009a\u0001R\u0019\u0010Ò\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010\u009a\u0001R\u0019\u0010Ô\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010\u009a\u0001R*\u0010Ü\u0001\u001a\u00030Õ\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R*\u0010ä\u0001\u001a\u00030Ý\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R\u001c\u0010ç\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R*\u0010ï\u0001\u001a\u00030è\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R*\u0010÷\u0001\u001a\u00030ð\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bñ\u0001\u0010ò\u0001\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0006\bõ\u0001\u0010ö\u0001R*\u0010ÿ\u0001\u001a\u00030ø\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R*\u0010\u0087\u0002\u001a\u00030\u0080\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002\"\u0006\b\u0085\u0002\u0010\u0086\u0002R*\u0010\u008f\u0002\u001a\u00030\u0088\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0089\u0002\u0010\u008a\u0002\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002\"\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0019\u0010\u0092\u0002\u001a\u00020z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R\u001b\u0010\u0094\u0002\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010¥\u0001R\u0018\u0010u\u001a\u0004\u0018\u00010t8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002R\u0016\u0010G\u001a\u00020F8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0018\u0010 \u001a\u0004\u0018\u00010\u00158@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002¨\u0006\u009d\u0002"}, d2 = {"Lir/nasim/features/call/service/CallService;", "Landroid/app/Service;", "<init>", "()V", "Lir/nasim/rB7;", "c0", "Lir/nasim/mz0;", "callServiceState", "f0", "(Lir/nasim/mz0;)V", "w1", "v1", "Y0", "Lir/nasim/TN;", "audioManagerCompat", "Lir/nasim/tN;", "j0", "(Lir/nasim/TN;)Lir/nasim/tN;", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "Lir/nasim/Xx0;", "onReadyToShowNotification", "V0", "(Landroid/content/Intent;Lir/nasim/UA2;)V", "Lir/nasim/d25;", "peer", "K1", "(Lir/nasim/d25;)V", "y1", "(Landroid/content/Intent;)V", "Z0", "callPeer", "F1", "(Lir/nasim/Xx0;)V", "H1", "O1", "l1", "j1", "i1", "J1", "e0", "", "b1", "()Z", "h0", "q1", "e1", "d1", "o0", "isFromNotification", "l0", "(Z)V", "m0", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "n1", "(Ljava/lang/Exception;)V", "k1", "Lir/nasim/dv0;", "discardReason", "", "callDuration", "h1", "(Lir/nasim/dv0;I)V", "d0", "N1", "M1", "g0", "", "callId", "g1", "(J)V", "o1", "m1", "C1", "Lir/nasim/gj3;", "f1", "()Lir/nasim/gj3;", "senderId", "W0", "(I)V", "", "Lir/nasim/M26;", "accumulator", "Lir/nasim/Fq2;", "newValue", "H0", "(Ljava/util/List;Ljava/util/List;)V", "Q1", "(Ljava/util/List;Ljava/util/List;Lir/nasim/rm1;)Ljava/lang/Object;", "P1", "i0", "x1", "eventType", "duration", "z1", "(IJJLir/nasim/Xx0;)V", "D1", "(JJLir/nasim/Xx0;)V", "A1", "B1", "onCreate", "Lir/nasim/h47;", "switchType", "Lir/nasim/ro1;", "serviceScope", "Lir/nasim/C08;", "k0", "(Lir/nasim/h47;Landroid/content/Intent;Lir/nasim/ro1;)Lir/nasim/C08;", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "K0", "Lir/nasim/Pz0;", "callType", "I0", "(Landroid/content/Intent;Lir/nasim/Pz0;Lir/nasim/UA2;)V", "J0", "userId", "", "phoneNumber", "u0", "(ILjava/lang/String;)Lir/nasim/Xx0;", "onCallPrepared", "r1", "Lkotlin/Function2;", "s1", "(Landroid/content/Intent;Lir/nasim/Pz0;Lir/nasim/iB2;)V", "t1", "u1", "grantedPermission", "p1", "(Ljava/lang/String;)V", "r", "(ZLir/nasim/UA2;)V", "c1", "rootIntent", "onTaskRemoved", "onDestroy", "X0", "endForAllUsers", "p0", "n0", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Lir/nasim/mz0$a;", "callState", "G0", "(Lir/nasim/mz0$a;)V", "d", "J", "start", "e", "Lir/nasim/ro1;", "A0", "()Lir/nasim/ro1;", "f", "Lir/nasim/Yu3;", "B0", "stopCallJob", "g", "Lir/nasim/gj3;", "stopCallIfUsersLeftJob", "h", "C0", "E1", "(Lir/nasim/gj3;)V", "stopCallServiceJob", "Lir/nasim/sy0;", "i", "Lir/nasim/sy0;", "callProximityManager", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "j", "Landroid/os/PowerManager$WakeLock;", "cpuWakelock", "k", "Lir/nasim/TN;", "l", "Lir/nasim/tN;", "s0", "()Lir/nasim/tN;", "setAudioDeviceSelector$nasim_release", "(Lir/nasim/tN;)V", "audioDeviceSelector", "Lir/nasim/ok7;", "m", "Lir/nasim/ok7;", "telephonyManagerCompat", "n", "Lir/nasim/C08;", "voiceCallSwitch", "Landroid/support/v4/media/session/MediaSessionCompat;", "o", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSession", "Landroid/content/BroadcastReceiver;", "p", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "q", "Z", "wasScreenOn", "lastReconnectTimeEventMs", "s", "lastConnectToRoomTimeEventMs", "t", "lastPoorConnectionTimeEventMs", "Lir/nasim/kG;", "u", "Lir/nasim/kG;", "r0", "()Lir/nasim/kG;", "setApplyConnectedRoomStateUserCase", "(Lir/nasim/kG;)V", "applyConnectedRoomStateUserCase", "Lir/nasim/Iy0;", "v", "Lir/nasim/Iy0;", "x0", "()Lir/nasim/Iy0;", "setCallRingtoneHandler", "(Lir/nasim/Iy0;)V", "callRingtoneHandler", "w", "Lir/nasim/mz0$a;", "callStateBeforeReconnect", "Lir/nasim/dJ7;", "x", "Lir/nasim/dJ7;", "D0", "()Lir/nasim/dJ7;", "setUserRepository", "(Lir/nasim/dJ7;)V", "userRepository", "Lir/nasim/Nm;", "y", "Lir/nasim/Nm;", "q0", "()Lir/nasim/Nm;", "setAnalyticsRepository", "(Lir/nasim/Nm;)V", "analyticsRepository", "Lir/nasim/aS7;", "z", "Lir/nasim/aS7;", "E0", "()Lir/nasim/aS7;", "setVersionCodeNumber", "(Lir/nasim/aS7;)V", "versionCodeNumber", "Lir/nasim/u78;", "A", "Lir/nasim/u78;", "F0", "()Lir/nasim/u78;", "setWebRtcStatsRepository", "(Lir/nasim/u78;)V", "webRtcStatsRepository", "Lokhttp3/OkHttpClient;", "B", "Lokhttp3/OkHttpClient;", "z0", "()Lokhttp3/OkHttpClient;", "setOkHttpClient", "(Lokhttp3/OkHttpClient;)V", "okHttpClient", "D", "Ljava/lang/String;", "myName", "G", "timerJob", "y0", "()Lir/nasim/Pz0;", "t0", "()J", "w0", "()Lir/nasim/Xx0;", "H", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class CallService extends Hilt_CallService {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int J = 8;
    private static CallService Y;

    /* renamed from: A, reason: from kotlin metadata */
    public C21786u78 webRtcStatsRepository;

    /* renamed from: B, reason: from kotlin metadata */
    public OkHttpClient okHttpClient;

    /* renamed from: G, reason: from kotlin metadata */
    private InterfaceC13730gj3 timerJob;

    /* renamed from: d, reason: from kotlin metadata */
    private long start;

    /* renamed from: g, reason: from kotlin metadata */
    private InterfaceC13730gj3 stopCallIfUsersLeftJob;

    /* renamed from: h, reason: from kotlin metadata */
    private InterfaceC13730gj3 stopCallServiceJob;

    /* renamed from: i, reason: from kotlin metadata */
    private C21002sy0 callProximityManager;

    /* renamed from: j, reason: from kotlin metadata */
    private PowerManager.WakeLock cpuWakelock;

    /* renamed from: k, reason: from kotlin metadata */
    private TN audioManagerCompat;

    /* renamed from: l, reason: from kotlin metadata */
    private C21250tN audioDeviceSelector;

    /* renamed from: m, reason: from kotlin metadata */
    private InterfaceC18490ok7 telephonyManagerCompat;

    /* renamed from: n, reason: from kotlin metadata */
    private C08 voiceCallSwitch;

    /* renamed from: o, reason: from kotlin metadata */
    private MediaSessionCompat mediaSession;

    /* renamed from: p, reason: from kotlin metadata */
    private BroadcastReceiver broadcastReceiver;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean wasScreenOn;

    /* renamed from: r, reason: from kotlin metadata */
    private long lastReconnectTimeEventMs;

    /* renamed from: s, reason: from kotlin metadata */
    private long lastConnectToRoomTimeEventMs;

    /* renamed from: t, reason: from kotlin metadata */
    private long lastPoorConnectionTimeEventMs;

    /* renamed from: u, reason: from kotlin metadata */
    public C15838kG applyConnectedRoomStateUserCase;

    /* renamed from: v, reason: from kotlin metadata */
    public C5344Iy0 callRingtoneHandler;

    /* renamed from: w, reason: from kotlin metadata */
    private C17448mz0.a callStateBeforeReconnect;

    /* renamed from: x, reason: from kotlin metadata */
    public InterfaceC11621dJ7 userRepository;

    /* renamed from: y, reason: from kotlin metadata */
    public C6409Nm analyticsRepository;

    /* renamed from: z, reason: from kotlin metadata */
    public C9728aS7 versionCodeNumber;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC20315ro1 serviceScope = AbstractC20906so1.a(C12366eV1.a().X(P17.b(null, 1, null)));

    /* renamed from: f, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 stopCallJob = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.az0
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return CallService.L1(this.a);
        }
    });

    /* renamed from: D, reason: from kotlin metadata */
    private String myName = "";

    /* renamed from: ir.nasim.features.call.service.CallService$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final CallService a() {
            return CallService.Y;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[C17448mz0.a.values().length];
            try {
                iArr[C17448mz0.a.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C17448mz0.a.j.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C17448mz0.a.l.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C17448mz0.a.m.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[C17448mz0.a.k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[C17448mz0.a.d.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[C17448mz0.a.a.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[C17448mz0.a.g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC13941h47.values().length];
            try {
                iArr2[EnumC13941h47.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC12029dv0.values().length];
            try {
                iArr3[EnumC12029dv0.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[EnumC12029dv0.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[EnumC12029dv0.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[EnumC12029dv0.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            c = iArr3;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ CallService a;

            a(CallService callService) {
                this.a = callService;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                if (z) {
                    C21002sy0 c21002sy0 = this.a.callProximityManager;
                    if (c21002sy0 != null) {
                        c21002sy0.c();
                    }
                } else {
                    if (z) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C21002sy0 c21002sy02 = this.a.callProximityManager;
                    if (c21002sy02 != null) {
                        c21002sy02.b();
                    }
                }
                return C19938rB7.a;
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[C17448mz0.a.values().length];
                try {
                    iArr[C17448mz0.a.n.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.features.call.service.CallService$c$c, reason: collision with other inner class name */
        public static final class C1122c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.features.call.service.CallService$c$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.call.service.CallService$c$c$a$a, reason: collision with other inner class name */
                public static final class C1123a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1123a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.features.call.service.CallService.c.C1122c.a.C1123a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.features.call.service.CallService$c$c$a$a r0 = (ir.nasim.features.call.service.CallService.c.C1122c.a.C1123a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.call.service.CallService$c$c$a$a r0 = new ir.nasim.features.call.service.CallService$c$c$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L72
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        r2 = r7
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r4 = r2.e()
                        ir.nasim.mz0$a r5 = ir.nasim.C17448mz0.a.a
                        if (r4 == r5) goto L69
                        ir.nasim.mz0$a r4 = r2.e()
                        ir.nasim.mz0$a r5 = ir.nasim.C17448mz0.a.b
                        if (r4 == r5) goto L69
                        ir.nasim.mz0$a r4 = r2.e()
                        ir.nasim.mz0$a r5 = ir.nasim.C17448mz0.a.c
                        if (r4 == r5) goto L69
                        ir.nasim.mz0$a r4 = r2.e()
                        ir.nasim.mz0$a r5 = ir.nasim.C17448mz0.a.f
                        if (r4 == r5) goto L69
                        ir.nasim.mz0$a r4 = r2.e()
                        ir.nasim.mz0$a r5 = ir.nasim.C17448mz0.a.g
                        if (r4 == r5) goto L69
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 != r4) goto L72
                    L69:
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L72
                        return r1
                    L72:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.c.C1122c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public C1122c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.call.service.CallService$c$d$a$a, reason: collision with other inner class name */
                public static final class C1124a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1124a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.features.call.service.CallService.c.d.a.C1124a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.features.call.service.CallService$c$d$a$a r0 = (ir.nasim.features.call.service.CallService.c.d.a.C1124a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.call.service.CallService$c$d$a$a r0 = new ir.nasim.features.call.service.CallService$c$d$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L61
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        ir.nasim.mz0 r6 = (ir.nasim.C17448mz0) r6
                        ir.nasim.mz0$a r2 = r6.e()
                        int[] r4 = ir.nasim.features.call.service.CallService.c.b.a
                        int r2 = r2.ordinal()
                        r2 = r4[r2]
                        r4 = 0
                        if (r2 != r3) goto L49
                        r2 = r4
                        goto L4a
                    L49:
                        r2 = r3
                    L4a:
                        boolean r6 = r6.s()
                        r6 = r6 ^ r3
                        if (r2 == 0) goto L54
                        if (r6 == 0) goto L54
                        r4 = r3
                    L54:
                        java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r4)
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L61
                        return r1
                    L61:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.c.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new d(new C1122c(C18039nz0.a.d())));
                a aVar = new a(CallService.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(aVar, this) == objE) {
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC9336Zm4 interfaceC9336Zm4A = C18039nz0.a.a();
            do {
                value = interfaceC9336Zm4A.getValue();
                ((Number) value).doubleValue();
            } while (!interfaceC9336Zm4A.f(value, AbstractC6392Nk0.b(-1.0d)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                TN tn = this.c.audioManagerCompat;
                if (tn != null) {
                    AbstractC6392Nk0.a(tn.l());
                }
                C21250tN audioDeviceSelector = this.c.getAudioDeviceSelector();
                if (audioDeviceSelector != null) {
                    audioDeviceSelector.Q(false);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                try {
                    TN tn = CallService.this.audioManagerCompat;
                    if (tn != null) {
                        tn.p(3);
                    }
                } catch (Exception e) {
                    C19406qI3.j("CallService", "configureDeviceForCall: " + e.getMessage(), new Object[0]);
                }
                WM3 wm3C = C12366eV1.c();
                a aVar = new a(CallService.this, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C17448mz0 c17448mz0;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(30000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C19406qI3.a("CallService", "AllUsersLeftJob executed", new Object[0]);
            InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
            do {
                value = interfaceC9336Zm4H.getValue();
                c17448mz0 = (C17448mz0) value;
            } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.m, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
            C08 c08 = CallService.this.voiceCallSwitch;
            if (c08 != null) {
                c08.e(CallService.this.t0(), K04.CallDiscardReason_HANGUP);
            }
            if (CallService.this.d0()) {
                CallService.this.N1();
            } else {
                CallService.this.M1();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class g implements Y08 {
        final /* synthetic */ InterfaceC20315ro1 a;
        final /* synthetic */ CallService b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.i1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.j1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;
            final /* synthetic */ Exception d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(CallService callService, Exception exc, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
                this.d = exc;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.k1(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.l1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;
            final /* synthetic */ Exception d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(CallService callService, Exception exc, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
                this.d = exc;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new e(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.n1(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ long c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new f(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
                long j = this.c;
                while (true) {
                    Object value = interfaceC9336Zm4H.getValue();
                    C17448mz0 c17448mz0 = (C17448mz0) value;
                    long j2 = j;
                    if (interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : j, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : c17448mz0.e() == C17448mz0.a.a ? C17448mz0.a.b : c17448mz0.e(), (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                        return C19938rB7.a;
                    }
                    j = j2;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.features.call.service.CallService$g$g, reason: collision with other inner class name */
        static final class C1125g extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1125g(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1125g(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17448mz0.a aVar = this.c.callStateBeforeReconnect;
                if (aVar != null) {
                    InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
                    while (true) {
                        Object value = interfaceC9336Zm4H.getValue();
                        C17448mz0 c17448mz0 = (C17448mz0) value;
                        InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
                        if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : aVar, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                            break;
                        }
                        interfaceC9336Zm4H = interfaceC9336Zm4;
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1125g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            h(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new h(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                C17448mz0 c17448mz0;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
                CallService callService = this.c;
                do {
                    value = interfaceC9336Zm4H.getValue();
                    c17448mz0 = (C17448mz0) value;
                    callService.callStateBeforeReconnect = c17448mz0.e();
                } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.h, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;
            final /* synthetic */ C22376v78 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(CallService callService, C22376v78 c22376v78, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
                this.d = c22376v78;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new i(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C15838kG c15838kGR0 = this.c.r0();
                    C22376v78 c22376v78 = this.d;
                    this.b = 1;
                    if (c15838kGR0.a(c22376v78, this) == objE) {
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
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20315ro1 interfaceC20315ro1, CallService callService) {
            this.a = interfaceC20315ro1;
            this.b = callService;
        }

        @Override // ir.nasim.Y08
        public void a() {
            this.b.lastConnectToRoomTimeEventMs = System.currentTimeMillis();
        }

        @Override // ir.nasim.Y08
        public void b(long j) {
            AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new f(j, null), 2, null);
        }

        @Override // ir.nasim.Y08
        public void c(C22376v78 c22376v78) {
            AbstractC13042fc3.i(c22376v78, "webSocketRoomState");
            AbstractC10533bm0.d(this.a, null, null, new i(this.b, c22376v78, null), 3, null);
        }

        @Override // ir.nasim.Y08
        public void d(Exception exc) {
            AbstractC13042fc3.i(exc, "exception");
            AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new c(this.b, exc, null), 2, null);
        }

        @Override // ir.nasim.Y08
        public void e() {
            AbstractC10533bm0.d(this.a, null, null, new C1125g(this.b, null), 3, null);
            Q12.a aVar = Q12.b;
            long jD = Q12.D(T12.t(System.currentTimeMillis() - this.b.lastReconnectTimeEventMs, W12.d));
            CallService callService = this.b;
            callService.A1(jD, callService.t0(), this.b.w0());
            C5074Hu0.a.f(this.b.t0(), this.b.lastReconnectTimeEventMs, System.currentTimeMillis());
        }

        @Override // ir.nasim.Y08
        public void f() {
            AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new a(this.b, null), 2, null);
        }

        @Override // ir.nasim.Y08
        public void g(Exception exc) {
            AbstractC13042fc3.i(exc, "exception");
            AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new e(this.b, exc, null), 2, null);
        }

        @Override // ir.nasim.Y08
        public void h() {
            AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new b(this.b, null), 2, null);
        }

        @Override // ir.nasim.Y08
        public void i() {
            AbstractC10533bm0.d(this.a, C12366eV1.c(), null, new d(this.b, null), 2, null);
            Q12.a aVar = Q12.b;
            long jD = Q12.D(T12.t(System.currentTimeMillis() - this.b.lastConnectToRoomTimeEventMs, W12.d));
            CallService callService = this.b;
            callService.B1(jD, callService.t0(), this.b.w0());
            C5074Hu0.a.e(this.b.t0(), jD, true);
            if (((C17448mz0) C18039nz0.a.d().getValue()).o()) {
                this.b.m1();
            }
        }

        @Override // ir.nasim.Y08
        public void j() {
            this.b.lastReconnectTimeEventMs = System.currentTimeMillis();
            AbstractC10533bm0.d(this.a, null, null, new h(this.b, null), 3, null);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11458d25 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C11458d25 c11458d25, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11458d25;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4G = C18039nz0.a.g();
                C10857cJ7 c10857cJ7 = new C10857cJ7(EnumC21689ty0.a, this.c);
                this.b = 1;
                if (interfaceC8327Vm4G.a(c10857cJ7, this) == objE) {
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            /* renamed from: ir.nasim.features.call.service.CallService$i$a$a, reason: collision with other inner class name */
            static final class C1126a implements InterfaceC4806Gq2 {
                final /* synthetic */ CallService a;

                C1126a(CallService callService) {
                    this.a = callService;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                    C19406qI3.a("CallService", "current call state : " + c17448mz0 + Separators.SP, new Object[0]);
                    this.a.g0(c17448mz0);
                    this.a.f0(c17448mz0);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C17448mz0.a y(C17448mz0 c17448mz0) {
                return c17448mz0.e();
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C18039nz0.a.d(), new UA2() { // from class: ir.nasim.features.call.service.a
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return CallService.i.a.y((C17448mz0) obj2);
                        }
                    });
                    C1126a c1126a = new C1126a(this.c);
                    this.b = 1;
                    if (interfaceC4557Fq2X.b(c1126a, this) == objE) {
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ CallService d;

                /* renamed from: ir.nasim.features.call.service.CallService$i$b$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C1127a {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC23259wd1.values().length];
                        try {
                            iArr[EnumC23259wd1.a.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[EnumC23259wd1.b.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[EnumC23259wd1.c.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[EnumC23259wd1.d.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = callService;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = obj;
                    return aVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    int i = C1127a.a[((EnumC23259wd1) this.c).ordinal()];
                    if (i == 1 || i == 2) {
                        if (this.d.lastPoorConnectionTimeEventMs != 0) {
                            Q12.a aVar = Q12.b;
                            long jD = Q12.D(T12.t(System.currentTimeMillis() - this.d.lastPoorConnectionTimeEventMs, W12.d));
                            CallService callService = this.d;
                            callService.D1(jD, callService.t0(), this.d.w0());
                            C5074Hu0.a.c(this.d.t0(), this.d.lastPoorConnectionTimeEventMs, System.currentTimeMillis());
                        }
                        this.d.lastPoorConnectionTimeEventMs = 0L;
                    } else if (i == 3) {
                        this.d.lastPoorConnectionTimeEventMs = System.currentTimeMillis();
                    } else if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(EnumC23259wd1 enumC23259wd1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(enumC23259wd1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.features.call.service.CallService$i$b$b, reason: collision with other inner class name */
            public static final class C1128b extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                private /* synthetic */ Object c;
                /* synthetic */ Object d;

                public C1128b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                        d dVar = new d((InterfaceC4557Fq2) this.d);
                        this.b = 1;
                        if (AbstractC6459Nq2.A(interfaceC4806Gq2, dVar, this) == objE) {
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
                public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1128b c1128b = new C1128b(interfaceC20295rm1);
                    c1128b.c = interfaceC4806Gq2;
                    c1128b.d = obj;
                    return c1128b.invokeSuspend(C19938rB7.a);
                }
            }

            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.features.call.service.CallService$i$b$c$a$a, reason: collision with other inner class name */
                    public static final class C1129a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1129a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.features.call.service.CallService.i.b.c.a.C1129a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.features.call.service.CallService$i$b$c$a$a r0 = (ir.nasim.features.call.service.CallService.i.b.c.a.C1129a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.features.call.service.CallService$i$b$c$a$a r0 = new ir.nasim.features.call.service.CallService$i$b$c$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L47
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                            ir.nasim.Fq2 r5 = r5.h()
                            if (r5 == 0) goto L47
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L47
                            return r1
                        L47:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.i.b.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            public static final class d implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.features.call.service.CallService$i$b$d$a$a, reason: collision with other inner class name */
                    public static final class C1130a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1130a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.features.call.service.CallService.i.b.d.a.C1130a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.features.call.service.CallService$i$b$d$a$a r0 = (ir.nasim.features.call.service.CallService.i.b.d.a.C1130a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.features.call.service.CallService$i$b$d$a$a r0 = new ir.nasim.features.call.service.CallService$i$b$d$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.M26 r5 = (ir.nasim.M26) r5
                            ir.nasim.wd1 r5 = r5.d()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.i.b.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2S0 = AbstractC6459Nq2.s0(new c(C18039nz0.a.h()), new C1128b(null));
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2S0, aVar, this) == objE) {
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
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ CallService c;

            static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                Object b;
                int c;
                /* synthetic */ Object d;
                /* synthetic */ Object e;
                final /* synthetic */ CallService f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                    this.f = callService;
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009c -> B:26:0x009d). Please report as a decompilation issue!!! */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                    /*
                        r6 = this;
                        java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                        int r1 = r6.c
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L3e
                        if (r1 == r4) goto L32
                        if (r1 == r3) goto L2a
                        if (r1 != r2) goto L22
                        java.lang.Object r1 = r6.b
                        java.util.Collection r1 = (java.util.Collection) r1
                        java.lang.Object r3 = r6.e
                        java.util.Iterator r3 = (java.util.Iterator) r3
                        java.lang.Object r4 = r6.d
                        java.util.Collection r4 = (java.util.Collection) r4
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L9d
                    L22:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L2a:
                        java.lang.Object r1 = r6.d
                        java.util.List r1 = (java.util.List) r1
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L6e
                    L32:
                        java.lang.Object r1 = r6.e
                        java.util.List r1 = (java.util.List) r1
                        java.lang.Object r4 = r6.d
                        java.util.List r4 = (java.util.List) r4
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L5e
                    L3e:
                        ir.nasim.AbstractC10685c16.b(r7)
                        java.lang.Object r7 = r6.d
                        java.util.List r7 = (java.util.List) r7
                        java.lang.Object r1 = r6.e
                        java.util.List r1 = (java.util.List) r1
                        ir.nasim.features.call.service.CallService r5 = r6.f
                        ir.nasim.features.call.service.CallService.F(r5, r7, r1)
                        ir.nasim.features.call.service.CallService r5 = r6.f
                        r6.d = r7
                        r6.e = r1
                        r6.c = r4
                        java.lang.Object r4 = ir.nasim.features.call.service.CallService.b0(r5, r7, r1, r6)
                        if (r4 != r0) goto L5d
                        return r0
                    L5d:
                        r4 = r7
                    L5e:
                        ir.nasim.features.call.service.CallService r7 = r6.f
                        r6.d = r1
                        r5 = 0
                        r6.e = r5
                        r6.c = r3
                        java.lang.Object r7 = ir.nasim.features.call.service.CallService.a0(r7, r4, r1, r6)
                        if (r7 != r0) goto L6e
                        return r0
                    L6e:
                        java.lang.Iterable r1 = (java.lang.Iterable) r1
                        java.util.ArrayList r7 = new java.util.ArrayList
                        r3 = 10
                        int r3 = ir.nasim.ZW0.x(r1, r3)
                        r7.<init>(r3)
                        java.util.Iterator r1 = r1.iterator()
                        r3 = r1
                        r1 = r7
                    L81:
                        boolean r7 = r3.hasNext()
                        if (r7 == 0) goto La4
                        java.lang.Object r7 = r3.next()
                        ir.nasim.Fq2 r7 = (ir.nasim.InterfaceC4557Fq2) r7
                        r6.d = r1
                        r6.e = r3
                        r6.b = r1
                        r6.c = r2
                        java.lang.Object r7 = ir.nasim.AbstractC6459Nq2.G(r7, r6)
                        if (r7 != r0) goto L9c
                        return r0
                    L9c:
                        r4 = r1
                    L9d:
                        ir.nasim.M26 r7 = (ir.nasim.M26) r7
                        r1.add(r7)
                        r1 = r4
                        goto L81
                    La4:
                        java.util.List r1 = (java.util.List) r1
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.i.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.f, interfaceC20295rm1);
                    aVar.d = list;
                    aVar.e = list2;
                    return aVar.invokeSuspend(C19938rB7.a);
                }
            }

            public static final class b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.features.call.service.CallService$i$c$b$a$a, reason: collision with other inner class name */
                    public static final class C1131a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1131a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.features.call.service.CallService.i.c.b.a.C1131a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.features.call.service.CallService$i$c$b$a$a r0 = (ir.nasim.features.call.service.CallService.i.c.b.a.C1131a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.features.call.service.CallService$i$c$b$a$a r0 = new ir.nasim.features.call.service.CallService$i$c$b$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L48
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            r2 = r5
                            ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                            ir.nasim.Fq2 r2 = r2.k()
                            if (r2 == 0) goto L48
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L48
                            return r1
                        L48:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.i.c.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.features.call.service.CallService$i$c$c, reason: collision with other inner class name */
            public static final class C1132c extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                private /* synthetic */ Object c;
                /* synthetic */ Object d;

                public C1132c(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                        InterfaceC4557Fq2 interfaceC4557Fq2K = ((C17448mz0) this.d).k();
                        AbstractC13042fc3.f(interfaceC4557Fq2K);
                        this.b = 1;
                        if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2K, this) == objE) {
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
                public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1132c c1132c = new C1132c(interfaceC20295rm1);
                    c1132c.c = interfaceC4806Gq2;
                    c1132c.d = obj;
                    return c1132c.invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(CallService callService, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = callService;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2J0 = AbstractC6459Nq2.j0(AbstractC6459Nq2.s0(new b(C18039nz0.a.h()), new C1132c(null)), AbstractC10360bX0.m(), new a(this.c, null));
                    this.b = 1;
                    if (AbstractC6459Nq2.k(interfaceC4557Fq2J0, this) == objE) {
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
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = CallService.this.new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(CallService.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(CallService.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(CallService.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            CallService callService;
            String name;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                CallService callService2 = CallService.this;
                InterfaceC11621dJ7 interfaceC11621dJ7D0 = callService2.D0();
                long jF = AbstractC5969Lp4.f();
                this.b = callService2;
                this.c = 1;
                Object objA = interfaceC11621dJ7D0.a(jF, this);
                if (objA == objE) {
                    return objE;
                }
                callService = callService2;
                obj = objA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                callService = (CallService) this.b;
                AbstractC10685c16.b(obj);
            }
            C17637nI7 c17637nI7 = (C17637nI7) obj;
            if (c17637nI7 == null || (name = c17637nI7.getName()) == null) {
                name = CallService.this.myName;
            }
            callService.myName = name;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ TN c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(TN tn, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = tn;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                this.c.p(0);
            } catch (Exception e) {
                C19406qI3.j("CallService", "restoreDeviceAudioState: " + e.getMessage(), new Object[0]);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
            do {
                value = interfaceC9336Zm4H.getValue();
            } while (!interfaceC9336Zm4H.f(value, new C17448mz0(null, 0L, null, null, null, null, null, false, null, null, null, false, 4095, null)));
            AbstractC20906so1.d(CallService.this.getServiceScope(), null, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class m extends MediaSessionCompat.b {
        m() {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public boolean r(Intent intent) {
            AbstractC13042fc3.i(intent, "mediaButtonIntent");
            return C21352tW3.h(intent);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new n(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            do {
                InterfaceC9336Zm4 interfaceC9336Zm4A = C18039nz0.a.a();
                do {
                    value = interfaceC9336Zm4A.getValue();
                } while (!interfaceC9336Zm4A.f(value, AbstractC6392Nk0.b(((Number) value).doubleValue() + 1)));
                this.b = 1;
            } while (HG1.b(1000L, this) != objE);
            return objE;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(90000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C19406qI3.a("CallService", "stopCallJob executed", new Object[0]);
            if (((C17448mz0) C18039nz0.a.d().getValue()).m()) {
                CallService.this.d1();
            } else {
                CallService.this.e1();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(3000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            CallService.this.E1(null);
            CallService.this.M1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.features.call.service.CallService$q$a$a, reason: collision with other inner class name */
            public static final class C1133a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.call.service.CallService$q$a$a$a, reason: collision with other inner class name */
                public static final class C1134a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1134a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1133a.this.a(null, this);
                    }
                }

                public C1133a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.features.call.service.CallService.q.a.C1133a.C1134a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.call.service.CallService$q$a$a$a r0 = (ir.nasim.features.call.service.CallService.q.a.C1133a.C1134a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.call.service.CallService$q$a$a$a r0 = new ir.nasim.features.call.service.CallService$q$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.M26 r5 = (ir.nasim.M26) r5
                        boolean r5 = r5.s()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.q.a.C1133a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1133a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return CallService.this.new q(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r5)
                goto L46
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ir.nasim.AbstractC10685c16.b(r5)
                goto L30
            L1e:
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.nz0 r5 = ir.nasim.C18039nz0.a
                ir.nasim.Zm4 r5 = r5.h()
                r4.b = r3
                java.lang.Object r5 = ir.nasim.AbstractC6459Nq2.G(r5, r4)
                if (r5 != r0) goto L30
                return r0
            L30:
                ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                ir.nasim.Fq2 r5 = r5.h()
                if (r5 == 0) goto L4d
                ir.nasim.features.call.service.CallService$q$a r1 = new ir.nasim.features.call.service.CallService$q$a
                r1.<init>(r5)
                r4.b = r2
                java.lang.Object r5 = ir.nasim.AbstractC6459Nq2.G(r1, r4)
                if (r5 != r0) goto L46
                return r0
            L46:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                goto L4e
            L4d:
                r5 = 0
            L4e:
                ir.nasim.features.call.service.CallService r0 = ir.nasim.features.call.service.CallService.this
                ir.nasim.C08 r0 = ir.nasim.features.call.service.CallService.D(r0)
                if (r0 == 0) goto L5a
                r5 = r5 ^ r3
                r0.h(r5)
            L5a:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class r extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return CallService.this.P1(null, null, this);
        }
    }

    static final class s extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        /* synthetic */ Object i;
        int k;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= RecyclerView.UNDEFINED_DURATION;
            return CallService.this.Q1(null, null, this);
        }
    }

    public CallService() {
        f1();
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(long duration, long callId, C8942Xx0 callPeer) {
        z1(8, duration, callId, callPeer);
    }

    private final InterfaceC13730gj3 B0() {
        return (InterfaceC13730gj3) this.stopCallJob.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(long duration, long callId, C8942Xx0 callPeer) {
        z1(1, duration, callId, callPeer);
    }

    private final void C1() {
        C20384rv0.a.U(t0());
        W0(AbstractC5969Lp4.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(long duration, long callId, C8942Xx0 callPeer) {
        z1(7, duration, callId, callPeer);
    }

    private final void F1(C8942Xx0 callPeer) {
        startForeground(202, C5335Ix0.a.A(this, callPeer, t0(), false, new UA2() { // from class: ir.nasim.cz0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return CallService.G1(this.a, (Notification) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G1(CallService callService, Notification notification) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(notification, "it");
        callService.startForeground(202, notification);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(List accumulator, List newValue) {
        if (!newValue.isEmpty() || !(!accumulator.isEmpty()) || ((C17448mz0) C18039nz0.a.h().getValue()).m()) {
            if (!newValue.isEmpty()) {
                C19406qI3.a("CallService", "cancel AllUsersLeftJob", new Object[0]);
                InterfaceC13730gj3 interfaceC13730gj3 = this.stopCallIfUsersLeftJob;
                if (interfaceC13730gj3 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                    return;
                }
                return;
            }
            return;
        }
        InterfaceC13730gj3 interfaceC13730gj32 = this.stopCallIfUsersLeftJob;
        if ((interfaceC13730gj32 != null && interfaceC13730gj32.isCancelled()) || this.stopCallIfUsersLeftJob == null) {
            this.stopCallIfUsersLeftJob = i0();
        }
        C19406qI3.a("CallService", "start AllUsersLeftJob", new Object[0]);
        InterfaceC13730gj3 interfaceC13730gj33 = this.stopCallIfUsersLeftJob;
        if (interfaceC13730gj33 != null) {
            interfaceC13730gj33.start();
        }
    }

    private final void H1(C8942Xx0 callPeer) {
        startForeground(203, C5335Ix0.a.F(this, callPeer, false, new UA2() { // from class: ir.nasim.bz0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return CallService.I1(this.a, (Notification) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I1(CallService callService, Notification notification) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(notification, "it");
        callService.startForeground(203, notification);
        return C19938rB7.a;
    }

    private final void J1() {
        if (this.timerJob == null) {
            this.timerJob = AbstractC10533bm0.d(this.serviceScope, null, null, new n(null), 3, null);
        }
    }

    private final void K1(C11458d25 peer) {
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.p(peer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "it");
        C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.h().getValue()).d();
        AbstractC13042fc3.f(c8942Xx0D);
        callService.H1(c8942Xx0D);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC13730gj3 L1(CallService callService) {
        AbstractC13042fc3.i(callService, "this$0");
        return AbstractC10533bm0.d(callService.serviceScope, null, null, callService.new o(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "it");
        C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.h().getValue()).d();
        AbstractC13042fc3.f(c8942Xx0D);
        callService.H1(c8942Xx0D);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        C19406qI3.a("CallService", "stopCallService", new Object[0]);
        InterfaceC13730gj3 interfaceC13730gj3 = this.stopCallServiceJob;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        G0(C17448mz0.a.n);
        n0();
        stopForeground(true);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        callService.H1(c8942Xx0);
        C11458d25 c11458d25R = C11458d25.r(c8942Xx0.b());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        callService.K1(c11458d25R);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1() {
        if (this.stopCallServiceJob == null) {
            x0().h();
            this.stopCallServiceJob = AbstractC10533bm0.d(this.serviceScope, null, null, new p(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O0(CallService callService, C8942Xx0 c8942Xx0, long j2) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        callService.H1(c8942Xx0);
        C11458d25 c11458d25R = C11458d25.r(j2);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        callService.K1(c11458d25R);
        return C19938rB7.a;
    }

    private final void O1() {
        AbstractC10533bm0.d(this.serviceScope, null, null, new q(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P0(CallService callService, C8942Xx0 c8942Xx0, List list) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        AbstractC13042fc3.i(list, "users");
        callService.H1(c8942Xx0);
        C08 c08 = callService.voiceCallSwitch;
        if (c08 != null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(C11458d25.r(((Number) it.next()).longValue()));
            }
            c08.d(arrayList);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:23:0x0086). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P1(java.util.List r10, java.util.List r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.P1(java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        callService.F1(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:32:0x00de, B:38:0x00fd], limit reached: 46 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0074 -> B:20:0x0094). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b9 -> B:26:0x00c0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q1(java.util.List r13, java.util.List r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.Q1(java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        callService.F1(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        callService.H1(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "it");
        callService.H1(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U0(CallService callService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(callService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "it");
        C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.h().getValue()).d();
        AbstractC13042fc3.f(c8942Xx0D);
        callService.H1(c8942Xx0D);
        return C19938rB7.a;
    }

    private final void V0(Intent intent, UA2 onReadyToShowNotification) {
        Object value;
        C17448mz0 c17448mz0;
        C8942Xx0 c8942Xx0A = AbstractC9559aA0.a(intent.getIntExtra("CALL_GROUP_ID_INT", 0));
        long longExtra = intent.getLongExtra("call_id", 0L);
        boolean booleanExtra = intent.getBooleanExtra("AM_I_INITIATOR_GROUP_CALL", false);
        String stringExtra = intent.getStringExtra("CALL_LINK");
        String stringExtra2 = intent.getStringExtra("EXTRA_CALL_TITLE");
        long longExtra2 = intent.getLongExtra("EXTRA_CALL_START_TIME", 0L);
        long longExtra3 = intent.getLongExtra("EXTRA_CALL_INITIATOR_USER_ID", 0L);
        boolean booleanExtra2 = intent.getBooleanExtra("EXTRA_IS_VOICE_MUTED", false);
        boolean booleanExtra3 = intent.getBooleanExtra("EXTRA_IS_VIDEO_MUTED", true);
        boolean booleanExtra4 = intent.getBooleanExtra("EXTRA_IS_VIDEO_FRONT_CAMERA", true);
        AbstractC7031Pz0.f fVar = new AbstractC7031Pz0.f((stringExtra == null || AbstractC20762sZ6.n0(stringExtra)) ^ true ? AbstractC12895fM2.a.a : AbstractC12895fM2.b.a, booleanExtra, Long.valueOf(longExtra3), stringExtra, stringExtra2, Long.valueOf(longExtra2));
        this.start = System.currentTimeMillis();
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0A, (4091 & 2) != 0 ? c17448mz0.b : longExtra, (4091 & 4) != 0 ? c17448mz0.c : fVar, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.f, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        x0().g();
        C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.h().getValue()).d();
        AbstractC13042fc3.f(c8942Xx0D);
        onReadyToShowNotification.invoke(c8942Xx0D);
        h0();
        q1();
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.i(longExtra, this.myName, booleanExtra2, booleanExtra3, booleanExtra4);
        }
    }

    private final void W0(int senderId) {
        AbstractC10533bm0.d(this.serviceScope, null, null, new h(new C11458d25(W25.a, senderId), null), 3, null);
    }

    private final void Y0() {
        try {
            Object systemService = getSystemService("power");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, "bale:voip");
            wakeLockNewWakeLock.acquire(600000L);
            this.cpuWakelock = wakeLockNewWakeLock;
        } catch (Exception e2) {
            C19406qI3.a("CallService", "Failure on keep call screen on: " + e2.getMessage(), new Object[0]);
        }
    }

    private final void Z0() {
        this.telephonyManagerCompat = InterfaceC18490ok7.a.b(InterfaceC18490ok7.a, this, false, new UA2() { // from class: ir.nasim.Zy0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return CallService.a1(this.a, ((Integer) obj).intValue());
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a1(CallService callService, int i2) {
        AbstractC13042fc3.i(callService, "this$0");
        C19406qI3.a("CallService", "Telephony state : " + i2, new Object[0]);
        if (i2 == 2) {
            C19406qI3.a("CallService", "Telephony call in progress, hang up call", new Object[0]);
            callService.X0();
        }
        return C19938rB7.a;
    }

    private final boolean b1() {
        return AbstractC13042fc3.d(((C17448mz0) C18039nz0.a.h().getValue()).f(), AbstractC7031Pz0.c.b);
    }

    private final void c0() {
        AbstractC10533bm0.d(this.serviceScope, null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d0() {
        C18039nz0 c18039nz0 = C18039nz0.a;
        int i2 = b.a[((C17448mz0) c18039nz0.h().getValue()).e().ordinal()];
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            return true;
        }
        return i2 != 5 ? i2 == 6 && ((C17448mz0) c18039nz0.h().getValue()).i() != null : y0() instanceof AbstractC7031Pz0.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1() {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.k, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.b(t0(), true);
        }
        M1();
    }

    private final void e0() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.timerJob;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.timerJob = null;
        AbstractC10533bm0.d(this.serviceScope, null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.k, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.e(t0(), K04.CallDiscardReason_MISSED);
        }
        if (d0()) {
            N1();
        } else {
            M1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(C17448mz0 callServiceState) {
        C08 c08;
        if (b.a[callServiceState.e().ordinal()] != 1 || (c08 = this.voiceCallSwitch) == null) {
            return;
        }
        c08.q(callServiceState.c());
    }

    private final InterfaceC13730gj3 f1() {
        return AbstractC10533bm0.d(this.serviceScope, null, null, new i(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(C17448mz0 callServiceState) {
        int i2 = b.a[callServiceState.e().ordinal()];
        if (i2 == 1) {
            if (callServiceState.m()) {
                B0().start();
                return;
            }
            return;
        }
        if (i2 == 7) {
            C19406qI3.a("CallService", "start stopCallJob | job cancelled status => " + B0().isCancelled(), new Object[0]);
            B0().start();
            return;
        }
        if (i2 != 8) {
            return;
        }
        InterfaceC13730gj3.a.a(B0(), null, 1, null);
        C19406qI3.a("CallService", "stopCallJob cancelled " + B0() + " | job cancelled status => " + B0().isCancelled(), new Object[0]);
    }

    private final void g1(long callId) {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC13730gj3.a.a(B0(), null, 1, null);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : callId, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    private final void h0() {
        AbstractC10533bm0.d(this.serviceScope, null, null, new e(null), 3, null);
    }

    private final void h1(EnumC12029dv0 discardReason, int callDuration) {
        C19406qI3.a("CallService", "onCallDiscarded reason: " + discardReason + ", duration: " + callDuration, new Object[0]);
        int i2 = discardReason == null ? -1 : b.c[discardReason.ordinal()];
        C17448mz0.a aVar = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? C17448mz0.a.n : C17448mz0.a.l : callDuration <= 0 ? C17448mz0.a.j : C17448mz0.a.n : C17448mz0.a.m : C17448mz0.a.k;
        C19406qI3.a("CallService", "onCallDiscarded callState: " + aVar, new Object[0]);
        G0(aVar);
        n0();
        if (d0()) {
            N1();
        } else {
            M1();
        }
    }

    private final InterfaceC13730gj3 i0() {
        return AbstractC10533bm0.d(this.serviceScope, null, EnumC23959xo1.LAZY, new f(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1() {
        x0().c();
        p0(false);
    }

    private final C21250tN j0(TN audioManagerCompat) {
        Context applicationContext = getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        return new C21250tN(applicationContext, audioManagerCompat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        Object value;
        C17448mz0 c17448mz0;
        J1();
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.g, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        this.callStateBeforeReconnect = null;
        if (y0() instanceof AbstractC7031Pz0.g) {
            x0().h();
        }
        x0().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k1(java.lang.Exception r20) {
        /*
            r19 = this;
            r0 = r20
            boolean r1 = r0 instanceof ir.nasim.core.network.RpcException
            r2 = 0
            if (r1 == 0) goto La
            ir.nasim.core.network.RpcException r0 = (ir.nasim.core.network.RpcException) r0
            goto Lb
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto L11
            java.lang.String r2 = r0.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String()
        L11:
            if (r2 == 0) goto L4b
            int r0 = r2.hashCode()
            switch(r0) {
                case -1755860558: goto L3f;
                case -1162391220: goto L33;
                case 218278524: goto L27;
                case 1185847733: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L4b
        L1b:
            java.lang.String r0 = "CallFloodWait"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L24
            goto L4b
        L24:
            ir.nasim.OM4$b r0 = ir.nasim.OM4.b.a
            goto L50
        L27:
            java.lang.String r0 = "CallClientDeprecated"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L30
            goto L4b
        L30:
            ir.nasim.OM4$a r0 = ir.nasim.OM4.a.a
            goto L50
        L33:
            java.lang.String r0 = "CallNotApproved"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L3c
            goto L4b
        L3c:
            ir.nasim.OM4$c r0 = ir.nasim.OM4.c.a
            goto L50
        L3f:
            java.lang.String r0 = "RoomLimitReached"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L48
            goto L4b
        L48:
            ir.nasim.OM4$d r0 = ir.nasim.OM4.d.a
            goto L50
        L4b:
            ir.nasim.OM4$g r0 = new ir.nasim.OM4$g
            r0.<init>(r2)
        L50:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onJoinGroupCallFailure: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "CallService"
            ir.nasim.C19406qI3.a(r3, r1, r2)
            ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
            ir.nasim.Zm4 r1 = r1.h()
        L6f:
            java.lang.Object r2 = r1.getValue()
            r3 = r2
            ir.nasim.mz0 r3 = (ir.nasim.C17448mz0) r3
            ir.nasim.mz0$a r8 = ir.nasim.C17448mz0.a.d
            r17 = 4055(0xfd7, float:5.682E-42)
            r18 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r10 = r0
            ir.nasim.mz0 r3 = ir.nasim.C17448mz0.b(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r2 = r1.f(r2, r3)
            if (r2 == 0) goto L6f
            boolean r0 = r19.d0()
            if (r0 == 0) goto L9d
            r19.N1()
            goto La0
        L9d:
            r19.M1()
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.k1(java.lang.Exception):void");
    }

    private final void l0(boolean isFromNotification) {
        C5074Hu0.a.b(isFromNotification, b1());
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.e(t0(), K04.CallDiscardReason_HANGUP);
        }
        M1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        C19406qI3.a("CallService", ">>> onJoinedToRoom in " + (AbstractC20507s76.p() - this.start), new Object[0]);
        if (y0() instanceof AbstractC7031Pz0.g) {
            x0().e();
        }
    }

    private final void m0() {
        M1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        j1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n1(java.lang.Exception r20) {
        /*
            r19 = this;
            r0 = r20
            boolean r1 = r0 instanceof ir.nasim.core.network.RpcException
            r2 = 0
            if (r1 == 0) goto La
            ir.nasim.core.network.RpcException r0 = (ir.nasim.core.network.RpcException) r0
            goto Lb
        La:
            r0 = r2
        Lb:
            if (r0 == 0) goto L11
            java.lang.String r2 = r0.getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String()
        L11:
            if (r2 == 0) goto L57
            int r0 = r2.hashCode()
            switch(r0) {
                case -1755860558: goto L4b;
                case -1162391220: goto L3f;
                case 74450885: goto L33;
                case 218278524: goto L27;
                case 1185847733: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L57
        L1b:
            java.lang.String r0 = "CallFloodWait"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L24
            goto L57
        L24:
            ir.nasim.OM4$b r0 = ir.nasim.OM4.b.a
            goto L5c
        L27:
            java.lang.String r0 = "CallClientDeprecated"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L30
            goto L57
        L30:
            ir.nasim.OM4$a r0 = ir.nasim.OM4.a.a
            goto L5c
        L33:
            java.lang.String r0 = "StartGroupCallPermissionDenied"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L3c
            goto L57
        L3c:
            ir.nasim.OM4$e r0 = ir.nasim.OM4.e.a
            goto L5c
        L3f:
            java.lang.String r0 = "CallNotApproved"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L48
            goto L57
        L48:
            ir.nasim.OM4$c r0 = ir.nasim.OM4.c.a
            goto L5c
        L4b:
            java.lang.String r0 = "RoomLimitReached"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L54
            goto L57
        L54:
            ir.nasim.OM4$d r0 = ir.nasim.OM4.d.a
            goto L5c
        L57:
            ir.nasim.OM4$g r0 = new ir.nasim.OM4$g
            r0.<init>(r2)
        L5c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onOutgoingCallFailure: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "CallService"
            ir.nasim.C19406qI3.a(r3, r1, r2)
            ir.nasim.nz0 r1 = ir.nasim.C18039nz0.a
            ir.nasim.Zm4 r1 = r1.h()
        L7b:
            java.lang.Object r2 = r1.getValue()
            r3 = r2
            ir.nasim.mz0 r3 = (ir.nasim.C17448mz0) r3
            ir.nasim.mz0$a r8 = ir.nasim.C17448mz0.a.d
            r17 = 4055(0xfd7, float:5.682E-42)
            r18 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r10 = r0
            ir.nasim.mz0 r3 = ir.nasim.C17448mz0.b(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r2 = r1.f(r2, r3)
            if (r2 == 0) goto L7b
            boolean r0 = r19.d0()
            if (r0 == 0) goto La9
            r19.N1()
            goto Lac
        La9:
            r19.M1()
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.CallService.n1(java.lang.Exception):void");
    }

    private final void o0() {
        Object value;
        C17448mz0 c17448mz0;
        C08 c08;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.m, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        if (!((C17448mz0) C18039nz0.a.h().getValue()).m() && (c08 = this.voiceCallSwitch) != null) {
            c08.e(t0(), K04.CallDiscardReason_DISCONNECT);
        }
        if (d0()) {
            N1();
        } else {
            M1();
        }
        Q12.a aVar = Q12.b;
        C5074Hu0.a.e(t0(), Q12.D(T12.t(System.currentTimeMillis() - this.lastConnectToRoomTimeEventMs, W12.d)), false);
    }

    private final void o1() {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.c, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    private final void q1() {
        Intent intent = new Intent(this, (Class<?>) CallActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public static /* synthetic */ C8942Xx0 v0(CallService callService, int i2, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallPeer");
        }
        if ((i3 & 2) != 0) {
            str = "";
        }
        return callService.u0(i2, str);
    }

    private final void v1() {
        Intent launchIntentForPackage;
        PendingIntent broadcast = PendingIntent.getBroadcast(getBaseContext(), 0, new Intent("android.intent.action.MEDIA_BUTTON"), 67108864);
        PackageManager packageManager = getPackageManager();
        PendingIntent activity = (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(getPackageName())) == null) ? null : PendingIntent.getActivity(this, 0, launchIntentForPackage, 67108864);
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this, getPackageName(), null, broadcast);
        mediaSessionCompat.f(true);
        mediaSessionCompat.n(activity);
        mediaSessionCompat.g(new m());
        this.mediaSession = mediaSessionCompat;
    }

    private final void w1() {
        this.wasScreenOn = C5161Id6.a.i();
        this.broadcastReceiver = new BroadcastReceiver() { // from class: ir.nasim.features.call.service.CallService$registerScreenOnChangeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (AbstractC13042fc3.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_ON")) {
                    this.a.wasScreenOn = true;
                    return;
                }
                if (AbstractC13042fc3.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_OFF")) {
                    if (((C17448mz0) C18039nz0.a.d().getValue()).e() == C17448mz0.a.e && this.a.wasScreenOn) {
                        this.a.x0().g();
                        this.a.unregisterReceiver(this);
                        this.a.broadcastReceiver = null;
                    }
                    this.a.wasScreenOn = false;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.broadcastReceiver, intentFilter);
    }

    private final void x1() {
        PowerManager.WakeLock wakeLock;
        PowerManager.WakeLock wakeLock2 = this.cpuWakelock;
        if (wakeLock2 == null || !wakeLock2.isHeld() || (wakeLock = this.cpuWakelock) == null) {
            return;
        }
        wakeLock.release();
    }

    private final AbstractC7031Pz0 y0() {
        return ((C17448mz0) C18039nz0.a.d().getValue()).f();
    }

    private final void y1(Intent intent) {
        u1(intent);
        AbstractC13042fc3.f(((C17448mz0) C18039nz0.a.h().getValue()).d());
        C11458d25 c11458d25R = C11458d25.r(r3.b());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        K1(c11458d25R);
    }

    private final void z1(int eventType, long duration, long callId, C8942Xx0 callPeer) {
        Map mapP = AbstractC20051rO3.p(AbstractC4616Fw7.a("action_type", Integer.valueOf(eventType)), AbstractC4616Fw7.a("call_id", Long.valueOf(callId)), AbstractC4616Fw7.a("duration", Long.valueOf(duration)));
        if (callPeer != null) {
            mapP.put("peer_id", Integer.valueOf(callPeer.b()));
            mapP.put("peer_type", Integer.valueOf(callPeer.b() == 0 ? 0 : callPeer.d() ? 2 : 1));
        }
        q0().d("call_action", mapP);
    }

    /* renamed from: A0, reason: from getter */
    protected final InterfaceC20315ro1 getServiceScope() {
        return this.serviceScope;
    }

    /* renamed from: C0, reason: from getter */
    protected final InterfaceC13730gj3 getStopCallServiceJob() {
        return this.stopCallServiceJob;
    }

    public final InterfaceC11621dJ7 D0() {
        InterfaceC11621dJ7 interfaceC11621dJ7 = this.userRepository;
        if (interfaceC11621dJ7 != null) {
            return interfaceC11621dJ7;
        }
        AbstractC13042fc3.y("userRepository");
        return null;
    }

    public final C9728aS7 E0() {
        C9728aS7 c9728aS7 = this.versionCodeNumber;
        if (c9728aS7 != null) {
            return c9728aS7;
        }
        AbstractC13042fc3.y("versionCodeNumber");
        return null;
    }

    protected final void E1(InterfaceC13730gj3 interfaceC13730gj3) {
        this.stopCallServiceJob = interfaceC13730gj3;
    }

    public final C21786u78 F0() {
        C21786u78 c21786u78 = this.webRtcStatsRepository;
        if (c21786u78 != null) {
            return c21786u78;
        }
        AbstractC13042fc3.y("webRtcStatsRepository");
        return null;
    }

    protected void G0(C17448mz0.a callState) {
        AbstractC13042fc3.i(callState, "callState");
        C19406qI3.a("CallService", "goToFinalState with state " + callState, new Object[0]);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
            if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : callState, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                return;
            } else {
                interfaceC9336Zm4H = interfaceC9336Zm4;
            }
        }
    }

    protected final void I0(Intent intent, AbstractC7031Pz0 callType, UA2 onReadyToShowNotification) {
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(callType, "callType");
        AbstractC13042fc3.i(onReadyToShowNotification, "onReadyToShowNotification");
        C8942Xx0 c8942Xx0V0 = v0(this, intent.getIntExtra("user_id", 0), null, 2, null);
        long longExtra = intent.getLongExtra("call_id", 0L);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
            if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0V0, (4091 & 2) != 0 ? c17448mz0.b : longExtra, (4091 & 4) != 0 ? c17448mz0.c : callType, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.e, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                break;
            } else {
                interfaceC9336Zm4H = interfaceC9336Zm4;
            }
        }
        if (intent.getBooleanExtra("notifications_disabled", false)) {
            q1();
        } else {
            onReadyToShowNotification.invoke(c8942Xx0V0);
        }
        x0().d();
    }

    protected final void J0(Intent intent, AbstractC7031Pz0 callType, UA2 onReadyToShowNotification) {
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(callType, "callType");
        AbstractC13042fc3.i(onReadyToShowNotification, "onReadyToShowNotification");
        C8942Xx0 c8942Xx0A = AbstractC9559aA0.a(intent.getIntExtra("CALL_GROUP_ID_INT", 0));
        long longExtra = intent.getLongExtra("call_id", 0L);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
            if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0A, (4091 & 2) != 0 ? c17448mz0.b : longExtra, (4091 & 4) != 0 ? c17448mz0.c : callType, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.e, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                break;
            } else {
                interfaceC9336Zm4H = interfaceC9336Zm4;
            }
        }
        if (intent.getBooleanExtra("notifications_disabled", false)) {
            q1();
        } else {
            onReadyToShowNotification.invoke(c8942Xx0A);
        }
        x0().d();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void K0(Intent intent) throws Exception {
        AbstractC13042fc3.i(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -2078638756:
                    if (action.equals("ACTION_JOIN_VOICE_CALL_FROM_ACTIVITY")) {
                        c1(false, new UA2() { // from class: ir.nasim.dz0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.L0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case -2011961251:
                    if (action.equals("ACTION_START_GROUP_VOICE_CALL_WITH_USERS")) {
                        t1(intent, new AbstractC7031Pz0.h(AbstractC12895fM2.a.a), new InterfaceC14603iB2() { // from class: ir.nasim.hz0
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return CallService.P0(this.a, (C8942Xx0) obj, (List) obj2);
                            }
                        });
                        return;
                    }
                    break;
                case -1963822725:
                    if (action.equals("ACTION_INCOMING_GROUP_VOICE_CALL")) {
                        InterfaceC13730gj3 interfaceC13730gj3 = this.stopCallServiceJob;
                        if (interfaceC13730gj3 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                        }
                        J0(intent, new AbstractC7031Pz0.b(null, 1, null), new UA2() { // from class: ir.nasim.iz0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.Q0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case -1764462741:
                    if (action.equals("ACTION_END_GROUP_CALL")) {
                        C18039nz0 c18039nz0 = C18039nz0.a;
                        if (((C17448mz0) c18039nz0.h().getValue()).f() instanceof AbstractC7031Pz0.h) {
                            AbstractC7031Pz0 abstractC7031Pz0F = ((C17448mz0) c18039nz0.h().getValue()).f();
                            AbstractC13042fc3.g(abstractC7031Pz0F, "null cannot be cast to non-null type ir.nasim.features.call.data.CallType.OutgoingGroupCall");
                            if (((AbstractC7031Pz0.h) abstractC7031Pz0F).d() instanceof AbstractC12895fM2.a) {
                                p0(false);
                                return;
                            }
                        }
                        if (((C17448mz0) c18039nz0.h().getValue()).f() instanceof AbstractC7031Pz0.b) {
                            AbstractC7031Pz0 abstractC7031Pz0F2 = ((C17448mz0) c18039nz0.h().getValue()).f();
                            AbstractC13042fc3.g(abstractC7031Pz0F2, "null cannot be cast to non-null type ir.nasim.features.call.data.CallType.IncomingGroupCall");
                            if (((AbstractC7031Pz0.b) abstractC7031Pz0F2).d() instanceof AbstractC12895fM2.a) {
                                p0(false);
                                return;
                            }
                        }
                        p0(intent.getBooleanExtra("END_FOR_ALL", false));
                        return;
                    }
                    break;
                case -1649568011:
                    if (action.equals("toggle_microphone")) {
                        O1();
                        return;
                    }
                    break;
                case -1277590163:
                    if (action.equals("ACTION_DECLINE_GROUP")) {
                        m0();
                        return;
                    }
                    break;
                case -1229923717:
                    if (action.equals("decline_from_activity")) {
                        l0(false);
                        return;
                    }
                    break;
                case -1058771350:
                    if (action.equals("ACTION_JOIN_GROUP_CALL")) {
                        V0(intent, new UA2() { // from class: ir.nasim.lz0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.T0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case -856671737:
                    if (action.equals("decline_call")) {
                        l0(true);
                        return;
                    }
                    break;
                case -599938471:
                    if (action.equals("ACTION_HANDLE_RECEIVED_REACTION")) {
                        int intExtra = intent.getIntExtra("CALL_REACTION_PEER_ID_INT", 0);
                        if (intExtra != 0) {
                            W0(intExtra);
                            return;
                        }
                        return;
                    }
                    break;
                case -440273762:
                    if (action.equals("stop_incoming_ringtone")) {
                        x0().g();
                        return;
                    }
                    break;
                case -180332724:
                    if (action.equals("ACTION_DESTROY_SERVICE_SWITCH")) {
                        n0();
                        M1();
                        return;
                    }
                    break;
                case 82556698:
                    if (action.equals("outgoing_accepted")) {
                        long longExtra = intent.getLongExtra("call_id", -1L);
                        if (longExtra == -1) {
                            throw new Exception("ACTION_OUTGOING_ACCEPTED should have callId!");
                        }
                        g1(longExtra);
                        return;
                    }
                    break;
                case 108405416:
                    if (action.equals("retry")) {
                        y1(intent);
                        return;
                    }
                    break;
                case 279578585:
                    if (action.equals("incoming_voice")) {
                        InterfaceC13730gj3 interfaceC13730gj32 = this.stopCallServiceJob;
                        if (interfaceC13730gj32 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
                        }
                        I0(intent, AbstractC7031Pz0.e.b, new UA2() { // from class: ir.nasim.jz0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.R0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 371926091:
                    if (action.equals("permission_granted")) {
                        String stringExtra = intent.getStringExtra("extra_granted_permission");
                        if (stringExtra != null) {
                            p1(stringExtra);
                            return;
                        }
                        return;
                    }
                    break;
                case 438844311:
                    if (action.equals("ACTION_JOIN_VOICE_CALL")) {
                        c1(true, new UA2() { // from class: ir.nasim.ez0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.M0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 979345736:
                    if (action.equals("start_voice_call")) {
                        InterfaceC13730gj3 interfaceC13730gj33 = this.stopCallServiceJob;
                        if (interfaceC13730gj33 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj33, null, 1, null);
                        }
                        r1(intent, new AbstractC7031Pz0.k(false, 1, null), new UA2() { // from class: ir.nasim.fz0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.N0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 1175237740:
                    if (action.equals("answer_voice_call")) {
                        r(true, new UA2() { // from class: ir.nasim.Yy0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.U0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 1419172897:
                    if (action.equals("disconnect_call")) {
                        o0();
                        return;
                    }
                    break;
                case 1420362068:
                    if (action.equals("outgoing_received")) {
                        o1();
                        return;
                    }
                    break;
                case 1497312768:
                    if (action.equals("accept_voice_from_activity")) {
                        r(false, new UA2() { // from class: ir.nasim.kz0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return CallService.S0(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 1553892867:
                    if (action.equals("ACTION_SEND_LIKE_REACTION")) {
                        C1();
                        return;
                    }
                    break;
                case 1725037378:
                    if (action.equals("end_call")) {
                        X0();
                        return;
                    }
                    break;
                case 1729625372:
                    if (action.equals("call_discarded")) {
                        Serializable serializableExtra = intent.getSerializableExtra("discard_reason");
                        h1(serializableExtra instanceof EnumC12029dv0 ? (EnumC12029dv0) serializableExtra : null, intent.getIntExtra("call_duration", 0));
                        return;
                    }
                    break;
                case 2112013777:
                    if (action.equals("ACTION_START_GROUP_VOICE_CALL")) {
                        InterfaceC13730gj3 interfaceC13730gj34 = this.stopCallServiceJob;
                        if (interfaceC13730gj34 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj34, null, 1, null);
                        }
                        s1(intent, new AbstractC7031Pz0.h(null, 1, null), new InterfaceC14603iB2() { // from class: ir.nasim.gz0
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return CallService.O0(this.a, (C8942Xx0) obj, ((Long) obj2).longValue());
                            }
                        });
                        return;
                    }
                    break;
            }
        }
        throw new IllegalStateException("Wrong action for call service: " + intent.getAction());
    }

    public final void X0() {
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.e(t0(), K04.CallDiscardReason_HANGUP);
        }
        M1();
    }

    protected final void c1(boolean isFromNotification, UA2 onReadyToShowNotification) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC13042fc3.i(onReadyToShowNotification, "onReadyToShowNotification");
        this.start = System.currentTimeMillis();
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.f, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        x0().g();
        C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.h().getValue()).d();
        AbstractC13042fc3.f(c8942Xx0D);
        onReadyToShowNotification.invoke(c8942Xx0D);
        h0();
        if (isFromNotification) {
            q1();
        }
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            C08.g(c08, t0(), this.myName, false, false, false, 28, null);
        }
    }

    public C08 k0(EnumC13941h47 switchType, Intent intent, InterfaceC20315ro1 serviceScope) {
        AbstractC13042fc3.i(switchType, "switchType");
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(serviceScope, "serviceScope");
        S37 s37 = S37.a;
        Context applicationContext = getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        C8386Vt0 c8386Vt0 = C8386Vt0.a;
        return s37.a(switchType, serviceScope, new g(serviceScope, this), applicationContext, c8386Vt0.rc(), c8386Vt0.i8(), E0(), F0(), z0());
    }

    protected void n0() {
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.onDestroy();
        }
        this.voiceCallSwitch = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // ir.nasim.features.call.service.Hilt_CallService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Y = this;
        TN.c cVar = TN.d;
        Context applicationContext = getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        TN tnB = cVar.b(applicationContext);
        this.audioManagerCompat = tnB;
        C21250tN c21250tNJ0 = j0(tnB);
        this.audioDeviceSelector = c21250tNJ0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
            if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : c21250tNJ0, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                Y0();
                Z0();
                this.callProximityManager = new C21002sy0();
                v1();
                w1();
                AbstractC10533bm0.d(this.serviceScope, null, null, new j(null), 3, null);
                return;
            }
            interfaceC9336Zm4H = interfaceC9336Zm4;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C19406qI3.a("CallService", "onDestroy call service", new Object[0]);
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.onDestroy();
        }
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.e();
        }
        TN tn = this.audioManagerCompat;
        if (tn != null) {
            AbstractC10533bm0.d(this.serviceScope, null, null, new k(tn, null), 3, null);
            tn.q(false);
        }
        BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        C21002sy0 c21002sy0 = this.callProximityManager;
        if (c21002sy0 != null) {
            c21002sy0.b();
        }
        this.callProximityManager = null;
        x0().a();
        TN tn2 = this.audioManagerCompat;
        if (tn2 != null) {
            tn2.b();
        }
        C21250tN c21250tN = this.audioDeviceSelector;
        if (c21250tN != null) {
            c21250tN.G();
        }
        C17448mz0.a aVarE = ((C17448mz0) C18039nz0.a.h().getValue()).e();
        C17448mz0.a aVar = C17448mz0.a.n;
        if (aVarE != aVar) {
            C19406qI3.a("CallService", "current state not finish in onDestroy call service", new Object[0]);
            C08 c082 = this.voiceCallSwitch;
            if (c082 != null) {
                c082.e(t0(), K04.CallDiscardReason_DISCONNECT);
            }
            G0(aVar);
        }
        e0();
        x1();
        InterfaceC18490ok7 interfaceC18490ok7 = this.telephonyManagerCompat;
        if (interfaceC18490ok7 != null) {
            interfaceC18490ok7.a();
        }
        this.mediaSession = null;
        this.voiceCallSwitch = null;
        Y = null;
        this.telephonyManagerCompat = null;
        this.audioManagerCompat = null;
        this.audioDeviceSelector = null;
        this.broadcastReceiver = null;
        this.wasScreenOn = false;
        try {
            stopForeground(true);
        } catch (Exception e2) {
            C19406qI3.a("CallService", "Error in stopForeground: " + e2.getMessage(), new Object[0]);
        }
        AbstractC10533bm0.d(this.serviceScope, null, null, new l(null), 3, null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) throws Exception {
        AbstractC13042fc3.i(intent, "intent");
        if (this.voiceCallSwitch == null) {
            Serializable serializableExtra = intent.getSerializableExtra("switch_type");
            EnumC13941h47 enumC13941h47 = serializableExtra instanceof EnumC13941h47 ? (EnumC13941h47) serializableExtra : null;
            if (enumC13941h47 == null) {
                C19406qI3.j("CallService", "There is a bad situation in onStartCommand, because SWITCH_TYPE is not provided, so we stop service...", new Object[0]);
                M1();
                return 2;
            }
            InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
            while (true) {
                Object value = interfaceC9336Zm4H.getValue();
                C17448mz0 c17448mz0 = (C17448mz0) value;
                InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
                if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : enumC13941h47, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                    break;
                }
                interfaceC9336Zm4H = interfaceC9336Zm4;
            }
            this.voiceCallSwitch = k0(enumC13941h47, intent, this.serviceScope);
        }
        K0(intent);
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        C19406qI3.a("CallService", "onTaskRemoved call service", new Object[0]);
    }

    public final void p0(boolean endForAllUsers) {
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.b(t0(), endForAllUsers);
        }
        M1();
    }

    public final void p1(String grantedPermission) {
        AbstractC13042fc3.i(grantedPermission, "grantedPermission");
        if (AbstractC13042fc3.d(grantedPermission, "android.permission.BLUETOOTH_SCAN") || AbstractC13042fc3.d(grantedPermission, "android.permission.BLUETOOTH_CONNECT")) {
            C21250tN c21250tN = this.audioDeviceSelector;
            if (c21250tN != null) {
                c21250tN.c();
                return;
            }
            return;
        }
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.k(grantedPermission);
        }
    }

    public final C6409Nm q0() {
        C6409Nm c6409Nm = this.analyticsRepository;
        if (c6409Nm != null) {
            return c6409Nm;
        }
        AbstractC13042fc3.y("analyticsRepository");
        return null;
    }

    protected final void r(boolean isFromNotification, UA2 onReadyToShowNotification) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC13042fc3.i(onReadyToShowNotification, "onReadyToShowNotification");
        this.start = System.currentTimeMillis();
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.f, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        x0().g();
        C8942Xx0 c8942Xx0D = ((C17448mz0) C18039nz0.a.h().getValue()).d();
        if (c8942Xx0D == null) {
            C19406qI3.a("CallService", "accepted invalid call peer", new Object[0]);
            return;
        }
        onReadyToShowNotification.invoke(c8942Xx0D);
        h0();
        if (isFromNotification) {
            q1();
        }
        C08 c08 = this.voiceCallSwitch;
        if (c08 != null) {
            c08.o(t0());
        }
        C5074Hu0.a.a(isFromNotification, b1());
    }

    public final C15838kG r0() {
        C15838kG c15838kG = this.applyConnectedRoomStateUserCase;
        if (c15838kG != null) {
            return c15838kG;
        }
        AbstractC13042fc3.y("applyConnectedRoomStateUserCase");
        return null;
    }

    protected final void r1(Intent intent, AbstractC7031Pz0 callType, UA2 onCallPrepared) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(callType, "callType");
        AbstractC13042fc3.i(onCallPrepared, "onCallPrepared");
        Serializable serializableExtra = intent.getSerializableExtra("switch_type");
        EnumC13941h47 enumC13941h47 = serializableExtra instanceof EnumC13941h47 ? (EnumC13941h47) serializableExtra : null;
        if (enumC13941h47 == null) {
            throw new IllegalArgumentException("startOutgoingCall: No switch type is provided!");
        }
        if (b.b[enumC13941h47.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        C8942Xx0 c8942Xx0V0 = v0(this, intent.getIntExtra("user_id", 0), null, 2, null);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0V0, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : callType, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.a, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        h0();
        onCallPrepared.invoke(c8942Xx0V0);
        q1();
    }

    /* renamed from: s0, reason: from getter */
    public final C21250tN getAudioDeviceSelector() {
        return this.audioDeviceSelector;
    }

    protected final void s1(Intent intent, AbstractC7031Pz0 callType, InterfaceC14603iB2 onCallPrepared) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(callType, "callType");
        AbstractC13042fc3.i(onCallPrepared, "onCallPrepared");
        Serializable serializableExtra = intent.getSerializableExtra("switch_type");
        EnumC13941h47 enumC13941h47 = serializableExtra instanceof EnumC13941h47 ? (EnumC13941h47) serializableExtra : null;
        if (enumC13941h47 == null) {
            throw new IllegalArgumentException("startOutgoingCall: No switch type is provided!");
        }
        if (b.b[enumC13941h47.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        C8942Xx0 c8942Xx0A = AbstractC9559aA0.a(intent.getIntExtra("CALL_GROUP_ID_INT", 0));
        long longExtra = intent.getLongExtra("CALL_GROUP_UNIQID_INT", 0L);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0A, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : callType, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.a, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        h0();
        onCallPrepared.invoke(c8942Xx0A, Long.valueOf(longExtra));
        q1();
    }

    public final long t0() {
        return ((C17448mz0) C18039nz0.a.d().getValue()).c();
    }

    protected final void t1(Intent intent, AbstractC7031Pz0 callType, InterfaceC14603iB2 onCallPrepared) {
        List listM;
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(callType, "callType");
        AbstractC13042fc3.i(onCallPrepared, "onCallPrepared");
        Serializable serializableExtra = intent.getSerializableExtra("switch_type");
        EnumC13941h47 enumC13941h47 = serializableExtra instanceof EnumC13941h47 ? (EnumC13941h47) serializableExtra : null;
        if (enumC13941h47 == null) {
            throw new IllegalArgumentException("startOutgoingCall: No switch type is provided!");
        }
        long[] longArrayExtra = intent.getLongArrayExtra("USERS_UNIQ_ID");
        if (longArrayExtra == null || (listM = AbstractC10242bK.e1(longArrayExtra)) == null) {
            listM = AbstractC10360bX0.m();
        }
        if (b.b[enumC13941h47.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        C8942Xx0 c8942Xx0V0 = v0(this, (int) ((Number) AbstractC15401jX0.q0(listM)).longValue(), null, 2, null);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        while (true) {
            Object value = interfaceC9336Zm4H.getValue();
            C17448mz0 c17448mz0 = (C17448mz0) value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = interfaceC9336Zm4H;
            if (interfaceC9336Zm4.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : c8942Xx0V0, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : callType, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.a, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false))) {
                h0();
                onCallPrepared.invoke(c8942Xx0V0, listM);
                q1();
                return;
            }
            interfaceC9336Zm4H = interfaceC9336Zm4;
        }
    }

    protected final C8942Xx0 u0(int userId, String phoneNumber) {
        AbstractC13042fc3.i(phoneNumber, "phoneNumber");
        if (userId == 0) {
            return new C8942Xx0(0, phoneNumber, null, false, 8, null);
        }
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(userId);
        if (c21231tK7 == null) {
            return new C8942Xx0(0, phoneNumber, null, false, 8, null);
        }
        int iO = c21231tK7.o();
        Object objB = c21231tK7.r().b();
        AbstractC13042fc3.h(objB, "get(...)");
        return new C8942Xx0(iO, (String) objB, (Avatar) c21231tK7.h().b(), false, 8, null);
    }

    protected final void u1(Intent intent) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC13042fc3.i(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("switch_type");
        EnumC13941h47 enumC13941h47 = serializableExtra instanceof EnumC13941h47 ? (EnumC13941h47) serializableExtra : null;
        if (enumC13941h47 == null) {
            C19406qI3.j("CallService", "retryPreviousCall return because call switch is null", new Object[0]);
            return;
        }
        InterfaceC13730gj3 interfaceC13730gj3 = this.stopCallServiceJob;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.voiceCallSwitch = k0(enumC13941h47, intent, this.serviceScope);
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : C17448mz0.a.a, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : enumC13941h47, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    public final C8942Xx0 w0() {
        return ((C17448mz0) C18039nz0.a.d().getValue()).d();
    }

    public final C5344Iy0 x0() {
        C5344Iy0 c5344Iy0 = this.callRingtoneHandler;
        if (c5344Iy0 != null) {
            return c5344Iy0;
        }
        AbstractC13042fc3.y("callRingtoneHandler");
        return null;
    }

    public final OkHttpClient z0() {
        OkHttpClient okHttpClient = this.okHttpClient;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        AbstractC13042fc3.y("okHttpClient");
        return null;
    }
}
