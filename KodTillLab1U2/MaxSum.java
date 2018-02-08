
public final class MaxSum {
    // globala, lagrar start och slut pÃ¥ sekvensen
    // jag orkade inte skriva getters fÃ¶r dom men det borde man kanske
    public static int seqStart = 0;
    public static int seqEnd = -1;

    /**
     * contiguous subsequence sum algorithm.
     * seqStart and seqEnd represent the actual best sequence.
     * Version 1
     */
    public static int maxSubSum1( int[] a ) {
        int maxSum = 0;
        for( int i = 0; i < a.length; i++ )
            for( int j = i; j < a.length; j++ ) {
                int thisSum = 0;
                for( int k = i; k <= j; k++ ) {
                    thisSum += a[k];
                }
                if( thisSum > maxSum ) {
                    maxSum   = thisSum;
                    seqStart = i;
                    seqEnd   = j;
                }
            }
        return maxSum;
    }

    // Version 2
    public static int maxSubSum2( int [ ] a ) {
        int maxSum = 0;                             // 1 op.
        for( int i = 0; i < a.length; i++ ) {       // n times do: (loop 1)
            int thisSum = 0;                        // 1 op.
            for( int j = i; j < a.length; j++ ) {   // n - i times do: (loop 2)
                thisSum += a[ j ];                  // 2 op.
                if( thisSum > maxSum ) {            // 1 op.
                    maxSum = thisSum;               // 1 op.
                    seqStart = i;                   // 1 op.
                    seqEnd   = j;                   // 1 op.
                }
            }                                       // (end loop 2)
        }                                           // (end loop 1)
        return maxSum;
    }

    // Version 3
    public static int maxSubSum3( int[] a ) {
        int maxSum  = 0;                                // 1 op.
        int thisSum = 0;                                // 1 op.
        for( int i = 0, j = 0; j < a.length; j++ ) {    // n times do: (loop 1)
            thisSum += a[ j ];                          // 2 op.
            if( thisSum > maxSum ) {                    // Either option 1 runs,  1 op.
                maxSum = thisSum;                       // 1 op.
                seqStart = i;                           // 1 op.
                seqEnd   = j;                           // 1 op.
            }
            else if( thisSum < 0 ) {                    // Or option 2 runs, 1 op.
                i = j + 1;                              // 2 op.
                thisSum = 0;                            // 1 op.
            }
        }                                               // (end loop 1)
        return maxSum;
    }
}