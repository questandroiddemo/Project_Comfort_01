package com.example.project_comfort_01;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

public class ComfortModelTest {
    @Mock
    MainFragment mainFragment;
    @Mock
    ComfortContractor.View view;
    @Mock
    ComfortContractor.Presenter presenter;
    @Mock
    ComfortModel comfortModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAcvalue() throws Exception {
        when(mainFragment.acvalue(anyBoolean())).thenReturn(Boolean.TRUE);
        Boolean result = comfortModel.acvalue(true);
    }

    @Test
    public void testMaxAcValue() throws Exception {
        when(mainFragment.maxvalue(anyBoolean())).thenReturn(true);
        Boolean result = comfortModel.maxAcValue(true);
    }

    @Test
    public void testPowerValue() throws Exception {
        when(mainFragment.powervalue(anyBoolean())).thenReturn(Boolean.TRUE);
        Boolean result = comfortModel.powerValue(true);

    }

    @Test
    public void testTempValue() throws Exception {
        comfortModel.TempValue(0);
    }

    @Test
    public void testSpeedValue() throws Exception {
        comfortModel.SpeedValue(0);
    }

    @Test
    public void testAutoValue() throws Exception {
        when(mainFragment.AutoValue(anyBoolean())).thenReturn(true);
        Boolean result = comfortModel.AutoValue(true);
    }

    @Test
    public void testDefrostValue() throws Exception {
        when(mainFragment.Defrost(anyBoolean())).thenReturn(true);
        Boolean result = comfortModel.DefrostValue(true);
    }

    @Test
    public void testRearfrostValue() throws Exception {
        when(mainFragment.RearFrost(anyBoolean())).thenReturn(true);
        Boolean result = comfortModel.RearfrostValue(true);
    }

    @Test
    public void testGetMaxList() throws Exception {
        when(mainFragment.getMaxList()).thenReturn(Arrays.<String>asList("String"));
        List<String> result = comfortModel.getMaxList();
    }

    @Test
    public void testGetDefrostList() throws Exception {
        when(mainFragment.getDefrostList()).thenReturn(Arrays.<String>asList("String"));
        List<String> result = comfortModel.getDefrostList();
    }

    @Test
    public void testGetAutoList() throws Exception {
        when(mainFragment.getAutoList()).thenReturn(Arrays.<String>asList("String"));
        List<String> result = comfortModel.getAutoList();
    }
}

