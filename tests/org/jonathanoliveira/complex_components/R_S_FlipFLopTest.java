package org.jonathanoliveira.complex_components;

import org.junit.Test;

import static org.junit.Assert.*;

public class R_S_FlipFLopTest {

    @Test (expected = IllegalArgumentException.class)
    public void checkInputError() throws Exception {
        R_S_FlipFLop rs = new R_S_FlipFLop();
        rs.inputs(true, true);
//        rs.reset(true);
        assertTrue(rs.Q() && !rs.Qbar());
    }

    @Test
    public void checkSet1() throws Exception {
        R_S_FlipFLop rs = new R_S_FlipFLop();
        rs.inputs(true, false);
//        rs.reset(false);
        assertTrue(rs.Q() && !rs.Qbar());
    }

    @Test
    public void checkReset1() throws Exception {
        R_S_FlipFLop rs = new R_S_FlipFLop();
        rs.inputs(false, true);
//        rs.reset(true);
        assertTrue(!rs.Q() && rs.Qbar());
    }

    @Test
    public void checkSetReset0() throws Exception {
        R_S_FlipFLop rs = new R_S_FlipFLop();
        rs.inputs(true,false);
        assertTrue(rs.Q() && !rs.Qbar());
        rs.inputs(false, false);
        assertTrue(rs.Q() && !rs.Qbar());
        rs.inputs(false, true);
        assertTrue(!rs.Q() && rs.Qbar());
        rs.inputs(false, false);
        assertTrue(!rs.Q() && rs.Qbar());
    }
}