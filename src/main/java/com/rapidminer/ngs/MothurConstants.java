package com.rapidminer.ngs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by paskal on 18.09.17.
 */
public final class MothurConstants {

    public final class Commands {
        public static final String TRIM_SEQS = "trim.seqs";
        public static final String SUMMARY_SEQS = "summary.seqs";
        public static final String ALIGN_SEQS = "align.seqs";
        public static final String SCREEN_SEQS = "screen.seqs";
        public static final String FILTER_SEQS = "filter.seqs";
        public static final String UNIQUE_SEQS = "unique.seqs";
        public static final String PRE_CLUSTER = "pre.cluster";
        public static final String CHIMERA_UCHIME = "chimera.uchime";
        public static final String REMOVE_SEQS = "remove.seqs";
        public static final String CLASSIFY_SEQS = "classify.seqs";
        public static final String REMOVE_LINEAGE = "remove.lineage";
        public static final String DIST_SEQS = "dist.seqs";
        public static final String CLUSTER = "cluster";

        private Commands() {}
    }

    public final class Parameters {
//        Files
        public static final String FASTA = "fasta";
        public static final String NAME = "name";
        public static final String GROUPS = "groups";
        public static final String OLIGOS = "oligos";
        public static final String REFERENCE = "reference";

        public static final String MAXHOMOP = "maxhomop";
        public static final String PDIFFS = "pdiffs";
        public static final String BDIFFS = "bdiffs";
        public static final String MINLENGTH = "minlength";
        public static final String PROCESSORS = "processors";

        private Parameters() {}
    }

    private MothurConstants(){};
}
