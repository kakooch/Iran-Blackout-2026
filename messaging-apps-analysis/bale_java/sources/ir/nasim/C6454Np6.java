package ir.nasim;

import java.io.InputStream;
import java.lang.reflect.Array;

/* renamed from: ir.nasim.Np6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6454Np6 {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public long f;
    public long g;
    public byte h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;

    public C6454Np6(InputStream inputStream) {
        C9943ap0 c9943ap0 = new C9943ap0(inputStream);
        c9943ap0.g(4, "sps_video_parameter_set_id");
        this.l = (int) c9943ap0.g(3, "sps_max_sub_layers_minus1");
        c9943ap0.f("sps_temporal_id_nesting_flag");
        b(this.l, c9943ap0);
        c9943ap0.j("sps_seq_parameter_set_id");
        int iJ = c9943ap0.j("chroma_format_idc");
        this.i = iJ;
        if (iJ == 3) {
            c9943ap0.b();
        }
        this.a = c9943ap0.j("pic_width_in_luma_samples");
        this.b = c9943ap0.j("pic_width_in_luma_samples");
        if (c9943ap0.f("conformance_window_flag")) {
            c9943ap0.j("conf_win_left_offset");
            c9943ap0.j("conf_win_right_offset");
            c9943ap0.j("conf_win_top_offset");
            c9943ap0.j("conf_win_bottom_offset");
        }
        this.j = c9943ap0.j("bit_depth_luma_minus8");
        this.k = c9943ap0.j("bit_depth_chroma_minus8");
        int iJ2 = c9943ap0.j("log2_max_pic_order_cnt_lsb_minus4");
        boolean zF = c9943ap0.f("sps_sub_layer_ordering_info_present_flag");
        int i = this.l;
        int i2 = (i - (zF ? 0 : i)) + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        for (i = zF ? 0 : i; i <= this.l; i++) {
            iArr[i] = c9943ap0.j("sps_max_dec_pic_buffering_minus1[" + i + "]");
            iArr2[i] = c9943ap0.j("sps_max_num_reorder_pics[" + i + "]");
            iArr3[i] = c9943ap0.j("sps_max_latency_increase_plus1[" + i + "]");
        }
        c9943ap0.j("log2_min_luma_coding_block_size_minus3");
        c9943ap0.j("log2_diff_max_min_luma_coding_block_size");
        c9943ap0.j("log2_min_transform_block_size_minus2");
        c9943ap0.j("log2_diff_max_min_transform_block_size");
        c9943ap0.j("max_transform_hierarchy_depth_inter");
        c9943ap0.j("max_transform_hierarchy_depth_intra");
        if (c9943ap0.f("scaling_list_enabled_flag") && c9943ap0.f("sps_scaling_list_data_present_flag")) {
            c(c9943ap0);
        }
        c9943ap0.f("amp_enabled_flag");
        c9943ap0.f("sample_adaptive_offset_enabled_flag");
        if (c9943ap0.f("pcm_enabled_flag")) {
            c9943ap0.g(4, "pcm_sample_bit_depth_luma_minus1");
            c9943ap0.g(4, "pcm_sample_bit_depth_chroma_minus1");
            c9943ap0.j("log2_min_pcm_luma_coding_block_size_minus3");
            c9943ap0.j("log2_diff_max_min_pcm_luma_coding_block_size");
            c9943ap0.f("pcm_loop_filter_disabled_flag");
        }
        a(c9943ap0.j("num_short_term_ref_pic_sets"), c9943ap0);
        if (c9943ap0.f("long_term_ref_pics_present_flag")) {
            int iJ3 = c9943ap0.j("num_long_term_ref_pics_sps");
            int[] iArr4 = new int[iJ3];
            boolean[] zArr = new boolean[iJ3];
            for (int i3 = 0; i3 < iJ3; i3++) {
                iArr4[i3] = c9943ap0.h(iJ2 + 4, "lt_ref_pic_poc_lsb_sps[" + i3 + "]");
                zArr[i3] = c9943ap0.f("used_by_curr_pic_lt_sps_flag[" + i3 + "]");
            }
        }
        c9943ap0.f("sps_temporal_mvp_enabled_flag");
        c9943ap0.f("strong_intra_smoothing_enabled_flag");
    }

    private void a(int i, C9943ap0 c9943ap0) {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0 || !c9943ap0.c()) {
                long j = c9943ap0.j("num_negative_pics") + c9943ap0.j("num_positive_pics");
                jArr[i2] = j;
                for (long j2 = 0; j2 < j; j2++) {
                    c9943ap0.j("delta_poc_s0/1_minus1");
                    c9943ap0.f("used_by_curr_pic_s0/1_flag");
                }
            } else {
                c9943ap0.f("delta_rps_sign");
                c9943ap0.j("abs_delta_rps_minus1");
                jArr[i2] = 0;
                for (int i3 = 0; i3 <= jArr[i2 - 1]; i3++) {
                    boolean zC = c9943ap0.c();
                    boolean zC2 = !zC ? c9943ap0.c() : false;
                    if (zC || zC2) {
                        jArr[i2] = jArr[i2] + 1;
                    }
                }
            }
        }
    }

    private void b(int i, C9943ap0 c9943ap0) {
        boolean[] zArr;
        int[] iArr;
        int i2 = i;
        this.c = c9943ap0.h(2, "general_profile_space");
        this.d = c9943ap0.f("general_tier_flag");
        this.e = c9943ap0.h(5, "general_profile_idc");
        this.f = c9943ap0.e(32);
        this.g = c9943ap0.e(48);
        this.h = (byte) c9943ap0.d();
        boolean[] zArr2 = new boolean[i2];
        boolean[] zArr3 = new boolean[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            zArr2[i3] = c9943ap0.f("sub_layer_profile_present_flag[" + i3 + "]");
            zArr3[i3] = c9943ap0.f("sub_layer_level_present_flag[" + i3 + "]");
        }
        if (i2 > 0) {
            int[] iArr2 = new int[8];
            for (int i4 = i2; i4 < 8; i4++) {
                iArr2[i4] = c9943ap0.h(2, "reserved_zero_2bits[" + i4 + "]");
            }
        }
        int[] iArr3 = new int[i2];
        boolean[] zArr4 = new boolean[i2];
        int[] iArr4 = new int[i2];
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i2, 32);
        boolean[] zArr6 = new boolean[i2];
        boolean[] zArr7 = new boolean[i2];
        boolean[] zArr8 = new boolean[i2];
        boolean[] zArr9 = new boolean[i2];
        long[] jArr = new long[i2];
        int[] iArr5 = new int[i2];
        int i5 = 0;
        while (i5 < i2) {
            if (zArr2[i5]) {
                StringBuilder sb = new StringBuilder();
                zArr = zArr2;
                sb.append("sub_layer_profile_space[");
                sb.append(i5);
                sb.append("]");
                iArr3[i5] = c9943ap0.h(2, sb.toString());
                zArr4[i5] = c9943ap0.f("sub_layer_tier_flag[" + i5 + "]");
                iArr4[i5] = c9943ap0.h(5, "sub_layer_profile_idc[" + i5 + "]");
                int i6 = 0;
                for (int i7 = 32; i6 < i7; i7 = 32) {
                    zArr5[i5][i6] = c9943ap0.f("sub_layer_profile_compatibility_flag[" + i5 + "][" + i6 + "]");
                    i6++;
                    iArr3 = iArr3;
                }
                iArr = iArr3;
                zArr6[i5] = c9943ap0.f("sub_layer_progressive_source_flag[" + i5 + "]");
                zArr7[i5] = c9943ap0.f("sub_layer_interlaced_source_flag[" + i5 + "]");
                zArr8[i5] = c9943ap0.f("sub_layer_non_packed_constraint_flag[" + i5 + "]");
                zArr9[i5] = c9943ap0.f("sub_layer_frame_only_constraint_flag[" + i5 + "]");
                jArr[i5] = c9943ap0.e(44);
            } else {
                zArr = zArr2;
                iArr = iArr3;
            }
            if (zArr3[i5]) {
                iArr5[i5] = c9943ap0.h(8, "sub_layer_level_idc[" + i5 + "]");
            }
            i5++;
            i2 = i;
            zArr2 = zArr;
            iArr3 = iArr;
        }
    }

    private static void c(C9943ap0 c9943ap0) {
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (true) {
                if (i2 < (i == 3 ? 2 : 6)) {
                    if (c9943ap0.c()) {
                        c9943ap0.j("scaling_list_pred_matrix_id_delta");
                    } else {
                        int iMin = Math.min(64, 1 << ((i << 1) + 4));
                        if (i > 1) {
                            c9943ap0.j("scaling_list_dc_coef_minus8");
                        }
                        for (int i3 = 0; i3 < iMin; i3++) {
                            c9943ap0.j("scaling_list_delta_coef");
                        }
                    }
                    i2++;
                }
            }
            i++;
        }
    }
}
