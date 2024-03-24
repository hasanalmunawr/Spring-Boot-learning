package hasanalmunawrDev.belajarspringBootmonitoring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class cppTest {

    @Autowired
    private cpp cpp;

    public int[] monkeyCount(final int n){
        int[] arrayNum = new int[n];
        for (int i = 0; i < n; i++) {
            arrayNum[i] = i+1;
        }
        return arrayNum;
    }

    @Test
    public void basicTests() {
        assertArrayEquals(new int[]{1,2,3,4,5},monkeyCount(5));
        assertArrayEquals(new int[]{1,2,3},monkeyCount(3));
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9},monkeyCount(9));
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10},monkeyCount(10));
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},monkeyCount(20));
    }

}